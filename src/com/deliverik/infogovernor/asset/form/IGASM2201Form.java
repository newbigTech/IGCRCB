/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: CI变更控制台显示FORM
 * 功能描述: CI变更控制台显示FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM2201Form extends BaseForm {
	
	/** 任务复选框 */
	protected String[] ciwtids;

	/** 任务状态是否完成 */
	protected String taskDone;
	
	/**
	 * 任务复选框取得
	 * 
	 * @return 任务复选框
	 */
	public String[] getCiwtids() {
		return ciwtids;
	}

	/**
	 * 任务复选框设定
	 * 
	 * @param ciwtids 任务复选框
	 */
	public void setCiwtids(String[] ciwtids) {
		this.ciwtids = ciwtids;
	}

	/**
	 * 任务状态是否完成取得
	 * 
	 * @return 任务状态是否完成
	 */
	public String getTaskDone() {
		return taskDone;
	}

	/**
	 * 任务状态是否完成设定
	 * 
	 * @param 任务状态是否完成
	 */
	public void setTaskDone(String taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.taskDone = "0";//默认查询未完成
		this.ciwtids = null;
	}

}
