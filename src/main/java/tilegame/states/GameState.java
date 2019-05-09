package tilegame.states;

import tilegame.entities.creatures.Player;
import tilegame.Game;
import tilegame.world.World;

import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;


    public GameState(Game game) {
        super(game);
        player = new Player (game,100,100);
//        world = new World("resources/worlds/world1.txt");
        world = new World("../resources/worlds/world1.txt");
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
