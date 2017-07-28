package myProject.paChong;

import infoInsertDao.InsetInfo;
import net.sf.json.JSONObject;
import pconline_crawler.Crawler;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月13日 上午9:57:33
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Insert_zb {

	public static void main(String[] args) {
		String url = "http://product.pconline.com.cn/mb/";
		Crawler crawler = new Crawler(url, 1, 61);
		JSONObject jsonObject = crawler.getData();
		InsetInfo info = new InsetInfo();
		info.insert_zb(jsonObject);
	}

}
