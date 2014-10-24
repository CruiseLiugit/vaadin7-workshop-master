package ch.frankel.duchessswiss.vaadin.behavior;

import ch.frankel.duchessswiss.vaadin.ui.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 广播
 * @author lililiu
 *
 */
public class Broadcaster {

    private final List<BroadcastListener<Message>> listeners = new ArrayList<BroadcastListener<Message>>();

    private static final Broadcaster SINGLETON = new Broadcaster();

    /**
     * 简单单例模式
     * @return
     */
    private Broadcaster() {}

    /**
     * 单例模式
     * @return
     */
    public static Broadcaster getInstance() {
        return SINGLETON;
    }

    
    /**
     * 注册广播监听器
     * @param listener
     */
    public void register(BroadcastListener<Message> listener) {

        listeners.add(listener);
    }

    /**
     * 取消广播监听器
     * @param listener
     */
    public void unregister(BroadcastListener<Message> listener) {

        listeners.remove(listener);
    }

    /**
     * 开始广播
     * @param message
     */
    public void broadcast(Message message) {
    		//一个个的监听器的发送消息
        for (BroadcastListener<Message> listener : listeners) {
            listener.onMessage(message);
        }
    }
}
