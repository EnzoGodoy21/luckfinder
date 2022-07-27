package sptech;

import java.util.Random;

public class Map {
    private MapStatesEnum[][] map = new MapStatesEnum[12][3];
    private int[] playerPos = { 11, 1 };
    private int obstacles = 2;
    private int[][] obstaclesPos = new int[obstacles][2];
    private int[][] areasRowConstraints = { { 0, 0 }, { 1, 5 }, { 6, 11 } };

    public Map() {
        createBaseMap();
        setPlayerPos();
        setObstacles();
    }


    // Map initialization
    private void createBaseMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i >= areasRowConstraints[0][0] && i <= areasRowConstraints[0][1]) {
                    map[i][j] = MapStatesEnum.OBJECTIVE;
                } else if (i >= areasRowConstraints[1][0] && i <= areasRowConstraints[1][1]) {
                    map[i][j] = MapStatesEnum.EMPTY_A2;
                } else if (i >= areasRowConstraints[2][0] && i <= areasRowConstraints[2][1]) {
                    map[i][j] = MapStatesEnum.EMPTY_A1;
                }
            }
        }
    }

    private void setPlayerPos() {
        map[playerPos[0]][playerPos[1]] = MapStatesEnum.PLAYER;
    }

    private void setObstacles() {
        setObstaclePos();
        for (int i = 0; i < obstaclesPos.length; i++) {
            map[obstaclesPos[i][0]][obstaclesPos[i][1]] = MapStatesEnum.OBSTACLE;
        }
    }

    private void setObstaclePos() {
        int[] obstaclesCol = generateObstacleCol();
        for (int i = 0; i < obstaclesPos.length; i++) {
            this.obstaclesPos[i][0] = new Random().nextInt(5) + 1;
            this.obstaclesPos[i][1] = obstaclesCol[i];
        }
    }

    private int[] generateObstacleCol() {
        int[] obstaclesCol = new int[obstacles];
        int cont = 0;
        Random rand = new Random();
        while (cont < this.obstacles) {
            int obstacle = rand.nextInt(3);
            if (obstacle != obstaclesCol[0]) {
                obstaclesCol[cont] = obstacle;
                cont++;
            }
        }
        return obstaclesCol;
    }

    public void showMap(int millis) {
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].length - 1; j >= 0; j--) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {

                }
                if (map[i][j] == MapStatesEnum.OBSTACLE) {
                    System.out.printf("|***%s***|", map[i][j].getText());
                } else {
                    System.out.printf("|---%s---|", map[i][j].getText());
                }
            }
            System.out.println();
        }
    }
}
