package sptech;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player();
        Map map = new Map(player);
        player.setActualMap(map);
        Scanner reader = new Scanner(System.in);

        Pilha<String> moveStack = new Pilha<>(5);

        String direction;
        map.showMap(100, false, false);
        while (!moveStack.isFull() && !player.isWinner()) {
            System.out.printf("Qual direção deseja tentar ir? (%d movimentos restantes)\n",5 - moveStack.size());
            direction = reader.nextLine();
            switch (direction) {
                case "b":
                    player.moveUp(rollDice());
                    moveStack.push("Baixo");
                    break;
                case "d":
                    player.moveRight(rollDice());
                    moveStack.push("Direita");
                    break;
                case "e":
                    player.moveLeft(rollDice());
                    moveStack.push("Esquerda");
                    break;
                default:
                    System.out.println("Essa direção não foi codificada, por favor tente outra");
                    break;
            }
        }
    }
}
