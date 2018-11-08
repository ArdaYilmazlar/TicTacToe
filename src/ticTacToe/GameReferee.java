package ticTacToe;

import java.util.ArrayList;

public class GameReferee implements ClickListener, WinSubject { //Listens to clicks, sends Win signal
    private char[][] grids = new char[3][3]; //Char representation of the board
    private Player playingPlayer; //Current player, not really needed but for easier readability, basically turnHolder[i]
    private Player[] turnHolder = new Player[2]; //To alternate between players
    private ArrayList<WinListener> winListeners= new ArrayList<WinListener>(); //To add as much as listeners I want
    private int turn = 0; //To access to turnHolder

    public GameReferee() {
        turnHolder[0] = new Player('x');
        turnHolder[1] = new Player('o');

        playingPlayer = turnHolder[0];
    }

    public boolean winCheck() { //Every WinCheck method needs to be *updated* to send coordinates of winning buttons, those are basically place holder until UI listeners are implemented
        if(horizontalWinCheck() || verticalWinCheck() || diagonalWinCheck())
            return true;
        return false;
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
        turn = (turn + 1) % 2;
        playingPlayer = turnHolder[turn];
    }

    public Player getPlayingPlayer() {
        return playingPlayer;
    }

    public void clickUpdate(int x, int y) { //Works when a button is clicked
        setGrid(x, y, playingPlayer.getPlayerLetter()); //Button sends x and y coordinates of itself, referee updates the grid accordingly
        System.out.print("Referee notified."); //Debugging
        notifyWinListeners(); //Sending response back to observer
        endTurn(); //no action left, turn ends for the player
    }

    public void registerWinListener(WinListener winListener) {
        winListeners.add(winListener);
    }

    public void removeWinListener(WinListener winListener) {
        winListeners.remove(winListeners.indexOf(winListener));
    }

    public void notifyWinListeners() { //Checks if the game has ended, sends the result back to observers to update UI
        boolean win = winCheck();

        for(WinListener winListener: winListeners){
            winListener.winUpdate(win, playingPlayer);
        }

    }

    public char getGrid(int x, int y){
        return grids[x][y];
    }

    public void setGrid(int x, int y, char letter){ grids[x][y] = letter;
    }
}
