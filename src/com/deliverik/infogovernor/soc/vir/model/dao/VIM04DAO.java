/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;

/**
  * 概述: 日志表DAO接口
  * 功能描述: 日志表DAO接口
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
public interface VIM04DAO extends BaseHibernateDAO<VIM04Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM04Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM04Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VIM04SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM04Info> findByCond(
			final VIM04SearchCond cond, final int start,
			final int count);

}