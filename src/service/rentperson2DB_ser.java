package service;

import Factorys.UsersFactory;
import domain.rentpersonBean;
import serviceimpl.UsersAccess2DB;

public class rentperson2DB_ser {
	
	private UsersAccess2DB impl = null;
	
	public rentperson2DB_ser(){
		impl = UsersFactory.getFactory("dao.rentperson2DB").getImple();
	}
	
	public int insert(rentpersonBean bean){
		
		return impl.insert(bean);
	}
	
	public rentpersonBean login(String username){
		
		return (rentpersonBean) impl.login(username);
	}
	
	public boolean isExisted(String username){
		
		return impl.isExist(username);
	}

}
