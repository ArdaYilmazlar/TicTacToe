package ticTacToe;

public interface CurrentPlayerSubject {
    void registerCurrentPlayerListener(CurrentPlayerListener currentPlayerListener);
    void removeCurrentPlayerListener(CurrentPlayerListener currentPlayerListener);
    void notifyCurrentPlayerListeners(int x, int y); //Notifies observers which are listening to currentPlayer condition

}
