/**
 * 
 */
package com.wangku.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author 谢虹英
 * 2015-5-29下午3:01:34
 * 类描述：用于短信业务的调取
 */

public class NoteUtil {
	/**
	 * 
	 * @author： 谢虹英  2015-5-29 下午3:04:45
	 * @方法名： randomNum
	 * @方法描述：随机获取六位数
	 * @param:无
	 * @返回值：String
	 *
	 */
	public static String randomNum(){
		int random =(int)(( Math.random()*9+1)*100000);
		return random+"";
	}
	public static String SMSCenter(String message,String mobile) throws UnsupportedEncodingException{
		//String PostData = "sname=kwsm&spwd=kwsm&scorpid=&sprdid=1012818&sdst=15313445856&smsg="+URLEncoder.encode(message,"utf-8");
		String PostData = "sname=dlbjwkht&spwd=iWOLr9Q7&scorpid=&sprdid=1012818&sdst="+mobile+"&smsg="+URLEncoder.encode(message,"utf-8");
		//String PostData = "sname=dl-wangyahui&spwd=wangyahui12&scorpid=&sprdid=1012888&sdst="+mobile+"&smsg="+URLEncoder.encode(message,"utf-8");
		String postUrl="http://cf.51welink.com/submitdata/Service.asmx/g_Submit";
		System.out.println("message："+message+ "  mobile："+mobile);
        //out.println(PostData);
        String ret =SMS(PostData,postUrl);
		return ret;
	}
	public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
	/* public static String SMS(String postData) {
	        try {
	            //发送POST请求
	        	String postUrl= "http://cf.lmobile.cn/submitdata/Service.asmx/g_Submit";
	            URL url = new URL(postUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);

	            conn.setRequestProperty("Content-Length", "" + postData.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(postData);
	            out.flush();
	            out.close();

	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
	                return "";
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line + "\n";
	            }
	            in.close();
	            return result;
	        } catch (IOException e) {
	            e.printStackTrace(System.out);
	        }
	        return "";
	    }*/
	 public static String SMSGetRemain(String postData) {
	        try {
	        	String PostData = "sname=dl-liuqiang&spwd=dl-liuqiang1&scorpid=&sprdid=1012888&sdst=15313445856&smsg=";
	            //发送POST请求
	        	String postUrl= "http://cf.lmobile.cn/submitdata/Service.asmx/g_Submit";
	            URL url = new URL(postUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);

	            conn.setRequestProperty("Content-Length", "" + postData.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(postData);
	            out.flush();
	            out.close();

	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
	                return "";
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line + "\n";
	            }
	            in.close();
	            return result;
	        } catch (IOException e) {
	            e.printStackTrace(System.out);
	        }
	        return "";
	    }
}
