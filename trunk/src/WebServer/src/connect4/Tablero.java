package connect4;

/**Clase que representa el tablero de juego y alguna de las operaciones sobre el**/
public class Tablero {
	private int [][] tablero;
	
	/**Crea un tablero de 6x7 y lo inicializa con todas sus casillas a 0**/
	public Tablero(){
		tablero=new int[6][7];
		for(int i=0;i<tablero.length;i++)
			for(int j=0;j<tablero[0].length;j++)
				tablero[i][j]=0;
	}
	
	/**Coloca una ficha en el tablero
	 * @param columna Columna donde se desea poner la ficha
	 * @param jugador Jugador que desea poner la ficha
	 * @return Devuelve TRUE si la ficha se ha colocado correctamente y FALSE si
	 * la ficha no se ha podido colocar**/
	public boolean ponerFicha(int columna,int jugador){
		int fila=libre(columna);
		if(fila!=-1){
			tablero[fila][columna]=jugador;
			return true;
		}
		return false;
	}
	
	/**Comprueba si existe alguna casilla libre en la columna donde se desea colocar
	 * la ficha
	 * @param columna Columna donde se desea colocar la ficha
	 * @return Devuelve la fila libre en el caso de que se pueda colocar la ficha y
	 * -1 en caso contrario**/
	public int libre(int columna){
		int fila=-1;
		for(int i=tablero.length-1;i>=0 && fila==-1 ;i--)
			if(tablero[i][columna]==0)
				fila=i;
		return fila;
	}
	
	/**Permite acceder al tablero de juego
	 * @return Devuelve el tablero con la situacion del juego**/
	public int [][] getTablero(){
		return tablero;
	}
	
	/**Permite cambiar el tablero de juego por otro
	 * @param tablero Nuevo tablero de juego**/
	public void setTablero(int [][] tablero){
		this.tablero=tablero;
	}
	
	/**Realiza una copia del tablero actual
	 * @return Devuelve la copia del tablero**/
	public Tablero  clonar(){
		Tablero copia=new Tablero();
		int [][] tablero=new int [6][7];
		for(int i=0;i<tablero.length;i++)
			for(int j=0;j<tablero[0].length;j++)
				tablero[i][j]=this.tablero[i][j];
		copia.setTablero(tablero);
		return copia;
	}
	
	/**Muestra el tablero de juego**/
	public void mostrar(){
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero[0].length;j++){
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
