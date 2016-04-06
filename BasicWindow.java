import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BasicWindow{
	private JFrame frame;
	static private String playerName1;
	static private String playerName2;
	private int bestOf;
	
	public BasicWindow(){
		this.frame = new JFrame ("Tic-tac-toe");
		this.frame.add(startWindow());
		this.frame.setSize(500, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	} 
	
	public JPanel startWindow() {
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
		final JTextField textPlayer1 = new JTextField(15);
		textPlayer1.setPreferredSize(new Dimension(20,30));
		final JTextField textPlayer2 = new JTextField(15);
		final JTextField textBestOf = new JTextField(15);
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(textPlayer1);
		panel1.add(textPlayer2);
		panel1.add(textBestOf);
		JButton OkButton = new JButton("OK");
		panel2.add(OkButton);
		OkButton.setPreferredSize(new Dimension(120,50));
		panel2.add(BorderLayout.PAGE_END, OkButton);
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
		
		
		
		OkButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {     
		        playerName1 = textPlayer1.getText();
		        playerName2 = textPlayer2.getText();  
			 	//bestOf = (int)textBestOf.getText();  
   
        	}
     	}); 
	
		return panel3;
	}
	
	public JPanel playWindow() {
		JPanel panel = new JPanel();
		JPanel gamePanel = new JPanel();
		JPanel status = new JPanel();
		
	 	BorderLayout layout = new BorderLayout();
      	layout.setHgap(10);
      	layout.setVgap(10);
      	panel.setLayout(layout);
      	
		JLabel turn = new JLabel("Turn <>: <name> (Player <>)");
		turn.setPreferredSize(new Dimension(50, 40));
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(turn, BorderLayout.NORTH);
		
		status.setLayout(new GridLayout(1,3));
		JLabel p1Label = new JLabel("<name> (P1): ");
		JLabel gameLabel = new JLabel("Game () out of (): ");
		JLabel p2Label = new JLabel("<name> (P2): ");
		status.add(p1Label);
		p1Label.setHorizontalAlignment(SwingConstants.CENTER);
		status.add(gameLabel);
		gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		status.add(p2Label);
		p2Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(status, BorderLayout.SOUTH);
		
		JPanel border1 = new JPanel();
		border1.setPreferredSize(new Dimension(100, 600));
		JPanel border2 = new JPanel();
		border2.setPreferredSize(new Dimension(100, 600));
		
		panel.add(border1, BorderLayout.EAST);
		panel.add(border2, BorderLayout.WEST);
		
		gamePanel.setLayout(new GridLayout(3,3));
		JButton button1 = new JButton("");
		JButton button2 = new JButton("");
		JButton button3 = new JButton("");
		JButton button4 = new JButton("");
		JButton button5 = new JButton("");
		JButton button6	= new JButton("");
		JButton button7	= new JButton("");
		JButton button8	= new JButton("");
		JButton button9	= new JButton("");
		
		gamePanel.add(button1);
		gamePanel.add(button2);
		gamePanel.add(button3);
		gamePanel.add(button4);
		gamePanel.add(button5);
		gamePanel.add(button6);
		gamePanel.add(button7);
		gamePanel.add(button8);
		gamePanel.add(button9);
		
		panel.add(gamePanel, BorderLayout.CENTER);
		
		return panel;
	
	}
}


   class playerMove implements ActionListener{

      public void actionPerformed(ActionEvent e) {
         
      }
   }
