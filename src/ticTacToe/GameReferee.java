package ticTacToe;

import ticTacToe.GUI.PlayerNameListener;

import java.util.ArrayList;

public class GameReferee implements GridClickListener, WinSubject, CurrentPlayerSubject, ScoreSubject, PlayerNameListener { //Listens to clicks, sends Win signal
    private char[][] grids = new char[3][3]; //Char representation of the board
    private Player playingPlayer; //Current player, not really needed but for easier readability, basically turnHolder[i]
    private Player[] turnHolder = new Player[2]; //To alternate between players
    private ArrayList<WinListener> winListeners = new ArrayList<WinListener>(); //To add as much as listeners I want
    private ArrayList<CurrentPlayerListener> currentPlayerListeners = new ArrayList<CurrentPlayerListener>();
    private ArrayList<ScoreListener> scoreListeners = new ArrayList<ScoreListener>();
    private int turn = 0; //To access to turnHolder
    private int round = 0;

    public GameReferee() {
        turnHolder[0] = new Player('x');
        turnHolder[1] = new Player('o');
        playingPlayer = turnHolder[0];

    }

    private void resetGame(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               grids[i][j] = '\u0000';
            }
        }
        turn = -1;
    }

    public int winCheck() {
        if(horizontalWinCheck() || verticalWinCheck() || diagonalWinCheck()){
            round++;
            playingPlayer.increaseScore();
            resetGame();
            return 1;
        } else if((turn + 1) % 9 == 0){ //Draw
            round++;
            resetGame();
            return -1;
        }
        return 0;
    }
    private boolean horizontalWinCheck(){ //Checks every horizontal line to see if 3 of the same letters are in order
        for(int i = 0; i < 3; i++){
                if(playingPlayer.getPlayerLetter() == grids[0][i]
                        && playingPlayer.getPlayerLetter() == grids[1][i]
                        && playingPlayer.getPlayerLetter() == grids[2][i])
                    return true;
            }
        return false;
    }

    private boolean verticalWinCheck(){ //Checks every vertical line to see if 3 of the same letters are in order
        for(int i = 0; i < 3; i++){
            if(playingPlayer.getPlayerLetter() == grids[i][0]
                    && playingPlayer.getPlayerLetter() == grids[i][1]
                    && playingPlayer.getPlayerLetter() == grids[i][2])
                return true;
        }
        return false;
    }

    private boolean diagonalWinCheck(){ //Checks left and right horizontal line to see if 3 of the same letters are in order
            if(playingPlayer.getPlayerLetter() == grids[0][0]
                    && playingPlayer.getPlayerLetter() == grids[1][1]
                    && playingPlayer.getPlayerLetter() == grids[2][2]
                    || (playingPlayer.getPlayerLetter() == grids[0][2]
                    && playingPlayer.getPlayerLetter() == grids[1][1]
                    && playingPlayer.getPlayerLetter() == grids[2][0]))
                return true;
        return false;
    }

    public void endTurn(){ //Alternates between 0 and 1 to manage playingPlayer
        turn++;
        playingPlayer = turnHolder[turn % 2];
    }

    public Player getPlayingPlayer() {
        return playingPlayer;
    }

    public void gridClickUpdate(int x, int y) { //Works when a button is clicked
        setGrid(x, y, playingPlayer.getPlayerLetter()); //Button sends x and y coordinates of itself, referee updates the grid accordingly
        notifyCurrentPlayerListeners(x, y);
        notifyWinListeners(); //Sending response back to observer
        endTurn(); //no action left, turn ends for the player
    }

    public void playerNameUpdate(String playerOneName, String playerTwoName){
        turnHolder[0].setName(playerOneName);
        turnHolder[1].setName(playerTwoName);
        notifyScoreListeners();
    }

    public void registerWinListener(WinListener winListener) {
        winListeners.add(winListener);
    }

    public void removeWinListener(WinListener winListener) {
        winListeners.remove(winListeners.indexOf(winListener));
    }

    public void notifyWinListeners() { //Checks if the game has ended, sends the result back to observers to update UI
        int win = winCheck();

        for(WinListener winListener: winListeners){
            winListener.winUpdate(win, playingPlayer, turnHolder[0].getScore(), turnHolder[1].getScore());
        }

        if(win == 1){
            notifyScoreListeners();
        }
    }

    public void registerCurrentPlayerListener(CurrentPlayerListener currentPlayerListener){
        currentPlayerListeners.add(currentPlayerListener);

    }

    public void removeCurrentPlayerListener(CurrentPlayerListener currentPlayerListener){
        currentPlayerListeners.remove(currentPlayerListeners.indexOf(currentPlayerListener));
    }

    public void notifyCurrentPlayerListeners(int x, int y){
        for(CurrentPlayerListener currentPlayerListener : currentPlayerListeners){
            currentPlayerListener.currentPlayerUpdate(playingPlayer, x, y);
        }
    }

    public void registerScoreListener(ScoreListener scoreListener){
        scoreListeners.add(scoreListener);
    }

    public void removeScoreListener(ScoreListener scoreListener){
        scoreListeners.remove(scoreListeners.indexOf(scoreListener));
    }
    public void notifyScoreListeners(){
        for(ScoreListener scoreListener : scoreListeners){
            scoreListener.scoreUpdate(turnHolder[0], turnHolder[1], round);
        }
    }

    public char getGrid(int x, int y){
        return grids[x][y];
    }

    public void setGrid(int x, int y, char letter){ grids[x][y] = letter;
    }
}
