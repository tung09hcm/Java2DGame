package com.example.java2dgame.titles;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import static com.example.java2dgame.main.GamePanel.titleSize;

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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        for(int i = 0; i <= gp.screenWidth ; i+= titleSize)
        {
            for(int j = 0; j <= gp.screenHeight ; j+= titleSize)
            {
                g2.drawImage(title[0].image,i,j,titleSize,titleSize,null);
            }
        }


    }
}
