package com.example.demo.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
//    private Long idTemp;
    private Long userId;
    private Long orderId;

}
