package gameEngine;


public class Cell {

    private boolean hasMine;
    private boolean isVisible;
    private boolean isFlaged;
    private boolean isQuestion;

    protected boolean hasMine() {
        return hasMine;
    }

    protected void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    protected boolean isVisible() {
        return isVisible;
    }

    protected void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    protected boolean isQuestion() {
        return isQuestion;
    }

    protected void setQuestion(boolean isQuestion) {
        this.isQuestion = isQuestion;
    }

    protected boolean isFlaged() {
        return isFlaged;
    }

    protected void setFlaged(boolean isFlaged) {
        this.isFlaged = isFlaged;
    }

}
