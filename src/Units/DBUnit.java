package Units;

import java.util.List;

import org.junit.Test;

import Beans.Account;
import Beans.Students;
import Utils.DBUtils;
import Utils.ListHandler;
import Utils.MD5Code;
import Utils.ObjectHandler;
import Utils.UniqueCode;
import Utils.sqlServerUtils;
import domain.feelist;

public class DBUnit {
	
	@Test
	public void test(){
		String sql = "select id,username,money from account where id=?";
		Object params[] = {2};
		Account account = (Account) DBUtils.query(sql, params, new ObjectHandler(Account.class));
		System.out.println(account.getUsername() +account.getMoney());
	}
	
	@Test
	public void test1(){
		String sql = "select id,username,money from account";
		Object params[] = {};
		List list = (List) DBUtils.query(sql, params, new ListHandler(Account.class));
		System.out.println(list.size());
	}
	
	@Test
	public void test2(){
		String sql = "update account set username=? where id=?";
		Object[] params = {"Peter",8};
		System.out.println(DBUtils.Operate(sql, params));
	}
	
	@Test
	public void test3(){
		
		String sql = "delete from students1 where sname=?";
		Object[] params = {"石彦"};
		System.out.println(sqlServerUtils.Operate(sql, params));
	}
	
	@Test
	public void test4(){
		
		String sql = "select snum,sname,cname from students1 where sname=?";
		Object[] params = {"肖杨"};
		List list = (List) sqlServerUtils.query(sql, params, new ListHandler(Students.class));
		System.out.println(list.size());
		
	}
	
	@Test
	public void test5(){
		
		String pwd = "940805";
		pwd = MD5Code.getToken(pwd);
		String sql = "update buildingholder set holder_pwd=? where holder_name=?";
		Object[] params = {pwd,"杨航"};
		System.out.println(sqlServerUtils.Operate(sql, params));
	}
	
	@Test
	public void test6(){
		
		String holder_id = "6d2bd431-3cfe-4038-8b43-5eda393582fd";
		String sql = "select building.building_id as building_id,rentperson.rentperson_id as rentperson_id,building.building_address as building_address,rentperson.rentperson_name as rentperson_name,rentperson.rentperson_phone as rentperson_phone,feelist.feelist_cash as feelist_cash from building,feelist,rentperson where feelist.holder_id='"+holder_id+"' and building.building_id=feelist.building_id and feelist.rentperson_id=rentperson.rentperson_id";
		//String sql = "select building.building_id as building_id,rentperson.rentperson_id as rentperson_id,building.building_address as building_address,rentperson.rentperson_name as rentperson_name,rentperson.rentperson_phone as rentperson_phone,feelist.feelist_cash as feelist_cash from building,feelist,rentperson where feelist.holder_id=" + holder_id + " and building.building_id=feelist.building_id and feelist.rentperson_id=rentperson.rentperson_id";
		Object[] params = {};
		List list = (List) sqlServerUtils.query(sql, params, new ListHandler(feelist.class));
		System.out.println(list.size());
	}
	
	@Test
	public void test7(){
		
		String sql1 = "insert into buildingholder (holder_id,holder_name,holder_address,holder_phone,holder_pwd) values (?,?,?,?,?)";
		String sql = "insert into building (building_id,holder_id,building_address,building_type,building_size,building_max_hold,building_cash,building_state,building_note,building_img) values (?,?,?,?,?,?,?,?,?,?)";
		for(int i = 0; i < 80; i++){
			String code = UniqueCode.getUniqueCode();
			Object[] params1 = {code, "David_" + i , "北京市东城区朝阳路" + i + "号", "185695478" + i, MD5Code.getToken("test")};
			DBUtils.Operate(sql1, params1);
			for(int j = 0; j < 10; j++){
				Object[] params = {UniqueCode.getUniqueCode(), code, "北京市东城区朝阳路" + i + "号", "三室两厅", 128, 3, 6500, "房子是刚刚装修过的", "专为高端人士打造", "/UploadFile/11/4/366a2677-d794-4d7e-8885-f9d7d34261a4_2659657054940149793.jpg"};
				DBUtils.Operate(sql, params);
			}
			
		}
	}
}














