package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int width=32, height=32;

    public static BufferedImage player,dirt,grass,stone,tree;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
        dirt = sheet.crop(0,0,width,height);
        player = sheet.crop(width,0,width,height);
        tree = sheet.crop(width * 2,0,width,height);
        grass=sheet.crop(0,height,width,height);
        stone=sheet.crop(width,height,width,height);
    }
}
