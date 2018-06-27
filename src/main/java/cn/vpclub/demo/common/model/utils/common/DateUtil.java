package cn.vpclub.demo.common.model.utils.common;

import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    protected DateUtil() {
    }

    public static final String SPLIT_CHAR = "-";

    public static final String YEAR_MONTH = "yyyy-MM";
    public static final String MONTH_DAY = "MM-dd";
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String YEAR_MONTH_DAY_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YEARMONTHDAY = "yyyyMMdd";
    public static final String YEARMONTHDAYHHMMSS = "yyyyMMddHHmmss";
    public static final String SHORT_YEARMONTHDAYHHMMSS = "yyMMddHHmmss";
    public static final String SHORT_YEARMONTHDAY = "yyMMdd";
    public static final String YEARMONTHDAYHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String HHMMSSSSS = "HHmmssSSS";


    /**
     * 格式化日期格式的字符串
     *
     * @param dateTimeStr 日期格式字符串
     * @param pattern     日期格式
     * @return Date
     */
    public static Date formatDateTimeStr(String dateTimeStr, String pattern) {
        Date date = null;
        if (StringUtil.isEmpty(dateTimeStr)) {
            date = new Date();
        } else {
            try {
                SimpleDateFormat format;
                if (StringUtil.isEmpty(pattern)) {
                    format = new SimpleDateFormat(YEARMONTHDAYHHMMSS);
                } else {
                    format = new SimpleDateFormat(pattern);
                }
                date = format.parse(dateTimeStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }


    /**
     * 支付平台日期字符串处理
     *
     * @param aliDateStr
     * @return
     */
    public static String alipayDateParse(String aliDateStr) {
        String resultDataStr;
        if (!StringUtil.isEmpty(aliDateStr)) {
            Date aliDate = DateUtil.formatDateTimeStr(aliDateStr, YEAR_MONTH_DAY_HH_MM_SS);
            resultDataStr = DateUtil.formatDate(aliDate, YEARMONTHDAYHHMMSS);
        } else {
            resultDataStr = DateUtil.formatDate(new Date(), YEARMONTHDAYHHMMSS);
        }
        return resultDataStr;
    }

    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return String
     */
    public static String formatDate(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat format;
        if (StringUtil.isEmpty(pattern)) {
            format = new SimpleDateFormat(YEARMONTHDAYHHMMSS);
        } else {
            format = new SimpleDateFormat(pattern);
        }
        return format.format(date);
    }

    /**
     * 年度计算,获取指定日期前(负数)/后(正数)n年的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的年度数
     * @return Date 计算后的日期
     */
    public static Date addYear(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.YEAR, n);
        return rightNow.getTime();
    }

    /**
     * 月份计算,获取指定日期前(负数)/后(正数)n月的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的月份数
     * @return Date 计算后的日期
     */
    public static Date addMonth(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.MONTH, n);
        return rightNow.getTime();
    }

    /**
     * 周数计算,获取指定日期前(负数)/后(正数)n周的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的周数
     * @return Date 计算后的日期
     */
    public static Date addWeek(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.WEEK_OF_YEAR, n);
        return rightNow.getTime();
    }

    /**
     * 日期计算,获取指定日期前(负数)/后(正数)n天的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的天数
     * @return Date 计算后的日期
     */
    public static Date addDay(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.DAY_OF_YEAR, n);
        return rightNow.getTime();
    }

    /**
     * 小时计算,获取指定日期前(负数)/后(正数)n小时的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的小时数
     * @return Date 计算后的日期
     */
    public static Date addHour(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.HOUR_OF_DAY, n);
        return rightNow.getTime();
    }

    /**
     * 分钟计算,获取指定日期前(负数)/后(正数)n分钟的日期(精确到毫秒)
     *
     * @param date 计算前日期
     * @param n    增加的分钟数
     * @return Date 计算后的日期
     */
    public static Date addMinute(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.MINUTE, n);
        return rightNow.getTime();
    }

    /**
     * 秒计算,获取指定日期前(负数)/后(正数)n秒的日期(忽略毫秒)
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addSeconds(Date date, int n) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.add(Calendar.SECOND, n);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取指定日期的年度(如果指定日期为空时获取当前年度)
     *
     * @param date 处理前日期
     * @return
     */
    public static int getYear(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        return rightNow.get(Calendar.YEAR);
    }

    /**
     * 获取当前年度
     *
     * @return
     */
    public static int getYear() {
        return DateUtil.getYear(null);
    }

    /**
     * 获取指定日期所在年度的月份(如果指定日期为空时获取当前日期所在年度的月份)
     *
     * @param date 处理前日期
     * @return 0 ~ 11
     */
    public static int getMonthOfYear(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        return rightNow.get(Calendar.MONTH);
    }

    /**
     * 获取当前日期所在年度的月份
     *
     * @return 0 ~ 11
     */
    public static int getMonthOfYear() {
        return DateUtil.getMonthOfYear(null);
    }

    /**
     * 获取指定日期所在年度的季度(如果指定日期为空时获取当前日期所在年度的季度)
     *
     * @param date 处理前日期
     * @return 1：一季度; 2：二季度; 3：三季度; 4：四季度;
     */
    public static int getQuarterOfYear(Date date) {
        return DateUtil.getMonthOfYear(date) / 3 + 1;
    }

    /**
     * 获取当前日期所在年度的季度
     *
     * @return 1：一季度; 2：二季度; 3：三季度; 4：四季度;
     */
    public static int getQuarterOfYear() {
        return getQuarterOfYear(null);
    }

    /**
     * 获取指定日期所在年度的周(如果指定日期为空时获取当前日期所在年度的周)
     *
     * @param date 处理前日期
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        int rightWeek = rightNow.get(Calendar.WEEK_OF_YEAR);
        if (rightWeek == 1 && rightNow.get(Calendar.MONTH) == 11) {
            rightWeek = 53;
        }
        return rightWeek;
    }

    /**
     * 获取当前日期所在年度的周
     *
     * @return
     */
    public static int getWeekOfYear() {
        return DateUtil.getWeekOfYear(null);
    }

    /**
     * 获取指定日期是星期几(如果指定日期为空时获取当前日期是星期几)
     *
     * @param date 处理前日期
     * @return 1:星期日; 2:星期一; 3:星期二; 4:星期三; 5:星期四; 6:星期五; 7:星期六;
     */
    public static int getWeekDay(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        return rightNow.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取当前日期是星期几
     *
     * @return 1:星期日; 2:星期一; 3:星期二; 4:星期三; 5:星期四; 6:星期五; 7:星期六;
     */
    public static int getWeekDay() {
        return DateUtil.getWeekDay(null);
    }

    /**
     * 获取指定日期是指定月份的某日
     *
     * @param date 处理前日期
     * @return 1:1日; …… 31:31日;
     */
    public static int getMonthDay(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        return rightNow.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得指定年度的第一天(精确到毫秒)
     *
     * @param year 年度
     * @return Date 计算后的日期
     */
    public static Date getFirstdayOfYear(int year) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.YEAR, year);
        rightNow.set(Calendar.MONTH, 0);
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMinimum(Calendar.DATE)); // 设置为该月第一天
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取指定年度的最后一天(精确到毫秒)
     *
     * @param year 年度
     * @return Date 计算后的日期
     */
    public static Date getLastDayOfYear(int year) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.YEAR, year);
        rightNow.set(Calendar.MONTH, 11);
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMaximum(Calendar.DATE)); // 设置为该月最后一天
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获得指定日期所在月份的第一天(精确到毫秒)
     *
     * @param date 计算前日期
     * @return Date 计算后的日期
     */
    public static Date getFirstdayOfMonth(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMinimum(Calendar.DATE)); // 设置为该月第一天
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取当前年某月的第一天(精确到毫秒)
     *
     * @param n 月份数：0~11
     * @return Date 计算后的日期
     */
    public static Date getFirstdayOfMonth(int n) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.MONTH, n);
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMinimum(Calendar.DATE));
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取指定日期所在月份的最后一天(精确到毫秒)
     *
     * @param date 计算前日期
     * @return Date 计算后的日期
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMaximum(Calendar.DATE)); // 设置为该月最后一天
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获取当前年某月的最后一天(精确到毫秒)
     *
     * @param n 月份数：0~11
     * @return Date 计算后的日期
     */
    public static Date getLastDayOfMonth(int n) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.MONTH, n);
        rightNow.set(Calendar.DAY_OF_MONTH, rightNow.getActualMaximum(Calendar.DATE)); // 设置为该月最后一天
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获取指定日期所在周的第一天[星期日(精确到毫秒)]
     *
     * @param date 处理前日期
     * @return Date
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.DAY_OF_WEEK, 1);//本周第一天，以星期日开始
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取当前年某周的第一天[星期日(精确到毫秒)]
     *
     * @param n 周数：1~53
     * @return Date
     */
    public static Date getFirstDayOfWeek(int n) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.WEEK_OF_YEAR, n);
        rightNow.set(Calendar.DAY_OF_WEEK, 1);//本周第一天，以星期日开始
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获取指定日期所在周的最后一天[星期六(精确到毫秒)]
     *
     * @param date 处理前日期
     * @return Date
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.DAY_OF_WEEK, 7);//本周最后一天
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获取当前年某周的最后一天[星期六(精确到毫秒)]
     *
     * @param n 周数：1~53
     * @return Date
     */
    public static Date getLastDayOfWeek(int n) {
        Calendar rightNow = new GregorianCalendar();
        rightNow.set(Calendar.WEEK_OF_YEAR, n);
        rightNow.set(Calendar.DAY_OF_WEEK, 7);//本周最后一天
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获得指定日期的开始时间(精确到毫秒)
     *
     * @param date 处理前日期
     * @return Date 处理后的日期
     */
    public static Date getFirstTimeOfDay(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获得指定日期的结束时间(精确到毫秒)
     *
     * @param date 处理前日期
     * @return Date 处理后的日期
     */
    public static Date getLastTimeOfDay(Date date) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MILLISECOND, 999);
        return rightNow.getTime();
    }

    /**
     * 获得指定日期的结束时间(精确到毫秒)
     *
     * @param date 处理前日期
     * @return Date 处理后的日期
     */
    public static Date getDateTimeOfDay(Date date, int hour, int minute, int second) {
        Calendar rightNow = new GregorianCalendar();
        if (date != null) {
            rightNow.setTime(date);
        }
        rightNow.set(Calendar.HOUR_OF_DAY, hour);
        rightNow.set(Calendar.MINUTE, minute);
        rightNow.set(Calendar.SECOND, second);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 比较两个 Date 对象表示的时间值（从历元至现在的毫秒偏移量）。
     * <p>
     * 比较逻辑：(d1 == d2) ? 0 : (d1 > d2) ? 1 : -1;
     * 如果 d1 的日期等于 d2 表示的日期(dl = d2)，则返回 0 值；
     * 如果 d1 的日期在 d2 的日期之前(d1 < d2)，则返回 -1 的值；
     * 如果 d1 的日期在 d2 的日期之后(dl > d2)，则返回 1 的值。
     *
     * @param d1
     * @param d2
     * @return int
     */
    public static int compare(Date d1, Date d2) {
        Assert.notNull(d1);
        Assert.notNull(d2);

        Calendar c1 = new GregorianCalendar();
        Calendar c2 = new GregorianCalendar();
        c1.setTime(d1);
        c2.setTime(d2);

        return c1.compareTo(c2);
    }

    /**
     * 比较两个 Date 对象表示的日期值（仅仅比较日期,忽略时分秒）。
     * <p>
     * 比较逻辑：(d1 == d2) ? 0 : (d1 > d2) ? 1 : -1;
     * 如果 d1 的日期等于 d2 表示的日期(dl = d2)，则返回 0 值；
     * 如果 d1 的日期在 d2 的日期之前(d1 < d2)，则返回 -1 的值；
     * 如果 d1 的日期在 d2 的日期之后(dl > d2)，则返回 1 的值。
     *
     * @param d1
     * @param d2
     * @return int
     */
    public static int compareDate(Date d1, Date d2) {
        Assert.notNull(d1);
        Assert.notNull(d2);

        Calendar c1 = new GregorianCalendar();
        c1.setTime(d1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);

        Calendar c2 = new GregorianCalendar();
        c2.setTime(d2);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MILLISECOND, 0);

        return c1.compareTo(c2);
    }

    /**
     * 获取间隔时间(毫秒)
     *
     * @param d1
     * @param d2
     * @return 返回间隔时间绝对值
     */
    public static Long getDiffMillis(Date d1, Date d2) {
        Assert.notNull(d1);
        Assert.notNull(d2);

        long diffMillis = d2.getTime() - d1.getTime();

        return Math.abs(diffMillis);
    }

    /**
     * 获取间隔天数(d2 - d1)
     *
     * @param d1
     * @param d2
     * @return long
     */
    public static long getDiffDays(Date d1, Date d2) {
        Assert.notNull(d1);
        Assert.notNull(d2);
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);

        Calendar c2 = new GregorianCalendar();
        c2.setTime(d2);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MILLISECOND, 0);

        long diffMillis = c2.getTimeInMillis() - c1.getTimeInMillis();

        long diffDays = 0;
        if (diffMillis != 0) {
            long dayMills = 24L * 60L * 60L * 1000L;
            diffDays = diffMillis / dayMills;
        }
        return diffDays;
    }

    /**
     * 获取当前月最大日期
     *
     * @return
     */
    public static int getNowMaxMonthDay() {
        GregorianCalendar c = new GregorianCalendar();
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断是否是润年
     *
     * @param year 年份
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
