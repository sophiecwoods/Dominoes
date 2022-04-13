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
        System.out.println("Round winner: " + dominoPlayer.getName());
    }

    @Override
    public void displayInvalidPlay(DominoPlayer dominoPlayer) {
        System.out.println("Invalid move by " + dominoPlayer.getName());
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
        System.out.println("Press 1 for Interactive Player");
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
            // can we ask the user to enter the human player name here and then set it
            player.setName("HumanPlayer");
            return player;
        } else {
            DominoPlayer player = new ComputerPlayer();
            // if two computer players play against themselves then they will both have the same name
            // which makes it hard to tell which one has won - can we set computerplayer1 and computerplayer2?
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

    public String showBonesInHand(DominoPlayer player){
        Bone[] playerBones = player.bonesInHand();

        String bonesInHand = "";
        for (int i = 0; i < playerBones.length; i++) {
            bonesInHand += i + 1 + " Bone: [" + playerBones[i].left() + "-" + playerBones[i].right() + "]";
            if (i != playerBones.length-1) {
                bonesInHand += ", ";
            }
        }
        return bonesInHand;
    }

    public int numberOfBonesInBoneyard(){return 0;}

    public String viewOfBonesOnTable(Table table){return "";}

    public void humanPlayerDrawBone(DominoPlayer player, BoneYard boneYard){}

    public void humanPlayerPass(DominoPlayer player){}

    public void displayCurrentPoints(DominoPlayer player1, DominoPlayer player2) {
        System.out.println("Points:\n" + player1.getName() + ": " + player1.getPoints() +"\n"
                + player2.getName() + ": " + player2.getPoints());
    }

    public void displayGameWinner(DominoPlayer dominoPlayer) {
        System.out.println("Game Winner: " + dominoPlayer.getName());
    }
}
