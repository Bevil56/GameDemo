package entity;

import graphics.SpriteLibrary;
import manager.*;

import java.awt.*;

public class Jerry extends GameObject {
    private int x,y,speed_X,speed_Y;
    private int velY;
    protected float gravity = 0.05f;
    private String status;


    public static int sizeFrameX = 40;
    public static int sizeFrameY = 76;
    public static int frameX = 43;
    public static int frameY = 54;
    Rectangle bound;


    KeyHandler keyH;
    AnimationManager animationManager;
    SpriteLibrary spriteLibrary;
    Game game;
    CollisonChecker collisonChecker;

    public Jerry(Game game, GamePanel gp, ObjectID id, int x, int y, KeyHandler keyH, SpriteLibrary spriteLibrary) {
        super(gp,id,x,y);
        this.game=game;
        this.keyH = keyH;
        this.spriteLibrary = spriteLibrary;
        speed_X = 5;
        speed_Y = 5;
        velY = speed_Y;
        this.gp = getGp();
        this.x=getX();
        this.y=getY();
        animationManager = new AnimationManager(gp,spriteLibrary.getUnit("unit"));
        status = "Idle";
        collisonChecker = new CollisonChecker();
        bound =  new Rectangle(x+43,y+54, 40, 75);
    }

    public void playAnimation(String name){
        animationManager.playAnimation(name);
    }

    @Override
    public void update() {
        if (x<=0) x = 0;
        if (y<=0) y = 0;
        if (x>=gp.screenWidth) x = gp.screenWidth;
        if (y>=gp.screenHeight) y = gp.screenHeight;
        if (keyH.leftPressed || keyH.rightPressed || keyH.upPressed ||
                keyH.downPressed || keyH.jumpPressed) {
            if (keyH.leftPressed) {
                status = "Walk";
                x -= speed_X;
            } else if (keyH.downPressed) {
                status = "Run";
                y += speed_Y;
            } else if (keyH.upPressed) {
                status = "Run";
                y -= speed_Y;
            } else if (keyH.rightPressed) {
                status = "Walk";
                x += speed_X;
            } else {


            }
            animationManager.update();

            collisonChecker.checker(this);
            }

    }



        @Override
    public void draw(Graphics2D g2D) {
        Image image = getImage();
        int sizeImage = image.getWidth(null) ;;
        g2D.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
        g2D.setColor(Color.BLACK);
        g2D.drawRect(x,y,sizeImage,sizeImage);
//        g2D.setColor(Color.RED);
//        g2D.drawRect(x+43,y+54, 40, 75);

    }

    @Override
    public Image getImage() {
        playAnimation("boy_down");
        return animationManager.getImage();
    }

    @Override
    public Rectangle getBounds() {
        return bound;
    }

    @Override
    public int getBoundsX() {
        return (int) bound.getX();
    }

    @Override
    public int getBoundsY() {
        return (int) bound.getY();
    }

    @Override
    public int getBoundsWidth() {
        return (int) bound.getWidth();
    }

    @Override
    public int getBoundsHeight(){
        return (int) bound.getHeight();
    }

}
