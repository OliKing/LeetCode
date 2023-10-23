package com.oliking.codejava.tran;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Strategic {

    public static void main(String[] args){
        String s = "市值大于50亿小于300亿；主板非st；date日涨幅大于4%未触及涨停；date1日未触及涨停；date日成交额大于8亿";
        for (int i = 7; i > 1; i --){
            String strs = s.replace("date1", TimeUtils.nDatesBefore(i+1, "MM-dd"));
            strs = strs.replace("date", TimeUtils.nDatesBefore(i, "MM-dd"));
            System.out.println(strs);
        }

    }
}
