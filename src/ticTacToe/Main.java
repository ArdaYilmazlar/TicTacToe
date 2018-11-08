package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;


public class Main {
    public static void main(String[] args) {
        GameReferee referee = new GameReferee(); //Creates a gameReferee to govern the game rules
        TicTacToeUI UI = new TicTacToeUI(); //Creates UI
        initializeListeners(UI, referee); //Initializes listeners between buttons and referee, not yet implemented but will add listeners to UI too
    }

    private static void initializeListeners(TicTacToeUI UI, GameReferee referee){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ //Accessing each button
                UI.getGrids()[j][i].registerClickListener(referee); //Notifies the buttons that referee wants to listen to their clicks
                referee.registerWinListener(UI.getGrids()[j][i]); //Notifies the referee that buttons wants to listen to win condition
            }

        }
    }
}
