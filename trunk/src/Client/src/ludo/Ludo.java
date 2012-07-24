package ludo;

public class Ludo {

	public enum Player {
		Yellow, Red, Blue, Green
	};

	public static final int HOUSE = 0;
	public static final int YELLOW_INITIAL_SQUARE = 5;
	public static final int RED_INITIAL_SQUARE = 39;
	public static final int BLUE_INITIAL_SQUARE = 22;
	public static final int GREEN_INITIAL_SQUARE = 56;
	public static final int YELLOW_LAST_SQUARE = 68;
	public static final int RED_LAST_SQUARE = 34;
	public static final int BLUE_LAST_SQUARE = 17;
	public static final int GREEN_LAST_SQUARE = 51;
	public static final int FINAL_SQUARE = 76;

	public static void initBoard(int[][] board) {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				board[row][column] = HOUSE;
			}
		}
	}

	public static int throwDice() {
		return (int) (Math.random() * 6 + 1);
	}

	public static void outPiece(int[][] board, int piece, Player player) {
		switch (player) {
		case Yellow:
			board[0][piece] = YELLOW_INITIAL_SQUARE;
			break;
		case Red:
			board[1][piece] += RED_INITIAL_SQUARE;
			break;
		case Blue:
			board[2][piece] += BLUE_INITIAL_SQUARE;
			break;
		case Green:
			board[3][piece] += GREEN_INITIAL_SQUARE;
			break;
		}
	}

	public static void move(int piece, int squares, int[][] board, Player player) {
		int square;
		switch (player) {
		case Yellow:
			square = board[0][piece];
			if (square > YELLOW_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[0][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[0][piece] += squares;
			}
			break;
			
		case Red:
			square = board[1][piece];
			if (square > RED_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[1][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[1][piece] += squares;
			}
			
			break;
		case Blue:
			square = board[2][piece];
			if (square > BLUE_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[2][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[2][piece] += squares;
			}
			
			break;
		case Green:
			square = board[3][piece];
			if (square > GREEN_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[3][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[3][piece] += squares;
			}
			break;
		}
	}
	
	public static boolean isWinner(int [][]board, Player player){
		boolean winner = false;
		
		switch(player){
		case Yellow:
			winner = board[0][0] == FINAL_SQUARE && board[0][1] == FINAL_SQUARE && board[0][2] == FINAL_SQUARE && board[0][3] == FINAL_SQUARE;
			break;
		case Red:
			winner = board[1][0] == FINAL_SQUARE && board[1][1] == FINAL_SQUARE && board[1][2] == FINAL_SQUARE && board[1][3] == FINAL_SQUARE;
			break;
		case Blue:
			winner = board[2][0] == FINAL_SQUARE && board[2][1] == FINAL_SQUARE && board[2][2] == FINAL_SQUARE && board[3][3] == FINAL_SQUARE;
			break;
		case Green:
			winner = board[3][0] == FINAL_SQUARE && board[3][1] == FINAL_SQUARE && board[3][2] == FINAL_SQUARE && board[4][3] == FINAL_SQUARE;
			break;
		}
		
		return winner;
	}
	
	
}
