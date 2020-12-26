package org.kodluyoruz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
class HumanPlayer extends Player
{

}

class AIPlayer extends Player
{

}
abstract class Game
{
    abstract void setMapSize(String mapSize);
    abstract void isPlayerScored(int givenRow, int givenColumn);
    abstract boolean isGameEnded();
    abstract void printMap();
    abstract void createMap();
    abstract void updateMap();
}
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



class GameSession extends BasicGame //Farkli oyun tipleri icin farkli classlar Game classini extend edebilir.
{

    public GameSession(String mapSize)
    {
        this.setMapSize(mapSize);
        this.createMap();

    }
}

public class Main
{

    public static void main(String[] args) throws IOException
    {
        int sizeInput;
        int rowInput;
        int columnInput;
        String charInput;

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        do
        {
            System.out.print("Oyunun harita boyutunu giriniz (3-7).: ");
            sizeInput =  Integer.parseInt(reader.readLine());
        }while(sizeInput>7 || sizeInput<3);

        GameSession game = new GameSession(String.valueOf(sizeInput));

        HumanPlayer player1 = new HumanPlayer();
        AIPlayer aiPlayer = new AIPlayer();

        game.playerList.add(player1);
        game.playerList.add(aiPlayer);

        game.turnOfPlayer = game.playerList.get(0);


        do{
            System.out.print("Satır:" + "(1-" + game.mapSize + ")");
            rowInput = Integer.parseInt(reader.readLine());
        }while(rowInput<0 || rowInput> game.mapSize);

        do{
            System.out.print("Sutun:"+ "(1-" + game.mapSize + ")");
            columnInput = Integer.parseInt(reader.readLine());
        }while(columnInput<0 || columnInput> game.mapSize);

        do{
            System.out.print("S/O:");
            charInput = (reader.readLine());
        }while(!charInput.toUpperCase().equals("S") && !charInput.toUpperCase().equals("O"));

        if(game.turnOfPlayer.play(rowInput-1,columnInput-1,game.gameMap,charInput))
        {
            System.out.print("Yay!");
        }
        else
        {
            System.out.print("Ohhh!");
        }

        System.out.print(Arrays.deepToString(game.gameMap));

    }
}