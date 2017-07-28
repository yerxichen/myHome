package pconline_crawler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月12日 上午10:17:03
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
/**
 * @author hasee
 *
 */
public class Crawler {
	private String url;
	private int nowPage;
	private int endPage;

	/**
	 * @param url
	 *            需要抓取的url
	 * @param nowPage
	 *            分页当前页页码
	 * @param endPage
	 *            分页显示最后一页页码
	 */
	public Crawler(String url, int nowPage, int endPage) {
		super();
		this.url = url;
		this.nowPage = nowPage;
		this.endPage = endPage;
	}

	/**
	 * 获取爬取的数据
	 * 
	 * @return suKEY:result sonKEY:detail
	 * @throws Exception
	 */
	public JSONObject getData() {
		JSONObject rtObj = new JSONObject(), rsObject = null;
		JSONArray rsArr = new JSONArray();
		for (int i = nowPage - 1; i < endPage; i++) {
			rsObject = new JSONObject();
			if (i != 0) {
				int index = url.lastIndexOf("/");
				url = url.substring(0, index + 1) + i * 25 + "s1.shtml";
			}
			System.err.println("start==" + url);
			MyHttpClient myHttpClient = new MyHttpClient();
			String html = myHttpClient.getURLContext(url);
			MyJsoup myJsoup = new MyJsoup();
			rsObject = myJsoup.pconlineJsoup(html);
			rsArr.add(rsObject);
		}
		rtObj.put("result", rsArr);
		return rtObj;
	}

}
