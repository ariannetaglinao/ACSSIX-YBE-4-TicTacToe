import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

public class BasicWindow{
	private JFrame frame;
	
	public static void main(String[] args){
		new BasicWindow();
	}
	
	public BasicWindow(){
		this.frame = new JFrame ("Tic-tac-toe");
		this.frame.add(addComponents());
		this.frame.setSize(500, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}
	
	private JPanel addComponents(){
		JPanel main = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JLabel letter1 = new JLabel("Player 1 Name: ", SwingConstants.CENTER);
		letter1.setFont(new Font("Calibri", Font.PLAIN, 24));
		JLabel letter2 = new JLabel("Player 2 Name: ", SwingConstants.CENTER);
		letter2.setFont(new Font("Calibri", Font.PLAIN, 24));
		JLabel letter3 = new JLabel("Best of: ", SwingConstants.CENTER);
		letter3.setFont(new Font("Calibri", Font.PLAIN, 24));
		panel.setLayout(new GridLayout(3,2));
		panel.add(letter1);
		panel.add(letter2);
		panel.add(letter3);
		JTextField k1 = new JTextField(15);
		k1.setPreferredSize(new Dimension(20,30));
		JTextField k2 = new JTextField(15);
		JTextField k3 = new JTextField(15);
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(k1);
		panel1.add(k2);
		panel1.add(k3);
		JButton but1 = new JButton("OK");
		panel2.add(but1);
		but1.setPreferredSize(new Dimension(120,50));
		panel2.add(BorderLayout.PAGE_END, but1);
		JButton but2 = new JButton("Cancel");
		panel2.add(but2);
		but2.setPreferredSize(new Dimension(120,50));
		main.setLayout(new FlowLayout());
		main.add(panel);
		main.add(panel1);
		main.add(panel2);
		panel4.setPreferredSize(new Dimension(50,50));
		panel3.setLayout(new BorderLayout());
		panel3.add(BorderLayout.NORTH, panel4);
		panel3.add(BorderLayout.CENTER, main);
		panel3.add(BorderLayout.SOUTH, panel2);
		
		
		
		
		
		return panel3;
	}
}
