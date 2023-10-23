package com.oliking.codejava.code;

import java.util.*;
import java.util.Map;

public class Q15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if (nums[left] + nums[right] > -nums[i]){
                    right--;
                }else if (nums[left] + nums[right] < -nums[i]){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
