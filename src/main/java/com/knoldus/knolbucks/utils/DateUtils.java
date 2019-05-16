package com.knoldus.knolbucks.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static String dateFormat = "dd/MM/yyyy";

    public static Date formatData(String date) {
        try {
            return new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
