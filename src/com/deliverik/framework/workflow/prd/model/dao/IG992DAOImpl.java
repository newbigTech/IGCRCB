/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;

/**
  * 概述: 流程外部调用定义表DAO实现
  * 功能描述: 流程外部调用定义表DAO实现
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public class IG992DAOImpl extends
		BaseHibernateDAOImpl<IG992Info> implements IG992DAO {

	/**
	 * 构造函数
	 */
	public IG992DAOImpl(){
		super(IG992TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG992Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG992Info findByPK(Serializable pk) {
		IG992Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG992SearchCond cond){
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
	public List<IG992Info> findByCond(final IG992SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG992SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * PEEID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEEID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPedidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(p.pseid) FROM IG156TB p WHERE p.pseid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

}