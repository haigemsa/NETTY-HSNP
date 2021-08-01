package com.grich.hsnp.controller.socket;


import com.grich.hsnp.annotation.SocketController;
import com.grich.hsnp.annotation.SocketRequestBody;
import com.grich.hsnp.annotation.SocketRequestMapping;
import com.grich.hsnp.annotation.SocketRequestParam;
import com.grich.hsnp.entity.SocketDataDto;
import com.grich.hsnp.hsnp.HsnpContextThreadLocal;
import com.grich.hsnp.hsnp.HsnpRequest;
import com.grich.hsnp.hsnp.HsnpResponse;
import com.grich.hsnp.server.ChannelHandler;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

/**
 * @author lucas
 */
@Api(value = "Socket生命周期接口", tags = {"Socket生命周期接口"})
@SocketController
@Service
@SocketRequestMapping("/socket")
public class LiveSocketController {

    /** 心跳
     *
     * @param socketDataDto
     * @return
     */
    @SocketRequestMapping("/beating")
    public String beating(@SocketRequestBody SocketDataDto socketDataDto) {
        return "welcome!:"+ socketDataDto.getId() +" socket request1! ";
    }

    /** 设备注册
     *
     * @param id 客户端ID
     * @return String
     */
    @SocketRequestMapping("/register")
    public String register(@SocketRequestParam("id") String id) {
        HsnpResponse hsnpResponse = HsnpContextThreadLocal.getHsnpResponse();
        HsnpRequest hsnpRequest = HsnpContextThreadLocal.getHsnpRequest();
        ChannelHandler.ID_RESPONSE.put(hsnpRequest.getId(),hsnpResponse);
        return "welcome! : "+ id;
    }

}
