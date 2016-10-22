package dao;

import Utils.DBUtils;
import Utils.IntegerUtils;
import domain.page;
import domain.seebuilding;
import serviceimpl.dataAccessObject;

public class seebuilding2DB implements dataAccessObject {

	@Override
	public int insert(Object obj) {
		
		seebuilding bean = (seebuilding) obj;
		String sql = "insert into seebuilding (seebuilding_id,building_id,rentperson_id,seebuilding_address) values (?,?,?,?)";
		Object[] params = {bean.getSeebuilding_id(),bean.getBuilding_id(),bean.getRentperson_id(),bean.getSeebuilding_address()};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int getTotoalRecord() {
		
		return 0;
	}

	@Override
	public int getTotalRecord(String building_id) {
		String sql = "select count(*) from seebuilding where building_id=?";
		Object[] params = {building_id};
		return (int) DBUtils.query(sql, params, new IntegerUtils());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
