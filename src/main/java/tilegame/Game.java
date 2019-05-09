package tilegame;

import tilegame.display.Display;
import tilegame.gfx.Assets;
import tilegame.gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.states.GameState;
import tilegame.states.MenuState;
import tilegame.states.SettingsState;
import tilegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private int width,height;
    public String title;

    private boolean running;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    //States
    private State gameState;
    private State menuState;
    private State settingsState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //Handler

    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }


    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this,0,0);
        handler = new Handler(this);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);

        State.setCurrentState(gameState);
    }


    private void tick(){
        keyManager.tick();
        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }
    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bufferStrategy.getDrawGraphics();

        //letakarítjuk a képernyőt mindig mielőtt rajzolunk
        graphics.clearRect(0,0,width,height);

        //rajzolunk
        if(State.getCurrentState() != null){
            State.getCurrentState().render(graphics);
        }

        bufferStrategy.show();
        graphics.dispose();

    }

    /**
     * start method indítja a runt, ami indítja az initet,
     * initel minden és loopolja a gamet.
     */
    public void run(){
        init();

        //Frame per second. Logikus.
        int fps = 60;

        //nanosecond/fps, számítógépes cuccokat nem másodpercben hanem nanomásodpercben mérjük 1sec/fps
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        //visszaadja aktuális idő nanosecben.
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }



    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public void setGameCamera(GameCamera gameCamera) {
        this.gameCamera = gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * amikor indítjuk a játékot(THREADET) akkor check ha már fut.
     * ugyan stopnál.
     */
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
