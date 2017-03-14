/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ��Ʒ�������ϸ��ϢDAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class GinoutStockDetailVWDAOImpl extends BaseHibernateDAOImpl<GinoutStockDetailVW> implements GinoutStockDetailVWDAO {

	/**
	 * ���캯��
	 */
	public GinoutStockDetailVWDAOImpl(){
		super(GinoutStockDetailVW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GinoutstockdetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GinoutStockDetailVW> findByCond(final GinoutstockdetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("giodcategory"));
		c.addOrder(Order.asc("giodcode"));
		List<GinoutStockDetailVW> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(GinoutstockdetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�������ϸID
		if(cond.getGiodid()!=null && cond.getGiodid()!=0){
			c.add(Expression.eq("giodid", cond.getGiodid()));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGiodcategory())){
			c.add(Expression.like("giodcategory", cond.getGiodcategory()+"%"));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGiodcode())){
			c.add(Expression.eq("giodcode", cond.getGiodcode()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGiotime_f())){
			c.add(Expression.ge("giodtime", cond.getGiotime_f()));
		}
		if(StringUtils.isNotEmpty(cond.getGiotime_t())){
			c.add(Expression.le("giodtime", cond.getGiotime_t()));
		}
		
		//�������
		if(StringUtils.isNotEmpty(cond.getGiodtype())){
			c.add(Expression.eq("giodtype", cond.getGiodtype()));
		}
		
		//���״̬
		if(StringUtils.isNotEmpty(cond.getGiodstatus())){
			c.add(Expression.eq("giodstatus", cond.getGiodstatus()));
		}
		
		//��������
		if(StringUtils.isNotEmpty(cond.getGiodorg())){
			c.add(Expression.eq("giodorg", cond.getGiodorg()));
		}
		
		//�ɹ����뵥���
		if(StringUtils.isNotEmpty(cond.getGiodreqnum())){
			c.add(Expression.eq("giodreqnum", cond.getGiodreqnum()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGiodoutype())){
			List<String> condList = new ArrayList<String>();
			condList.add(IGLOMCONSTANTS.GIODTYPE_RK);
			condList.add(IGLOMCONSTANTS.GIODTYPE_LY);
			condList.add(IGLOMCONSTANTS.GIODTYPE_TJ);
			condList.add(IGLOMCONSTANTS.GIODTYPE_HX);
			c.add(Expression.in("giodtype", condList));
		}
		
		return c;
	}

}