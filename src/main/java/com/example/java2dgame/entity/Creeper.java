package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.lang.Math.sqrt;


public class Creeper extends Entity{
    GamePanel gp;
    Player player;
    public Creeper (GamePanel gamePanel, Player player) throws IOException {
        this.gp = gamePanel;
        this.player = player;
        setDefaultValue();
        getCreeperImage();
    }
    public void setDefaultValue()
    {
        worldX = 500;
        worldY = 500;
        direction = "down";
        speed = 2;
        spriteNum = 1;
    }
    public void getCreeperImage() throws IOException {
        up1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_up_1.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_up_2.png"));
        down1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_down_1.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_down_2.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_left_1.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_left_2.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_right_1.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/mob/boy_right_2.png"));

    }

    public void update()
    {
        double distance =(player.worldX - this.worldX)*(player.worldX - this.worldX) + (player.worldY-this.worldY)*(player.worldY-this.worldY);
        if(distance < 0) distance = -1 * distance;
        System.out.println("distance: " + distance);
        System.out.println("player.x: " + player.worldX);
        System.out.println("player.y: " + player.worldY);
        System.out.println("creeper.x: " + this.worldX);
        System.out.println("creeper.y: " + this.worldY);

        if(distance < 200*200)
        {
            if(player.worldX >= worldX)
            {
                worldX += speed;
                direction = "right";
            }
            else {
                worldX -= speed;
                direction = "left";
            }
            if(player.worldY >= worldY)
            {
                worldY += speed;
                direction = "down";
            }
            else
            {
                worldY -= speed;
                direction = "up";
            }
        }
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

        g2.drawImage(image,worldX,worldY,gp.titleSize,gp.titleSize,null);
    }
}
