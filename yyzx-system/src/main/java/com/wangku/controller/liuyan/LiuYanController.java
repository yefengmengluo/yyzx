package com.wangku.controller.liuyan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.SpecialLiuYan;
import com.wangku.entity.User;
import com.wangku.service.SpecialLiuYanService;
import com.wangku.service.UserService;
import com.wangku.util.ExcelUtil;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;





/**
 * @author 周海朋
 * 2015-7-8 下午7:18:02
 * 类描述：留言
 */
@Controller
@RequestMapping("liuYanController")
public class LiuYanController {
@Autowired  SpecialLiuYanService specialLiuYanService;
@Autowired  UserService userService;
	/**
			 * 
			 * @author：  周海朋  2015-7-8 下午7:18:02
			 * @方法名： queryAllLiuYanByPage
			 * @方法描述：分页查询留言
			 * @param:
			 * @返回值：String
			 *
			 */
	@RequestMapping("/sp_ly/queryAllLiuYanByPage")
	public String queryAllLiuYanByPage(ModelMap map,HttpServletRequest request,Page<SpecialLiuYan> page){
		
		
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				if(user.getUserPower()!=VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){
						page=specialLiuYanService.queryAllLiuYanByPage(user,page);
						map.put("page", page);
						return "backstage/backPage/liuyan/liuyan_list";
				}else{
					return "backstage/backPage/errors/prower_error";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/errors/prower_error";
		
	}
	
	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午11:09:38
	  * @方法名： queryAllLiuYanByPageStatus
	  * @方法描述：根据状态分页查留言信息
	  * @param:
	  * @返回值：Page<SpecialLiuYan>
	  *
	  **/
	@RequestMapping("/sp_ly/queryAllLiuYanByPageStatus")
	public String queryAllLiuYanByPageStatus(ModelMap map,HttpServletRequest request,Page<SpecialLiuYan> page,Integer status){
		
		
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				if(user.getUserPower()!=VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){
						page=specialLiuYanService.queryAllLiuYanByPageStatus(user, page, status);
						map.put("page", page);
						map.put("status1", status);
						
						return "backstage/backPage/liuyan/liuyan_list";
				}else{
					return "backstage/backPage/errors/prower_error";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/errors/prower_error";
		
	}
	
	
	
	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午10:41:33
	  * @方法名： queryLiuYanLikeByKey
	  * @方法描述：模糊查询带分页
	  * @param:
	  * @返回值：String
	  *
	  **/
	@RequestMapping("/sp_ly/queryLiuYanLikeByKey")
	public String queryLiuYanLikeByKey(ModelMap map,HttpServletRequest request,Page<SpecialLiuYan> page,String keyWord){
		
		
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				if(user.getUserPower()!=VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){
						page=specialLiuYanService.queryLiuYanLikeByCopName(keyWord, user, page);
						map.put("page", page);
						map.put("keyWord", keyWord);
						return "backstage/backPage/liuyan/liuyan_like_list";
				}else{
					return "backstage/backPage/errors/prower_error";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/errors/prower_error";
		
	}
	
	
	/**
			 * 
			 * @author：  周海朋  2015-7-8 下午7:17:30
			 * @方法名： addLiuYan
			 * @方法描述：添加留言信息
			 * @param:
			 * @返回值：String
			 *
			 */
	@ResponseBody
	@RequestMapping("/addLiuYan")
	public String addLiuYan(HttpServletRequest request ,@RequestParam Long specId,@RequestParam String copName,
			@RequestParam String  linkman,@RequestParam String  mobile,@RequestParam String comment,
			@RequestParam Long userId
			){
		try {
			SpecialLiuYan specialliuyan =new SpecialLiuYan();
			specialliuyan.setSpecId(specId);
			specialliuyan.setUserId(userId);
			specialliuyan.setCopName(copName);
			specialliuyan.setLinkman(linkman);
			specialliuyan.setMobile(mobile);
			specialliuyan.setComment(comment);
			List<SpecialLiuYan> ly=specialLiuYanService.queryOneByLY(specialliuyan);
			
			if(ly.size()==0){//判断是否已留言
				specialliuyan.setCreatTime(new Date());
				specialliuyan.setStatus(0);
				specialLiuYanService.addLiuYan(specialliuyan);
				return "1";
			}else{
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	
	}
	
	
	/**
			 * 
			 * @author：  周海朋  2015-7-8 下午7:16:41
			 * @方法名： queryOneByLYId
			 * @方法描述：根据留言ID查留言信息
			 * @param:
			 * @返回值：String
			 *
			 */
	@RequestMapping("/sp_ly/queryOneByLYId")
	
	public String queryOneByLYId(ModelMap map,SpecialLiuYan specialliuyan,Page<SpecialLiuYan> page,HttpServletRequest request,Integer status){
		try {
			
			specialliuyan=specialLiuYanService.queryOneByLYId(specialliuyan);
			
			map.put("specialliuyan", specialliuyan);
			map.put("page", page);
			map.put("status1", status);
			
			return "backstage/backPage/liuyan/liuyan_edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	
	}
	
	/**
			 * 
			 * @author：  周海朋  2015-7-8 下午7:16:04
			 * @方法名： modifyUser
			 * @方法描述：更新留言
			 * @param:
			 * @返回值：String
			 *
			 */
	@RequestMapping("/sp_ly/modifyLiuYan")
	public String modifyLiuYan(SpecialLiuYan specialliuyan,HttpServletRequest request,Page<SpecialLiuYan> page,Integer status1){
		
		 
		try {
			User user = (User)request.getSession().getAttribute("user");
			specialliuyan.setUserId(user.getUserId());
			String i=specialLiuYanService.modifyOneLiuYan(specialliuyan);
			System.out.println(i);
			if(status1==null){
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPage?currentNum="+page.getCurrentNum();
				
			}else{
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status="+status1+"&currentNum="+page.getCurrentNum();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		
	}
	
	
	/**
	  * 
	  * @author：  周海朋  2015-7-15 下午2:07:59
	  * @方法名：removeLiuYan
	  * @方法描述：批量删除留言
	  * @param:
	  * @返回值：String
	  *
	  **/
	@RequestMapping("/sp_ly/removeLiuYan")
	public String removeLiuYan(String lyIds,Page<SpecialLiuYan> page,Integer lystatus){
		try {
			
			specialLiuYanService.removeOneLiuYan(lyIds);
			if(lystatus==null){
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPage?currentNum="+page.getCurrentNum();
				
			}else{
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status="+lystatus+"&currentNum="+page.getCurrentNum();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		
	}
	
	
	/**
	  * 
	  * @author：  周海朋  2015-7-15 下午2:28:52
	  * @方法名： modifyLiuYanById
	  * @方法描述：批量更新留言信息
	  * @param:
	  * @返回值：String
	  *
	  **/
	@RequestMapping("/sp_ly/modifyLiuYanById")
	public String modifyLiuYanById(String lyIds,Page<SpecialLiuYan> page,Integer lystatus,Integer status1){
		try {
			
			specialLiuYanService.modifyLiuYanById(lyIds, lystatus);
			
			if(status1==null){
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPage?currentNum="+page.getCurrentNum();
				
			}else{
				return "redirect:/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status="+status1+"&currentNum="+page.getCurrentNum();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		
	}
	
	
	
	
	 /**
	  * 
	  * @author：  周海朋  2015-7-9 下午7:44:12
	  * @方法名： download
	  * @方法描述：导出数据到EXCEL表格
	  * @param:
	  * @返回值：String
	  *
	  **/
	@RequestMapping("/sp_ly/download_project")
	    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
			String fileName="excel文件";
	        //填充projects数据
	        List<SpecialLiuYan> projects=null;
	        
	        User user = (User)request.getSession().getAttribute("user");
			try {
				projects = specialLiuYanService.queryAllLY(user);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			
			}
	        
	        List<Map<String,Object>> list=createExcelRecord(projects);
	        String columnNames[]={"专题id","公司名称","联系人","手机","备注","状态","添加时间","操作人员"};//列名
	        String keys[] ={"specId","copName","linkman","mobile","comment","status","creatTime","userId"};//map中的key
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        try {
	            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        // 设置response参数，可以打开下载页面
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	            bis = new BufferedInputStream(is);
	            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	
		//获取所有留言信息
	/*    private List<SpecialLiuYan> createData(HttpServletRequest request) {
	    	
	       
	    }*/
	    private List<Map<String, Object>> createExcelRecord(List<SpecialLiuYan> projects) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        SpecialLiuYan project=null;
	        User user=new User();
	        for (int j = 0; j < projects.size(); j++) {
	            project=projects.get(j);
	            user.setUserId(project.getUserId());
	            String statusName=null;
	            if(project.getStatus()==0){
	            	statusName="未审核";
	            }else if(project.getStatus()==1){
	            	statusName="已审核";
	            }else{
	            	statusName="已禁用";
	            }
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("specId", project.getSpecId());
	            mapValue.put("copName", project.getCopName());
	            mapValue.put("linkman", project.getLinkman());
	            mapValue.put("mobile", project.getMobile());
	            mapValue.put("comment", project.getComment());
	            mapValue.put("status", statusName);
	            mapValue.put("creatTime", sdf.format(project.getCreatTime()));
	            try {
	            	if(project.getUserId()!=null){
					mapValue.put("userId", userService.queryOneByUserId(user).getRealName());
	            	}else{
	            	mapValue.put("userId", "暂无");
	            	}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }

}
