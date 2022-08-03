package sptech;

public class Player {
    Map actualMap;
    private int points;
    private int totalMoves;
    private boolean winner;
    private int x;
    private int y;

    public Player() {
        this.points = 0;
        this.totalMoves = 0;
        this.winner = false;
        this.x = 11;
        this.y = 1;
    }

    public void win() {
        this.points += 100;
        this.winner = true;
        System.out.printf("Parabéns! Você chegou ao objetivo em %d movimentos \n", this.totalMoves);
        System.out.printf("Você tem %d pontos!!\n", this.points);
    }

    // Movement
    public void moveUp(int force) {
        this.totalMoves++;
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            int[] newPos = { this.x - 1, this.y };
            if (oldPos[0] == 0) {
                win();
                break;
            }
            if (actualMap.hasEmptyPath(newPos)) {
                this.x = newPos[0];
                actualMap.updatePlayerPos(oldPos);
            } else {
                break;
            }
        }
    }

    public void moveLeft(int force) {
        this.totalMoves++;
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            int[] newPos = { this.x, this.y + 1 };
            if (newPos[1] > 2)
                newPos[1] = 0;
            if (actualMap.hasEmptyPath(newPos)) {
                this.y = newPos[1];
                actualMap.updatePlayerPos(oldPos);
            } else {
                break;
            }
        }
    }

    public void moveRight(int force) {
        this.totalMoves++;
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            int[] newPos = { this.x, this.y - 1 };
            if (newPos[1] < 0)
                newPos[1] = 2;
            if (actualMap.hasEmptyPath(newPos)) {
                this.y = newPos[1];
                actualMap.updatePlayerPos(oldPos);
            } else {
                break;
            }
        }
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setActualMap(Map actualMap) {
        this.actualMap = actualMap;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public boolean isWinner(){
        return winner;
    }
}
