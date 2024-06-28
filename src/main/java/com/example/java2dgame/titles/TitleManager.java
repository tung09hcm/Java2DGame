package com.example.java2dgame.titles;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;


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
            title[1].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/dirt.png"));

            title[2] = new Title();
            title[2].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/tree.png"));

            title[3] = new Title();
            title[3].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/moss_brick.png"));

            title[4] = new Title();
            title[4].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/sand.png"));




        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        int i = 0;
        int j = 0;
        String fileName = "/com/example/java2dgame/map/map01.txt";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            System.err.println("Could not find file: " + fileName);
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                //                                                                                                                                                                                                                                                                          System.out.println(line);
                String[] numbers = line.split(" ");
                for(String number: numbers)
                {
                    g2.drawImage(title[Integer.parseInt(number)].image,i,j,gp.titleSize,gp.titleSize,null);
                    i += gp.titleSize;
                }
                i = 0;
                j += gp.titleSize;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
