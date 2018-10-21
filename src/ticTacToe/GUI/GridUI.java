package ticTacToe.GUI;

import ticTacToe.GameInitializer;
import ticTacToe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridUI extends JButton{
    ImageIcon icon = null;

    GridUI(GameInitializer game){
        initializeGridUI(game);
    }

    private void initializeGridUI(GameInitializer game){
        setBackground(Color.white);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                updateIcon(game.referee.playingPlayer.getPlayerLetter());
                game.referee.endTurn();
            }
        });
    }
    public void updateIcon(char icon){
        String Path = "\\images\\" + icon  + ".png";

        this.icon = new ImageIcon(this.getClass().getResource(Path));
        setIcon(this.icon);
    }
}
