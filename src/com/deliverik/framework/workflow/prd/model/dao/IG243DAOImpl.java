/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;

/**
  * 概述: 流程标题定义表DAO实现
  * 功能描述: 流程标题定义表DAO实现
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG243DAOImpl extends
		BaseHibernateDAOImpl<IG243Info> implements IG243DAO {

	/**
	 * 构造函数
	 */
	public IG243DAOImpl(){
		super(IG243TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG243Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG243Info findByPK(Serializable pk) {
		IG243Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG243SearchCond cond){
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
	public List<IG243Info> findByCond(final IG243SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG243SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPtdid_like())){
			c.add(Expression.like("ptdid", cond.getPtdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PTDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPtdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(ptd.ptdid) FROM IG243TB ptd WHERE ptd.ptdid LIKE :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

}