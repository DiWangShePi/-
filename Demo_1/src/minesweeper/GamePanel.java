package minesweeper;

import components.GridComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private GridComponent[][] mineField;
    private int[][] chessboard;
    private final Random random = new Random();
    private int x;
    private int y;
    private int Mcount;

    /**
     * 初始化一个具有指定行列数格子、并埋放了指定雷数的雷区。
     *
     * @param xCount    count of grid in column
     * @param yCount    count of grid in row
     * @param mineCount mine count
     */
    public GamePanel(int xCount, int yCount, int mineCount) {
        this.Mcount=mineCount;

        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setSize(GridComponent.gridSize * yCount, GridComponent.gridSize * xCount);

        initialGame(xCount, yCount, mineCount);

        repaint();
    }

    public void initialGame(int xCount, int yCount, int mineCount) {
        mineField = new GridComponent[xCount][yCount];

        generateChessBoard(xCount, yCount, mineCount);

        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                GridComponent gridComponent = new GridComponent(i, j);
                gridComponent.setContent(chessboard[i][j]);
                gridComponent.setLocation(j * GridComponent.gridSize , i * GridComponent.gridSize);
                mineField[i][j] = gridComponent;
                this.add(mineField[i][j]);
            }
        }
    }


    public void generateChessBoard(int xCount, int yCount, int mineCount) {
        //todo: generate chessboard by your own algorithm
        chessboard = new int[xCount][yCount];
        Random rand=new Random();
        boolean condition;
        do {for (int i=0;i<mineCount;) {
            int r = rand.nextInt(xCount);
            int c = rand.nextInt(yCount);
            if (chessboard[r][c] != -1) {
                chessboard[r][c] = -1;
                i++;
            }
        }
        int mines=0;
        condition=true;
        for(int x = 1;x<xCount-1;x++)
            for(int y=0;y<yCount;y++){
                for(int m=x-1;m<=x+1;m++)
                    for(int n=0;n<yCount;n++){
                        if(((m-x)*(m-x)+ (n-y)*(n-y) < 4)  && chessboard[m][n]==-1)
                          mines++;
                        if(mines>=9){
                            condition=false;
                        }
                        mines=0;
                    }
            }

        }
        while (condition==false);

        int b=0;
        for (int x = 0; x < xCount; x++)
            for (int y = 0; y < yCount; y++) {
                if (chessboard[x][y]== -1 )
                    chessboard[x][y] = -1;
                if(chessboard[x][y]== 0)
                    if(x>0 && x<xCount-1){
                        for(int m=x-1;m<=x+1;m++)
                            for(int n=0;n<yCount;n++){
                                if(((m-x)*(m-x)+ (n-y)*(n-y) < 4)  && chessboard[m][n]==-1)
                                    b++;
                                chessboard[x][y]=b;}
                    }
                if(x==0 && chessboard[x][y]==0){
                    for(int m=0;m<=1;m++)
                        for(int n=0;n<yCount;n++){
                            if(((m-x)*(m-x)+ (n-y)*(n-y) < 4)  && chessboard[m][n]==-1)
                                b++;
                            chessboard[x][y]=b;}
                }
                if(x==xCount-1 && chessboard[x][y]==0){
                    for(int m=xCount-2;m<xCount;m++)
                        for(int n=0;n<yCount;n++){
                            if(((m-x)*(m-x)+ (n-y)*(n-y) < 4)  && chessboard[m][n]==-1)
                                b++;
                            chessboard[x][y]=b;}
                }
                b=0;
            }

    }

    /**
     * 获取一个指定坐标的格子。
     * 注意请不要给一个棋盘之外的坐标哦~
     *
     * @param x 第x列
     * @param y 第y行
     * @return 该坐标的格子
     */
    public GridComponent getGrid(int x, int y) {
        try {
            return mineField[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public int[][] getChessboard() {
        return chessboard;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getMcount() {
        return Mcount;
    }
}
