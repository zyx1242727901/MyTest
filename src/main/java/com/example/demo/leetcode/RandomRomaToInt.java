package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 */
public class RandomRomaToInt {
    private static Map<String, Integer> valueMap = new HashMap<>();

    static{
        valueMap.put("I",1);
        valueMap.put("V",5);
        valueMap.put("X",10);
        valueMap.put("L",50);
        valueMap.put("C",100);
        valueMap.put("D",500);
        valueMap.put("M",1000);
    }

    public int romanToInt(String s) {
        String[] chars = s.split("");
        int i=0;
        int length = chars.length;
        int sum = 0;

        Integer aValue = 0;
        Integer bValue = 0;

        while (i<length) {
            aValue =  valueMap.get(chars[i]);

            if(i == length - 1 ){
                sum += aValue;
                break;
            }else if (isSum(aValue, bValue = valueMap.get(chars[i+1]))) {
                sum += aValue;
                i++;
            } else {
                sum += bValue - aValue;
                i += 2;
            }
        }

        return sum;
    }
    public boolean isSum(Integer s1,Integer s2){
        if(s1.compareTo(s2)<0){
            if ((s1.equals(1) && (s2.equals(5) || s2.equals(10)) || (s1.equals(10) && (s2.equals(50) || s2.equals(100))) || (s1.equals(100) && (s2.equals(500) || s2.equals(1000))))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RandomRomaToInt().romanToInt("MCMXCIV"));
    }
}
