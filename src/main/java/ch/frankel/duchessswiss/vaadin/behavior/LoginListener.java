package ch.frankel.duchessswiss.vaadin.behavior;

import ch.frankel.duchessswiss.vaadin.ui.ChatScreen;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LoginListener implements Button.ClickListener {

    private Layout newScreen;
    private Property<String> loginHolder;

    public LoginListener(Layout newScreen, Property<String> loginHolder) {

        this.loginHolder = loginHolder;
        this.newScreen = newScreen;
    }

    /**
     * 按钮点击后的  操作
     */
    @Override
    public void buttonClick(Button.ClickEvent event) {
    		//获取登录文本框中的内容
        String login = loginHolder.getValue();
        //通知
        Notification.show("欢迎你: " + login);
        //吧当前用户名，存入  session 中
        VaadinSession.getCurrent().setAttribute(String.class, login);
        //创建一个新的 屏幕对象,new ChatScreen()
        //当前UI 对象只有一个，显示什么内容，要看往里面放入什么内容
        //可以放入的有 Layout
        UI.getCurrent().setContent(newScreen);
    }
}
