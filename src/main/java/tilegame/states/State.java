package tilegame.states;

import tilegame.Handler;

import java.awt.*;

public abstract class State {

    private static State state;
    protected Handler handler;

    public static void setState(State currentState) {
        State.state = currentState;
    }

    public static State getState() {
        return state;
    }

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
}