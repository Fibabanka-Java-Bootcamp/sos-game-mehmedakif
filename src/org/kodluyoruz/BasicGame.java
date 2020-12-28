package org.kodluyoruz;

import java.util.*;

class BasicGame extends Game
{
    int mapSize;
    String[][] gameMap;
    List<Player> playerList = new ArrayList<>();
    Player theCurrentPlayer; // Isaretleme yapmasi beklenen oyuncu.

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
        this.printMap(this.gameMap);
    }
    @Override
    public boolean isPlayerScored(Player player, int givenRow, int givenColumn)
    {
        boolean isScored = false;
        String[] triplesToCheck = new String[3];
        //isScored = checkCloseAdjacents(givenRow, givenColumn, triplesToCheck);
        //isScored = isScored || checkDistantAdjacents(givenRow, givenColumn, triplesToCheck);

        this.printMap(this.gameMap);
        return isScored;
    }

    public void switchTurn()
    {
        if(theCurrentPlayer.equals(playerList.get(0)))
        {
            theCurrentPlayer = playerList.get(1);
        }
        else if (theCurrentPlayer.equals(playerList.get(1)))
        {
            theCurrentPlayer = playerList.get(0);
        }
    }

    @Override
    public boolean isGameEnded()
    {
        if(!Arrays.deepToString(this.gameMap).contains(" "))
        {
            System.out.println("Karakter koyacak bosluk kalmadi oyun bitti.");
            return true;
        }
        return false;
    }

    @Override
    void printMap(String[][] map)
    {
        for (int i = 0; i< this.mapSize; i++)
        {
            System.out.println(Arrays.toString(map[i]));

        }
    }

    private boolean checkCloseAdjacents(int givenRow, int givenColumn, String[] triplesToCheck)
    {
        //TODO implement corner and edge states.

        boolean isScored = false;
        triplesToCheck[0] = gameMap[givenRow -1][givenColumn -1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn +1];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow -1][givenColumn +1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn -1];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow -1][givenColumn];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow +1][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn -1];
        triplesToCheck[1] = gameMap[givenRow][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn +1];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
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
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }

        triplesToCheck[0] = gameMap[givenRow -2][givenColumn];
        triplesToCheck[1] = gameMap[givenRow -1][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow -2][givenColumn+2];
        triplesToCheck[1] = gameMap[givenRow -1][givenColumn+1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn +2];
        triplesToCheck[1] = gameMap[givenRow][givenColumn +1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn +2];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn +1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow +2][givenColumn-2];
        triplesToCheck[1] = gameMap[givenRow +1][givenColumn-1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        triplesToCheck[0] = gameMap[givenRow][givenColumn -2];
        triplesToCheck[1] = gameMap[givenRow][givenColumn -1];
        triplesToCheck[2] = gameMap[givenRow][givenColumn];
        if(Arrays.toString(triplesToCheck).equals("SOS"))
        {
            this.theCurrentPlayer.increasePlayerPoint();
            isScored = true;
        }
        return isScored;
    }

}