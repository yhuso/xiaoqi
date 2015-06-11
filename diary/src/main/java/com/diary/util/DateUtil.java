package com.diary.util;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

public class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
	private static String defaultDatePattern = null;
	private static String timePattern = "HH:mm";
	public static final String TS_FORMAT = DateUtil.getDatePattern()
			+ " HH:mm:ss.S";
	/** 日期格式yyyy-MM-dd字符串常量 */
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	/** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 某天结束时分秒字符串常量 23:59:59 */
	private static final String HOURMIN_FORMAT = "HH:mm";
	public static final String DAY_END_STRING_HHMMSS = " 23:59:59";
	public static final String YEARMONTHDAY = "yyyy/MM/dd";
	public static final String MONTHDAY = "MM月dd日";
	public static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);
	public static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);
	public static SimpleDateFormat sdf_hourmin_format = new SimpleDateFormat(HOURMIN_FORMAT);

	public static SimpleDateFormat zhYMD_format = new SimpleDateFormat("yyyy年MM月dd日");
	/**
	 * 比较两个日期相差的天数 date1-date2相差的天数
	 * 
	 * @date Mar 11, 2012
	 * @param date1
	 *            格式yyyy-MM-dd
	 * @param date2
	 *            格式yyyy-MM-dd
	 * @return
	 */
	public static int getMargin(String date1, String date2) {
		int margin;
		try {
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos1 = new ParsePosition(0);
			Date dt1 = sdf_date_format.parse(date1, pos);
			Date dt2 = sdf_date_format.parse(date2, pos1);
			long l = dt1.getTime() - dt2.getTime();
			margin = (int) (l / (24 * 60 * 60 * 1000));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtilV2.getMargin():" + e.toString());
			return 0;
		}
	}

	public static int getMargin(Date date1, Date date2) {
		int margin;
		long l = date1.getTime() - date2.getTime();
		margin = (int) (l / (24 * 60 * 60 * 1000));
		return margin;
	}

	/**
	 * 功能描述:计算两个日期之间相差的天数，只比较年月日，与
	 * getDoubleMargin/getMonthMargin进行区分，他们两个如果日期相差不满24小时，显示的为0
	 * 
	 * <pre>
	 * Modify Reason:(修改原因,不需覆盖，直接追加.)
	 *     bianjie:   2015年4月27日      新建
	 * </pre>
	 *
	 * @param smdate
	 *            较小的日期
	 * @param bdate
	 *            较大的日期
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		smdate = sdf_date_format.parse(sdf_date_format.format(smdate));
		bdate = sdf_date_format.parse(sdf_date_format.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 比较两个日期相差的天数
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double getDoubleMargin(String date1, String date2) {
		double margin;
		try {
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos1 = new ParsePosition(0);
			Date dt1 = sdf_datetime_format.parse(date1, pos);
			Date dt2 = sdf_datetime_format.parse(date2, pos1);
			long l = dt1.getTime() - dt2.getTime();
			margin = (l / (24 * 60 * 60 * 1000.00));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtilV2.getMargin():" + e.toString());
			return 0;
		}
	}

	/**
	 * 比较两个日期相差的月数
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonthMargin(String date1, String date2) {
		int margin;
		try {
			margin = (Integer.parseInt(date2.substring(0, 4)) - Integer
					.parseInt(date1.substring(0, 4))) * 12;
			margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0",
					"-")) - Integer.parseInt(date1.substring(4, 7).replaceAll(
					"-0", "-")));
			return margin;
		} catch (Exception e) {
			logger.debug("DateUtilV2.getMargin():" + e.toString());
			return 0;
		}
	}

	/**
	 * 返回日期加X年后的日期
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param date
	 * @param i
	 * @return
	 */
	public static String addYear(String date, int i) {
		try {
			GregorianCalendar gCal = new GregorianCalendar(
					Integer.parseInt(date.substring(0, 4)),
					Integer.parseInt(date.substring(5, 7)) - 1,
					Integer.parseInt(date.substring(8, 10)));
			gCal.add(GregorianCalendar.YEAR, i);
			return sdf_date_format.format(gCal.getTime());
		} catch (Exception e) {
			logger.debug("DateUtilV2.addYear():" + e.toString());
			return "";
		}
	}

	/**
	 * 返回某年某月中的最大天
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMaxDay(int iyear, int imonth) {
		int day = 0;
		try {
			if (imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7
					|| imonth == 8 || imonth == 10 || imonth == 12) {
				day = 31;
			} else if (imonth == 4 || imonth == 6 || imonth == 9
					|| imonth == 11) {
				day = 30;
			} else if ((0 == (iyear % 4)) && (0 != (iyear % 100))
					|| (0 == (iyear % 400))) {
				day = 29;
			} else {
				day = 28;
			}
			return day;
		} catch (Exception e) {
			logger.debug("DateUtilV2.getMonthDay():" + e.toString());
			return 1;
		}
	}

	/**
	 * 格式化日期
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param orgDate
	 * @param Type
	 * @param Span
	 * @return
	 */
	public String rollDate(String orgDate, int Type, int Span) {
		try {
			String temp = "";
			int iyear, imonth, iday;
			int iPos = 0;
			char seperater = '-';
			if (orgDate == null || orgDate.length() < 6) {
				return "";
			}

			iPos = orgDate.indexOf(seperater);
			if (iPos > 0) {
				iyear = Integer.parseInt(orgDate.substring(0, iPos));
				temp = orgDate.substring(iPos + 1);
			} else {
				iyear = Integer.parseInt(orgDate.substring(0, 4));
				temp = orgDate.substring(4);
			}

			iPos = temp.indexOf(seperater);
			if (iPos > 0) {
				imonth = Integer.parseInt(temp.substring(0, iPos));
				temp = temp.substring(iPos + 1);
			} else {
				imonth = Integer.parseInt(temp.substring(0, 2));
				temp = temp.substring(2);
			}

			imonth--;
			if (imonth < 0 || imonth > 11) {
				imonth = 0;
			}

			iday = Integer.parseInt(temp);
			if (iday < 1 || iday > 31)
				iday = 1;

			Calendar orgcale = Calendar.getInstance();
			orgcale.set(iyear, imonth, iday);
			temp = rollDate(orgcale, Type, Span);
			return temp;
		} catch (Exception e) {
			return "";
		}
	}

	public static String rollDate(Calendar cal, int Type, int Span) {
		try {
			String temp = "";
			Calendar rolcale;
			rolcale = cal;
			rolcale.add(Type, Span);
			temp = sdf_date_format.format(rolcale.getTime());
			return temp;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回默认的日期格式
	 * 
	 *
	 * @date Mar 11, 2012
	 * @return
	 */
	public static synchronized String getDatePattern() {
		defaultDatePattern = "yyyy-MM-dd";
		return defaultDatePattern;
	}

	/**
	 * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param aDate
	 * @return
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * 取得给定日期的时间字符串，格式为当前默认时间格式
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param theTime
	 * @return
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * 取得当前时间的Calendar日历对象
	 * 
	 *
	 * @date Mar 11, 2012
	 * @return
	 * @throws ParseException
	 */
	public Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));
		return cal;
	}

	/**
	 * 将日期类转换成指定格式的字符串形式
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param aMask
	 * @param aDate
	 * @return
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			logger.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * 用指定的模式格式日期
	 * 如果data=null,则返回""
	 *
	 * @date Mar 11, 2012
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date date,SimpleDateFormat pattern) {
		if(date==null){
			return "";
		}
		return pattern.format(date);
	}

	/**
	 * 将日期字符串按指定格式转换成日期类型
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param aMask
	 *            指定的日期格式，如:yyyy-MM-dd
	 * @param strDate
	 *            待转换的日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (logger.isDebugEnabled()) {
			logger.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			logger.error("ParseException: " + pe);
			throw pe;
		}
		return (date);
	}

	/**
	 * 将日期字符串按默认格式转换成日期类型
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			if (logger.isDebugEnabled()) {
				logger.debug("converting date with pattern: "
						+ getDatePattern());
			}
			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			logger.error("Could not convert '" + strDate
					+ "' to a date, throwing exception");
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
		return aDate;
	}

	/**
	 * 返回一个JAVA简单类型的日期字符串
	 * 
	 *
	 * @date Mar 11, 2012
	 * @return
	 */
	public static String getSimpleDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat();
		String NDateTime = formatter.format(new Date());
		return NDateTime;
	}

	/**
	 * 返回指定年份中指定月份的天数
	 * 
	 * @param 年份year
	 * @param 月份month
	 * @return 指定月的总天数
	 */
	public static String getMonthLastDay(int year, int month) {
		int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
				{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return day[1][month] + "";
		} else {
			return day[0][month] + "";
		}
	}

	/**
	 * 判断是平年还是闰年
	 * 
	 *
	 * @date Mar 11, 2012
	 * @param year
	 * @return
	 */
	public static boolean isLeapyear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 功能描述:将日期变为字符串 特殊字符串:今天，昨天
	 *
	 * <pre>
	 * Modify Reason:(修改原因,不需覆盖，直接追加.)
	 *     bianjie:   2015年4月26日      新建
	 * </pre>
	 *
	 * @param target
	 * @return
	 */
	public static String formatDateToFriendString(Date target) {
		int day = 0;
		try {
			day = daysBetween(target, new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (day == 0)
			return "今天";
		if (day == 1)
			return "昨天";
		return getDateTime("MM月dd日", target);
	}
	
	public static String formatDateToFriendString(Date target,String reg){
		int day = 0;
		try {
			day = daysBetween(target, new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (day == 0)
			return "今天";
		if (day == 1)
			return "昨天";
		return getDateTime(reg, target);
	}
	
	/** 
     * 获取当前月的最后一天 
     * @param date 
     * @return 
     * @throws ParseException 
     */  
    public static Date getMaxMonthDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        return calendar.getTime();
    }  

    public static void main(String[] args) {
    	Date smdate;
    	Date tdate;
		try {
			smdate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-01");
			tdate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-02");
			System.out.println(daysBetween(null, tdate));
		} catch (Exception e) {
			logger.info("日期解析错误,");
		}
    	System.out.println("5");
    
	}
	
}