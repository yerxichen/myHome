package myProject.paChong;

import infoInsertDao.InsetInfo;
import net.sf.json.JSONObject;
import pconline_crawler.Crawler;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月13日 下午4:30:55
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Insert_dy {

	public static void main(String[] args) {
		String url = "http://product.pconline.com.cn/power/";
		Crawler crawler = new Crawler(url, 1, 55);
		JSONObject jsonObject = crawler.getData();
		InsetInfo info = new InsetInfo();
		info.insert_dy(jsonObject);

	}

}
