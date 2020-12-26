package org.kodluyoruz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        }while(!charInput.equalsIgnoreCase("S") && !charInput.equalsIgnoreCase("O"));

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