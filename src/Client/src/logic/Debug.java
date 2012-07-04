package logic;

public class Debug {
	private static boolean debug = true;
	
	public static void print(String message){
		if(debug)
			System.out.println(message);
	}
	
	public static void printError(String error){
		if(debug)
			System.err.print(error);
	}
}
