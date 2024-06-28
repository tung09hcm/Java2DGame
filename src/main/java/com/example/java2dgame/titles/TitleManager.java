package com.example.java2dgame.titles;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;


public class TitleManager {
    GamePanel gp;
    Title[] title;
    int mapTitleNum[][];

    public TitleManager(GamePanel gp)
    {
        this.gp = gp;

        title = new Title[10];
        mapTitleNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        loadMap("/com/example/java2dgame/map/world01.txt");
        getTitleImage();

    }
    public void loadMap(String fileName)
    {
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            System.err.println("Could not find file: " + fileName);
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int i = 0;
            int j = 0;
            while ((line = br.readLine()) != null) {
                //                                                                                                                                                                                                                                                                          System.out.println(line);
                String[] numbers = line.split(" ");
                for(String number: numbers)
                {
                    mapTitleNum[i][j] = Integer.parseInt(number);
                    j++;
                }
                j=0;
                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void getTitleImage()
    {
        try
        {
            title[0] = new Title();
            title[0].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/dirt.png"));

            title[1] = new Title();
            title[1].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/sand.png"));

            title[2] = new Title();
            title[2].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/tree.png"));

            title[3] = new Title();
            title[3].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/moss_brick.png"));

            title[4] = new Title();
            title[4].image = ImageIO.read(getClass().getResourceAsStream("/com/example/java2dgame/titles/brick.png"));




        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2)
    {
        int i_i = 0;
        int j_j = 0;
        for(int i = 0; i < gp.maxWorldRow ; i++)
        {
            for(int j = 0; j < gp.maxWorldCol ; j++)
            {
                g2.drawImage(title[mapTitleNum[i][j]].image,i_i,j_j,gp.titleSize,gp.titleSize,null);
                i_i += gp.titleSize;
            }
            i_i = 0;
            j_j += gp.titleSize;
        }


    }
}
