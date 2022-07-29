package sptech;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Player player = new Player();
        Map map = new Map(player);
        player.setActualMap(map);

        map.showMap(0,false,false);

        Scanner nextInt = new Scanner(System.in);
        player.moveUp(nextInt.nextInt());
        player.moveLeft(nextInt.nextInt());
        player.moveRight(nextInt.nextInt());
        
    }
}
