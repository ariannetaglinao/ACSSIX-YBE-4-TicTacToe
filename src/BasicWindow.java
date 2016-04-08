import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BasicWindow{
	private JFrame frame;
	static public String playerName1;
	static private String playerName2;
	private int bestOf;
	final private JPanel cards;
	private static int turnNumber;
	private static int gameNumber;
	private Player player1;
	private Player player2;
	private JLabel tempLabel1; 
	private JLabel tempLabel2; 
	private int score;
	private JPanel gamePanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;	
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	
	
	
	public BasicWindow(){ 
		this.frame = new JFrame ("Tic-tac-toe"); 
		cards = new JPanel(new CardLayout());
		
		this.frame.setSize(500, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel card1 = startWindow(cards);
		cards.add(card1, "startGame");
		
		

		
		          
        this.frame.add(cards);
        CardLayout cardLayout = (CardLayout) cards.getLayout();
		cardLayout.show(cards, "startGame"); 

		this.frame.setVisible(true);
	} 
	
	public JPanel startWindow(final JPanel cards) {
		JPanel main = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JLabel letter1 = new JLabel("Player 1 Name: ", SwingConstants.CENTER);
		letter1.setFont(new Font("MONOSPACED", Font.PLAIN, 20));
		JLabel letter2 = new JLabel("Player 2 Name: ", SwingConstants.CENTER);
		letter2.setFont(new Font("MONOSPACED", Font.PLAIN, 20));
		JLabel letter3 = new JLabel("Best of: ", SwingConstants.CENTER);
		letter3.setFont(new Font("MONOSPACED", Font.PLAIN, 20));
		panel.setLayout(new GridLayout(3,2));
		panel.add(letter1);
		panel.add(letter2);
		panel.add(letter3);
		final JTextField textPlayer1 = new JTextField(15);
		textPlayer1.setPreferredSize(new Dimension(15,25));
		final JTextField textPlayer2 = new JTextField(15);
		textPlayer2.setPreferredSize(new Dimension(15,25));
		final JTextField textBestOf = new JTextField(15);
		textBestOf.setPreferredSize(new Dimension(15,25));
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(textPlayer1);
		panel1.add(textPlayer2);
		panel1.add(textBestOf);
		
		JButton OkButton = new JButton("OK");
		
		panel2.add(OkButton);
		OkButton.setPreferredSize(new Dimension(120,50));
		panel2.add(OkButton);
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
				//System.out.println(playerName1); 
				try {
				bestOf = Integer.parseInt(textBestOf.getText());
				} catch (Exception ex) {}
				
						
      		  JPanel card2 = playWindow(player1, player2);
       			cards.add(card2, "playGame");
       			frame.add(cards);
			 	CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.next(cards);
        	}
     	}); 
     	
		return panel3;
	}
	
	public JPanel playWindow(Player p1, Player p2) {
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);

			
		JPanel panel = new JPanel();
		gamePanel = new JPanel();
		JPanel status = new JPanel();
		
	 	BorderLayout layout = new BorderLayout();
      	layout.setHgap(10);
      	layout.setVgap(10);
      	panel.setLayout(layout);
      	
		JLabel turn = new JLabel();
		setTurnText(turn);
		turn.setPreferredSize(new Dimension(50, 40));
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(turn, BorderLayout.NORTH);
		
		status.setLayout(new GridLayout(1,3));
		JLabel p1Label = new JLabel();
		setPlayer1Status(p1Label);
		
		JLabel gameLabel = new JLabel();
		setGameText(gameLabel);
		JLabel p2Label = new JLabel();
		setPlayer2Status(p2Label);
		
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
		
		button1 = new JButton("");
		button2 = new JButton("");
		button3 = new JButton("");
		button4 = new JButton("");
		button5 = new JButton("");
		button6 = new JButton("");
		button7 = new JButton("");
		button8 = new JButton("");
		button9 = new JButton("");

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button1.setText("X");
					else button1.setText("O");
					turnNumber+=1;
					System.out.println(turnNumber);
		    	}	
     	}); 
     	
     	button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber	%2 == 0)     
					button2.setText("X");
					else button2.setText("O");
					turnNumber+=1;
		    	}	
     	}); 
     	button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button3.setText("X");
					else button3.setText("O");
					turnNumber+=1;
		    	}	
     	});
     	button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button4.setText("X");
					else button4.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button5.setText("X");
					else button5.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button6.setText("X");
					else button6.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button7.setText("X");
					else button7.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button8.setText("X");
					else button8.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	
     	button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (turnNumber%2 == 0)     
					button9.setText("X");
					else button9.setText("O");
					turnNumber+=1;
					checkRound();
		    	}	
     	});
     	
		
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
	
	public Player getPlayer1() {

		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	public int getBestOf() {
		return bestOf;
	}
	
	public void setTurnText(JLabel turn) {
		turnNumber = Tictactoe.getTurn();
		turn.setText("Turn " + turnNumber + ": <name> (Player <>)");
	}
	
	public void setGameText(JLabel gameLabel) {
		gameNumber = Tictactoe.getGame();
		gameLabel.setText("Game " + gameNumber + " out of " + bestOf + ": ");
	}
	
	public void setPlayer1Status(JLabel status) {
		score = player1.getScore();
		status.setText(playerName1 + " (P1): " + score);
	}
	
	public void setPlayer2Status(JLabel status) {
		score = player2.getScore();
		status.setText(playerName2 + " (P2): " + score);
	}
	
	public void checkRound() {
		if(button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X"){
			System.out.println("Player 2 wins");
		}
		
}
}
