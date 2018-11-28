package ticTacToe.GUI;

import ticTacToe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GridUI extends JButton implements GridClickSubject, WinListener { //Fix this so it doesn't extend JButton!, Sends clicks to observers, waiting for win
    ImageIcon icon = null; //No image at start, showing background

    static int totalGrids = 0; //Shared grid count between button objects, used to determine coordinates of the button
    private int gridCoordinatesX;
    private int gridCoordinatesY;
    private Player currentPlayer; //To hold currentPlayer that has been sent by referee through listeners
    private boolean gameEnded = false;
    private ArrayList<GridClickListener> gridClickListeners = new ArrayList<GridClickListener>(); //To hold as much as listeners i want, not needed for now as only referee listens to clicks, added for flexibility

    GridUI(){
        initializeGridUI(); //Initializes how button looks and it's click action listener (Possibly a better way to implement this?)
        gridCoordinatesX = totalGrids % 3; //Those assume 0,0 coordinate is left-bottom
        gridCoordinatesY = 2 - totalGrids / 3;
        totalGrids++;
    }

    private void initializeGridUI(){
        setBackground(Color.white); //White background for buttons

        addActionListener(new ActionListener() { //Listening for mouse click
            public void actionPerformed(ActionEvent e)
            {
                if(icon == null){ //To see if the tile has been set already
                    notifyClickListeners();
                    updateIcon(Character.toString(currentPlayer.getPlayerLetter())); //Updates icon accordingly to currentPlayer so it shows the image representation of the letter
                    System.out.printf("X = %d, Y = %d \n", gridCoordinatesX, gridCoordinatesY); //Debug
                    if(gameEnded){ //No score system for now, so it just exits
                        JOptionPane.showMessageDialog(null, "Winner: " + currentPlayer.getPlayerLetter(), "Game over!", JOptionPane.PLAIN_MESSAGE);
                        System.exit(1);
                    }
                    }
                }

            }
        );
    }
    public void updateIcon(String icon){
        String Path = String.format("\\images\\%s.png", icon); //Images are in a subfolder of GUI

        this.icon = new ImageIcon(this.getClass().getResource(Path)); //gets location of GridUI, adds Path then creates a ImageIcon object with the picture
        setIcon(this.icon); //Jbutton setIcon
    }

    public void registerClickListener(GridClickListener gridClickListener) {
        gridClickListeners.add(gridClickListener);
    }

    public void removeClickListener(GridClickListener gridClickListener) {
        gridClickListeners.remove(gridClickListeners.indexOf(gridClickListener));
    }

    public void notifyClickListeners() {
        for(GridClickListener obs : gridClickListeners){ //Enhanced for loop to access every listener
            obs.gridClickUpdate(gridCoordinatesX, gridCoordinatesY); //Sends coordinates of clicked button
        }
    }

    public void winUpdate(boolean win, Player player) { //referee sends back game information
        currentPlayer = player;
        gameEnded = win;
    }
}
