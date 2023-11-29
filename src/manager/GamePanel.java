package manager;

import entity.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends JFrame {
    public final int originalTileSize = 16;
    final float scale = 4;
    public final int tileSize = (int) (originalTileSize * scale);
    public final int screenCol = 16;
    public final int screenRow = 9;
    public final int screenWidth = screenCol * tileSize;
    public final int screenHeight = screenRow * tileSize;

    Game game;
    Canvas window = new Canvas();
    KeyHandler keyH= new KeyHandler();


    public GamePanel(Game game) {
        this.game = game;
        window.setPreferredSize(new Dimension(screenWidth,screenHeight));
        window.setFocusable(true);
        addKeyListener(keyH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(window);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        window.createBufferStrategy(3);

    }
    public void update(){
        game.getGameObjects().forEach(GameObject::update);
    }
    public void render(){
        BufferStrategy bg = window.getBufferStrategy();

        Graphics g = bg.getDrawGraphics();
        Graphics2D g2D = (Graphics2D)g;

        g2D.setColor(Color.WHITE);
        g2D.fillRect(0,0,screenWidth,screenHeight);
        game.getGameObjects().forEach(gameObject -> gameObject.draw(g2D));

        g2D.dispose();
        bg.show();
    }
}
