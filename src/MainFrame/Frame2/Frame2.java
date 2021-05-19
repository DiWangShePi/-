package MainFrame.Frame2;

import MainFrame.Frame0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainFrame.abstractFrame;
import entity.Player;
import minesweeper.GamePanel;
public class Frame2 extends JFrame {
    ImageIcon fpx=new ImageIcon("space.jpg");
    ImageIcon fpx2=new ImageIcon("back.jpg");
    public Frame2(Player p1,Player p2,int step0) {
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

        JButton button1 = new JButton("初级模式");
        button1.setBounds(140, 40, 100, 80);
        button1.setLayout(null);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame21 frame21 = new Frame21(p1,p2,step0);
                frame.setVisible(false);
                frame21.setVisible(true);
            }
        });

        JButton button2 = new JButton("中级模式");
        button2.setBounds(140, 130, 100, 80);
        button2.setLayout(null);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame22 frame22 = new Frame22(p1,p2,step0);
                frame.setVisible(false);
                frame22.setVisible(true);
            }
        });

        JButton button3 = new JButton("高级模式");
        button3.setBounds(140, 220, 100, 80);
        button3.setLayout(null);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame23 frame23 = new Frame23(p1,p2,step0);
                frame.setVisible(false);
                frame23.setVisible(true);
            }
        });

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



        /*JLabel b = new JLabel(new ImageIcon("C:\\Users\\Abraham Feng\\Desktop\\OIP.jfif"));
        b.setBounds(-10, -20, 400, 400);
        frame.getContentPane().add(b);
        b.setVisible(true);*/


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}