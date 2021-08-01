package com.grich.hsnp.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import com.grich.hsnp.core.Result;
import com.grich.hsnp.core.ResultGenerator;
import com.grich.hsnp.enums.Constants;
import com.grich.hsnp.enums.LogType;
import com.grich.hsnp.model.user.VlabUser;
import com.grich.hsnp.service.user.VlabUserService;
import com.grich.hsnp.utils.IpUtil;
import com.grich.hsnp.utils.RequestHolder;
import com.grich.hsnp.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;


import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginService  {

    @Resource
    private VlabUserService sysUserService;



    @Resource
    private RestUtils restUtils;


    @Autowired
    private PasswordEncoder passwordEncoder;


    // 文件访问路径
    @Value("${oauth.oauthUrl}")
    private String oauthUrl;


    @Transactional(rollbackFor = Exception.class)
    public Result<Map<String, Object>> login(String username, String password, Constants.VlaUserType type){
        VlabUser paramValue = new VlabUser();
        paramValue.setOpenId(username);
        paramValue.setUserType(type.getType());
        VlabUser vlabUser = sysUserService.findOneByModel(paramValue);
        if (vlabUser == null) {
            return ResultGenerator.genFailResult("用户不存在，请先注册！");
        } else {
            if (!passwordEncoder.matches(password,vlabUser.getPassword())) {
                return ResultGenerator.genFailResult("用户名或密码错误，请重试！");
            }
            if(vlabUser.getStatus() == Constants.VlaUserStatus.FROZEN.getStatus()){
                return ResultGenerator.genFailResult("用户已被冻结，请先解冻。");
            }
            if(vlabUser.getStatus() == Constants.VlaUserStatus.DELETE.getStatus()){
                return ResultGenerator.genFailResult("用户已注销，暂无法登录");
            }
        }
        log.info("用户登录：username = " + username);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        map.put("grant_type", "password");
        map.put("scope", "all");
        String jsonStr = JSON.toJSONString(map);
        System.out.println(jsonStr);

        String jsonPost = "username=" + username + "&password=" + password + "&scope=all&grant_type=password";

        JSONObject jsonObject;
        try {
            jsonObject = restUtils.login(oauthUrl, jsonPost);
            if (jsonObject.has("access_token")) {
                Map<String, Object> retMap = new HashMap<>();
                VlabUser sysUser = sysUserService.findBy("openId", username);

                RequestHolder.add(sysUser);

                String operatorIp = IpUtil.getRemoteIp(RequestHolder.getCurrentRequest());
                retMap.put("user", sysUser);
                retMap.put("ip", operatorIp);
                retMap.put("token", jsonObject);


                return ResultGenerator.genSuccessResult(retMap);
            } else {
                return ResultGenerator.genFailResult("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("登录失败");
        }
    }
}