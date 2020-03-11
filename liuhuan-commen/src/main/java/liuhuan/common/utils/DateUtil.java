package liuhuan.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 83795
 *
 */
public class DateUtil {

	/*
	 * 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22 则返回的结果为2019-05-01
	 * 00:00:00
	 */
	@SuppressWarnings("static-access")
	public static Date getDateByInitMonth(Date src) {
		
		// 创建日历控件
		Calendar calendar = Calendar.getInstance();
		// 将日期转化成日历
		calendar.setTime(src);
		// 设置为当前月的第一天
		calendar.set(calendar.DAY_OF_MONTH, 1);
		// 将小时设置为0
		calendar.set(calendar.HOUR_OF_DAY, 0);
		// 将分钟设置为0
		calendar.set(calendar.MINUTE, 0);
		// 将秒设置为0
		calendar.set(calendar.SECOND, 0);
		// 将毫秒设置为0
		calendar.set(calendar.MILLISECOND, 0);
		// 获取本月第一天的时间
		Date date = new Date(new Long(calendar.getTimeInMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = sdf.format(date);
		Date d = null;
		try {
			d = sdf.parse(format);
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	/*
	 * 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	 *  例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59 
	 *  例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 */
	public static Date getDateByFullMonth(Date src) {

		// 创建日历控件
		Calendar calendar = Calendar.getInstance();
		// 将日期转化成日历
		calendar.setTime(src);
		//设置为当月最后一天
		calendar.set(calendar.DAY_OF_MONTH, calendar.getActualMaximum(calendar.DAY_OF_MONTH));
		// 将小时设置为23
		calendar.set(calendar.HOUR_OF_DAY, 23);
		// 将分钟设置为59
		calendar.set(calendar.MINUTE, 59);
		// 将秒设置为59
		calendar.set(calendar.SECOND, 59);
		// 将毫秒设置为999
		calendar.set(calendar.MILLISECOND, 999);
		// 获取本月第一天的时间
		Date date = new Date(new Long(calendar.getTimeInMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = sdf.format(date);
		Date d = null;
		try {
			d = sdf.parse(format);
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
