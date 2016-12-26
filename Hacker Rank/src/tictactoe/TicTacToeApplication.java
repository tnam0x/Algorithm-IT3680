package tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {
	public static void main(String[] args) {
		// Getting input
		Scanner scanner = new Scanner(System.in);
		// Allows for cont. games
		boolean doYouWantToPlay = true;
		while (doYouWantToPlay) {
			// Setting up our tokens and AI
			System.out.println("Welcome to Tic Tac Toe! You are about to go against "
					+ "the master of Tic Tac Toe. Are you ready? I hope so!\n BUT FIRST, you"
					+ " must pick what character you want to be and which character I will be");
			System.out.println();
			System.out.println("Enter a single character that will represent you on the board");
			char playerToken = scanner.next().charAt(0);
			System.out.println("Enter a single character that will represent your opponent on the board");
			char opponentToken = scanner.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			AI ai = new AI();

			// Set up the game
			System.out.println();
			System.out.println("Now we can start the game. To play, enter a number and your taken shall be put"
					+ "in its place.\nThe numbers go from 1-9, left ro right. We shall see who will win this rounds");
			TicTacToe.printIndexBoard();
			System.out.println();

			// Let's play!
			while (game.gameOver().equals("notOver")) {
				if (game.currentMarker == game.userMarker) {
					// User turn
					System.out.println("It's your turn! Enter a spot for your token");
					int spot = scanner.nextInt();
					while (!game.playTurn(spot)) {
						System.out.println("Try again. " + spot + " is invalid. This spot already taken"
								+ " or it is out of range");
						spot = scanner.nextInt();
					}
					System.out.println("You picked " + spot + "!");
				} else {
					// AI turn
					System.out.println("It's my turn");
					// Pick spot
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot + "!");
				}
				// Print out new board
				game.printBoard();
				System.out.println();
			}
			System.out.println(game.gameOver());
			System.out.println();
			// Set up a new game... or not depending on the response
			System.out.println(
					"Do you want to play again? Enter Y if you do. " + "Enter anything else if you are tired of me.");
			char response = scanner.next().charAt(0);
			doYouWantToPlay = (response == 'Y');
			System.out.println();

		}
		scanner.close();
	}
}
