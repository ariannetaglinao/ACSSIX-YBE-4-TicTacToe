public class Player {
	private String name;
	private int score = 0;

	public Player (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void updateScore() {
		score += 1;
	}
}
