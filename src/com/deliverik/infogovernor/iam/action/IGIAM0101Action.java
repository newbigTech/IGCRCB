/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0102Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;


/**
 * ������ĿAction����
 *
 * @author
 */
public class IGIAM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0101Action.class);

	/**
	 * ������Ŀ��ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGIAM0102Form form = (IGIAM0102Form)actionForm;
		
		//BLȡ��
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO����
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//�����ҳ��ѯ����
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========�����ѯ������ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
			if ("SEARCH1".equals(mapping.getParameter())){
				form.setIapYear("");
				form.setIapName("");
				form.setIapStatus("");
				form.setIapOpenTimeFrom("");
				form.setIapOpenTimeTo("");
			//���г��β�ѯ����
			} else {
				//���з�ҳ����
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0101");
			//��form��װ��dto��
			dto.setIgIAM0102Form(form);
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);
			//�����Ϣ�����߼�����
			dto = ctlBL.searchIAMAction(dto);
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//����ѯ�����װ��VO��
			vo.setInternalauditprjInfoList(dto.getInternalauditprjInfoList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
			
			log.debug("========�����ѯ��������========");
		}
		//�������Ǽ���������Ŀ����ҳ��ѯ
		if ("HELPSEARCH".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//���г��β�ѯ����
				//���з�ҳ����
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0101");
			//��form��װ��dto��
			dto.setIgIAM0102Form(form);
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);

			//�����Ϣ�����߼�����
			dto = ctlBL.helpSearch(dto);
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			vo.setHelpSearchList(dto.getHelpSearchList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		//�������Ǽ���������Ŀ����ҳ��ѯ
		if ("PROJECTSEARCH".equals(mapping.getParameter())){
			//��form��װ��dto��
			dto.setIgIAM0102Form(form);
			//��ҳ��DTOȡ��
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//���г��β�ѯ����
				//���з�ҳ����
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0101");
			//��form��װ��dto��
			dto.setIgIAM0102Form(form);
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);
			//�����Ϣ�����߼�����
			dto = ctlBL.helpSearch(dto);
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			vo.setHelpSearchList(dto.getHelpSearchList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		//����ȷ�ϳ�ʼ���ͷ���
		if ("QDISP".equals(mapping.getParameter()) || "QBACK".equals(mapping.getParameter())) {
			if ("QDISP".equals(mapping.getParameter())) {
				form.setIapStatus("1");
			} else {
				form.setIapType("0");
			}
			//��ҳ��DTOȡ��
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//���г��β�ѯ����
				//���з�ҳ����
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0101");
			//��form��װ��dto��
			dto.setIgIAM0102Form(form);
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);
			//�����Ϣ�����߼�����
			dto = ctlBL.searchIAMAction(dto);
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//����ѯ�����װ��VO��
			vo.setInternalauditprjInfoList(dto.getInternalauditprjInfoList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		return mapping.findForward("DISP");
	}
}