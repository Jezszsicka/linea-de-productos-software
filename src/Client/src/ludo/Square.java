package ludo;

public class Square {
	private int square;
	private int pieces;
	private int firstPiece;
	private int secondPiece;

	public Square(int square) {
		this.square = square;
		firstPiece = Ludo.EMPTY;
		secondPiece = Ludo.EMPTY;
	}

	public Square(int firstPiece, int secondPiece) {
		this.firstPiece = firstPiece;
		this.secondPiece = secondPiece;
	}

	public void addPiece(int player) {
		if (firstPiece == Ludo.EMPTY) {
			firstPiece = player;
		} else {
			if (secondPiece == Ludo.EMPTY)
				secondPiece = player;
		}
	}

	public void removePiece(int player) {
		if (firstPiece == player) {
			firstPiece = Ludo.EMPTY;
		} else {
			secondPiece = player;
		}
	}

	public int numberOfPieces() {
		int pieces = 0;

		if (firstPiece != Ludo.EMPTY)
			pieces++;

		if (secondPiece != Ludo.EMPTY)
			pieces++;

		return pieces;

	}

	/**
	 * @return the square
	 */
	public int getSquare() {
		return square;
	}

	/**
	 * @param square
	 *            the square to set
	 */
	public void setSquare(int square) {
		this.square = square;
	}

	/**
	 * @return the firstPiece
	 */
	public int getFirstPiece() {
		return firstPiece;
	}

	/**
	 * @param firstPiece
	 *            the firstPiece to set
	 */
	public void setFirstPiece(int firstPiece) {
		this.firstPiece = firstPiece;
	}

	/**
	 * @return the secondPiece
	 */
	public int getSecondPiece() {
		return secondPiece;
	}

	/**
	 * @param secondPiece
	 *            the secondPiece to set
	 */
	public void setSecondPiece(int secondPiece) {
		this.secondPiece = secondPiece;
	}

	/**
	 * @return the pieces
	 */
	public int getPieces() {
		pieces = 0;
		
		if (firstPiece != Ludo.EMPTY)
			pieces++;

		if (secondPiece != Ludo.EMPTY)
			pieces++;
		
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "Square [square=" + square + ", firstPiece=" + firstPiece
				+ ", secondPiece=" + secondPiece + "]";
	}
}
