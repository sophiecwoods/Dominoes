package dominoes.players;

import dominoes.*;

import java.util.Vector;

public class ComputerPlayer implements DominoPlayer {

    Vector myBones = new Vector();
    String name;
    int points;

    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int leftPips = table.left();
        int rightPips = table.right();

        for (int i = 0; i < myBones.size(); i++) {
            Bone b = (Bone) myBones.get(i);
            if (b.left() == leftPips || b.right() == leftPips) {
                myBones.remove(i);
                System.out.println("points " + getPoints());
                return new Play(b, Play.LEFT);
            }
            else if (b.left() == rightPips || b.right() == rightPips) {
                myBones.remove(i);
                System.out.println("points " + getPoints());
                return new Play(b, Play.RIGHT);
            }
        }
        System.out.println("points " + getPoints());
        throw new CantPlayException();
    }

    @Override
    public void takeBack(Bone bone) {
        myBones.addElement(bone);
    }

    @Override
    public void draw(BoneYard boneYard) {
        myBones.addElement(boneYard.draw());
    }

    @Override
    public int numInHand() {
        return myBones.size();
    }

    @Override
    public Bone[] bonesInHand() {
        Bone[] bones = new Bone[myBones.size()];
        for (int i = 0; i < myBones.size(); i++) {
            bones[i] = (Bone) myBones.get(i);
        }
        return bones;
    }

    @Override
    public void newRound() {
        this.myBones = new Vector();
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void setPoints(int i) {
        this.points = i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        this.name = s;
    }
}
