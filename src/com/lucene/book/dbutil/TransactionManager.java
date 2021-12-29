package com.lucene.book.dbutil;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TransactionManager {
	
	// 开启事务
	public void openTransaction(final Connection connection) {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 提交事务
	public void commitTransaction(final Connection connection) {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 回滚事务
	public void rollbackTransaction(final Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
