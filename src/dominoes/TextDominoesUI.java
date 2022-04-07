package dominoes;

import dominoes.players.DominoPlayer;

public class TextDominoesUI implements DominoUI {
    @Override
    public void display(DominoPlayer[] dominoPlayers, Table table, BoneYard boneYard) {

    }

    @Override
    public void displayRoundWinner(DominoPlayer dominoPlayer) {

    }

    @Override
    public void displayInvalidPlay(DominoPlayer dominoPlayer) {

    }

    public int getNumberOfPointsToWin()
    {
        return 0;
    }

    public void setNumberOfPointsToWin(int points)
    {
    }

    public PlayerMode getPlayerMode()
    {
        return PlayerMode.Unknown;
    }

    public void setPlayerMode(PlayerMode mode)
    {
    }

    public boolean startNewGame()
    {
        return false;
    }

    public int showCurrentRound()
    {
        return 0;
    }

    public int showBones(DominoPlayer player)
    {
        return 0;
    }
}
