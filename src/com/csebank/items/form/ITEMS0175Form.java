/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0175Form extends BaseForm implements OutStockSearchCond {

	private static final long serialVersionUID = 1L;

	protected Integer outstockid;
	protected String[] outstockorgs;//库存机构号
	protected String[] categorys;//物品种类
	protected String[] itemsnames;//物品名称
	protected String[] seqcodes;//物品编号
	protected String[] typecodes;//物品型号
	protected String[] seqnos;//批次号
	protected Integer[] bigpacknums;//大包装数量
	protected Integer[] smallpacknums;//小包装数量
	protected String[] itemversions;//凭证版本
	protected Integer[] stockids;//stock库存静态信息表的主键ID
	protected Integer[] reqnums;//申领数量
	protected Integer[] stocknum;//申领数量
	protected Integer[] chknums;//审批完成数量
	protected Integer[] outnums;//实际出库数量
	protected String[] types;//物品类型
	
	protected String outtype;//出库类型
	protected String reqstatusa;
	protected String reqorg;//领用机构号
	protected String reqid;//申请人或下拨人ＩＤ
	protected String reqname;//申请人或下拨人姓名
	protected String reqtime;//申请或下拨时间

	
	protected String chkreason;//审批调整原因
	protected String pakreason;//出库调整原因
	protected String packno;//包裹号
	protected String chkid;//审批人ID
	protected String chkname;//审批人姓名
	protected String chktime;//审批时间
	protected String stockuserid;//库管人的ID
	
	protected String stockname;//库管人的名字
	protected String outtime;//出库时间
	protected String rcvid;//接收人ID
	protected String rcvname;//接收人姓名
	protected String rcvtime;//接收时间
	protected String reqstatus;//出库状态
	protected String accountstatus;//结账状态
	
	protected Double inprice;//入库单价（未使用）
	protected Double outprice;//出库单价
	protected Double outamount;//出库金额

	
	protected String outtime_f;//出库时间从
	protected String outtime_t;//出库时间至
	
	protected String outstockorg;//库存机构号
	protected String category;//物品种类
	protected String seqcode;//物品编号
	protected Integer stockid;//stock库存静态信息表的主键ID
	protected String itemsname;//物品名称
	protected String type;//物品类型
	protected ArrayList<String> outtypelist;//出库类型
	protected String serachtype;//排序方式
	protected String outstockorg_q;//机构号
	protected String Typecode_q;//物品名称
	
	public Integer getOutstockid() {
		return outstockid;
	}
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public String[] getOutstockorgs() {
		return outstockorgs;
	}
	public void setOutstockorgs(String[] outstockorgs) {
		this.outstockorgs = outstockorgs;
	}
	public String[] getCategorys() {
		return categorys;
	}
	public void setCategorys(String[] categorys) {
		this.categorys = categorys;
	}
	public String[] getItemsnames() {
		return itemsnames;
	}
	public void setItemsnames(String[] itemsnames) {
		this.itemsnames = itemsnames;
	}
	public String[] getSeqcodes() {
		return seqcodes;
	}
	public void setSeqcodes(String[] seqcodes) {
		this.seqcodes = seqcodes;
	}
	public String[] getTypecodes() {
		return typecodes;
	}
	public void setTypecodes(String[] typecodes) {
		this.typecodes = typecodes;
	}
	public String[] getSeqnos() {
		return seqnos;
	}
	public void setSeqnos(String[] seqnos) {
		this.seqnos = seqnos;
	}
	public Integer[] getBigpacknums() {
		return bigpacknums;
	}
	public void setBigpacknums(Integer[] bigpacknums) {
		this.bigpacknums = bigpacknums;
	}
	public Integer[] getSmallpacknums() {
		return smallpacknums;
	}
	public void setSmallpacknums(Integer[] smallpacknums) {
		this.smallpacknums = smallpacknums;
	}
	public String[] getItemversions() {
		return itemversions;
	}
	public void setItemversions(String[] itemversions) {
		this.itemversions = itemversions;
	}
	public Integer[] getStockids() {
		return stockids;
	}
	public void setStockids(Integer[] stockids) {
		this.stockids = stockids;
	}
	public Integer[] getReqnums() {
		return reqnums;
	}
	public void setReqnums(Integer[] reqnums) {
		this.reqnums = reqnums;
	}
	public Integer[] getChknums() {
		return chknums;
	}
	public void setChknums(Integer[] chknums) {
		this.chknums = chknums;
	}
	public Integer[] getOutnums() {
		return outnums;
	}
	public void setOutnums(Integer[] outnums) {
		this.outnums = outnums;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getOuttype() {
		return outtype;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public String getReqorg() {
		return reqorg;
	}
	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getReqname() {
		return reqname;
	}
	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
	public String getReqtime() {
		return reqtime;
	}
	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}
	public String getChkreason() {
		return chkreason;
	}
	public void setChkreason(String chkreason) {
		this.chkreason = chkreason;
	}
	public String getPakreason() {
		return pakreason;
	}
	public void setPakreason(String pakreason) {
		this.pakreason = pakreason;
	}
	public String getPackno() {
		return packno;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
	public String getChkid() {
		return chkid;
	}
	public void setChkid(String chkid) {
		this.chkid = chkid;
	}
	public String getChkname() {
		return chkname;
	}
	public void setChkname(String chkname) {
		this.chkname = chkname;
	}
	public String getChktime() {
		return chktime;
	}
	public void setChktime(String chktime) {
		this.chktime = chktime;
	}
	public String getStockuserid() {
		return stockuserid;
	}
	public void setStockuserid(String stockuserid) {
		this.stockuserid = stockuserid;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getRcvid() {
		return rcvid;
	}
	public void setRcvid(String rcvid) {
		this.rcvid = rcvid;
	}
	public String getRcvname() {
		return rcvname;
	}
	public void setRcvname(String rcvname) {
		this.rcvname = rcvname;
	}
	public String getRcvtime() {
		return rcvtime;
	}
	public void setRcvtime(String rcvtime) {
		this.rcvtime = rcvtime;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Double getOutprice() {
		return outprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public Double getOutamount() {
		return outamount;
	}
	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	public String getOuttime_f() {
		return outtime_f;
	}
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	public String getOutstockorg() {
		return outstockorg;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public Integer getStockid() {
		return stockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public String getItemsname() {
		return itemsname;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}
	public String getSerachtype() {
		return serachtype;
	}
	public void setSerachtype(String serachtype) {
		this.serachtype = serachtype;
	}
	public String getOutstockorg_q() {
		return outstockorg_q;
	}
	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}
	public String getAccountstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCategory_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getOuttype_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getReqstatusList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSortType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStockorg() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isCanPayment() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getTypecode_q() {
		return Typecode_q;
	}
	public void setTypecode_q(String typecode_q) {
		Typecode_q = typecode_q;
	}
	public String getItemsname_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSeqcode_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatusa() {
		return reqstatusa;
	}
	public void setReqstatusa(String reqstatusa) {
		this.reqstatusa = reqstatusa;
	}
	public Integer[] getStocknum() {
		return stocknum;
	}
	public void setStocknum(Integer[] stocknum) {
		this.stocknum = stocknum;
	}
	
	
	
}
