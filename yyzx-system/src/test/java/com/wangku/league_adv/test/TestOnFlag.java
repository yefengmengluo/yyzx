package com.wangku.league_adv.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangku.service.LeagueAdvInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class TestOnFlag {
	
	@Autowired
	private LeagueAdvInfoService leagueAdvInfoService;
	
	@Test
	public void testOnFlagModify() throws Exception{
		leagueAdvInfoService.modifyOnFlag();
	}

}
