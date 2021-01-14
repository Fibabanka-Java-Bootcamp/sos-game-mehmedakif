package org.kodluyoruz;

import java.util.Random;

class AIPlayer extends Player
{
    int randomRow;
    int randomColumn;
    boolean randomChar;

    @Override
    public void play(int row, int column, String[][] gameMap, String inputValue)
    {

        while(!gameMap[randomRow][randomColumn].equals(" "))
        {
            randomPlace();
            randomInput();
        }

        if(randomChar)
        {
            gameMap[randomRow][randomColumn] = "S";
        }
        else
        {
            gameMap[randomRow][randomColumn] = "O";
        }
    }

    public void randomPlace()
    {
        Random random1 = new Random();
        randomRow = random1.nextInt(5);
        randomColumn = random1.nextInt(5);
    }

    public void randomInput()
    {
        Random random = new Random();
        randomChar = random.nextBoolean();
    }
}