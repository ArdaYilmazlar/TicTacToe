package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;

public class GameInitializer {
    public GameReferee referee;

    public GameInitializer(){
        //GET PLAYER 1 & 2's letters instead of code below.
        Player player1 = new Player('x');
        Player player2 = new Player('o');
        this.referee = new GameReferee(player1, player2);
    }
}
