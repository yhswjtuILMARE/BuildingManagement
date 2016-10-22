package Factorys;

import serviceimpl.dataAccessObject;

public class BuildingFactory {
	
	private String classpath = null;
	private dataAccessObject impl = null;
	
	private BuildingFactory(String classpath){
		
		this.classpath = classpath;
	}
	
	public static BuildingFactory getFactory(String classpath){
		BuildingFactory factory = new BuildingFactory(classpath);
		return factory;
	}
	
	public dataAccessObject getImple(){
		
		try {
			Class clazz = Class.forName(classpath);
			impl = (dataAccessObject) clazz.newInstance();
			return impl;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
}
