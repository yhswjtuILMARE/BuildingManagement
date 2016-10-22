package dao;

import Utils.DBUtils;
import Utils.ObjectHandler;
import domain.holderBean;
import serviceimpl.UsersAccess2DB;

public class holder2DB implements UsersAccess2DB {

	@Override
	public int insert(Object obj) {
		
		holderBean bean = (holderBean) obj;
		String sql = "insert into buildingholder (holder_id,holder_name,holder_address,holder_phone,holder_pwd) values (?,?,?,?,?)";
		Object[] params = {bean.getHolder_id(),bean.getHolder_name(),bean.getHolder_address(),bean.getHolder_phone(),bean.getHolder_pwd()};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public Object login(String username) {
		
		String sql = "select holder_id,holder_name,holder_address,holder_phone,holder_pwd from buildingholder where holder_name=?";
		Object[] params = {username};
		return DBUtils.query(sql, params, new ObjectHandler(holderBean.class));
	}

	@Override
	public boolean isExist(String username) {
		
		String sql = "select holder_id,holder_name,holder_address,holder_phone,holder_pwd from buildingholder where holder_name=?";
		Object[] params = {username};
		holderBean bean = (holderBean) DBUtils.query(sql, params, new ObjectHandler(holderBean.class));
		if(bean == null)return false;
		else return true;
	}

	@Override
	public Object select(String id) {
		
		String sql = "select holder_id,holder_name,holder_address,holder_phone,holder_pwd from buildingholder where holder_id=?";
		Object[] params = {id};
		return DBUtils.query(sql, params, new ObjectHandler(holderBean.class));
	}

	@Override
	public int update(Object obj) {
		
		holderBean bean = (holderBean) obj;
		String sql = "update buildingholder set holder_name=? , holder_address=? , holder_phone=? , holder_pwd=? where holder_id=?";
		Object[] params = {bean.getHolder_name(),bean.getHolder_address(),bean.getHolder_phone(),bean.getHolder_pwd(),bean.getHolder_id()};
		return DBUtils.Operate(sql, params);
	}

	

}
