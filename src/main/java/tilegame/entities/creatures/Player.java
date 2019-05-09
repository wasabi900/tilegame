package tilegame.entities.creatures;


import tilegame.Game;
import tilegame.Handler;
import tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(Handler handler , float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up )
            yMove = -speed;
        if(handler.getKeyManager().down )
            yMove = speed;
        if(handler.getKeyManager().left )
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }

    public void render(Graphics graphics) {

        graphics.drawImage(Assets.player,(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
