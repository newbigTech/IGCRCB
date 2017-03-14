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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0108Form;

/**
 * �豸��ѯ����Action����
 *
 */
public class IGCIM0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0108Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0108Form form = (IGCIM0108Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		
		if ("DISP".equals(mapping.getParameter())){
			req.setAttribute("backurl", req.getParameter("backurl"));
			
			//�豸�޸Ĵ�����ʾ
			log.debug("========�豸�޸Ĵ�����ʾ��ʼ========");
			dto.setIgcim0108Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========�豸�޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//�豸�޸Ĵ�����ʾ
			log.debug("========�豸�޸Ĵ�����ʾ��ʼ========");
			req.setAttribute("backurl", req.getParameter("backurl"));
			dto.setIgcim0108Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========�豸�޸Ĵ�����ʾ����========");
		}
		
		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}