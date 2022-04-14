import dominoes.Bone;
import dominoes.BoneYard;
import dominoes.TextDominoesUI;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.HumanPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.mock.TableMock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class UITest {
    private TextDominoesUI textDominoesUI;
    private DominoPlayer player1;
    private DominoPlayer player2;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        textDominoesUI = new TextDominoesUI();
        System.setOut(new PrintStream(outContent));
        player1 = new ComputerPlayer();
        player2 = new HumanPlayer();
        player1.setName("Computer Player");
        player2.setName("Human Player");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    public void inputHelper (String s) { // helper method for testing the input

        String playInput = String.format("%s%s",
                s, System.lineSeparator());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(playInput.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void numberOfPointsToWin() {
        int numOfPoints = 10;
        inputHelper("10");

        int numberOfPointsToWin = textDominoesUI.askNumberOfPointsToWin();

        assertEquals(numOfPoints, numberOfPointsToWin);
    }

    @Test
    void playerMode() {
        inputHelper("1");
        DominoPlayer player1 = textDominoesUI.choosePlayer("1");
        assertEquals(player1.getName(), "HumanPlayer");

        inputHelper("2");
        DominoPlayer player2 = textDominoesUI.choosePlayer("2");
        assertEquals(player2.getName(), "ComputerPlayer");
    }

    @Test
    void startNewGame() {
        assertEquals(true, textDominoesUI.startNewGame());
    }

    @Test
    void currentRound() {
        String printedString = "Current Round: 0\n";
        textDominoesUI.showCurrentRound();
        assertEquals(printedString, outContent.toString());
    }

    @Test
    void showBones() {
        String printedString = "Number of bones Computer Player has: 0\n";
        textDominoesUI.showBones(player1);
        assertEquals(printedString, outContent.toString());
    }

    @Test
    void showBonesInHand(){
        Bone bone1 = new Bone(1,2);
        player2.takeBack(bone1);
        Bone bone2 = new Bone(5,4);
        player2.takeBack(bone2);
        String expected = "1 Bone: [2-1], 2 Bone: [5-4]\n";
        textDominoesUI.showBonesInHand(player2);
        assertEquals(expected, outContent.toString());
    }

    @Test
    void numberOfBonesInBoneyard(){
        BoneYard boneYard = new BoneYard(6);
        String expected = String.valueOf(boneYard.size()) + "\n";
        textDominoesUI.numberOfBonesInBoneyard(boneYard);
        assertEquals(expected, outContent.toString());
    }

    @Test
    void viewOfBonesOnTable(){
        Vector vector = new Vector();
        vector.addElement(new Bone(1,2));
        vector.addElement(new Bone(5,4));
        vector.addElement(new Bone(2,4));
        TableMock table = new TableMock(vector);
        String expected = "[2-1][5-4][4-2]\n";
        textDominoesUI.viewOfBonesOnTable(table);
        assertEquals(expected, outContent.toString());
    }

    @Test
    void humanPlayerDrawBone(){
        BoneYard boneYard = new BoneYard(6);
        int original = player2.numInHand();
        int expected = original + 1;
        textDominoesUI.humanPlayerDrawBone(player2, boneYard);
        int actual = player2.numInHand();
        assertEquals(expected, actual);
    }

    @Test
    void humanPlayerPass() {
//        Vector vector = new Vector();
//        vector.addElement(new Bone(1,2));
//        vector.addElement(new Bone(5,4));
//        TableMock table = new TableMock(vector);
//        String expected = textDominoesUI.viewOfBonesOnTable(table);
//        textDominoesUI.humanPlayerPass(player2);
//        String actual = textDominoesUI.viewOfBonesOnTable(table);
//        assertEquals(expected, actual);
    }


    @Test
    void displayPoints() {
        player1.setPoints(5);
        player2.setPoints(10);
        String printedString = "Points:\nComputer Player: 5\nHuman Player: 10\n";
        textDominoesUI.displayCurrentPoints(player1, player2);
        assertEquals(printedString, outContent.toString());
    }

    @Test
    void displayRoundWinner() {
       String printedString = "Round winner: Computer Player\n";
       textDominoesUI.displayRoundWinner(player1);
       assertEquals(printedString, outContent.toString());
    }

    @Test
    void displayGameWinner() {
        inputHelper("50");
        String printedString = "Game Winner: Computer Player\n";
        textDominoesUI.displayGameWinner(player1);
        assertEquals(printedString, outContent.toString());
    }

    @Test
    void displayInvalidMove() {
        String printedString = "Invalid move by Computer Player\n";
        textDominoesUI.displayInvalidPlay(player1);
        assertEquals(printedString, outContent.toString());
    }
}
