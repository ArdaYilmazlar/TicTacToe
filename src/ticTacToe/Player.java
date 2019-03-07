package ticTacToe;

public class Player {
    private String name;
    private final char playerLetter;
    private int score = 0;

    protected Player(char letter){
        this.playerLetter = letter;
        name = Character.toString(Character.toUpperCase(letter));

    }

    protected void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }

    protected void increaseScore(){
        score++;
    }

    public int getScore(){
        return score;
    }


}
