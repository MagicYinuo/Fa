package com.example.familyfd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.Time;

public class TimeUtils {

	public static final String getTime(long data)
	{
		 long time=System.currentTimeMillis()-data;
		 if(time<60*1000)
		 {
			 return time/1000+"秒前";
		 }else if(time<60*1000*60)
			 return time/60/1000+"分钟前";
		 else if(time<60*1000*60*24)
			 return time/60/1000/60+"小时前";
		 else 
			 return time/60/1000/60/24+"天前";
	}
	
	
	public static final String getTime(long date,String pattern)
	{
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		return format.format(new Date(date));
	}
	
	public static final String ShowTime() {      
	   
	              
	        Time time = new Time("GMT+8");       
	        int year = time.year;      
	        int month = time.month;      
	        int day = time.monthDay;      
	        int minute = time.minute;      
	        int hour = time.hour;      
	        int sec = time.second; 
	        
	        return ("当前时间为：" + year +       
	                            "年 " + month +       
	                            "月 " + day +       
	                            "日 " + hour +       
	                            "时 " + minute +       
	                            "分 " + sec +       
	                            "秒");      
	    }      
}
