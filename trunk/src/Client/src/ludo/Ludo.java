package ludo;

public class Ludo {

	public static final int YELLOW = 0;
	public static final int RED = 1;
	public static final int BLUE = 2;
	public static final int GREEN = 3;
	
	
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

	public static int pieceInSquare(int[][] board,int square, int player){
		int piece = 0;
		
		for(int i = 0 ;i< 4;i ++){
			if(board[player][i] == square){
				piece = i;
				break;
			}
		}
		
		return piece;
	}
	
	
	public static void move(int piece, int squares, int[][] board, int player) {
		int square;
		switch (player) {
		case YELLOW:
			square = board[YELLOW][piece];
			if (square > YELLOW_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[YELLOW][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[YELLOW][piece] += squares;
			}else{
				board[YELLOW][piece] += squares;
			}
				
			break;
			
		case RED:
			square = board[RED][piece];
			if (square > RED_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[RED][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[RED][piece] += squares;
			}else{
				board[RED][piece] += squares;
			}
			
			break;
		case BLUE:
			square = board[BLUE][piece];
			if (square > BLUE_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[BLUE][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[BLUE][piece] += squares;
			}else{
				board[BLUE][piece] += squares;
			}
			
			break;
		case GREEN:
			square = board[GREEN][piece];
			if (square > GREEN_LAST_SQUARE) {
				int offset = FINAL_SQUARE - (square + squares);
				if (offset < 0) // NOS HEMOS PASAO
					board[GREEN][piece] = FINAL_SQUARE - offset;
				else
					// AUN FALTA PARA LLEGAR o llegmaos justos
					board[GREEN][piece] += squares;
			}else{
				board[GREEN][piece] += squares;
			}
			break;
		}
	}
	
	public static boolean isWinner(int [][]board, int player){
		boolean winner = false;
		
		switch(player){
		case YELLOW:
			winner = board[YELLOW][0] == FINAL_SQUARE && board[YELLOW][1] == FINAL_SQUARE && board[YELLOW][2] == FINAL_SQUARE && board[YELLOW][3] == FINAL_SQUARE;
			break;
		case RED:
			winner = board[RED][0] == FINAL_SQUARE && board[RED][1] == FINAL_SQUARE && board[RED][2] == FINAL_SQUARE && board[RED][3] == FINAL_SQUARE;
			break;
		case BLUE:
			winner = board[BLUE][0] == FINAL_SQUARE && board[BLUE][1] == FINAL_SQUARE && board[BLUE][2] == FINAL_SQUARE && board[BLUE][3] == FINAL_SQUARE;
			break;
		case GREEN:
			winner = board[GREEN][0] == FINAL_SQUARE && board[GREEN][1] == FINAL_SQUARE && board[GREEN][2] == FINAL_SQUARE && board[GREEN][3] == FINAL_SQUARE;
			break;
		}
		
		return winner;
	}

	public static int canBringPieceToStartingSquare(int[][] board,
			int player) {
		int piece = -1;
				
		for(int i=0 ; i<4; i++){
			if(board[player][i] == HOUSE){
				piece = i;
				break;
			}
				
		}
		
		return piece;
	}
	
	public static void takeOutPiece(int [][] board, int piece, int player){
		switch(player){
		case YELLOW:
			board[YELLOW][piece] = YELLOW_INITIAL_SQUARE;
			break;
		case RED:
			board[RED][piece] = RED_INITIAL_SQUARE;
			break;
		case BLUE:
			board[BLUE][piece] = BLUE_INITIAL_SQUARE;
			break;
		case GREEN:
			board[GREEN][piece] = GREEN_INITIAL_SQUARE;
			break;
		}
	}

	public static boolean isPieceOut(int[][] board, int player) {
		for(int i = 0; i<4; i++)
			if(board[player][i] != HOUSE )
				return true;
		
		return false;
	}
	
	
}
