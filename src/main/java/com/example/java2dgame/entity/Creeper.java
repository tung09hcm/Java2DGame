package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
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
        x = 500;
        y = 500;
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
        double distance =(player.x - this.x)*(player.x - this.x) + (player.y-this.y)*(player.y-this.y);
        if(distance < 0) distance = -1 * distance;
        System.out.println("distance: " + distance);
        System.out.println("player.x: " + player.x);
        System.out.println("player.y: " + player.y);
        System.out.println("creeper.x: " + this.x);
        System.out.println("creeper.y: " + this.y);

        if(distance < 200*200)
        {
            if(player.x >= x)
            {
                x += speed;
            }
            else {
                x -= speed;
            }
            if(player.y >= y)
            {
                y += speed;
            }
            else
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
