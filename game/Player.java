package game;

public class Player {
	//the name of the player
	private String name;
	//the mark of the player on the board
	private char mark;
	
	public Player(String name, char mark) {
		this.name=name;
		this.mark=mark;
	}
	
	//private fields can be accessed only by methods outside of the class
	public String getName() {
		return this.name;
	}
	
	public char getMark() {
		return this.mark;
	}
	
	//return "name(mark)"
	public String toString() {
		return String.format("%s(%c)", this.name,this.mark);
	}
	
}
