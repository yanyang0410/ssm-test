package com.test.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: com.test.ssm.utils.DateUtils
 * @Description: 时间工具类
 * @Author: francis
 * @Date: 2019-05-20 22:41
 * @Version: 1.0
 */
public class DateUtils {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss ";
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final Locale DEFAUTL_LOCALE = Locale.ENGLISH;
    private static final Pattern DATE_FORMAT_PATTERN = Pattern.compile("((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
    private static final Pattern DAY_PATTERN = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");

    /**
     * 功能描述: 〈日期转换：日期格式转换成字符串〉
     *
     * @param date
     * @param pattern
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-05-20 23:03
     */
    public static String date2String(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 功能描述: 〈日期转换：字符串转换成日期格式〉
     *
     * @param str
     * @param pattern
     * @return: java.util.Date
     * @author: francis
     * @date: 2019-05-20 23:06
     */
    public static Date string2Date(String str, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(str);
    }

    /**
     * 功能描述: 〈将日期字符yyyymmdd转换成yyyy-mm-dd〉
     *
     * @param dataStr
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-05-26 11:12
     */
    public static String changeDateString(String dataStr) {
        try {
            return new SimpleDateFormat(DATE_PATTERN, DEFAUTL_LOCALE).format(new SimpleDateFormat(
                    DATE_FORMAT, DEFAUTL_LOCALE).parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("string format error!!");
        }
    }

    /**
     * 功能描述: 〈判断日期格式是否为yyyy-mm-dd〉
     *
     * @param timeStr
     * @return: boolean
     * @author: francis
     * @date: 2019-05-26 11:13
     */
    public static boolean valiDateTimeWithLongFormat(String timeStr) {
        Matcher matcher = DATE_FORMAT_PATTERN.matcher(timeStr);
        if (matcher.matches()) {
            matcher = DAY_PATTERN.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }
}