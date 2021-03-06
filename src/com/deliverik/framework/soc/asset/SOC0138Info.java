/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
 * 概述: 资产域明细表接口
 * 功能描述: 资产域明细表接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface SOC0138Info extends BaseModel {

	/**
	 * 资产域ID取得
	 *
	 * @return 资产域ID
	 */
	public Integer getEiddid();

	/**
	 * 资产域版本取得
	 *
	 * @return 资产域版本
	 */
	public Integer getEiddversion();

	/**
	 * 资产名称取得
	 *
	 * @return 资产ID
	 */
	public  String getEiname();

	/**
	 * 资产导入版本取得
	 *
	 * @return 资产导入版本
	 */
	public Integer getEiImportversion();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/** 创建时间 */
	public String getCreatetime();
	
//	/**
//	 * 域信息取得
//	 * @return 域信息
//	 */
//	public EiDomainDefVW getEiDomainDefVW();
	/**
	 * 域信息取得
	 * @return 域信息
	 */
	public SOC0111TB getEiDomainDefTB();
	
	public Integer getEiid();
	
	/**
	 * 资产已建立关系总数取得
	 * @return 资产已建立关系总数
	 */
	public String getEircount();
}
