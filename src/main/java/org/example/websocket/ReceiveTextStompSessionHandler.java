package org.example.websocket;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;



/**
 * @author jiangyuanlin@163.com
 */

public class ReceiveTextStompSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("接收订阅消息=" + (String) payload);
    }

    @Override
    public void handleTransportError(StompSession stompSession, Throwable exception) {

        //super.handleTransportError(stompSession, exception);
        try {
            Thread.sleep(3000);
            ReceiveTextStompClient.connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        }
    }