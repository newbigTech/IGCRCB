/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * �ʲ��������ݱ�ʶ�б��֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04191VO extends BaseVO implements Serializable{
	
	/** �ʲ��������ݱ�ʶ�б� */
	protected List<SOC0151Info> configurationCodeDetailList;

	/**
	 * ���캯��
	 * @param configurationCodeDetailBeanList���ʲ��������ݱ�ʶ�б�
	 */
	public IGDRM04191VO(List<SOC0151Info> configurationCodeDetailList) {
		this.configurationCodeDetailList = configurationCodeDetailList;
	}

	public List<SOC0151Info> getConfigurationCodeDetailList() {
		return configurationCodeDetailList;
	}

}

