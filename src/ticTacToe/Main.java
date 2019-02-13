package ticTacToe;

import ticTacToe.GUI.MainMenuUI;

/*
TODO Implement AI (hard)
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
                mainMenuUI.getTicTacToe().getGrid(j, i).registerClickListener(referee); //Notifies the buttons that referee wants to listen to their click
                referee.registerCurrentPlayerListener(mainMenuUI.getTicTacToe().getGrid(j, i)); //Notifies the referee that buttons wants to listen to currentPlayer
            }
        }
        referee.registerWinListener(mainMenuUI.getTicTacToe());
        referee.registerScoreListener(mainMenuUI.getTicTacToe());
        referee.notifyScoreListeners();
    }
}
