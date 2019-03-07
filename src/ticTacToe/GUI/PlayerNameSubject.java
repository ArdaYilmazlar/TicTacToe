package ticTacToe.GUI;

public interface PlayerNameSubject {
    void registerClickListener(PlayerNameListener playerNameListener);
    void removeClickListener(PlayerNameListener playerNameListener);
    void notifyClickListeners();
}
