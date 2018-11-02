package ticTacToe.GUI;

import ticTacToe.Game;
import ticTacToe.GameReferee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridUI extends JButton{
    ImageIcon icon = null;

    static int totalGrids = 0;
    private int gridCoordinatesX;
    private int gridCoordinatesY;

    GridUI(GameReferee referee){
        initializeGridUI(referee);
        gridCoordinatesX = totalGrids % 3;
        gridCoordinatesY = 2 - totalGrids / 3;
        totalGrids++;
    }

    private void initializeGridUI(GameReferee referee){
        setBackground(Color.white);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(icon == null){
                    updateIcon(referee.getPlayingPlayer().getPlayerLetter());
                    referee.setGrid(gridCoordinatesX, gridCoordinatesY, referee.getPlayingPlayer().getPlayerLetter());
                    //System.out.printf("X = %d, Y = %d \n", gridCoordinatesX, gridCoordinatesY);
                    if(referee.horizontalWinCheck() || referee.verticalWinCheck() || referee.diagonalWinCheck()){
                        JOptionPane.showMessageDialog(null, "Kazanan: " + referee.getPlayingPlayer().getPlayerLetter(), "Oyun Bitti!", JOptionPane.PLAIN_MESSAGE);
                        System.exit(1);
                    }
                    

                    referee.endTurn();
                }

            }
        });
    }
    public void updateIcon(char icon){
       // String.format("", )
        String Path = "\\images\\" + icon  + ".png";

        this.icon = new ImageIcon(this.getClass().getResource(Path));
        setIcon(this.icon);
    }
}
