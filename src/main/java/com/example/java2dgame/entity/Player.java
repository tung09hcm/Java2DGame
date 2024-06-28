package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;
import com.example.java2dgame.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;



public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel panel, KeyHandler keyHandler) throws IOException {
        this.gp = panel;
        this.keyH = keyHandler;
        screenX = gp.screenWidth/2 - gp.titleSize/2;
        screenY = gp.screenHeight/2 - gp.titleSize/2;
        getPlayerImage();
    }

    public void setDefaultValue()
    {
        worldX = gp.titleSize * 23;
        worldY = gp.titleSize * 21;
        speed = 4;
        direction = "down";
        spriteNum = 1;
    }
    public void update()
    {
        if(keyH.upPressed == true)
        {
            worldY -= speed;
            direction = "up";
            // keyH.upPressed = false;
        }
        else if (keyH.downPressed == true)
        {
            worldY += speed;
            direction = "down";
            // keyH.downPressed = false;
        }
        else if (keyH.leftPressed == true)
        {
            worldX -= speed;
            direction = "left";
            // keyH.leftPressed = false;
        }
        else if (keyH.rightPressed == true)
        {
            worldX += speed;
            direction = "right";
            // keyH.rightPressed = false;
        }

        //        if(x < 0)
//        {
//            x = 0;
//        }
//        if(y < 0)
//        {
//            y = 0;
//        }
//        if(x + gp.titleSize >= 768)
//        {
//            x = 768 - gp.titleSize;
//        }
//        if(y + gp.titleSize >= 576)
//        {
//            y = 576 - gp.titleSize;
//        }
        spriteCounter++;
        if(spriteCounter > 12)
        {
           if(spriteNum == 1)
           {
               spriteNum = 2;
           }
           else if (spriteNum == 2)
           {
               spriteNum = 1;
           }
        }

    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        if(direction == "up")
        {
            if(spriteNum == 1) image = up1;
            else image = up2;
        }
        else if (direction == "down")
        {
            if(spriteNum == 1 )image = down1;
            else image = down2;
        }
        else if (direction == "left")
        {
            if(spriteNum == 1 )image = left1;
            else image = left2;
        }
        else if (direction == "right")
        {
            if(spriteNum == 1 )image = right1;
            else image = right2;
        }

        g2.drawImage(image,screenX,screenY,gp.titleSize,gp.titleSize,null);
    }
    public void getPlayerImage() throws IOException {

        up1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_up_1.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_up_2.png"));
        down1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_down_1.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_down_2.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_left_1.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_left_2.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_right_1.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/player/boy_right_2.png"));

    }
}
