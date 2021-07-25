/**
 * Inspired by JoJozhai's Spring Security Mooc class.
 *
 * http://coding.imooc.com/learn/list/134.html
 *
 */
package com.grich.hsnp.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 *
 */
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

	
	/**
	 * OAuth2认证服务器配置
	 */
	private OAuth2Properties oauth2 = new OAuth2Properties();

	public OAuth2Properties getOauth2() {
		return oauth2;
	}

	public void setOauth2(OAuth2Properties oauth2) {
		this.oauth2 = oauth2;
	}


}
