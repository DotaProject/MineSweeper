import gameController.GameController;
import gameEngine.GameEngine;
import gamePanel.GamePanel;

import javax.swing.*;

public class Minesweeper {

    public static void main(String[] args) {
        GameController controller = new GameController();
        GameEngine engine = new GameEngine();
        GamePanel panel = new GamePanel();

        panel.init(controller, engine);
        controller.init(panel, engine);
        engine.init(10, 15, 10);


        JFrame gameFrame = new JFrame(engine.GAME_NAME);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().add(panel);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.start();
    }

}
