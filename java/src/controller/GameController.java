package controller;

import model.Game;

public class GameController {
    private static GameController instance;
    private GameController() {}
    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        return instance;
    }

    private Game game;

    // returns 0 if no winner
    public int checkWinner() {
        int mapSize = game.getMapSize();
        int[][] map = game.getMap();

        int winner;
        if ((winner = checkHorizontal(mapSize, map)) != 0) return winner;
        if ((winner = checkVertical(mapSize, map)) != 0) return winner;
        if ((winner = checkOblique1(mapSize, map)) != 0) return winner;
        if ((winner = checkOblique2(mapSize, map)) != 0) return winner;
        return 0;
    }

    private int checkHorizontal(int mapSize, int[][] map) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize - 2; j++) {
                int value = map[i][j];
                if (value != 0 && map[i][j + 1] == value && map[i][j + 2] == value) {
                    return value;
                }
            }
        }
        return 0;
    }

    private int checkVertical(int mapSize, int[][] map) {
        for (int i = 0; i < mapSize - 2; i++) {
            for (int j = 0; j < mapSize; j++) {
                int value = map[i][j];
                if (value != 0 && map[i + 1][j] == value && map[i + 2][j] == value) {
                    return value;
                }
            }
        }
        return 0;
    }

    private int checkOblique1(int mapSize, int[][] map) {
        for (int i = 0; i < mapSize - 2; i++) {
            for (int j = 0; j < mapSize - 2; j++) {
                int value = map[i][j];
                if (value != 0 && map[i + 1][j + 1] == value && map[i + 2][j + 2] == value) {
                    return value;
                }
            }
        }
        return 0;
    }

    private int checkOblique2(int mapSize, int[][] map) {
        for (int i = 0; i < mapSize - 2; i++) {
            for (int j = 2; j < mapSize; j++) {
                int value = map[i][j];
                if (value != 0 && map[i + 1][j - 1] == value && map[i + 2][j - 2] == value) {
                    return value;
                }
            }
        }
        return 0;
    }



    public void nextTurn() {
        if (game.getCurrentPlayer() == game.getPlayers()) {
            game.setCurrentPlayer(1);
        } else {
            game.setCurrentPlayer(game.getCurrentPlayer() + 1);
        }
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
