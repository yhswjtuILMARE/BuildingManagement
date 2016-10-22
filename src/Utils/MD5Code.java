package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Code {
	
	public static String getToken(String message){
		
		try {
			MessageDigest dig = MessageDigest.getInstance("md5");
			byte[] buffer = dig.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(buffer);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
