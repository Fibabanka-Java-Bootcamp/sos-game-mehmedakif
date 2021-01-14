package org.kodluyoruz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main
{
    static int sizeInput;
    static int rowInput;
    static int columnInput;
    static String charInput;

    public static void main(String[] args) throws IOException
    {


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

        game.playerList.add(0,player1);
        game.playerList.add(1,aiPlayer);

        game.theCurrentPlayer = game.playerList.get(0);
        while(!game.isGameEnded())
        {

            System.out.println("----------------");
            System.out.println(game.theCurrentPlayer.getClass() + "Skor: " + game.theCurrentPlayer.point);
            if(game.theCurrentPlayer instanceof HumanPlayer)
            {
                getInput(reader,game);
                game.theCurrentPlayer.play(rowInput,columnInput,game.gameMap,charInput);
                if(!game.isPlayerScored(game.theCurrentPlayer, rowInput,columnInput))
                {
                    game.switchTurn();
                }
                else game.theCurrentPlayer.increasePlayerPoint();
            }
            else
                {
                    game.theCurrentPlayer.play(rowInput,columnInput,game.gameMap,charInput);
                    if(!game.isPlayerScored(game.theCurrentPlayer, rowInput,columnInput))
                    {
                        game.switchTurn();
                    }
                    else game.theCurrentPlayer.increasePlayerPoint();
                }

        }
        System.out.println("Oyun bitti");
    }

    private static void getInput(BufferedReader reader, GameSession game) throws IOException {
        do{
            System.out.print("Satır: ");
            rowInput = Integer.parseInt(reader.readLine());
        }while(rowInput<0 || rowInput> game.mapSize);

        do{
            System.out.print("Sutun: ");
            columnInput = Integer.parseInt(reader.readLine());
        }while(columnInput<0 || columnInput> game.mapSize);

        do{
            System.out.print("S/O: ");
            charInput = (reader.readLine());
            charInput =charInput.toUpperCase(Locale.ROOT);
        }while(!charInput.equalsIgnoreCase("S") && !charInput.equalsIgnoreCase("O"));
    }
}