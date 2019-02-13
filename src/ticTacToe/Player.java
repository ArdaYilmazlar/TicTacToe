package ticTacToe;

public class Player {
    static int playerCount = 1;
    private String name;
    private final char playerLetter;
    private int score = 0; //Not implemented yet, To hold points and deciding who won the most rounds

    public Player(char letter){
        this.playerLetter = letter;
        name = String.format("Player%d", playerCount);
        playerCount++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }

    public void increaseScore(){
        score++;
    }

    public int getScore(){
        return score;
    }


}
