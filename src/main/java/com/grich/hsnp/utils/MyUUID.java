package com.grich.hsnp.utils;

import java.util.UUID;

/**
 * @author William
 *
 */
public class MyUUID {

	/**
	 * 生成随机的UUID
	 * 
	 * @return
	 */
	public static String randomUUID() {
		String uuid = UUID.randomUUID().toString().intern();
		return uuid;
	}
}
