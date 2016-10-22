package dao;

import Utils.DBUtils;
import Utils.ObjectHandler;
import domain.rentpersonBean;
import serviceimpl.UsersAccess2DB;

public class rentperson2DB implements UsersAccess2DB {

	@Override
	public int insert(Object obj) {
		
		rentpersonBean bean = (rentpersonBean) obj;
		String sql = "insert into rentperson (rentperson_id,rentperson_name,rentperson_sex,rentperson_phone,rentperson_pwd) values (?,?,?,?,?)";
		Object[] params = {bean.getRentperson_id(),bean.getRentperson_name(),bean.getRentperson_sex(),bean.getRentperson_phone(),bean.getRentperson_pwd()};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public Object login(String username) {
		
		String sql = "select rentperson_id,rentperson_name,rentperson_sex,rentperson_phone,rentperson_pwd from rentperson where rentperson_name=?";
		Object[] params = {username};
		return DBUtils.query(sql, params, new ObjectHandler(rentpersonBean.class));
	}

	@Override
	public boolean isExist(String username) {
		
		String sql = "select rentperson_id,rentperson_name,rentperson_sex,rentperson_phone,rentperson_pwd from rentperson where rentperson_name=?";
		Object[] params = {username};
		rentpersonBean bean = (rentpersonBean) DBUtils.query(sql, params, new ObjectHandler(rentpersonBean.class));
		if(bean == null)return false;
		else return true;
	}

	@Override
	public Object select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
