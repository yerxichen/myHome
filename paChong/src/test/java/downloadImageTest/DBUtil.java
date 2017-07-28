package downloadImageTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.ConnectionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月17日 下午2:51:25
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class DBUtil {

	/**
	 * 查询列表
	 * 
	 * @param path
	 *            表名
	 * @return
	 */
	public JSONObject query_util(String path) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		JSONObject rtObj = new JSONObject(), rsObj = null;
		JSONArray rsArr = new JSONArray();
		String sql = "SELECT xxzjbh,title,pic FROM " + path;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			while (res.next()) {
				rsObj = new JSONObject();
				rsObj.put("xxzjbh", res.getString("xxzjbh"));
				rsObj.put("title", res.getString("title"));
				rsObj.put("pic", res.getString("pic"));
				rsArr.add(rsObj);
				count++;
				System.out.println("下载图片程序完成了" + count + "次");
			}
			rtObj.put("result", rsArr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(res, pstmt, conn);
		}

		return rtObj;
	}

	/**
	 * 
	 */
	public void save_util(int xxzjbh, String localPic, String tableName) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "UPDATE " + tableName + " SET localPic='" + localPic + "' WHERE xxzjbh=" + xxzjbh;
		// System.out.println(sql);
		// int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			// count++;
			// System.out.println("插入数据库程序完成了" + count + "次");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(res, pstmt, conn);
		}
	}
}
