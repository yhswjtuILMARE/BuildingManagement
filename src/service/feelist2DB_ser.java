package service;

import Factorys.BuildingFactory;
import domain.feelistBean;
import domain.page;
import serviceimpl.dataAccessObject;

public class feelist2DB_ser {
	
	private dataAccessObject impl = null;
	
	public feelist2DB_ser(){
		
		impl = BuildingFactory.getFactory("dao.feelist2DB").getImple();
	}
	
	public int insert(feelistBean bean){
		return impl.insert(bean);
	}
	
	public int getTotalRecord(){
		return impl.getTotoalRecord();
	}
	
	public int getTotalRecord(String feelist_id){
		
		return impl.getTotalRecord(feelist_id);
	}
	
	public page getHouse(int currentpage){
		
		return impl.select(currentpage);
	}
	
	public Object select(String feelist_id){
		
		return impl.select(feelist_id);
	}
	
	public Object selectlist(String holder_id){
		return impl.selectlist(holder_id);
	}
	
	public int delete(String feelist_id){
		return impl.delete(feelist_id);
	}

}
