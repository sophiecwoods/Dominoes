package dominoes.players;

import dominoes.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;
    private Table table;

    @BeforeEach
    void setUp () {
        computerPlayer = new ComputerPlayer();
        // set the bones on the table
        Vector vector = new Vector();
        vector.addElement(new Bone(1, 2));
        table = new TableMock(vector);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void makePlayValid() throws CantPlayException {
        // test makePlay returns Play object when valid play is possible
        computerPlayer.bones = new ArrayList<>(Arrays.asList(new Bone(1, 4), new Bone(6, 6)));
        Play actualPlay = computerPlayer.makePlay(table);
        assertTrue(actualPlay != null);
    }

    @Test
    void makePlayCantPlay() {
        // test makePlay throws exception when no play is possible
        computerPlayer.bones = new ArrayList<>(Arrays.asList(new Bone(3, 4), new Bone(6, 6)));
        Assertions.assertThrows(CantPlayException.class, () -> { computerPlayer.makePlay(table);});
    }
}
