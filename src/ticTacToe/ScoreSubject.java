package ticTacToe;

public interface ScoreSubject {
    void registerScoreListener(ScoreListener scoreListener);
    void removeScoreListener(ScoreListener scoreListener);
    void notifyScoreListeners();
}
