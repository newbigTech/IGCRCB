/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
  * 概述: 虚拟资源项目信息DAO实现
  * 功能描述: 虚拟资源项目信息DAO实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class VCD02DAOImpl extends
		BaseHibernateDAOImpl<VCD02Info> implements VCD02DAO {

	/**
	 * 构造函数
	 */
	public VCD02DAOImpl(){
		super(VCD02TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD02Info findByPK(Serializable pk) {
		VCD02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VCD02SearchCond cond){
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
	public List<VCD02Info> findByCond(final VCD02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(VCD02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}