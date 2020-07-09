package cn.iocoder.springboot.lab67.nettyclientdemo.controller;

import cn.iocoder.springboot.lab67.nettyclientdemo.client.NettyClient;
import cn.iocoder.springboot.lab67.nettycommondemo.codec.Invocation;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.util.concurrent.DefaultPromise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private NettyClient nettyClient;

    @PostMapping("/mock")
    public String mock(String type, String message) {
        // 创建 Invocation 对象
        Invocation invocation = new Invocation(type, message);
        // 发送消息
        nettyClient.send(invocation);
        return "success";
    }



    @PostMapping("/async")
    public String async( String message) throws ExecutionException, InterruptedException {
        // 创建 Invocation 对象
        Invocation invocation = new Invocation("async", message);
        // 发送消息
        ChannelPromise promise = null;
        ChannelFuture future = nettyClient.sendAsync(invocation, promise);


        return "success";
    }

}
