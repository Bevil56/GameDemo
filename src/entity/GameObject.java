package entity;

import manager.GamePanel;

import java.awt.*;

public abstract class GameObject {

    protected GamePanel gp;

    protected int x,y;
    protected ObjectID id;

    private boolean falling = true;
    private boolean jumping = false;

    public GameObject(GamePanel gp,ObjectID id,int x, int y) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public GamePanel getGp() {
        return gp;
    }
    public ObjectID getId() {
        return id;
    }

//    public boolean isFalling() {
//        return falling;
//    }
//
//    public void setFalling(boolean falling) {
//        this.falling = falling;
//    }
//
//    public boolean isJumping() {
//        return jumping;
//    }
//
//    public void setJumping(boolean jumping) {
//        this.jumping = jumping;
//    }


    public abstract void update();

    public abstract void draw(Graphics2D g2D);

    public abstract Image getImage();
    public abstract Rectangle getBounds();
    public abstract int getBoundsX();
    public abstract int getBoundsY();
    public abstract int getBoundsWidth();
    public abstract int getBoundsHeight();
}
