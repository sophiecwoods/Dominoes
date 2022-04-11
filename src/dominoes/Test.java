package dominoes;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        TextDominoesUI textDominoesUI = new TextDominoesUI();
        int numberOfPointsToWin = textDominoesUI.askNumberOfPointsToWin();
        DominoPlayer Player1 = textDominoesUI.choosePlayer("1");
        DominoPlayer Player2 = textDominoesUI.choosePlayer("2");

        Dominoes dom = new Dominoes(textDominoesUI, Player1, Player2, numberOfPointsToWin, 6);
        dom.play();
    }
}
