package Utils;

import java.util.UUID;

public class UniqueCode {
	
	public static String getUniqueCode(){
		
		return UUID.randomUUID().toString();
	}

}
