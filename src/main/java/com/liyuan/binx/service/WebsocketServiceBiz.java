//package com.liyuan.binx.service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.concurrent.ConcurrentHashMap;
//
//@ServerEndpoint("/endpoint")
//@Component
//public class WebsocketServiceBiz {
//
//    public static Logger log = LoggerFactory.getLogger(WebsocketServiceBiz.class);
//    private static int onlineCount = 0;
//    private static final ConcurrentHashMap<String, WebsocketServiceBiz> webSocketMap = new ConcurrentHashMap<>();
//    private static ApplicationContext applicationContext;
//
//
//    private Session session;
//    private String userId = "";
//
//
//    public static void setApplicationContext(ApplicationContext applicationContext) {
//        WebsocketServiceBiz.applicationContext = applicationContext;
//    }
//
//
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("userId") String userId) {
//        this.session = session;
//        this.userId = userId;
//        if (webSocketMap.containsKey(userId)) {
//            webSocketMap.remove(userId);
//            webSocketMap.put(userId, this);
//        } else {
//            webSocketMap.put(userId, this);
//            addOnlineCount();
//        }
//
//        log.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
//        try {
//            sendMessage("WSSuccess");
//            JSONObject init = new JSONObject();
//            String gid = "0";
//            webSocketMap.get(userId).sendMessage(init.toJSONString());
//
//        } catch (IOException e) {
//            log.error("用户:" + userId + ",网络异常!!!!!!");
//        }
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        if (webSocketMap.containsKey(userId)) {
//            webSocketMap.remove(userId);
//            subOnlineCount();
//        }
//        log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        log.info("用户消息:" + userId + ",报文:" + message);
//        if (!ObjectUtils.isEmpty(message)) {
//            try {
//                JSONObject jsonObject = JSON.parseObject(message);
//                String toUserId = jsonObject.getJSONObject("data").getString("sim");
//                if (!ObjectUtils.isEmpty(toUserId) && webSocketMap.containsKey(toUserId)) {
//                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
//                } else {
//                    log.error("请求的userId:" + toUserId + "不在该服务器上");
//                }
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//        }
//    }
//
//
//    @OnError
//    public void onError(Session session, Throwable error) {
//        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
//    }
//
//    /**
//     * 实现服务器主动推送
//     */
//    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
//    }
//
//
//    /**
//     * 发送自定义消息
//     */
//    public void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
//        log.info("发送消息到:" + userId + "，报文:" + message);
//        if (!ObjectUtils.isEmpty(userId) && webSocketMap.containsKey(userId)) {
//            webSocketMap.get(userId).sendMessage(message);
//        } else {
//            log.error("用户" + userId + ",不在线！");
//        }
//    }
//
//    public static synchronized int getOnlineCount() {
//        return 0;
//    }
//
//    public static synchronized void addOnlineCount() {
//        WebsocketServiceBiz.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        WebsocketServiceBiz.onlineCount--;
//    }
//}
