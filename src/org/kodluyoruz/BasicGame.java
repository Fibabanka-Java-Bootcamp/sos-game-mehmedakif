package org.kodluyoruz;

import java.util.*;

class BasicGame extends Game
{
    int mapSize;
    String[][] gameMap;
    List<Player> playerList = new ArrayList<>();
    Player turnOfPlayer; // Isaretleme yapmasi beklenen oyuncu.

    @Override
    public void setMapSize(String mapSize)
    {
        this.mapSize = Integer.parseInt(mapSize);
    }
    @Override
    public void createMap()
    {
        this.gameMap = new String[this.mapSize][this.mapSize];

        for (int i = 0; i < this.mapSize; i++)
        {
            for (int j = 0; j < this.mapSize; j++)
            {
                this.gameMap[i][j] = " ";
            }
        }
    }
    @Override
    void isPlayerScored(int givenRow, int givenColumn)
    {
        boolean isScored;
        String[] triplesToCheck = new String[3];
        isScored = checkCloseAdjacents(givenRow, givenColumn, triplesToCheck);
        isScored = isScored || checkDistantAdjacents(givenRow, givenColumn, triplesToCheck);

        if(!isScored)
        {
            this.switchTurn();
        }

    }

    void switchTurn()
    {
        if(turnOfPlayer.equals(playerList.get(0)))
        {
            turnOfPlayer = playerList.get(1);
        }
        else if (turnOfPlayer.equals(playerList.get(1)))
        {
            turnOfPlayer = playerList.get(0);
        }
    }

    @Override
    boolean isGameEnded()
    {
        if(Arrays.deepToString(this.gameMap).length() == Math.pow(mapSize,2.0))
        {
            System.out.println("Oyun alanı doldu. Oyun bitti.");
            return true;
        }
        return false;
    }

    @Override
    void printMap()
    {

    }

    @Override
    void updateMap()
    {

    }

    private boolean checkCloseAdjacents(int givenRow, int givenColumn, String[] triplesToCheck)
    {
        boolean isScored = false;
        triplesToCheck[0] = gameMap[givenRow -1][givenColumn -1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn +1];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }

        triplesToCheck[0] = gameMap[givenRow -1][givenColumn +1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn -1];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow -1][givenColumn];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn -1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn +1];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        return isScored;
    }
    private boolean checkDistantAdjacents(int givenRow, int givenColumn, String[] triplesToCheck)
    {
        boolean isScored = false;
        triplesToCheck[0] = gameMap[givenRow -2][givenColumn -2];
        triplesToCheck[1] = gameMap[givenRow -1][givenColumn -1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }

        triplesToCheck[0] = gameMap[givenRow -2][givenColumn];
        triplesToCheck[1] = gameMap[givenRow -1][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow -2][givenColumn+2];
        triplesToCheck[1] = gameMap[givenRow -1][givenColumn+1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn +2];
        triplesToCheck[1] = gameMap[givenRow][givenColumn +1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn +2];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn +1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn-2];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn-1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn -2];
        triplesToCheck[1] = gameMap[givenRow][givenColumn -1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).toUpperCase(Locale.ROOT).equals("SOS"))
        {
            this.turnOfPlayer.increasePlayerPoint();
            isScored = true;
        }
        return isScored;
    }

}