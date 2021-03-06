/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 概述: 日常维护查询条件实现
 * 功能描述: 日常维护查询条件实现
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public class OnDutyPersonRecordSearchCondImpl implements OnDutyPersonRecordSearchCond{
	
    /** 按主键查询 */
    protected Integer odprid_eq;
    
	/** 查询关键字 */
	protected String keywords_like;
	
	protected String odprctime_ge;
	
	protected String odprctime_le;


    /**
     * 查询关键字取得
     *
     * @return keywords_like 查询关键字
     */
    public String getKeywords_like() {
        return keywords_like;
    }

    /**
     * 查询关键字设定
     *
     * @param keywords_like 查询关键字
     */
    public void setKeywords_like(String keywords_like) {
        this.keywords_like = keywords_like;
    }

    /**
     * 时间条件：从 取得
     * @return 时间条件：从
     */
	public String getOdprctime_ge() {
		return odprctime_ge;
	}

	/**
	 * 时间条件：从设定
	 * @param odprctime_ge时间条件：从
	 */
	public void setOdprctime_ge(String odprctime_ge) {
		this.odprctime_ge = odprctime_ge;
	}

	/**
	 * 时间条件：到取得
	 * @return 时间条件：到
	 */
	public String getOdprctime_le() {
		return odprctime_le;
	}

	/**
	 * 时间条件：到设定
	 * @param odprctime_le时间条件：到
	 */
	public void setOdprctime_le(String odprctime_le) {
		this.odprctime_le = odprctime_le;
	}
    /**
     * 按主键查询取得
     *
     * @return odprid_eq 按主键查询
     */
    public Integer getOdprid_eq() {
        return odprid_eq;
    }

    /**
     * 按主键查询设定
     *
     * @param odprid_eq 按主键查询
     */
    public void setOdprid_eq(Integer odprid_eq) {
        this.odprid_eq = odprid_eq;
    }
	
	
}
