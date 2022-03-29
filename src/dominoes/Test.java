package dominoes;

import dominoes.players.ComputerPlayer;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        Dominoes dom = new Dominoes(new TextDominoesUI(), new ComputerPlayer(), new ComputerPlayer(), 50, 6);
        dom.play();
    }
}
