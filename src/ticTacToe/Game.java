package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;

public class Game {
    private char[][] grids = new char[3][3];
    Player player1;
    Player player2;

    public Game(){
        //GET PLAYER 1 & 2's letters instead of code below.
        player1 = new Player('x');
        player2 = new Player('o');
    }

    public char getGrid(int x, int y){
        return grids[x][y];
    }

    public char setGrid(int x, int y, char letter){
        return grids[x][y] = letter;
    }

}
