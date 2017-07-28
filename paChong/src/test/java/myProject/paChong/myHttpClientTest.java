package myProject.paChong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pconline_crawler.Crawler;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月11日 下午1:57:26
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class myHttpClientTest {

	public static void main(String[] args) {
		String url = "http://product.pconline.com.cn/cpu/";
		Crawler crawler = new Crawler(url, 1, 11);
		JSONObject jsonObject = crawler.getData();
		// System.out.println(jsonObject);

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		JSONArray arr = (JSONArray) jsonObject.get("result");

		try {
			for (int i = 0; i < arr.size(); i++) {
				JSONObject resultObj = arr.getJSONObject(i);
				JSONArray detailArr = (JSONArray) resultObj.get("detail");
				System.out.println("detailArrsize==" + detailArr.size());
				for (int j = 0; j < detailArr.size(); j++) {
					JSONObject detailObj = detailArr.getJSONObject(j);
					// System.out.println("detailObj===" + detailObj);
					String sql = "INSERT INTO pc_cpu (xh,cpdw,xpcf,hxsl,hxlx,scgy,jklx,xcs,hxdy,zp,dtjs,ejhc,xshxxh,xshxpl,zctdms,zcncpl,lsswclq,tdpjs,xnh,gzgl,sxgjz) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("产品定位"));
					pstmt.setString(3, (String) detailObj.get("芯片厂方"));
					pstmt.setString(4, (String) detailObj.get("核心数量"));
					pstmt.setString(5, (String) detailObj.get("核心类型"));
					pstmt.setString(6, (String) detailObj.get("生产工艺"));
					pstmt.setString(7, (String) detailObj.get("接口类型"));
					pstmt.setString(8, (String) detailObj.get("线程数"));
					pstmt.setString(9, (String) detailObj.get("核心电压"));
					pstmt.setString(10, (String) detailObj.get("主频"));
					pstmt.setString(11, (String) detailObj.get("动态加速"));
					pstmt.setString(12, (String) detailObj.get("二级缓存"));
					pstmt.setString(13, (String) detailObj.get("显示核心型号"));
					pstmt.setString(14, (String) detailObj.get("显示核心频率"));
					pstmt.setString(15, (String) detailObj.get("支持通道模式"));
					pstmt.setString(16, (String) detailObj.get("支持内存频率"));
					pstmt.setString(17, (String) detailObj.get("64位处理器"));
					pstmt.setString(18, (String) detailObj.get("TDP技术"));
					pstmt.setString(19, (String) detailObj.get("Virtualization(虚拟化)"));
					pstmt.setString(20, (String) detailObj.get("工作功率"));
					pstmt.setString(21, (String) detailObj.get("属性关键字"));
					pstmt.execute();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

	}
}
