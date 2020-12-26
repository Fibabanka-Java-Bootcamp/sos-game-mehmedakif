package org.kodluyoruz;

class Player
{
    int point = 0;

    public boolean play(int row, int column, String[][] gameMap, String inputValue)
    {
        if(gameMap[row][column].equals(" "))
        {
            gameMap[row][column] = inputValue;
            return true;
        }
        return false;// Yeniden girdi al.
    }

    public void increasePlayerPoint()
    {
        point =+ 1;
    }
}