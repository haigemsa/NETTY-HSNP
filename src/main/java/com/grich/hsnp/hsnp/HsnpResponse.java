package com.grich.hsnp.hsnp;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;


/**
 * @author lucas
 */

public class HsnpResponse {



    private final ChannelHandlerContext channelContext;

    public HsnpResponse(ChannelHandlerContext channelContext) {
        this.channelContext = channelContext;
    }


    public ChannelHandlerContext getChannelContext() {
        return channelContext;
    }

    public<T> void success(T data){
        channelContext.writeAndFlush((new ResponseObj<T>().success(data)));
    }
    public void fail(String message){
        channelContext.writeAndFlush(new ResponseObj<String>().fail(message));
    }

    @Data
    class ResponseObj<T>{
        private Integer code;
        private String message;
        private T data;

        public String success(T data) {
            this.code = HsnpStatus.SUCCESS.getStatus();
            this.message = HsnpStatus.SUCCESS.getStatusName();
            this.data = data;
            return this.toString();
        }

        public String fail(String message) {
            this.code = HsnpStatus.FAIL.getStatus();
            this.message = message;
            return this.toString();
        }
        @Override
        public String toString(){
           return JSON.toJSONString(this) + "\r\n";
        }
    }


}
