package com.wangku.league_adv.test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeagueSize;
import com.wangku.service.LeaguePramService;
import com.wangku.service.LeagueSizeService;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 导出广告数据 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class ExportAdvDataTest {

	@Autowired
	private LeagueSizeService leagueSizeService;

	@Autowired
	private LeaguePramService leaguePramService;

	@Test
	public void testOnFlagModify() throws Exception {

		String fileName = "广告信息.xls";// 文件名称
		// 导出的字段名
		String[] columnNames = {"广告类型", "广告行业","前台调用"};

		WritableWorkbook wwb;
		// 新建立一个jxl文件
		OutputStream os = new FileOutputStream(fileName);
		// 添加第一个工作表
		wwb = Workbook.createWorkbook(os);
		
		//设置第一个Sheet的名字
		WritableSheet sheetPic = wwb.createSheet("图片广告", 0);
		//设置第二个Sheet的名字
		WritableSheet sheetWord = wwb.createSheet("文字广告", 1);
		
		Label label;
		jxl.write.WritableFont titleFont = new jxl.write.WritableFont(WritableFont.createFont("宋体"), 24);
		WritableCellFormat titleStyle = new WritableCellFormat(titleFont);
		titleStyle.setAlignment(jxl.format.Alignment.CENTRE);
		titleStyle.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

		//设置图片广告信息标题字体
		sheetPic.mergeCells(0, 0, 2, 0);
		sheetPic.setColumnView(0, 12);
		sheetPic.setColumnView(1, 12);
		sheetPic.setColumnView(2, 1200);
		label = new Label(0, 0, "图片广告信息", titleStyle);
		sheetPic.addCell(label);

		//设置文字广告信息标题字体
		sheetWord.mergeCells(0, 0, 2, 0);
		sheetWord.setColumnView(0, 12);
		sheetWord.setColumnView(1, 12);
		sheetWord.setColumnView(2, 1300);
		label = new Label(0, 0, "文字广告信息", titleStyle);
		sheetWord.addCell(label);

		// 设置表头字体
		jxl.write.WritableFont headFont = new jxl.write.WritableFont(WritableFont.createFont("宋体"), 14);
		WritableCellFormat headStyle = new WritableCellFormat(headFont);
		headStyle.setBackground(jxl.format.Colour.LIGHT_GREEN);
		headStyle.setBorder(Border.ALL, BorderLineStyle.THIN);

		for (int i = 0; i < columnNames.length; i++) {
			// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
			label = new Label(i, 1, columnNames[i], headStyle);
			// 将定义好的单元格添加到工作表中
			sheetPic.addCell(label);
		}
		for (int i = 0; i < columnNames.length; i++) {
			// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
			label = new Label(i, 1, columnNames[i], headStyle);
			// 将定义好的单元格添加到工作表中
			sheetWord.addCell(label);
		}

		// 表格数据项字体设置
		jxl.write.WritableFont bodyFont = new jxl.write.WritableFont(WritableFont.createFont("宋体"), 12);
		WritableCellFormat bodyStyle = new WritableCellFormat(bodyFont);
		bodyStyle.setBackground(jxl.format.Colour.IVORY);
		bodyStyle.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		
		// 查询并填充图片信息表的数据
		List<LeagueSize> sizes = leagueSizeService.queryAll();
		if (!CollectionUtils.isEmpty(sizes)) {
			for (int i = 1; i < sizes.size() + 1; i++) {
				LeagueSize size = sizes.get(i - 1);
				int j = -1;// 列计数器
				sheetPic.addCell(new Label(++j, i + 1, size.getTypeName(), bodyStyle));
				sheetPic.addCell(new Label(++j, i + 1, size.getIndustryName(), bodyStyle));
				String url = "<script type=\"text/javascript\" src=\"http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=1000&advType=0&advCode="+size.getIndustryId()+"_"+ size.getSizeCode()+"&dataNum=1\"></script>";
				sheetPic.addCell(new Label(++j, i + 1, url, bodyStyle));
			}
		}

		// 查询并填充文字信息表的数据
		List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);
		if (!CollectionUtils.isEmpty(industrys)) {
			for (int i = 1; i < industrys.size() + 1; i++) {
				LeaguePram industry = industrys.get(i - 1);
				int j = -1;// 列计数器
				sheetWord.addCell(new Label(++j, i + 1, "文字广告", bodyStyle));
				sheetWord.addCell(new Label(++j, i + 1, industry.getParamName(), bodyStyle));
				String url = "<script type=\"text/javascript\" src=\"http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=pageWidth1000&advType=0&advCode="+industry.getId()+"_0_0"+"&dataNum=1\"></script>";
				sheetWord.addCell(new Label(++j, i + 1, url, bodyStyle));
			}
		}
		// 写入数据
		wwb.write();
		// 关闭文件
		wwb.close();
	}
}
