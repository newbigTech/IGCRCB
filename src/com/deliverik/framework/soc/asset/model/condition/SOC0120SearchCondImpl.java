/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: �������ݰ汾��������������ʵ��
  * ��������: �������ݰ汾��������������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0120SearchCondImpl implements
		SOC0120SearchCond {
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag_eq;
	
	/** ʵ����(������)*/
	protected String impeiname_eq;
	
	/** ʵ���� */
	protected String impeiname;
	
	/** ʵ����(ģ����ѯ) */
	protected String impeiname_like;
	
	/** �汾�� */
	protected Integer impversion;
	
	/** ����ʱ�� */
	protected String impcreatetime_e;
	
	/** ����ʱ�� */
	protected String impcreatetime_s;

	/** code�� */
	protected String esyscoding;

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname_eq() {
		return impeiname_eq;
	}
	
	
	/**
	 * ʵ�����趨
	 *
	 * @param impeiname_eqʵ����
	 */
	public void setImpeiname_eq(String impeiname_eq) {
		this.impeiname_eq = impeiname_eq;
	}
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param deleteflag_eq �߼�ɾ����ʶ
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}

	/**
	 * ʵ����(ģ����ѯ)ȡ��
	 * @return ʵ����(ģ����ѯ)
	 */
	public String getImpeiname_like() {
		return impeiname_like;
	}

	/**
	 * ʵ����(ģ����ѯ)�趨
	 * @param impeiname_likeʵ����(ģ����ѯ)
	 */
	public void setImpeiname_like(String impeiname_like) {
		this.impeiname_like = impeiname_like;
	}

	/**
	 * ʵ����ȡ��
	 * @return ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * ʵ�����趨
	 * @param impeinameʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * �汾���趨
	 * @param impversion�汾��
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}


	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getImpcreatetime_e() {
		return impcreatetime_e;
	}


	public void setImpcreatetime_e(String impcreatetime_e) {
		this.impcreatetime_e = impcreatetime_e;
	}


	public String getImpcreatetime_s() {
		return impcreatetime_s;
	}


	public void setImpcreatetime_s(String impcreatetime_s) {
		this.impcreatetime_s = impcreatetime_s;
	}
}