package dominoes;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.HumanPlayer;

import java.util.Scanner;

public class TextDominoesUI implements DominoUI {
    @Override
    public void display(DominoPlayer[] dominoPlayers, Table table, BoneYard boneYard) {

    }

    @Override
    public void displayRoundWinner(DominoPlayer dominoPlayer) {

    }

    @Override
    public void displayInvalidPlay(DominoPlayer dominoPlayer) {

    }

    public int askNumberOfPointsToWin() {
        boolean validInput = false;
        int numOfPoints = 0;

        while (!validInput) {

            Scanner input = new Scanner(System.in);
            System.out.println("Specify the number of points necessary to win:");
            try {
                numOfPoints = input.nextInt();
                if (numOfPoints > 0 && numOfPoints < Integer.MAX_VALUE) {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        return numOfPoints;
    }

    public DominoPlayer choosePlayer(String number) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose Player " + number + ".");
        System.out.println("Press 1for Interactive Player");
        System.out.println("Press 2 for Computer Player");

        var playerNum = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                playerNum = input.nextInt();
                if (playerNum == 1 || playerNum == 2) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                validInput = false;
            }
        }

        if(playerNum == 1){
            DominoPlayer player = new HumanPlayer();
            player.setName("HumanPlayer");
            return player;
        } else {
            DominoPlayer player = new ComputerPlayer();
            player.setName("ComputerPlayer");
            return player;
        }
    }

    public boolean startNewGame()
    {
        return false;
    }

    public int showCurrentRound()
    {
        return 0;
    }

    public int showBones(DominoPlayer player)
    {
        return 0;
    }

    public void displayCurrentPoints(DominoPlayer player1, DominoPlayer player2) {

    }

    public void displayGameWinner(DominoPlayer player1, DominoPlayer player2) {

    }

    public void displayInvalidMove() {

    }
}
