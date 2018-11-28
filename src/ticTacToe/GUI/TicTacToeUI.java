package ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;

public class TicTacToeUI {

    JPanel panel = new JPanel(); //Crates panel
    GridUI[][] board = new GridUI[3][3]; //Contains buttons

    public TicTacToeUI(){ //Each part initialized in different methods for easier debugging
        initializeBoard(); //Top layer gets created
        initializePanel(); //Second layer gets created
    }

    private void initializeBoard(){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){ //Fills array with buttons
                board[j][i] = new GridUI();
            }
        }
    }

    private void initializePanel(){
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

    public GridUI getGrid(int x, int y){
        return board[x][y];
    }

    public JPanel getPanel() {
        return panel;
    }
}
