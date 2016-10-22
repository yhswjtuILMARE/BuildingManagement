package Utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Interfaces.ResultHandler;


public class ObjectHandler implements ResultHandler{
	
	private Class clazz = null;
	
	public ObjectHandler(Class clazz){
		this.clazz = clazz;
	}

	@Override
	public Object operate(ResultSet res) {
		
		if(res == null) return null;
		
		try {
			if(res.next()){
				Object obj = clazz.newInstance();
				ResultSetMetaData rm = res.getMetaData();
				int count = rm.getColumnCount();
				for(int i = 0; i < count; i++){
					String name = rm.getColumnName(i+1);
					Object arg = res.getObject(i+1);
					PropertyDescriptor pro = new PropertyDescriptor(name, clazz);
					Method method = pro.getWriteMethod();
					method.invoke(obj, arg);
				}return obj;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
