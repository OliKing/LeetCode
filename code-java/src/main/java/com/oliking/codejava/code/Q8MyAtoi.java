package com.oliking.codejava.code;

public class Q8MyAtoi {
    public int myAtoi(String s) {
        String str = s.trim();
        int flag = 1;
        boolean start = false;
        int res = 0;
        for(char c : str.toCharArray()){
            if (start && (c < '0' || c > '9')){
                break;
            }
            if (c == '-'){
                flag = -1;
            }else if (c >= '0' && c <= '9'){
                if (res * flag < Integer.MIN_VALUE/10){
                    return Integer.MIN_VALUE;
                }else if (res * flag > Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }
                res = res*10 + c - '0';
            }else if (c != '+'){
                return 0;
            }
            start = true;
        }
        return res * flag;
    }

    public static void main(String[] args){
        System.out.println(new Q8MyAtoi().myAtoi("   -42"));
        System.out.println('4' - '0');
    }
}
