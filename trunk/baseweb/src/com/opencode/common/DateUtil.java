package com.opencode.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�����ڴ�����
 * <p>Title: ����Ժ��Ŀ����ϵͳ</p>
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
     * ��ʽ������
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
    
    //�õ�ʱ ��
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
    * ���غ���
    * 
    * @param date
    * ����
    * @return ���غ���
    */
    public static long getMillis(java.util.Date date) {
    java.util.Calendar c = java.util.Calendar.getInstance();
    c.setTime(date);
    return c.getTimeInMillis();
    }


    /**
    * �������
    * 
    * @param date
    * ����
    * @param date1
    * ����
    * @return ������������������
    */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
    return ((int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000))) + 1;
    }
    
    /**
     * �������(���)
     * 
     * @param date
     * ����
     * @param date1
     * ����
     * @return ����������ʵ����������
     */
     public static int diffDate2(java.util.Date date, java.util.Date date1) {
     return ((int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000)));
     }
    /**
     * �������
     * 
     * @param date
     * ����
     * @param date1
     * ����
     * @return ��������������
     */
     public static java.util.Date diffDate(java.util.Date date, int day) {
    	 java.util.Calendar c = java.util.Calendar.getInstance();
    	    c.setTimeInMillis(getMillis(date) -((long) day) * 24 * 3600 * 1000);
    	    return c.getTime();
     }
    /**
    * �������
    * 
    * @param date
    * ����
    * @param day
    * ����
    * @return ������Ӻ������
    */
    public static java.util.Date addDate(java.util.Date date, int day) {
    java.util.Calendar c = java.util.Calendar.getInstance();
    c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
    return c.getTime();
    }
    
    /**
     * ��ȡ��ݺ���λ
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
     * �����������ڵĲ�ֵ
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
     * �����������ڵĲ�ֵ
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
     * �����������ڵĲ�ֵ
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
     * ��ȡ��������ʱ��
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
