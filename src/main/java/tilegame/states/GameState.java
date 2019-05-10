package tilegame.states;

import tilegame.Handler;
import tilegame.world.World;

import java.awt.*;
import java.io.File;

public class GameState extends State{
    private World world;

    public GameState(Handler handler) {
        super(handler);
        String filePath = new File("").getAbsolutePath();
        world = new World(handler,filePath + "\\src\\main\\resources\\worlds\\world1.txt");
        handler.setWorld(world);
    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics graphics) {
        world.render(graphics);
    }
}
