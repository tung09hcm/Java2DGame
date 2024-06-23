package com.example.java2dgame.main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    int FPS = 60;
    final int originTitleSize = 16;
    final int scale = 3;
    final int titleSize = originTitleSize * scale; // 48 x 48 (pixel)
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol; // 768 (pixel)
    final int screenHeight = titleSize * maxScreenRow; // 576 (pixel)
    Thread gamethread;
    KeyHandler keyH = new KeyHandler();
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

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
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawtime = System.nanoTime() + drawInterval;

        while(gamethread != null)
        {
            // as long as gameThread still exist it will run in this while
            // System.out.println("this game is running");
            // 1. Update: update information such as player information
            update();
            // 2. Draw: draw the screen with the update information
            repaint();
            try
            {
                double remainingTime = nextDrawtime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawtime += drawInterval;
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }

    public void update()
    {
        if(keyH.upPressed == true)
        {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed == true)
        {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed == true)
        {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true)
        {
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(playerX,playerY,titleSize,titleSize);
        g2.dispose(); // save memory
    }
}
