package MainFrame.Frame2;

import MainFrame.Frame0;
import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Frame02 extends JFrame {
    int[] step=new int[1];
    public Frame02(){
        JFrame frame = new JFrame();
        frame.setTitle("扫雷小游戏");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);

        //AtomicReference<String> p1name = null;
        //AtomicReference<String> p2name = null;
        Player p1 = new Player();
        Player p2 = new Player();

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

        JButton clickBtn1 = new JButton("请输入单次游戏步数");
        clickBtn1.setSize(300, 20);
        clickBtn1.setLocation(50,20 );
        clickBtn1.addActionListener(e -> {
            String fileName= JOptionPane.showInputDialog(this, "input here");
            //assert step.get() != null;
            step[0]=Integer.parseInt(fileName);
        });

        JButton clickBtn2 = new JButton("请输入1号玩家姓名");
        clickBtn2.setSize(300, 20);
        clickBtn2.setLocation(50,120 );
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            p1.setUserName(fileName);
            //System.out.println(p1.getUserName());
        });

        JButton clickBtn3 = new JButton("请输入2号玩家姓名");
        clickBtn3.setSize(300, 20);
        clickBtn3.setLocation(50,220 );
        clickBtn3.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            p2.setUserName(fileName);
           // System.out.println(p2.getUserName());
        });

        JButton clickBtn4 = new JButton("开始游戏");
        clickBtn4.setSize(300, 20);
        clickBtn4.setLocation(50,320 );
        clickBtn4.addActionListener(e -> {
            Frame2 frame2 = new Frame2(p1,p2,step[0]);
            frame.setVisible(false);
            frame2.setVisible(true);
        });


        frame.add(button4);
        frame.add(clickBtn1);
        frame.add(clickBtn2);
        frame.add(clickBtn3);
        frame.add(clickBtn4);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public int[] getStep() {
        return step;
    }
}
