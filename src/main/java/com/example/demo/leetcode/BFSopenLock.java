package com.example.demo.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * zhangyuxiao
 * 2020/9/18 10:24
 *
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 */
public class BFSopenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedBlockingQueue();
        Set<String> collect = new HashSet<>();
        for (String deadend : deadends) {
            collect.add(deadend);
        }
//        Set<String> collect = Arrays.stream(deadends).collect(Collectors.toSet());
        int step = 0;

        if (target == "0000") {
            return 0;
        }

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if (collect.contains(poll)) {
                    continue;
                } else {
                    collect.add(poll);
                }

                for (int j = 0; j < poll.length(); j++) {
                    String addStr = addOne(poll, j);
                    String subStr = subOne(poll, j);

                    if (addStr.equals(target) || (subStr.equals(target))) {
                        return ++step;
                    } else {
                        queue.offer(addStr);
                        queue.offer(subStr);
                    }
                }
            }
            step++;
        }
        return -1;


//
//        Set<String> dead = new HashSet();
//        for (String d: deadends) dead.add(d);
//
//        Queue<String> queue = new LinkedList();
//        queue.offer("0000");
//        queue.offer(null);
//
//        Set<String> seen = new HashSet();
//        seen.add("0000");
//
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            String node = queue.poll();
//            if (node == null) {
//                depth++;
//                if (queue.peek() != null)
//                    queue.offer(null);
//            } else if (node.equals(target)) {
//                return depth;
//            } else if (!dead.contains(node)) {
//                for (int i = 0; i < 4; ++i) {
//                    for (int d = -1; d <= 1; d += 2) {
//                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
//                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
//                        if (!seen.contains(nei)) {
//                            seen.add(nei);
//                            queue.offer(nei);
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }
    }

    /**
     * 上拨一下
     * @param s
     * @param index
     * @return
     */
    public String addOne(String s,int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] = Character.forDigit(chars[index]-'0'+1,10);
        }
        return new String(chars);
    }

    /**
     * 下拨一下
     * @param s
     * @param index
     * @return
     */
    public String subOne(String s,int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] = Character.forDigit(chars[index]-'0'-1,10);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new BFSopenLock().openLock(new String[]{"1301","0113","0202","0122","3012","0131","0200","0203","1232","0222"}, "2311"));
//["1301","0113","0202","0122","3012","0131","0200","0203","1232","0222"]
//        ""
    }

}
