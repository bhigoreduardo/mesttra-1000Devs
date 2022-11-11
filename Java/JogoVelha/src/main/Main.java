package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void clearConsole() throws IOException, InterruptedException {
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
	}

	public static void showBoard(char[] board) {
		int position = 0;

		//clearConsole();

		for (int i = 0; i < 3; i++) {
			System.out.printf("\t    Coluna %d", i + 1);
		}

		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.printf("Linha %d\t", i + 1);

			for (int j = 0; j < 3; j++) {
				if (j < 2) {
					System.out.printf("\t %s \t |", board[position]);
				} else {
					System.out.printf("\t %s \t\n", board[position]);
				}
				position++;
			}

			if (i < 2) {
				System.out.println("\t---------------------------------------------------");
			}
		}
	}

	public static boolean isWin(char[] board) {
		int pos0, pos1, pos2;

		int[][] winBoard = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
				{ 2, 4, 6 } };

		for (int i = 0; i < 8; i++) {
			pos0 = winBoard[i][0];
			pos1 = winBoard[i][1];
			pos2 = winBoard[i][2];

			if (board[pos0] == board[pos1] && board[pos0] == board[pos2]
					&& (board[pos0] == 'x' || board[pos0] == 'o')) {
				return true;
			}
		}

		return false;
	}

	public static int choiceBoardPosition() {
		int boardPosition;
		String choice[] = null;

		// validated choices user
		while (true) {
			Scanner input = new Scanner(System.in);

			// get choices user
			System.out.print("Informe a [Linha] x [Coluna]: ");
			choice = input.nextLine().strip().split(" ");

			if (choice.length != 2) {
				System.out.println("Escolha a posição da linha e coluna separados por um espaço.");
				System.out.println("Exemplo: 1 2");
			} else if (Integer.parseInt(choice[0]) < 1 || Integer.parseInt(choice[0]) > 3
					|| Integer.parseInt(choice[1]) < 1 || Integer.parseInt(choice[1]) > 3) {
				System.out.println("Escolha um valor entre as possibilidades do programa [1-3]");
			} else {
				break;
			}
		}

		// calculator choices user
		int i = Integer.parseInt(choice[0]);
		int j = Integer.parseInt(choice[1]);

		if (i == 1) {
			boardPosition = j - i;
		} else if (i == 2) {
			boardPosition = j + i;
		} else {
			boardPosition = j + i + 2;
		}

		return boardPosition;
		/*
		 * 0 1 2 ==> i=1 ==> j-i
		 * 3 4 5 ==> i=2 ==> j+i
		 * 6 7 8 ==> i=3 ==> j+i+2
		 */
	}

	public static void main(String[] args)  {
		char[] board = new char[9], symbols = { 'x', 'o' };
		int playerTime = 0, counter = 1;

		while (true) {
			// show the board
			showBoard(board);

			if (playerTime == 0) {
				while (true) {
					// choice the board position
					int boardPosition = choiceBoardPosition();

					if ((board[boardPosition] == 'x') || (board[boardPosition] == 'o')) {
						System.out.println("Escolha outra posição, está já foi marcada.");
					} else {
						board[boardPosition] = symbols[playerTime];
						break;
					}
				}
			} else {
				for (int i = 0; i < board.length; i++) {
					if (board[i] == 'x' || board[i] == 'o') {
						continue;
					}

					board[i] = 'o';
					break;
				}
			}

			// validate winner player
			if (isWin(board) || counter == 9) {
				break;
			}

			playerTime = playerTime == 0 ? 1 : 0;
			counter++;
		}

		showBoard(board);

		if (counter != 9) {
			System.out.printf("Jogador vencedor: %s", symbols[playerTime]);
		} else {
			System.out.print("Nenhum jogador foi o vencedor.");
		}

	}

}
