package com.deliverik.infogovernor.risk.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskCheck;


/**
 * 风险检查结果FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0206Form extends BaseForm {
	
	/** 风险检查结果ID */
	protected Integer rcrid;
	
	/** 风险检查ID */
	protected Integer rcid;
	
	/** 风险检查检查项名称*/
	protected String rcname;

	/** 风险检查计划检查时间 */
	protected String rcrplandate;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_from;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_to;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime;
	
	/** 风险检查结果提交人ID */
	protected String rcruserid;
	
	/** 风险检查结果提交人姓名 */
	protected String rcrusername;
	
	/** 风险检查结果 */
	protected String rcrresult;
	
	/** 风险检查结果说明 */
	protected String rcrcomment;
	
	/** 风险检查对象 */
	protected RiskCheck riskCheck;
	/** 风险检查方法说明 */
	protected String rcdesc;


	/** 风险检查项类别 */
	protected String rccategory;
	
	/** 风险检查项类别 */
	protected String rccategoryname;
	
	/** 计划执行检查开始日期（查询条件） */
	protected String startdate;
	
	/** 计划执行检查结束日期（查询条件）*/
	protected String enddate;

	
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	
	/**
	 * 风险检查检查项名称取得
	 * @return 风险检查检查项名称
	 */
	public String getRcname() {
		return rcname;
	}


	/**
	 * 风险检查检查项名称设定
	 * @param rcname 风险检查检查项名称
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}
	

	/**
	 * 计划执行检查开始日期（查询条件）取得
	 * @return 计划执行检查开始日期（查询条件）
	 */
	public String getStartdate() {
		return startdate;
	}
	

	/**
	 * 计划执行检查结束日期（查询条件）取得
	 * @return 计划执行检查结束日期（查询条件）
	 */
	public String getEnddate() {
		return enddate;
	}


	/**
	 * 计划执行检查开始日期（查询条件）设定
	 * @param startdate 计划执行检查开始日期（查询条件）
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	/**
	 * 计划执行检查结束日期（查询条件）设定
	 * @param enddate 计划执行检查结束日期（查询条件）
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	/**
	 * @return the fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}


	/**
	 * @param fileMap the fileMap to set
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}


	/**
	 * 风险检查结果附件数据取得
	 * @return 风险检查结果附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 风险检查结果附件数据
	 *
	 * @param index 风险检查结果附件数据数组索引
	 * @param file 风险检查结果附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 风险检查结果ID取得
	 * @return 风险检查结果ID
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * 风险检查ID取得
	 * @return the 风险检查ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 风险检查计划检查时间取得
	 * @return 风险检查计划检查时间
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * 风险检查实际检查时间取得
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * 风险检查结果提交人ID取得
	 * @return 风险检查结果提交人ID
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * 风险检查结果提交人姓名取得
	 * @return 风险检查结果提交人姓名
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * 风险检查结果取得
	 * @return 风险检查结果
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * 风险检查结果说明取得
	 * @return 风险检查结果说明
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * 风险检查对象取得
	 * @return 风险检查对象
	 */
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}

	/**
	 * 风险检查结果ID设定
	 * @param rcrid 风险检查结果ID
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * 风险检查ID设定
	 * @param rcid 风险检查ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 风险检查计划检查时间设定
	 * @param rcrplandate 风险检查计划检查时间
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * 风险检查实际检查时间设定
	 * @param rcrrealtime 风险检查实际检查时间
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * 风险检查结果提交人ID设定
	 * @param rcruserid 风险检查结果提交人ID
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * 风险检查结果提交人姓名设定
	 * @param rcrusername 风险检查结果提交人姓名
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * 风险检查结果设定
	 * @param rcrresult 风险检查结果
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * 风险检查结果说明设定
	 * @param rcrcomment 风险检查结果说明
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * 风险检查对象设定
	 * @param riskCheck 风险检查对象
	 */
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}

	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory() {
		return rccategory;
	}


	/**
	 * 风险检查项类别设定
	 * @param rccategory 风险检查项类别
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}


	/**
	 * 风险检查项类别取得
	 *
	 * @return 风险检查项类别
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}


	/**
	 * 风险检查项类别设定
	 *
	 * @param rccategoryname 风险检查项类别
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}
	public String getRcdesc() {
		return rcdesc;
	}

	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}


	public String getRcrplandate_from() {
		return rcrplandate_from;
	}


	public void setRcrplandate_from(String rcrplandate_from) {
		this.rcrplandate_from = rcrplandate_from;
	}


	public String getRcrplandate_to() {
		return rcrplandate_to;
	}


	public void setRcrplandate_to(String rcrplandate_to) {
		this.rcrplandate_to = rcrplandate_to;
	}
	
	

}
