package com.dev.ext.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * �������һ������������ͨ����ť��������
 * �ж϶����������Ƿ���ڣ��趨�����������Ƿ���ڱ���ֵ
 * </p>
 */
public class IGEVENT0202BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0202BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/**
	 * ��ѯ�๦��API���趨
	 * 
	 * @param flowSearchBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		//��ѯ����������
		List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��������");
		
		PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
		
		//������
		ppivInfo.setFormname("2�������Ƿ����");

		if (pInfoList != null && pInfoList.size() > 0){
			//���ö����������Ƿ���ڱ���ֵΪ1			
			//����ֵ
			ppivInfo.setFormvalue("1");			
		} else {
			//���ö����������Ƿ���ڱ���ֵΪ0			
			//����ֵ
			ppivInfo.setFormvalue("0");			
		}
		this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
		
	}

}