package ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI implements MenuButtonClickListener{

    private JFrame frame = new JFrame("TicTacToe - Arda Yılmazlar");
    private TicTacToeUI ticTacToe = new TicTacToeUI(); //Might not need a reference to TicTacToeUI, check back later
    private JPanel panelMenu = new JPanel(); //Main menu which holds TicTacToe and Options buttons
    private JPanel panelTicTacToe = ticTacToe.getPanel();
    private JPanel panelContainer = new JPanel(); //Used to swap panels with cardLayout
    private CardLayout cardLayout = new CardLayout(); //To switch between panels
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints playTicTacToeButtonConstraints = new GridBagConstraints();
    private MenuButton playTicTacToeButton = new MenuButton("Play TicTacToe", "TicTacToe");
    private MenuButton optionsButton = new MenuButton("Options", "Options");
    private GridBagConstraints optionsButtonConstraints = new GridBagConstraints();
    private JButton quitGame = new JButton("Quit");
    private GridBagConstraints quitGameConstraints = new GridBagConstraints();
    private JLabel menuLabel;
    private GridBagConstraints menuLabelConstraints = new GridBagConstraints();


    public MainMenuUI(){
        initializeButtons();
        initializeMenuLabel();
        initializePanelMenu();
        initializePanelContainer();
        initializeFrame();
    }

    private void initializeFrame(){
        frame.setSize(500, 500); //500 x 500 window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Pressing X button terminates the program
        frame.setResizable(false); //Not resizable
        frame.setLocationRelativeTo(null); //Centers the program to the screen
        frame.setVisible(true); //Makes it visible to user
    }

    private void initializeMenuLabel(){
        menuLabel = new JLabel("Tic Tac Toe!");
        menuLabel.setFont(new Font("", Font.BOLD, 75));
        menuLabelConstraints.insets = new Insets(50,0,100,0);
        menuLabelConstraints.gridy = 0;

    }


    private void initializePanelMenu(){
        panelMenu.setLayout(gridBagLayout);
        panelMenu.setBackground(Color.ORANGE);
        panelMenu.add(playTicTacToeButton.getMenuButton(), playTicTacToeButtonConstraints);
        panelMenu.add(menuLabel, menuLabelConstraints);
        panelMenu.add(quitGame, quitGameConstraints);
        panelMenu.add(optionsButton.getMenuButton(),optionsButtonConstraints);
    }

    private void initializePlayTicTacToeButton(){
        playTicTacToeButton.registerClickListener(this);
        playTicTacToeButton.getMenuButton().setBackground(Color.WHITE);
        playTicTacToeButton.getMenuButton().setFocusable(false);
        playTicTacToeButton.getMenuButton().setPreferredSize(new Dimension(150, 30));
        playTicTacToeButtonConstraints.gridy = 1;
        playTicTacToeButtonConstraints.insets = new Insets(0,0,30,0);
    }

    private void initializeQuitButton(){
        quitGame.setBackground(Color.RED);
        quitGame.setFocusable(false);
        quitGame.setPreferredSize(new Dimension(150,30));
        quitGameConstraints.insets = new Insets(0,0,30,0);
        quitGameConstraints.gridy = 3;

        quitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void initializeOptionsButton(){
        optionsButton.registerClickListener(this);
        optionsButton.getMenuButton().setBackground(Color.WHITE);
        optionsButton.getMenuButton().setFocusable(false);
        optionsButton.getMenuButton().setPreferredSize(new Dimension(150, 30));
        optionsButtonConstraints.gridy = 2;
        optionsButtonConstraints.insets = new Insets(0,0,30,0);
    }

    private void initializeButtons(){
        initializePlayTicTacToeButton();
        initializeQuitButton();
        initializeOptionsButton();
    }



    private void initializePanelContainer(){
        frame.add(panelContainer); //Container is added to frame
        panelContainer.setLayout(cardLayout); //Since this container will be used to swap panels, cardLayout is used
        panelContainer.add(panelMenu, "MainMenu"); //Menus added, "Nicknames" for panels added
        panelContainer.add(panelTicTacToe, "TicTacToe");
        cardLayout.show(panelContainer, "MainMenu"); //Initial panel to show when program is first launched
    }


    public void menuButtonClickUpdate(String JFrameAlias) {
        cardLayout.show(panelContainer, JFrameAlias);
    }

    public TicTacToeUI getTicTacToe() {
        return ticTacToe;
    }
}

