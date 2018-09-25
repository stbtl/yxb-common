package com.yxb.util;


import com.yxb.constant.Consts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 * Created by VMBing on 2017/3/8.
 */
public class DateUtil {
    /** 锁对象 */
    private static final Object lockObj = new Object();

    /** 存放不同的日期模板格式的sdf的Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern 日期格式
     * @return 日期格式对象
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    System.out.println("put new sdf of pattern " + pattern + " to map");

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {
                            System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     *
     * @param date 日期
     * @param pattern 日期格式
     * @return 格式化后日期
     */
    private static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    /**
     * 日期字符串转日期
     *
     * @param dateStr 日期字符串
     * @return 日期
     * @throws ParseException 转换异常
     */
    public static Date stringToDate(String dateStr) throws ParseException {
        return getSdf(Consts.DATE_PATTERN_DEFAULT).parse(dateStr);
    }

    /**
     * 获取日期
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：2000-01-01 23:59:59）
     */
    public static String getDateForDefault(Date date) {
        return format(date, Consts.DATE_PATTERN_DEFAULT);
    }

    /**
     * 获取日期
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：2000-01-01）
     */
    public static String getDateForDate10(Date date) {
        return format(date, Consts.DATE_PATTERN_DATE_10);
    }

    /**
     * 获取日期
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：20000101）
     */
    public static String getDateForDate8(Date date) {
        return format(date, Consts.DATE_PATTERN_DATE_8);
    }

    /**
     * 获取日期的时间
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：23:59:59）
     */
    public static String getTime(Date date) {
        return format(date, Consts.DATE_PATTERN_TIME);
    }

    /**
     * 获取日期的年
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：2015）
     */
    public static String getYear(Date date) {
        return format(date, Consts.DATE_PATTERN_YEAR);
    }

    /**
     * 获取日期的月
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：06）
     */
    public static String getMonth(Date date) {
        return format(date, Consts.DATE_PATTERN_MONTH);
    }

    /**
     * 获取日期的日
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：31）
     */
    public static String getDay(Date date) {
        return format(date, Consts.DATE_PATTERN_DAY);
    }

    /**
     * 获取日期的小时
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：23）
     */
    public static String getHourFor24(Date date) {
        return format(date, Consts.DATE_PATTERN_HOUR_24);
    }

    /**
     * 获取日期的小时
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：11）
     */
    public static String getHourFor12(Date date) {
        return format(date, Consts.DATE_PATTERN_HOUR_12);
    }

    /**
     * 获取日期的分钟
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：59）
     */
    public static String getMinute(Date date) {
        return format(date, Consts.DATE_PATTERN_MINUTE);
    }

    /**
     * 获取日期的秒
     *
     * @param date 日期
     * @return 日期 - 日期格式（例：59）
     */
    public static String getSecond(Date date) {
        return format(date, Consts.DATE_PATTERN_SECOND);
    }

    /**
     * 日期计算
     *
     * @param date 日期
     * @param calendarType 计算的日期类型（年或月或日或其他）
     * @param amount 需要计算的数值
     * @return 日期计算结果
     */
    private static Date addDate(Date date, int calendarType, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarType, amount);

        return calendar.getTime();
    }

    /**
     * 日期计算（加减天数）
     *
     * @param date 日期
     * @param days 加减的天数
     * @return 日期计算结果
     */
    public static Date addDays(Date date, int days) {
        return addDate(date, Calendar.DATE, days);
    }

    /**
     * 日期计算（加减月数）
     *
     * @param date 日期
     * @param months 加减的月数
     * @return 日期计算结果
     */
    public static Date addMonth(Date date, int months) {
        return addDate(date, Calendar.MONTH, months);
    }

    /**
     * 日期计算（加减年数）
     *
     * @param date 日期
     * @param years 加减的年数
     * @return 日期计算结果
     */
    public static Date addYear(Date date, int years) {
        return addDate(date, Calendar.YEAR, years);
    }

    /**
     * 获取月末日期
     *
     * @param date 日期
     * @return 月末日期
     */
    public static int getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期是星期几
     *
     * @param date 日期
     * @return 月末日期
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 两个日期间隔天数(数值有正负，正：sDate > fDate  负：反之)
     *
     * @param fDate 第一个日期
     * @param sDate 第二个日期
     * @return 日期间隔天数
     * @throws ParseException 异常信息
     */
    public static int getIntervalDays(Date fDate, Date sDate) throws ParseException {
        Date fDateTmp = stringToDate(format(fDate, Consts.DATE_PATTERN_DATE_10));
        Date sDateTmp = stringToDate(format(sDate, Consts.DATE_PATTERN_DATE_10));
        long time = sDateTmp.getTime() - fDateTmp.getTime();
        int num = (int) (time / (24 * 60 * 60 * 1000));

        return num;
    }
}
