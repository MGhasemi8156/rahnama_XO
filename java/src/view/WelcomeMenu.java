package view;

import controller.GameController;
import model.Game;

import java.util.Scanner;

public class WelcomeMenu extends Menu{
    private static WelcomeMenu instance;
    private WelcomeMenu() {}
    public static WelcomeMenu getInstance() {
        if (instance == null) instance = new WelcomeMenu();
        return instance;
    }

    @Override
    public void run(Scanner scanner) {
        System.out.println("Hi, please enter number of players:");
        int players = 2;
        try {
            players = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("you did not enter a number in correct form.\n We will use default value");
            return;
        }
        System.out.println("Please enter size of the map:");
        int n = 3;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("you did not enter a number in correct form.\n We will use default value");
        }

        Game game = new Game(players, n);
        GameController.getInstance().setGame(game);

        GameMenu.getInstance().run(scanner);
    }
}
