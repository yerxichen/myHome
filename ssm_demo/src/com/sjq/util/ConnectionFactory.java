package com.sjq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class ConnectionFactory {

	private static BoneCP connectionPool = null;

	static {
		Properties properties = new Properties();

		try {
			ClassLoader cl = ConnectionFactory.class.getClassLoader();
			InputStream is = cl.getResourceAsStream("jdbc.properties");
			properties.load(is);
			Class.forName(properties.getProperty("mysql.config.drivername", ""));
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(properties.getProperty("mysql.config.url", ""));
			config.setUsername(properties.getProperty("mysql.config.username", ""));
			config.setPassword(properties.getProperty("mysql.config.password", ""));
			config.setMinConnectionsPerPartition(0);
			config.setMaxConnectionsPerPartition(100);
			config.setPartitionCount(1);
			config.setPoolName("pool2");
			try {
				connectionPool = new BoneCP(config);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库链接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * close resultSet
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * close Statement
	 * 
	 * @param stmt
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * close PreparedStatement
	 * 
	 * @param ps
	 */
	public static void closePreparedStatement(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * close Connection
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * close All
	 */
	public static void closeAll(Object... args) {
		for (int i = 0; i < args.length; i++) {
			// close ResultSet
			if (args[i] instanceof ResultSet) {
				closeResultSet((ResultSet) args[i]);
				continue;
			}

			// close Statement
			if (args[i] instanceof Statement) {
				closeStatement((Statement) args[i]);
				continue;
			}

			// close PreparedStatement
			if (args[i] instanceof PreparedStatement) {
				closePreparedStatement((PreparedStatement) args[i]);
				continue;
			}

			// close Connection
			if (args[i] instanceof Connection) {
				closeConnection((Connection) args[i]);
				continue;
			}
		}
	}

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		try {
			System.out.println(connection.getMetaData().getDriverName().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
