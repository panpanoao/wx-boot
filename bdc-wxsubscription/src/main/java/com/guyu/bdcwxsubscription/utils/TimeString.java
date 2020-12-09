package com.guyu.bdcwxsubscription.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/5 0005 13:29
 * @描述 根据当前时间生成文件名
 **/
public class TimeString {
    private String valueOfString(String str, int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len - str.length(); i++) {
            sb.append("0");
        }
        return (sb.length() == 0) ? (str) : (sb.toString() + str);
    }

    public String getDateFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public Date getDateFormat(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getTimeString(Calendar calendar) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(calendar.get(Calendar.YEAR)))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), 2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)), 2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.SECOND)), 2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)), 3));
        return sb.toString();
    }

    public String getTimeString(String time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.getDateFormat(time));
        return this.getTimeString(calendar);
    }

    public String getTimeString() {
        Calendar calendar = new GregorianCalendar();
        return this.getTimeString(calendar);
    }
}
