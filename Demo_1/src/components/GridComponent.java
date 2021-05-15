package components;

import MainFrame.abstractFrame;
import entity.GridStatus;
import entity.Player;
import MainFrame.MainFrame;
import controller.GameController;
import minesweeper.GamePanel;
import minesweeper.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static MainFrame.abstractFrame.players;

public class GridComponent extends BasicComponent {
    public static int gridSize = 30;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image1 = toolkit.getImage("icon.png");



    private int row;
    private int col;
    private GridStatus status = GridStatus.Covered;
    private int content = 0;
    int step=0;

    public GridComponent(int x, int y) {
        this.setSize(gridSize, gridSize);
        this.row = x;
        this.col = y;
    }

    @Override
    public void onMouseLeftClicked() {
        int[][] chessboard = abstractFrame.controller.getGamePanel().getChessboard();
        int x;
        int y;//联开


        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if(players.size()==2) {
            if (this.status == GridStatus.Covered && this.content == -1) {
                this.status = GridStatus.Boom;
                repaint();
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                    players.get(0).costScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                    players.get(1).costScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update();
                }
                abstractFrame.controller.nextTurn();
            }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Clicked;
                repaint();
                abstractFrame.controller.nextTurn();
            }
        }
        if(players.size()==1){
            if (this.status == GridStatus.Covered && this.content == -1) {
                this.status = GridStatus.Boom;
                repaint();
                players.get(0).costScore();
                ScoreBoard e=abstractFrame.controller.getScoreBoard();
                e.update1();

            }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Clicked;
                repaint();
            }
        }
        if(players.size()==3) {
            if (this.status == GridStatus.Covered && this.content == -1) {
                this.status = GridStatus.Boom;
                repaint();
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                    players.get(0).costScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                    players.get(1).costScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(2)){
                    players.get(2).costScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                abstractFrame.controller.nextTurn3();
            }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Clicked;
                repaint();
                abstractFrame.controller.nextTurn3();
            }
        }
        abstractFrame.controller.setStep(abstractFrame.controller.getStep()+1);
        GridComponent p =abstractFrame.controller.getGamePanel().getGrid(this.row,this.col);
        abstractFrame.controller.getSet().add(p);
        int sum=0;
        for(int i=0;i<abstractFrame.controller.getSet().size();i++){
            if(abstractFrame.controller.getSet().get(i).status!=GridStatus.Covered && abstractFrame.controller.getSet().get(i).content==-1){
                sum++;
                if(sum==abstractFrame.controller.getGamePanel().getMcount()){
                    System.out.print("GAME OVER");
                    SHOW();
                }
            }
        }



        //TODO: 在左键点击一个格子的时候，还需要做什么？
    }
    public void SHOW(){
        JFrame frame =new JFrame();
        JTextField textField = new JTextField();
        frame.setTitle("排行榜");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        for(int i=0;i< players.size()-1 ;i++){
            for(int j = 0;j<players.size()-1;j++){
                int first=players.get(j).getScore();
                int second=players.get(j+1).getScore();
                if(first<second){
                    Collections.swap(players,j,j+1);
                }
                if(first==second){
                    if(players.get(j).getMistake()>players.get(j+1).getMistake())
                        Collections.swap(players,j,j+1);
                }

            }
        }
        for(int i=0;i<players.size();i++){
            JTextField f =new JTextField();
            f.setText(i+1 + "" + players.get(i).getUserName() + "\n");
            f.setSize(400,400/players.size());
            f.setLocation(0,400/players.size() * i - 30);
            abstractFrame.controller.getTextFields().add(f);
        }
        for (int i=0;i<abstractFrame.controller.getTextFields().size();i++){
            frame.add(abstractFrame.controller.getTextFields().get(i));
        }
        frame.setVisible(true);
        frame.add(BorderLayout.NORTH,textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onMouseRightClicked() {
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row, col);
        if(players.size()==2){
        if (this.status == GridStatus.Covered && this.content==-1) {
            this.status = GridStatus.Correct;
            repaint();
            if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                players.get(0).addScore();
                ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                e1.update();
            }
            if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                players.get(1).addScore();
                ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                e1.update();
            }
            abstractFrame.controller.nextTurn();
        }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Wrong;
                repaint();
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                    players.get(0).addMistake();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                    players.get(1).addMistake();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update();
                }
                abstractFrame.controller.nextTurn();
            }
        }
        if(players.size()==1){
            if (this.status == GridStatus.Covered && this.content==-1) {
                this.status = GridStatus.Correct;
                repaint();
                players.get(0).addScore();
                players.get(0).getMistake();
                ScoreBoard e=abstractFrame.controller.getScoreBoard();
                e.update1();
            }
            if(this.status == GridStatus.Covered && this.content!=-1){
                this.status = GridStatus.Wrong;
                repaint();
                players.get(0).addMistake();
                players.get(0).getMistake();
                ScoreBoard e=abstractFrame.controller.getScoreBoard();
                e.update1();
            }
        }
        if(players.size()==3){
            if (this.status == GridStatus.Covered && this.content==-1) {
                this.status = GridStatus.Correct;
                repaint();
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                    players.get(0).addScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                    players.get(1).addScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(2)){
                    players.get(2).addScore();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                abstractFrame.controller.nextTurn3();
            }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Wrong;
                repaint();
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(0)){
                    players.get(0).addMistake();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(1)){
                    players.get(1).addMistake();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                if(abstractFrame.controller.getOnTurnPlayer()==players.get(2)){
                    players.get(2).addMistake();
                    ScoreBoard e1 =abstractFrame.controller.getScoreBoard();
                    e1.update2();
                }
                abstractFrame.controller.nextTurn3();
            }
        }
        abstractFrame.controller.setStep(abstractFrame.controller.getStep()+1);
        GridComponent p =abstractFrame.controller.getGamePanel().getGrid(this.row,this.col);
        abstractFrame.controller.getSet().add(p);
        int sum=0;
        for(int i=0;i<abstractFrame.controller.getSet().size();i++){
            if(abstractFrame.controller.getSet().get(i).status!=GridStatus.Covered && abstractFrame.controller.getSet().get(i).content==-1){
                sum++;
                if(sum==abstractFrame.controller.getGamePanel().getMcount()){
                    System.out.print("GAME OVER");
                    SHOW();
                }
            }
        }


        //TODO: 在右键点击一个格子的时候，还需要做什么？
    }

    public void draw(Graphics g) {

        if (this.status == GridStatus.Covered) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
        if (this.status == GridStatus.Clicked) {

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth() -1, getHeight() -1);
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Correct) {

            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.GREEN);
            g.drawString("R", getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Wrong) {

            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.RED);
            g.drawString("W", getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if(this.status==GridStatus.Boom){
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.drawImage(image1,getWidth() / 2-17 , getHeight() / 2-18 ,35,35,this);
        }
    }

    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        draw(g);
    }

    public int getStep() {
        return step;
    }
}
