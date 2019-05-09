package tilegame.display;

import javax.swing.JFrame;
import java.awt.*;

public class Display {

    /**
     * ablakunk
     */
    private JFrame frame;

    /**
     * "vászon"
     */
    private Canvas canvas;

    private String title;
    private int width,height;

    private void createDisplay(){
        /**
         * új ablak, megkapja a címet paraméterként
         */
        frame = new JFrame(title);

        /**
         * beállítjuk az ablakméretet.
         */
        frame.setSize(width,height);

        /**
         * bezárjuk az abalakot, akkor megfelelően zárja be az alkalmazást,
         * hogy ne fusson véletlen a háttérben
         */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * mivel beállítjuk a méretet, azért ne lehessen átméretezni az ablakot.
         */
        frame.setResizable(false);

        /**
         * képernyő közepére jelenik meg az ablak.
         */
        frame.setLocationRelativeTo(null);

        /**
         * Default nem látszik az ablak,ezért láthatóvá kell tenni.
         */
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Display( String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }


}
