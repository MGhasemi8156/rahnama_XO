package view;

import controller.GameController;
import model.Game;

import java.util.Scanner;

public class GameMenu extends Menu {
    private static GameMenu instance;
    private GameMenu() {}
    public static GameMenu getInstance() {
        if (instance == null) instance = new GameMenu();
        return instance;
    }

    @Override
    public void run(Scanner scanner) {
        while (true) {
            Game game = GameController.getInstance().getGame();
            int mapSize = game.getMapSize();
            System.out.println("===================================================");
            System.out.println("This is player" + game.getCurrentPlayer() + " turn");
            this.printMap(mapSize, game.getMap());
            System.out.println("Please enter row and column. (Correct form is \"i j\")");

            try {
                String[] input = scanner.nextLine().split(" ");
                int i = Integer.parseInt(input[0]);
                int j = Integer.parseInt(input[1]);
                if (i < 0 || i >= mapSize || j < 0 || j >= mapSize) {
                    System.err.println("Row or column is out of map size.");
                    continue;
                }

                int target = game.getMap()[i][j];
                if (target != 0) {
                    System.err.println("This cell is full.");
                    continue;
                }

                game.getMap()[i][j] = game.getCurrentPlayer();

                int winner;
                if ((winner = GameController.getInstance().checkWinner()) != 0) {
                    System.out.println("Player" + winner + " wins this game!!!!!");
                    break;
                }

                GameController.getInstance().nextTurn();

            } catch (Exception e) {
                System.err.println("Please enter row and column in correct form.");
                continue;
            }
        }
    }


    private void printMap(int mapSize, int[][] map) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.printf("%-4d", map[i][j]);
            }
            System.out.println();
        }
    }
}
