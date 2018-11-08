package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;
/* TODO Update pictures with transparent backgrounds and use anti-aliasing with letters (easy)
TODO Implement AI (hard)
TODO / FIXME Better winCheck methods, also those methods need to send info about tiles that made player win (medium)
TODO ^ Make the button backgrounds green if they cause the win (easy)
TODO Players need to hold score and name (easy)
TODO UI needs to display player attributes correctly (hard, might lead to complete rewrite of TicTacToeUI(GridLayOut might not support this))
TODO Add a main menu and options menu inside that (hard)
TODO Pressing esc should bring up a menu (easy / medium, code might get confusing)
TODO Add music just to see if i can (???)
TODO Online play (%99 will never implement, might comeback to this project for this in a year)
*/
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
