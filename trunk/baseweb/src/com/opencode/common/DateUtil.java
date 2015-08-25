package com.opencode.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期处理类
 * <p>Title: 铁三院项目管理系统</p>
 *
 * <p>Description: TSProjectManage</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: BeiJing YuanHeng</p>
 *
 * <p>date: 2007-3-12</p>
 *
 * @author zhengcun
 * @email zhengcun@yuanheng.net.cn
 * @version 1.0
 */
public class DateUtil
{
    /**
     * 格式化日期
     * @param cal
     * @return
     */
    public static String getDate(Calendar cal)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cal.getTime());        
    }
    
    public static java.util.Date getDate(String date)
    {
    	/*
        String dates[] =  date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
        return new java.util.Date(calendar.getTimeInMillis());    */
    	try {
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    		return format.parse(date);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return new Date();
    	}
    }
    
    public static String  getDate(java.util.Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date.getTime());           
    }
    
    //得到时 分
    public static String  getDate(java.util.Date date,boolean flag)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date.getTime());           
    }
    
    public static String  getDate(java.util.Date date, String formatStr)
    {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date.getTime());           
    }
    /**
    * 返回毫秒
    * 
    * @param date
    * 日期
    * @return 返回毫秒
    */
    public static long getMillis(java.util.Date date) {
    java.util.Calendar c = java.util.Calendar.getInstance();
    c.setTime(date);
    return c.getTimeInMillis();
    }


    /**
    * 日期相减
    * 
    * @param date
    * 日期
    * @param date1
    * 日期
    * @return 返回相减后的日期天数
    */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
    return ((int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000))) + 1;
    }
    
    /**
     * 日期相减(勿改)
     * 
     * @param date
     * 日期
     * @param date1
     * 日期
     * @return 返回相减后的实际日期天数
     */
     public static int diffDate2(java.util.Date date, java.util.Date date1) {
     return ((int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000)));
     }
    /**
     * 日期相减
     * 
     * @param date
     * 日期
     * @param date1
     * 日期
     * @return 返回相减后的日期
     */
     public static java.util.Date diffDate(java.util.Date date, int day) {
    	 java.util.Calendar c = java.util.Calendar.getInstance();
    	    c.setTimeInMillis(getMillis(date) -((long) day) * 24 * 3600 * 1000);
    	    return c.getTime();
     }
    /**
    * 日期相加
    * 
    * @param date
    * 日期
    * @param day
    * 天数
    * @return 返回相加后的日期
    */
    public static java.util.Date addDate(java.util.Date date, int day) {
    java.util.Calendar c = java.util.Calendar.getInstance();
    c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
    return c.getTime();
    }
    
    /**
     * 获取年份后两位
     * @param date
     * @return
     */
    public static String getYearLast2(String date)
    {
        if(date == null || date.equals(""))
        {
            date = new java.sql.Date(System.currentTimeMillis()).toString();
        }
        String[] str = date.split("-");
        return str[0].substring(2);
    }
    /**
     * 计算两个日期的差值
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getCompareDate(String startDate,String endDate)
    {
        try
        {
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            Date date1=formatter.parse(startDate);    
            Date date2=formatter.parse(endDate);
            long l = date2.getTime() - date1.getTime();
            long d = l/(24*60*60*1000);
            return d;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * 计算两个日期的差值
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getCompareDateTime(String startDate,String endDate)
    {
        try
        {
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1=formatter.parse(startDate);    
            Date date2=formatter.parse(endDate);
            long l = date2.getTime() - date1.getTime();
            //long d = l/(24*60*60*1000);
            return l;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * 计算两个日期的差值
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getCompareDate(Date startDate,Date endDate)
    {        
        long l = startDate.getTime() - endDate.getTime();
        long d = l/(24*60*60*1000);
        return d;
    }
    /**
     * 获取本天最早时刻
     * @param date
     * @return
     */
    public static String getStartDate(Date date)
    {
        Calendar cal = Calendar.getInstance();
        String strDate = getDate(date);
        String[] strs = strDate.split("-");
        cal.set(Integer.valueOf(strs[0]).intValue(), Integer.valueOf(strs[1]).intValue()-1, Integer.valueOf(strs[2]).intValue(),0,0,0);
        return strDate + " 00:00:00";
    }

}
