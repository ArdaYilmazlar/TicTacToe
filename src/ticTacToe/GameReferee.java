package ticTacToe;

public class GameReferee extends Game{

    private Player playingPlayer;
    private Player[] turnHolder = new Player[2];
    private int i = 0;

    public GameReferee() {
        turnHolder[0] = player1;
        turnHolder[1] = player2;

        playingPlayer = player1;
    }

    public boolean winCheck() {
        return false;
    }
    public boolean horizontalWinCheck(){
        for(int i = 0; i < 3; i++){
                if(playingPlayer.getPlayerLetter() == getGrid(0, i)
                        && playingPlayer.getPlayerLetter() == getGrid(1, i)
                        && playingPlayer.getPlayerLetter() == getGrid(2, i))
                    return true;
            }
        return false;
    }

    public boolean verticalWinCheck(){
        for(int i = 0; i < 3; i++){
            if(playingPlayer.getPlayerLetter() == getGrid(i, 0)
                    && playingPlayer.getPlayerLetter() == getGrid(i, 1)
                    && playingPlayer.getPlayerLetter() == getGrid(i, 2))
                return true;
        }
        return false;
    }

    public boolean diagonalWinCheck(){
            if(playingPlayer.getPlayerLetter() == getGrid(0, 0)
                    && playingPlayer.getPlayerLetter() == getGrid(1, 1)
                    && playingPlayer.getPlayerLetter() == getGrid(2, 2)
                    || (playingPlayer.getPlayerLetter() == getGrid(0, 2)
                    && playingPlayer.getPlayerLetter() == getGrid(1, 1)
                    && playingPlayer.getPlayerLetter() == getGrid(2, 0)))
                return true;
        return false;
    }

    public void endTurn(){
        i++;
        i %= 2;
        playingPlayer = turnHolder[i];
    }

    public Player getPlayingPlayer() {
        return playingPlayer;
    }
}
