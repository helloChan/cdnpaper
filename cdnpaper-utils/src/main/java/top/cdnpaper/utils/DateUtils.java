package top.cdnpaper.utils;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static top.cdnpaper.utils.Constants.*;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月21日 下午6:13:48
* @description 日期、时间工具类
*/
public class DateUtils {
	
	/**
	 * 当前时间
	 */
	public static final Date NOW = DateTime.now().toDate();
	
	/**
	 * 当前时间的字符串格式{@link Constants#YYYYMMDD}
	 */
	public static final String NOW_YYYYMMDD = defaultDate2String(NOW, YYYYMMDD);
	
	/**
	 * 当前时间的字符串格式{@link Constants#YYYY_MM_DD}
	 */
	public static final String NOW_YYYY_MM_DD = defaultDate2String(NOW, YYYY_MM_DD);
	
	/**
	 * 当前时间的字符串格式{@link Constants#YYYYMMDD_CHINESE}
	 */
	public static final String NOW_YYYYMMDD_CHINESE = defaultDate2String(NOW, YYYYMMDD_CHINESE);
	
	/**
	 * 当前时间的字符串格式{@link Constants#YYYY_MM_DD_HHSSMM_24}
	 */
	public static final String NOW_YYYY_MM_DD_HHSSMM_24 = defaultDate2String(NOW, YYYY_MM_DD_HHSSMM_24);

	/**
	 * 当前时间的字符串格式{@link Constants#YYYY_MM_DD_HHSSMM_12_ENGLISH}
	 */
	public static final String NOW_YYYY_MM_DD_HHSSMM_12_ENGLISH = date2String(NOW, YYYY_MM_DD_HHSSMM_12_ENGLISH, Locale.ENGLISH);

	/**
	 * 当前时间的字符串格式{@link Constants#YYYY_MM_DD_HHSSMM_12_CHINESE}
	 */
	public static final String NOW_YYYY_MM_DD_HHSSMM_12_CHINESE = date2String(NOW, YYYY_MM_DD_HHSSMM_12_CHINESE, Locale.CHINESE);
	
	/**
	 * 系统毫秒级的当前时间
	 */
	public static final long currentTimeMillis = System.currentTimeMillis();
	
	/**
	 * 使用默认的{@link Locale}把date转为字符串格式
	 * @param date date
	 * @param pattern 转换格式，为空时默认使用格式{@link Constants#YYYY_MM_DD}
	 * @return 格式后的字符串
	 */
	public static String defaultDate2String(Date date, String pattern){
		return date2String(date, pattern, null);
	}
	
	/**
	 * 根据给定的{@link Locale}把date转为字符串格式
	 * @param date date
	 * @param pattern 转换格式，为空时默认使用格式{@link Constants#YYYY_MM_DD}
	 * @param locale locale，为空时默认使用格式{@link Locale#CHINESE}
	 * @return 格式后的字符串
	 */
	public static String date2String(Date date, String pattern, Locale locale){
		return new DateTime(date).toString(
				StringUtils.isNotBlank(pattern)?pattern:YYYY_MM_DD, 
				locale==null?Locale.CHINESE:locale);
	}
	
	/**
	 * 把字符串根据给定格式转为{@link Date}
	 * @param date 字符串
	 * @param pattern 转换格式，为空时默认使用格式{@link Constants#YYYY_MM_DD}
	 * @return {@link Date}
	 * @throws CustomException date为空时抛出异常
	 */
	public static Date string2Date(String date, String pattern) throws CustomException{
		if(StringUtils.isNotBlank(date)){
			return DateTime.parse(date, 
					DateTimeFormat.forPattern(
							StringUtils.isNotBlank(pattern)?pattern:YYYY_MM_DD))
					.toDate();
		}else{
			throw new CustomException(new NullPointerException());
		}
	}
	
	/**
	 * 把字符串根据默认格式{@link Constants#YYYY_MM_DD}转为{@link Date}
	 * @param date 字符串
	 * @return {@link Date}
	 * @throws CustomException date为空时抛出异常
	 */
	public static Date defaultString2Date(String date) throws CustomException{
		return string2Date(date, null);
	}
	
	/**
	 * 把date转为long类型
	 * @param date {@link Date}
	 * @return 
	 */
	public static long date2Long(Date date){
		return new DateTime(date).getMillis();
	}
	
	/**
	 * 把long类型数据转为date
	 * @param millis
	 * @return {@link Date}
	 */
	public static Date long2Date(long millis){
		return new DateTime(millis).toDate();
	}
	
	/**
	 * 计算两个给定日期之间的天数
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 两个给定日期之间的天数
	 */
	public static int daysBetween(Date start, Date end){
		DateTime dateTimeStart = new DateTime(start);
		DateTime dateTimeEnd = new DateTime(end);
		return Days.daysBetween(dateTimeStart, dateTimeEnd).getDays();
	}
	
	/**
	 * 计算两个给定日期之间的天数
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param pattern 日期格式，为空时默认使用格式{@link Constants#YYYY_MM_DD}
	 * @return 两个给定日期之间的天数
	 * @throws CustomException start和end任一为空时抛出异常
	 */
	public static int daysBetween(String start, String end, String pattern) throws CustomException{
		if(StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)){
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(
					StringUtils.isNotBlank(pattern)?pattern:YYYY_MM_DD);
			DateTime dateTimeStart = DateTime.parse(start, dateTimeFormatter);
			DateTime dateTimeEnd = DateTime.parse(end, dateTimeFormatter);
			return Days.daysBetween(dateTimeStart, dateTimeEnd).getDays();
		}else{
			throw new CustomException(new NullPointerException());
		}
	}
	
	/**
	 * 工具类不允许实例化
	 */
	private DateUtils(){
		
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws CustomException
	 */
	public static void main(String[] args) throws CustomException {
		System.out.println(NOW);
		System.out.println(DateUtils.defaultDate2String(NOW, "yyyyMMdd HH:mm:SS"));
		
		System.out.println(NOW_YYYYMMDD);
		System.out.println(NOW_YYYY_MM_DD);
		System.out.println(NOW_YYYYMMDD_CHINESE);

		System.out.println(NOW_YYYY_MM_DD_HHSSMM_24);
		System.out.println(NOW_YYYY_MM_DD_HHSSMM_12_ENGLISH);
		System.out.println(NOW_YYYY_MM_DD_HHSSMM_12_CHINESE);
		
		System.out.println(string2Date("20170808", "yyyyMMdd"));
		
		long millis = date2Long(NOW);
		System.out.println(millis);
		System.out.println(long2Date(millis));
		
		System.out.println(daysBetween(
				new DateTime(2012, 12, 15, 00, 00, 00).toDate(), 
				new DateTime(2013, 01, 01, 00, 01, 00).toDate()));
		
		System.out.println(daysBetween("2017-08-21", "2017-09-09", "yyyy-MM-dd"));
		
		System.out.println(currentTimeMillis);
	}
	
	
	
	
}
