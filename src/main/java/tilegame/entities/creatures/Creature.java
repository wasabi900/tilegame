package tilegame.entities.creatures;


import tilegame.Game;
import tilegame.Handler;
import tilegame.entities.Entity;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove,yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    public void move(){
        x +=xMove;
        y +=yMove;
    }

    //GETTERS SETTERS

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public static int getDefaultCreatureWidth() {
        return DEFAULT_CREATURE_WIDTH;
    }

    public static int getDefaultCreatureHeight() {
        return DEFAULT_CREATURE_HEIGHT;
    }

    public static int getDefaultHealth() {
        return DEFAULT_HEALTH;
    }

    public static float getDefaultSpeed() {
        return DEFAULT_SPEED;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
