package dominoes;

import dominoes.players.ComputerPlayer;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        TextDominoesUI textDominoesUI = new TextDominoesUI();
        int numberOfPointsToWin = textDominoesUI.askNumberOfPointsToWin(System.in);

        Dominoes dom = new Dominoes(textDominoesUI, new ComputerPlayer(), new ComputerPlayer(), numberOfPointsToWin, 6);
        dom.play();
    }
}
