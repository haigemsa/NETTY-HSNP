/**
 * 
 */
package com.grich.hsnp.utils;

/**
 * @author william
 *
 */
public class SqlUtils {
	
	/**
	 * 生成按开始日期过滤条件
	 * 
	 * @return String
	 */
	public static String createBeginDateFilter(String columnName, String beginDate) {
		return SqlUtils.createDateString(columnName) + " >= '" + beginDate + "'";
	}
	
	/**
	 * 生成按结束日期过滤条件
	 * 
	 * @return String
	 */
	public static String createEndDateFilter(String columnName, String endDate) {
		return SqlUtils.createDateString(columnName) + " <= '" + endDate + "'";
	}
	
	/**
	 * 按日期时间返回日期字符串
	 * 
	 * @return String
	 */
	public static String createDateString(String columnName) {
		return " DATE_FORMAT(" + columnName + ",'%Y-%m-%d')";
	}
	
	/**
	 * 按日期时间返回周字符串
	 * 
	 * @return String
	 */
	public static String createWeekString(String columnName) {
		return " YEARWEEK(" + columnName + ")";
	}
	/**
	 * 按日期时间返回月字符串
	 * 
	 * @return String
	 */
	public static String createMonthString(String columnName) {
		return " DATE_FORMAT(" + columnName + ",'%Y-%m')";
	}
	/**
	 * 按日期时间返回月字符串
	 * 
	 * @return String
	 */
	public static String createYearString(String columnName) {
		return " DATE_FORMAT(" + columnName + ",'%Y')";
	}
}
