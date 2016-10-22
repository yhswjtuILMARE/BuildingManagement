package service;

import java.util.List;

import Factorys.BuildingFactory;
import domain.BuildingBean;
import domain.page;
import serviceimpl.dataAccessObject;

public class Building2DB_ser {
	
	private dataAccessObject impl = null;
	private String path = null;
	
	public Building2DB_ser(String path){
		this.path = path;
		impl = BuildingFactory.getFactory(path).getImple();
	}
	
	public int insert(BuildingBean bean){
		return impl.insert(bean);
	}
	
	public int getTotalRecord(){
		return impl.getTotoalRecord();
	}
	
	public page getHouse(int currentpage){
		
		return impl.select(currentpage);
	}
	
	public Object select(String building_id){
		
		return impl.select(building_id);
	}
	
	public List selectlist(String holder_id){
		
		return (List) impl.selectlist(holder_id);
	}
	
	public int delete(String building_id){
		return impl.delete(building_id);
	}
	
	public int update (BuildingBean bean){
		return impl.update(bean);
	}

}
