package service;

import Factorys.BuildingFactory;
import domain.BuildingBean;
import domain.page;
import domain.seebuilding;
import serviceimpl.dataAccessObject;

public class seebuilding_ser {
	
	private dataAccessObject impl = null;
	
	public seebuilding_ser(){
		
		impl = BuildingFactory.getFactory("dao.seebuilding2DB").getImple();
	}
	
	public int insert(seebuilding bean){
		return impl.insert(bean);
	}
	
	public int getTotalRecord(){
		return impl.getTotoalRecord();
	}
	
	public int getTotalRecord(String building_id){
		
		return impl.getTotalRecord(building_id);
	}
	
	public page getHouse(int currentpage){
		
		return impl.select(currentpage);
	}
	
	public Object select(String seebuilding_id){
		
		return impl.select(seebuilding_id);
	}
}
