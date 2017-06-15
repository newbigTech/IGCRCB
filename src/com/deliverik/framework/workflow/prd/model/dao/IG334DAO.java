/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;

/**
  * 概述: 通知策略基本信息DAO接口
  * 功能描述: 通知策略基本信息DAO接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG334DAO extends BaseHibernateDAO<IG334Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG334Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG334Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG334SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG334Info> findByCond(
			final IG334SearchCond cond, final int start,
			final int count);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond);
}