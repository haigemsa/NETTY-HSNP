package com.grich.hsnp.hsnp;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lucas
 */
@Data
public class HsnpRequest {

    /**
     * 客户端指定的唯一通信ID，该ID用来后续的双通道通信
     */
    private String id;
    /**
     * 请求路径
     */
    private String uri;

    /**
     * 请求token
     */
    private String token;
    /**
     * 请求IP
     */
    private String ip;

    /**
     * 业务数据对象(JSON）
     */
    private String body;

    /**
     * 参数：格式 name=123&age=123
     */
    private String paramData;

    /**
     * 参数map,对应paramData
     */
    private Map<String, String> paramMap = new HashMap<>();


    public HsnpRequest() {

    }

    public HsnpRequest(ChannelHandlerContext ctx, String requestData) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        JSONObject jsonObject = JSONObject.parseObject(requestData);
        HsnpRequest hsnpRequest = jsonObject.toJavaObject(HsnpRequest.class);

        if (StringUtils.isBlank(hsnpRequest.getUri())) {
            throw new IllegalArgumentException("uri is need！");
        }
        if (StringUtils.isBlank(hsnpRequest.getToken())) {
            throw new IllegalArgumentException("token is need！");
        }
        if (StringUtils.isBlank(hsnpRequest.getId())) {
            throw new IllegalArgumentException("id is need！");
        }

        this.uri = hsnpRequest.getUri();
        this.token = hsnpRequest.getToken();
        this.body = hsnpRequest.getBody();
        this.ip = channel.localAddress().getHostString();
        this.id = hsnpRequest.getId();
        String paramData = hsnpRequest.getParamData();
        if (paramData != null) {
            String[] split = paramData.split("&");
            for (String param : split) {
                String[] keyValue = param.split("=");
                this.paramMap.put(keyValue[0].trim(),keyValue[1].trim());
            }
        }
    }


}
