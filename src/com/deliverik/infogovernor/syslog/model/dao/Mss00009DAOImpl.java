/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;

/**
 * 概述: mss00009DAO实现 功能描述: mss00009DAO实现 创建记录: 2013/03/28 修改记录:
 */
@SuppressWarnings("deprecation")
public class Mss00009DAOImpl extends BaseHibernateDAOImpl<Mss00009Info>
		implements Mss00009DAO {

	/**
	 * 构造函数
	 */
	public Mss00009DAOImpl() {
		super(Mss00009TB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Mss00009Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pk
	 *            主键
	 * @return 检索结果
	 */
	public Mss00009Info findByPK(Serializable pk) {
		Mss00009Info result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 * @throws Exception
	 */
	public int getSearchCount(final Mss00009SearchCond cond) throws Exception {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 * @throws Exception
	 */
	public List<Mss00009Info> findByCond(final Mss00009SearchCond cond,
			final int start, final int count) throws Exception {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));// 按照时间由近到远排序
		c.addOrder(Order.desc("rulelevel"));// 按照级别由高到低排序
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 获取当前最大ID
	 * @return
	 */
	public int getMaxID(){
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				
				query.append(" select COALESCE(max(ID),0) from mss00009 ");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00009SearchCond cond)
			throws Exception {
		DetachedCriteria c = getDetachedCriteria();

		// 当告警IP不为空时
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		// 当开始的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_from())) {
			// 转换触发时间
			c.add(Expression.ge("starttime", cond.getStarttime_from()));
		}
		// 当结束的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// 转换触发时间
			c.add(Expression.le("starttime", cond.getStarttime_to()));
		}

		if (StringUtils.isNotEmpty(cond.getEndtime_from())) {
			// 转换触发时间
			c.add(Expression.ge("endtime", cond.getEndtime_from()));
		}
		// 当结束的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// 转换触发时间
			c.add(Expression.le("endtime", cond.getStarttime_to()));
		}

		// 当告警内容关键字不为空时
		if (StringUtils.isNotEmpty(cond.getWord_like())) {
			c.add(Expression.like("alarmmsg", "%" + cond.getWord_like() + "%"));
		}
		// 当设备类型syscoding不为空时
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		if (cond.getPriority() != null && cond.getPriority().length != 0) {
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		if (StringUtils.isNotEmpty(cond.getState())) {
			c.add(Expression.eq("state",Integer.parseInt(cond.getState())));
		}
		if(cond.getId()!=null&&cond.getId().length!=0)
		{
			c.add(Expression.in("id", cond.getId()));
		}
		return c;
	}

}