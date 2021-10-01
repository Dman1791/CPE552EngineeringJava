/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stevens.cpe552.f2021.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author Derek Kellerman
 */
public class Calculator extends JFrame
{
    public static void main(String[] args)
    {
        Calculator c = new Calculator("Calculator");
        c.setVisible(true);
    }
    
    private JPanel buttons, screen;
    private JTextArea text;
    private ArrayList<JButton> buttonArray;
    
    public Calculator(String title)
    {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        buttons = new JPanel();
        screen = new JPanel();
        buttonArray = new ArrayList<>();
        
        buttons.setLayout(new GridLayout(6,4));
        buttonArray.add(new JButton("ABS"));
        buttonArray.add(new JButton("SQRT"));
        buttonArray.add(new JButton("MOD"));
        buttonArray.add(new JButton("CLR"));
        buttonArray.add(new JButton("("));
        buttonArray.add(new JButton(")"));
        buttonArray.add(new JButton("^"));
        buttonArray.add(new JButton("+"));
        buttonArray.add(new JButton("7"));
        buttonArray.add(new JButton("8"));
        buttonArray.add(new JButton("9"));
        buttonArray.add(new JButton("-"));
        buttonArray.add(new JButton("4"));
        buttonArray.add(new JButton("5"));
        buttonArray.add(new JButton("6"));
        buttonArray.add(new JButton("*"));
        buttonArray.add(new JButton("1"));
        buttonArray.add(new JButton("2"));
        buttonArray.add(new JButton("3"));
        buttonArray.add(new JButton("/"));
        buttonArray.add(new JButton("ANS"));
        buttonArray.add(new JButton("0"));
        buttonArray.add(new JButton("."));
        buttonArray.add(new JButton("="));
        
        for (int i = 0; i < buttonArray.size(); i++)
        {
            buttonArray.get(i).addActionListener(buttonListener());
            buttons.add(buttonArray.get(i));
        }
        
        text = new JTextArea();
        text.setLineWrap(true);
        text.setFont(new Font("Segoe UI", 34, 34));
        text.setEditable(false);
        screen.setLayout(new BorderLayout());
        screen.add(text, BorderLayout.CENTER);
        screen.setPreferredSize(new Dimension(600,200));
        
        this.setLayout(new BorderLayout());
        this.add(screen, BorderLayout.NORTH);
        this.add(buttons, BorderLayout.CENTER);
        this.setSize(600,800);
    }
    
    private void handleButton(String b)
    {
        switch (b)
        {
            case "=" -> {}//Do math
            case "ABS" -> text.append("abs(");
            case "ANS" -> text.append("ans");
            case "MOD" -> text.append("%");
            case "CLR" -> text.setText("");
            case "SQRT" -> text.append("sqrt(");
            default -> text.append(b);
        }
        
        text.repaint();
        screen.repaint();
        this.repaint();
    }
    
    private String simplify(String s)
    {
        return "";
    }
    
    private ActionListener buttonListener()
    {
        return new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton source = (JButton)e.getSource();
                handleButton(source.getText());
            }
        };
    }
}