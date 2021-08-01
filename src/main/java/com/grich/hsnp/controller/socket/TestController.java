
package com.grich.hsnp.controller.socket;



import com.grich.hsnp.annotation.SocketController;
import com.grich.hsnp.annotation.SocketRequestBody;
import com.grich.hsnp.annotation.SocketRequestMapping;
import com.grich.hsnp.annotation.SocketRequestParam;
import com.grich.hsnp.core.Result;
import com.grich.hsnp.core.ResultGenerator;
import com.grich.hsnp.entity.SocketDataDto;
import com.grich.hsnp.enums.Constants;
import com.grich.hsnp.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author lucas
 */
@Api(value = "Socket请求测试接口", tags = {"Socket请求测试接口"})
@SocketController
@Service
@SocketRequestMapping("/socket")
public class TestController {

    @SocketRequestMapping("/hello")
    public Result<String>  hello(@SocketRequestBody SocketDataDto socketDataDto, @SocketRequestParam(value = "name") String name , @SocketRequestBody SocketDataDto socketDataDto1, @SocketRequestParam(value = "age", require = true) int age ) {
        return ResultGenerator.genSuccessResult("welcome!:"+ socketDataDto.getId() + socketDataDto1.getId() + name + age + " socket request! ");
    }

    @SocketRequestMapping("/hello1")
    public Result<String> hello1(@SocketRequestBody SocketDataDto socketDataDto) {
        return ResultGenerator.genSuccessResult("welcome!:"+ socketDataDto.getId() +" socket request1! ") ;
    }





}


