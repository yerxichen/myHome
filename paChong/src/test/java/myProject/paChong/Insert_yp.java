package myProject.paChong;

import infoInsertDao.InsetInfo;
import net.sf.json.JSONObject;
import pconline_crawler.Crawler;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月13日 下午3:37:57
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Insert_yp {

	public static void main(String[] args) {
		String url = "http://product.pconline.com.cn/harddisk/";
		Crawler crawler = new Crawler(url, 1, 8);
		JSONObject jsonObject = crawler.getData();
		InsetInfo info = new InsetInfo();
		info.insert_yp(jsonObject);

	}

}
