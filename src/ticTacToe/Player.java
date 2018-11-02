package ticTacToe;

public class Player {
   // private String name;
    private final char playerLetter;
    //private int point;

    public Player(char letter){
        this.playerLetter = letter;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }


}
