/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ����������ϵ����������ʵ��
  * ��������: ����������ϵ����������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiBelongRelationSearchCondImpl implements
		EiBelongRelationSearchCond {
	/** Դ�ʲ�ID */
	protected String brpareiid;

	/** Դ�ʲ���汾 */
	protected String brparversion;

	/** Դ�ʲ�С�汾 */
	protected String brparsmallversion;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** Ŀ���ʲ�ID */
	protected String brcldeiid;

	/** Ŀ���ʲ���汾 */
	protected String brcldversion;

	/** Ŀ���ʲ�С�汾 */
	protected String brcldsmallversion;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected String eirootmark;
	
	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public String getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * Ŀ���ʲ�ID�趨
	 *
	 * @param brcldeiidĿ���ʲ�ID
	 */
	public void setBrcldeiid(String brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public String getBrcldversion() {
		return brcldversion;
	}

	/**
	 * Ŀ���ʲ���汾�趨
	 *
	 * @param brcldversionĿ���ʲ���汾
	 */
	public void setBrcldversion(String brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * Ŀ���ʲ�С�汾ȡ��
	 *
	 * @return Ŀ���ʲ�С�汾
	 */
	public String getBrcldsmallversion() {
		return brcldsmallversion;
	}

	/**
	 * Ŀ���ʲ�С�汾�趨
	 *
	 * @param brcldsmallversionĿ���ʲ�С�汾
	 */
	public void setBrcldsmallversion(String brcldsmallversion) {
		this.brcldsmallversion = brcldsmallversion;
	}

	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param deleteflag�߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public String getBrpareiid() {
		return brpareiid;
	}

	/**
	 * Դ�ʲ�ID�趨
	 *
	 * @param brpareiidԴ�ʲ�ID
	 */
	public void setBrpareiid(String brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public String getBrparversion() {
		return brparversion;
	}

	/**
	 * Դ�ʲ���汾�趨
	 *
	 * @param brparversionԴ�ʲ���汾
	 */
	public void setBrparversion(String brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * Դ�ʲ�С�汾ȡ��
	 *
	 * @return Դ�ʲ�С�汾
	 */
	public String getBrparsmallversion() {
		return brparsmallversion;
	}

	/**
	 * Դ�ʲ�С�汾�趨
	 *
	 * @param brparsmallversionԴ�ʲ�С�汾
	 */
	public void setBrparsmallversion(String brparsmallversion) {
		this.brparsmallversion = brparsmallversion;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public String getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}
}