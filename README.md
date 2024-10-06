This project implements a generic board game framework in Java, including the ability to create and manage players, update game states, and check for win conditions. 
The core classes (Board, Player, and Game) provide the foundation for creating different board games. 
Two specific games, TicTacToe (3x3 grid) and FourInARow (6x7 grid), are implemented by extending the base Game class. 
Each game has its own unique win condition (e.g., aligning 3 marks for TicTacToe or 4 marks for FourInARow). 
Players alternate turns until a winner is determined or the board is full.
