package com.example.java2dgame.main;

import com.example.java2dgame.entity.Entity;

public class CollisonChecker {
    GamePanel gp;
    public CollisonChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    public void checkTitle(Entity entity)
    {

        int y_f;
        int x_f;
        switch(entity.direction)
        {

            case "up" :
                y_f = entity.worldY/gp.titleSize - 1;
                x_f = entity.worldX/gp.titleSize;
                if(y_f < 0)
                {
                    entity.CollisionOn = true;
                    break;
                }
                if(gp.titleManager.title[gp.titleManager.mapTitleNum[y_f][x_f]].collison)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "down" :
                y_f = entity.worldY/gp.titleSize + 1;
                if(y_f > gp.maxWorldRow)
                {
                    entity.CollisionOn = true;
                    break;
                }
                x_f = entity.worldX/gp.titleSize;
                if(gp.titleManager.title[gp.titleManager.mapTitleNum[y_f][x_f]].collison)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "left" :
                y_f = entity.worldY/gp.titleSize;
                x_f = entity.worldX/gp.titleSize-1;
                if(x_f < 0)
                {
                    entity.CollisionOn = true;
                    break;
                }
                if(gp.titleManager.title[gp.titleManager.mapTitleNum[y_f][x_f]].collison)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "right" :
                y_f = entity.worldY/gp.titleSize;
                x_f = entity.worldX/gp.titleSize+1;
                if(x_f > gp.maxWorldCol)
                {
                    entity.CollisionOn = true;
                    break;
                }
                if(gp.titleManager.title[gp.titleManager.mapTitleNum[y_f][x_f]].collison)
                {
                    entity.CollisionOn = true;
                }
                break;
        }
    }
}
