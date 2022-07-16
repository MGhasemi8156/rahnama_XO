import view.WelcomeMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WelcomeMenu.getInstance().run(scanner);
    }
}
