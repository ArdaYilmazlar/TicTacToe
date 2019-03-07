package ticTacToe;

import ticTacToe.GUI.MainMenuPanel;

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

        MainMenuPanel menu = new MainMenuPanel();
        initializeListeners(menu, referee);
    }

    private static void initializeListeners(MainMenuPanel mainMenuPanel, GameReferee referee){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ //Accessing each button
                mainMenuPanel.getTicTacToe().getGrid(j, i).registerClickListener(referee); //Notifies the buttons that referee wants to listen to their click
                referee.registerCurrentPlayerListener(mainMenuPanel.getTicTacToe().getGrid(j, i)); //Notifies the referee that buttons wants to listen to currentPlayer
            }
        }
        mainMenuPanel.getOptions().registerClickListener(referee);
        referee.registerWinListener(mainMenuPanel.getTicTacToe());
        referee.registerScoreListener(mainMenuPanel.getTicTacToe());
        referee.notifyScoreListeners();
    }
}
