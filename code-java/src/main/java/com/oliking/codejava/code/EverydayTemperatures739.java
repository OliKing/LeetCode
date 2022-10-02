package com.oliking.codejava.code;

import java.util.Arrays;

public class EverydayTemperatures739 {



    /***
     * 每日温度
     * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     */

    /**
     * 一天的温度与第二天相关
     * 从后往前遍历，如果第二天温度降低，则进行回溯，直到第n天温度高于今天
     * dp[i]为i到n天中的温度升高的最短天数。dp[i] = dp[i-1] + 1
     */

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 0) return null;
        if (n == 1) return new int[]{0};
        int[] res = new int[n];
        for (int i = n -1; i >= 0; i --){
            if (i == n-1){
                res[i] = 0;
            }else{
                int j = i + 1;
                if (temperatures[i] < temperatures[j]){
                    res[i] = 1;
                }else{
                    int flag = 1;
                    while(j < n-1 && temperatures[i] >= temperatures[j]){
                        if (temperatures[i] >= temperatures[j] && res[j] == 0){
                            //温度高于后缀
                            res[i] = 0;
                            flag =0;
                            break;
                        }
                        j = res[j] + j;
                    }
                    if (j < n-1 && temperatures[i] <= temperatures[j] && flag == 1){
                        res[i] = j-i;
                    }

                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] day = new int[]{77,77,77,77,77,41,77,41,41,77};
        int[] res = dailyTemperatures(day);
        System.out.println();
    }
}
