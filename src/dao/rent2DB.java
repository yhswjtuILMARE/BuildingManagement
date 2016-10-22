package dao;

import Utils.DBUtils;
import Utils.ListHandler;
import domain.page;
import domain.rent;
import domain.rentBean;
import serviceimpl.dataAccessObject;

public class rent2DB implements dataAccessObject{

	@Override
	public int insert(Object obj) {
		
		rentBean bean = (rentBean) obj;
		String sql = "insert into rent (rent_id,building_id,rentperson_id) values (?,?,?)";
		Object[] params = {bean.getRent_id(),bean.getBuilding_id(),bean.getRentperson_id()};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int getTotoalRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalRecord(String building_id) {
		// TODO Auto-generated method stub
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

		String sql = "select rent_id,building.building_address as building_address,rentperson.rentperson_name as rentperson_name,rentperson.rentperson_phone as rentperson_phone,building.building_cash as building_cash from building,buildingholder,rent,rentperson where buildingholder.holder_id='"+holder_id+"' and building.holder_id=buildingholder.holder_id and building.building_id=rent.building_id and rent.rentperson_id=rentperson.rentperson_id";
		Object[] params = {};
		return DBUtils.query(sql, params, new ListHandler(rent.class));
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from rent where rent_id=?";
		Object[] params = {id};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
