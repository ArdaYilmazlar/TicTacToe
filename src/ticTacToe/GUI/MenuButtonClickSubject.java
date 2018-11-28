package ticTacToe.GUI;

public interface MenuButtonClickSubject {
    void registerClickListener(MenuButtonClickListener menuButtonClickListener);
    void removeClickListener(MenuButtonClickListener menuButtonClickListener);
    void notifyClickListeners(); //Sends info to observers waiting for a click
}
