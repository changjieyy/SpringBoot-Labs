package cn.iocoder.springboot.lab67.nettyserverdemo.messagehandler.heartbeat;

import cn.iocoder.springboot.lab67.nettycommondemo.codec.Invocation;
import cn.iocoder.springboot.lab67.nettycommondemo.dispatcher.MessageHandler;
import cn.iocoder.springboot.lab67.nettyserverdemo.message.heartbeat.AsyncRequest;
import cn.iocoder.springboot.lab67.nettyserverdemo.message.heartbeat.AsyncResponse;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AsynctRequestHandler implements MessageHandler<AsyncRequest> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, AsyncRequest message) {
        logger.info("[execute][收到连接({}) 的 async 请求] ------- {}", channel.id(), message.getMessage());
        // 响应心跳
        AsyncResponse response = new AsyncResponse( channel.id()  + " -- " + message.getMessage()  );
        channel.writeAndFlush(new Invocation(AsyncResponse.TYPE, response));
    }

    @Override
    public String getType() {
        return AsyncRequest.TYPE;
    }

}
