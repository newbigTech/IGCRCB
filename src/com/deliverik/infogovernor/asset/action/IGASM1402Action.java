package com.deliverik.infogovernor.asset.action;

import java.util.Date;
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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1402Form;
import com.deliverik.infogovernor.asset.vo.IGASM14021VO;

/**
 * 服务记录编辑画面Action处理
 *
 * @author
 */
public class IGASM1402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1402Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1402Form form = (IGASM1402Form)actionForm;
		
		//BL取得
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO生成
		IGASM14DTO dto = new IGASM14DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//服务记录登记画面初期显示处理
			log.debug("========服务记录登记画面初期显示处理开始========");
			form = new IGASM1402Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);		
			
			dto.setIgasm1402Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM1402Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","服务记录基本信息"));
			log.debug("========服务记录登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//服务记录登记画面再显示处理
			log.debug("========服务记录登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========服务记录登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//服务记录编辑处理
			if (form.getMode().equals("0")){
				//服务记录登记处理
				log.debug("========服务记录登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO输入参数设定
				dto.setIgasm1402Form(form);
				
				//服务记录信息登记逻辑调用
				dto = ctlBL.insertEntityItemAction(dto);
				
				//将登记完了的服务记录信息设定到VO中
				IGASM14021VO vo = new IGASM14021VO(dto.getIgasm1402Form());
				
				super.<IGASM14021VO>setVO(req.getSession(), vo);
				
				log.debug("========服务记录登记处理终了========");
				
				forward = "DISP";

			}
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
