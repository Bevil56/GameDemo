package entity;

import manager.GamePanel;

import java.awt.*;

public class Block extends GameObject {

    public Block(GamePanel gp,ObjectID id,int x, int y) {
        super(gp,id,x,y);
        this.x=getX();
        this.y=getY();
        this.gp= getGp();
    }

    @Override
        public void update() {

        }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.black);
        g2D.drawRect(x,y, gp.tileSize, gp.tileSize);
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, gp.tileSize, gp.tileSize);
    }

    @Override
    public int getBoundsX() {
        return 0;
    }

    @Override
    public int getBoundsY() {
        return 0;
    }

    @Override
    public int getBoundsWidth() {
        return 0;
    }

    @Override
    public int getBoundsHeight() {
        return 0;
    }
}
