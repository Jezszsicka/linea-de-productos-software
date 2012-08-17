package ludo;


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

	public static boolean validateMove(int piece, int squares,
			int[][] board, int player) {
		
		int fromSquare = board[player][piece];
		int toSquare = fromSquare + squares;
		Square square;

		switch (player) {
		case YELLOW:
			// Caso normal
			if (fromSquare >= YELLOW_INITIAL_SQUARE
					&& toSquare <= YELLOW_LAST_SQUARE) {
				
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
			} else
			// En las casillas finales
			if (fromSquare >= 69 && fromSquare <= YELLOW_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > YELLOW_FINAL_SQUARE) {
					int offset = toSquare - YELLOW_FINAL_SQUARE;
					toSquare = YELLOW_FINAL_SQUARE - offset;
					
					for (int from = fromSquare + 1; from <= YELLOW_FINAL_SQUARE-1; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
					for (int from = YELLOW_FINAL_SQUARE-1; from >= toSquare; from--) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
					
					
				}// Llegamos justos o aún quedan casillas
				else {
					for (int from = fromSquare + 1; from <= toSquare; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2 && from != YELLOW_FINAL_SQUARE)
							return false;
					}
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= YELLOW_LAST_SQUARE
					&& toSquare > YELLOW_LAST_SQUARE) {
				
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
			}
			break;
		case RED:
			// Caso normal 39-68 y Caso normal 1-34
			if ((fromSquare >= RED_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= RED_LAST_SQUARE)) {
				
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					if (toSquare > 68 && fromSquare <= 68 && from > 68) {
						from = 1;
						toSquare -= 68;
					}

					square = squareInfo(board, from);

					if (square.numberOfPieces() == 2)
						return false;
				}
			} else
			// En las casillas finales
			if (fromSquare >= 77 && fromSquare <= RED_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > RED_FINAL_SQUARE) {
					int offset = toSquare - RED_FINAL_SQUARE;
					toSquare = RED_FINAL_SQUARE - offset;
					
					for (int from = fromSquare + 1; from <= RED_FINAL_SQUARE-1; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
					for (int from = RED_FINAL_SQUARE-1; from >= toSquare; from--) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
				}// Llegamos justos o aún quedan casillas
				else {
					for (int from = fromSquare + 1; from <= toSquare; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= RED_LAST_SQUARE && toSquare > RED_LAST_SQUARE) {
				int squaresToFinal = RED_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 76 + innerSquares;
				
				for (int from = fromSquare + 1; from <= RED_LAST_SQUARE; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
				for (int from = 77; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
			}
			break;
		case BLUE:
			// Caso normal 22-68 y Caso normal 1-17
			if ((fromSquare >= BLUE_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= BLUE_LAST_SQUARE)) {
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				int squaresToChange = 68 - fromSquare;
				toSquare = squares - squaresToChange;

				for (int from = fromSquare + 1; from <= toSquare; from++) {
					if (toSquare > 68 && fromSquare <= 68 && from > 68) {
						from = 1;
						toSquare -= 68;
					}

					square = squareInfo(board, from);

					if (square.numberOfPieces() == 2)
						return false;
				}
				
			} else
			// En las casillas finales
			if (fromSquare >= 85 && fromSquare <= BLUE_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > BLUE_FINAL_SQUARE) {
					int offset = toSquare - BLUE_FINAL_SQUARE;
					toSquare = BLUE_FINAL_SQUARE - offset;
					
					for (int from = fromSquare + 1; from <= BLUE_FINAL_SQUARE-1; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
					for (int from = BLUE_FINAL_SQUARE-1; from >= toSquare; from--) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
				}// Llegamos justos o aún quedan casillas
				else {
					for (int from = fromSquare + 1; from <= toSquare; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= BLUE_LAST_SQUARE && toSquare > BLUE_LAST_SQUARE) {
				int squaresToFinal = BLUE_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 84 + innerSquares;
				
				for (int from = fromSquare + 1; from <= BLUE_LAST_SQUARE; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
				for (int from = 85; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
			}
			break;
		case GREEN:
			// Caso normal 56-68 y Caso normal 1-51
			if ((fromSquare >= GREEN_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= GREEN_LAST_SQUARE)) {
				
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				int squaresToChange = 68 - fromSquare;
				toSquare = squares - squaresToChange;
				
				for (int from = fromSquare + 1; from <= toSquare; from++) {
					if (toSquare > 68 && fromSquare <= 68 && from > 68) {
						from = 1;
						toSquare -= 68;
					}

					square = squareInfo(board, from);

					if (square.numberOfPieces() == 2)
						return false;
				}
				
			} else
			// En las casillas finales
			if (fromSquare >= 93 && fromSquare <= GREEN_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > GREEN_FINAL_SQUARE) {
					int offset = toSquare - GREEN_FINAL_SQUARE;
					toSquare = GREEN_FINAL_SQUARE - offset;
					
					for (int from = fromSquare + 1; from <= GREEN_FINAL_SQUARE-1; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
					for (int from = GREEN_FINAL_SQUARE-1; from >= toSquare; from--) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
					
				}// Llegamos justos o aún quedan casillas
				else {
					for (int from = fromSquare + 1; from <= toSquare; from++) {
						square = squareInfo(board, from);
						if (square.numberOfPieces() == 2)
							return false;
					}
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= GREEN_LAST_SQUARE && toSquare > GREEN_LAST_SQUARE) {
				int squaresToFinal = GREEN_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 93 + innerSquares;

				for (int from = fromSquare + 1; from <= GREEN_LAST_SQUARE; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
				
				for (int from = 93; from <= toSquare; from++) {
					square = squareInfo(board, from);
					if (square.numberOfPieces() == 2)
						return false;
				}
			}
			break;
			
		}
		
		return true;
		
	}

	public static boolean move(int piece, int squares, int[][] board, int player) {

		int fromSquare = board[player][piece];
		int toSquare = fromSquare + squares;

		switch (player) {
		case YELLOW:
			// Caso normal
			if (fromSquare >= YELLOW_INITIAL_SQUARE
					&& toSquare <= YELLOW_LAST_SQUARE) {
				board[player][piece] = toSquare;
			} else
			// En las casillas finales
			if (fromSquare >= 69 && fromSquare <= YELLOW_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > YELLOW_FINAL_SQUARE) {
					int offset = toSquare - YELLOW_FINAL_SQUARE;
					toSquare = YELLOW_FINAL_SQUARE - offset;
					board[player][piece] = toSquare;
				}// Llegamos justos o aún quedan casillas
				else {
					board[player][piece] = toSquare;
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= YELLOW_LAST_SQUARE
					&& toSquare > YELLOW_LAST_SQUARE) {
				board[player][piece] = toSquare;
			}
			break;
		case RED:
			// Caso normal 39-68 y Caso normal 1-34
			if ((fromSquare >= RED_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= RED_LAST_SQUARE)) {
				board[player][piece] = toSquare;
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				int squaresToChange = 68 - fromSquare;
				toSquare = squares - squaresToChange;
				board[player][piece] = toSquare;
			} else
			// En las casillas finales
			if (fromSquare >= 77 && fromSquare <= RED_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > RED_FINAL_SQUARE) {
					int offset = toSquare - RED_FINAL_SQUARE;
					toSquare = RED_FINAL_SQUARE - offset;
					board[player][piece] = toSquare;
				}// Llegamos justos o aún quedan casillas
				else {
					board[player][piece] = toSquare;
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= RED_LAST_SQUARE && toSquare > RED_LAST_SQUARE) {
				int squaresToFinal = RED_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 76 + innerSquares;
				board[player][piece] = toSquare;
			}
			break;
		case BLUE:
			// Caso normal 22-68 y Caso normal 1-17
			if ((fromSquare >= BLUE_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= BLUE_LAST_SQUARE)) {
				board[player][piece] = toSquare;
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				int squaresToChange = 68 - fromSquare;
				toSquare = squares - squaresToChange;
				board[player][piece] = toSquare;
			} else
			// En las casillas finales
			if (fromSquare >= 77 && fromSquare <= BLUE_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > BLUE_FINAL_SQUARE) {
					int offset = toSquare - BLUE_FINAL_SQUARE;
					toSquare = BLUE_FINAL_SQUARE - offset;
					board[player][piece] = toSquare;
				}// Llegamos justos o aún quedan casillas
				else {
					board[player][piece] = toSquare;
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= BLUE_LAST_SQUARE && toSquare > BLUE_LAST_SQUARE) {
				int squaresToFinal = BLUE_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 84 + innerSquares;
				board[player][piece] = toSquare;
			}
			break;
		case GREEN:
			// Caso normal 56-68 y Caso normal 1-51
			if ((fromSquare >= GREEN_INITIAL_SQUARE && toSquare <= 68)
					|| (fromSquare >= 1 && toSquare <= GREEN_LAST_SQUARE)) {
				board[player][piece] = toSquare;
			} else
			// Caso normal pasamos del tramo 1 al 2
			if (fromSquare <= 68 && toSquare > 68) {
				int squaresToChange = 68 - fromSquare;
				toSquare = squares - squaresToChange;
				board[player][piece] = toSquare;
			} else
			// En las casillas finales
			if (fromSquare >= 77 && fromSquare <= GREEN_FINAL_SQUARE - 1) {
				// Nos pasamos de la casilla final
				if (toSquare > GREEN_FINAL_SQUARE) {
					int offset = toSquare - GREEN_FINAL_SQUARE;
					toSquare = GREEN_FINAL_SQUARE - offset;
					board[player][piece] = toSquare;
				}// Llegamos justos o aún quedan casillas
				else {
					board[player][piece] = toSquare;
				}
			} else
			// Entramos en las casillas finales
			if (fromSquare <= GREEN_LAST_SQUARE && toSquare > GREEN_LAST_SQUARE) {
				int squaresToFinal = GREEN_LAST_SQUARE - fromSquare;
				int innerSquares = squares - squaresToFinal;
				toSquare = 93 + innerSquares;
				board[player][piece] = toSquare;
			}
			break;
		}

		// Comprobar si hay que comer la ficha de la casilla en al que se cae
		Square squareInfo = Ludo.squareInfo(board, toSquare);
		int squareNum = squareInfo.getSquare();
		if (squareInfo.numberOfPieces() == 2 && squareNum != 5
				&& squareNum != 12 && squareNum != 22 && squareNum != 29
				&& squareNum != 39 && squareNum != 46 && squareNum != 56
				&& squareNum != 63) {
			if (squareInfo.getFirstPiece() != player){
				pieceToHouse(board, squareInfo.getFirstPiece(), squareNum);
				return true;
			}
			else if (squareInfo.getSecondPiece() != player){
				pieceToHouse(board, squareInfo.getSecondPiece(), squareNum);
				return true;
			}

		}

		return false;
	}

	private static void pieceToHouse(int[][] board, int player, int squareNum) {
		for (int i = 0; i < 4; i++)
			if (board[player][i] == squareNum) {
				board[player][i] = Ludo.HOUSE;
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

	public static int piecesInFinalSquare(int[][] board, int player) {
		int pieces = 0;
		int finalSquare = 0;

		switch (player) {
		case YELLOW:
			finalSquare = YELLOW_FINAL_SQUARE;
			break;
		case RED:
			finalSquare = RED_FINAL_SQUARE;
			break;
		case BLUE:
			finalSquare = BLUE_FINAL_SQUARE;
			break;
		case GREEN:
			finalSquare = GREEN_FINAL_SQUARE;
			break;
		}

		for (int i = 0; i < 4; i++)
			if (board[player][i] == finalSquare)
				pieces++;

		return pieces;
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

	public static void printState(int[][] board) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
