package manager;

import entity.*;
import graphics.SpriteLibrary;

import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {

    private int ups,fps;
    private boolean running = false;
    public static int FPS = 60;
    public int x_default,y_default;

    private final List<GameObject> gameObjects;

    GamePanel gp;
    Thread gameThread;
    private final SpriteLibrary sprites;


    public Game() {
        gp = new GamePanel(this);
        gp.requestFocus();
        gameThread();
        gameObjects = new ArrayList<>();
        sprites = new SpriteLibrary();
        setDefaultPosition();
        addObject();
    }
    public void addObject(){
        for (int i = 0; i < gp.screenWidth/gp.tileSize; i++){
            gameObjects.add(new Block(gp,ObjectID.Block,gp.tileSize * i, gp.screenHeight- gp.tileSize));
        }
        for (int i = 0; i < gp.screenHeight/gp.tileSize; i++){
            gameObjects.add(new Block(gp,ObjectID.Block,gp.screenWidth - gp.tileSize, gp.tileSize * i));
        }
        gameObjects.add(new Jerry(this,gp,ObjectID.Jerry,x_default - Jerry.frameX - Jerry.sizeFrameX/2,y_default - Jerry.frameY - Jerry.sizeFrameY/2,gp.keyH,sprites));
    }
    public void setDefaultPosition(){
        this.x_default = gp.screenWidth/2;
        this.y_default = gp.screenHeight/2;

    }
    public synchronized void gameThread() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000d / FPS;

        double delta = 0 ;
        double currentTime, lastUpdate = System.currentTimeMillis();
        double nextStatTime = System.currentTimeMillis();


        while (running) {
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastUpdate) / drawInterval;
            lastUpdate = currentTime;
            if(delta >= 1) {
                while (delta >= 1) {
                    update();
                    delta--;
                }
                repaint();
                if (System.currentTimeMillis() - nextStatTime > 1000){
                    nextStatTime += 1000;
//                    System.out.printf("FPS: %d UPS: %d\n",fps,ups);
//                    fps = 0;
//                    ups = 0;
                }
            }
        }
    }
    private void update() {
        ups++;
        gp.update();
    }

    public void repaint() {
        fps++;
        gp.render();
    }
    public List<GameObject> getGameObjects(){
        return gameObjects;
    }
}