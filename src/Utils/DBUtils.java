package Utils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import Interfaces.ResultHandler;

public class DBUtils {
	
	private static ComboPooledDataSource com = null;
	
	static{
		com = new ComboPooledDataSource("mysql");
	}
	
	private static Connection getConnection() throws SQLException{
		
		return com.getConnection();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		}
		return 0;
	}

	public static Object query(String sql, Object params[], ResultHandler handler){
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet res = null;
		
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			ParameterMetaData pd = st.getParameterMetaData();
			int count = pd.getParameterCount();
			for(int i = 0; i < count; i++){
				st.setObject(i+1, params[i]);
			}
			res = st.executeQuery();
			return handler.operate(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getRelease(con,st,res);
		}
		return null;
	}
}
