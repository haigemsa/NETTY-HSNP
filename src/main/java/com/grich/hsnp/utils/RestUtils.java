/**
 * 
 */
package com.grich.hsnp.utils;


import net.sf.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author william
 *
 */
@Component
public class RestUtils {

    @Resource
    RestTemplate restTemplate;

	/**
	 * get请求
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static JSONObject get(String url) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

		JSONObject jsonObject = JSONObject.fromObject(responseEntity.getBody());
		return jsonObject;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 * @param outStr
	 * @return
	 * @throws Exception
	 */
	public static JSONObject post(String url, String jsonString) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> entity = new HttpEntity<String>(jsonString, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		JSONObject jsonObject = JSONObject.fromObject(responseEntity.getBody());

		return jsonObject;
	}

	/**
	 * POST请求
	 * 
	 * @param url 请求地址
	 * @param jsonString json参数
	 * @return
	 * @throws Exception
	 */
	public JSONObject login(String url, String jsonString) throws Exception {
		//RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Basic bXlhcHA6bXlhcHBzZWNyZXQ=");
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<String>(jsonString, headers), String.class);
		return JSONObject.fromObject(responseEntity.getBody());
	}

}
