package com.example.demo.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item",type = "docs",shards = 1,replicas = 0)
public class Item {
    @Id
    private Long id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")//最细粒度分词器
    private String title;

    @Field(type = FieldType.Keyword)
    private String brand;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(index = false, type = FieldType.Keyword) //index:是否是索引
    private String images;
}
