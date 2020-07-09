package cn.iocoder.springboot.lab67.nettyclientdemo.message.heartbeat;

import cn.iocoder.springboot.lab67.nettycommondemo.dispatcher.Message;

/**
 * 消息 - 心跳响应
 */
public class AsyncResponse implements Message {

    /**
     * 类型 - 心跳响应
     */
    public static final String TYPE = "async_response";


    /**
     * 响应提示
     */
    private String message;

    public AsyncResponse(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ASYNC_RESPONSE{}";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
