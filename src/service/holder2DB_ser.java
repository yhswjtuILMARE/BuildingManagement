package service;

import Factorys.BuildingFactory;
import Factorys.UsersFactory;
import domain.BuildingBean;
import domain.holderBean;
import serviceimpl.UsersAccess2DB;
import serviceimpl.dataAccessObject;

public class holder2DB_ser {
	
	private UsersAccess2DB impl = null;
	
	public holder2DB_ser(){
		impl = UsersFactory.getFactory("dao.holder2DB").getImple();
	}
	
	public int insert(holderBean bean){
		
		return impl.insert(bean);
	}
	
	public holderBean login(String username){
		
		return (holderBean) impl.login(username);
	}
	
	public boolean isExisted(String username){
		
		return impl.isExist(username);
	}
	
	public Object select(String holder_id){
		return impl.select(holder_id);
	}
	
	public int update(holderBean bean){
		return impl.update(bean);
	}

}
