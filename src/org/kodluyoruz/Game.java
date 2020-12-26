package org.kodluyoruz;

abstract class Game
{
    abstract void setMapSize(String mapSize);
    abstract void isPlayerScored(int givenRow, int givenColumn);
    abstract boolean isGameEnded();
    abstract void printMap();
    abstract void createMap();
    abstract void updateMap();
}