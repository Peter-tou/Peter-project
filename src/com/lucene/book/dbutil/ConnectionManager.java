package com.lucene.book.dbutil;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	// 方法1.获取数据库连接对象
	public Connection getConnection() {
		try {
			Context cxt = new InitialContext();

			DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/peterDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 方法2.断开数据库连接对象
	public void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
