import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tictactoe {

	private static JButton OKButton;
	static private String playerName1;
	static private String playerName2;
	private static int turn = 1;
	private static int game = 0;
	
	public static void main(String[] args){
		final BasicWindow window = new BasicWindow();
		
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
