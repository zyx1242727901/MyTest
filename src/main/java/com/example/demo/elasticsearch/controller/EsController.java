package com.example.demo.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.elasticsearch.model.Item;
import com.example.demo.elasticsearch.service.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class EsController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository itemRepository;

    /**
     * 创建索引
     */
    @RequestMapping("/createIndex")
    public void createIndex(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Item.class);
    }

    @RequestMapping("/deleteIndex")
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex("item");
    }

    /**
     * 新增
     */
    @RequestMapping("/insert")
    public void insert() {
        Item item = new Item(1L, "小米手机7", "小米", 2999.00, "https://img12.360buyimg.com/n1/s450x450_jfs/t1/14081/40/4987/124705/5c371b20E53786645/c1f49cd69e6c7e6a.jpg");
        itemRepository.save(item);
    }

    /**
     * 批量新增
     */
    @RequestMapping("/insertList")
    public void insertList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", "锤子", 3999.00, "https://img12.360buyimg.com/n1/s450x450_jfs/t1/14081/40/4987/124705/5c371b20E53786645/c1f49cd69e6c7e6a.jpg"));
        list.add(new Item(3L, "华为META20",  "华为", 4999.00, "https://img12.360buyimg.com/n1/s450x450_jfs/t1/14081/40/4987/124705/5c371b20E53786645/c1f49cd69e6c7e6a.jpg"));
        list.add(new Item(4L, "iPhone X", "iPhone", 5100.00, "https://img12.360buyimg.com/n1/s450x450_jfs/t1/14081/40/4987/124705/5c371b20E53786645/c1f49cd69e6c7e6a.jpg"));
        list.add(new Item(5L, "iPhone XS", "iPhone", 5999.00, "https://img12.360buyimg.com/n1/s450x450_jfs/t1/14081/40/4987/124705/5c371b20E53786645/c1f49cd69e6c7e6a.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    /**
     * 基本查询
     * @return
     */
    @RequestMapping("/query")
    public String query() {
        // 查询全部，并按照价格降序排序
        Iterable<Item> items = itemRepository.findAll(Sort.by("price").descending());
        items.forEach(item -> System.out.println("item = " + item));
        return JSON.toJSONString(items);
    }

    /**
     * 自定义方法
     */
    @RequestMapping("/queryByTitle")
    public String queryByTitle(String title) {
        List<Item> list = itemRepository.findByTitle(title);
        list.forEach(item -> System.out.println("item = " + item));
        return JSON.toJSONString(list);
    }

    /**
     * 自定义查询
     */
    @RequestMapping("/search")
    public String search(String title) {
//        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        MatchQueryBuilder builder = QueryBuilders.matchQuery("title", title);
        queryBuilder.withQuery(builder);
        queryBuilder.withHighlightFields(new HighlightBuilder.Field("*").preTags("<tag>").postTags("<post>"));
        // 搜索，获取结果
        Page<Item> items = itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        items.forEach(item -> System.out.println("item = " + item));
        return JSON.toJSONString(items);
    }

    /**
     * 分页查询
     */
    @RequestMapping("/searchByPage")
    public void searchByPage() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("brand", "华为"));
        // 分页：
        int page = 0;
        int size = 2;
        queryBuilder.withPageable(PageRequest.of(page, size));
        // 搜索，获取结果
        Page<Item> items = itemRepository.search(queryBuilder.build());
        long total = items.getTotalElements();
        System.out.println("总条数 = " + total);
        System.out.println("总页数 = " + items.getTotalPages());
        System.out.println("当前页：" + items.getNumber());
        System.out.println("每页大小：" + items.getSize());
        items.forEach(item -> System.out.println("item = " + item));
    }
}
