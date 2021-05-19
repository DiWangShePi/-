package components;

import MainFrame.abstractFrame;
import entity.GridStatus;
import MainFrame.Select;
import entity.Player;
import MainFrame.MainFrame;
import controller.GameController;
import minesweeper.GamePanel;
import minesweeper.ScoreBoard;
import icons.Play;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static MainFrame.abstractFrame.players;

public class GridComponent extends BasicComponent {
    public static int gridSize = 30;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image1 = toolkit.getImage("mine.png");
    ImageIcon image2=new ImageIcon("blackboard.png");
    Color color=new Color(146, 17, 203);
    Color color2=new Color(80, 6, 191, 255);
    Color color3=new Color(182, 63, 8);
    Color color4=new Color(167, 43, 43);
    Font font=new Font("Britannic Bold",Font.BOLD,15);
    Select select;




    private int row;
    private int col;
    private GridStatus status = GridStatus.Covered;
    private int content = 0;
    int step=0;
    Font rank=new Font("华文琥珀",Font.BOLD,40);

    public GridComponent(int x, int y) {
        this.setSize(gridSize, gridSize);
        this.row = x;
        this.col = y;
    }

    @Override
    public void onMouseLeftClicked() {
        GridComponent p =abstractFrame.controller.getGamePanel().getGrid(this.row,this.col);
        abstractFrame.controller.getSet().add(p);
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if(players.size()==2) {
            if(this.status==GridStatus.Covered && this.content==0) {
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                open(row,col);}
            if (this.status == GridStatus.Covered && this.content == -1) {
                this.status = GridStatus.Boom;
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("boom.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("砸砖.mp3").start();
                }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                repaint();
                abstractFrame.controller.nextTurn();
            }
        }
        if(players.size()==1){
            if(this.status==GridStatus.Covered && this.content==0) {
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
            open(row,col);}
            if (this.status == GridStatus.Covered && this.content == -1) {
                this.status = GridStatus.Boom;
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("boom.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("砸砖.mp3").start();
                }
                repaint();
                players.get(0).costScore();
                ScoreBoard e=abstractFrame.controller.getScoreBoard();
                e.update1();

            }
            if (this.status == GridStatus.Covered && this.content!=-1) {
                this.status = GridStatus.Clicked;
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                repaint();
            }
        }
        if(players.size()==3) {
            if(this.status==GridStatus.Covered && this.content==0) {
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                open(row,col);}
            if (this.status == GridStatus.Covered && this.content == -1) {
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("boom.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("砸砖.mp3").start();
                }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                repaint();
                abstractFrame.controller.nextTurn3();
            }
        }
        abstractFrame.controller.setStep(abstractFrame.controller.getStep()+1);
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
    public void open(int i, int j){
        if(abstractFrame.controller.getGamePanel().getGrid(i,j).getStatus()!=GridStatus.Covered){
            return;
        }
        if(abstractFrame.controller.getGamePanel().getGrid(i,j).getStatus()==GridStatus.Covered){
            abstractFrame.controller.getGamePanel().getGrid(i,j).setStatus(GridStatus.Clicked);
            abstractFrame.controller.getGamePanel().getGrid(i,j).repaint();
        }

        if( abstractFrame.controller.getGamePanel().getGrid(i,j).content==0){
            if(i>0 &&j>0 && abstractFrame.controller.getGamePanel().getGrid(i-1,j-1).content==0)
                open(i-1,j-1);
            if(i>0  && abstractFrame.controller.getGamePanel().getGrid(i-1,j).content==0)
                open(i-1,j);
            if(i>0 &&j<abstractFrame.controller.getGamePanel().getChessboard()[0].length-1 && abstractFrame.controller.getGamePanel().getGrid(i-1,j+1).content==0)
                open(i-1,j+1);
            if(j>0 && abstractFrame.controller.getGamePanel().getGrid(i,j-1).content==0)
                open(i,j-1);
            if(j<abstractFrame.controller.getGamePanel().getChessboard()[0].length-1 && abstractFrame.controller.getGamePanel().getGrid(i,j+1).content==0)
                open(i,j+1);
            if(i<abstractFrame.controller.getGamePanel().getChessboard().length-1 &&j>0 && abstractFrame.controller.getGamePanel().getGrid(i+1,j-1).content==0)
                open(i+1,j-1);
            if(i<abstractFrame.controller.getGamePanel().getChessboard().length-1  && abstractFrame.controller.getGamePanel().getGrid(i+1,j).content==0)
                open(i+1,j);
            if(i<abstractFrame.controller.getGamePanel().getChessboard().length-1 &&j<abstractFrame.controller.getGamePanel().getChessboard()[0].length-1 && abstractFrame.controller.getGamePanel().getGrid(i+1,j+1).content==0)
                open(i+1,j+1);

        }


    }
    public void SHOW(){
        JFrame frame =new JFrame();
        JTextField textField = new JTextField();
        frame.setTitle("排行榜");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        JLabel back=new JLabel(image2);
        frame.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
        back.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
        Container container =frame.getContentPane();
        ((JPanel) container).setOpaque(false);
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
            JLabel f =new JLabel();
            f.setText(i+1 + "" +"    "+ players.get(i).getUserName() + "\n");
            f.setFont(rank);
            f.setForeground(Color.WHITE);
            f.setSize(400,400/players.size());
            f.setLocation(0,400/players.size() * i - 30);
            abstractFrame.controller.getLabels().add(f);
        }
        for (int i=0;i<abstractFrame.controller.getLabels().size();i++){
            frame.add(abstractFrame.controller.getLabels().get(i));
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
            if(abstractFrame.controller.getSelect().getChosen()==1){
                new Play("jiguang.mp3").start();}
            if(abstractFrame.controller.getSelect().getChosen()==2){
                new Play("开砖.mp3").start();
            }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
                repaint();
                players.get(0).addScore();
                players.get(0).getMistake();
                ScoreBoard e=abstractFrame.controller.getScoreBoard();
                e.update1();
            }
            if(this.status == GridStatus.Covered && this.content!=-1){
                this.status = GridStatus.Wrong;
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
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
                if(abstractFrame.controller.getSelect().getChosen()==1){
                    new Play("jiguang.mp3").start();}
                if(abstractFrame.controller.getSelect().getChosen()==2){
                    new Play("开砖.mp3").start();
                }
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

        if(abstractFrame.controller.getSelect().getChosen()==1) {
            if (this.status == GridStatus.Covered) {
                g.setColor(color);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
            if (this.status == GridStatus.Clicked) {

                g.setColor(color2);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.black);
                g.setFont(new Font("华文彩云", Font.BOLD, 23));
                g.drawString(Integer.toString(content), getWidth() / 2 - 7, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Correct) {

                g.setColor(color2);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.GREEN);
                g.setFont(new Font("华文彩云", Font.BOLD, 25));
                g.drawString("R", getWidth() / 2 - 10, getHeight() / 2 + 8);
            }
            if (this.status == GridStatus.Wrong) {

                g.setColor(color2);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.RED);
                g.setFont(new Font("华文彩云", Font.BOLD, 25));
                g.drawString("W", getWidth() / 2 - 10, getHeight() / 2 + 8);
            }
            if (this.status == GridStatus.Boom) {
                g.setColor(color2);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.drawImage(image1, getWidth() / 2 - 17, getHeight() / 2 - 18, 35, 35, this);
            }
        }
        if(abstractFrame.controller.getSelect().getChosen()==2){
            if (this.status == GridStatus.Covered) {
                g.setColor(color3);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
            if (this.status == GridStatus.Clicked) {

                g.setColor(color4);
                g.fillRect(0, 0, getWidth() -1, getHeight() -1);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Correct) {

                g.setColor(color4);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.ORANGE);
                g.setFont(font);
                g.drawString("R", getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Wrong) {

                g.setColor(color4);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.RED);
                g.setFont(font);
                g.drawString("W", getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if(this.status==GridStatus.Boom){
                g.setColor(color4);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.drawImage(image1,getWidth() / 2-17 , getHeight() / 2-18 ,35,35,this);
            }

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

    public GridStatus getStatus() {
        return status;
    }

    public void setStatus(GridStatus status) {
        this.status = status;
    }

    public int getStep() {
        return step;
    }

    public int getContent() {
        return content;
    }





}
