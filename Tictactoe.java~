import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tictactoe {

	private static int turn = 1;
	private static int game = 0;
	private static boolean proceed;
	
	public static void main(String[] args){
		final BasicWindow window = new BasicWindow();
		while (proceed!=true) {
			
			proceed = window.getProceed();
		}
		
		
		System.out.println(window.getPlayer1().getName());
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
