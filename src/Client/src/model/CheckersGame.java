package model;

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
	
	

}
