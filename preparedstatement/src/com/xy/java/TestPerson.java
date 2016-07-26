package com.xy.java;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.xy.utils.JdbcUtils;

public class TestPerson {
	public static void main(String[] args){
		TestPerson tp = new TestPerson();
		tp.find();
		//tp.update();
		//tp.insert();
		//tp.delete();
	} 
	
	public void find(){
		Connection conn       = null;
		PreparedStatement  st = null;
		   ResultSet rs       = null;
		   
	   try {
			      conn = JdbcUtils.getConnection();
	        String sql = "select * from students where id =? ";
			st = conn.prepareStatement(sql); 
			st.setInt(1,2);
			rs = st.executeQuery();
		  if(rs.next()){
			  System.out.println(rs.getString("name"));
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	public void insert(){
		Connection conn       = null;
		PreparedStatement  st = null;
		   ResultSet rs       = null;
		   
		try {
			        conn = JdbcUtils.getConnection();
			  String sql = "insert into students(id,name,sex,age)values(?,?,?,?)";
			          st = conn.prepareStatement(sql);
			  st.setInt(1, 10);
			  st.setString(2, "xy1");
			  st.setString(3, "Male");
			  st.setString(4, "24");
			  int num = st.executeUpdate();
			  if(num>0){
				  System.out.println("插入数据成功！");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void update(){
		Connection conn       = null;
		PreparedStatement  st = null;
		   ResultSet rs       = null;
		   
	   try {
			        conn = JdbcUtils.getConnection();
			  String sql = "update students set name = ? where id = ? ";
			  st = conn.prepareStatement(sql);
			  st.setString(1, "xyy");
			  st.setInt(2, 2);
			  int num = st.executeUpdate();
			  if(num>0){
				  System.out.println("更新数据成功！");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void delete(){
		Connection conn       = null;
		PreparedStatement  st = null;
		   ResultSet rs       = null;
		   
	   try {
			        conn = JdbcUtils.getConnection();
			  String sql = "delete from students where id=? ";
			  st = conn.prepareStatement(sql);
			  st.setInt(1, 10);
			  int num = st.executeUpdate();
			  if(num>0){
				  System.out.println("删除数据成功！");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
