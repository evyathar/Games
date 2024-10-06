package game;

public class FourInARow extends Game {

	public FourInARow(String Player1, String Player2) {
		super(6, 7, new Player(Player1, 'W'), new Player(Player2, 'B'));
	}

	// override the method of 'Game', so the return value will be true only if there
	// is a continuous line on the board in the length of 4
	@Override
	protected boolean doesWin(int row, int col) {
		if (this.maxLineContaining(row, col) == 4) {
			return true;
		}
		return false;
	}

	@Override
	// receive a column from the user and update the board, and print the cur board
	// in the end of the turn
	// print a msg in case the index is illegal
	protected boolean onePlay(Player p) {
		int col, row = 0;
		boolean flag = true;
		
		System.out.printf("Please chose a Column between 0 to %d on the board :", this.m);
		col = this.s.nextInt();

		while (flag) {
			
			for (int i = 0; i < this.n; i++) {
				if (this.set(i, col, p)) {
					row = i;
					flag = false;
					break;
				}
			}
			
			if (flag) {
				System.out.println(
						"This column is already full or out of the boundaries, please enter a diffrent column on the board:");
				col = this.s.nextInt();
			}

		}
		// print the current state of the board
		System.out.println(this.toString());
		return doesWin(row, col);

	}

}
