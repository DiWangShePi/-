package controller;

import components.GridComponent;
import minesweeper.GamePanel;
import entity.Player;
import minesweeper.ScoreBoard;
import java.io.* ;


import javax.swing.*;
import java.util.ArrayList;


public class GameController {

    private Player p1;
    private Player p2;
    private Player p3;

    private Player onTurn;

    private int step0;
    private int step=1;

    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;
    ArrayList<GridComponent> set = new ArrayList<>();
    ArrayList<JTextField> textFields=new ArrayList<>();

    public GameController() {

    }
    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
        this.onTurn = p1;
    }
    public GameController(Player p1) {
        this.init(p1);
        this.onTurn = p1;
    }
    public GameController(Player p1,Player p2,Player p3){
        this.init(p1,p2,p3);
        this.onTurn=p1;
    }


    /**
     * 初始化游戏。在开始游戏前，应先调用此方法，给予游戏必要的参数。
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public void init(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.onTurn = p1;

        //TODO: 在初始化游戏的时候，还需要做什么？
    }
    public void init(Player p1) {
        this.p1 = p1;
        this.onTurn = p1;

        //TODO: 在初始化游戏的时候，还需要做什么？
    }
    /**
     * 初始化游戏。在开始游戏前，应先调用此方法，给予游戏必要的参数。
     *
     * @param p1 玩家1
     * @param p2 玩家2
     * @param p3 玩家3
     */
    public void init(Player p1,Player p2,Player p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.onTurn = p1;
    }

    /**
     * 进行下一个回合时应调用本方法。
     * 在这里执行每个回合结束时需要进行的操作。
     * <p>
     * (目前这里没有每个玩家进行n回合的计数机制的，请自行修改完成哦~）
     */
    public void nextTurn() {
        if (step % step0 == 0 && step!=0) {
            if (onTurn == p1) {
                onTurn = p2;
            } else if (onTurn == p2) {
                onTurn = p1;
            }
            System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        }
    }
        //scoreBoard.update();
        //TODO: 在每个回合结束的时候，还需要做什么 (例如...检查游戏是否结束？)

    public void nextTurn3() {
        if (step % step0 == 0 && step!=0) {
            if (onTurn == p1) {
                onTurn = p2;
            } else if (onTurn == p2) {
                onTurn = p3;
            } else if (onTurn == p3) {
                onTurn = p1;
            }
            System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        }
    }


    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */
    public Player getOnTurnPlayer() {
        return onTurn;
    }


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
    public Player getP3(){
        return p3;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public ArrayList<GridComponent> getSet() {
        return set;
    }

    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }


    public void setStep0(int step0) {
        this.step0 = step0;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public void readFileData(String fileName) {
        //todo: read date from file

    }

    public void writeDataToFile(String fileName){
        //todo: write data into file
    }


}
