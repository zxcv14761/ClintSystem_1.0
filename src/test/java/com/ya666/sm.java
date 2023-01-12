package com.ya666;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sm {

    public static void main(String[] args) throws ParseException {

        String s = "2000-8-8 00:00:00";
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date birth = sdf.parse(s);

        int duration =(int)((today.getTime()-birth.getTime())/(24*60*60*1000))/365;
        System.out.println(duration);


    }
}
