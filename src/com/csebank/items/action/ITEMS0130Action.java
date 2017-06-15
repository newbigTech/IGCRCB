/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.common.OrgValueBean;
import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0130Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0130Action extends BaseAction {

	static Log log = LogFactory.getLog(ITEMS0130Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL) this.getBean("items01BL");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		ITEMS01DTO dto = new ITEMS01DTO();
		dto.setUser(user);
		boolean flag = items01BL.checkRoleManagerByUserID(dto);
		if(flag){
			req.setAttribute("selectOrg","Y");
		}else{
			req.setAttribute("selectOrg","N");
		}
		if("DISP".equals(mapping.getParameter())){
			ITEMS0130Form form = (ITEMS0130Form) actionForm;
			if(flag){
				form.setStockorg_qname(OrgValueBean.getConfigInfo(DefineUtils.DEFAULT_ORGNO));
				form.setStockorg_q(DefineUtils.DEFAULT_ORGNO);
			}
			
		}else if ("SEARCH".equals(mapping.getParameter())) {
			
			ITEMS0130Form form = (ITEMS0130Form) actionForm;
			dto.setCategory(form.getCategory());
			//分页信息
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setStockorg_q(form.getStockorg_q());
			dto.setSeqcode_q(form.getSeqcode_q());
			dto.setItemsname_q(form.getItemsname_q());
			dto = items01BL.statStockAction(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setStockList(dto.getStockList());
			req.setAttribute("chknumList", dto.getChknumList());
			super.<ITEMS01011VO> setVO(req, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				pDto.setFromCount(0);
				pDto.setPageDispCount(0);
				dto.setPagingDto(pDto);
				dto = items01BL.statStockAction(dto);
				vo.setStockList(dto.getStockList());
				req.setAttribute("vo", vo);
				req.setAttribute("form", form);
				this.setPaginDTO(req, null);
				return mapping.findForward("REPORT");
			}

		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		return mapping.findForward("DISP");

	}

}
