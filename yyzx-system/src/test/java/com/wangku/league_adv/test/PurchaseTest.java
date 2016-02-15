package com.wangku.league_adv.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.wangku.util.NoteUtil;

public class PurchaseTest {

@Test
	public void sendNote() throws Exception{
		String mobile="18259177340";
			String message="系统通知:您的订单已经处理完毕.预计3天左右送达请保持电话畅通谢谢！【微网通联】";
		String result=NoteUtil.SMSCenter(message, mobile);
		System.out.println("==result: "+result);
		if(result.contains("<State>")){
			System.out.println("result.indexOf('<State>')"+result.indexOf("<State>"));
			System.out.println("result.indexOf('</State>')"+result.indexOf("</State>"));
			String substring = result.substring(result.indexOf("<State>"), result.indexOf("</State>"));
			System.out.println("substring:"+substring);
		}
		System.out.println("发送短信结果："+result);
	}
}
