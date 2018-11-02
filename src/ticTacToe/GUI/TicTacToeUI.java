package ticTacToe.GUI;

import ticTacToe.Game;
import ticTacToe.GameReferee;

import javax.swing.*;
import java.awt.*;

public class TicTacToeUI {

    JFrame frame = new JFrame("TicTacToe - Arda Yılmazlar");
    JPanel panel = new JPanel();
    GridUI[][] board = new GridUI[3][3]; //Contains buttons

    public TicTacToeUI(GameReferee referee){
        initializeBoard(referee);
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

    private void initializeBoard(GameReferee referee){
        for(int i = 0, j = 0; i < 3 && j < 3; i++){
            board[j][i] = new GridUI(referee);

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
