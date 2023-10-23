package com.oliking.codejava.code;

import java.util.ArrayList;
import java.util.List;

public class Q6Convert {
    public String convert(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) return s;
         StringBuilder res = new StringBuilder();
         for (int i = 0; i < numRows; i ++){
             int p = 1;
             for (int j = i; j < s.length(); ){
                 res.append(s.charAt(j));
                 if (i == 0 || i == numRows - 1){
                     j = j + 2*(numRows - 1);
                 }else{
                     if (p == 1){
                         j = j + 2*(numRows - i - 1);
                     }else{
                         j = j + 2*i;
                     }
                    p = -p;
                 }
             }
         }
        return res.toString();
    }

    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        System.out.println(new Q6Convert().convertBetter(s, 3));
    }

    public String convertBetter(String s, int numRows) {
        if(s.length() < 2 || numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        int flag = -1;
        int c = 0;
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++){
            list.get(c).append(s.charAt(i));
            if (c == 0 || c == numRows -1){
                flag = - flag;
            }
            c += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder stringBuilder1 : list){
            stringBuilder.append(stringBuilder1);
        }
        return stringBuilder.toString();
    }
}
