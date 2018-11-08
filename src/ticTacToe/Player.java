package ticTacToe;

public class Player {
   // private String name; //Not implemented yet, To hold names
    private final char playerLetter;
    //private int point; //Not implemented yet, To hold points and deciding who won the most rounds

    public Player(char letter){
        this.playerLetter = letter;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }


}
