package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
public class ReceiveTextStompClient {
    private static String url = "http://127.0.0.1:8621/websocket";
    private static String token = "freeswitch_token";
    private static StompSession stompSession;// 定义全局变量，表明一个session

    public static void connect() {// 定义链接函数
        if (stompSession == null || !stompSession.isConnected()) {

            List<Transport> transports = new ArrayList<>();
            transports.add(new WebSocketTransport(new StandardWebSocketClient()));
            SockJsClient sockJsClient = new SockJsClient(transports);
            WebSocketStompClient webSocketStompClient = new WebSocketStompClient(sockJsClient);
            webSocketStompClient.setMessageConverter(new StringMessageConverter());
            webSocketStompClient.setDefaultHeartbeat(new long[] { 20000, 0 });
            ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
            taskScheduler.afterPropertiesSet();
            webSocketStompClient.setTaskScheduler(taskScheduler);
            WebSocketHttpHeaders webSocketHttpHeaders = null;
            StompHeaders stompHeaders = new StompHeaders();
            stompHeaders.add("token", token);
            StompSessionHandler receiveTextStompSessionHandler = new ReceiveTextStompSessionHandler();
            try {
                ListenableFuture<StompSession> future = webSocketStompClient.connect(url, webSocketHttpHeaders,
                        stompHeaders, receiveTextStompSessionHandler);
                stompSession = future.get();
                stompSession.setAutoReceipt(true);
                //stompSession.subscribe("/topic/app", receiveTextStompSessionHandler);
                //stompSession.send("/app/test", "test");
                stompSession.subscribe("/topic/publish", receiveTextStompSessionHandler);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("当前处于链接状态");
        }

    }

    public static void main(String[] args) {// 创建链接
        while (stompSession == null || !stompSession.isConnected()) {
            connect();// 链接服务器
            try {
                Thread.sleep(3000);// 链接服务器失败的处理 3秒后从新链接
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        new Scanner(System.in).nextLine();
    }
}