package serviceimpl;

import domain.page;

public interface dataAccessObject {
	
	public int insert(Object obj);
	
	public int getTotoalRecord();
	
	public int getTotalRecord(String building_id);
	
	public page select(int cruuentpage);
	
	public Object select(String id);
	
	public Object selectlist(String holder_id);
	
	public int delete(String id);
	
	public int update(Object obj);
}
