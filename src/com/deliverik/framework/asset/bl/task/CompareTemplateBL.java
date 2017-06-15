/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.asset.model.condition.CompareTemplateSearchCond;
import com.deliverik.framework.asset.model.entity.CompareTemplateTB;

/**
  * 概述: compareTemplate业务逻辑接口
  * 功能描述: compareTemplate业务逻辑接口
  * 创建记录: 2011/05/23
  * 修改记录: 
  */
public interface CompareTemplateBL extends BaseBL {

	/**
	 * compareTemplate实例取得
	 *
	 * @return compareTemplate实例
	 */
	public CompareTemplateTB getCompareTemplateTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareTemplateInfo> searchCompareTemplate();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareTemplateInfo searchCompareTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareTemplateSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareTemplateInfo> searchCompareTemplate(
			CompareTemplateSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareTemplateInfo> searchCompareTemplate(
			CompareTemplateSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareTemplateInfo registCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareTemplateInfo updateCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

}