package com.wangku.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 读取配置文件信息，该配置文件在jar外部
 * @author Administrator
 *
 */
public class ConfigProperties {
	
	private static Properties properties;
	
	static {
		properties = new Properties();
		URL url = Thread.currentThread().getContextClassLoader().getResource("fastdfs.properties");
		try {
			properties.load(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//URL url = Thread.currentThread().getContextClassLoader().getResource("rabbitmq.properties");
		
		//Properties properties = new Properties();
		//properties.load(url.openStream());
		System.out.println(properties.getProperty("webconsole.jmx.url"));
		//System.out.println(properties.getProperty("PURCHASE_URL"));
		System.out.println(System.getProperty("user.dir"));
	}
	
	public static String getProperties(String key){
		return properties.getProperty(key);
	}

}
