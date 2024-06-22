package com.example.java2dgame.main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originTitleSize = 16;
    final int scale = 3;
    final int titleSize = originTitleSize * scale; // 48 x 48 (pixel)
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol; // 768 (pixel)
    final int screenHeight = titleSize * maxScreenRow; // 576 (pixel)
    Thread gamethread;

    public void startGameThread()
    {
        gamethread = new Thread(this);
        gamethread.start();
    }

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    @Override
    public void run() {

        while(gamethread != null)
        {
            // as long as gameThread still exist it will run in this while
            System.out.println("This game is running");
        }
    }
}
