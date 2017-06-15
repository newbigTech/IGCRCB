/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 导入程序管理表DAO实现
  * 功能描述: 导入程序管理表DAO实现
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
public class EiImportProgrammeDAOImpl extends
		BaseHibernateDAOImpl<EiImportProgrammeInfo> implements EiImportProgrammeDAO {

	/**
	 * 构造函数
	 */
	public EiImportProgrammeDAOImpl(){
		super(EiImportProgrammeTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiImportProgrammeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiImportProgrammeInfo findByPK(Serializable pk) {
		EiImportProgrammeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiImportProgrammeSearchCond cond){
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
	public List<EiImportProgrammeInfo> findByCond(final EiImportProgrammeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EiImportProgrammeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}