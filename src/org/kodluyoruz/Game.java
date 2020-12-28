package org.kodluyoruz;

abstract class Game
{
    abstract void setMapSize(String mapSize);
    abstract boolean isPlayerScored(Player player,int givenRow, int givenColumn);
    abstract boolean isGameEnded();
    abstract void printMap(String[][] map);
    abstract void createMap();
}