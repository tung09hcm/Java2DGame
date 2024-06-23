package com.example.java2dgame.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
            System.out.println("SPACE == TRUE");
        }
        else if(code == KeyEvent.VK_W)
        {
            upPressed = true;
            System.out.println("upPressed: " + upPressed);
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = true;
            System.out.println("downPressed: " + downPressed);
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
            System.out.println("leftPressed: " + leftPressed);
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
            System.out.println("rightPressed: " + rightPressed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE)
        {
            System.out.println("SPACE == FALSE");
            spacePressed = false;
        }
        else if(code == KeyEvent.VK_W)
        {
            upPressed = false;
            System.out.println("upPressed: " + upPressed);
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
            System.out.println("downPressed: " + downPressed);
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
            System.out.println("leftPressed: " + leftPressed);
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
            System.out.println("rightPressed: " + rightPressed);
        }
    }
}
