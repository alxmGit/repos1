package com.itcast.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date stringtoDate(String date ,String panten ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(panten);
        Date parse = sdf.parse(date);
        return parse;
    }

    public  static String DatetoString(Date date ,String panten ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(panten);
        String format = sdf.format(date);
        return format;
    }
}
