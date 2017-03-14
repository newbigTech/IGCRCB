package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * �����༭����FORM
 * 
 */
public class IGASM2802Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** �����ID */
	protected Integer eiid;
	
	/** �����ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** ��������� */
	protected String einame;
	
	/** �������� */
	protected String eilabel;

	/** �����˵�� */
	protected String eidesc;

	/** �����״̬ */
	protected String eistatus;

	/** �������ʱ�� */
	protected String eiupdtime;
	
	/** �����汾�� */
	protected Integer eiversion;

	/** �����Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/**��̸����*/
	protected String viewobj;
	
	/**���ϵ���*/
	protected String dataread;
	
	/**������Ƶ��*/
	protected String checkfrequency;
	
	/**�����xinxi*/
	protected String[] civalue;
	
	/** ɾ���������� */
	protected String[] deleteEiid;
	
	/**������id*/
	protected String mguserid;
	
	/**����������*/
	protected String mgusername;

	/**
	 * ������idȡ��
	 * @return mguserid ������id
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * ������id�趨
	 * @param mguserid ������id
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * ����������ȡ��
	 * @return mgusername ����������
	 */
	public String getMgusername() {
		return mgusername;
	}

	/**
	 * �����������趨
	 * @param mgusername ����������
	 */
	public void setMgusername(String mgusername) {
		this.mgusername = mgusername;
	}

	/**
	 * �����xinxiȡ��
	 * @return civalue �����xinxi
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �����xinxi�趨
	 * @param civalue �����xinxi
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * �����ID�趨
	 *
	 * @param eiid �����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * �����ID�����֣�ȡ��
	 * @return �����ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * �����ID�����֣��趨
	 *
	 * @param eiidStr �����ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����������趨
	 *
	 * @param einame ���������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���������趨
	 *
	 * @param eilabel ��������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �����˵��ȡ��
	 * @return �����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �����˵���趨
	 *
	 * @param eidesc �����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ��������ʱ��ȡ��
	 * @return ��������ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ��̸����ȡ��
	 * @return viewobj ��̸����
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * ��̸�����趨
	 * @param viewobj ��̸����
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * ���ϵ���ȡ��
	 * @return dataread ���ϵ���
	 */
	public String getDataread() {
		return dataread;
	}

	/**
	 * ���ϵ����趨
	 * @param dataread ���ϵ���
	 */
	public void setDataread(String dataread) {
		this.dataread = dataread;
	}

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * ������Ƶ���趨
	 * @param checkfrequency ������Ƶ��
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param eiupdtime ��������ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �����״̬ȡ��
	 * @return �����״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �����״̬�趨
	 *
	 * @param eistatus �����״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �����汾��ȡ��
	 * @return �����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �����汾���趨
	 *
	 * @param eiversion �����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �����Ǽ���ȡ��
	 * @return �����Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �����Ǽ����趨
	 *
	 * @param eiinsdate �����Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}