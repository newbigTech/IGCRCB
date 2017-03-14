/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;

/**
 * 概述: 存储维护画面FORM
 * 功能描述: 存储维护画面FORM
 * 创建记录: 2011/11/18
 * 修改记录: 
 */
public class IGMNT0207Form extends BaseForm implements SOC0306SearchCond{
	private static final long serialVersionUID = 1L;
	

	/**
	 *symmid
	 */
	protected String symmid;

	/**
	 *symmid取得
	 * 
	 * @return symmid
	 */
	public String getSymmid() {
		return symmid;
	}

	/**
	 *symmid设定
	 * 
	 * @param symmidsymmid
	 */
	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}

	/**
	 *创建时间
	 */
	protected String dataitmes;

	/**
	 *创建时间取得
	 * 
	 * @return 创建时间
	 */
	public String getDataitmes() {
		return dataitmes;
	}

	/**
	 *创建时间设定
	 * 
	 * @param dataitmes创建时间
	 */
	public void setDataitmes(String dataitmes) {
		this.dataitmes = dataitmes;
	}

	/**
	 *类型
	 */
	protected String symtype;

	/**
	 *类型取得
	 * 
	 * @return 类型
	 */
	public String getSymtype() {
		return symtype;
	}

	/**
	 *类型设定
	 * 
	 * @param symtype类型
	 */
	public void setSymtype(String symtype) {
		this.symtype = symtype;
	}

	/**
	 *是否已阅读
	 */
	protected String readdate;

	/**
	 *是否已阅读取得
	 * 
	 * @return 是否已阅读
	 */
	public String getReaddate() {
		return readdate;
	}

	/**
	 *是否已阅读设定
	 * 
	 * @param readdate是否已阅读
	 */
	public void setReaddate(String readdate) {
		this.readdate = readdate;
	}

	/**
	 *创建时间从
	 */
	protected String dataitmes_f;
	
	/**
	 *创建时间到
	 */
	protected String dataitmes_t;

	public String getDataitmes_f() {
		return dataitmes_f;
	}

	public void setDataitmes_f(String dataitmes_f) {
		this.dataitmes_f = dataitmes_f;
	}

	public String getDataitmes_t() {
		return dataitmes_t;
	}

	public void setDataitmes_t(String dataitmes_t) {
		this.dataitmes_t = dataitmes_t;
	}
	
}
