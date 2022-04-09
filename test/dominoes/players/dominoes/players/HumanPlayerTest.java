package dominoes.players;

import dominoes.*;
import test.mock.TableMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer;
    private Table table;
    private Vector vector;

    @BeforeEach
    void setUp(){
        humanPlayer = new HumanPlayer();
        vector = new Vector();
        vector.addElement(new Bone(4,3));
        table = new TableMock(vector);
        humanPlayer.bones = new ArrayList<>(Arrays.asList(new Bone(1,2), new Bone(4,5), new Bone(3,6)));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validMakePlayLeft() throws CantPlayException {

        inputHelper("2", "0"); //second bone in hand, left side of table
        Play actual = humanPlayer.makePlay(table);
        assertNotNull(actual);
    }

    @Test
    void validMakePlayRight() throws CantPlayException {

        inputHelper("3", "1");
        Play actual = humanPlayer.makePlay(table);
        assertNotNull(actual);
    }

    @Test
    void invalidMakePlay1() throws CantPlayException {

        inputHelper("3", "0");
        Assertions.assertThrows(CantPlayException.class, () -> humanPlayer.makePlay(table));
    }

    @Test
    void invalidMakePlay2() throws CantPlayException {

        inputHelper("4", "0");
        Assertions.assertThrows(CantPlayException.class, () -> humanPlayer.makePlay(table));
    }

    @Test
    void bonesInHand() throws CantPlayException {

        inputHelper("2", "0");

        Play play = humanPlayer.makePlay(table);
        Bone[] actual = humanPlayer.bonesInHand();
        String actualBones = "[";
        for (int i = 0; i < actual.length; i++){
            actualBones += (i + 1) + " Bone: [" + actual[i].left() + "-" + actual[i].right() + "]";
            if (i != actual.length-1) {
                actualBones += ", ";
            }
        }
        actualBones += "]";
        String expectedBones = "[1 Bone: [2-1], 2 Bone: [6-3]]";

        assertEquals(expectedBones, actualBones);

    }

    public void inputHelper (String bone, String side) { //helper method for testing the input

        String playInput = String.format("%s%s%s%s",
                bone, System.lineSeparator(),
                side, System.lineSeparator());
        ByteArrayInputStream boneInputStream = new ByteArrayInputStream(playInput.getBytes());
        System.setIn(boneInputStream);
    }

}
