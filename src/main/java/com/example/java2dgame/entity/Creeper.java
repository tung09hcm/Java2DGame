package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static java.lang.Math.sqrt;


public class Creeper extends Entity{
    GamePanel gp;
    Player player;
    public Creeper (GamePanel gamePanel, Player player)
    {
        this.gp = gamePanel;
        this.player = player;
        setDefaultValue();
    }
    public void setDefaultValue()
    {
        x = 200;
        y = 200;
        direction = "down";
        speed = 4;
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
    public double calculateDistance()
    {
        double distance =(player.x - x)*(player.x - x) - (player.y-y)*(player.y-y);
        distance = sqrt(distance);
        return distance;
    }
    public void update()
    {
        if(calculateDistance() < 200)
        {
            if(player.x > x)
            {
                x += speed;
            }
            else if(player.x < x)
            {
                x -= speed;
            }
            if(player.y > y)
            {
                y += speed;
            }
            else if(player.x < y)
            {
                y -= speed;
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        g2.drawImage(down1,x,y,gp.titleSize,gp.titleSize,null);
    }
}
