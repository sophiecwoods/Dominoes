package dominoes.players;

import dominoes.*;

public class ComputerPlayer implements DominoPlayer {
    @Override
    public Play makePlay(Table table) throws CantPlayException {
        return null;
    }

    @Override
    public void takeBack(Bone bone) {

    }

    @Override
    public void draw(BoneYard boneYard) {

    }

    @Override
    public int numInHand() {
        return 0;
    }

    @Override
    public Bone[] bonesInHand() {
        return new Bone[0];
    }

    @Override
    public void newRound() {

    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public void setPoints(int i) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String s) {

    }
}
