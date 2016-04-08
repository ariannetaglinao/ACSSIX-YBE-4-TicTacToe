import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tictactoe {

	private static int turn = 1;
	private static int game = 0;
	private static boolean proceed;
	private static Player player1;
	private static Player player2; 
	
	public static void main(String[] args){
		final BasicWindow window = new BasicWindow();

		//System.out.println(window.getPlayer1());
	}
	
	public static int getTurn() {
		return turn;
	}
	
	public static int getGame() {
		return game;
	}
	
	public static void updateTurn() {
		turn += 1;
	}
	
	public static void updateGame() {
		game += 1;
	}
}
