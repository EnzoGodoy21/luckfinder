package sptech;

public class Player {
    Map actualMap;
    private int x;
    private int y;

    public Player() {
        this.x = 11;
        this.y = 1;
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    // Movement

    public void moveUp(int force) {
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            int[] newPos = {this.x - 1, this.y};
            if(actualMap.hasEmptyPath(newPos)){
                this.x = newPos[0];
                actualMap.updatePlayerPos(oldPos);
            }else{
                break;
            }
        }
    }

    public void moveLeft(int force) {
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            int[] newPos = {this.x, this.y};
            if(newPos[1] > 2) y = 0;
            if(actualMap.hasEmptyPath(newPos)){
                this.y = newPos[1];
                actualMap.updatePlayerPos(oldPos);
            }else{
                break;
            }
        }
    }

    public void moveRight(int force) {
        for (int i = 0; i < force; i++) {
            int[] oldPos = getPos();
            this.y--;
            if (y > 0) {
                y = 2;
            }
            actualMap.updatePlayerPos(oldPos);
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

}
