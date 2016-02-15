package com.wangku.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.SpecialLiuYan;
import com.wangku.entity.SpecialLiuYanExample;
import com.wangku.entity.User;
import com.wangku.mapper.SpecialLiuYanMapper;
import com.wangku.service.SpecialLiuYanService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * @author 周海朋
 *
 */
@Service
public class SpecialLiuYanServiceImpl implements SpecialLiuYanService{
	@Autowired 
	private VoteSequenceDao seqDao;
	@Autowired 
	private SpecialLiuYanMapper specialLiuYanMapper;
	
	
	/**
		 * 
		 * @author：周海朋 2015-7-7 下午5:44:56
		 * @方法名： addLiuYan
		 * @方法描述：添加留言
		 * @param:
		 * @返回值：String
		 *
		 */
	@Override
	public String addLiuYan(SpecialLiuYan specialliuyan) throws Exception {
		String lycode="0";
		if(specialliuyan!=null){
		Long seqVal = seqDao.getIdByTableName(VoteSeqEnum.LIU_YAN_SEQ.SPECIAL_LIUYAN.getValue());
		specialliuyan.setLyId(seqVal);
		specialLiuYanMapper.insert(specialliuyan);
		lycode="1";
		}
		return lycode;
	}
	
	
	
	/**
		 * 
		 * @author：周海朋 2015-7-7 下午5:45:00
		 * @方法名： queryAllLiuYanByPage
		 * @方法描述：分页查询所有订单
		 * @param:
		 * @返回值：Page<SpecialLiuYan>
		 *
		 */
	@Override
	public Page<SpecialLiuYan> queryAllLiuYanByPage(
			User user, Page<SpecialLiuYan> page)
			throws Exception {
		List<SpecialLiuYan> list=new ArrayList<SpecialLiuYan>();
		Integer uPower = user.getUserPower();
		if(user!=null){
			if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
					if(page==null){
						page = new Page<SpecialLiuYan>();
					}else{
						page.setPageSize(10);
					}//设置查sql语句中使用的page
						page.setSqlPage(page);
						//调用分页查所用管理员
						list = specialLiuYanMapper.selectAllLiuYanByPage(page.getOffsetValue(), page.getPageSize(),null);
						//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
					if(list.size()==0&&page.getCurrentNum()!=1){
						page.setCurrentNum(page.getCurrentNum()-1);
						page.setSqlPage(page);
						//调用分页查所用管理员
						list = specialLiuYanMapper.selectAllLiuYanByPage(page.getOffsetValue(), page.getPageSize(),null);
					}
						//将查找出的对象放入PageList中
						page.setPageList(list);
		 				//查未分页是的全部条数
						SpecialLiuYanExample ue = new SpecialLiuYanExample();
						ue.createCriteria();
						List<SpecialLiuYan> specialLiuYans = specialLiuYanMapper.selectByExample(ue);
						//设置最大页数
						page.setMaxPage(specialLiuYans.size(), page);
		
			}else if(uPower==VoteSeqEnum.UPOWER.LIUYAN_POWER.getValue()){
				if(page==null){
					page = new Page<SpecialLiuYan>();
				}else{
					page.setPageSize(10);
				}//设置查sql语句中使用的page
					page.setSqlPage(page);
					//调用分页查所用管理员
					list = specialLiuYanMapper.selectAllLiuYanByPage(page.getOffsetValue(), page.getPageSize(),user.getUserId());
					//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
				if(list.size()==0&&page.getCurrentNum()!=1){
					page.setCurrentNum(page.getCurrentNum()-1);
					page.setSqlPage(page);
					//调用分页查所用管理员
					list = specialLiuYanMapper.selectAllLiuYanByPage(page.getOffsetValue(), page.getPageSize(),user.getUserId());
				}
					//将查找出的对象放入PageList中
					page.setPageList(list);
	 				//查未分页是的全部条数
					SpecialLiuYanExample ue = new SpecialLiuYanExample();
					ue.createCriteria().andUserIdEqualTo(user.getUserId());
					List<SpecialLiuYan> specialLiuYans = specialLiuYanMapper.selectByExample(ue);
					//设置最大页数
					page.setMaxPage(specialLiuYans.size(), page);
			}
		}
		
		
		return page;
	}



	/**
		 * 
		 * @author：周海朋 2015-7-7 下午5:46:02
		 * @方法名： queryOneByLYId
		 * @方法描述：根据留言ID查留言
		 * @param:
		 * @返回值：SpecialLiuYan
		 *
		 */
	@Override
	public SpecialLiuYan queryOneByLYId(SpecialLiuYan specialliuyan)
			throws Exception {
		specialliuyan=specialLiuYanMapper.selectByPrimaryKey(specialliuyan.getLyId());
	
		return specialliuyan;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午10:02:49
	  * @方法名： modifyOneLiuYan
	  * @方法描述：提交修改信息
	  * @param:
	  * @返回值：String
	  *
	  **/
	@Override
	public String modifyOneLiuYan(SpecialLiuYan specialliuyan) throws Exception {
		String code="0";
		if(specialliuyan!=null){
			specialliuyan.setEndTime(new Date());
			specialLiuYanMapper.updateByPrimaryKeySelective(specialliuyan);	
			code="1";
		}
	
		return code;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午10:03:14
	  * @方法名： queryOneByLY
	  * @方法描述：根据条件查留言
	  * @param:
	  * @返回值：List<SpecialLiuYan>
	  *
	  **/
	@Override
	public List<SpecialLiuYan> queryOneByLY(SpecialLiuYan specialliuyan)
			throws Exception {
		SpecialLiuYanExample liuyan=new SpecialLiuYanExample();
		liuyan.createCriteria().andCopNameEqualTo(specialliuyan.getCopName()).andLinkmanEqualTo(specialliuyan.getLinkman()).andMobileEqualTo(specialliuyan.getMobile()).andUserIdEqualTo(specialliuyan.getUserId());
		
		List<SpecialLiuYan> ly=specialLiuYanMapper.selectByExample(liuyan);
		return ly;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午10:06:56
	  * @方法名： queryLiuYanLikeByCopName
	  * @方法描述：模糊查询
	  * @param:
	  * @返回值：Page<SpecialLiuYan>
	  *
	  **/
	@Override
	public Page<SpecialLiuYan> queryLiuYanLikeByCopName(String keyWord,
			User user, Page<SpecialLiuYan> page) throws Exception {
		Integer uPower = user.getUserPower();
		if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
			if(page==null){
				page = new Page<SpecialLiuYan>();
			}else{
				page.setPageSize(10);
			}
			page.setSqlPage(page);
			
			if ("请输入关键字".equals(keyWord)) {
				keyWord = "%%";
			} else {
				keyWord = "%" + keyWord.trim() + "%";
			}
			List<SpecialLiuYan> list = specialLiuYanMapper.selectLiuYanLikeByPage(keyWord,page.getOffsetValue(), page.getPageSize(),null);
			page.setPageList(list);
			List<SpecialLiuYan> allList = specialLiuYanMapper.selectLiuYanLike(keyWord,null);
			page.setMaxPage(allList.size(), page);
		}else if(uPower==VoteSeqEnum.UPOWER.LIUYAN_POWER.getValue()){
			if(page==null){
				page = new Page<SpecialLiuYan>();
			}else{
				page.setPageSize(10);
			}
			page.setSqlPage(page);
			
			if ("请输入关键字".equals(keyWord)) {
				keyWord = "%%";
			} else {
				keyWord = "%" + keyWord.trim() + "%";
			}
			List<SpecialLiuYan> list = specialLiuYanMapper.selectLiuYanLikeByPage(keyWord,page.getOffsetValue(), page.getPageSize(),user.getUserId());
			page.setPageList(list);
			List<SpecialLiuYan> allList = specialLiuYanMapper.selectLiuYanLike(keyWord,user.getUserId());
			page.setMaxPage(allList.size(), page);
		}
		return page;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午11:09:11
	  * @方法名： queryAllLiuYanByPageStatus
	  * @方法描述：根据状态分页查留言信息
	  * @param:
	  * @返回值：Page<SpecialLiuYan>
	  *
	  **/
	@Override
	public Page<SpecialLiuYan> queryAllLiuYanByPageStatus(User user,
			Page<SpecialLiuYan> page, Integer status) throws Exception {
		List<SpecialLiuYan> list=new ArrayList<SpecialLiuYan>();
		Integer uPower = user.getUserPower();
		if(user!=null){
			if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
					if(page==null){
						page = new Page<SpecialLiuYan>();
					}else{
						page.setPageSize(10);
					}//设置查sql语句中使用的page
						page.setSqlPage(page);
						//调用分页查所用管理员
						list = specialLiuYanMapper.selectAllLiuYanByPageStatus(page.getOffsetValue(), page.getPageSize(),status,null);
						//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
					if(list.size()==0&&page.getCurrentNum()!=1){
						page.setCurrentNum(page.getCurrentNum()-1);
						page.setSqlPage(page);
						//调用分页查所用管理员
						list = specialLiuYanMapper.selectAllLiuYanByPageStatus(page.getOffsetValue(), page.getPageSize(),status,null);
					}
						//将查找出的对象放入PageList中
						page.setPageList(list);
		 				//查未分页是的全部条数
						SpecialLiuYanExample ue = new SpecialLiuYanExample();
						ue.createCriteria().andStatusEqualTo(status);
						List<SpecialLiuYan> specialLiuYans = specialLiuYanMapper.selectByExample(ue);
						//设置最大页数
						page.setMaxPage(specialLiuYans.size(), page);
			}else if(uPower==VoteSeqEnum.UPOWER.LIUYAN_POWER.getValue()){
				if(page==null){
					page = new Page<SpecialLiuYan>();
				}else{
					page.setPageSize(10);
				}//设置查sql语句中使用的page
					page.setSqlPage(page);
					//调用分页查所用管理员
					list = specialLiuYanMapper.selectAllLiuYanByPageStatus(page.getOffsetValue(), page.getPageSize(),status,user.getUserId());
					//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
				if(list.size()==0&&page.getCurrentNum()!=1){
					page.setCurrentNum(page.getCurrentNum()-1);
					page.setSqlPage(page);
					//调用分页查所用管理员
					list = specialLiuYanMapper.selectAllLiuYanByPageStatus(page.getOffsetValue(), page.getPageSize(),status,user.getUserId());
				}
					//将查找出的对象放入PageList中
					page.setPageList(list);
	 				//查未分页是的全部条数
					SpecialLiuYanExample ue = new SpecialLiuYanExample();
					ue.createCriteria().andStatusEqualTo(status).andUserIdEqualTo(user.getUserId());
					List<SpecialLiuYan> specialLiuYans = specialLiuYanMapper.selectByExample(ue);
					//设置最大页数
					page.setMaxPage(specialLiuYans.size(), page);
				
			}
	}
		return page;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 下午1:48:50
	  * @方法名： removeOneLiuYan
	  * @方法描述：删除留言信息
	  * @param:
	  * @返回值：Page<SpecialLiuYan>
	  *
	  **/
	@Override
	public String removeOneLiuYan(String lyId) throws Exception {
		String code="0";
		if(lyId!=null){
			String[] split = lyId.split(",");
			List<Long>  lyIds= new ArrayList<Long>();
			for (int i = 0; i < split.length; i++) {
				lyIds.add(Long.parseLong(split[i]));
			}
			SpecialLiuYanExample ue = new SpecialLiuYanExample();
			ue.createCriteria().andLyIdIn(lyIds);
			specialLiuYanMapper.deleteByExample(ue);
			code="1";
		}
		return code;
	}



	/**
	  * 
	  * @author：  周海朋  2015-7-9 下午7:47:00
	  * @方法名： queryAllLY
	  * @方法描述：查询所有信息
	  * @param:
	  * @返回值：List<SpecialLiuYan>
	  *
	  **/
	@Override
	public List<SpecialLiuYan> queryAllLY(User user) throws Exception {
		List<SpecialLiuYan> ly=null;
		Integer uPower = user.getUserPower();
		if(user!=null){
			if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
		SpecialLiuYanExample ue = new SpecialLiuYanExample();
		ue.createCriteria();
		ue.setOrderByClause("creat_time desc");
		 ly=specialLiuYanMapper.selectByExample(ue);
		
			}else if(uPower==VoteSeqEnum.UPOWER.LIUYAN_POWER.getValue()){
				SpecialLiuYanExample ue = new SpecialLiuYanExample();
				ue.createCriteria().andUserIdEqualTo(user.getUserId());
				ue.setOrderByClause("creat_time desc");
				 ly=specialLiuYanMapper.selectByExample(ue);
				
			}
			
		}
		return ly;
	}
	
	
	
	/**
	  * 
	  * @author：  周海朋  2015-7-15 下午4:21:42
	  * @方法名： modifyLiuYanById
	  * @方法描述：批量更新状态
	  * @param:
	  * @返回值：String
	  *
	  **/
	@Override
	public String modifyLiuYanById(String lyId,Integer status) throws Exception {
		String code="0";
		if(lyId!=null){
			String[] split = lyId.split(",");
			List<Long>  lyIds= new ArrayList<Long>();
			for (int i = 0; i < split.length; i++) {
				lyIds.add(Long.parseLong(split[i]));
			}
			SpecialLiuYanExample ue = new SpecialLiuYanExample();
			ue.createCriteria().andLyIdIn(lyIds);
			SpecialLiuYan sly = new SpecialLiuYan();
			sly.setStatus(status);
			specialLiuYanMapper.updateByExampleSelective(sly, ue);
			code="1";
		}
		return code;
	}

}
