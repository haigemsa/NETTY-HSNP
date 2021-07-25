/**
 * Inspired by JoJozhai's Spring Security Mooc class.
 *
 * http://coding.imooc.com/learn/list/134.html
 *
 */
package com.grich.hsnp.security;
/**
 * 
 *
 */

public class OAuth2Properties {

	
	/**
	 * 客户端配置
	 */
	private OAuth2ClientProperties client ;

	public OAuth2ClientProperties getClient() {
		return client;
	}

	public void setClient(OAuth2ClientProperties client) {
		this.client = client;
	}

}
