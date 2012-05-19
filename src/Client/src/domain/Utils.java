package domain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import IceUtilInternal.Base64;

public class Utils {

	public static String hashMD5_Base64(String password) {
		String encoded = null;
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.update(password.getBytes("UTF-8"));
			byte[] rawData = algorithm.digest();
			encoded = Base64.encode(rawData);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encoded;

	}
}
