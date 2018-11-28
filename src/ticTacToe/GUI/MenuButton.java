package ticTacToe.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuButton implements MenuButtonClickSubject{
    JButton menuButton = new JButton();
    String JFrameAlias;

    ArrayList<MenuButtonClickListener> menuButtonClickListeners = new ArrayList<MenuButtonClickListener>();

    public MenuButton(String buttonText, String JFrameAlias){
        menuButton.setText(buttonText);
        this.JFrameAlias = JFrameAlias;
        initializeMouseClickListener();
    }

    private void initializeMouseClickListener(){
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notifyClickListeners();
            }
        });
    }

    public JButton getMenuButton(){
        return menuButton;
    }
    public void registerClickListener(MenuButtonClickListener menuButtonClickListener) {
        menuButtonClickListeners.add(menuButtonClickListener);
    }

    public void removeClickListener(MenuButtonClickListener menuButtonClickListener) {
        menuButtonClickListeners.remove(menuButtonClickListeners.indexOf(menuButtonClickListener));
    }

    public void notifyClickListeners() {
        for(MenuButtonClickListener listener : menuButtonClickListeners){
            listener.menuButtonClickUpdate(JFrameAlias);
        }
    }
}
