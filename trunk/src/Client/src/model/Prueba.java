package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Format formatter = new SimpleDateFormat("EEEE"); 
		Date date = new Date(1212);
		
	    String s = formatter.format(date);
	    System.out.println(s);

	}

}
