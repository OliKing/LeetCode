package com.oliking.codejava.code;

public class Q7Reverse {
    public int reverse(int x) {
        int res = 0;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        try {
            while (x != 0){
                res = res*10 + x%10;
                x /= 10;
            }
            res = flag * res;
        }catch (Exception e){
            return 0;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new Q7Reverse().reverseBetter(1534236469));

        System.out.println(-44%10);
    }

    public int reverseBetter(int x){
        int res = 0;
        while(x != 0){
            if (res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10) return  0;
            res = res*10 + x%10;
            x /= 10;
        }
        return res;
    }
}
