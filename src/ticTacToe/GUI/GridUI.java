package ticTacToe.GUI;

import ticTacToe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridUI extends JButton{
    ImageIcon icon = null;

    GridUI(){
        initializeGridUI();
    }
    private void initializeGridUI(){
        setBackground(Color.white);

        addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                updateIcon('x');
            }
        });
    }
    public void updateIcon(char icon){
        String Path = "\\images\\" + icon  + ".png";

        this.icon = new ImageIcon(this.getClass().getResource(Path));
        setIcon(this.icon);
        getIcon();
    }
}
