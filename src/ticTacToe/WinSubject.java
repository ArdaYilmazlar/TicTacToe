package ticTacToe;

public interface WinSubject {
    void registerWinListener(WinListener winListener);
    void removeWinListener(WinListener winListener);
    void notifyWinListeners(); //Notifies observers which are expecting win condition
}
