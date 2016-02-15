/**
 * 
 */
package com.wangku.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author 谢虹英
 * 2015-6-1上午11:46:42
 * 类描述：抓取用户IP
 */

public class IPService {
	/**
	 * 
	 * @author： 谢虹英  2015-6-1 下午1:35:58
	 * @方法名： getIpAddr
	 * @方法描述：获取用户IP地址
	 * @param:用户IP地址
	 * @返回值：String  IP地址
	 *
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = this.getRequest().getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 
	 * @author： 谢虹英  2015-6-1 下午1:35:58
	 * @方法名： getIPName
	 * @方法描述：获取用户IP的名称
	 * @param:用户IP地址
	 * @返回值：String  IP名称
	 *
	 */
	public static String getIPName( String Ip) {
		String urls = "http://www.ip138.com/ips138.asp?ip="+Ip+"&action=2";
		String serviceName=null;
		long starttime = System.currentTimeMillis();
		try {
			Document doc = Jsoup.connect(urls).get();

			Elements elements = doc.select(".ul1 li");
			if(!(elements==null)&&!(elements.isEmpty())){
				String html2 = elements.get(0).html();
				//String str = html2.substring(6, html2.length());
				 serviceName = html2.substring(6);
				int j=serviceName.indexOf(" ");
				if(j>-1){
					System.out.println(j);
					serviceName=serviceName.substring(0, j);
					System.out.println(serviceName);
				}
				if("本地局域网".equals(serviceName)){
					serviceName="局域网";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e);
		}
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
		return serviceName;
	}
	
	@Test
	public void zhua() {
		String urls = "http://www.ip138.com/ips138.asp?ip=220.231.23.109&action=2";

		long starttime = System.currentTimeMillis();
		try {
			Document doc = Jsoup.connect(urls).get();

			Elements elements = doc.select(".ul1 li");
			/*String[] html = new String[elements.size()];
			for (int i = 0; i < elements.size(); i++) {
				html[i] = elements.get(i).html();
				
				System.out.println(html[i]);
			}*/
			if(elements!=null){
				String html2 = elements.get(0).html();
				//String str = html2.substring(6, html2.length());
				String str = html2.substring(6);
				int j=str.indexOf(" ");
				System.out.println(j);
				str=str.substring(0, j);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e);
		}
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);

	}


}
