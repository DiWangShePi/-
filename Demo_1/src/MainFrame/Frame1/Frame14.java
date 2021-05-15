package MainFrame.Frame1;

import MainFrame.abstractFrame;
import components.GridComponent;
import controller.GameController;
import entity.Player;
import minesweeper.GamePanel;
import minesweeper.ScoreBoard;

import javax.swing.*;
import java.util.ArrayList;

public class Frame14 extends JFrame implements abstractFrame {
    //public static GameController controller;
    private int xCount;
    private int yCount;
    private int mineCount;

    public Frame14(Player p1) {
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        this.xCount = 9;//grid of row
        this.yCount = 9;// grid of column
        this.mineCount = 20;// mine count

        this.setTitle("2021 CS102A Project Demo 2");
        this.setLayout(null);
        this.setSize(yCount * GridComponent.gridSize + 20, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        players.add(p1);
        setController(players);


        //  controller = new GameController(p1, p2);
        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, xCount, yCount);
        controller.setScoreBoard(scoreBoard);

        this.add(gamePanel);
        this.add(scoreBoard);


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
        controller.init(p1);

    }
}
