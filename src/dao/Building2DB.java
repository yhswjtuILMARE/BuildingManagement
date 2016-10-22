package dao;

import java.util.List;

import Utils.DBUtils;
import Utils.IntegerUtils;
import Utils.ListHandler;
import Utils.ObjectHandler;
import domain.BuildingBean;
import domain.page;
import serviceimpl.dataAccessObject;

public class Building2DB implements dataAccessObject{
	
	public int insert(Object obj){
		
		BuildingBean bean = (BuildingBean) obj;
		String sql = "insert into building (building_id,holder_id,building_address,building_type,building_size,building_max_hold,building_cash,building_state,building_note,building_img) values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {bean.getBuilding_id(),bean.getHolder_id(),bean.getBuilding_address(),bean.getBuilding_type(),bean.getBuilding_size(),bean.getBuilding_max_hold(),bean.getBuilding_cash(),bean.getBuilding_state(),bean.getBuilding_note(),bean.getBuilding_img()};
		return DBUtils.Operate(sql, params);
	}
	
	@Override
	public int getTotoalRecord() {
		
		String sql = "select count(*) from building";
		Object[] params = {};
		return (int) DBUtils.query(sql, params, new IntegerUtils());
	}

	@Override
	public page select(int currentpage) {
		
		int totalRecord = getTotoalRecord();
		page p = new page(totalRecord, currentpage);
		int contain = p.getPageContain();
		int start = (currentpage - 1) * contain;
		String sql = "select building_id,holder_id,building_address,building_type,building_size,building_max_hold,building_cash,building_state,building_note,building_img from building limit ?,? ";
		Object[] params = {start, contain};
		p.setList((List) DBUtils.query(sql, params, new ListHandler(BuildingBean.class)));
		return p;
	}

	@Override
	public Object select(String id) {
		
		String sql = "select building_id,holder_id,building_address,building_type,building_size,building_max_hold,building_cash,building_state,building_note,building_img from building where building_id=?";
		Object[] params = {id};
		return DBUtils.query(sql, params, new ObjectHandler(BuildingBean.class));	
	}
	
	public Object selectlist(String holder_id){
		
		String sql = "select building_id,holder_id,building_address,building_type,building_size,building_max_hold,building_cash,building_state,building_note,building_img from building where holder_id=?";
		Object[] params = {holder_id};
		return DBUtils.query(sql, params, new ListHandler(BuildingBean.class));
	}

	@Override
	public int getTotalRecord(String building_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from building where building_id=?";
		Object[] params = {id};
		return DBUtils.Operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		
		BuildingBean bean = (BuildingBean) obj;
		String sql = "update building set building_address=? , building_type=? , building_size=? , building_max_hold=? , building_cash=? , building_state=? , building_note=? where building_id=?";
		Object[] params = {bean.getBuilding_address(),bean.getBuilding_type(),bean.getBuilding_size(),bean.getBuilding_max_hold(),bean.getBuilding_cash(),bean.getBuilding_state(),bean.getBuilding_note(),bean.getBuilding_id()};
		return DBUtils.Operate(sql, params);
	}

	

	

}
