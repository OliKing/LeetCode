package com.oliking.codejava.tran;

import java.util.*;

public class sortUtil {

    /**
     * 快速排序
     * 分界值，左边小于分界值，右边大于或等于分界值
     * @param list
     * @return
     */
    public static List<Integer> quickSort(List<Integer> list){
        if (null == list || list.size() <= 1) return list;
        quickSortHelper(list,  0, list.size()-1);
        return list;
    }

    public static void  quickSortHelper(List<Integer> list, Integer left, Integer right){
        if (left >= right){
            return;
        }
        int prePst = left;
        int p = list.get(right);
        int low = left;
        while(left < right){
            if (list.get(left) < p){
                int tmp = list.get(prePst);
                list.set(prePst, list.get(left));
                list.set(left, tmp);
                prePst++;
            }
            left ++;
        }
        int tmp = list.get(prePst);
        list.set(prePst, p);
        list.set(right, tmp);
        quickSortHelper(list, low, prePst -1);
        quickSortHelper(list, prePst + 1, right);
    }

//    public static void main(String[] args){
//        Integer[] num = new Integer[]{9,1,5,2,6,3};
//        List<Integer> list = Arrays.asList(num);
//        quickSort(list);
//        System.out.println(list.toString());
//    }

    /**
     * 选择排序
     * 每次循环，在未排序数据集中找到最小（或最大）的数，放到对应的位置
     * @param nums
     */
    public static void selectSort(int[] nums){
        int pos = 0;
        for (int i = 0; i < nums.length; i ++){
            int min = nums[i];
            for (int j = i; j < nums.length; j++){
                if (min > nums[j]){
                    min = nums[j];
                    pos = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = tmp;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{9,9,3,5,-1,9,7};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
