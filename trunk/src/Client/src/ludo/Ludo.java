package ludo;

import constants.Constants;

public class Ludo {

	public static final int EMPTY = -1;
	public static final int YELLOW = 0;
	public static final int RED = 1;
	public static final int BLUE = 2;
	public static final int GREEN = 3;

	public static final int HOUSE = 0;

	public static final int YELLOW_INITIAL_SQUARE = 5;
	public static final int YELLOW_LAST_SQUARE = 68;
	public static final int YELLOW_FINAL_SQUARE = 76;

	public static final int RED_INITIAL_SQUARE = 39;
	public static final int RED_LAST_SQUARE = 34;
	public static final int RED_FINAL_SQUARE = 84;

	public static final int BLUE_INITIAL_SQUARE = 22;
	public static final int BLUE_LAST_SQUARE = 17;
	public static final int BLUE_FINAL_SQUARE = 92;

	public static final int GREEN_INITIAL_SQUARE = 56;
	public static final int GREEN_LAST_SQUARE = 51;
	public static final int GREEN_FINAL_SQUARE = 100;

	public static void initBoard(int[][] board) {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				board[row][column] = HOUSE;
			}
		}
	}

	public static int throwDice() {
		// return 5;
		return (int) (Math.random() * 6 + 1);
	}

	public static int pieceInSquare(int[][] board, int square, int player) {
		int piece = 0;

		for (int i = 0; i < 4; i++) {
			if (board[player][i] == square) {
				piece = i;
				break;
			}
		}

		return piece;
	}

	public static MoveResult validateMove(int piece, int squares,
			int[][] board, int player) {
		int fromSquare = board[player][piece];
		int toSquare = fromSquare + squares;

		if (toSquare > 68 && fromSquare <= 68 && player != YELLOW)
			toSquare = toSquare - 68;

		Square square = squareInfo(board, toSquare);

		for (int from = fromSquare + 1; from <= toSquare; from++) {
			if (toSquare > 68 && fromSquare <= 68 && from > 68) {
				from = 1;
				toSquare -= 68;
			}
			
			square = squareInfo(board, from);
			
			//There is a block on the way
			if(square.numberOfPieces() == 2)
				return MoveResult.Invalid;
		}
		
		
		//Catch a piece
		if (square.numberOfPieces() == 1) {
			int squareNum = square.getSquare();
			//Check if the piece is not in a secure
			if (square.getFirstPiece() != player && squareNum != 12 && squareNum != 63 && squareNum != 46 && squareNum != 29)
				return MoveResult.Count20;
			//Block on the target square
		} else if (square.numberOfPieces() == 2)
			return MoveResult.Invalid;

		return MoveResult.Valid;
	}

	public static void move(int piece, int squares, int[][] board, int player) {
		int square;
		switch (player) {
		case YELLOW:
			square = board[YELLOW][piece];
			if (square >= YELLOW_LAST_SQUARE) {
				int offset = YELLOW_FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[YELLOW][piece] = YELLOW_FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[YELLOW][piece] += squares;
			} else {
				int toSquare = square + squares;
				if (toSquare > 68)
					toSquare -= 68;
				board[YELLOW][piece] = toSquare;
			}

			break;

		case RED:
			square = board[RED][piece];
			if ((square >= RED_INITIAL_SQUARE && square <= 68)
					|| (square >= 1 && square <= RED_LAST_SQUARE)) {
				int toSquare = square + squares;
				if (toSquare > 68)
					toSquare -= 68;
				board[RED][piece] = toSquare;
			} else {
				int offset = RED_FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[RED][piece] = RED_FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[RED][piece] += squares;
			}

			break;
		case BLUE:
			square = board[BLUE][piece];

			if ((square >= BLUE_INITIAL_SQUARE && square <= 68)
					|| (square >= 1 && square <= BLUE_LAST_SQUARE)) {
				int toSquare = square + squares;
				if (toSquare > 68)
					toSquare -= 68;
				board[BLUE][piece] = toSquare;
			} else {
				int offset = BLUE_FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[BLUE][piece] = BLUE_FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[BLUE][piece] += squares;
			}

			break;
		case GREEN:
			square = board[GREEN][piece];

			if ((square >= GREEN_INITIAL_SQUARE && square <= 68)
					|| (square >= 1 && square <= GREEN_LAST_SQUARE)) {
				int toSquare = square + squares;
				if (toSquare > 68)
					toSquare -= 68;
				board[GREEN][piece] = toSquare;
			} else {
				int offset = GREEN_FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[GREEN][piece] = GREEN_FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[GREEN][piece] += squares;
			}

			break;
		}
	}

	public static boolean isWinner(int[][] board, int player) {
		boolean winner = false;

		switch (player) {
		case YELLOW:
			winner = board[YELLOW][0] == YELLOW_FINAL_SQUARE
					&& board[YELLOW][1] == YELLOW_FINAL_SQUARE
					&& board[YELLOW][2] == YELLOW_FINAL_SQUARE
					&& board[YELLOW][3] == YELLOW_FINAL_SQUARE;
			break;
		case RED:
			winner = board[RED][0] == RED_FINAL_SQUARE
					&& board[RED][1] == RED_FINAL_SQUARE
					&& board[RED][2] == RED_FINAL_SQUARE
					&& board[RED][3] == RED_FINAL_SQUARE;
			break;
		case BLUE:
			winner = board[BLUE][0] == BLUE_FINAL_SQUARE
					&& board[BLUE][1] == BLUE_FINAL_SQUARE
					&& board[BLUE][2] == BLUE_FINAL_SQUARE
					&& board[BLUE][3] == BLUE_FINAL_SQUARE;
			break;
		case GREEN:
			winner = board[GREEN][0] == GREEN_FINAL_SQUARE
					&& board[GREEN][1] == GREEN_FINAL_SQUARE
					&& board[GREEN][2] == GREEN_FINAL_SQUARE
					&& board[GREEN][3] == GREEN_FINAL_SQUARE;
			break;
		}

		return winner;
	}

	public static boolean canBringPieceToStartingSquare(int[][] board,
			int player) {

		int initialPieces = 0;

		switch (player) {
		case YELLOW:
			for (int piece = 0; piece < 4; piece++) {
				if (board[player][piece] == YELLOW_INITIAL_SQUARE)
					initialPieces++;
			}
			break;
		case RED:
			for (int piece = 0; piece < 4; piece++) {
				if (board[player][piece] == RED_INITIAL_SQUARE)
					initialPieces++;
			}
			break;
		case BLUE:
			for (int piece = 0; piece < 4; piece++) {
				if (board[player][piece] == BLUE_INITIAL_SQUARE)
					initialPieces++;
			}
			break;
		case GREEN:
			for (int piece = 0; piece < 4; piece++) {
				if (board[player][piece] == GREEN_INITIAL_SQUARE)
					initialPieces++;
			}
			break;
		}

		if (initialPieces < 2) {
			for (int i = 0; i < 4; i++) {
				if (board[player][i] == HOUSE) {
					return true;
				}

			}
		}

		return false;
	}

	public static int takeOutPiece(int[][] board, int player) {
		int piece = 0;

		for (int i = 0; i < 4; i++) {
			if (board[player][i] == HOUSE) {

				switch (player) {
				case YELLOW:
					board[player][i] = YELLOW_INITIAL_SQUARE;
					break;
				case RED:
					board[player][i] = RED_INITIAL_SQUARE;
					break;
				case BLUE:
					board[player][i] = BLUE_INITIAL_SQUARE;
					break;
				case GREEN:
					board[player][i] = GREEN_INITIAL_SQUARE;
					break;
				}

				piece = i;

				break;
			}
		}

		return piece;

	}

	public static boolean isPieceOut(int[][] board, int player) {
		for (int i = 0; i < 4; i++)
			if (board[player][i] != HOUSE)
				return true;

		return false;
	}

	public static Square squareInfo(int[][] board, int square) {
		Square info = new Square(square);

		for (int player = YELLOW; player < 4; player++) {
			for (int piece = 0; piece < 4; piece++) {
				if (board[player][piece] == square) {
					info.addPiece(player);
				}
			}

		}

		return info;
	}

}
