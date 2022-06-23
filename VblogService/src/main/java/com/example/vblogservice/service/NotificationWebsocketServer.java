package com.example.vblogservice.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/ws/notification/{account}")
public class NotificationWebsocketServer {
    private static final Map<String, NotificationWebsocketServer> online = new ConcurrentHashMap<String, NotificationWebsocketServer>();
    private static int onlineCount = 0;
    private Session session;
    private String account;

    @OnOpen
    public void onOpen(Session session, @PathParam("account") String account) {
        this.session = session;
        this.account = account;

        addOnlineCount();
        online.put(account, this);
        System.out.println(getOnlineCount());
    }

    @OnClose
    public void onClose(){
        online.remove(account);
        subOnlineCount();
    }

    @OnMessage
    public void OnMessage(String message, Session session) throws IOException {
        if(message.equals("heartBath")) {
            System.out.println(message);
            session.getAsyncRemote().sendText(message);
            return;
        }
        JSONObject jsonTo = JSONObject.parseObject(message);
        String mes = (String) jsonTo.get("message");

        for (NotificationWebsocketServer item : online.values()) {
            if(item.account.equals(jsonTo.get("to"))) {
                item.session.getAsyncRemote().sendText(mes);
            }
        }
    }

    public static synchronized void addOnlineCount() {
        NotificationWebsocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        NotificationWebsocketServer.onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

}
