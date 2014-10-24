package ch.frankel.duchessswiss.vaadin.ui;

import static com.vaadin.ui.Table.ColumnHeaderMode.HIDDEN;
import ch.frankel.duchessswiss.vaadin.behavior.ChatListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;

/**
 * 聊天界面
 * @author lililiu
 *
 */
public class ChatScreen extends VerticalLayout {

    public ChatScreen() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        //创建一个表哥
        Table incoming = new Table();
        incoming.setContainerDataSource(new BeanItemContainer(Message.class));
        incoming.setVisibleColumns("time", "sender", "text");
        incoming.setColumnWidth("time", 150);  //设置列宽度
        incoming.setColumnWidth("sender", 150); //设置列宽度
        incoming.addGeneratedColumn("time", new TimeGeneratedColumn()); //时间显示格式
        //incoming.setColumnHeaderMode(HIDDEN);  //隐藏表头 Mode
        incoming.setSizeFull();
        incoming.setReadOnly(true); 
        addComponent(incoming);

        //水平布局
        HorizontalLayout bottomBar = new HorizontalLayout();
        bottomBar.setWidth(100, PERCENTAGE); //百分比宽度
        bottomBar.setSpacing(true);

        addComponent(bottomBar);

        //把一个 TextArea 增加到 水平布局中
        TextArea toBeSent = new TextArea();
        toBeSent.setWidth(100, PERCENTAGE);
        bottomBar.addComponent(toBeSent);

        //把 按钮增加到水平布局中
        Button button = new Button("发送!");
        //按钮监听器，参数一，数据来源；参数二，数据显示去处
        ChatListener chatListener = new ChatListener(toBeSent, incoming);
        button.addClickListener(chatListener);
        
        //通过 MainUI 中的静态方法，把监听器注册到广播监听器中，实现广播功能
        MainUI.getCurrent().setBroadcastListener(chatListener);
        
        bottomBar.addComponent(button);
    }
}
