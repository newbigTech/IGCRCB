/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
/**
 * 概述: 导入对象信息检索结果ＶＯ
 * 功能描述: 导入对象信息检索结果ＶＯ
 * 创建记录: 2011/05/05
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02111VO extends BaseVO implements Serializable{
	
	/** 导入对象版本检索结果 */
	protected List<SOC0120Info> importVersionInfoList;
	
	/** 导入对象检索结果 */
	protected SOC0120Info importVersionInfo;
	
	
	
	/**
	 * 构造函数
	 * @param importVersionInfoList导入对象版本检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public IGCIM02111VO(List<SOC0120Info> importVersionInfoList,
			SOC0120Info importVersionInfo) {
		super();
		this.importVersionInfoList = importVersionInfoList;
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * 导入对象版本检索结果取得
	 * @return 导入对象检索结果 
	 */
	public List<SOC0120Info> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 导入对象版本检索结果设定
	 * @param importVersionInfoList导入对象检索结果 
	 */
	public void setImportVersionInfoList(
			List<SOC0120Info> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * 导入对象检索结果
	 * @return 导入对象检索结果
	 */
	public SOC0120Info getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * 导入对象检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public void setImportVersionInfo(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	

}
