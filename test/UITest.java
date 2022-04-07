import dominoes.PlayerMode;
import dominoes.TextDominoesUI;

import dominoes.players.ComputerPlayer;
import dominoes.players.DominoPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dominoes.PlayerMode.ComputerPlayer;
import static org.junit.jupiter.api.Assertions.*;

public class UITest {
    private TextDominoesUI textDominoesUI;

    @BeforeEach
    void setUp() {
        textDominoesUI = new TextDominoesUI();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNumberOfPointsToWin() {
        int numOfPoints = 10;
        textDominoesUI.setNumberOfPointsToWin(numOfPoints);
        assertEquals(numOfPoints, textDominoesUI.getNumberOfPointsToWin());
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


}
