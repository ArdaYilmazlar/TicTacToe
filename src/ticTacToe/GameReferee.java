package ticTacToe;

public class GameReferee {
    public Player playingPlayer;
    private Player[] turnHolder = new Player[2];
    private int i = 0;

    public GameReferee(Player Player1, Player Player2) {
        turnHolder[0] = Player1;
        turnHolder[1] = Player2;

        playingPlayer = Player1;
    }

    public void endTurn(){
        i++;
        i %= 2;
        playingPlayer = turnHolder[i];
    }
}
