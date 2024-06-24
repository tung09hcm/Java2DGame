package com.example.java2dgame.main;
import com.example.java2dgame.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    int FPS = 120;
    public static final int originTitleSize = 16;
    public static final int scale = 3;
    public static final int titleSize = originTitleSize * scale; // 48 x 48 (pixel)
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = titleSize * maxScreenCol; // 768 (pixel)
    public final int screenHeight = titleSize * maxScreenRow; // 576 (pixel)

    Thread gamethread;
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this,keyH);



    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public void startGameThread()
    {
        gamethread = new Thread(this);
        gamethread.start();
    }

    public GamePanel() throws IOException {
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
        player.setDefaultValue();
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
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        g2.dispose(); // save memory
    }
}
