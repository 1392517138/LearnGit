package com.edu.assignment_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Show {
    private JPanel panel1;
    public JTextArea textArea1;
    private JButton 返回Button;
    public static JFrame frame = null;
    {
        for (Car c: loadInformation.list
        ) {
            textArea1.append(c.toString()+"\n");
        }
    }

    public Show() {
        返回Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Start.frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Show");
        frame.setContentPane(new Show().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
