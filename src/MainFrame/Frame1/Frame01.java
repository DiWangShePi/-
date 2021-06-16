package MainFrame.Frame1;

import MainFrame.Frame0;
import MainFrame.Frame1.Frame1;
import MainFrame.Frame2.Frame2;
import MainFrame.Select;
import MainFrame.abstractFrame;
import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import icons.Play;

public class Frame01 extends JFrame {
    ImageIcon fpx=new ImageIcon("space.jpg");
    ImageIcon fpx2=new ImageIcon("back.jpg");
    public Frame01(){
        JFrame frame = new JFrame();
        frame.setTitle("扫雷小游戏");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);

        if(abstractFrame.controller.getSelect().getChosen()==1){
            JLabel back=new JLabel(fpx);
            frame.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
            back.setBounds(0,0,fpx.getIconWidth(),fpx.getIconHeight());
            Container container =frame.getContentPane();
            ((JPanel) container).setOpaque(false);}

        if(abstractFrame.controller.getSelect().getChosen()==2){
            JLabel back=new JLabel(fpx2);
            frame.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
            back.setBounds(0,0,fpx2.getIconWidth(),fpx2.getIconHeight());
            Container container =frame.getContentPane();
            ((JPanel) container).setOpaque(false);

        }

        //AtomicReference<String> p1name = null;
        //AtomicReference<String> p2name = null;
        Player p1 = new Player();

        JButton button4 = new JButton("<-");
        button4.setBounds(0, 0, 20, 20);
        button4.setLayout(null);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame0 frame0 = new Frame0();
                frame.setVisible(false);
                frame0.setVisible(true);
            }
        });
        JButton clickBtn2 = new JButton("请输入玩家姓名");
        clickBtn2.setSize(300, 20);
        clickBtn2.setLocation(50,120 );
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            p1.setUserName(fileName);
            //System.out.println(p1.getUserName());
        });
        JButton clickBtn4 = new JButton("开始游戏");
        clickBtn4.setSize(300, 20);
        clickBtn4.setLocation(50,320 );
        clickBtn4.addActionListener(e -> {
            Frame1 frame1 = new Frame1(p1);
            frame.setVisible(false);
            frame1.setVisible(true);
        });


        frame.add(button4);
        frame.add(clickBtn2);
        frame.add(clickBtn4);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}