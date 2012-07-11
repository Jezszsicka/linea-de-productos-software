package checkers;

import java.util.ArrayList;
import java.util.List;



public class CheckersGame {

	public static final int EMPTY = 0;
	public static final int RED = 1;
	public static final int RED_KING = 2;
	public static final int BLACK = 3;
	public static final int BLACK_KING = 4;

	public static void initBoard(int[][] board) {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (row % 2 == column % 2) {
					if (row < 3)
						board[row][column] = BLACK;
					else if (row > 4)
						board[row][column] = RED;
					else
						board[row][column] = EMPTY;
				} else {
					board[row][column] = EMPTY;
				}
			}
		}

	}

	public static void move(int[][] board, int fromRow, int fromColumn,
			int toRow, int toColumn) {
		board[toRow][toColumn] = board[fromRow][fromColumn];
		board[fromRow][fromColumn] = EMPTY;
		if (fromRow - toRow == 2 || fromRow - toRow == -2) {
			// The move is a jump. Remove the jumped piece from the board.
			int jumpRow = (fromRow + toRow) / 2; // Row of the jumped piece.
			int jumpCol = (fromColumn + toColumn) / 2; // Column of the jumped
														// piece.
			board[jumpRow][jumpCol] = EMPTY;
		}
		if (toRow == 0 && board[toRow][toColumn] == RED)
			board[toRow][toColumn] = RED_KING;
		if (toRow == 7 && board[toRow][toColumn] == BLACK)
			board[toRow][toColumn] = BLACK_KING;
	}

	public static List<CheckersMove> legalMoves(int[][] board, int player) {
		if (player != RED && player != BLACK)
			return null;

		int playerKing;

		if (player == RED)
			playerKing = RED_KING;
		else
			playerKing = BLACK_KING;

		List<CheckersMove> moves = new ArrayList<CheckersMove>();
		/*
		 * First, check for any possible jumps. Look at each square on the
		 * board. If that square contains one of the player's pieces, look at a
		 * possible jump in each of the four directions from that square. If
		 * there is a legal jump in that direction, put it in the moves
		 * ArrayList.
		 */

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board[row][col] == player || board[row][col] == playerKing) {
					if (canJump(board, player, row, col, row + 1, col + 1,
							row + 2, col + 2))
						moves.add(new CheckersMove(row, col, row + 2, col + 2));
					if (canJump(board, player, row, col, row - 1, col + 1,
							row - 2, col + 2))
						moves.add(new CheckersMove(row, col, row - 2, col + 2));
					if (canJump(board, player, row, col, row + 1, col - 1,
							row + 2, col - 2))
						moves.add(new CheckersMove(row, col, row + 2, col - 2));
					if (canJump(board, player, row, col, row - 1, col - 1,
							row - 2, col - 2))
						moves.add(new CheckersMove(row, col, row - 2, col - 2));
				}
			}
		}

		/*
		 * If any jump moves were found, then the user must jump, so we don't
		 * add any regular moves. However, if no jumps were found, check for any
		 * legal regular moves. Look at each square on the board. If that square
		 * contains one of the player's pieces, look at a possible move in each
		 * of the four directions from that square. If there is a legal move in
		 * that direction, put it in the moves ArrayList.
		 */

		if (moves.size() == 0) {
			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
					if (board[row][col] == player
							|| board[row][col] == playerKing) {
						if (canMove(board, player, row, col, row + 1, col + 1))
							moves.add(new CheckersMove(row, col, row + 1,
									col + 1));
						if (canMove(board, player, row, col, row - 1, col + 1))
							moves.add(new CheckersMove(row, col, row - 1,
									col + 1));
						if (canMove(board, player, row, col, row + 1, col - 1))
							moves.add(new CheckersMove(row, col, row + 1,
									col - 1));
						if (canMove(board, player, row, col, row - 1, col - 1))
							moves.add(new CheckersMove(row, col, row - 1,
									col - 1));
					}
				}
			}
		}

		return moves;
	}

	/**
	 * This is called by the two previous methods to check whether the player
	 * can legally jump from (r1,c1) to (r3,c3). It is assumed that the player
	 * has a piece at (r1,c1), that (r3,c3) is a position that is 2 rows and 2
	 * columns distant from (r1,c1) and that (r2,c2) is the square between
	 * (r1,c1) and (r3,c3).
	 */
	private static boolean canJump(int[][] board, int player, int r1, int c1,
			int r2, int c2, int r3, int c3) {

		if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
			return false; // (r3,c3) is off the board.

		if (board[r3][c3] != EMPTY)
			return false; // (r3,c3) already contains a piece.

		if (player == RED) {
			if (board[r1][c1] == RED && r3 > r1)
				return false; // Regular red piece can only move up.
			if (board[r2][c2] != BLACK && board[r2][c2] != BLACK_KING)
				return false; // There is no black piece to jump.
			return true; // The jump is legal.
		} else {
			if (board[r1][c1] == BLACK && r3 < r1)
				return false; // Regular black piece can only move downn.
			if (board[r2][c2] != RED && board[r2][c2] != RED_KING)
				return false; // There is no red piece to jump.
			return true; // The jump is legal.
		}

	} // end canJump()

	/**
	 * This is called by the getLegalMoves() method to determine whether the
	 * player can legally move from (r1,c1) to (r2,c2). It is assumed that
	 * (r1,r2) contains one of the player's pieces and that (r2,c2) is a
	 * neighboring square.
	 */
	private static boolean canMove(int[][] board, int player, int r1, int c1,
			int r2, int c2) {

		if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
			return false; // (r2,c2) is off the board.

		if (board[r2][c2] != EMPTY)
			return false; // (r2,c2) already contains a piece.

		if (player == RED) {
			if (board[r1][c1] == RED && r2 > r1)
				return false; // Regular red piece can only move down.
			return true; // The move is legal.
		} else {
			if (board[r1][c1] == BLACK && r2 < r1)
				return false; // Regular black piece can only move up.
			return true; // The move is legal.
		}

	} // end canMove()
	
	
	/**
	 * Return a list of the legal jumps that the specified player can make
	 * starting from the specified row and column. If no such jumps are
	 * possible, null is returned. The logic is similar to the logic of the
	 * getLegalMoves() method.
	 */
	public static List<CheckersMove> getLegalJumpsFrom(int [][] board,int player, int row, int col) {
		if (player != RED && player != BLACK)
			return null;

		// The constant representing a King belonging to player
		int playerKing; 

		if (player == RED)
			playerKing = RED_KING;
		else
			playerKing = BLACK_KING;
		ArrayList<CheckersMove> moves = new ArrayList<CheckersMove>();
		// The legal jumps will be stored in this list.
		
		if (board[row][col] == player || board[row][col] == playerKing) {
			if (canJump(board,player, row, col, row + 1, col + 1, row + 2,
					col + 2))
				moves.add(new CheckersMove(row, col, row + 2, col + 2));
			if (canJump(board,player, row, col, row - 1, col + 1, row - 2,
					col + 2))
				moves.add(new CheckersMove(row, col, row - 2, col + 2));
			if (canJump(board,player, row, col, row + 1, col - 1, row + 2,
					col - 2))
				moves.add(new CheckersMove(row, col, row + 2, col - 2));
			if (canJump(board,player, row, col, row - 1, col - 1, row - 2,
					col - 2))
				moves.add(new CheckersMove(row, col, row - 2, col - 2));
		}
		
		return moves;
	} // end getLegalMovesFrom()
}
