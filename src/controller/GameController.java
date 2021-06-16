package controller;

import MainFrame.Select;
import components.GridComponent;
import entity.GridStatus;
import minesweeper.GamePanel;
import entity.Player;
import minesweeper.ScoreBoard;
import MainFrame.abstractFrame;
import java.io.* ;


import javax.swing.*;
import java.util.ArrayList;


public class GameController  {
    private static final long serialVersionUID = 715919700682963666L;

    private Player p1;
    private Player p2;
    private Player p3;

    private Player onTurn;

    private int step0;
    private int step=1;


    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;
    ArrayList<GridComponent> set = new ArrayList<>();
    ArrayList<JLabel> labels=new ArrayList<>();
    Select select=new Select();

    public Select getSelect() {
        return select;
    }



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

    public ArrayList<JLabel> getLabels() {
        return labels;
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
    public void save(String string) throws IOException {
        File file = new File(String.format("/Users/lee/IdeaProjects/CS102A-AeroplaneChess/file/%s.txt", string));
        PrintWriter pw = new PrintWriter(file);
        for (String s : getallchesspiece()) {
            pw.println(s);
        }
        pw.println(this.getOnTurnPlayer());
        pw.close();
        PrintWriter sc=new PrintWriter(file);
        for(String s : getscoreDetail()){
            sc.println(s);
        }
        sc.close();
    }

    public void load(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        ArrayList pieces = new ArrayList();
        String str;
        while ((str = bf.readLine()) != null) {
            if (str.length() > 1) {
                pieces.add(str);
            }
        }
        bf.close();
        fr.close();
        getGamePanel().resetGame(pieces);
        getScoreBoard().reset(pieces);
    }
    public ArrayList<String> getallchesspiece() {
        ArrayList<String> chesspiece = new ArrayList<>();
        for (int row = 0; row <= abstractFrame.controller.getGamePanel().getChessboard().length; row++) {
            for (int col = 0; col <= abstractFrame.controller.getGamePanel().getChessboard()[0].length; col++) {
                chesspiece.add(String.format("%s %d %d %d", abstractFrame.controller.getGamePanel().getGrid(row, col).getStatus(), abstractFrame.controller.getGamePanel().getGrid(row, col).getContent(), row, col));
            }
        }
        return chesspiece;
    }
    public ArrayList<String> getscoreDetail(){
        ArrayList<String>detail = new ArrayList<>();
        for(int i=0;i<abstractFrame.players.size();i++){
            detail.add(String.format("%s %d %d ",abstractFrame.players.get(i).getUserName(),abstractFrame.players.get(i).getScore(),abstractFrame.players.get(i).getMistake()));
        }
        return detail;
    }

    public void setSelect(Select select) {
        this.select = select;
    }
}
