package com.company;

import com.sun.org.apache.xpath.internal.objects.XString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameForm {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JTextField userInput;
    public JButton submitButton;
    private JButton clearButton;
    private JTextArea gameActivity;


    public GameForm(){
       createAndShow();
    }

    private void createAndShow(){
        GridLayout grid = new GridLayout();
        frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(grid);

        frame.setSize(600, 600);
        mainPanel.setSize(300,600);

        addActionListeners();

        frame.setVisible(true);
        frame.add(mainPanel);
        //frame.add(topPanel);
    }

    private void addActionListeners(){
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("");
            }
        });

       submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.setSelected(true);
                 //gameActivity.append( " " + userInput.getText());
                 //gameActivity.append("CLICKED");
            }
        });
    }

    public void updateGameActivty(String text){
        gameActivity.setText(gameActivity.getText() + "\n" + text);
    }

    public String getUserInput() {
         return userInput.getText();
    }
    public int getAge() {
        String age = userInput.getText();
        return Integer.parseInt(age);
    }

    public boolean isSubmitButtonSelceted() {
        return submitButton.isSelected();
    }

}
