package chess;

import java.util.ArrayList;
import java.util.List;

public class Chess {
	
	public enum Player {
		Black, White
	};

	public final static int EMPTY = -1;

	public final static int BLACK_INITIAL_PAWN = 0;
	public final static int BLACK_PAWN = 1;
	public final static int BLACK_ROOK = 2;
	public final static int BLACK_KNIGHT = 3;
	public final static int BLACK_BISHOP = 4;
	public final static int BLACK_KING = 5;
	public final static int BLACK_QUEEN = 6;

	public final static int WHITE_INITIAL_PAWN = 7;
	public final static int WHITE_PAWN = 8;
	public final static int WHITE_ROOK = 9;
	public final static int WHITE_KNIGHT = 10;
	public final static int WHITE_BISHOP = 11;
	public final static int WHITE_KING = 12;
	public final static int WHITE_QUEEN = 13;

	private final static int[][] KnightMoves = { { 2, 1 }, { 1, 2 }, { -1, 2 },
			{ 2, -1 }, { -2, 1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	private final static int[][] KingMoves = { { 0, 1 }, { 1, 0 }, { -1, 0 },
			{ 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

	public static void initBoard(int[][] board) {
		// Rooks
		board[0][0] = BLACK_ROOK;
		board[0][7] = BLACK_ROOK;
		board[7][0] = WHITE_ROOK;
		board[7][7] = WHITE_ROOK;

		// Knights
		board[0][1] = BLACK_KNIGHT;
		board[0][6] = BLACK_KNIGHT;
		board[7][1] = WHITE_KNIGHT;
		board[7][6] = WHITE_KNIGHT;

		// Bishops
		board[0][2] = BLACK_BISHOP;
		board[0][5] = BLACK_BISHOP;
		board[7][2] = WHITE_BISHOP;
		board[7][5] = WHITE_BISHOP;

		// Kings
		board[0][3] = BLACK_QUEEN;
		board[7][3] = WHITE_QUEEN;

		// Queens
		board[0][4] = BLACK_KING;
		board[7][4] = WHITE_KING;

		// Pawns
		for (int i = 0; i < 8; i++) {
			board[1][i] = BLACK_INITIAL_PAWN;
			board[6][i] = WHITE_INITIAL_PAWN;
		}

		// Empty
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	public static boolean move(int[][] board, Player player, int fromRow,
			int fromColumn, int toRow, int toColumn) {

		if (isValidMove(board, player, fromRow, fromColumn, toRow, toColumn)) {
			int piece = board[fromRow][fromColumn];
			switch (piece) {
			case BLACK_INITIAL_PAWN:
				piece = BLACK_PAWN;
				break;
			case WHITE_INITIAL_PAWN:
				piece = WHITE_PAWN;
				break;
			}

			board[toRow][toColumn] = piece;
			board[fromRow][fromColumn] = EMPTY;
			return true;
		}

		return false;

	}

	public static boolean isValidMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {
		boolean valid = false;
		final int piece = board[fromRow][fromColumn];

		switch (piece) {
		case BLACK_INITIAL_PAWN:
		case WHITE_INITIAL_PAWN:
			valid = checkPawnMove(board, player, fromRow, fromColumn, toRow,
					toColumn, true);
			break;

		case BLACK_PAWN:
		case WHITE_PAWN:
			valid = checkPawnMove(board, player, fromRow, fromColumn, toRow,
					toColumn, false);
			break;
		case BLACK_ROOK:
		case WHITE_ROOK:
			valid = checkRookMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
			break;
		case BLACK_KNIGHT:
		case WHITE_KNIGHT:
			valid = checkKnightMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
			break;
		case BLACK_BISHOP:
		case WHITE_BISHOP:
			valid = checkBishopMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
			break;
		case BLACK_QUEEN:
		case WHITE_QUEEN:
			valid = checkQueenMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
			break;
		case BLACK_KING:
		case WHITE_KING:
			valid = checkKingMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
			break;
		}

		return valid;
	}

	private static boolean checkPawnMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn,
			boolean initial) {
		switch (player) {
		case Black:

			// Straight-down move
			if (fromRow + 1 == toRow && fromColumn == toColumn) {
				if (board[toRow][toColumn] == EMPTY)
					return true;
			}

			// Double Straight-down move
			if (initial) {
				if (fromRow + 2 == toRow && fromColumn == toColumn) {
					if (board[toRow][toColumn] == EMPTY)
						return true;
				}
			}

			// Right-down diagonal move
			if (fromRow + 1 == toRow && fromColumn + 1 == toColumn) {
				if (isWhitePiece(board[toRow][toColumn]))
					return true;
			}

			// Left-down diagonal move
			if (fromRow + 1 == toRow && fromColumn - 1 == toColumn) {
				if (isWhitePiece(board[toRow][toColumn]))
					return true;
			}

			break;
		case White:

			// Straight-up move
			if (fromRow - 1 == toRow && fromColumn == toColumn) {
				if (board[toRow][toColumn] == EMPTY)
					return true;
			}

			if (initial) {
				// Double Straight-up move
				if (fromRow - 2 == toRow && fromColumn == toColumn) {
					if (board[toRow][toColumn] == EMPTY)
						return true;
				}
			}

			// Right-up diagonal move
			if (fromRow - 1 == toRow && fromColumn + 1 == toColumn) {
				if (isBlackPiece(board[toRow][toColumn]))
					return true;
			}

			// Left-up diagonal move
			if (fromRow - 1 == toRow && fromColumn - 1 == toColumn) {
				if (isBlackPiece(board[toRow][toColumn]))
					return true;
			}

			break;
		}

		return false;
	}

	private static boolean checkRookMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {

		// Horizontal move
		if (fromRow == toRow) {
			int offset = fromColumn - toColumn;
			// Move to the left
			if (offset > 0) {
				// Check if a piece is on the way
				for (int i = fromColumn - 1; i != toColumn; i--) {
					if (board[fromRow][i] != EMPTY) {
						return false;
					}
				}
			}
			// Move to the right
			else {
				// Check if a piece is on the way
				for (int i = fromColumn + 1; i != toColumn; i++) {
					if (board[fromRow][i] != EMPTY) {
						return false;
					}
				}
			}
		} else {
			// Vertical move
			if (fromColumn == toColumn) {
				int offset = fromRow - toRow;
				// Move up
				if (offset > 0) {
					// Check if a piece is on the way
					for (int i = fromRow - 1; i != toRow; i--)
						if (board[i][fromColumn] != EMPTY)
							return false;
				}
				// Move down
				else {
					// Check if a piece is on the way
					for (int i = fromRow + 1; i != toRow; i++)
						if (board[i][fromColumn] != EMPTY)
							return false;
				}
			} else {
				// Other invalid move
				return false;
			}

		}

		// Check target square
		if (player == Player.Black) {
			if (board[toRow][toColumn] == EMPTY
					|| isWhitePiece(board[toRow][toColumn]))
				return true;
		} else {
			if (board[toRow][toColumn] == EMPTY
					|| isBlackPiece(board[toRow][toColumn]))
				return true;
		}

		return false;
	}

	private static boolean checkKnightMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {

		int[] offset = { fromRow - toRow, fromColumn - toColumn };

		for (int[] knightMove : KnightMoves) {
			// Valid move
			if (offset[0] == knightMove[0] && offset[1] == knightMove[1]) {
				switch (player) {
				case Black:
					if (board[toRow][toColumn] == EMPTY
							|| isWhitePiece(board[toRow][toColumn]))
						return true;
					break;
				case White:
					if (board[toRow][toColumn] == EMPTY
							|| isBlackPiece(board[toRow][toColumn]))
						return true;
					break;
				}
			}
		}

		return false;
	}

	private static boolean checkBishopMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {
		int n1 = fromColumn - fromRow;
		int n2 = fromColumn + fromRow;
		int y1 = toRow + n1;
		int y2 = -toRow + n2;

		int rectN;
		int m;

		// Not diagonal move
		if (fromRow == toRow || fromColumn == toColumn)
			return false;

		if (y1 == toColumn) {
			rectN = n1;
			m = 1;
		} else if (y2 == toColumn) {
			rectN = n2;
			m = -1;
		} else
			return false;

		// Down diagonal
		if (fromRow < toRow) {
			System.out.println("Diagonal hacia abajo");
			for (int i = fromRow + 1; i != toRow; i++) {
				int j = m * i + rectN;
				if (board[i][j] != EMPTY)
					return false;
			}
		} else {
			// Up diagonal
			if (fromRow > toRow) {
				System.out.println("Diagonal hacia arriba");
				for (int i = fromRow - 1; i != toRow; i--) {
					int j = m * i + rectN;
					if (board[i][j] != EMPTY)
						return false;
				}
			}
		}

		// Check target square
		if (player == Player.Black) {
			if (board[toRow][toColumn] == EMPTY
					|| isWhitePiece(board[toRow][toColumn]))
				return true;
		} else {
			if (board[toRow][toColumn] == EMPTY
					|| isBlackPiece(board[toRow][toColumn]))
				return true;
		}

		return false;
	}

	private static boolean checkQueenMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {

		boolean valid;

		if (fromRow == toRow || fromColumn == toColumn)
			valid = checkRookMove(board, player, fromRow, fromColumn, toRow,
					toColumn);
		else
			valid = checkBishopMove(board, player, fromRow, fromColumn, toRow,
					toColumn);

		return valid;
	}

	private static boolean checkKingMove(int[][] board, Player player,
			int fromRow, int fromColumn, int toRow, int toColumn) {

		int[] offset = { fromRow - toRow, fromColumn - toColumn };

		for (int[] kingMove : KingMoves) {
			// Valid move
			if (offset[0] == kingMove[0] && offset[1] == kingMove[1]) {
				switch (player) {
				case Black:
					if (board[toRow][toColumn] == EMPTY
							|| isWhitePiece(board[toRow][toColumn]))
						return true;
					break;
				case White:
					if (board[toRow][toColumn] == EMPTY
							|| isBlackPiece(board[toRow][toColumn]))
						return true;
					break;
				}
			}
		}

		return false;

	}

	public static boolean check(int[][] board, Player player) {
		int[] kingPosition = findKing(board, player);

		Player opponentPlayer = changePlayer(player);
		

		if (opponentPlayer == Player.Black) {
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					int piece = board[row][column];
					if (isBlackPiece(piece))
						if (isValidMove(board, opponentPlayer, row, column,
								kingPosition[0], kingPosition[1]))
							return true;
				}
			}
		} else {
			for (int row = 0; row < 8; row++) {
				for (int column = 0; column < 8; column++) {
					int piece = board[row][column];
					if (isWhitePiece(piece))
						if (isValidMove(board, opponentPlayer, row, column,
								kingPosition[0], kingPosition[1]))
							return true;
				}
			}
		}
		return false;
	}

	public static boolean checkMate(int[][] board, Player player) {

		if (!check(board, player))
			return false;
		else {
			int[] kingPosition = findKing(board, player);
			List<int[]> moves = kingMoves(board, kingPosition, player);

			for (int[] move : moves) {
				int[][] auxBoard = clone(board);
				move(auxBoard, player, kingPosition[0], kingPosition[1],
						kingPosition[0] + move[0], kingPosition[1] + move[1]);
				if (!check(auxBoard, player))
					return false;
			}
		}

		return true;
	}

	private static int[][] clone(int[][] board) {
		int[][] copy = new int[8][8];
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				copy[i][j] = board[i][j];
		return copy;
	}

	private static List<int[]> kingMoves(int[][] board, int[] kingPosition,
			Player player) {
		List<int[]> moves = new ArrayList<int[]>();
		for (int[] move : KingMoves) {
			try {
				if (isValidMove(board, player, kingPosition[0],
						kingPosition[1], kingPosition[0] + move[0],
						kingPosition[1] + move[1]))
					moves.add(move);
			} catch (IndexOutOfBoundsException e) {
			}
		}

		return moves;
	}

	private static int[] findKing(int[][] board, Player player) {
		boolean found = false;
		int[] position = new int[2];
		int playerKing;

		if (player == Player.Black)
			playerKing = BLACK_KING;
		else
			playerKing = WHITE_KING;

		for (int row = 0; row < 8 && !found; row++)
			for (int column = 0; column < 8 && !found; column++)
				if (board[row][column] == playerKing) {
					position[0] = row;
					position[1] = column;
					found = true;
				}

		return position;
	}

	public static boolean isWhitePiece(int piece) {
		return piece >= 7 && piece <= 13;
	}

	public static boolean isBlackPiece(int piece) {
		return piece >= 0 && piece <= 6;
	}

	public static boolean isPawnPromoted(int[][] board, int row,int column, Player player) {
		int piece = board[row][column];
		if(piece == Chess.BLACK_PAWN || piece == Chess.WHITE_PAWN){
			if (player == Player.Black)
				return row == 7;
			else
				return row == 0;
		}
		
		return false;
	}

	public static Player changePlayer(Player player){
		if(player == Player.Black)
			return Player.White;
		
		return Player.Black;
	}
}
