package dominoes;

import dominoes.players.DominoPlayer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.InputStream;
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

    public int askNumberOfPointsToWin(InputStream stdin) {
        boolean validInput = false;
        int numOfPoints = 0;

        while (!validInput) {

            Scanner input = new Scanner(stdin);
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

    public PlayerMode getPlayerMode()
    {
        return PlayerMode.Unknown;
    }

    public void setPlayerMode(PlayerMode mode)
    {
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
