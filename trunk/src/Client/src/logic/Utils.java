package logic;

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
			e.printStackTrace();
		}

		return encoded;
	}

	public static String countryImgPath(int country) {
		String path = "/images/Flags/";
		switch (country) {
		case 0:
			path += "us";
			break;
		case 1:
			path += "es";
			break;
		case 2:
			path += "fr";
			break;
		case 3:
			path += "de";
			break;
		}
		return path + ".png";
	}

	public static String countrySmallImgPath(int country) {
		String path = "/images/Flags/";
		switch (country) {
		case 0:
			path += "us_small";
			break;
		case 1:
			path += "es_small";
			break;
		case 2:
			path += "fr_small";
			break;
		case 3:
			path += "de_small";
			break;
		}
		return path + ".png";
	}

}
