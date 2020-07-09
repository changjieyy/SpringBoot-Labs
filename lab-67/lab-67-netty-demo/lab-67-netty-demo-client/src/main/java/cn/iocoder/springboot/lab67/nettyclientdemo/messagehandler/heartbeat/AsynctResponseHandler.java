package cn.iocoder.springboot.lab67.nettyclientdemo.messagehandler.heartbeat;

import cn.iocoder.springboot.lab67.nettyclientdemo.message.heartbeat.AsyncResponse;
import cn.iocoder.springboot.lab67.nettycommondemo.dispatcher.MessageHandler;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AsynctResponseHandler implements MessageHandler<AsyncResponse> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, AsyncResponse message) {
        logger.info("[execute][收到连接({}) 的 async 结果] ---- {} ", channel.id(), message.getMessage());
    }

    @Override
    public String getType() {
        return AsyncResponse.TYPE;
    }

}
