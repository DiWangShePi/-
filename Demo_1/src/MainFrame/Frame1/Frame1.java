package MainFrame.Frame1;

import MainFrame.Frame0;
import entity.Player;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame {
   public Frame1(Player p1){
       JFrame frame = new JFrame();
       frame.setTitle("扫雷小游戏");
       frame.setSize(400, 400);
       frame.setLocationRelativeTo(null);
       frame.setAlwaysOnTop(true);
       frame.setLayout(null);

       JButton button1 = new JButton("初级模式");
       button1.setBounds(140, 10, 100, 80);
       button1.setLayout(null);
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 打开另一个窗口
               Frame11 frame11 = new Frame11(p1);
               frame.setVisible(false);
               frame11.setVisible(true);
           }
       });

       JButton button2 = new JButton("中级模式");
       button2.setBounds(140, 100, 100, 80);
       button2.setLayout(null);
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 打开另一个窗口
               Frame12 frame12 = new Frame12(p1);
               frame.setVisible(false);
               frame12.setVisible(true);
           }
       });

       JButton button3 = new JButton("高级模式");
       button3.setBounds(140, 190, 100, 80);
       button3.setLayout(null);
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 打开另一个窗口
               Frame13 frame13 = new Frame13(p1);
               frame.setVisible(false);
               frame13.setVisible(true);
           }
       });

       JButton button4 = new JButton("人机模式");
       button4.setBounds(140, 280, 100, 80);
       button4.setLayout(null);
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 打开另一个窗口
               Frame14 frame14 = new Frame14(p1);
               frame.setVisible(false);
               frame14.setVisible(true);
           }
       });

       JButton button5 = new JButton("<-");
       button5.setBounds(0, 0, 20, 20);
       button5.setLayout(null);
       button5.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 打开另一个窗口
               Frame0 frame0 = new Frame0();
               frame.setVisible(false);
               frame0.setVisible(true);
           }
       });

        /*JLabel b = new JLabel(new ImageIcon("C:\\Users\\Abraham Feng\\Desktop\\OIP.jfif"));
        b.setBounds(-10, -20, 400, 400);
        frame.getContentPane().add(b);
        b.setVisible(true);*/



       frame.add(button1);
       frame.add(button2);
       frame.add(button3);
       frame.add(button4);
       frame.add(button5);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}
