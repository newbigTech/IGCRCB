package com.deliverik.infogovernor.soc.cim.action;


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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0105Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01051VO;

/**
 * �豸������Ϣ��ʷ��¼����Action����
 *
 */
public class IGCIM0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0105Action.class);
	
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
		IGCIM0105Form form = (IGCIM0105Form)actionForm;
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igasm03BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//�豸������Ϣ��ʷ��¼���������ʾ����
			log.debug("========�豸������Ϣ��ʷ��¼���������ʾ������ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0105");

			//DTO��������趨
			dto.setIgasm0305Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�豸������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0305Action(dto);
			
			//���豸������Ϣ��ʷ��¼��������趨��VO��
			IGCIM01051VO vo = new IGCIM01051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGCIM01051VO>setVO(req.getSession(), vo);
			
			//�߼����������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========�豸������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "XMLDISP".equals(mapping.getParameter())){
			//�豸������Ϣ��ʷ��¼���������ʾ����
			log.debug("========�豸������Ϣ��ʷ��¼���������ʾ������ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0105");

			//DTO��������趨
			dto.setIgasm0305Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�豸������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0305ActionForXML(dto);
			
			//���豸������Ϣ��ʷ��¼��������趨��VO��
			IGCIM01051VO vo = new IGCIM01051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGCIM01051VO>setVO(req.getSession(), vo);
			
			//�߼����������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========�豸������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//�豸������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
	
	
}