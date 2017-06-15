/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂成本信息查询接口
 *
 */
public interface EaterySearchCond {
	
	/**
	 * 食堂成本信息查询时间开始
	 */
	public String getEtime_from();
	
	/**
	 * 食堂成本信息查询时间结束
	 */
	public String getEtime_to();

}
