package dominoes.players;

import dominoes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements DominoPlayer {
    private int points = 0;
    private String name;
    private ArrayList<Bone> bones = new ArrayList<>();

    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int leftPips = table.left();
        int rightPips = table.right();

        ArrayList<String> options = new ArrayList<>(); //available bones
        for (int i = 0; i < bones.size(); i++){
            options.add((i + 1) + " Bone: [" + bones.get(i).left() + "-" + bones.get(i).right() + "]");
        }

        System.out.println(options);

        Scanner inputBone = new Scanner(System.in);
        System.out.println("Please select a bone");
        int selectedBone = Integer.parseInt(inputBone.nextLine()) -1;

        Scanner inputSide = new Scanner(System.in);
        System.out.println("Please select a side, 0 for left, 1 for right");
        int selectedSide = Integer.parseInt(inputSide.nextLine());

        Play result;
        var bone = bones.get(selectedBone);

        if ((selectedSide == 0 && (bone.left() == leftPips || bone.right() == leftPips))
            || (selectedSide == 1 && (bone.left() == rightPips || bone.right() == rightPips))) {
            result = new Play(bone, selectedSide);
        } else {
            System.out.println("Can't play");
            throw new CantPlayException();
        }

        bones.remove(selectedBone);

        return result;

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
        this.points = 0;
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
        return this.name;
    }

    @Override
    public void setName(String s) {
        this.name = s;
    }
}
