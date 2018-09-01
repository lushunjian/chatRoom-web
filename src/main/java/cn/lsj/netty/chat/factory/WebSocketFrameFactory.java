package cn.lsj.netty.chat.factory;

import cn.lsj.netty.chat.WebSocketFrameHandler;
import cn.lsj.netty.chat.exception.ChatException;
import cn.lsj.netty.chat.impl.BinaryWebSocketFrameHandler;
import cn.lsj.netty.chat.impl.CloseWebSocketFrameHandler;
import cn.lsj.netty.chat.impl.PingWebSocketFrameHandler;
import cn.lsj.netty.chat.impl.TextWebSocketFrameHandler;
import cn.lsj.netty.chat.spring.ApplicationContextProvider;
import io.netty.handler.codec.http.websocketx.*;

/**
 * @Auther: Lushunjian
 * @Date: 2018/9/1 15:39
 * @Description:
 */
public class WebSocketFrameFactory {

    /**
     * 传统方式写法，手动生成实例
     * */
    public static WebSocketFrameHandler createSocketHandler(WebSocketFrame frame){
        // 判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            return new CloseWebSocketFrameHandler((CloseWebSocketFrame)frame);
        }
        // 判断是否ping消息
        else if (frame instanceof PingWebSocketFrame) {
            return new PingWebSocketFrameHandler((PingWebSocketFrame)frame);
        }
        //字符串处理
        else if(frame instanceof TextWebSocketFrame){
            return new TextWebSocketFrameHandler((TextWebSocketFrame)frame);
        }
        // 二进制文件流
        else if (frame instanceof BinaryWebSocketFrame) {
            return new BinaryWebSocketFrameHandler((BinaryWebSocketFrame)frame);
        }
        else {
            throw ChatException.error("没有找到对应socket的处理类");
        }
    }

    /**
     * 通过spring 实例化bean
     * */
    public static WebSocketFrameHandler createSocketHandlerBySpring(WebSocketFrame frame){
        // 判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            CloseWebSocketFrameHandler frameHandler =  ApplicationContextProvider.getBean("close",CloseWebSocketFrameHandler.class);
            frameHandler.setCloseWebSocketFrame((CloseWebSocketFrame)frame);
            return frameHandler;
        }
        // 判断是否ping消息
        else if (frame instanceof PingWebSocketFrame) {
            PingWebSocketFrameHandler frameHandler = ApplicationContextProvider.getBean("ping",PingWebSocketFrameHandler.class);
            frameHandler.setPingWebSocketFrame((PingWebSocketFrame)frame);
            return frameHandler;
        }
        //字符串处理
        else if(frame instanceof TextWebSocketFrame){
            TextWebSocketFrameHandler frameHandler = ApplicationContextProvider.getBean("text",TextWebSocketFrameHandler.class);
            frameHandler.setTextWebSocketFrame((TextWebSocketFrame)frame);
            return frameHandler;
        }
        // 二进制文件流
        else if (frame instanceof BinaryWebSocketFrame) {
            BinaryWebSocketFrameHandler frameHandler = ApplicationContextProvider.getBean("binary",BinaryWebSocketFrameHandler.class);
            frameHandler.setBinaryWebSocketFrame((BinaryWebSocketFrame)frame);
            return frameHandler;
        }
        else {
            throw ChatException.error("没有找到对应socket的处理类");
        }
    }
}
