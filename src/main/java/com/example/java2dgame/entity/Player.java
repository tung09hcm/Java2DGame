package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;
import com.example.java2dgame.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

import static com.example.java2dgame.main.GamePanel.titleSize;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel panel, KeyHandler keyHandler) throws IOException {
        this.gp = panel;
        this.keyH = keyHandler;
        getPlayerImage();
    }

    public void setDefaultValue()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void update()
    {
        if(keyH.upPressed == true)
        {
            y -= speed;
            direction = "up";
        }
        else if (keyH.downPressed == true)
        {
            y += speed;
            direction = "down";
        }
        else if (keyH.leftPressed == true)
        {
            x -= speed;
            direction = "left";
        }
        else if (keyH.rightPressed == true)
        {
            x += speed;
            direction = "right";
        }

        if(x < 0)
        {
            x = 0;
        }
        if(y < 0)
        {
            y = 0;
        }
        if(x + titleSize*2 >= 768)
        {
            x = 768 - titleSize*2;
        }
        if(y + titleSize*2 >= 576)
        {
            y = 576 - titleSize*2;
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        image = up1;
        g2.drawImage(image,x,y,titleSize*2,titleSize*2,null);
    }
    public void getPlayerImage() throws IOException {
        up1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/knight.png"));


    }
}
