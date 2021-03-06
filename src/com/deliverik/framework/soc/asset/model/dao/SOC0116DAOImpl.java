/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * 概述: EiWaitTaskTempDAO实现
  * 功能描述: EiWaitTaskTempDAO实现
  * 创建记录: 2012/07/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0116DAOImpl extends
		BaseHibernateDAOImpl<SOC0116Info> implements SOC0116DAO {

	/**
	 * 构造函数
	 */
	public SOC0116DAOImpl(){
		super(SOC0116TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0116Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0116Info findByPK(Serializable pk) {
		SOC0116Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0116SearchCond cond){
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
	public List<SOC0116Info> findByCond(final SOC0116SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0116SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}