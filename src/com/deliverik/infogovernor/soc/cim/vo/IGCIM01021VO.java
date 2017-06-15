package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * �豸��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01021VO extends BaseVO implements Serializable{
	
	/** �豸��¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData���豸��¼����Ϣ
	 */
	public IGCIM01021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * �豸��¼����Ϣȡ��
	 * @return �豸��¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}

