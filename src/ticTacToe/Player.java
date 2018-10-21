package ticTacToe;

public class Player {
    private char playerLetter;

    public Player(char letter){
        setPlayerLetter(letter);
    }

    public char getPlayerLetter() {
        return playerLetter;
    }

    private void setPlayerLetter(char playerLetter) {
        this.playerLetter = playerLetter;
    }

}
