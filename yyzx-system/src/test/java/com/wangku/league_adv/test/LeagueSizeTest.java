package com.wangku.league_adv.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangku.entity.AdvLeagueSize;
import com.wangku.entity.AdvTypeAndSize;
import com.wangku.service.LeagueSizeService;

//import com.wangku.service.LeagueSizeService;

public class LeagueSizeTest {
	private ApplicationContext ct;
	private LeagueSizeService leagueSizeService;
	@Before
	public void bef(){
		 ct = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		 leagueSizeService=(LeagueSizeService)ct.getBean("leagueSizeService");
	}
	@Test
	public void queryInitTypeSize() throws Exception{
		List<Long> ids=new ArrayList<Long>();
		ids.add(29l);
		List<AdvTypeAndSize> ts= leagueSizeService.queryAdvTypeAndSizeByIndustryIds(ids);
		
		System.out.println("List集合："+ts.toString());
		System.out.println();
		for(AdvTypeAndSize s:ts){
			System.out.print("广告类型====："+s.getAdvType());
			for(AdvLeagueSize s2:s.getLeagueSizeList()){
				//System.out.print(s2.getSizeCode());
				System.out.print("类型下的集合："+s2);
				System.out.println();
			}
		
		}
	}
	
//	
//	//@Test
//	public void queryTypeSizeByOneIndustryId() throws Exception{
//		
//		List<AdvTypeAndSize> ts= leagueSizeService.queryTypeSizeByOneIndustryId(Long.parseLong("1"));
//		
//		System.out.println(ts.toString());
//		for(AdvTypeAndSize s:ts){
//			System.out.print(s.getAdvType());
//			for(AdvLeagueSize s2:s.getLeagueSizeList()){
//				System.out.print(s2.getSizeCode());
//				System.out.print("     ");
//			}
//			System.out.println();
//		}
//	}
//	
//	
//	@Test
//	public void queryTypeSizeByIndustryIds() throws Exception{
//		List<Long> list = new ArrayList<Long>();
//		list.add(Long.parseLong("1"));
//		list.add(Long.parseLong("2"));
//		
//		List<AdvTypeAndSize> ts= leagueSizeService.queryTypeSizeByIndustryIds(list);
//		
//		System.out.println(ts.toString());
//		for(AdvTypeAndSize s:ts){
//			System.out.print(s.getAdvType());
//			for(AdvLeagueSize s2:s.getLeagueSizeList()){
//				System.out.print(s2.getSizeCode());
//				System.out.print("     ");
//			}
//			System.out.println();
//		}
//	}
	
}
