package com.example.java2dgame.entity;

import com.example.java2dgame.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Creeper extends Entity{
    GamePanel gp;
    public Creeper (GamePanel gamePanel)
    {
        this.gp = gamePanel;
        setDefaultValue();
    }
    public void setDefaultValue()
    {
        x = 300;
        y = 300;
        direction = "down";
        speed = 4;
        spriteNum = 1;
    }
    public void getCreeperImage() throws IOException {
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
