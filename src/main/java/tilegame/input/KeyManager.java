package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public boolean[] keys;
    public boolean up,down,left,right;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    public void keyTyped(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed!");
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        System.out.println("Released!");
    }
}
