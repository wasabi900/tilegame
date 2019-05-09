package tilegame.states;

import tilegame.Game;

import java.awt.*;

public abstract class State {

    private static State currentState;

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public static State getCurrentState() {
        return currentState;
    }

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);


}
