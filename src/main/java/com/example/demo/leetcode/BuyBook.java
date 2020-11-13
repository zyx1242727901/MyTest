package com.example.demo.leetcode;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * zhangyuxiao
 * 2020/9/27 11:21
 *
 * 用40元钱购买单价分别为2元、5元和11元的三种练习本，每种至少买一本，而且钱恰好花完．则不同的购买方法
 */
public class BuyBook {
    int[] bookArray = new int[]{2, 5, 11};
    int sum = 0;
    Set<SortList> useSet = new HashSet();

    public Set<SortList> getUseSet() {
        return useSet;
    }

    public int buyBook(int amount){
        amount = amount - 5 - 11 - 2;
        buy(amount,new SortList());
        return sum;
    }

    public void buy(int amount, SortList sortList){
        for (int i = 0; i < bookArray.length; i++) {
            int restAmount = amount - bookArray[i];
            if (restAmount < 0) {
                continue;
            } else {
                SortList tempList = new SortList(sortList).add(bookArray[i]);
                if (restAmount == 0) {
                    if (useSet.contains(tempList)) {
                        continue;
                    }
                    useSet.add(tempList);
                    sum++;
                } else {
                    buy(restAmount, tempList);
                }
            }
        }
    }


    static class SortList {
        List<Integer> list = new ArrayList<>();

        public SortList(SortList sortList) {
            if (!CollectionUtils.isEmpty(sortList.list)) {
                sortList.list.stream().forEach(item->{
                    this.list.add(item);
                });
            }
        }
        public SortList() {
        }

        public  SortList add(Integer num) {
            list.add(num);
            return this;
        }

        @Override
        public boolean equals(Object o) {
            return this.toString().equals(o.toString());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.toString());
        }

        @Override
        public String toString() {
            Collections.sort(list);
            return JSON.toJSONString(list);
        }

    }

    public static void main(String[] args) {
        BuyBook buyBook = new BuyBook();
        System.out.println(buyBook.buyBook(40));


    }

}
