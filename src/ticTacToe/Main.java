package ticTacToe;

import ticTacToe.GUI.TicTacToeUI;


public class Main {
    public static void main(String[] args) {
        Player player1 = new Player('x');
        Player player2 = new Player('o');

        new TicTacToeUI();
    }
}
