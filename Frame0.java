package MainFrame;
import MainFrame.Frame1.Frame01;
import MainFrame.Frame2.Frame02;
import MainFrame.Frame2.Frame2;
import MainFrame.Frame3.Frame03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame0 extends JFrame{
    public  Frame0(){
        JFrame frame = new JFrame();
        frame.setTitle("扫雷小游戏");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);

        JButton button1 = new JButton("单人模式");
        button1.setBounds(140, 40, 100, 80);
        button1.setLayout(null);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame01 frame01 = new Frame01();
                frame01.setVisible(true);
                frame.dispose();
            }
        });

        JButton button2 = new JButton("双人模式");
        button2.setBounds(140, 130, 100, 80);
        button2.setLayout(null);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame02 frame02 = new Frame02();
                frame02.setVisible(true);
                frame.dispose();
            }
        });

        JButton button3 = new JButton("多人模式");
        button3.setBounds(140, 220, 100, 80);
        button3.setLayout(null);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                Frame03 frame03 = new Frame03();
                frame03.setVisible(true);
                frame.dispose();
            }
        });

        JButton button4 = new JButton("<-");
        button4.setBounds(0, 0, 20, 20);
        button4.setLayout(null);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 打开另一个窗口
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                frame.dispose();
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
