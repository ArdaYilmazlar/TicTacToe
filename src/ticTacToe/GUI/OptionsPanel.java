package ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptionsPanel implements PlayerNameSubject{

    private JPanel panel = new JPanel();
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints gridBagConstraints =  new GridBagConstraints();
    private GridBagConstraints optionsLabelConstraints = new GridBagConstraints();

    private ArrayList<PlayerNameListener> playerNameListeners = new ArrayList<PlayerNameListener>();

    private MenuButton menuButton = new MenuButton("Main Menu", "MainMenu");
    private GridBagConstraints menuButtonConstraints = new GridBagConstraints();

    private JLabel playerOneLabel = new JLabel("Player 'X' Name: ");
    private JLabel playerTwoLabel = new JLabel("Player 'O' Name: ");
    private JLabel optionsLabel;
    private JTextField playerOneNameField = new JTextField(10);
    private JTextField playerTwoNameField = new JTextField(10);

    private String playerOneName = "X";
    private String playerTwoName = "O";

    protected OptionsPanel(){
        initializeOptionsLabel();
        initializePlayerOneNameField();
        initializePlayerTwoNameField();
        initializeMenuButton();
        initializePanel();
    }

    private void initializeMenuButton(){
        menuButton.getMenuButton().setBackground(Color.WHITE);
        menuButton.getMenuButton().setFocusable(false);
        menuButton.getMenuButton().setPreferredSize(new Dimension(150, 30));
        menuButtonConstraints.gridy = 2;
        menuButtonConstraints.insets = new Insets(0,-330,-340,0);
    }

    private void initializePlayerTwoNameField(){
        playerTwoNameField.setText(playerTwoName);

        playerTwoNameField.addActionListener(new ActionListener() { //Listening for enter
            public void actionPerformed(ActionEvent e)
            {
                if(playerTwoNameField.getText().length() < 10)
                    playerTwoName = playerTwoNameField.getText();
                else
                    playerTwoName = playerTwoNameField.getText().substring(0, 10);
                notifyClickListeners();
                System.out.print(playerTwoName);
            }
        });
    }

    private void initializePlayerOneNameField(){
        playerOneNameField.setText(playerOneName);

        playerOneNameField.addActionListener(new ActionListener() { //Listening for enter
            public void actionPerformed(ActionEvent e)
            {
                if(playerOneNameField.getText().length() < 10)
                    playerOneName = playerOneNameField.getText();
                else
                    playerOneName = playerOneNameField.getText().substring(0,10);
                notifyClickListeners();
            }
        });
    }

    private void initializePanel(){
        panel.setLayout(gridBagLayout); //GridBagLayOut is added to Panel
        panel.setBackground(Color.ORANGE); //Orange background because it looks nice


        panel.add(optionsLabel, optionsLabelConstraints);


        gridBagConstraints.insets = new Insets(0,-200,0,0);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        panel.add(playerOneLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        panel.add(playerOneNameField, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        panel.add(playerTwoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        panel.add(playerTwoNameField, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        panel.add(menuButton.getMenuButton(), menuButtonConstraints);
    }

    protected MenuButton getMenuButton(){
        return menuButton;
    }

    private void initializeOptionsLabel(){
        optionsLabel = new JLabel("Options");
        optionsLabel.setFont(new Font("", Font.BOLD, 75));
        optionsLabelConstraints.insets = new Insets(-150,0,150,0);
    }

    public void registerClickListener(PlayerNameListener playerNameListener){
        playerNameListeners.add(playerNameListener);
    }
    public void removeClickListener(PlayerNameListener playerNameListener){
        playerNameListeners.remove(playerNameListeners.indexOf(playerNameListener));
    }
    public void notifyClickListeners(){
        for(PlayerNameListener playerNameListener: playerNameListeners){
            playerNameListener.playerNameUpdate(playerOneName, playerTwoName);
        }
    }

    protected JPanel getPanel() {
        return panel;
    }

}
