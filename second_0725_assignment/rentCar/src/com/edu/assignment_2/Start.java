package com.edu.assignment_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    private JPanel panel1;
    private JButton 租车Button;
    private JButton 展示车辆Button;
    public static JFrame frame = null;

    public Start() {
        展示车辆Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Show().main(null);
            }
        });
        租车Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Rent().main(null);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Start");
        frame.setContentPane(new Start().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
