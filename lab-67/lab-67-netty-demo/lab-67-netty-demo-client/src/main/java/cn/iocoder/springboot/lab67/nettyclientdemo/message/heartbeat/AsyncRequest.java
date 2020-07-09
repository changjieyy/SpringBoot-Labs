package cn.iocoder.springboot.lab67.nettyclientdemo.message.heartbeat;

import cn.iocoder.springboot.lab67.nettycommondemo.dispatcher.Message;

/**
 * 消息 - 心跳请求
 */
public class AsyncRequest implements Message {

    /**
     * 类型 - 心跳请求
     */
    public static final String TYPE = "async";


    /**
     * 响应提示
     */
    private String message;

    @Override
    public String toString() {
        return "AsyncRequest{}";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
