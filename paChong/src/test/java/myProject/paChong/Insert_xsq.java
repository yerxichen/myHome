package myProject.paChong;

import infoInsertDao.InsetInfo;
import net.sf.json.JSONObject;
import pconline_crawler.Crawler;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月13日 下午2:48:47
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class Insert_xsq {

	public static void main(String[] args) {
		String url = "http://product.pconline.com.cn/lcd/";
		Crawler crawler = new Crawler(url, 1, 121);
		JSONObject jsonObject = crawler.getData();
		InsetInfo info = new InsetInfo();
		info.insert_xsq(jsonObject);

	}

}
