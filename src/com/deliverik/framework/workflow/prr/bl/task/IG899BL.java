/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * 概述: 流程私有变量表业务逻辑接口
  * 功能描述: 流程私有变量表业务逻辑接口
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public interface IG899BL extends BaseBL {

	/**
	 * 流程私有变量表实例取得
	 *
	 * @return 流程私有变量表实例
	 */
	public IG899TB getIG899TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG899Info> searchIG899Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG899Info searchIG899InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG899SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param ig899Info 新增实例
	 * @return 新增实例
	 */
	public IG899Info registIG899Info(IG899Info ig899Info)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param ig899Info 修改实例
	 * @return 修改实例
	 */
	public IG899Info updateIG899Info(IG899Info ig899Info)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG899InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param ig899Info 删除实例
	 */
	public void deleteIG899Info(IG899Info ig899Info)
		throws BLException;
	
	/**
	 * 保存私有变量处理
	 * 
	 * @param ig899InfoList 表单变量集合
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException 
	 */
	public void registIG899Info(List<IG599Info> ig899InfoList, Integer roleid, String userid,String orgid)
		throws BLException;

}