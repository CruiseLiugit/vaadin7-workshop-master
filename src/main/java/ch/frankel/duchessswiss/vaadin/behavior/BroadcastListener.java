package ch.frankel.duchessswiss.vaadin.behavior;


/**
 * 自定义的 广播监听器 接口
 * @author lililiu
 *
 * @param <T>
 */
public interface BroadcastListener<T> {

    void onMessage(T message);
}
