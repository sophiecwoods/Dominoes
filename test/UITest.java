import dominoes.PlayerMode;
import dominoes.TextDominoesUI;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import dominoes.players.HumanPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dominoes.PlayerMode.ComputerPlayer;
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

    @Test
    void numberOfPointsToWin() {
        int numOfPoints = 10;
        textDominoesUI.setNumberOfPointsToWin(numOfPoints);
        assertEquals(numOfPoints, textDominoesUI.getNumberOfPointsToWin());
    }

    @Test
    void playerMode() {
        PlayerMode mode = ComputerPlayer;
        textDominoesUI.setPlayerMode(mode);
        assertEquals(mode, textDominoesUI.getPlayerMode());
    }

    @Test
    void startNewGame() {
        assertEquals(true, textDominoesUI.startNewGame());
    }

    @Test
    void currentRound() {
        assertEquals(0, textDominoesUI.showCurrentRound());
    }

    @Test
    void showBones() {
        DominoPlayer player = new ComputerPlayer();
        assertEquals(0, textDominoesUI.showBones(player));
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
        player1.setPoints(50);
        textDominoesUI.setNumberOfPointsToWin(50);
        String printedString = "Winner: Computer Player\n";
        textDominoesUI.displayGameWinner(player1, player2);
        assertEquals(printedString, outContent.toString());
    }

    @Test
    void displayInvalidMove() {
        String printedString = "Invalid move";
        textDominoesUI.displayInvalidMove();
        assertEquals(printedString, outContent.toString());
    }
}
