package com.example.demo.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class SolutionThreeSumDiGui {
    private Comparator comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return (Integer) o1 - (Integer) o2;
        }
    };
    private Set<String> keySet = new HashSet<String>();

    public List<List<Integer>> threeSum(int[] nums) {
        List resultList = new ArrayList();
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                List<Integer> integerList = findT(nums, x, y, y + 1);
                if(integerList != null && integerList.size() > 0){
                    resultList.add(integerList);
                }
            }
        }
        return resultList;
    }

    private List<Integer> findT(int[] nums, int curXIndex, int curYIndex, int zIndex){
        if (curXIndex > nums.length - 1 || curYIndex > nums.length - 1 || zIndex > nums.length - 1) {
            return null;
        }

        if(nums[curXIndex] + nums[curYIndex] + nums[zIndex] == 0){
            List<Integer> list = new ArrayList<>();
            list.add(nums[curXIndex]);
            list.add(nums[curYIndex]);
            list.add(nums[zIndex]);
            if(checkContains(list)){
                return list;
            }
        }

        return findT(nums, curXIndex, curYIndex, zIndex + 1);
    }

    private Boolean checkContains(List<Integer> list){
        list.sort(comparator);
        StringBuffer key = new StringBuffer();
        for (Integer integer : list) {
            key.append(integer + "_");
        }
        String keyStr = key.toString();
        if(keySet.contains(keyStr)){
            return false;
        }
        keySet.add(keyStr);
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-28801,324,1202,-90885,-2989,-95597,-34333,35528,5680,89093,-90606,50360,-29393,-27012,53313,65213,99818,-82405,-41661,-3333,-51952,72135,-1523,26377,74685,96992,92263,15929,5467,-99555,-43348,-41689,-60383,-3990,32165,65265,-72973,-58372,12741,-48568,-46596,72419,-1859,34153,62937,81310,-61823,-96770,-54944,8845,-91184,24208,-29078,31495,65258,14198,85395,70506,-40908,56740,-12228,-40072,32429,93001,68445,-73927,25731,-91859,-24150,10093,-60271,-81683,-18126,51055,48189,-6468,25057,81194,-58628,74042,66158,-14452,-49851,-43667,11092,39189,-17025,-79173,13606,83172,92647,-59741,19343,-26644,-57607,82908,-20655,1637,80060,98994,39331,-31274,-61523,91225,-72953,13211,-75116,-98421,-41571,-69074,99587,39345,42151,-2460,98236,15690,-52507,-95803,-48935,-46492,-45606,-79254,-99851,52533,73486,39948,-7240,71815,-585,-96252,90990,-93815,93340,-71848,58733,-14859,-83082,-75794,-82082,-24871,-1};
        SolutionThreeSumDiGui solution = new SolutionThreeSumDiGui();
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println("\n");
        }
    }
}
