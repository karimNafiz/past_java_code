package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private boolean[] keyPresses = new boolean[120];
    public boolean up, down, right , left;

    public void update()
    {
        up = this.keyPresses[KeyEvent.VK_UP] || this.keyPresses[KeyEvent.VK_W];
        down = this.keyPresses[KeyEvent.VK_DOWN] || this.keyPresses[KeyEvent.VK_S];
        right = this.keyPresses[KeyEvent.VK_RIGHT] || this.keyPresses[KeyEvent.VK_D];
        left = this.keyPresses[KeyEvent.VK_LEFT] || this.keyPresses[KeyEvent.VK_A];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyPresses[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyPresses[e.getKeyCode()] = false;
    }
}
