package game;

public class TicTacToe extends Game {
	
	//create two Players one with mark X and the other as O
	//size f board is 3X3
	public TicTacToe(String Player1, String Player2) {
		super(3, 3, new Player(Player1,'X'), new Player(Player2,'O'));
		
	}
	//override the method of 'Game', so the return value will be true only if there is a
	//continuous line on the board in the length of 3
	@Override
	protected boolean doesWin(int row, int col) {
		if(this.maxLineContaining(row,col)==3){
			return true;
		}
		return false;
	}

}
