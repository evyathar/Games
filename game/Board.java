package game;

public class Board {
	// array of the class Player, representing the board
	protected Player[][] board;
	// the size of the board
	protected int n, m;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		this.board = new Player[n][m];
	}

	// if the place on the board is free then assignee the player to it and return
	// true, else false
	protected boolean set(int i, int j, Player p) {
		try {
		if (this.board[i][j] == null) {
			
				this.board[i][j] = p;
			return true;
		} else {
			return false;
		}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is out of boundaries");
			return false;
		}
	}

	// if the place on the board is free return true
	public boolean isEmpty(int i, int j) {
		if (this.board[i][j] == null) {
			return true;
		} else {
			return false;
		}
	}

	// return the player on the place(i,j) in the board,else null
	public Player get(int i, int j) {
		if (this.board[i][j] == null) {
			return null;
		} else {
			return this.board[i][j];
		}
	}

	// check if the board is full -> true, else false
	public boolean isFull() {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				if (this.board[i][j] == null)
					return false;
			}
		}
		return true;
	}

	// return the board as a string - if null '.' ,else mark of the player
	public String toString() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				Player p = this.board[i][j];
				if (p == null) {
					str.append(".");
				} else {
					str.append(p.getMark());
				}
			}
			str.append("\n");
		}
		return str.toString();
	}

	// return the longest continuous line in a board that occupied by the player in
	// board[i][j]
	protected int maxLineContaining(int i, int j) {
		int max = 0;
		if (this.board[i][j] == null) {
			return max;
		}
		// using -1,0 and 1 for direction on the board
		for (int row = -1; row < 2; row++) {
			for (int col = -1; col < 2; col++) {
				// if the direction is uper-left then need to consider down-right as well
				int tempmax = this.rayLength(i, j, row, col);
				tempmax += this.rayLength(i, j, row * -1, col * -1) - 1;
				if (tempmax > max) {
					max = tempmax;
				}
			}
		}
		return max;

	}

	// a utility method for maxLineContaining, count the continuous line in one
	// direction from a given point
	private int rayLength(int i, int j, int di, int dj) {
		Player p = this.board[i][j];
		int row = i + di, col = j + dj, count = 1;
		if (di == 0 && dj == 0) {
			return count;
		}
		while (row >= 0 && col >= 0 && row < this.n && col < this.m) {
			if (this.board[row][col] != null && this.board[row][col].equals(p))
				count++;
			row += di;
			col += dj;
		}
		return count;
	}

}
