/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 自定义流程页面设置Form
 * 功能描述:  自定义流程页面设置Form
 * 创建记录: 2012/11/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0169Form extends BaseForm {
	
	/** 主键 */
	protected String pjdid;

	/** 流程定义ID */
	protected String pdid;
	
	/** 页面类型*/
	protected String pjdtype;

	/** BL名称 */
	protected String pjdblid;

	/** 相对路径 */
	protected String pjdurl;
	
	/** 登记成功返回标志 0 新增 1 修改*/
	protected String mode = "0";
	/** 记录时间戳 */
	protected String fingerPrint;

	/**
	 * 主键获取
	 * @return the pjdid
	 */
	public String getPjdid() {
		return pjdid;
	}

	/**
	 *
	 *	主键设置
	 * @param pjdid the pjdid to set
	 */
	public void setPjdid(String pjdid) {
		this.pjdid = pjdid;
	}

	/**
	 * 流程定义ID 获取
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 *流程定义ID  设置
	 *	
	 * @param pdid the pdid to set
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 页面类型 取得
	 * @return the pjdtype
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 *页面类型 设置
	 *	
	 * @param pjdtype the pjdtype to set
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * BL名称获得
	 * @return the pjdblid
	 */
	public String getPjdblid() {
		return pjdblid;
	}

	/**
	 *
	 *	BL名称设置
	 * @param pjdblid the pjdblid to set
	 */
	public void setPjdblid(String pjdblid) {
		this.pjdblid = pjdblid;
	}

	/**
	 * 相对路径获得
	 * @return the pjdurl
	 */
	public String getPjdurl() {
		return pjdurl;
	}

	/**
	 *
	 *	相对路径 设置
	 * @param pjdurl the pjdurl to set
	 */
	public void setPjdurl(String pjdurl) {
		this.pjdurl = pjdurl;
	}

	/**
	 * 时间戳获得
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 *时间戳设置
	 *	
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 *  登记成功返回标志 获取
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 登记成功返回标志 设置
	 *	
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}
