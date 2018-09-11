package com.itcast.domain;

import org.springframework.core.convert.converter.Converter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsStringToDate implements Converter<String,Date> {


    @Override
    public Date convert(String source) {

        if (source==null){

            throw new RuntimeException("请输入数字");
        }
  else {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return df.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
                throw  new RuntimeException("数据类型转换错误");
            }
        }


    }
}
