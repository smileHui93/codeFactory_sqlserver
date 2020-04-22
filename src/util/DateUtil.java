package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy/MM/dd");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * 获取YYYY格式
     * 
     * @return
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     * 
     * @return
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     * 
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     * 
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * @Title: compareDate
     * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
     * @param s
     * @param e
     * @return boolean
     * @throws @author luguosui
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期
     * 
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     * 
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long aa = 0;
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     * 
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     * 
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后是周几
     * 
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }
    
    /**
     * 获取某年某月最后一天
     * @param year
     * @param month
     * @return 2016-02-29
     */
    public static String getLastDayOfMonth(int year,int month){
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
      }
    
    /**
     * 获取某年某月第一天
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(Calendar.YEAR, year);     
        cal.set(Calendar.MONTH, month-1);  
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));  
       return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());  
    }
    
    public static Integer getMonthMaxDay() {
        Calendar cal = Calendar.getInstance();
        int max = cal.getMaximum(Calendar.DAY_OF_MONTH);
        return max;
    }
    
    /**
     * 今天与当前月份第一天的天数差
     * @return
     */
    public static Integer getDeltaDay2TodayInMonth() {
        String fisrtDay = getFirstDayOfMonth(Integer.valueOf(getSysYear()),Integer.valueOf(getSysMonth()));
        Integer firstDate = Integer.valueOf(fisrtDay.split("-")[2]);
        String today = getDay();
        Integer nowDate = Integer.valueOf(today.split("-")[2]);
        return nowDate-firstDate+1;
    }
    
    /**
	 * 获取当前日期
	 * 
	 * @param i
	 * @return
	 */
	public static String getCurrentDay() {
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d);  
		return dateNowStr; 
	}
	
	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		// Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println(sdf.format(date));
		return sdf.format(date);
	}
	
	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
     * 获取当前年份
     * @return
     */
    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }
    
    public static int getSysYear1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.YEAR);
    }
    
    public static String getSysMonth() {
        Calendar date = Calendar.getInstance();
        String month = String.valueOf(date.get(Calendar.MONTH )+1);
        return month;
    }
    
    public static int getSysMonth1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MONTH )+1;
    }
    
    public static int getSysDay1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.DATE);
    }
    
    public static int getSysHour1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getSysMin1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MINUTE);
    }
    
    public static int getSysSec1() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.SECOND);
    }
    
    public static int getSysWeek1() {
        /*获取星期几*/
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        
    }

}
