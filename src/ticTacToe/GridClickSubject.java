package ticTacToe;

public interface GridClickSubject {
    void registerClickListener(GridClickListener gridClickListener);
    void removeClickListener(GridClickListener gridClickListener);
    void notifyClickListeners(); //Sends info to observers waiting for a click
}
