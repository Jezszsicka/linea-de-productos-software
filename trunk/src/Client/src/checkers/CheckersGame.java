package checkers;

import java.util.ArrayList;
import java.util.List;





public class CheckersGame {
	private enum Square {Black,BlackKing,Red,RedKing,Empty};
	private Square[][] board;
	
	public CheckersGame(){
		super();
		board = new Square[8][8];
		initBoard();
	}
	
	private void initBoard(){
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (row % 2 == column % 2) {
					if (row < 3)
						board[row][column] = Square.Black;
					else if (row > 4)
						board[row][column] = Square.Red;
					else
						board[row][column] = Square.Empty;
				} else {
					board[row][column] = Square.Empty;
				}
			}
		}
		
		
		for(int i = 0;i<8;i++){
			System.out.print(i+" -");
			for(int j= 0;j<8;j++)
				System.out.print(" "+board[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	public Square getSquare(int row, int column){
		return board[row][column];
	}
	
	public void setSquare(int row, int column, Square square){
		board[row][column] = square;
	}
	
	public void move(int row, int column, int newRow, int newColumn){
		Square square = board[row][column];
		board[row][column] = Square.Empty;
		board[newRow][newColumn] = square;
	}
	
	public List<CheckersMove> legalMoves(Square player){
		if (player != Square.Red && player != Square.Black)
			return null;
		
		Square playerKing;
		
		if(player == Square.Red)
			playerKing = Square.RedKing;
		else
			playerKing = Square.BlackKing;
		
		
		List<CheckersMove> moves = new ArrayList<CheckersMove>();
		/*
		 * First, check for any possible jumps. Look at each square on the
		 * board. If that square contains one of the player's pieces, look
		 * at a possible jump in each of the four directions from that
		 * square. If there is a legal jump in that direction, put it in the
		 * moves ArrayList.
		 */

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board[row][col] == player
						|| board[row][col] == playerKing) {
					if (canJump(player, row, col, row + 1, col + 1,
							row + 2, col + 2))
						moves.add(new CheckersMove(row, col, row + 2,
								col + 2));
					if (canJump(player, row, col, row - 1, col + 1,
							row - 2, col + 2))
						moves.add(new CheckersMove(row, col, row - 2,
								col + 2));
					if (canJump(player, row, col, row + 1, col - 1,
							row + 2, col - 2))
						moves.add(new CheckersMove(row, col, row + 2,
								col - 2));
					if (canJump(player, row, col, row - 1, col - 1,
							row - 2, col - 2))
						moves.add(new CheckersMove(row, col, row - 2,
								col - 2));
				}
			}
		}
		
		/*
		 * If any jump moves were found, then the user must jump, so we
		 * don't add any regular moves. However, if no jumps were found,
		 * check for any legal regular moves. Look at each square on the
		 * board. If that square contains one of the player's pieces, look
		 * at a possible move in each of the four directions from that
		 * square. If there is a legal move in that direction, put it in the
		 * moves ArrayList.
		 */

		if (moves.size() == 0) {
			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
					if (board[row][col] == player
							|| board[row][col] == playerKing) {
						if (canMove(player, row, col, row + 1, col + 1))
							moves.add(new CheckersMove(row, col, row + 1,
									col + 1));
						if (canMove(player, row, col, row - 1, col + 1))
							moves.add(new CheckersMove(row, col, row - 1,
									col + 1));
						if (canMove(player, row, col, row + 1, col - 1))
							moves.add(new CheckersMove(row, col, row + 1,
									col - 1));
						if (canMove(player, row, col, row - 1, col - 1))
							moves.add(new CheckersMove(row, col, row - 1,
									col - 1));
					}
				}
			}
		}
		
		return moves;
	}
	
	/**
	 * This is called by the two previous methods to check whether the
	 * player can legally jump from (r1,c1) to (r3,c3). It is assumed that
	 * the player has a piece at (r1,c1), that (r3,c3) is a position that is
	 * 2 rows and 2 columns distant from (r1,c1) and that (r2,c2) is the
	 * square between (r1,c1) and (r3,c3).
	 */
	private boolean canJump(Square player, int r1, int c1, int r2, int c2,
			int r3, int c3) {

		if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
			return false; // (r3,c3) is off the board.

		if (board[r3][c3] != Square.Empty)
			return false; // (r3,c3) already contains a piece.

		if (player == Square.Red) {
			if (board[r1][c1] == Square.Red && r3 > r1)
				return false; // Regular red piece can only move up.
			if (board[r2][c2] != Square.Black && board[r2][c2] != Square.BlackKing)
				return false; // There is no black piece to jump.
			return true; // The jump is legal.
		} else {
			if (board[r1][c1] == Square.Black && r3 < r1)
				return false; // Regular black piece can only move downn.
			if (board[r2][c2] != Square.Red && board[r2][c2] != Square.RedKing)
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
	private boolean canMove(Square player, int r1, int c1, int r2, int c2) {

		if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
			return false; // (r2,c2) is off the board.

		if (board[r2][c2] != Square.Empty)
			return false; // (r2,c2) already contains a piece.

		if (player == Square.Red) {
			if (board[r1][c1] == Square.Red && r2 > r1)
				return false; // Regular red piece can only move down.
			return true; // The move is legal.
		} else {
			if (board[r1][c1] == Square.Black && r2 < r1)
				return false; // Regular black piece can only move up.
			return true; // The move is legal.
		}

	} // end canMove()
}
