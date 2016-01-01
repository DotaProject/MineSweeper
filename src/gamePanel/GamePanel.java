package gamePanel;

import gameController.GameController;
import gameEngine.GameEngine;
import gameEngine.GameOverException;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameEngine engine;
    private CellsPanel cellsPanel;

    private static final long serialVersionUID = -5589204574632563738L;


    public void init(GameController controller, GameEngine engine) {
        this.addMouseListener(controller);
        this.engine = engine;
        this.cellsPanel = new CellsPanel(engine);
        this.setLayout(new BorderLayout());
        this.add(cellsPanel, BorderLayout.CENTER);
    }

    public void showGameOverPanel(GameOverException e) {
        //TODO
    }
}
