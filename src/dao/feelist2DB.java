package dao;

import Utils.DBUtils;
import Utils.ListHandler;
import domain.feelist;
import domain.feelistBean;
import domain.page;
import serviceimpl.dataAccessObject;

public class feelist2DB implements dataAccessObject{

	@Override
	public int insert(Object obj) {
		
		feelistBean bean = (feelistBean) obj;
		String sql = "insert into feelist (feelist_id,holder_id,building_id,rentperson_id,feelist_cash) values (?,?,?,?,?)";
		Object[] params = {bean.getFeelist_id(),bean.getHolder_id(),bean.getBuilding_id(),bean.getRentperson_id(),bean.getFeelist_cash()};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int getTotoalRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalRecord(String building_id) {
		
		return 0;
	}

	@Override
	public page select(int cruuentpage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectlist(String holder_id) {
		
		String sql = "select feelist_id,building.building_id as building_id,rentperson.rentperson_id as rentperson_id,building.building_address as building_address,rentperson.rentperson_name as rentperson_name,rentperson.rentperson_phone as rentperson_phone,feelist.feelist_cash as feelist_cash from building,feelist,rentperson where feelist.holder_id='"+holder_id+"' and building.building_id=feelist.building_id and feelist.rentperson_id=rentperson.rentperson_id";
		Object[] params = {};
		return DBUtils.query(sql, params, new ListHandler(feelist.class));
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from feelist where feelist_id=?";
		Object[] params = {id};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
