package WebDemo.litecore.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateTimeUtil {

    /**
     * 格式 yyyy年MM月dd日 HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String getDateTimeDisplayString(LocalDateTime dateTime) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(dateTime);

        return strDate2;
    }

    /**
     * LocalDateTime 转传统的date
     * @param time
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime time){
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 传统date 转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
    }

    /**
     *
     * @param dateTime
     * @param level
     * @return
     */
    public static Long localDataTime2Timestamp(LocalDateTime dateTime,String level){

        if (StringUtils.equals("milliSeconds",level)){
            return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        }
        return dateTime.toEpochSecond(ZoneOffset.of("+8"));
    }
}
