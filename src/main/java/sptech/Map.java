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
        // setObstaclePos();
    }

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

    private void setObstaclePos() {
        boolean hasObstacle = false;
        int cont = 0;
        while (cont < obstaclesPos.length) {
            int[] obstacle = generateObstaclePos();
            for (int i = 0; i < obstaclesPos.length;) {
                for (int j = 0; j < obstaclesPos[i].length; j++) {
                    
                }
            }
        }
    }

    private int[] generateObstaclePos() {
        Random random = new Random();
        int obstacleRow = random.nextInt(5) + 1;
        int obstacleCollumn = random.nextInt(3);
        int[] obstaclePos = { obstacleRow, obstacleCollumn };
        return obstaclePos;
    }

    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                System.out.printf("|---%s---|", map[i][j].getText());
            }
            System.out.println();
        }
    }
}
