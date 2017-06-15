/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.entity.CITaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 更新任务表DAO实现
  * 功能描述: 审计任务表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CITaskDAOImpl extends
		BaseHibernateDAOImpl<CITaskInfo> implements CITaskDAO {

	/**
	 * 构造函数
	 */
	public CITaskDAOImpl(){
		super(CITaskTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CITaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CITaskInfo findByPK(Serializable pk) {
		CITaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CITaskSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CITaskInfo> findByCond(final CITaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("cittime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CITaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//审计任务描述
		if (StringUtils.isNotEmpty(cond.getCitdesc_like())) {
			c.add(Expression.like("citdesc", "%" + cond.getCitdesc_like() + "%"));
		}
		//状态
		if (StringUtils.isNotEmpty(cond.getCitstatus_eq())) {
			c.add(Expression.eq("citstatus", cond.getCitstatus_eq()));
		}
		return c;
	}

}