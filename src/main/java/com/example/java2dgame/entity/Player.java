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

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = gp.titleSize/4*3;
        solidArea.height = gp.titleSize/4*3;
    }
    public void setDefaultValue() {
        worldX = gp.titleSize * 19;
        worldY = gp.titleSize * 4;
        speed = 8;
        direction = "down";
        spriteNum = 1;
    }
    public void update() {
        CollisionOn = false;
        //gp.cChecker.checkTitle(this);
        if(keyH.upPressed && worldY != 0)
        {
            spriteCounter++;
            direction = "up";
            gp.cChecker.checkTitle(this);
            if(!CollisionOn) worldY -= speed;

        }
        else if (keyH.downPressed && worldY/gp.titleSize != gp.maxWorldRow - 1)
        {
            spriteCounter++;
            direction = "down";
            gp.cChecker.checkTitle(this);
            if(!CollisionOn) worldY += speed;

        }
        else if (keyH.leftPressed && worldX != 0)
        {
            spriteCounter++;
            direction = "left";
            gp.cChecker.checkTitle(this);
            if(!CollisionOn) worldX -= speed;
        }
        else if (keyH.rightPressed && worldX/gp.titleSize != gp.maxWorldCol - 1)
        {
            spriteCounter++;
            direction = "right";
            gp.cChecker.checkTitle(this);
            if(!CollisionOn) worldX += speed;

        }



        if(spriteCounter > 120)
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
        // System.out.println("player: " + worldX/gp.titleSize + ", " + worldY/gp.titleSize);
        // System.out.println("title#: " + gp.titleManager.mapTitleNum[worldY/gp.titleSize][worldX/gp.titleSize]);



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
