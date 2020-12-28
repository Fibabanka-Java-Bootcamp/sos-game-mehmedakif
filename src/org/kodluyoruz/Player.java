package org.kodluyoruz;

class Player
{
    int point = 0;

    public void play(int row, int column, String[][] gameMap, String inputValue)
    {
        if(gameMap[row][column].equals(" "))
        {
            gameMap[row][column] = inputValue;
        }
    }

    public void increasePlayerPoint()
    {
        this.point =+ 1;
    }
}