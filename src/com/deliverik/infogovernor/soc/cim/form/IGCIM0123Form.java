package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ�û�����Ϣ�ɹ���¼��ȷ�ϻ���FORM
 * 
 */
public class IGCIM0123Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** Ӧ��ID */
	protected Integer eiid;

	/**
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}