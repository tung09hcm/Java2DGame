package com.example.java2dgame.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    // this store variables that are used for player, monster and NPC
    public int worldX, worldY;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean CollisionOn = false;

}
