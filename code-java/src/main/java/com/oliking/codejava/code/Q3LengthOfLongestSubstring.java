package com.oliking.codejava.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        Map<Character, int[]> map = new HashMap<>();
        int res = 1;
        map.put(s.charAt(0), new int[]{0, 1});
        for(int i=1; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                res = Math.max(res, map.get(s.charAt(i-1))[1]);
                for (int j = map.get(s.charAt(i))[0]+1; j < i; j++){
                    map.put(s.charAt(j), new int[]{j, map.get(s.charAt(j))[1] -map.get(s.charAt(i))[1]-1});
                }
                map.put(s.charAt(i), new int[]{i, 0});
            }else{
                res = Math.max(res, map.get(s.charAt(i-1))[1] + 1);
            }
            map.put(s.charAt(i), new int[]{i, map.get(s.charAt(i-1))[1] + 1});
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new Q3LengthOfLongestSubstring().lengthOfLongestSubstring("bb"));
    }
}
