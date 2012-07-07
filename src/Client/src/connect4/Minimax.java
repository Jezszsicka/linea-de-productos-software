package connect4;

/**Clase que implementa el algoritmo minimax para el juego de 4 en raya**/
public class Minimax {
	private int maximo;
	
	/**Contruye una instancia del algoritmo minimax
	 * @param maximo Indica la profundidad m�xima a la que llegar� el algoritmo
	 * minimax**/
	public Minimax(int maximo){
		this.maximo=maximo;
	}
	
	/**Realiza la b�squeda minimax
	 * @param estado Tablero con la situacion actual del juego
	 * @param jugador Jugador para el que se desea saber el mejor movimiento
	 * @return Un entero que representa la columna encontrada como mejor opci�n**/
	public int minimax(Tablero estado,int jugador){
		int mejorMovimiento=-1;
		int mejorSucesor=Integer.MIN_VALUE;
		for(int i=0;i<estado.getTablero()[0].length;i++){
			Tablero aux=estado.clonar();
			int valorSucesor=Integer.MIN_VALUE;
			if(aux.ponerFicha(i, jugador)){
				valorSucesor=Min_Valor(aux,Integer.MIN_VALUE,Integer.MAX_VALUE,cambiarJugador(jugador),i,1);
				if(valorSucesor>=mejorSucesor){
					mejorSucesor=valorSucesor;
					mejorMovimiento=i;
				}
			}
		}
		return mejorMovimiento;
	}
	
	/**Funcion max valor del algortimo minimax
	 * @param estado Tablero con la situacion del juego
	 * @param alpha Parametro alpha del algoritmo minimax
	 * @param beta Parametro beta del algoritmo minimax
	 * @param jugador Jugador que debe realizar el siguiente movimiento
	 * @param columna Columna donde se coloc� la ultima ficha
	 * @param profundidad Profundidad en la que se encuentra el algoritmo**/
	public int Max_Valor(Tablero estado,int alpha,int beta,int jugador,int columna,int profundidad){
		if(ganador(jugador,estado,columna))return Integer.MAX_VALUE;
		else if(ganador(cambiarJugador(jugador),estado,columna))return Integer.MIN_VALUE;
		else if(hayEmpate(estado))
			if(tresEnRaya(estado.getTablero(),jugador)>tresEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MAX_VALUE;
			else if(tresEnRaya(estado.getTablero(),jugador)<tresEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MIN_VALUE;
			else if(dosEnRaya(estado.getTablero(),jugador)>dosEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MAX_VALUE;
			else if(dosEnRaya(estado.getTablero(),jugador)<dosEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MIN_VALUE;
			else return 0;
		else if(profundidad>=maximo)
			return utilidad(estado,jugador);
		
		int valor=Integer.MIN_VALUE;
		Tablero aux;
		for(int i=0;i<estado.getTablero()[0].length;i++){
			aux=estado.clonar();
			if(aux.ponerFicha(i, jugador)){
				valor=Math.max(valor, Min_Valor(aux,alpha,beta,cambiarJugador(jugador),i,profundidad+1));
				if(valor>=beta){
					return valor;
				}
				alpha=Math.max(alpha,valor);
			}
		}
		return valor;
	}
	
	
	/**Funcion min valor del algortimo minimax
	 * @param estado Tablero con la situacion del juego
	 * @param alpha Parametro alpha del algoritmo minimax
	 * @param beta Parametro beta del algoritmo minimax
	 * @param jugador Jugador que debe realizar el siguiente movimiento
	 * @param columna Columna donde se coloc� la ultima ficha
	 * @param profundidad Profundidad en la que se encuentra el algoritmo**/
	public int Min_Valor(Tablero estado,int alpha,int beta,int jugador,int columna,int profundidad){
		if(ganador(jugador,estado,columna)){
			return Integer.MIN_VALUE;
		}
		else if(ganador(cambiarJugador(jugador),estado,columna)){
			return Integer.MAX_VALUE;
		}
		else if(hayEmpate(estado))
			if(tresEnRaya(estado.getTablero(),jugador)>tresEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MIN_VALUE;
			else if(tresEnRaya(estado.getTablero(),jugador)<tresEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MAX_VALUE;
			else if(dosEnRaya(estado.getTablero(),jugador)>dosEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MIN_VALUE;
			else if(dosEnRaya(estado.getTablero(),jugador)<dosEnRaya(estado.getTablero(),cambiarJugador(jugador)))
				return Integer.MAX_VALUE;
			else return 0;
		else if(profundidad>=maximo)
			return utilidad(estado,jugador);
		
		int valor=Integer.MAX_VALUE;
		Tablero aux;
		for(int i=0;i<estado.getTablero()[0].length;i++){
			aux=estado.clonar();
			if(aux.ponerFicha(i, jugador)){
				valor=Math.min(valor,Max_Valor(aux,alpha,beta,cambiarJugador(jugador),i,profundidad+1));
				if(valor<=alpha){
					return valor;
				}
				beta=Math.min(beta,valor);
			}
		}
		return valor;	
	}

	/**Comprueba si el jugador ha ganado al colocar la ultima ficha
	 * @param jugador Jugador del cual se desea comprobar si se ha ganado
	 * @param tablero Tablero con la situacion actual del juego
	 * @param columna Columna donde se coloco la ultima ficha
	 * @return Devuelve TRUE si el jugador ha ganado y FALSE en caso contrario**/
	public boolean ganador(int jugador,Tablero tablero,int columna){
		int fila=0;
		try{
		while(tablero.getTablero()[fila][columna]!=jugador)
			fila++;
		}catch(IndexOutOfBoundsException e){
			return false;
		}
		return vertical(jugador,tablero.getTablero(),fila,columna)|| horizontal(jugador,tablero.getTablero(),fila,columna)||
		ascenDer(jugador,tablero.getTablero(),fila,columna) || ascenIzq(jugador,tablero.getTablero(),fila,columna);
	}
	
	/**Comprueba si existe cuatro en raya en diagonal ascendente hacia la derecha
	 * o diagonal descendente hacia la izquierda
	 * @param jugador Jugador del cual se desea comprobar si se ha ganado
	 * @param tablero Tablero con la situacion actual del juego
	 * @param fila Fila donde se coloco la ultima ficha
	 * @param columna Columna donde se coloco la ultima ficha
	 * @return Devuelve TRUE si el jugador ha ganado y FALSE en caso contrario**/
	public boolean ascenDer(int jugador,int [][]tablero,int fila,int columna){
		boolean ganador=false;
		try{
			ganador=tablero[fila+1][columna+1]==jugador && tablero[fila+2][columna+2]==jugador
			&& tablero[fila+3][columna+3]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-1][columna-1]==jugador && tablero[fila+1][columna+1]==jugador
				&& tablero[fila+2][columna+2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-2][columna-2]==jugador && tablero[fila-1][columna-1]==jugador
				&& tablero[fila+1][columna+1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-3][columna-3]==jugador && tablero[fila-2][columna-2]==jugador
				&& tablero[fila-1][columna-1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return ganador;
	}
	
	/**Comprueba si existe cuatro en raya en diagonal ascendente hacia la izquierda
	 * o diagonal descendente hacia la derecha
	 * @param jugador Jugador del cual se desea comprobar si se ha ganado
	 * @param tablero Tablero con la situacion actual del juego
	 * @param fila Fila donde se coloco la ultima ficha
	 * @param columna Columna donde se coloco la ultima ficha
	 * @return Devuelve TRUE si el jugador ha ganado y FALSE en caso contrario**/
	public boolean ascenIzq(int jugador,int [][] tablero,int fila,int columna){
		boolean ganador=false;
		try{
			ganador=tablero[fila+1][columna-1]==jugador && tablero[fila+2][columna-2]==jugador
			&& tablero[fila+3][columna-3]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-1][columna+1]==jugador && tablero[fila+1][columna-1]==jugador
				&& tablero[fila+2][columna-2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-1][columna+1]==jugador && tablero[fila-2][columna+2]==jugador
				&& tablero[fila+1][columna-1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-1][columna+1]==jugador && tablero[fila-2][columna+2]==jugador
				&& tablero[fila-3][columna+3]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return ganador;
	}
	
	/**Comprueba si existe cuatro en raya en horizontal
	 * @param jugador Jugador del cual se desea comprobar si se ha ganado
	 * @param tablero Tablero con la situacion actual del juego
	 * @param fila Fila donde se coloco la ultima ficha
	 * @param columna Columna donde se coloco la ultima ficha
	 * @return Devuelve TRUE si el jugador ha ganado y FALSE en caso contrario**/
	public boolean horizontal(int jugador,int [][] tablero,int fila,int columna){
		boolean ganador=false;
		try{
			ganador=tablero[fila][columna+1]==jugador && tablero[fila][columna+2]==jugador
			&& tablero[fila][columna+3]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila][columna-1]==jugador && tablero[fila][columna+1]==jugador
				&& tablero[fila][columna+2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila][columna-2]==jugador && tablero[fila][columna-1]==jugador
				&& tablero[fila][columna+1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila][columna-3]==jugador && tablero[fila][columna-2]==jugador
				&& tablero[fila][columna-1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return ganador;
	}
	
	/**Comprueba si existe cuatro en raya en vertical
	 * @param jugador Jugador del cual se desea comprobar si se ha ganado
	 * @param tablero Tablero con la situacion actual del juego
	 * @param fila Fila donde se coloco la ultima ficha
	 * @param columna Columna donde se coloco la ultima ficha
	 * @return Devuelve TRUE si el jugador ha ganado y FALSE en caso contrario**/
	public boolean vertical(int jugador,int [][] tablero,int fila,int columna){
		boolean ganador=false;
		try{
			ganador=tablero[fila+1][columna]==jugador && tablero[fila+2][columna]==jugador
			&& tablero[fila+3][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-1][columna]==jugador && tablero[fila+1][columna]==jugador
				&& tablero[fila+2][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-2][columna]==jugador && tablero[fila-1][columna]==jugador
				&& tablero[fila+1][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!ganador)
				ganador=tablero[fila-3][columna]==jugador && tablero[fila-2][columna]==jugador
				&& tablero[fila-1][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return ganador;
	}
	
	/**Funcion de utilidad que devuelve un valor de utilidad en funcion de la situacion
	 * del juego
	 * @param estado Tablero con la situacion del juego
	 * @param jugador Jugador del que se desea saber su valor de utilidad
	 * @return El valor de la funcion de utilidad**/
	public int utilidad(Tablero estado,int jugador){
		int tres=tresEnRaya(estado.getTablero(),jugador);
		int dos=dosEnRaya(estado.getTablero(),jugador);
		return tres*60+dos*40;
	}
	
	/**Comprueba si el juego ha terminado en empate
	 * @param estado Tablero con la situacion del juego
	 * @return Devuelve TRUE si existe empate y FALSE en caso contrario**/
	public boolean hayEmpate(Tablero estado){
		boolean empate=true;
		for(int i=0;i<estado.getTablero()[0].length;i++)
			if(estado.getTablero()[0][i]==0)
				empate=false;
		return empate;
	}
	
	/**Cuenta el numero de tres en raya que tiene un jugador en el tablero
	 * @param tablero Tablero con la situacion del juego
	 * @param jugador Jugador del que se desea contar el numero de tres en raya
	 * @return Devuelve el numero de tres en raya del jugador en el tablero**/
	public int tresEnRaya(int [][] tablero,int jugador){
		int total=0;
		for(int i=0;i<tablero.length;i++)
			for(int j=0;j<tablero[0].length;j++)
				if(tresHorizontal(tablero,i,j,jugador) || tresVertical(tablero,i,j,jugador)
					|| tresDerAsc(tablero,i,j,jugador) || tresIzqAsc(tablero,i,j,jugador))
					total++;
		return total;
	}
	
	/**Comprueba si existe tres en raya en horizontal
	 * @param tablero Tablero con la situacion del juego
	 * @param fila Fila de la casilla que se toma como referencia
	 * @param columna Columna de la casilla que se toma como referencia
	 * @param jugador Jugador del que se desea saber si existe tres en raya**/
	private boolean tresHorizontal(int [][] tablero,int fila, int columna,int jugador){
		boolean raya=false;
		try{
			raya=tablero[fila][columna+1]==jugador && tablero[fila][columna+2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila][columna-1]==jugador && tablero[fila][columna+1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila][columna-1]==jugador && tablero[fila][columna-2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return raya;
	}
	
	/**Comprueba si existe tres en raya en vertical
	 * @param tablero Tablero con la situacion del juego
	 * @param fila Fila de la casilla que se toma como referencia
	 * @param columna Columna de la casilla que se toma como referencia
	 * @param jugador Jugador del que se desea saber si existe tres en raya
	 * @return Devuelve TRUE si existe tres en raya y FALSE en caso contrario**/
	public boolean tresVertical(int [][] tablero,int fila, int columna, int jugador){
		boolean raya=false;
		try{
			raya=tablero[fila+1][columna]==jugador && tablero[fila+2][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila-1][columna]==jugador && tablero[fila+1][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila-1][columna]==jugador && tablero[fila-2][columna]==jugador;
		}catch(IndexOutOfBoundsException e){}
		
		return raya;
	}
	
	/**Comprueba si existe tres en raya en diagonal ascendente hacia la derecha o en diagonal
	 * descendente hacia la izquierda
	 * @param tablero Tablero con la situacion del juego
	 * @param fila Fila de la casilla que se toma como referencia
	 * @param columna Columna de la casilla que se toma como referencia
	 * @param jugador Jugador del que se desea saber si existe tres en raya
	 * @return Devuelve TRUE si existe tres en raya y FALSE en caso contrario**/
	public boolean tresDerAsc(int [][] tablero, int fila, int columna, int jugador){
		boolean raya=false;
		try{
			raya=tablero[fila+1][columna+1]==jugador && tablero[fila+2][columna+2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila+1][columna+1]==jugador && tablero[fila-1][columna]-1==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila-1][columna-1]==jugador && tablero[fila-2][columna-2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		
		return raya;
	}
	
	/**Comprueba si existe tres en raya en diagonal ascendente hacia la izquierda o en diagonal
	 * descendente hacia la derecha
	 * @param tablero Tablero con la situacion del juego
	 * @param fila Fila de la casilla que se toma como referencia
	 * @param columna Columna de la casilla que se toma como referencia
	 * @param jugador Jugador del que se desea saber si existe tres en raya
	 * @return Devuelve TRUE si existe tres en raya y FALSE en caso contrario**/
	public boolean tresIzqAsc(int [][] tablero, int fila, int columna, int jugador){
		boolean raya=false;
		try{
			raya=tablero[fila+1][columna-1]==jugador && tablero[fila+2][columna-2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila+1][columna-1]==jugador && tablero[fila-1][columna+1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		try{
			if(!raya)
				raya=tablero[fila-1][columna+1]==jugador && tablero[fila-2][columna+2]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return raya;
	}
	
	/**Cuenta el numero de dos en raya que tiene un jugador en el tablero
	 * @param tablero Tablero con la situacion del juego
	 * @param jugador Jugador del que se desea contar el numero de dos en raya
	 * @return Devuelve el numero de dos en raya del jugador en el tablero**/
	public int dosEnRaya(int [][] tablero,int jugador){
		int total=0;
		for(int i=0;i<tablero.length;i++)
			for(int j=0;j<tablero[0].length;j++)
				if(dosEnRaya(tablero,i,j,jugador))
					total++;
		return total;
	}
	
	/**Comprueba si existe dos en raya 
	 * @param tablero Tablero con la situacion del juego
	 * @param fila Fila de la casilla que se toma como referencia
	 * @param columna Columna de la casilla que se toma como referencia
	 * @param jugador Jugador del que se desea saber si existe dos en raya
	 * @return Devuelve TRUE si existe dos en raya y FALSE en caso contrario**/
	public boolean dosEnRaya(int [][] tablero,int fila,int columna,int jugador){
		boolean dos=false;
		try{
			dos=tablero[fila+1][columna]==jugador || tablero[fila-1][columna]==jugador
			|| tablero[fila+1][columna+1]==jugador || tablero[fila+1][columna-1]==jugador
			|| tablero[fila][columna+1]==jugador || tablero[fila][columna-1]==jugador
			|| tablero[fila-1][columna+1]==jugador ||tablero[fila-1][columna-1]==jugador;
		}catch(IndexOutOfBoundsException e){}
		return dos;
	}
	
	/**Realiza el de turno entre jugadores
	 * @param jugador Jugador actual
	 * @return Jugador del siguiente turno**/
	public int cambiarJugador(int jugador){
		if(jugador==1)
			return 2;
		else return 1;
	}
	
}
