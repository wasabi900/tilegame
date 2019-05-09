package tilegame.states;

import tilegame.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState;

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public static State getCurrentState() {
        return currentState;
    }

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);


}
