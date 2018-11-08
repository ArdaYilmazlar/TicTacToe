package ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;

public class TicTacToeUI {

    JFrame frame = new JFrame("TicTacToe - Arda Yılmazlar"); //Creates frame
    JPanel panel = new JPanel(); //Crates panel
    GridUI[][] board = new GridUI[3][3]; //Contains buttons

    public TicTacToeUI(){ //Each part initialized in different methods for easier debugging
        initializeBoard(); //Top layer gets created
        initializePanel(); //Second layer gets created
        initializeFrame(); //Bottom layer gets created
    }
    private void initializeFrame(){
        frame.setSize(500, 500); //500 x 500 window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Pressing X button terminates the program
        frame.setResizable(false); //Not resizable
        frame.setLocationRelativeTo(null); //Centers the program to the screen
        frame.setVisible(true); //Makes it visible to user
    }

    private void initializeBoard(){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){ //Fills array with buttons
                board[j][i] = new GridUI();
            }
        }
    }

    private void initializePanel(){
        frame.add(panel); //Panel is added to frame
        GridLayout layout = new GridLayout(3, 3); //GridLayOut, might prove problematic with Player names and scores (not the same size as buttons)
        layout.setVgap(10); //Adds gap between buttons, hence more TicTacToe'y feeling
        layout.setHgap(10);
        panel.setLayout(layout); //GirdLayOut is added to Panel
        panel.setBackground(Color.ORANGE); //Orange background because it looks nice

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){ //Each button is added to panel
                panel.add(board[j][i]);
            }
        }

    }
    public GridUI[][] getGrids(){
        return board;
    }
}
