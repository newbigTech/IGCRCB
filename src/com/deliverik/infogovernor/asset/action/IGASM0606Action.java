package com.deliverik.infogovernor.asset.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM06BL;
import com.deliverik.infogovernor.asset.dto.IGASM06DTO;
import com.deliverik.infogovernor.asset.form.IGASM0606Form;
import com.deliverik.infogovernor.asset.vo.IGASM06061VO;

/**
 * ������ϵ��������Action����
 *
 */
public class IGASM0606Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0606Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM0606Form form = (IGASM0606Form)actionForm;
		
		//BLȡ��
		IGASM06BL ctlBL = (IGASM06BL) getBean("igasm06BL");
		
		//DTO����
		IGASM06DTO dto = new IGASM06DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//������ϵ�������������ʾ����
			log.debug("========������ϵ�������������ʾ������ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM0606Form) req.getSession().getAttribute("IGASM0606Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0606");

			//DTO��������趨
			dto.setIgasm0606Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������ϵ�������������ʾ�߼�����
			dto = ctlBL.initIGASM0606Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM06061VO vo = new IGASM06061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM06061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========������ϵ�������������ʾ��������========");
			
			forword = "DISP";
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			if (req.getParameter("btn_back")!=null) {
				//���ذ�ť����ʱ�ķ��ش���
				forword = "BACK";
			}
			if (req.getParameter("btn_add")!=null) {
				//���Ӱ�ť����ʱ�Ĵ���
				forword = "ADD";
			}
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//������ϵɾ������
			log.debug("========������ϵɾ��������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//������ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========������ϵɾ����������========");
			
			forword = "DISP";
		}

		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forword);
	}
}