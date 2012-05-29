package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import ProductLine.User;

public class LanguageManager {
	private static LanguageManager language;
	private ResourceBundle strings;
	private Properties preferences;
	private int languageCode;
	
	private LanguageManager(){
		preferences = new Properties();
		File file = new File("preferences.properties");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			preferences.load(in);
			languageCode = Integer.parseInt(preferences.getProperty("default"));
			strings = ResourceBundle.getBundle("Strings",codeToLocale(languageCode));
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LanguageManager language(){
		if(language == null){
			language = new LanguageManager();
		}
		
		return language;
	}
	
	
	public void setLanguage(String language, String country){
		Locale locale = new Locale(language,country);
		strings = ResourceBundle.getBundle("Strings", locale);
	}
	
	public void setLanguage(String user,int languageCode){
		this.languageCode = languageCode;
		Locale locale = codeToLocale(languageCode);	
		strings = ResourceBundle.getBundle("Strings",locale);
		preferences.setProperty(user,String.valueOf(languageCode));
		preferences.setProperty("default", String.valueOf(languageCode));
		try{
		FileOutputStream out = new FileOutputStream("preferences.properties");
		preferences.store(out, "");
		out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getString(String key){
		return strings.getString(key);
	}
	
	public void loadPreferences(User user){
		preferences = new Properties();
		File file = new File("preferences.properties");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			preferences.load(in);
			int language = Integer.parseInt(preferences.getProperty(user.getUsername(),String.valueOf(user.getCountry())));
			strings = ResourceBundle.getBundle("Strings",codeToLocale(language));
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Locale codeToLocale(int languageCode){
		Locale locale = null;
		switch(languageCode){
			case 0:
				locale = Locale.getDefault();
				break;
			case 1:
				locale = new Locale("es","ES");
				break;
			case 2:
				locale = new Locale("fr","FR");
				break;
			case 3:
				locale = new Locale("de","DE");
		}
		return locale;
	}

	public int getLanguageCode() {
		return languageCode;
	}
	
}
