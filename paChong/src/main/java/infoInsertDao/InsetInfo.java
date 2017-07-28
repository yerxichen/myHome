package infoInsertDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月12日 下午5:56:47
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class InsetInfo {

	/**
	 * cpu数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_cpu(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_cpu (xh,cpdw,xpcf,hxsl,hxlx,scgy,jklx,xcs,hxdy,zp,dtjs,ejhc,xshxxh,xshxpl,zctdms,zcncpl,lsswclq,tdpjs,xnh,gzgl,sxgjz,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
					pstmt.setString(22, (String) detailObj.get("title"));
					pstmt.setString(23, (String) detailObj.get("price"));
					pstmt.setString(24, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 主板数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_zb(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_zb(xh,sylx,xpcs,xpzhbqxp,cpucc,zccpulx,zbjg,zcnclx,zctdms,nccc,ncpl,zdzcncrl,jcxkhx,bzsk,bzwk,ypjk,satasjksl,sataesl,cpzllx,cpzlms,zcxkbz,kzcc,pcicc,kzjk,usbjksl,dyhl,dyjk,yxdj,tsgn,wxcc,fj,title,price,pic)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("适用类型"));
					pstmt.setString(3, (String) detailObj.get("芯片厂商"));
					pstmt.setString(4, (String) detailObj.get("芯片组或北桥芯片"));
					pstmt.setString(5, (String) detailObj.get("CPU插槽"));
					pstmt.setString(6, (String) detailObj.get("支持CPU类型"));
					pstmt.setString(7, (String) detailObj.get("主板架构"));
					pstmt.setString(8, (String) detailObj.get("支持内存类型"));
					pstmt.setString(9, (String) detailObj.get("支持通道模式"));
					pstmt.setString(10, (String) detailObj.get("内存插槽"));
					pstmt.setString(11, (String) detailObj.get("内存频率"));
					pstmt.setString(12, (String) detailObj.get("最大支持内存容量"));
					pstmt.setString(13, (String) detailObj.get("集成显卡核心"));
					pstmt.setString(14, (String) detailObj.get("板载声卡"));
					pstmt.setString(15, (String) detailObj.get("板载网卡"));
					pstmt.setString(16, (String) detailObj.get("硬盘接口"));
					pstmt.setString(17, (String) detailObj.get("SATA III接口数量"));
					pstmt.setString(18, (String) detailObj.get("SATA-Express数量"));
					pstmt.setString(19, (String) detailObj.get("磁盘阵列类型"));
					pstmt.setString(20, (String) detailObj.get("磁盘阵列模式"));
					pstmt.setString(21, (String) detailObj.get("支持显卡标准"));
					pstmt.setString(22, (String) detailObj.get("扩展插槽"));
					pstmt.setString(23, (String) detailObj.get("PCI插槽"));
					pstmt.setString(24, (String) detailObj.get("扩展接口"));
					pstmt.setString(25, (String) detailObj.get("USB接口数量"));
					pstmt.setString(26, (String) detailObj.get("电源回路"));
					pstmt.setString(27, (String) detailObj.get("电源接口"));
					pstmt.setString(28, (String) detailObj.get("游戏等级"));
					pstmt.setString(29, (String) detailObj.get("特色功能"));
					pstmt.setString(30, (String) detailObj.get("外形尺寸"));
					pstmt.setString(31, (String) detailObj.get("附件"));
					pstmt.setString(32, (String) detailObj.get("title"));
					pstmt.setString(33, (String) detailObj.get("price"));
					pstmt.setString(34, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 显卡数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_xk(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_xk(xh,xklx,xpxh,xpdh,xpcf,zzgy,hxwk,xkjkbz,scjk,xcrl,xclx,xcwk,xcfz,xcdk,hxpl,lcldy,sdapi,sdtx,zdfbl,srms,dyjk,bkcc,tdpgh,tsgn,pj,title,price,pic)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("显卡类型"));
					pstmt.setString(3, (String) detailObj.get("芯片型号"));
					pstmt.setString(4, (String) detailObj.get("芯片代号"));
					pstmt.setString(5, (String) detailObj.get("芯片厂方"));
					pstmt.setString(6, (String) detailObj.get("制作工艺"));
					pstmt.setString(7, (String) detailObj.get("核心位宽"));
					pstmt.setString(8, (String) detailObj.get("显卡接口标准"));
					pstmt.setString(9, (String) detailObj.get("输出接口"));
					pstmt.setString(10, (String) detailObj.get("显存容量"));
					pstmt.setString(11, (String) detailObj.get("显存类型"));
					pstmt.setString(12, (String) detailObj.get("显存位宽"));
					pstmt.setString(13, (String) detailObj.get("显存封装"));
					pstmt.setString(14, (String) detailObj.get("显存带宽"));
					pstmt.setString(15, (String) detailObj.get("核心频率"));
					pstmt.setString(16, (String) detailObj.get("流处理器单元(SP)"));
					pstmt.setString(17, (String) detailObj.get("3D API"));
					pstmt.setString(18, (String) detailObj.get("3D特性"));
					pstmt.setString(19, (String) detailObj.get("最大分辨率"));
					pstmt.setString(20, (String) detailObj.get("散热描述"));
					pstmt.setString(21, (String) detailObj.get("电源接口"));
					pstmt.setString(22, (String) detailObj.get("板卡尺寸"));
					pstmt.setString(23, (String) detailObj.get("TDP功耗"));
					pstmt.setString(24, (String) detailObj.get("特色功能"));
					pstmt.setString(25, (String) detailObj.get("配件"));
					pstmt.setString(26, (String) detailObj.get("title"));
					pstmt.setString(27, (String) detailObj.get("price"));
					pstmt.setString(28, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 显卡数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_xsq(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_xsq(title,price,pic,xh,cc,pmbl,jklx,xncs,mblx,dj,ld,dxdbd,dtdbd,fbl,xysj,sxl,spksjd,czksjd,sy,sh,bglx,ql,mkjyx,pjld,dbd,hdgl,bzgl,qtxn,tsgn,wgcc,zl) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("title"));
					pstmt.setString(2, (String) detailObj.get("price"));
					pstmt.setString(3, (String) detailObj.get("pic"));
					pstmt.setString(4, (String) detailObj.get("型号"));
					pstmt.setString(5, (String) detailObj.get("尺寸"));
					pstmt.setString(6, (String) detailObj.get("屏幕比例"));
					pstmt.setString(7, (String) detailObj.get("接口类型"));
					pstmt.setString(8, (String) detailObj.get("性能参数"));
					pstmt.setString(9, (String) detailObj.get("面板类型"));
					pstmt.setString(10, (String) detailObj.get("点距"));
					pstmt.setString(11, (String) detailObj.get("亮度"));
					pstmt.setString(12, (String) detailObj.get("典型对比度"));
					pstmt.setString(13, (String) detailObj.get("动态对比度"));
					pstmt.setString(14, (String) detailObj.get("分辨率"));
					pstmt.setString(15, (String) detailObj.get("响应时间"));
					pstmt.setString(16, (String) detailObj.get("刷新率"));
					pstmt.setString(17, (String) detailObj.get("水平可视角度"));
					pstmt.setString(18, (String) detailObj.get("垂直可视角度"));
					pstmt.setString(19, (String) detailObj.get("色域"));
					pstmt.setString(20, (String) detailObj.get("色数"));
					pstmt.setString(21, (String) detailObj.get("背光类型"));
					pstmt.setString(22, (String) detailObj.get("曲率"));
					pstmt.setString(23, (String) detailObj.get("麦克及音箱"));
					pstmt.setString(24, (String) detailObj.get("平均亮度"));
					pstmt.setString(25, (String) detailObj.get("对比度"));
					pstmt.setString(26, (String) detailObj.get("耗电功率"));
					pstmt.setString(27, (String) detailObj.get("标准功率"));
					pstmt.setString(28, (String) detailObj.get("其他性能"));
					pstmt.setString(29, (String) detailObj.get("特色功能"));
					pstmt.setString(30, (String) detailObj.get("外观尺寸"));
					pstmt.setString(31, (String) detailObj.get("重量"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 内存数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_nc(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_nc(xh,sylx,nclx,nctd,nczp,nczrl,ncrlms,cjsm,ycms,ncdy,qtxn,bz,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("适用类型"));
					pstmt.setString(3, (String) detailObj.get("内存类型"));
					pstmt.setString(4, (String) detailObj.get("内存特点"));
					pstmt.setString(5, (String) detailObj.get("内存主频"));
					pstmt.setString(6, (String) detailObj.get("内存总容量"));
					pstmt.setString(7, (String) detailObj.get("内存容量描述"));
					pstmt.setString(8, (String) detailObj.get("插脚数目"));
					pstmt.setString(9, (String) detailObj.get("延迟描述"));
					pstmt.setString(10, (String) detailObj.get("内存电压"));
					pstmt.setString(11, (String) detailObj.get("其他性能"));
					pstmt.setString(12, (String) detailObj.get("包装"));
					pstmt.setString(13, (String) detailObj.get("title"));
					pstmt.setString(14, (String) detailObj.get("price"));
					pstmt.setString(15, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 硬盘数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_yp(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_yp(xh,rl,zs,hcrl,ptcc,jkbz,iopsz,csbz,ddrl,qtxn,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("容量"));
					pstmt.setString(3, (String) detailObj.get("转速"));
					pstmt.setString(4, (String) detailObj.get("缓存容量"));
					pstmt.setString(5, (String) detailObj.get("盘体尺寸"));
					pstmt.setString(6, (String) detailObj.get("接口标准"));
					pstmt.setString(7, (String) detailObj.get("IOPS值(测试数据)"));
					pstmt.setString(8, (String) detailObj.get("传输标准"));
					pstmt.setString(9, (String) detailObj.get("单碟容量"));
					pstmt.setString(10, (String) detailObj.get("其它性能"));
					pstmt.setString(11, (String) detailObj.get("title"));
					pstmt.setString(12, (String) detailObj.get("price"));
					pstmt.setString(13, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 固态硬盘数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_gtyp(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_gtyp(xh,rl,hclx,hcrl,sclx,zkxp,kl,lxdqzdsd,lxxrzdsd,ypcc,jklx,pjwgzsj,sksjdq,sksjxr,iopsdq,iopsxr,nvme,trimgn,wgcc,zl,gzwd,bx,qtxn,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("容量"));
					pstmt.setString(3, (String) detailObj.get("缓存类型"));
					pstmt.setString(4, (String) detailObj.get("缓存容量"));
					pstmt.setString(5, (String) detailObj.get("闪存类型"));
					pstmt.setString(6, (String) detailObj.get("主控芯片"));
					pstmt.setString(7, (String) detailObj.get("颗粒"));
					pstmt.setString(8, (String) detailObj.get("连续读取最大速度"));
					pstmt.setString(9, (String) detailObj.get("连续写入最大速度"));
					pstmt.setString(10, (String) detailObj.get("硬盘尺寸"));
					pstmt.setString(11, (String) detailObj.get("接口类型"));
					pstmt.setString(12, (String) detailObj.get("平均无故障时间"));
					pstmt.setString(13, (String) detailObj.get("4K随机读取"));
					pstmt.setString(14, (String) detailObj.get("4K随机写入"));
					pstmt.setString(15, (String) detailObj.get("IOPS读取"));
					pstmt.setString(16, (String) detailObj.get("IOPS写入"));
					pstmt.setString(17, (String) detailObj.get("NVMe"));
					pstmt.setString(18, (String) detailObj.get("TRIM功能"));
					pstmt.setString(19, (String) detailObj.get("外观尺寸"));
					pstmt.setString(20, (String) detailObj.get("重量"));
					pstmt.setString(21, (String) detailObj.get("工作温度"));
					pstmt.setString(22, (String) detailObj.get("保修"));
					pstmt.setString(23, (String) detailObj.get("其它性能"));
					pstmt.setString(24, (String) detailObj.get("title"));
					pstmt.setString(25, (String) detailObj.get("price"));
					pstmt.setString(26, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 电源数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_dy(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_dy(xh,sylx,dybz,ydgl,zdgl,sycpufw,rzgf,zbdyjk,cpugdjk,gdjk,satajk,xkdyjk,pfclx,zhxl,plusrz,fsms,cc,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("适用类型"));
					pstmt.setString(3, (String) detailObj.get("电源标准"));
					pstmt.setString(4, (String) detailObj.get("额定功率"));
					pstmt.setString(5, (String) detailObj.get("最大功率"));
					pstmt.setString(6, (String) detailObj.get("适用CPU范围"));
					pstmt.setString(7, (String) detailObj.get("认证规范"));
					pstmt.setString(8, (String) detailObj.get("主板电源接口"));
					pstmt.setString(9, (String) detailObj.get("CPU供电接口"));
					pstmt.setString(10, (String) detailObj.get("供电接口(大4pin)"));
					pstmt.setString(11, (String) detailObj.get("SATA接口"));
					pstmt.setString(12, (String) detailObj.get("8Pin显卡电源接口"));
					pstmt.setString(13, (String) detailObj.get("PFC类型"));
					pstmt.setString(14, (String) detailObj.get("转换效率"));
					pstmt.setString(15, (String) detailObj.get("80PLUS认证"));
					pstmt.setString(16, (String) detailObj.get("风扇描述"));
					pstmt.setString(17, (String) detailObj.get("尺寸"));
					pstmt.setString(18, (String) detailObj.get("title"));
					pstmt.setString(19, (String) detailObj.get("price"));
					pstmt.setString(20, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 机箱数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_jx(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_jx(xh,sylx,jxstyle,jxlx,jrzb,jxcw,kzcc,jxcz,bchd,jxys,bpdy,qzjkms,jxfs,nbsrms,zcsl,xkxc,srqxg,dywz,jxcc,zl,fj,qtxn,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("适用类型"));
					pstmt.setString(3, (String) detailObj.get("机箱样式"));
					pstmt.setString(4, (String) detailObj.get("机箱类型"));
					pstmt.setString(5, (String) detailObj.get("兼容主板"));
					pstmt.setString(6, (String) detailObj.get("机箱仓位"));
					pstmt.setString(7, (String) detailObj.get("扩展插槽"));
					pstmt.setString(8, (String) detailObj.get("机箱材质"));
					pstmt.setString(9, (String) detailObj.get("板材厚度"));
					pstmt.setString(10, (String) detailObj.get("机箱颜色"));
					pstmt.setString(11, (String) detailObj.get("标配电源"));
					pstmt.setString(12, (String) detailObj.get("前置接口描述"));
					pstmt.setString(13, (String) detailObj.get("机箱风扇"));
					pstmt.setString(14, (String) detailObj.get("内部散热描述"));
					pstmt.setString(15, (String) detailObj.get("支持水冷"));
					pstmt.setString(16, (String) detailObj.get("显卡限长"));
					pstmt.setString(17, (String) detailObj.get("散热器限高"));
					pstmt.setString(18, (String) detailObj.get("电源位置"));
					pstmt.setString(19, (String) detailObj.get("机箱尺寸"));
					pstmt.setString(20, (String) detailObj.get("重量"));
					pstmt.setString(21, (String) detailObj.get("附件"));
					pstmt.setString(22, (String) detailObj.get("其它性能"));
					pstmt.setString(23, (String) detailObj.get("title"));
					pstmt.setString(24, (String) detailObj.get("price"));
					pstmt.setString(25, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}

	/**
	 * 散热数据入库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public boolean insert_sr(JSONObject jsonObject) {
		boolean boo = false;
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
					String sql = "INSERT INTO pc_sr(xh,sypj,srqzl,sypjfw,fscc,fszc,fszs,fl,zy,srqzcc,zl,srpcz,qtxn,title,price,pic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, (String) detailObj.get("型号"));
					pstmt.setString(2, (String) detailObj.get("适用配件"));
					pstmt.setString(3, (String) detailObj.get("散热器种类"));
					pstmt.setString(4, (String) detailObj.get("适用配件范围"));
					pstmt.setString(5, (String) detailObj.get("风扇尺寸"));
					pstmt.setString(6, (String) detailObj.get("风扇轴承"));
					pstmt.setString(7, (String) detailObj.get("风扇转速"));
					pstmt.setString(8, (String) detailObj.get("风量"));
					pstmt.setString(9, (String) detailObj.get("噪音"));
					pstmt.setString(10, (String) detailObj.get("散热器总尺寸"));
					pstmt.setString(11, (String) detailObj.get("重量"));
					pstmt.setString(12, (String) detailObj.get("散热片材质"));
					pstmt.setString(13, (String) detailObj.get("其它性能"));
					pstmt.setString(14, (String) detailObj.get("title"));
					pstmt.setString(15, (String) detailObj.get("price"));
					pstmt.setString(16, (String) detailObj.get("pic"));
					boo = pstmt.execute();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(pstmt, conn);
		}

		return boo;
	}
}
