package dominoes.players;

import dominoes.*;

import java.util.ArrayList;

public class ComputerPlayer implements DominoPlayer {
    private int points = 0;
    private String name;
    private ArrayList<Bone> bones = new ArrayList<>();

    @Override
    public Play makePlay(Table table) throws CantPlayException {
        // game logic goes here
        for(int i = 0; i < bones.size(); ++i)
        {
            if(bones.get(i).left() == table.left())
            {
                Play play = new Play(bones.get(i), Play.LEFT);
                bones.remove(i);
                return play;
            }
            else if(bones.get(i).right() == table.right())
            {
                Play play = new Play(bones.get(i), Play.RIGHT);
                bones.remove(i);
                return play;
            }
        }

        throw new CantPlayException();
    }

    @Override
    public void takeBack(Bone bone) {
        bones.add(bone);
    }

    @Override
    public void draw(BoneYard boneYard) {
        bones.add(boneYard.draw());
    }

    @Override
    public int numInHand() {
        return bones.size();
    }

    @Override
    public Bone[] bonesInHand() {
        Bone[] bonesArray = new Bone[bones.size()];
        bonesArray = bones.toArray(bonesArray);
        return bonesArray;
    }

    @Override
    public void newRound() {
        points = 0;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int i) {
        points = i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        name = s;
    }
}
