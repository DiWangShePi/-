package MainFrame.Frame3;


import MainFrame.Select;
import MainFrame.abstractFrame;
import components.GridComponent;
import controller.GameController;
import entity.Player;
import minesweeper.GamePanel;
import minesweeper.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame31 extends JFrame implements abstractFrame{
    ImageIcon fpx=new ImageIcon("space.jpg");
    ImageIcon fpx2=new ImageIcon("back.jpg");
    private int xCount;
    private int yCount;
    private int mineCount;

    public Frame31(Player p1,Player p2,Player p3,int step0) {
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        this.xCount = 9;//grid of row
        this.yCount = 9;// grid of column
        this.mineCount = 10;// mine count
        ImageIcon fpx=new ImageIcon("space.jpg");
        ImageIcon fpx2=new ImageIcon("back.jpg");

        this.setTitle("2021 CS102A Project Demo 2");
        this.setLayout(null);
        this.setSize(yCount * GridComponent.gridSize + 20, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        players.add(p1);
        players.add(p2);
        players.add(p3);


        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);
        setController(players);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, p2, p3,xCount, yCount);
        controller.setScoreBoard(scoreBoard);
        controller.setStep0(step0);

        this.add(gamePanel);
        this.add(scoreBoard);

        if(abstractFrame.controller.getSelect().getChosen()==1){
            JLabel back=new JLabel(fpx);
            this.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
            back.setBounds(0,0,fpx.getIconWidth(),fpx.getIconHeight());
            Container container =this.getContentPane();
            ((JPanel) container).setOpaque(false);}

        if(abstractFrame.controller.getSelect().getChosen()==2){
            JLabel back=new JLabel(fpx2);
            this.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
            back.setBounds(0,0,fpx2.getIconWidth(),fpx2.getIconHeight());
            Container container =this.getContentPane();
            ((JPanel) container).setOpaque(false);

        }


        JButton clickBtn = new JButton("Click");
        clickBtn.setSize(80, 20);
        clickBtn.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn);
        clickBtn.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            System.out.println("fileName :" + fileName);

//            controller.readFileData(fileName);
//            controller.writeDataToFile(fileName);
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    @Override
    public void setController(ArrayList<Player> players) {
        Player p1= players.get(0);
        Player p2= players.get(1);
        Player p3= players.get(2);
        controller.init(p1,p2,p3);
    }
}
