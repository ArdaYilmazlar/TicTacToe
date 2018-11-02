package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;


public class Main {
    public static void main(String[] args) {
        GameReferee referee = new GameReferee();
        new TicTacToeUI(referee);
    }
}
