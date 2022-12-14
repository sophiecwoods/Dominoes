package dominoes.players;

import dominoes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements DominoPlayer {
    private int points = 0;
    private String name;
    protected ArrayList<Bone> bones = new ArrayList<>();
    private Integer currentRound = 0;
    private final CubbyHole cubbyHole = CubbyHoleFactory.getCubbyHole();
    private TextDominoesUI ui = new TextDominoesUI();

    @Override
    public Play makePlay(Table table) throws CantPlayException {
        int leftPips = table.left();
        int rightPips = table.right();

        Scanner input = new Scanner(System.in);

        System.out.println(name + ", please select a bone, press 0 for pass, or b to draw a bone. " +
                "Press n to start a new game.");

        var in = input.nextLine();

        if(passTurn(in)) {
            throw new CantPlayException();
        }

        int selectedBone = validBone(in, bones);

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
            ui.displayInvalidPlay(this);
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
        bones = new ArrayList<>();
        currentRound ++;
        cubbyHole.put(currentRound);
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

    public int validBone(String s, ArrayList<Bone> a) throws CantPlayException {
        if (s.equals("b")){
            throw new CantPlayException();
        } else if (s.equals("n")){
            ui.startNewGame();
        }
        int selectedBoneNum = -1;
        try {
            selectedBoneNum = Integer.parseInt(s)-1;
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input, please input numbers, or b to draw from boneyard.");
            return -1;
        }
        if ((selectedBoneNum < 0) || (selectedBoneNum > a.size()-1)) {
            System.out.println("No such bone, please try again.");
            return -1;
        }
        return selectedBoneNum;
    }

    private boolean passTurn(String s) {
        try {
            int input = Integer.parseInt(s);
            if(input == 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
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

    public int getCurrentRound() {
        return currentRound;
    }
}
