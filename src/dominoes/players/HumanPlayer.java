package dominoes.players;

import dominoes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements DominoPlayer {
    private int points = 0;
    private String name;
    protected ArrayList<Bone> bones = new ArrayList<>();

    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int leftPips = table.left();
        int rightPips = table.right();

        Scanner input = new Scanner(System.in);
        System.out.println("Please select a bone");
        int selectedBone = validBone(input.nextLine(), bones);

        while (selectedBone == -1){
            selectedBone = validBone(input.nextLine(), bones);
        }

        System.out.println("Please select a side, 0 for left, 1 for right");
        int selectedSide = validSide(input.nextLine());

        while (selectedSide == -1) {
            selectedSide = validSide(input.nextLine());
        }

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

    public int validBone(String s, ArrayList<Bone> a){
        int selectedBoneNum = -1;
        try {
            selectedBoneNum = Integer.parseInt(s)-1;
        } catch (Exception e) {
            System.out.println("Not a valid input, please input numbers.");
            return -1;
        }
        if ((selectedBoneNum < 0) || (selectedBoneNum > a.size()-1)) {
            System.out.println("No such bone, please try again.");
            return -1;
        }
        return selectedBoneNum;
    }

    public int validSide(String s){
        int selectedSideNum = -1;
        try {
            selectedSideNum = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Not a valid input, please input numbers.");
            return -1;
        }
        if ((selectedSideNum < 0) || (selectedSideNum > 1)) {
            System.out.println("You must pick 0 or 1");
            return -1;
        }
        return selectedSideNum;
    }
}
