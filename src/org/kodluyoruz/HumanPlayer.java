package org.kodluyoruz;

class HumanPlayer extends Player
{
    @Override
    public void play(int row, int column, String[][] gameMap, String inputValue)
    {
        if(gameMap[row][column].equals(" "))
        {
            gameMap[row][column] = inputValue;
        }
    }


}