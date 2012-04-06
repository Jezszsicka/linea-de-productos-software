import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String email = "_@as@test.com";
		Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();

		if(matchFound){
		System.out.println("EMAIL OK");
		}else{
		System.out.println("EMAIL ERROR");
		}

	}

}
