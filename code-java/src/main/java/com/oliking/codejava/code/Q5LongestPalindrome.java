package com.oliking.codejava.code;

public class Q5LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++){
            int left = i-1;
            int right = i +1;
            String s1 = helper(left, right, s, n);
            String s2 = helper(left+1, right, s, n);
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;

        }
        return res;
    }

    public String helper(int left, int right, String s, int n){
        while (right < n && left > -1 &&  s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return  s.substring(left+1, right);
    }

    public static void main(String[] args){
        String s = "bb";
        System.out.println(new Q5LongestPalindrome().longestPalindrome(s));
    }
}
