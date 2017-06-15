/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0502Form;
import com.csebank.lom.vo.IGLOM05011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 食堂成本管理Action
 * 
 */
public class IGLOM0502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0502Action.class);

	/**
	 * 食堂成本管理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGLOM0502Form form = (IGLOM0502Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//食堂成本管理查询画面初期显示处理
			log.debug("========食堂成本管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========食堂成本管理查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} 	/*
			else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========食堂成本管理删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteRid(form.getDeleteRid());
			
			ctlBL.deleteRecptionAction(dto);
			
			log.debug("========接待工作管理删除处理终了========");
			
			forward = "DELETE";
			
		} */else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//食堂成本管理查询处理
			log.debug("========食堂成本管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0502");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0502Form) req.getSession().getAttribute("IGLOM0502Form");
				if ( form == null ) {
					form = new IGLOM0502Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0502Form) req.getSession().getAttribute("IGLOM0502Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0502");
			
			//DTO输入参数设定
			dto.setEaterySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//食堂成本管理信息检索逻辑调用
			dto = ctlBL.searchEateryAction(dto);
			
			
			//将食堂成本管理信息检索结果设定到VO中
			IGLOM05011VO vo = new IGLOM05011VO();
			vo.setEateryList(dto.getEateryList());
			
			super.<IGLOM05011VO>setVO(req, vo);
			
			log.debug("========食堂成本管理查询处理终了========");
			
			forward = "DISP";
			
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
