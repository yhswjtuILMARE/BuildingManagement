package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Interfaces.ResultHandler;

public class sqlServerUtils {
	
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			url = "jdbc:sqlserver://localhost:1433;DatabaseName=buildingmanagement";
			username = "ben";
			password = "123456";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, username, password);
	}
	
	private static void getRelease(Connection con, Statement st, ResultSet res){
		
		if(res != null){
			try {
				res.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static int Operate(String sql, Object[] params){
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet res = null;
		
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			ParameterMetaData pm = st.getParameterMetaData();
			int count = pm.getParameterCount();
			for(int i = 0; i < count; i++){
				st.setObject(i+1, params[i]);
			}
			return st.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			getRelease(con, st, res);
		}return -1;
	}
	
	public static Object query(String sql, Object[] params, ResultHandler res){
		
		Connection  con = null;
		PreparedStatement st = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			ParameterMetaData pm = st.getParameterMetaData();
			int count = pm.getParameterCount();
			for(int i =0; i < count; i++){
				st.setObject(i+1, params[i]);
			}
			result = st.executeQuery();
			return res.operate(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			getRelease(con, st, result);
		}return null;
	}

}
