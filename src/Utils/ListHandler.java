package Utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Interfaces.ResultHandler;

public class ListHandler implements ResultHandler{

	private List list = new LinkedList();
	private Class clazz = null;
	public ListHandler(Class clazz){
		
		this.clazz = clazz;
	}
	
	@Override
	public Object operate(ResultSet res) {

		if(res == null) return null;
		
		try {
			if(res.wasNull()) return null;
			while(res.next()){
				ResultSetMetaData rm = res.getMetaData();
				int count = rm.getColumnCount();
				Object obj = clazz.newInstance();
				for(int i =0; i < count; i++){
					String name = rm.getColumnName(i+1);
					Object arg = res.getObject(i+1);
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(obj, arg);
				}list.add(obj);
			}return list;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
}
