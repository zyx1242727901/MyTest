package com.example.demo.mybatis.mapper1;

import com.example.demo.mybatis.entity.Order;
import com.example.demo.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into t_order(order_id,user_id) values(#{orderId},#{userId})")
    void insert(Order order);

    @Insert("insert into t_order_item(order_id,item_id) values(#{orderId},#{itemId})")
    void insertOrderItem(Long orderId,Long itemId);

    @Update("CREATE TABLE `t_order` (\n" +
            "  `order_id` int(11) NOT NULL,\n" +
            "  `user_id` int(11) DEFAULT NULL,\n" +
            "  `id` varchar(256) NOT NULL ,\n" +
            "  PRIMARY KEY (`id`) \n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin")
    void createTableOrder();

    @Update("CREATE TABLE `t_order_item` (\n" +
            " `order_id` int(11) NOT NULL,\n" +
            " `item_id` int(11) DEFAULT NULL,\n" +
            " `id` varchar(256) NOT NULL ,\n" +
            " PRIMARY KEY (`id`) \n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin")
    void createTableItem();

    @Select("select t1.* from t_order_item t1 " +
            " left join t_order t2 on t1.order_id = t2.order_id" +
            " where t1.order_id=#{orderId}")
    List<OrderItem> selectOrderItem(Long orderId);

    @Select("select t1.* from t_order_item t1 " +
            " where t1.item_id=#{itemId}")
    List<OrderItem> selectItemId(Long itemId);
}
