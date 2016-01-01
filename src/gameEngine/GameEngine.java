package gameEngine;

import java.awt.Image;
import java.util.Random;

public class GameEngine {
    public static final String ROWS_GETTER = "enter number of rows";
    public static final String COLS_GETTER = "enter number of columns";
    public static final String NUMBER_OF_BOMBS_GETTER = "enter number of bombs";
    public static final String GAME_NAME = "MineSweeper";

    private int passedTime = 0;
    private Cell[][] cells;
    private int rows;
    private int cols;
    private int numberOfBombs;
    private boolean bombsInited = false;

    public void init(int rows, int cols, int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }

    }

    private void initBombs(int startingRow, int startingColumn) {
        Random rand = new Random();
        for (int i = 0; i < numberOfBombs; i++) {

            int generatedNumberForRow = rand.nextInt(rows);
            int generatedNumberForCol = rand.nextInt(cols);

            if (generatedNumberForCol == startingColumn && generatedNumberForRow == startingRow) {
                i--;
            } else if (cells[generatedNumberForRow][generatedNumberForCol]
                    .hasMine()) {
                i--;
            } else {
                cells[generatedNumberForRow][generatedNumberForCol]
                        .setHasMine(true);
            }
        }
        bombsInited = true;
    }

    public void update() {
        passedTime++;
    }

    public void rightClick(int i, int j) {
        if (cells[i][j].isVisible() == false) {
            if (cells[i][j].isFlaged()) {
                cells[i][j].setFlaged(false);
                cells[i][j].setQuestion(true);
            } else if (cells[i][j].isQuestion()) {
                cells[i][j].setQuestion(false);
            } else {
                cells[i][j].setFlaged(true);
            }
        }
    }

    public void leftClick(int i, int j) throws GameOverException {
        if (bombsInited == false) {
            initBombs(i, j);
        }
        if (cells[i][j].isVisible() == false && cells[i][j].isFlaged() == false) {
            cells[i][j].setVisible(true);
            if (cells[i][j].hasMine()) {
                throw new GameOverException(false);
            }
            if (getNumberOfRemainingCells() == numberOfBombs) {
                throw new GameOverException(true);
            }
            discover(i, j);
        }

    }

    private void discover(int i, int j) {
        int nearbyBombs = getBombsAround(i, j);
        if (nearbyBombs == 0) {
            for (int i1 = i - 1; i1 < i + 2; i1++) {
                for (int j1 = j - 1; j1 < j + 2; j1++) {
                    try {
                        if (cells[i1][j1].isVisible() == false
                                && cells[i1][j1].isFlaged() == false) {
                            cells[i1][j1].setVisible(true);
                            cells[i1][j1].setQuestion(false);

                            discover(i1, j1);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }
    }

    public int getBombsAround(int i, int j) {
        int toReturn = 0;
        for (int i1 = i - 1; i1 < i + 2; i1++) {
            for (int j1 = j - 1; j1 < j + 2; j1++) {
                try {
                    if (cells[i1][j1].hasMine()) {
                        toReturn++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return toReturn;
    }

    public int getPassedTime() {
        return passedTime;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumberOfRemainingCells() {
        int toReturn = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isVisible() == false) {
                    toReturn++;
                }
            }
        }
        return toReturn;
    }

    public int getNumberOfRemainingBombs() {
        int toReturn = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isFlaged()) {
                    toReturn++;
                }
            }
        }
        return numberOfBombs - toReturn;
    }

    public Image getCellImage(int row, int col) {
        //TODO
        return null;
    }
}
