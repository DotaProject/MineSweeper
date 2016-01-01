package gameEngine;

public class GameOverException extends Exception {

    private static final long serialVersionUID = -1817516153136338328L;

    private boolean isWinner;

    public GameOverException(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public String getMessage() {
        if (isWinner) {
            return "you Won!";
        } else {
            return "oops :( ";
        }
    }

}
