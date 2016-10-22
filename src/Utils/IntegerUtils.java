package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import Interfaces.ResultHandler;

public class IntegerUtils implements ResultHandler{

	@Override
	public Object operate(ResultSet res) {
		
		try {
			while(res.next()){
				return res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return -1;
	}

}
