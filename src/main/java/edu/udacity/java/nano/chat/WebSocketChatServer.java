package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.lang.String.format;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    //private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    private static HashMap<String, String> users = new HashMap<>();
    private static Set<WebSocketChatServer> chatEndpoints = new CopyOnWriteArraySet<>();
    private Session session;

    private static void sendMessageToAll(String msg, String msgType, String username) {
        //TODO: add send message method.

        Message m = new Message();
        m.setMsg(msg);
        m.setOnlineCount(users.size());
        m.setType(msgType);
        m.setUsername(username);

        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    if(endpoint.session.isOpen()) {
                        endpoint.session.getBasicRemote().sendText(JSON.toJSONString(m));
                    }
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        //TODO: add on open connection.

        //add session
        this.session = session;
        chatEndpoints.add(this);

        //add user
        users.put(session.getId(), username);

        //broadcast
        String message = username  + " joined!";
        sendMessageToAll(message,"ENTER", username);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) throws IOException, EncodeException {
        //TODO: add send message.
        Message incoming = JSON.parseObject(jsonStr, Message.class);
        sendMessageToAll(incoming.getMsg(),"SPEAK",incoming.getUsername());
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
