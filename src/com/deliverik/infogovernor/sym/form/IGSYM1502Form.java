package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;

/**
 * 数据详细信息画面FORM
 * 
 */
public class IGSYM1502Form extends BaseForm implements CodeDetailDefSearchCond {

	private static final long serialVersionUID = 1L;
	
	/** 数据分类CD */
	protected String ccid ;
	/** 数据分类CD */
	protected String tempccid ;
	
	/** 数据CD */
	protected String cid ;
	
	/** 数据CD */
	protected String tempcid ;
	
	/** 数据分类CD */
	protected String ccname ;
	
	/** 数据id */
	protected String pcid ;
	
	/** 数据名称 */
	protected String pcvalue ;
	
	/** 状态 0-停用，1-启用 */
	protected String cdstatus;
	
	/** 级次 */
	protected String clevel;
	
	protected String pccid;
	
	/** 查询指定结点的下级树 */
	protected String syscoding_q;
	
	/** 查询指定结点 */
	protected String syscoding;
	
	protected String psyscoding;
	
	/** 是否可选择根节点 1不可以 */
	protected String rootSelect;
	
	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getPcvalue() {
		return pcvalue;
	}

	public void setPcvalue(String pcvalue) {
		this.pcvalue = pcvalue;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	/**
	 * 状态 0-停用，1-启用
	 * @return 状态
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * 状态 0-停用，1-启用
	 *
	 * @param cdstatus 状态
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	public String getTempcid() {
		return tempcid;
	}

	public void setTempcid(String tempcid) {
		this.tempcid = tempcid;
	}

	public String getTempccid() {
		return tempccid;
	}

	public void setTempccid(String tempccid) {
		this.tempccid = tempccid;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getPccid() {
		return pccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public String getPcid() {
		return pcid;
	}

	public String getPsyscoding() {
		return psyscoding;
	}

	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

	

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public String getBusinesscode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 是否可选择根节点取得
	 * @return 是否可选择根节点
	 */
	public String getRootSelect() {
		return rootSelect;
	}

	/**
	 * 是否可选择根节点设定
	 * @param rootSelect是否可选择根节点
	 */
	public void setRootSelect(String rootSelect) {
		this.rootSelect = rootSelect;
	}

	public String getCvalue_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
