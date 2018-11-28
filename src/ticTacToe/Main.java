package ticTacToe;

import ticTacToe.GUI.MainMenuUI;

/*
TODO Update pictures with transparent backgrounds and use anti-aliasing with letters (easy) OR Get rid of the pictures and use letters
TODO Implement AI (hard)
TODO / FIXME Better winCheck methods, also those methods need to send info about tiles that made player win (medium)
TODO ^ Make the button backgrounds green if they cause the win (easy)
TODO Players need to hold score and name (easy)
TODO UI needs to display player attributes correctly (hard, might lead to complete rewrite of TicTacToeUI(GridLayOut might not support this))
TODO Create Options Panel (Medium)
TODO Pressing esc should bring up a menu (easy / medium, code might get confusing)
TODO Add music just to see if i can (???)
TODO Online play (%99 will never implement, might comeback to this project for this in a year)
*/
public class Main {
    public static void main(String[] args) {
        GameReferee referee = new GameReferee(); //Creates a gameReferee to govern the game rules

        MainMenuUI menu = new MainMenuUI();
        initializeListeners(menu, referee);
    }

    private static void initializeListeners(MainMenuUI mainMenuUI, GameReferee referee){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ //Accessing each button
                mainMenuUI.getTicTacToe().getGrid(j, i).registerClickListener(referee); //Notifies the buttons that referee wants to listen to their clicks
                referee.registerWinListener(mainMenuUI.getTicTacToe().getGrid(j, i)); //Notifies the referee that buttons wants to listen to win condition
            }

        }
    }
}
