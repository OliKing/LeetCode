package com.oliking.codejava.util;

import java.util.Arrays;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            int count = 0;
            for(int j = 0; j < points.length; j++){
                double l = Math.sqrt(Math.pow((queries[i][0] - points[j][0]), 2) + Math.pow((queries[i][1] - points[j][1]), 2));
                if(queries[i][2] >= l){
                    count ++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args){
        int[][] queries = new int[][]{{2,3,1},{4,3,1},{1,1,2}};
        int[][] points = new int[][]{{1,3}, {3,3},{5,3}, {2,2}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }
}
