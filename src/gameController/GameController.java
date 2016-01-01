package gameController;

import gameEngine.GameEngine;
import gamePanel.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameController implements MouseListener {
    public static final int FPS = 100;
    private GamePanel panel;
    private GameEngine engine;
    private boolean running;

    public void init(GamePanel panel, GameEngine engine) {
        this.engine = engine;
        this.panel = panel;
    }
//Hi
    public void start() {
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                while (running) {
                    GameUpdate();
                    GameRender();
                    try {
                        Thread.sleep(1000 / FPS);
                    } catch (Exception e) {

                    }
                }
            }

        });
        gameLoop.start();

    }

    private void GameUpdate() {
        engine.update();
    }

    private void GameRender() {
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO
    }

}
