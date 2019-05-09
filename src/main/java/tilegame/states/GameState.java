package tilegame.states;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.Game;
import tilegame.world.World;

import java.awt.*;
import java.io.File;

public class GameState extends State{

    private Player player;
    private World world;


    public GameState(Handler handler) {
        super(handler);
        String filePath = new File("").getAbsolutePath();
        world = new World(handler,filePath + "\\src\\main\\resources\\worlds\\world1.txt");
        handler.setWorld(world);
        player = new Player (handler,100,100);


    }

    public void tick() {
        world.tick();
        player.tick();

    }

    public void render(Graphics graphics) {

        world.render(graphics);
        player.render(graphics);


    }
}
