package ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;

public class GridUI extends JButton{
    ImageIcon icon = null;

    GridUI(){
        setBackground(Color.white);
    }

    public void updateIcon(char icon){
        String Path = "\\images\\" + icon  + ".png";

        this.icon = new ImageIcon(this.getClass().getResource(Path));
        setIcon(this.icon);
        getIcon();
    }
}
