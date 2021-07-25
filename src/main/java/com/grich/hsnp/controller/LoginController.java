
package com.grich.hsnp.controller;



import com.grich.hsnp.core.Result;
import com.grich.hsnp.enums.Constants;
import com.grich.hsnp.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author william
 */
@Api(value = "管理员登录接口", tags = {"管理员登录接口"})
@RestController
@RequestMapping("/user/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping
    Result<Map<String, Object>> login(String username, String password) {
        return loginService.login(username, password, Constants.VlaUserType.ADMIN);
    }
}


