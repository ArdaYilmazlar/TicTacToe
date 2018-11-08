package ticTacToe;

public interface ClickSubject {
    void registerClickListener(ClickListener clickListener);
    void removeClickListener(ClickListener clickListener);
    void notifyClickListeners(); //Sends info to observers waiting for a click
}
