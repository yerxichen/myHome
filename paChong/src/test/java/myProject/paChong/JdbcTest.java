package myProject.paChong;

import java.sql.Connection;

import org.junit.Test;

import Util.ConnectionFactory;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月12日 下午3:16:36
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class JdbcTest {
	@Test
	public void testConnection() {
		Connection conn = ConnectionFactory.getConnection();

	}
}
