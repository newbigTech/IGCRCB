package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * �ʲ���Ϣ��������ʵ��
 * 
 */
public class SOC0163SearchCondImpl implements SOC0163SearchCond {

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ�����ƣ�ƽ̨������ */
	protected String ename;
	
	/** �ʲ���� */
	protected String eilabel;
	
	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ�����ࣨƽ̨������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������ࣨƽ̨������ */
	protected String ekey2;
	
	/** �ʲ����¿�ʼʱ�� */
	protected String eiupdtime_from;
	
	/** �ʲ����½�ֹʱ�� */
	protected String eiupdtime_to;
	
	/** �ʲ�����2��ʼʱ�� */
	protected String eiupdtime_from2;
	
	/** �ʲ�����2��ֹʱ�� */
	protected String eiupdtime_to2;
	
	/** �ʲ������������������飨ƽ̨������ */
	protected String[] cname;
	
	/** �ʲ�����ֵ�����������飨ƽ̨������ */
	protected String[] civalue;
	
	/** �ʲ���ͨ���Ա�ż����������飨ƽ̨������ */
	protected String[] cclabel;
	
	/** �ʲ���ͨ����ֵ�����������飨ƽ̨������ */
	protected String[] ccivalue;
	
	/** �ʲ��������������*/
	public String eiorgcode;
	
	/** �ʲ�������������루ƽ̨������*/
	public String eiorgsyscoding;
	
	/** �ʲ�������������루ƽ̨������*/
	public String eiorgsyscoding_q;

	/** �ʲ�״̬��ƽ̨������ */
	protected String eistatus;

	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;
	protected String esyscoding_like;
	
	/** �ʲ�״̬��ƽ̨������*/
	protected String eistatus_q;
	
	/** �ʲ�ID���ϣ�ƽ̨������*/
	protected List<String> eiidList;
	
	/** �ʲ�ʹ�û���code */
	protected String usesyscoding;
	
	/** ά����ʼ���� */
	protected String wbdate_from;
	
	/** ά���������� */
	protected String wbdate_to;
	/**�ʲ����ڵ�*/
	protected Integer eirootmark_eq;
	
	private String ip;
	
	/** ��ѯ����ʵ���ʶ*/
	protected boolean topCiFlag;
	
	/** ����ʵ����*/
	protected String topCI;
	
	public String getTopCI() {
		return topCI;
	}

	public void setTopCI(String topCI) {
		this.topCI = topCI;
	}
	
	public boolean isTopCiFlag() {
		return topCiFlag;
	}

	public void setTopCiFlag(boolean topCiFlag) {
		this.topCiFlag = topCiFlag;
	}
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgcode() {
		return eiorgcode;
	}

	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgcode �ʲ��������������
	 */
	public void setEiorgcode(String eiorgcode) {
		this.eiorgcode = eiorgcode;
	}
	
	
	/**
	 * �ʲ�״̬ȡ��
	 * @return �ʲ�״̬
	 */
	public String getEistatus_q() {
		return eistatus_q;
	}

	/**
	 * �ʲ�״̬�趨
	 *
	 * @param eistatus_q �ʲ�״̬
	 */
	public void setEistatus_q(String eistatus_q) {
		this.eistatus_q = eistatus_q;
	}

	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding_q �ʲ��������������
	 */
	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�״̬ȡ��
	 * @return �ʲ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ʲ�״̬�趨
	 *
	 * @param eistatus �ʲ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding �ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ���趨
	 *
	 * @param elabel �ʲ�ģ�ͱ��
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
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 *
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * �ʲ�ģ��һ������ȡ��
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey2 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * �ʲ����¿�ʼʱ��ȡ��
	 * @return �ʲ����¿�ʼʱ��
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �ʲ����¿�ʼʱ���趨
	 *
	 * @param eiupdtime_from �ʲ����¿�ʼʱ��
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �ʲ����½�ֹʱ��ȡ��
	 * @return �ʲ����½�ֹʱ��
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �ʲ����½�ֹʱ���趨
	 *
	 * @param eiupdtime_to �ʲ����½�ֹʱ��
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	/**
	 * �ʲ�������������������ȡ��
	 * @return �ʲ�������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * �ʲ��������Ƽ������������趨
	 *
	 * @param cname �ʲ��������Ƽ�����������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * �ʲ�����ֵ������������ȡ��
	 * @return �ʲ�����ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �ʲ�����ֵ�������������趨
	 *
	 * @param civalue �ʲ�����ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ʲ���ͨ���Ա�ż�����������ȡ��
	 * @return �ʲ���ͨ���Ա�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * �ʲ���ͨ���Ա�ż������������趨
	 *
	 * @param cclabel �ʲ���ͨ���Ա�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * �ʲ���ͨ����ֵ������������ȡ��
	 * @return �ʲ���ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * �ʲ���ͨ����ֵ�������������趨
	 *
	 * @param ccivalue �ʲ���ͨ����ֵ������������
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * �ʲ�ID����ȡ��
	 * @return �ʲ�ID����
	 */
	public List<String> getEiidList() {
		return eiidList;
	}

	/**
	 * �ʲ�ID�����趨
	 *
	 * @param eiidList �ʲ�ID����
	 */
	public void setEiidList(List<String> eiidList) {
		this.eiidList = eiidList;
	}

	/**
	 * �ʲ�ʹ�û���codeȡ��
	 * @return �ʲ�ʹ�û���code
	 */
	public String getUsesyscoding() {
		return usesyscoding;
	}

	/**
	 * �ʲ�ʹ�û���code�趨
	 *
	 * @param usesyscoding �ʲ�ʹ�û���code
	 */
	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}

	/**
	 * ά����ʼ����ȡ��
	 * @return ά����ʼ����
	 */
	public String getWbdate_from() {
		return wbdate_from;
	}

	/**
	 * ά����ʼ�����趨
	 *
	 * @param wbdate_from ά����ʼ����
	 */
	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	/**
	 * ά����������ȡ��
	 * @return ά����������
	 */
	public String getWbdate_to() {
		return wbdate_to;
	}

	/**
	 * ά�����������趨
	 *
	 * @param wbdate_to ά����������
	 */
	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	/**
	 * �ʲ����ڵ�ȡ��
	 *
	 * @return eirootmark_eq �ʲ����ڵ�
	 */
	public Integer getEirootmark_eq() {
		return eirootmark_eq;
	}

	/**
	 * �ʲ����ڵ��趨
	 *
	 * @param eirootmark_eq �ʲ����ڵ�
	 */
	public void setEirootmark_eq(Integer eirootmark_eq) {
		this.eirootmark_eq = eirootmark_eq;
	}

	/**
	 * @return the �ʲ�����2��ʼʱ��
	 */
	public String getEiupdtime_from2() {
		return eiupdtime_from2;
	}

	/**
	 * @param �ʲ�����2��ʼʱ�� the eiupdtime_from2 to set
	 */
	public void setEiupdtime_from2(String eiupdtime_from2) {
		this.eiupdtime_from2 = eiupdtime_from2;
	}

	/**
	 * @return the �ʲ�����2��ֹʱ��
	 */
	public String getEiupdtime_to2() {
		return eiupdtime_to2;
	}

	/**
	 * @param �ʲ�����2��ֹʱ�� the eiupdtime_to2 to set
	 */
	public void setEiupdtime_to2(String eiupdtime_to2) {
		this.eiupdtime_to2 = eiupdtime_to2;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
	
}