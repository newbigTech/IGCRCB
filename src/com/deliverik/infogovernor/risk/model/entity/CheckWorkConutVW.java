/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
  * 概述: 检查工作统计报表实体
  * 功能描述: 检查工作统计报表实体
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckWorkConutVW")
public class CheckWorkConutVW extends BaseEntity implements Serializable,
		Cloneable, CheckWorkConutVWInfo {

	/** 主键 */
	@Id
	protected Integer id;
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	protected Integer rcid;

	/** 检查项名称 */
	protected String rcname;
	
	/** 检查项说明*/
	protected String rcdesc;

	/** 检查频率 */
	protected String rcfrequency;

	/** 责任人 */
	protected String rcusername;

	/** 检查项分类 */
	protected String rccategoryname;

	/** 问题名称 */
	protected String prtitle;

	/** 检查方式 */
	protected String rcrtestmode;

	/** 检查结果 */
	protected String rcstatus;

	/** 实际检查时间 */
	protected String rccreatetime;

	/** 结果说明 */
	protected String rcrcomment;

	/** 检查程度 */
	protected String rcrresult;

	/** 附件 */
	protected String rcrattch;

	/** 检查计划时间 */
	protected String rcrplandate;
	
	/**检查开始时间*/
	protected String rcstartdate;
	
	/** 风险检查类型 */
	protected String rcclass;
	/**附件id*/
	protected String attachid;

	/**
	 * 检查开始时间取得
	 * @return rcstartdate 检查开始时间
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}

	/**
	 * 检查开始时间设定
	 * @param rcstartdate 检查开始时间
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 主键设定
	 *
	 * @param rcid 主键
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 检查项名称取得
	 *
	 * @return 检查项名称
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * 检查项名称设定
	 *
	 * @param rcname 检查项名称
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * 检查频率取得
	 *
	 * @return 检查频率
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * 检查频率设定
	 *
	 * @param rcfrequency 检查频率
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * 责任人取得
	 *
	 * @return 责任人
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * 责任人设定
	 *
	 * @param rcusername 责任人
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * 检查项分类取得
	 *
	 * @return 检查项分类
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * 检查项分类设定
	 *
	 * @param rccategoryname 检查项分类
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	/**
	 * 问题名称取得
	 *
	 * @return 问题名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 问题名称设定
	 *
	 * @param prtitle 问题名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 检查方式取得
	 *
	 * @return 检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * 检查方式设定
	 *
	 * @param rcrtestmode 检查方式
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * 检查结果取得
	 *
	 * @return 检查结果
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * 检查结果设定
	 *
	 * @param rcstatus 检查结果
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * 实际检查时间取得
	 *
	 * @return 实际检查时间
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * 实际检查时间设定
	 *
	 * @param rccreatetime 实际检查时间
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * 结果说明取得
	 *
	 * @return 结果说明
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * 结果说明设定
	 *
	 * @param rcrcomment 结果说明
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * 检查程度取得
	 *
	 * @return 检查程度
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * 检查程度设定
	 *
	 * @param rcrresult 检查程度
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getRcrattch() {
		return rcrattch;
	}

	/**
	 * 附件设定
	 *
	 * @param rcrattch 附件
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}

	/**
	 * 检查计划时间取得
	 *
	 * @return 检查计划时间
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * 检查计划时间设定
	 *
	 * @param rcrplandate 检查计划时间
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rcid;
	}

	/**
	 * 风险检查类型取得
	 * @return rcclass 风险检查类型
	 */
	public String getRcclass() {
		return rcclass;
	}

	/**
	 * 风险检查类型设定
	 * @param rcclass 风险检查类型
	 */
	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	/**
	 * 附件id取得
	 * @return attachid 附件id
	 */
	public String getAttachid() {
		return attachid;
	}

	/**
	 * 附件id设定
	 * @param attachid 附件id
	 */
	public void setAttachid(String attachid) {
		this.attachid = attachid;
	}

	/**
	 * 检查项说明取得
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * 检查项说明设定
	 * @param rcdesc the 检查项说明
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}
}