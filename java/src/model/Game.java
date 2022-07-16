package model;

public class Game {
    private final int players;
    private final int mapSize;
    private int[][] map;
    private int currentPlayer;
    public Game(int players, int mapSize) {
        this.players = players;
        this.mapSize = mapSize;
        this.map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                this.map[i][j] = 0;
            }
        }
        this.currentPlayer = 1;
    }

    public int getPlayers() {
        return players;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int[][] getMap() {
        return map;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
