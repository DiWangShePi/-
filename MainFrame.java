package MainFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("扫雷小游戏");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);


        JButton button = new JButton("开始\n游戏");
        button.setBounds(140, 150, 100, 80);
        button.setLayout(null);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame0 frame0 = new Frame0();
                frame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //frame.setDefaultCloseOperation(3);
                frame.dispose();
            }
        });
        frame.add(button);


        JLabel b = new JLabel(new ImageIcon("C:\\Users\\Abraham Feng\\Desktop\\OIP.jfif"));
        b.setBounds(-10, -20, 400, 400);
        frame.getContentPane().add(b);
        b.setVisible(true);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   /* public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("扫雷小游戏");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);


        JButton button = new JButton("开始\n游戏");
        button.setBounds(140, 150, 100, 80);
        button.setLayout(null);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame0 frame0 = new Frame0();
                frame0.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.add(button);


        JLabel b = new JLabel(new ImageIcon("C:\\Users\\Abraham Feng\\Desktop\\OIP.jfif"));
        b.setBounds(-10, -20, 400, 400);
        frame.getContentPane().add(b);
        b.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/

}