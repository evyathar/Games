package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s;

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);// initialize the board
		this.s = new Scanner(System.in);// stander input
		this.players = new Player[] { p1, p2 };
	}

	// check the last move of the player, in case it was (0,0) on the board the
	// player win
	protected boolean doesWin(int i, int j) {
		if (i == 0 && j == 0)
			return true;
		return false;
	}
	
	//receive and index from the user and update the board, and print the cur board in the end of the turn
	//print a msg in case the index is illegal
	protected boolean onePlay(Player p) {
		int i, j;
		System.out.printf("Please enter a palce on board[%dX%d]:", this.n, this.m);
		i = this.s.nextInt();
		j = this.s.nextInt();
		
		while (!this.set(i, j, p)) {
			System.out.println("The place is already taken or out of the boundaries, please enter a diffrent spot on the board:");
			i = this.s.nextInt();
			j = this.s.nextInt();
		}
		// print the current state of the board
		System.out.println(this.toString());
		return doesWin(i, j);
	}
	
	//represent a turn of a player
	//run as long as the board in not full, or there is a winner
	public Player play() {
		int turn = 0;
		while (!this.isFull()) {
			if (this.onePlay(players[turn])) {
				System.out.printf("Player %s has won the game!\n", players[turn].getName());
				this.toString();
				return players[turn];
			}
			turn = 1 - turn;

		}
		System.out.println("The board is full and no one has won the game.");
		return null;
	}

}
