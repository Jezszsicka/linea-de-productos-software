package checkers;

public class CheckersMove {
	private int fromRow;
	private int fromColumn;
	private int toRow;
	private int toColumn;
	
	
	/**
	 * @param fromRow
	 * @param fromColumn
	 * @param toRow
	 * @param toColumn
	 */
	public CheckersMove(int fromRow, int fromColumn, int toRow, int toColumn) {
		this.fromRow = fromRow;
		this.fromColumn = fromColumn;
		this.toRow = toRow;
		this.toColumn = toColumn;
	}


	/**
	 * @return the fromRow
	 */
	public int getFromRow() {
		return fromRow;
	}


	/**
	 * @param fromRow the fromRow to set
	 */
	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}


	/**
	 * @return the fromColumn
	 */
	public int getFromColumn() {
		return fromColumn;
	}


	/**
	 * @param fromColumn the fromColumn to set
	 */
	public void setFromColumn(int fromColumn) {
		this.fromColumn = fromColumn;
	}


	/**
	 * @return the toRow
	 */
	public int getToRow() {
		return toRow;
	}


	/**
	 * @param toRow the toRow to set
	 */
	public void setToRow(int toRow) {
		this.toRow = toRow;
	}


	/**
	 * @return the toColumn
	 */
	public int getToColumn() {
		return toColumn;
	}


	/**
	 * @param toColumn the toColumn to set
	 */
	public void setToColumn(int toColumn) {
		this.toColumn = toColumn;
	}
	
	boolean isJump() {
		// Test whether this move is a jump. It is assumed that
		// the move is legal. In a jump, the piece moves two
		// rows. (In a regular move, it only moves one row.)
		return (fromRow - toRow == 2 || fromRow - toRow == -2);
	}
	

}
