package ticTacToe.GUI;

import ticTacToe.Player;

import javax.swing.*;
import java.awt.*;

public class TicTacToeUI {

    JFrame frame = new JFrame("TicTacToe - Arda Yılmazlar");
    JPanel panel = new JPanel();
    GridUI[][] board = new GridUI[3][3]; //Contains buttons

    public TicTacToeUI(){
        initializeBoard();
        initializePanel();
        initializeFrame();


    }
    private void initializeFrame(){
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initializeBoard(){
        for(int i = 0, j = 0; i < 3 && j < 3; i++){
            board[j][i] = new GridUI();

            if(i == 2)
            {
                j++;
                i = -1;
            }

        }
    }
    private void initializePanel(){
        frame.add(panel);
        GridLayout layout = new GridLayout(3, 3);
        layout.setVgap(10);
        layout.setHgap(10);
        panel.setLayout(layout);
        panel.setBackground(Color.ORANGE);


        for(int i = 0, j = 0; i < 3 && j < 3; i++){
            panel.add(board[j][i]);

            if (i == 2) {
                j++;
                i = -1;
            }
        }

    }
}
