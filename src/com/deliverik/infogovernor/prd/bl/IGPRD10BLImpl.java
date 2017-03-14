/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG273BL;
import com.deliverik.framework.workflow.prd.bl.task.IG298BL;
import com.deliverik.framework.workflow.prd.bl.task.IG413BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG699BL;
import com.deliverik.framework.workflow.prd.bl.task.IG725BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG156TB;
import com.deliverik.framework.workflow.prd.model.entity.IG222TB;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;
import com.deliverik.infogovernor.prd.form.IGPRD1002Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶���BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD10BLImpl extends BaseBLImpl implements IGPRD10BL{

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGPRD10BLImpl.class);
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/** ���̶���BL */
	protected IG222BL ig222BL;
	/** ���̶���BL */
	protected IG298BL ig298BL;
	/**���̲����߶���ҵ���߼�����BL*/
	protected IG560BL ig560BL;
	
	/** ���̶���BL */
	protected IG273BL ig273BL;

	/**
	 * @param ig273bl the ig273BL to set
	 */
	public void setIg273BL(IG273BL ig273bl) {
		ig273BL = ig273bl;
	}


	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}


	public void setIg298BL(IG298BL ig298bl) {
		ig298BL = ig298bl;
	}

	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}


	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	
	/**
	 * ���̶�����Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchLastProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("=============���̶�����Ϣ��ѯ������ʼ===============");
		//ʵ������ѯ���� zx
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		this.copyProperties(cond, dto.getForm());
		int totalCount = workFlowDefinitionBL.getProcessDefinitionSearchLastCount(cond);
		
		if (totalCount == 0) {
			log.debug("========���̶�����Ϣ��ѯ���ݲ�����========");
			//���̶�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���̶�����Ϣ��ѯ���ݼ�������========");
			//���̶�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		//��ǰҳ���̶�����Ϣȡ��
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchLastProcessDefinition(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setProcessDefinitionList(processDefinitionList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("=============���̶�����Ϣ��ѯ��������===============");
		return dto;
	}
	
	/**
	 * �������̶�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO initProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("=============�������̶�����Ϣ������ʼ=============");
		//dto����ȡ��
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			IG699BL ig699BL = (IG699BL) WebApplicationSupport.getBean("ig699BL");
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			//ȡ�����̶���ID
			String pdid = form.getPdid();
			//ƴ��xml
			Document doc = DocumentHelper.createDocument();
			//��ʼ�����̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			Element rootElement = DocumentHelper.createElement("WebFlow");
			Element rootBase = DocumentHelper.createElement("BaseProperties");
			rootBase.addAttribute("flowId", pd.getPdid());
			rootBase.addAttribute("flowText", pd.getPdname());
			rootElement.add(rootBase);
			//��ʼ�����ɽڵ�
			IG233SearchCondImpl assignCond = new IG233SearchCondImpl();
			assignCond.setPdid(pdid);
			List<IG233Info> assignList = workFlowDefinitionBL.searchAssignedDefInfo(assignCond);
			Map<String, List<IG233Info>> assignMap = new HashMap<String, List<IG233Info>>();
			for(IG233Info info:assignList){
				if(assignMap.get(info.getPsdid()) == null){
					assignMap.put(info.getPsdid(), new ArrayList<IG233Info>());
				}
				assignMap.get(info.getPsdid()).add(info);
			}
			//��ʼ����ť
			IG725SearchCondImpl psbCond = new IG725SearchCondImpl();
			psbCond.setPdbdid_like(pdid);
			List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(psbCond);
			Map<String, Map<String, IG725Info>> psbMap = new HashMap<String,  Map<String, IG725Info>>();
			for(IG725Info info:psbList){
				if(psbMap.get(info.getPsdid()) == null){
					psbMap.put(info.getPsdid(), new HashMap<String, IG725Info>());
				}
				psbMap.get(info.getPsdid()).put(info.getPbdid(), info);
			}
			//��ʼ���ڵ㶨����Ϣ
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(pdid);
			//��Ӧ����������ڵ�������Ӧ����ʶ
			psdCond.setDrmSign("drm");
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			Element steps = DocumentHelper.createElement("Steps");
			for(IG333Info info:psdList){
				Element step = DocumentHelper.createElement("Step");
				Element stepBase = DocumentHelper.createElement("BaseProperties");
				stepBase.addAttribute("id", info.getPsdid());
				stepBase.addAttribute("text", info.getPsdname());
				stepBase.addAttribute("ppsdid", info.getPpsdid());
				if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "EndStep");
				}else if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "BeginStep");
				}else if(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "EndStep");
				}else{
					stepBase.addAttribute("stepType", "NormalStep");
				}
				//����Ǵ�����ڵ�����ʱ���ó�0
				if("������".equals(info.getPsdname())){
					stepBase.addAttribute("bysequence","0");
				}else{
					stepBase.addAttribute("bysequence",info.getBysequence());
				}
				
				step.add(stepBase);
				Element baseInfo = DocumentHelper.createElement("BasicInfo");
				//����ԾǨ����
				IG699SearchCondImpl ig699Cond = new IG699SearchCondImpl();
				ig699Cond.setPsdid(info.getPsdid());
				List<IG699Info> ig699InfoList = ig699BL.searchIG699Info(ig699Cond);
				if(ig699InfoList!=null && ig699InfoList.size()>0){
					for(IG699Info ig699Info:ig699InfoList){
						IG007Info ig007Info = ig007BL.searchIG007InfoByKey(ig699Info.getPidid());
						if(ig007Info!=null&&ig007Info.getPidname().equals("ԾǨ����")){
							baseInfo.addAttribute("ig007Entity", "true");
						}
					}
				}
				addInfo(baseInfo,info);
				step.add(baseInfo);
				List<IG233Info> list = assignMap.get(info.getPsdid());
				if(list != null){
					Element psbs = DocumentHelper.createElement("AssignList");
					for(IG233Info psb:list){
						Element button = DocumentHelper.createElement("AssignInfo");
						addInfo(button,psb);
						psbs.add(button);
					}
					
					step.add(psbs);
				}
				
				//������
				IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
				ig222Cond.setPsdid(info.getPsdid());
				List<IG222Info> parList = workFlowDefinitionBL.searchParticipantDef(ig222Cond);
				if(parList != null){
					Element psbs = DocumentHelper.createElement("Participants");
					for(IG222Info psb:parList){
						Element roleInfo = DocumentHelper.createElement("role");
						addInfo(roleInfo,psb);
						psbs.add(roleInfo);
					}
					step.add(psbs);
				}
				
				
				steps.add(step);
			}
			
			rootElement.add(steps);
			IG273SearchCondImpl pstCond = new IG273SearchCondImpl();
			pstCond.setPtdid_like(pdid);
			List<IG273Info> pstList = workFlowDefinitionBL.searchProcessTransitionDef(pstCond);
			Element actions = DocumentHelper.createElement("Actions");
			Element buttons = DocumentHelper.createElement("Buttons");
			for(IG273Info info:pstList){
			 	Element action = DocumentHelper.createElement("Action");
				Element actionBase = DocumentHelper.createElement("BaseProperties");
				actionBase.addAttribute("id", IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH + info.getPtdid());
				actionBase.addAttribute("actionType", "PolyLine");
				actionBase.addAttribute("from", info.getFpsdid());
				actionBase.addAttribute("to", info.getTpsdid());
				actionBase.addAttribute("ppsdid", info.getFingerPrint());
				
				action.add(actionBase);
				Element rules = DocumentHelper.createElement("Rules");
				rules.addAttribute("ptdname", info.getPtdname());
				rules.addAttribute("ptddesc", info.getPtddesc());
				rules.addAttribute("ptdtype", info.getPtdtype());
				rules.addAttribute("ptdcond", info.getPtdcond());
				Map<String, IG725Info> map = psbMap.get(info.getFpsdid());
				if(map != null){
					if(StringUtils.isNotEmpty(info.getPtdcond())){
						String[] split = info.getPtdcond().split("!");
						if(split.length > 1){
							String pbid = split[1].split("#")[0];
							IG725Info pb = map.get(pbid);
							if(pb != null&&!"�л�����".equals(pb.getPdbdname())){
								rules.addAttribute("pbname", pb.getPdbdname());
							}
						}
					}
					//��ȡ�л�������ť
					if(map.get("15")!=null){
						IG725Info pb = map.get("15");
						Element button = DocumentHelper.createElement("Button");
						button.addAttribute("psdid", pb.getPsdid());
						buttons.add(button);
					}
				}
				action.add(rules);
				actions.add(action);
			}
			rootElement.add(actions);
			rootElement.add(buttons);
			doc.setRootElement(rootElement);
			addOtherInfo(doc,pd);
			form.setXml(doc.asXML());
		}
		log.debug("=============�������̶�����Ϣ��������=============");
		return dto;
	}

	@SuppressWarnings("unchecked")
	private void addOtherInfo(Document doc, IG380Info pd) {
		if(StringUtils.isNotEmpty(pd.getPdxml())){
			try {
				Document flowXml = DocumentHelper.parseText(pd.getPdxml());
				Element root = flowXml.getRootElement();
				Map<String, Element> stepMap = new HashMap<String, Element>();
				Map<String, Element> actionMap = new HashMap<String, Element>();
				for(Iterator<Element> steps = root.element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					stepMap.put(psdid, element);
				}
				for(Iterator<Element> actions = root.element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					actionMap.put(ptdid, element);
				}
				for(Iterator<Element> steps = doc.getRootElement().element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					Element e = stepMap.get(psdid);
					Element vml = DocumentHelper.createElement("VMLProperties");
					vml.addAttribute("width", "50");
					vml.addAttribute("height", "80");
					if(e != null){
						Element rvml = e.element("VMLProperties");
						vml.addAttribute("x", rvml.attributeValue("x"));
						vml.addAttribute("y", rvml.attributeValue("y"));
					}
					element.add(vml);
				}
				for(Iterator<Element> actions = doc.getRootElement().element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					Element e = actionMap.get(ptdid);
					if(e != null){
						List<Element> list = e.elements("point");
						if(list != null){
							for(Element p:list){
								Element point = DocumentHelper.createElement("point");
								point.addAttribute("id", p.attributeValue("id"));
								point.addAttribute("x", p.attributeValue("x"));
								point.addAttribute("y", p.attributeValue("y"));
								element.add(point);
							}
						}
					}
				}
			} catch (DocumentException e) {
				log.error("",e);
			}
		}
	}


	private void addInfo(Element other, Object info) {
		Class<? extends Object> clz = info.getClass();
		Field[] fields = clz.getDeclaredFields();
		
		for(Field f:fields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
		//�����е����� - fingerprint
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		for(Field f:superFields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
	}
	
	private void parseInfo(Element e,Object o) throws BLException{
		Class<? extends Object> clz = o.getClass();
		//baseAction ����
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		//��ǰ���е�����
		Field[] fields = Arrays.copyOf(clz.getDeclaredFields(), clz.getDeclaredFields().length+superFields.length);
		//�������е��������ӵ����������� ����������  ���������鿪ʼ���� ������������ ����������ŵ�λ��  ����������ĳ���
		System.arraycopy(superFields, 0, fields, fields.length-superFields.length, superFields.length);
		
		for(Field f:fields){
			f.setAccessible(true);
			String ev = e.attributeValue(f.getName());
			ev = nullToEmpty(ev);
			String type = f.getType().toString();
			Object value = null;
			try{
				if(type.endsWith("java.lang.String")){
					value = ev;
				}else if(type.endsWith("java.lang.Integer")){
					if(!"".equals(ev)){
						value = Integer.valueOf(ev);
					}
				}else if(type.endsWith("java.lang.Double")){
					value = Double.valueOf(ev);
				}
				f.set(o, value);
			}catch (Exception ex) {
				log.error("",ex);
			}
		}
		
	}

	/**
	 * �������̶������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGPRD10DTO changeProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("================�������̶��������ʼ=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			IG699BL ig699BL = (IG699BL) WebApplicationSupport.getBean("ig699BL");
			try {
				Document doc = DocumentHelper.parseText(form.getXmlValue());
				//ȡ�ø��ڵ�
				Element root = doc.getRootElement();
				String pdid = root.element("BaseProperties").attributeValue("flowId");
				// ɾ��Ȩ��
				IG699SearchCondImpl ig699Cond = new IG699SearchCondImpl();
				ig699Cond.setPdvid_like(pdid);
				List<IG699Info> ig699InfoList = ig699BL.searchIG699Info(ig699Cond);
				if (ig699InfoList != null && ig699InfoList.size() > 0) {
					for (IG699Info ig699Info : ig699InfoList) {
						ig699BL.deleteIG699Info(ig699Info);
					}
				}
				//ɾ��007�����õ�ԾǨ����
				IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
				ig007Cond.setPdid(pdid);
				ig007Cond.setPidname("ԾǨ����");
				List<IG007Info> ig007InfoList = ig007BL.searchIG007Info(ig007Cond, 0, 0);
				if(ig007InfoList!=null && ig007InfoList.size()>0){
					for(IG007Info ig007Info:ig007InfoList){
						ig007BL.deleteIG007Info(ig007Info);
					}
					
				}
				IG380TB pdTB = (IG380TB) workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
				//��ѯ���нڵ�
				IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
				psdCond.setPdid(pdid);
				List<IG333Info> psds = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
				Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();
				for(IG333Info info:psds){
					psdMap.put(info.getPsdid(), info);
				}
				//ȡ�����нڵ���Ϣ
				List<IG333TB> psdList = new ArrayList<IG333TB>(); 
				for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
					Element step = steps.next();
					Element base = step.element("BasicInfo");
					if(base != null){
						IG333TB psd = new IG333TB();
						parseInfo(base, psd);
						psdList.add(psd);
					}
				}
				//���ݿ����ӽڵ���Ϣ
				if(psdList.size() > 0){
					for(IG333TB tb : psdList){
						//PPSDID���Լ��BUG��� ��PPSDID Ϊ���ַ���ʱ��Ҫת��ΪNULL
						if(StringUtils.isEmpty(tb.getPpsdid())){
							tb.setPpsdid(null);
						}
						workFlowDefinitionBL.registProcessStatus(tb);
						IG333Info info = psdMap.get(tb.getPsdid());
						if(info != null){
							psdMap.remove(info.getPsdid());
						}
					}
				}
				
				//���ӽڵ��������Ϣ
				//������Ϣ
				List<IG233TB> assignList = new ArrayList<IG233TB>();
				//ɾ�� ��ǰ���̶����µ�����״̬���� Ĭ��ֵ
				IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
				ig560Cond.setPsdid_l(pdid);
				ig560Cond.setUsedToAll("F");
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				for(IG560Info info:ig560List){
					ig560BL.deleteIG560ByPK(info.getDvid());
				}
				
				//��յ�ǰ���̵����нڵ��ǰ����
				IG413BL ig413BL = (IG413BL) WebApplicationSupport.getBean("ig413BL");
				IG413SearchCondImpl cond = new IG413SearchCondImpl();
				cond.setPdid(pdid);
				List<IG413Info> ig413Lst = ig413BL.searchIG413Info(cond);
				for(IG413Info info:ig413Lst){
					ig413BL.deleteIG413Info(info.getPedid());
				}
				//����״̬�ڵ�
				for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
					Element step = steps.next();
					Element base = step.element("BasicInfo");
					//��ǰ�ڵ�psdid
					String curPsdid = base.attributeValue("psdid");
					//������Ϣlist
					Element assignLst = step.element("AssignList");
					if(null!=assignLst){
						for(Iterator<Element> assignIter = step.element("AssignList").elementIterator("AssignInfo");assignIter.hasNext();){
							Element next = assignIter.next();
							IG233TB assign = new IG233TB();
							parseInfo(next, assign);
							assignList.add(assign);
						}
					}
					//״̬������Ϣ
					Element stepForm = step.element("StepForm");
					if(null!=stepForm){
						int index = 0;
						for(Iterator<Element> stepFormIter = step.element("StepForm").elementIterator("FormInfo");stepFormIter.hasNext();){
							index++;
							Element next = stepFormIter.next();
							next.attributeValue("pidtype");
							IG560TB ig560tb = new IG560TB();
							parseInfo(next, ig560tb);
							ig560tb.setUsedtoall("F");
							//ȥ������
//							if("F".equals(next.attributeValue("pidtype"))){
//								//20150324195106851000000000000002_#_�½��ı��ĵ�.txt
//								ig560tb.setDfvalue(ig560tb.getDfvalue().split("_#_")[0]);	
//							}
							if(!"F".equals(next.attributeValue("pidtype"))){
								//�ʲ�����
								if("4".equals(next.attributeValue("pidtype")) &&ig560tb.getPsdid().lastIndexOf("002") != 7){
									if(StringUtils.isNotBlank(ig560tb.getDfvalue()) && ig560tb.getDfvalue().split("_EIID_").length > 1 && ig560tb.getDfvalue().split("_EIID_")[1].split("_SOC_").length > 1){
										ig560tb.setDfvalue(ig560tb.getDfvalue().split("_EIID_")[0]+"_SOC_"+ig560tb.getDfvalue().split("_EIID_")[1].split("_SOC_")[1]);
									}
									
								}
								//���˵��رսڵ�
								if(ig560tb.getPsdid().lastIndexOf("002") != 7){
									ig560BL.registIG560(ig560tb);
								}
							}
							
						}
					}
					//����ԾǨ��������
					Element ig007Entity = step.element("ig007Entity");
					if(null!=ig007Entity){
						IG007TB ig007TB = new IG007TB();
						ig007TB.setPidid(ig007Entity.attributeValue("pidid"));
						ig007TB.setPdid(ig007Entity.attributeValue("pdid"));
						ig007TB.setPidname(ig007Entity.attributeValue("pidname"));
						ig007TB.setPidlabel(ig007Entity.attributeValue("pidlabel"));
						ig007TB.setPidtype(ig007Entity.attributeValue("pidtype"));
						ig007TB.setPidoption(ig007Entity.attributeValue("pidoption"));
						ig007TB.setPidrequired(ig007Entity.attributeValue("pidrequired"));
						ig007TB.setPidsortid(ig007Entity.attributeValue("pidsortid"));
						ig007TB.setPidmode("0");
						ig007TB.setRowwidth(ig007Entity.attributeValue("rowwidth"));
						ig007TB.setSelecedlast(ig007Entity.attributeValue("selectedlast"));
						ig007TB.setNumbertype(ig007Entity.attributeValue("numbertype"));
						ig007TB.setShowline(ig007Entity.attributeValue("showline"));
						ig007TB.setRemarks(ig007Entity.attributeValue("remarks"));
						ig007TB.setShowstyles(ig007Entity.attributeValue("showstyles"));
						ig007TB.setTitledisplay(ig007Entity.attributeValue("titledisplay"));
						ig007TB.setPidrows(Integer.parseInt(ig007Entity.attributeValue("pidrows")));
						ig007TB.setPidwidth(Integer.parseInt(ig007Entity.attributeValue("pidwidth")));
						ig007TB.setPiduse(ig007Entity.attributeValue("piduse"));
						ig007TB.setNeedidea(ig007Entity.attributeValue("needidea"));
						ig007TB.setPidratio(ig007Entity.attributeValue("pidratio"));
						ig007TB.setPidsize(Integer.parseInt(ig007Entity.attributeValue("pidsize")));
						ig007TB.setHasattach(ig007Entity.attributeValue("hasattach"));
						ig007TB.setShowrownum(ig007Entity.attributeValue("showrownum"));
						ig007BL.registIG007Info(ig007TB);
						String stepId = ig007Entity.attributeValue("stepId");
						
						IG699TB ig699TB = new IG699TB();
						ig699TB.setPidid(ig007TB.getPidid());
						ig699TB.setPdvid(stepId+ig007TB.getPidid().substring(ig007TB.getPidid().length()-3, ig007TB.getPidid().length()));
						ig699TB.setPidrequired("1");
						ig699TB.setPsdid(stepId);
						ig699TB.setPidaccess("3");
						ig699BL.registIG699Info(ig699TB);
					}
					
					//ɾ����������Ϣ
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(curPsdid);
					List<IG222Info>	ig222List = ig222BL.searchIG222Info(ig222cond);
					for(IG222Info delInfo:ig222List){
						ig222BL.deleteIG222Info(delInfo);
					}
					IG298SearchCondImpl ig298cond = new IG298SearchCondImpl();
					ig298cond.setPsdid(curPsdid);
					List<IG298Info>	ig298List = ig298BL.searchIG298Info(ig298cond);
					for(IG298Info delInfo:ig298List){
						ig298BL.deleteIG298Info(delInfo);
					}
					//������list
					Element participantsLst = step.element("Participants");
					if(null!=participantsLst){
						for(Iterator<Element> roleIter = step.element("Participants").elementIterator("role");roleIter.hasNext();){
							Element next = roleIter.next();
							IG222TB participants = new IG222TB();
							parseInfo(next, participants);
							String psdid = next.attributeValue("psdid");
							Integer roleid = Integer.valueOf(next.attributeValue("roleid"));
							participants.setPpdid(workFlowDefinitionBL.getParticipantDefPK(psdid));
							ig222BL.registIG222Info(participants);
							workFlowDefinitionBL.registParticipantDef(participants);
							
							IG298Info psrdInfo = workFlowDefinitionBL.checkProcessStatusRoleDefInfo(psdid,roleid);
							if(psrdInfo == null) {
								IG298TB psrdTB = new IG298TB();
								psrdTB.setPsrdid(workFlowDefinitionBL.getProcessStatusRoleDefInfoPK(psdid));
								psrdTB.setPsdid(psdid);
								psrdTB.setRoleid(1);
								workFlowDefinitionBL.registProcessStatusRoleDefInfo(psrdTB);
							}
						}
					}
					
					// �趨 ������ǰ�����¼�
					IG413TB preTB = new IG413TB();
					preTB.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
					preTB.setPdid(pdid);
					preTB.setPsdid(curPsdid);
					preTB.setPedtype("1");//ǰ����
					preTB.setPedblid("igDRMEVENT0103BL");
					preTB.setPedorder(2);
					ig413BL.registIG413Info(preTB);
//					workFlowDefinitionBL.registWorkFlowEventHandler(preTB);
					
					// �趨 ������ǰ�����¼����ж��Ƿ�Ϊ�رսڵ㣬ֹͣʱ�䣩
//					IG413TB preTB1 = new IG413TB();
//					preTB1.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
//					preTB1.setPdid(pdid);
//					preTB1.setPsdid(curPsdid);
//					preTB1.setPedtype("1");//ǰ����
//					preTB1.setPedblid("igDRMEVENT0103BL");
//					preTB1.setPedorder(1);
//					ig413BL.registIG413Info(preTB1);
//					workFlowDefinitionBL.registWorkFlowEventHandler(preTB1);
					
					//�趨 ������������ڵ�Ĵ�����
					IG413TB preTB2 = new IG413TB();
					preTB2.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
					preTB2.setPdid(pdid);
					preTB2.setPsdid(curPsdid);
					preTB2.setPedtype("1");// ǰ����
					preTB2.setPedblid("igDRMEVENT0301BL");
					preTB2.setPedorder(1);
					ig413BL.registIG413Info(preTB2);
//					workFlowDefinitionBL.registWorkFlowEventHandler(preTB2);
					
					
					IG413TB flagTB = new IG413TB();
					flagTB.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
					flagTB.setPdid(pdid);
					flagTB.setPsdid(curPsdid);
					flagTB.setPedtype("2");//����
					flagTB.setPedblid("igDRMEVENT0103BL");
					flagTB.setPedorder(1);
					ig413BL.registIG413Info(flagTB);
//					workFlowDefinitionBL.registWorkFlowEventHandler(flagTB);
					
					//������ͼ�в���Ҫ��Ԫ��ɾ��
					step.remove(base);
					step.remove(step.element("AssignList"));
					step.remove(step.element("attInfo"));
					step.remove(step.element("Participants"));
					step.remove(step.element("StepForm"));
				}
				//psdFlag 0����ͨ�ڵ� 1����ʼ�͹رսڵ�
				if(psdList.size() > 0){
					for(IG333TB tb : psdList){
						String psdFlag = "0";
						//psdFlag 0����ͨ�ڵ� 1����ʼ�͹رսڵ� ZC
						if("Z".equals(tb.getPsdcode())||"C".equals(tb.getPsdcode())||"B".equals(tb.getPsdcode())){
							psdFlag = "1";
						}
						//�趨��ťȨ��
						insertProcessDefaultButtonDef(tb.getPsdid(),psdFlag);
					}
				}
				if(assignList.size() > 0){
					for(IG233TB tb : assignList){
						workFlowDefinitionBL.registAssignedDefInfo(tb);
					}
				}
				
				//ɾ��������
				IG273SearchCondImpl ig273cond = new IG273SearchCondImpl();
				ig273cond.setPtdid_like(pdid);
				List<IG273Info>	ig273List = ig273BL.searchIG273Info(ig273cond);
				for(IG273Info delInfo:ig273List){
					ig273BL.deleteIG273Info(delInfo);
				}
				//����������
				for(Iterator<Element> actions = root.element("Actions").elementIterator("Action");actions.hasNext();){
					Element action = actions.next();
					Element base = action.element("BaseProperties");
					Element rules = action.element("Rules");
					IG273TB rTB = new IG273TB();
					rTB.setPtdid(base.attributeValue("id").substring(1));
					rTB.setFpsdid(base.attributeValue("from"));
					rTB.setTpsdid(base.attributeValue("to"));
					rTB.setFingerPrint(base.attributeValue("ppsdid"));
					if(null!=rules){
						rTB.setPtdname(rules.attributeValue("ptdname"));
						rTB.setPtddesc(rules.attributeValue("ptddesc"));
						rTB.setPtdtype(rules.attributeValue("ptdtype"));
						rTB.setPtdcond(rules.attributeValue("ptdcond"));
					}
					workFlowDefinitionBL.registProcessTransitionDef(rTB);
					action.remove(rules);
				}
				for(Iterator<Entry<String, IG333Info>> iter = psdMap.entrySet().iterator();iter.hasNext();){
					Entry<String, IG333Info> entry = iter.next();
					workFlowDefinitionBL.deleteProcessStatusDefByPK(entry.getValue().getPsdid());
				}
				pdTB.setPdxml(doc.asXML());
				workFlowDefinitionBL.updateProcessDefinition(pdTB);
				//�����л�������ťȨ��
				IG725BL ig725BL = (IG725BL) WebApplicationSupport.getBean("ig725BL");
				IG725SearchCondImpl ig725CondImpl = new IG725SearchCondImpl();
				ig725CondImpl.setPdbdid_like(pdid);
				List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(ig725CondImpl);
				if(psbList!=null && psbList.size()>0){
					for(IG725Info ig725Info:psbList){
						if("�л�����".equals(ig725Info.getPdbdname())){
							ig725BL.deleteIG725Info(ig725Info);
						}	
					}
				}
				for(Iterator<Element> buttons = root.element("Buttons").elementIterator("Button");buttons.hasNext();){
					Element button = buttons.next();
					IG725TB ig725TB = new IG725TB();
					ig725TB.setPdbdid(button.attributeValue("psdid")+"003");
					ig725TB.setPsdid(button.attributeValue("psdid"));
					ig725TB.setPbdid("15");
					ig725TB.setPdbdname("�л�����");
					ig725TB.setPdbddesc("�л�����");
					ig725TB.setPdbdauth("0");
					ig725TB.setCheckrequired("0");
					ig725TB.setCheckrecord("0");
					ig725TB.setActurl("switchMaster");
					ig725BL.registIG725Info(ig725TB);
				}

			} catch (Exception e) {
				log.debug("=======���泡���������========");

				e.printStackTrace();

				throw new BLException("IGCO10000.E141", "���泡������");

			}
		}
		log.debug("================�������̶����������=================");
		return dto;
	}
	
	/**
	 * ȡ�ýڵ㰴ť��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchProcessStepButtonAction(IGPRD10DTO dto) throws BLException {
		log.debug("==============�ڵ㰴ť��Ϣȡ�ò�����ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			//��ʼ����ť
			IG725SearchCondImpl psbCond = new IG725SearchCondImpl();
			psbCond.setPdbdid_like(form.getPsdid());
			List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(psbCond);
			//ƴ��xml
			Document doc = DocumentHelper.createDocument();
			Element root = DocumentHelper.createElement("Buttons");
			for(IG725Info info:psbList){
				Element b = DocumentHelper.createElement("Button");
				addInfo(b, info);
				root.add(b);
			}
			doc.setRootElement(root);
			dto.setAjaxResult(doc.asXML());
		}
		log.debug("==============�ڵ㰴ť��Ϣȡ�ò�������==============");
		return dto;
	}

	/**
	 * �趨��ťȨ��-�Ͱ�ťBL
	 * @param psdid
	 * @param psdFlag 0����ͨ�ڵ� 1����ʼ�͹رսڵ�
	 * @throws BLException
	 */
	private void insertProcessDefaultButtonDef(String psdid,String psdFlag) throws BLException {
		
		// �趨��ťȨ��
		//��������������ýڵ�ԭ���İ�ťȨ��
		IG725TB pdbdTB = new IG725TB();
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		List<IG725Info> infoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(cond);
		for(int i=0;i<infoList.size();i++){
			workFlowDefinitionBL.deleteParticipantDefaultButtonDefByKey(infoList.get(i).getPdbdid());
		}
		//��������������ýڵ�ԭ���İ�ťȨ��
		//��������������ýڵ�ԭ������ֹ��ť����BL
		IG156SearchCondImpl ig156Cond = new IG156SearchCondImpl();
		ig156Cond.setPsdid(psdid);
		List<IG156Info> ig156List = workFlowDefinitionBL.searchProcessStatusButtonDef(ig156Cond);
		for(int i=0;i<ig156List.size();i++){
			workFlowDefinitionBL.deleteProcessStatusButtonDefByPK(ig156List.get(i).getPseid());
		}
		//��������������ýڵ�ԭ������ֹ��ť����BL
		
		//�ύ��ť
		pdbdTB.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psdid));
		pdbdTB.setPsdid(psdid);
		pdbdTB.setPbdid("10");
		pdbdTB.setPdbdname("�ύ");
		pdbdTB.setPdbddesc("�ύ");
		pdbdTB.setPdbdauth("0");
		pdbdTB.setCheckrequired("1");
		pdbdTB.setCheckrecord("0");
		workFlowDefinitionBL.registParticipantDefaultButtonDef(pdbdTB);
		
		//�Ƿ���͹رսڵ�������ֹ��ť�Ͱ�ťBL
		if("0"==psdFlag){
			//�Զ�����ֹ��ť
			pdbdTB.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psdid));
			pdbdTB.setPsdid(psdid);
			pdbdTB.setPbdid("14");
			pdbdTB.setPdbdname("��ֹ");
			pdbdTB.setPdbddesc("��ֹ");
			pdbdTB.setPdbdauth("0");
			pdbdTB.setCheckrequired("1");
			pdbdTB.setCheckrecord("0");
			workFlowDefinitionBL.registParticipantDefaultButtonDef(pdbdTB);
			
			// �趨��ֹ��ť�¼�
			IG156TB spseTB = new IG156TB();
			spseTB.setPseid(workFlowDefinitionBL.getProcessStatusButtonDefPK(psdid));
			spseTB.setPdid(psdid.substring(0, 7));
			spseTB.setPsdid(psdid);
			spseTB.setPsebuttonid("14");
			spseTB.setPseactionid("igDRMBTN0103BL");
			spseTB.setPseorder(1); 
			spseTB.setPsbdname("��ֹ");
			workFlowDefinitionBL.registProcessStatusButtonDef(spseTB);
			
			// �趨���水ť�¼�
			IG156TB updateTB = new IG156TB();
			updateTB.setPseid(workFlowDefinitionBL.getProcessStatusButtonDefPK(psdid));
			updateTB.setPdid(psdid.substring(0, 7));
			updateTB.setPsdid(psdid);
			updateTB.setPsebuttonid("01");
			updateTB.setPseactionid("igDRMBTN0104BL");
			updateTB.setPseorder(1); 
			updateTB.setPsbdname("����");
			workFlowDefinitionBL.registProcessStatusButtonDef(updateTB);
		}
	}
	
	/**
	 * null->""
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String nullToEmpty(String str) throws BLException{
		if(null==str){
			str = "";
		}	
		return str;
	}
	
}