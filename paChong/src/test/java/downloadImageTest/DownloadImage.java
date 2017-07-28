package downloadImageTest;

import Util.SaveImage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月17日 下午2:34:24
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class DownloadImage {

	public static void main(String[] args) {
		getImage("pc_cpu");
	}

	public static void getImage(String path) {
		int xxzjbh = 0;
		String title = "";
		String pic = "";
		DBUtil qu = new DBUtil();
		JSONObject obj = qu.query_util(path);
		JSONArray arr = obj.getJSONArray("result");
		for (int i = 0; i < arr.size(); i++) {
			JSONObject rsObj = (JSONObject) arr.get(i);
			xxzjbh = Integer.parseInt(rsObj.getString("xxzjbh"));
			title = rsObj.getString("title");
			// System.out.println(title);
			title = title.replaceAll("/", "_");
			title = title.replaceAll("\\*", "x");
			title = title.replaceAll(" ", "_");
			// System.out.println(title);
			pic = rsObj.getString("pic");
			SaveImage si = new SaveImage();
			si.saveImageToDisk(xxzjbh, title, pic, path);
			String localPic = "E:\\\\pc_image\\\\" + path + "\\\\" + title + "_" + xxzjbh + ".jpg";
			// System.out.println(localPic);
			qu.save_util(xxzjbh, localPic, path);
			System.out.println("完成" + i + "次");
		}
		System.out.println("程序结束！");
	}
}
