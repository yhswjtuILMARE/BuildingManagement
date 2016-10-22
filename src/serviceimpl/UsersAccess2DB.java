package serviceimpl;

public interface UsersAccess2DB {
	
	public int insert(Object obj);
	
	public Object login(String username);
	
	public boolean isExist(String username);
	
	public Object select(String id);
	
	public int update(Object obj);

}
