package connect4;

public class Connect4 {
	// RED is always the first player
	public static int EMPTY = -1;
	public static int RED = 0;
	public static int BLUE = 1;

	/**
	 * Coloca una ficha en el tablero
	 * 
	 * @param columna
	 *            Columna donde se desea poner la ficha
	 * @param jugador
	 *            Jugador que desea poner la ficha
	 * @return Devuelve TRUE si la ficha se ha colocado correctamente y FALSE si
	 *         la ficha no se ha podido colocar
	 **/
	public static boolean ponerFicha(int[][] tablero, int columna, int jugador) {
		int fila = libre(tablero, columna);
		if (fila != -1) {
			tablero[fila][columna] = jugador;
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si existe alguna casilla libre en la columna donde se desea
	 * colocar la ficha
	 * 
	 * @param columna
	 *            Columna donde se desea colocar la ficha
	 * @return Devuelve la fila libre en el caso de que se pueda colocar la
	 *         ficha y -1 en caso contrario
	 **/
	public static int libre(int[][] tablero, int columna) {
		int fila = -1;
		for (int i = tablero.length - 1; i >= 0 && fila == -1; i--)
			try{
			if (tablero[i][columna] == -1)
				fila = i;
			}catch(IndexOutOfBoundsException e){System.out.println("Ha petado el libres");};
		return fila;
	}

	/**
	 * Realiza una copia del tablero actual
	 * 
	 * @return Devuelve la copia del tablero
	 **/
	public int[][] clonar(int[][] tablero) {
		int[][] copiaTablero = new int[6][7];
		for (int i = 0; i < copiaTablero.length; i++)
			for (int j = 0; j < copiaTablero[0].length; j++)
				copiaTablero[i][j] = tablero[i][j];
		return copiaTablero;
	}

	/** Muestra el tablero de juego **/
	public void mostrar(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void initBoard(int[][] board) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = EMPTY;

	}
}
