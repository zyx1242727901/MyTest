package com.example.demo.elasticsearch.service;

import com.example.demo.elasticsearch.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    List<Item> findByTitle(String title);
}
