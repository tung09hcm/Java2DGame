package com.example.java2dgame.titles;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;


public class TitleManager {
    GamePanel gp;
    Title[] title;

    public TitleManager(GamePanel gp)
    {
        this.gp = gp;
        title = new Title[10];
        getTitleImage();

    }
    public void getTitleImage()
    {
        try
        {
            title[0] = new Title();
            title[0].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/brick.png"));

            title[1] = new Title();
            title[1].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/moss_brick.png"));

            title[2] = new Title();
            title[2].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/stonebrick_cracked.png"));

            title[3] = new Title();
            title[3].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/stone.png"));



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        for(int i = 0; i <= gp.screenWidth ; i+= gp.titleSize)
        {
            for(int j = 0; j <= gp.screenHeight ; j+= gp.titleSize)
            {
                g2.drawImage(title[2].image,i,j,gp.titleSize,gp.titleSize,null);
            }
        }


    }
}
