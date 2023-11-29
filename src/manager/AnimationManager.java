package manager;

import graphics.AnimationSet;

import java.awt.*;
import java.awt.image.BufferedImage;



public class AnimationManager {
    private AnimationSet spritesSet;
    private BufferedImage currentAnimationSheet;
    private int currentFrameTime;
    private int updatesPerFrame;

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }

    private int frameIndex;

    GamePanel gp;

    public AnimationManager(GamePanel gp, AnimationSet spritesSet) {
        this.gp = gp;
        this.spritesSet = spritesSet;
        this.updatesPerFrame = 10;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
    }
    public Image getImage(){
        return currentAnimationSheet.getSubimage(frameIndex * gp.originalTileSize,0,
                gp.originalTileSize,gp.originalTileSize );
    }
    public void update(){
        currentFrameTime++;
        if (currentFrameTime >= updatesPerFrame){
            currentFrameTime = 0;
            frameIndex++;
            if (frameIndex > currentAnimationSheet.getWidth()/ gp.originalTileSize - 1 ){
                frameIndex = 0;
            }
        }
    }
    public void playAnimation(String name){
        this.currentAnimationSheet = (BufferedImage) spritesSet.getSheet(name);
    }
    public boolean collisons = false;
}
