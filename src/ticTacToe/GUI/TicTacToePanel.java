package ticTacToe.GUI;

import ticTacToe.Player;
import ticTacToe.ScoreListener;
import ticTacToe.WinListener;

import javax.swing.*;
import java.awt.*;

public class TicTacToePanel implements ScoreListener, WinListener {

    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints buttonConstraints = new GridBagConstraints();
    private GridBagConstraints infoConstraints = new GridBagConstraints();
    private JPanel panel = new JPanel(); //Crates panel
    private JLabel player1Score;
    private JLabel player2Score;
    private JLabel roundCount;
    GridUI[][] board = new GridUI[3][3]; //Contains buttons


    public TicTacToePanel(){ //Each part initialized in different methods for easier debugging
        initializeScoreSystem();
        initializeBoard(); //Top layer gets created
        initializePanel(); //Bottom layer gets created
    }

    private void resetButtons(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].resetIcon();
            }

        }
    }

    private void initializeScoreSystem(){
        player1Score = new JLabel();
        player2Score = new JLabel();
        roundCount = new JLabel();
    }
    private void initializeBoard(){
        buttonConstraints.insets = new Insets(5,5,5,5);

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){ //Fills array with buttons
                board[j][i] = new GridUI();
                board[j][i].setPreferredSize(new Dimension(135,135));
                //board[j][i].setMaximumSize(new Dimension(150,150));
               // board[j][i].setMinimumSize(new Dimension(150,150));
            }
        }
    }

    private void initializePanel(){
        panel.setLayout(gridBagLayout); //GridBagLayOut is added to Panel
        panel.setBackground(Color.ORANGE); //Orange background because it looks nice

        infoConstraints.gridx = 0;
        panel.add(player1Score, infoConstraints);
        infoConstraints.gridx = 1;
        panel.add(roundCount, infoConstraints);
        infoConstraints.gridx = 2;
        panel.add(player2Score, infoConstraints);

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){ //Each button is added to panel
                buttonConstraints.gridx = j;
                buttonConstraints.gridy = i + 1; //i = 0 is reserved for score
                panel.add(board[j][i], buttonConstraints);
            }
        }

    }

    public void winUpdate(int win, Player player, int playerOneScore, int playerTwoScore){
        if(win == 1){
            JOptionPane.showMessageDialog(null, String.format("%s has won this round!", player.getName()), "Congratulations", JOptionPane.PLAIN_MESSAGE);
            resetButtons();
        } else if(win == -1){
            JOptionPane.showMessageDialog(null, "Draw!");
            resetButtons();
        }

    }

    public void scoreUpdate(Player playerOne, Player playerTwo, int round){
        this.player1Score.setText(String.format("%s : %d", playerOne.getName(), playerOne.getScore()));
        this.player2Score.setText(String.format("%s : %d", playerTwo.getName(), playerTwo.getScore()));
        this.roundCount.setText(String.format("Round : %d", round));
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
