/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 控制台任务查看FORM
 * 功能描述: 控制台任务查看FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM2010Form extends BaseForm {
	
	/** 任务ID */
	protected Integer eitid;

	/**
	 * 任务ID取得
	 * 
	 * @return 任务ID
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * 任务ID设定
	 * 
	 * @param eitid 任务ID
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

}
