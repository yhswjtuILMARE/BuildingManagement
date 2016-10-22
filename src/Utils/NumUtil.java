package Utils;

public class NumUtil {
	
	public static String NumUtil(Double cash){
		
		String cashs = cash + "";
		if(cashs.indexOf(".") == -1){
			return cashs;
		}else if((cashs.length() - cashs.indexOf(".")) <= 3){
			
			return cashs;
		}
		cashs = cashs.substring(0, (cashs.indexOf(".") + 3));
		return cashs;
	}

}
