import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BasicWindow{
	private JFrame frame;
	static public String playerName1;
	static private String playerName2;
	private int bestOf;
	final private JPanel cards;
	private static int turnNumber = 1;
	private static int gameNumber = 1;
	private Player player1;
	private Player player2;
	private JLabel tempLabel1; 
	private JLabel tempLabel2; 
	private int p1score;
	private int p2score;
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
	private JLabel gameLabel;
	private JLabel p1Label;
	private JLabel p2Label;
	
	
	
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
      	
		final JLabel turn = new JLabel();
		setTurnText(turn);
		turn.setPreferredSize(new Dimension(50, 40));
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(turn, BorderLayout.NORTH);
		
		status.setLayout(new GridLayout(1,3));
		p1Label = new JLabel();
		setPlayer1Status(p1Label);
		
		gameLabel = new JLabel();
		setGameText(gameLabel);
		p2Label = new JLabel();
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
				if(button1.getText()==""){
				if (turnNumber%2 == 0)     
					button1.setText("X");
					else button1.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
					System.out.println(turnNumber);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	}); 
     	
     	button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button2.getText()==""){
				if (turnNumber	%2 == 0)     
					button2.setText("X");
					else button2.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	}); 
     	button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button3.getText()==""){
				if (turnNumber%2 == 0)     
					button3.setText("X");
					else button3.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button4.getText()==""){
				if (turnNumber%2 == 0)     
					button4.setText("X");
					else button4.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button5.getText()==""){
				if (turnNumber%2 == 0)     
					button5.setText("X");
					else button5.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button6.getText()==""){
				if (turnNumber%2 == 0)     
					button6.setText("X");
					else button6.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button7.getText()==""){
				if (turnNumber%2 == 0)     
					button7.setText("X");
					else button7.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(button8.getText()==""){
				if (turnNumber%2 == 0)     
					button8.setText("X");
					else button8.setText("O");
					turnNumber+=1;
					checkRound();
					setTurnText(turn);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Space already taken");
				}
		    	}	
     	});
     	
     	button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					if(button9.getText()==""){
							if (turnNumber%2 == 0)     
							button9.setText("X");
							else button9.setText("O");
							turnNumber+=1;
							checkRound();
							setTurnText(turn);
						}
					else{
						JOptionPane.showMessageDialog(frame, "Space already taken");
					}
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
		//turnNumber = Tictactoe.getTurn();
		if(turnNumber%2==0) turn.setText("Turn " + turnNumber + " " + playerName2 + " Player 2");
		else turn.setText("Turn " + turnNumber + " " + playerName1 + " Player 1");
	}
	
	public void setGameText(JLabel gameLabel) {
		//gameNumber = Tictactoe.getGame();
		gameLabel.setText("Game " + gameNumber + " out of " + bestOf + ": ");
	}
	
	public void setPlayer1Status(JLabel status) {
		//score = player1.getScore();
		status.setText(playerName1 + " (P1): " + p1score);
	}
	
	public void setPlayer2Status(JLabel status) {
		//score = player2.getScore();
		status.setText(playerName2 + " (P2): " + p2score);
	}
	
	public void checkRound() {
		if(button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker(); 	
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button3.getText() == "X" && button6.getText() == "X" && button9.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			champChecker();
			resetBoard();
		}
		else if(button4.getText() == "X" && button5.getText() == "X" && button6.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button7.getText() == "X" && button8.getText() == "X" && button9.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		else if(button3.getText() == "X" && button5.getText() == "X" && button7.getText() == "X"){
			System.out.println("Player 2 wins");
			JOptionPane.showMessageDialog(frame, "Player 2 wins!");
			gameNumber++;
			p2score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer2Status(p2Label);
			champChecker();
			resetBoard();
		}
		if(button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
			//champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
//			champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button3.getText() == "O" && button6.getText() == "O" && button9.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
//			champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
//			champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button4.getText() == "O" && button5.getText() == "O" && button6.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
//			champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button7.getText() == "O" && button8.getText() == "O" && button9.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
//			champChecker();
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
		else if(button3.getText() == "O" && button5.getText() == "O" && button7.getText() == "O"){
			System.out.println("Player 1 wins");
			JOptionPane.showMessageDialog(frame, "Player 1 wins!");
			gameNumber++;
			p1score++;
			
			setGameText(gameLabel);
			setPlayer1Status(p1Label);
			champChecker();
			resetBoard();
		}
 
		}
		
		public void resetBoard(){
			turnNumber = 1; 
			
			button1.setText("");
			button2.setText("");
			button3.setText("");
			button4.setText("");
			button5.setText("");
			button6.setText("");
			button7.setText("");
			button8.setText("");
			button9.setText("");
		
		}
		public void champChecker(){	
			if(gameNumber > bestOf && p1score > p2score){ 
				System.out.println("Player one wins!");
				JOptionPane.showMessageDialog(frame, "Player 1 victorious");
				System.exit(0);
				}
			else if(gameNumber > bestOf && p1score < p2score){ 
				System.out.println("Player 2 wins!");
				JOptionPane.showMessageDialog(frame, "Player 2 victorious!");
				System.exit(0);
				}
		
		
		}	
	}
