/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03091VO;

/**
 * 概述: 设备详细信息Action处理
 * 功能描述: 设备详细信息Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGCIM0309Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0309Action.class);

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
		IGCIM0309Form form = (IGCIM0309Form)actionForm;
		
		//BL取得
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO生成
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//设备配置信息登记画面初期显示处理
			log.debug("========设备配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0309");
			
			//DTO输入参数设定
			dto.setIgcim0309Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//设备配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGCIM0309Action(dto);
			
			//将设备配置信息检索结果设定到VO中
			IGCIM03091VO vo = new IGCIM03091VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setSoc0128List(dto.getConfigItemVersionTime());
			super.<IGCIM03091VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","设备配置信息"));
			log.debug("========设备配置信息登记画面初期显示处理终了========");
			saveToken(req);
			forward = "DISP";
			IGCIM0309Form finalform = new IGCIM0309Form();
			BeanUtils.copyProperties(finalform, form);
			req.getSession().setAttribute("ADfinalform", finalform);
			req.setAttribute("eiidValue", form.getEiid());
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
