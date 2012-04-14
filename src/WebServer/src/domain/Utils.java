package domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	
	public static String hashMD5(String password) {
		StringBuffer hexString = null;
		try {
			byte[] defaultBytes = password.getBytes();
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();

			hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1)
					hexString.append('0');

				hexString.append(hex);

			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hexString.toString();

	}
}



