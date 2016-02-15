package com.wangku.service;

import java.util.List;

import com.wangku.entity.LeaguePram;
import com.wangku.jdbc.DataSource;

public interface LeaguePramService {
	
	
	/**
	 * @author:李焕焕 2015年7月27日 下午4:01:37
	 * @方法名:queryAll
	 * @方法描述:TODO(查询所有参数)
	 * @param:@return
	 * @返回值:List<LeaguePram>
	 */
	@DataSource("slave")
	public List<LeaguePram> queryAll()throws Exception;
	
	
	
	/**
	 * @author:李焕焕 2015年7月27日 下午1:45:25
	 * @方法名:queryLeaguePram
	 * @方法描述:TODO(查询所有行业)   根据参数类型查询参数数据(zsl)
	 * @param:@return
	 * @返回值:List<LeaguePram>
	 */
	@DataSource("slave")
	public List<LeaguePram> queryLeaguePram(int paramType)throws Exception;//查询所有行业
	
	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:01:43
	 * @方法名:queryById
	 * @方法描述:TODO(按id查询)
	 * @param:@param id
	 * @param:@return
	 * @返回值:LeaguePram
	 */
	@DataSource("slave")
	public LeaguePram queryById(long id)throws Exception;//用于修改行业时，获取对象
	
	
	
	/**
	 * @author:李焕焕 2015年7月28日 下午2:33:53
	 * @方法名:queryByParamName
	 * @方法描述:TODO(按行业名称查询)
	 * @param:@param paramName
	 * @param:@return
	 * @返回值:int
	 */
	@DataSource("slave")
	public int queryByParamName(Integer paramType,String paramName) throws Exception;//用于添加行业时，检测行业是否已存在
	
	/**
	 * 
	 * @author： zsl  2015年8月11日 上午11:59:27
	 * @方法名： queryByParamNameAnd
	 * @方法描述：用于修改参数时，检测参数是否已存在
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int queryByParamNameAndId(Integer paramType,String paramName,Long id) throws Exception;//用于修改参数时，检测参数是否已存在
	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:02:54
	 * @方法名:addLeaguePram
	 * @方法描述:TODO(添加行业)
	 * @param:@param leaguePram
	 * @返回值:void
	 */
	@DataSource("master")
	public void addLeaguePram(LeaguePram leaguePram) throws Exception;//添加行业
	
	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:03:07
	 * @方法名:modifyLeaguePram
	 * @方法描述:TODO(修改行业)
	 * @param:@param leaguePram
	 * @返回值:void
	 */
	@DataSource("master")
	public void modifyLeaguePram(LeaguePram leaguePram) throws Exception;//修改行业名称
	
	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:04:35
	 * @方法名:removeLeaguePram
	 * @方法描述:TODO(删除行业)
	 * @param:@param id
	 * @返回值:void
	 */
	@DataSource("master")
	public void removeLeaguePram(Long id) throws Exception;//删除行业
	/**
	 * 
	 * @author： zsl  2015年7月29日 下午4:59:39
	 * @方法名： queryLeaguePramByPramType
	 * @方法描述：根据参数类型查询数据
	 * @param:
	 * @返回值：List<LeaguePram>
	 *
	 */
	@DataSource("slave")
	public List<LeaguePram> queryLeaguePramByPramType(int pramType) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年9月7日 上午11:43:21
	 * @方法名： querySizeCountByParamId
	 * @方法描述：
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int querySizeCountByParamId(int paramType ,Long id) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年9月14日 下午5:14:00
	 * @方法名： queryWordCountByParamId
	 * @方法描述：根据行业ID查询此行业下是否有数据
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int queryWordCountByParamId(Long id) throws Exception;
	

	/**
	 * 
	 * @author： zsl  2015年9月7日 下午3:25:28
	 * @方法名： delLeaguePram
	 * @方法描述：删除参数
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void delLeaguePram(Long id) throws Exception;
}
