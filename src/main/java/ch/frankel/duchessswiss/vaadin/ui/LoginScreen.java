package ch.frankel.duchessswiss.vaadin.ui;

import javax.servlet.annotation.WebServlet;

import ch.frankel.duchessswiss.vaadin.behavior.LoginListener;

import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.server.Sizeable.Unit.PIXELS;
import static com.vaadin.ui.Alignment.MIDDLE_CENTER;

public class LoginScreen extends VerticalLayout {

	/**
	 * 创建登录页面
	 */
    LoginScreen() {
    		//设置整个页面的  页面填充方式
        setSizeFull();
        setMargin(true);//an outer margin (akin to a CSS margin)
        setSpacing(true);//an inner spacing (akin to a CSS padding)

        //创建一个  面板
        Panel panel = new Panel();
        panel.setHeight(200, PIXELS);  //PIXELS 像素
        panel.setWidth(300, PIXELS);   //PIXELS 像素
        //设置面板位置
        addComponent(panel);
        setComponentAlignment(panel, MIDDLE_CENTER);//alignment of a component inside them


        //相当于 html  form 表单
        final FormLayout panelLayout = new FormLayout();
        panelLayout.setMargin(true);
        panelLayout.setSpacing(true);
        panelLayout.setSizeFull();

        panel.setContent(panelLayout);
        
        //添加表单中的输入框主键
        final TextField loginField = new TextField("Username");
        loginField.setWidth(100, PERCENTAGE); //按照百分比的设置宽高比例

        panelLayout.addComponent(loginField);

        Button button = new Button("Login");
        //按钮点击，第一个参数的下一个新页面的 对象，第二个是 输入框对
        button.addClickListener(new LoginListener(new ChatScreen(), loginField));

        panelLayout.addComponent(button);
    }
}
