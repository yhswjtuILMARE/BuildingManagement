package service;

import java.util.List;

import Factorys.BuildingFactory;
import domain.page;
import domain.rentBean;
import serviceimpl.dataAccessObject;

public class rent2DB_ser {
	
	private dataAccessObject impl = null;
	
	public rent2DB_ser(){
		
		impl = BuildingFactory.getFactory("dao.rent2DB").getImple();
	}
	
	public int insert(rentBean bean){
		return impl.insert(bean);
	}
	
	public int getTotalRecord(){
		return impl.getTotoalRecord();
	}
	
	public int getTotalRecord(String rent_id){
		
		return impl.getTotalRecord(rent_id);
	}
	
	public page getHouse(int currentpage){
		
		return impl.select(currentpage);
	}
	
	public Object select(String rent_id){
		
		return impl.select(rent_id);
	}
	
	public List selectlist(String holder_id){
		return (List) impl.selectlist(holder_id);
	}
	
	public int delete(String rent_id){
		return impl.delete(rent_id);
	}

}
