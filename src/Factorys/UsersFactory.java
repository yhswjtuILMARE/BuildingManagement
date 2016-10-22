package Factorys;

import serviceimpl.UsersAccess2DB;
import serviceimpl.dataAccessObject;

public class UsersFactory {
	
	private String classpath = null;
	private UsersAccess2DB impl = null;
	
	private UsersFactory(String classpath){
		this.classpath = classpath;
	}
	
	public static UsersFactory getFactory(String classpath){
		UsersFactory factory = new UsersFactory(classpath);
		return factory;
	}
	
	public UsersAccess2DB getImple(){
		
		try {
			Class clazz = Class.forName(classpath);
			impl = (UsersAccess2DB) clazz.newInstance();
			return impl;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}

}
