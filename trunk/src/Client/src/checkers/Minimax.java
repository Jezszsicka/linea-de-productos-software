package checkers;

import java.util.List;

/** Clase que implementa el algoritmo minimax para el juego de 4 en raya **/
public class Minimax {
	private int maxDepth;
	private int[][] squareValues;

	/**
	 * Contruye una instancia del algoritmo minimax
	 * 
	 * @param maximo
	 *            Indica la profundidad m�xima a la que llegar� el algoritmo
	 *            minimax
	 **/
	public Minimax(int maximo) {
		this.maxDepth = maximo;
		int[][] squareValues = { { 4, 0, 4, 0, 4, 0, 4, 0 },
				{ 0, 3, 0, 3, 0, 3, 0, 4 }, { 0, 3, 0, 2, 0, 2, 0, 4 },
				{ 0, 3, 0, 1, 0, 2, 0, 4 }, { 4, 0, 2, 0, 1, 0, 3, 0 },
				{ 0, 3, 0, 2, 0, 2, 0, 4 }, { 4, 0, 3, 0, 3, 0, 3, 0 },
				{ 0, 4, 0, 4, 0, 4, 0, 4 } };
		this.squareValues = squareValues;
	}

	/**
	 * Realiza la búsqueda minimax
	 * 
	 * @param board
	 *            Tablero con la situacion actual del juego
	 * @param player
	 *            Jugador para el que se desea saber el mejor movimiento
	 * @return Un entero que representa la columna encontrada como mejor opci�n
	 **/
	public CheckersMove minimax(int[][] board, int player) {
		CheckersMove bestMove = null;
		int mejorSucesor = Integer.MIN_VALUE;
		List<CheckersMove> moves = Checkers.legalMoves(board, player);

		for (CheckersMove move : moves) {
			int[][] aux = clonar(board);
			int valorSucesor = Integer.MIN_VALUE;
			Checkers.move(aux, move.getFromRow(), move.getFromColumn(),
					move.getToRow(), move.getToColumn());
			valorSucesor = Min_Valor(aux, Integer.MIN_VALUE, Integer.MAX_VALUE,
					changePlayer(player), move, 1);

			if (valorSucesor >= mejorSucesor) {
				mejorSucesor = valorSucesor;
				bestMove = move;
			}
		}

		return bestMove;

	}

	/**
	 * Funcion max valor del algortimo minimax
	 * 
	 * @param board
	 *            Tablero con la situacion del juego
	 * @param alpha
	 *            Parametro alpha del algoritmo minimax
	 * @param beta
	 *            Parametro beta del algoritmo minimax
	 * @param jugador
	 *            Jugador que debe realizar el siguiente movimiento
	 * @param columna
	 *            Columna donde se coloc� la ultima ficha
	 * @param profundidad
	 *            Profundidad en la que se encuentra el algoritmo
	 **/
	public int Max_Valor(int[][] board, int alpha, int beta, int player,
			CheckersMove move, int depth) {

		if (winner(changePlayer(player), board, move)) {
			return Integer.MIN_VALUE;
		} else if (depth >= maxDepth)
			return evaluationFunction(board, player);

		int valor = Integer.MIN_VALUE;
		List<CheckersMove> moves = Checkers.legalMoves(board, player);
		int[][] aux;

		for (CheckersMove nextMove : moves) {
			aux = clonar(board);
			Checkers.move(aux, nextMove.getFromRow(),
					nextMove.getFromColumn(), nextMove.getToRow(),
					nextMove.getToColumn());
			if (valor >= beta) {
				return valor;
			}
			alpha = Math.max(alpha, valor);
		}

		return valor;
	}

	/**
	 * Funcion min valor del algortimo minimax
	 * 
	 * @param board
	 *            Tablero con la situacion del juego
	 * @param alpha
	 *            Parametro alpha del algoritmo minimax
	 * @param beta
	 *            Parametro beta del algoritmo minimax
	 * @param player
	 *            Jugador que debe realizar el siguiente movimiento
	 * @param columna
	 *            Columna donde se coloc� la ultima ficha
	 * @param depth
	 *            Profundidad en la que se encuentra el algoritmo
	 **/
	public int Min_Valor(int[][] board, int alpha, int beta, int player,
			CheckersMove move, int depth) {

		if (winner(changePlayer(player), board, move)) {
			return Integer.MAX_VALUE;
		} else if (depth >= maxDepth)
			return evaluationFunction(board, player);

		int valor = Integer.MAX_VALUE;
		List<CheckersMove> moves = Checkers.legalMoves(board, player);

		int[][] aux;

		for (CheckersMove nextMove : moves) {
			aux = clonar(board);
			Checkers.move(aux, nextMove.getFromRow(),
					nextMove.getFromColumn(), nextMove.getToRow(),
					nextMove.getToColumn());
			valor = Math.min(
					valor,
					Max_Valor(aux, alpha, beta, changePlayer(player),
							nextMove, depth + 1));
			if (valor <= alpha) {
				return valor;
			}
			beta = Math.min(beta, valor);
		}

		return valor;
	}

	public boolean winner(int player, int[][] board, CheckersMove move) {
		int[][] auxBoard = clonar(board);
		Checkers.move(auxBoard, move.getFromRow(), move.getFromColumn(),
				move.getToRow(), move.getToColumn());
		List<CheckersMove> moves = Checkers.legalMoves(auxBoard,
				changePlayer(player));
		if (moves.size() > 0)
			return false;
		else
			return true;
	}

	public int evaluationFunction(int[][] board, int player) {
		int figures = 0;
		int utility = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				switch (board[i][j]) {
				case Checkers.RED:
					if (player == Checkers.RED) {
						figures++;
						utility += squareValues[i][j] * 5;
					}
					break;
				case Checkers.RED_KING:
					if (player == Checkers.RED) {
						figures++;
						utility += squareValues[i][j] * 10;
					}
					break;
				case Checkers.BLACK:
					if (player == Checkers.BLACK) {
						figures++;
						utility += squareValues[i][j] * 5;
					}
					break;
				case Checkers.BLACK_KING:
					if (player == Checkers.BLACK) {
						figures++;
						utility += squareValues[i][j] * 10;
					}
					break;
				}
			}
		}

		return utility / figures;
	}

	/**
	 * Realiza el de turno entre jugadores
	 * 
	 * @param jugador
	 *            Jugador actual
	 * @return Jugador del siguiente turno
	 **/
	public int changePlayer(int jugador) {
		if (jugador == Checkers.RED)
			return Checkers.BLACK;
		else
			return Checkers.RED;
	}

	/**
	 * Realiza una copia del tablero actual
	 * 
	 * @return Devuelve la copia del tablero
	 **/
	private int[][] clonar(int[][] tablero) {
		int[][] copia = new int[8][8];
		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[0].length; j++)
				copia[i][j] = tablero[i][j];
		return copia;
	}
}
