/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserRoleVW;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG212BL;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.bl.task.IG893BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupEventBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupProcessLaunchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowJspHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowMessageGeneratorBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowThreadEventHandlerBLImpl;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.bl.task.CurrentMonthWorkVWBL;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG113BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG463BL;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG485BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG505BL;
import com.deliverik.framework.workflow.prr.bl.task.IG506BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG711BL;
import com.deliverik.framework.workflow.prr.bl.task.IG715BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.bl.task.IG899BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.util.ComputingTime;

/**
 * <p>
 * ���̴���ҵ���߼�ʵ��
 * </p>
 * 
 */

public class WorkFlowOperationBLImpl extends BaseBLImpl implements WorkFlowOperationBL {
	
	private static Log log = LogFactory.getLog(WorkFlowOperationBLImpl.class);
	
	// ���ο���log
	private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
	
	/** ������Ϣ���� */
	private IG500BL ig500BL;
	
	/** ���̱������� */
	private IG599BL ig599BL;

	/** ��������Ϣ���� */
	private IG337BL ig337BL;

	/** ��־��Ϣ���� */
	private IG036BL ig036BL;

	/** �ϴ�������Ϣ���� */
	private FileUploadBL fileUploadBL;

	/** ������Ϣ���� */
	private AttachmentBL attachmentBL;
	
	/** �û���ɫ���� */
	private UserRoleBL userRoleBL;
	
	/** ��ɫ���� */
	private RoleBL roleBL;
	
	/** �û����� */
	private UserBL userBL;
	
	/** ���̶�����Ϣ���� */
	private WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ���̹�ϵ��Ϣ���� */
	private IG512BL ig512BL;
	
	/** ����״̬��־��Ϣ����*/
	protected IG224BL ig224BL;
	
	/** ����״̬��־��Ϣ����*/
	protected IG113BL ig113BL;
	
	/** ���̲����߱���Ȩ����ͼ*/
	protected IG893BL ig893BL;
	
	/** �����ʲ���ϵ */
	private IG731BL ig731BL;
	
	/** �����ʲ���ϵ */
	private IG105BL ig105BL;
	
	/** ����˽�б��� */
	protected IG899BL ig899BL;

	/** ����֪ͨ�����趨BL */
	protected IG212BL ig212BL;
	
	/** ����BL */
	protected SendMessageBL sendMessageBL;
	
	/** �ʼ�BL */
	protected SendMailBL sendMailBL;
	
	protected CodeListUtils codeListUtils;
	
	/** ����BL */
	protected OrganizationBL organizationBL;

	/** ��ѯ���е�ǰ�����˵ı��¹���BL */
	protected CurrentMonthWorkVWBL currentMonthWorkVWBL;
	
	/** ���������ֵBL */
	protected IG505BL ig505BL;
	
	/** ����ʽ����ֵBL */
	protected IG898BL ig898BL;
	
	/** ��Ա����ֵBL */
	protected IG506BL ig506BL;
	
	/** ���̹�����ϵBL */
	protected IG715BL ig715BL;
	
	/**���񹤵�ҵ��BL*/
	protected IG933BL ig933BL;
	
	/**��������BL*/
	protected IG463BL ig463BL;
	
	/**�û���ȨBL*/
	protected IG711BL ig711BL;
	
	/**�������ϵ����BL*/
	protected IG482BL ig482BL;
	
	/**������ʵ��BL*/
	protected IG483BL ig483BL;
	
	/**�������Աʵ��BL*/
	protected IG484BL ig484BL;
	
	/**�������ϵʵ��BL*/
	protected IG485BL ig485BL;
	
	/**״̬��˽�б���Ĭ��ֵBL*/
    protected IG560BL ig560BL;
    
    /**״̬��˽�б���ֵ��*/
    protected IG561BL ig561BL;
	
	/**
	 * <p>
	 * ��ѯ���е�ǰ�����˵ı��¹���BL�趨
	 * <p>
	 * 
	 * @param currentMonthWorkVWBL ��ѯ���е�ǰ�����˵ı��¹���BL 
	 */
	public void setCurrentMonthWorkVWBL(CurrentMonthWorkVWBL currentMonthWorkVWBL) {
		this.currentMonthWorkVWBL = currentMonthWorkVWBL;
	}

	/**
	 * <p>
	 * ����BL�趨
	 * <p>
	 * 
	 * @param organizationBL ����BL 
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * <p>
	 * ��������״̬��־��Ϣ
	 * <p>
	 * 
	 * @param ig222BL ����״̬��־��Ϣ
	 */
	public void setIg113BL(IG113BL ig113BL) {
		this.ig113BL = ig113BL;
	}
	
	/**
	 * <p>
	 * ����������Ϣ����
	 * <p>
	 * 
	 * @param ig500BL ������Ϣ����
	 */
	
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	
	/**
	 * <p>
	 * �������̱�����Ϣ����
	 * <p>
	 * 
	 * @param ig599BL ���̱�����Ϣ����
	 */
	
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}
	
	/**
	 * <p>
	 * ���ò�������Ϣ����
	 * <p>
	 * 
	 * @param ig337BL ��������Ϣ����
	 */
	
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}
	
	/**
	 * <p>
	 * ������־��Ϣ����
	 * <p>
	 * 
	 * @param ig036BL ��־��Ϣ����
	 */
	
	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	/**
	 * <p>
	 * �����ϴ�������Ϣ����
	 * <p>
	 * 
	 * @param fileUploadBL �ϴ�������Ϣ����
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * <p>
	 * ���ø�����Ϣ����
	 * <p>
	 * 
	 * @param attachmentBL ������Ϣ����
	 */
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * <p>
	 * �����û���ɫ����
	 * <p>
	 * 
	 * @param userRoleVWBL �û���ɫ����
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * <p>
	 * ���ý�ɫ����
	 * <p>
	 * 
	 * @param roleBL ��ɫ����
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * <p>
	 * �������̶�����Ϣ����
	 * <p>
	 * 
	 * @param workFlowDefinitionBL ���̶�����Ϣ����
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * <p>
	 * �������̹�ϵ��Ϣ����
	 * <p>
	 * 
	 * @param ig512BL ���̹�ϵ��Ϣ����
	 */
	public void setIg512BL(
			IG512BL ig512BL) {
		this.ig512BL = ig512BL;
	}
	
	/**
	 * <p>
	 * ��������״̬��Ϣ����
	 * <p>
	 * 
	 * @param ig224BL ����״̬��Ϣ����
	 */
	public void setIg224BL(IG224BL ig224BL) {
		this.ig224BL = ig224BL;
	}
	
	/**
	 * <p>
	 * �����û�BL����
	 * <p>
	 * 
	 * @param userBL �û�BL����
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * <p>
	 * �������̲����߱���Ȩ����ͼ����
	 * <p>
	 * 
	 * @param ig893BL���̲����߱���Ȩ����ͼ����
	 */
	public void setIg893BL(IG893BL ig893BL) {
		this.ig893BL = ig893BL;
	}

	/**
	 * �����ʲ���ϵ��Ϣ
	 * @param ig731BL �����ʲ���ϵ
	 */
	public void setIg731BL(IG731BL ig731BL) {
		this.ig731BL = ig731BL;
	}
	
	/**
	 * ���̲���BL
	 * @param ig105BL ���̲���BL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}

	/**
	 * <p>
	 * ����˽�б����趨
	 * </p>
	 *
	 * @param ig899BL ����˽�б���
	 */
	public void setIg899BL(IG899BL ig899BL) {
		this.ig899BL = ig899BL;
	}
	
	/**
	 * ����BL�趨
	 * 
	 * @param sendMessageBL ����BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �ʼ�BL�趨
	 * 
	 * @param sendMailBL �ʼ�BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * ����֪ͨ�����趨BL�趨
	 * 
	 * @param ig212BL ����֪ͨ�����趨BL
	 */
	public void setig212BL(
			IG212BL ig212BL) {
		this.ig212BL = ig212BL;
	}
	
	/**
	 * ��������BL�趨
	 * 
	 * @param codeListUtils ��������BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * ���񹤵�ҵ��BL�趨
	 * @param ig933BL ���񹤵�ҵ��BL
	 */
	public void setIg933BL(IG933BL ig933bl) {
		ig933BL = ig933bl;
	}

	/**
	 * ���������ֵBL�趨
	 * @param ig505BL ���������ֵBL
	 */
	public void setIg505BL(IG505BL ig505bl) {
		ig505BL = ig505bl;
	}

	/**
	 * ��������BL�趨
	 * @param ig463BL ��������BL
	 */
	public void setIg463BL(IG463BL ig463bl) {
		ig463BL = ig463bl;
	}

	/**
	 * �û���ȨBL�趨
	 * @param ig711BL �û���ȨBL
	 */
	public void setIg711BL(IG711BL ig711bl) {
		ig711BL = ig711bl;
	}
	
	/**
	 * �������ϵ����BL�趨
	 * @param ig482BL �������ϵ����BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}
	
	/**
	 * ������ʵ��BL�趨
	 * @param ig483BL ������ʵ��BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}
	
	/**
	 * �������Աʵ��BL�趨
	 * @param ig484BL �������Աʵ��BL
	 */
	public void setIg484BL(IG484BL ig484BL) {
		this.ig484BL = ig484BL;
	}
	
	/**
	 * �������ϵʵ��BL�趨
	 * @param ig485BL �������ϵʵ��BL
	 */
	public void setIg485BL(IG485BL ig485BL) {
		this.ig485BL = ig485BL;
	}

	/**
	 * <p>
	 * �µ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ�������Ϣ����ʵ��ȡ��
	 */

	public IG500TB getProcessRecordTBInstance() {
		return ig500BL.getIG500TBInstance();
	}
	
	/**
	 * <p>
	 * �µ����̱�����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ����̱�����Ϣ����ʵ��ȡ��
	 */
	public IG599TB getProcessInfoTBInstance() {
		return ig599BL.getIG599TBInstance();
	}
    public void setIg560BL(IG560BL ig560bl) {
        ig560BL = ig560bl;
    }

    public void setIg561BL(IG561BL ig561bl) {
        ig561BL = ig561bl;
    }	
	
	/**
	 * ��Ա����ֵBL�趨
	 * @param ig506BL ��Ա����ֵBL
	 */
	public void setIg506BL(IG506BL ig506bl) {
		ig506BL = ig506bl;
	}
	
	/**
	 * ���̹�����ϵBL�趨
	 * @param ig715BL ���̹�����ϵBL
	 */
	public void setIg715BL(IG715BL ig715bl) {
		ig715BL = ig715bl;
	}

	/**
	 * <p>
	 * �µ�����˽�б�����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ�����˽�б�����Ϣ����ʵ��ȡ��
	 */
	public IG899TB getProcessPrivateInfoTBInstance() {
		return ig899BL.getIG899TBInstance();
	}

	/**
	 * <p>
	 * �µĲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µĲ�������Ϣ����ʵ��ȡ��
	 */

	public IG337TB getProcessParticipantTBInstance() {
		return ig337BL.getIG337TBInstance();
	}

	/**
	 * <p>
	 * �µ���־��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ���־��Ϣ����ʵ��ȡ��
	 */
	
	public IG036TB getRecordLogTBInstance() {
		return ig036BL.getIG036TBInstance();
	}
	
	/**
	 * <p>
	 * �µ����̹�ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ����̹�ϵ��Ϣ����ʵ��ȡ��
	 */
	
	public IG512TB getProcessRecordRelationTBInstance() {
		return ig512BL.getIG512TBInstance();
	}
	
	/**
	 * ����ʽ����ֵBL�趨
	 * @param ig898BL ����ʽ����ֵBL
	 */
	public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
	}
	
	/**
	 * <p>
	 * ���̷���
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	
	public IG500Info createProcessRecord(IG500Info processRecord, User user, Integer roleid,
			String comment, String desc, Map<Integer, FormFile> filemap, String type, String pbdid, String prstatus)
			throws BLException{
		processRecord = ig500BL.registIG500Info(processRecord);
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}

	/**
	 * <p>
	 * ���̷���
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param participantList ���̲�������ϢList
	 * @param processInfoList ���̱�����ϢList
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */

	public IG500Info createProcessRecord(IG500Info processRecord, List<IG337Info> participantList,
			List<IG599Info> processInfoList, User user, Integer roleid, 
			String comment, String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus)
			throws BLException {
		processRecord = createProcessRecord(processRecord, user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		ig337BL.registIG337Info(participantList);
		if(processInfoList != null && !processInfoList.isEmpty()){
			ig599BL.saveOrUpdIG599Infos(processInfoList);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}

	/**
	 * <p>
	 * ����״̬ԾǨ
	 * </p>
	 * 
	 * @param srcStatus ����ԾǨʱ״̬����Դ״̬
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	
	public synchronized IG500Info updateProcessRecord(String srcStatus,IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrstatus(srcStatus);
		cond.setPrid(processRecord.getPrid());
		List<IG500Info> list = ig500BL.searchIG500Info(cond, 0, 0);
		if(list.size() != 1){
			throw new BLException("IGSVC0000.E001");
		}
		processRecord = ig500BL.updateIG500Info(processRecord);
		
		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// ���������־����, ����
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}
	
	/**
	 * <p>
	 * ������Ϣ���£�״̬���ı�
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */
	
	public IG500Info updateProcessRecord(IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException {
		String currentStatus = ig500BL.searchIG500InfoByKey(processRecord.getPrid()).getPrstatus();
		if(!currentStatus.equals(processRecord.getPrstatus())) {
			throw new BLException("IGSVC0000.E003");
		}
		processRecord = ig500BL.updateIG500Info(processRecord);
		
		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// ���������־����, ����
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}
	
	/**
	 * <p>
	 * ������Ϣ���£�״̬���ı�,����¼��־
	 * </p>
	 * 
	 * @param processRecord ������Ϣ
	 * @return ������Ϣ
	 * @throws BLException
	 *
	 */

	public IG500Info updateProcessRecord(IG500Info processRecord)
			throws BLException {
		String currentStatus = ig500BL.searchIG500InfoByKey(processRecord.getPrid()).getPrstatus();
		if(!currentStatus.equals(processRecord.getPrstatus())) {
			throw new BLException("IGSVC0000.E003");
		}
		return ig500BL.updateIG500Info(processRecord);
	}
	
	/**
	 * <p>
	 * ָ������ID��ѯ������Ϣ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ������Ϣ
	 * @throws BLException 
	 *
	 */
	
	public IG500Info searchProcessRecordByKey(Integer prid) throws BLException {
		return ig500BL.searchIG500InfoByKey(prid);
	}
	
	/**
	 * <p>
	 * ָ�������Ų�ѯ������Ϣ
	 * </p>
	 * 
	 * @param prserialnum ���̹�����
	 * @return ������Ϣ
	 * @throws BLException 
	 *
	 */

	public IG500Info searchProcessRecordBySerialnum(String prserialnum) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrserialnum(prserialnum);
		List<IG500Info> list = ig500BL.searchIG500Info(cond);
		if(list.size() != 1){
			throw new BLException("IGCO10000.E004","������Ϊ" + prserialnum + "������");
		}
		return list.get(0);
	}

	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б�����ҳ��ѯ�ã�
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	
	public List<IG500Info> searchProcessRecord(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.searchIG500Info(cond, start, count);
	}
	
	/**
	 * ���ݼ�����������������������ȡ��������Ϣ�б�����ҳ��ѯ�ã�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count){
		return ig500BL.queryIG500EntityListByProcessInfo(cond, start, count);
	}
	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */

	public List<IG500Info> searchProcessRecord(IG500SearchCond cond) {
		return ig500BL.searchIG500Info(cond);
	}
	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б��������¼�������״̬����ƽ̨������
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	
	public List<IG500Info> searchProcessRecordSubStatusList(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.queryIG500InfoSubStatusList(cond, start, count);
	}
	
	/**
	 * ���ݼ�������ȡ��������Ϣ�б��������¼�������״̬����ƽ̨������
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	
	public List<IG500ONLYInfo> searchProcessRecordONLYSubStatusList(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.queryIG500ONLYInfoSubStatusList(cond, start, count);
	}
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count){
		return ig500BL.searchProcessRecordForSelfDef(cond,start,count);
	}
	
	
	/**
	 * �Զ���������ع�������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond){
		return ig500BL.searchProcessRecordCountForSelfDef(cond);
	}
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count){
		return ig500BL.searchProcessRecordForSelfDef(cond,start,count);
	}
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond){
		return ig500BL.searchProcessRecordCountForSelfDef(cond);
	}
	
	
	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ�����������¼�������״̬����ƽ̨������
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */

	public int getProcessRecordSubStatusSearchCount(IG500SearchCond cond) {
		return ig500BL.queryIG500InfoSubStatusListCount(cond);
	}

	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ�����������¼�������״̬����ƽ̨������
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */

	public int getProcessRecordONLYSubStatusSearchCount(IG500SearchCond cond) {
		return ig500BL.queryIG500ONLYInfoSubStatusListCount(cond);
	}

	/**
	 * <p>
	 * ���ݼ�������ȡ��������Ϣ����
	 * </p>
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */

	public int getProcessRecordSearchCount(IG500SearchCond cond) {
		return ig500BL.getIG500InfoSearchCount(cond);
	}

	/**
	 * <p>
	 * ָ������ID��ѯ���̷�����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param initStatus ���̷���״̬
	 * @return ���̷�������Ϣ
	 *
	 */

	public IG337Info searchProcessOpener(Integer prid,String initStatus) {
		return ig337BL.getProcessOpener(prid,initStatus);
	}
	
	/**
	 * <p>
	 * Description: ��ȡָ��������
	 * </p>
	 * 
	 * @param ppid ������ID
	 * @return ��������Ϣ
	 * @throws BLException 
	 */
	
	public IG337Info searchProcessParticipantByKey(Integer ppid) throws BLException{
		return ig337BL.searchIG337InfoByKey(ppid);
	}

	/**
	 * <p>
	 * ����ָ��״̬�²�ѯδ����������
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return δ������������Ϣ
	 *
	 */
	
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status) {
		return ig337BL.getIG337InfoTodoRoles(prid,status);
	}
	
	/**
	 * <p>
	 * ����ָ��״̬��δ����������ȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ppsubstatus ��������״̬
	 * @return ����ָ��״̬��δ����������
	 *
	 */

	public List<IG337Info> searchProcessParticipantTodoRole(
			Integer prid, String status, String ppsubstatus) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);//����ID
		cond.setPpstatus(status);
		cond.setPpsubstatus(ppsubstatus);
		cond.setPpproctimeIsNull("Y");//δ����
		return ig337BL.getIG337Infos(cond);
	}
	
	/**
	 * <p>
	 * ����ָ��״̬���Ѵ���������ȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ����ָ��״̬���Ѵ���������
	 *
	 */

	public List<IG337Info> searchProcessParticipantDoneRole(
			Integer prid, String status) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpproctimeIsNull("N");
		return ig337BL.getIG337Infos(cond);
	}
	
	/**
	 * <p>
	 * ����ָ��״̬���Ѵ���������ȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ppsubstatus ��������״̬
	 * @return ����ָ��״̬���Ѵ���������
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(
			Integer prid, String status, String ppsubstatus) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpsubstatus(ppsubstatus);
		cond.setPpproctimeIsNull("Y");
		return ig337BL.getIG337Infos(cond);
	}

	/**
	 * <p>
	 * ���̲���������
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,User authorizeuser, String pbdid, String prstatus) throws BLException {
		processParticipant = ig337BL.registIG337Info(processParticipant);

		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// ���������־����, ����
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processParticipant;
	}
	
	/**
	 * <p>
	 * ���̲���������
	 * </p>
	 * @param processParticipant ��������Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant) throws BLException{
		processParticipant = ig337BL.registIG337Info(processParticipant);
		return processParticipant;
	}

	/**
	 * <p>
	 * ���̲�����ɾ��
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public void removeProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type, User authorizeuser, String pbdid, String prstatus) throws BLException {

		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// ���������־����, ����
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		ig337BL.deleteIG337Info(processParticipant);
	}
	/**
	 * <p>
	 * ���̲�����ɾ��
	 * ����¼��־
	 * </p>
	 * @param processParticipant ��������Ϣ
	 * @throws BLException
	 */
	
	public void removeProcessParticipant(IG337Info processParticipant) throws BLException {
		ig337BL.deleteIG337Info(processParticipant);
	}

	/**
	 * <p>
	 * ��������Ϣ���£�״̬���ı�
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public synchronized IG337Info updateProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,List<IG599Info> prInfoList, User authorizeuser, String pbdid, String prstatus) throws BLException {
		//����ʱ��¼�ռ�¼�����ϵͳ��־
		if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(pbdid)) {
			type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
		}
		
		String ppstatus = ig337BL.searchIG337InfoByKey(processParticipant.getPpid()).getPsdid();
		if(!ppstatus.equals(processParticipant.getPsdid())){
			throw new BLException("IGSVC0000.E004");
		}
		processParticipant = ig337BL.updateIG337Info(processParticipant);

		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// ���������־����, ����
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		IG036Info recordLog = addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		
		
		//�ύ���ͷ�ϵͳ��־ʱ����Ҫ��¼������־
		if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type) && prInfoList!=null && !prInfoList.isEmpty()){
			this.addRecordLogVarInfo(prInfoList, recordLog);
		}
		
		return processParticipant;
	}

	/**
	 * <p>
	 * ��������Ϣ���£�״̬���ı䣨��������־��Ϣ��
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public synchronized IG337Info updateProcessParticipant(IG337Info processParticipant) throws BLException {
		String ppstatus = ig337BL.searchIG337InfoByKey(processParticipant.getPpid()).getPsdid();
		if(!ppstatus.equals(processParticipant.getPsdid())){
			throw new BLException("IGSVC0000.E004");
		}
		processParticipant = ig337BL.updateIG337Info(processParticipant);
		return processParticipant;
	}
	
	
	/**
	 * <p>
	 * ����ָ��״̬δ���������߽�ɫID����ȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ����ָ��״̬δ���������߽�ɫID����
	 *
	 */

	public List<Integer> searchProcessParticipantTodoRoleId(Integer prid,
			String status) {
		List<IG337Info> list = ig337BL
				.getIG337InfoTodoRoles(prid, status);
		List<Integer> roleList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			roleList.add(list.get(i).getPproleid());
		}
		return roleList;
	}

	/**
	 * <p>
	 * ����ָ��״̬�£�ָ����ɫ��������Ϣȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param roleId ��ɫID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 *
	 */

	public IG337Info searchProcessParticipant(Integer prid,
			Integer roleId, String status) {
		return ig337BL.getIG337Info(prid, roleId,
				status);
	}

	/**
	 * <p>
	 * ����ָ��״̬�£�ָ����ɫ��������Ϣȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 *
	 */

	public IG337Info searchProcessParticipant(Integer prid,
			String userId, String status) {
		return ig337BL.getIG337Info(prid, userId,
				status);
	}
	
	/**
	 * <p>
	 * ����ָ��״̬�£���������Ϣȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ��������Ϣ
	 * @throws BLException 
	 *
	 */

	public List<IG337Info> searchProcessParticipant(
			Integer prid, String status) throws BLException {
		return ig337BL.getIG337Infos(prid,
				null, status);
	}
	
	/**
	 * <p>
	 * ���ݼ���������ѯ��������Ϣ
	 * </p>
	 * 
	 * @param IG337SearchCond ��������
	 * @return ��������Ϣ
	 *
	 */

	public List<IG337Info> searchProcessParticipants(IG337SearchCond cond) {
		return ig337BL.getIG337Infos(cond);
	}
	

	/**
	 * <p>
	 * ����ָ��״̬�£�δ������������Ϣ����ȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ָ��״̬�µ�δ��������������
	 *
	 */

	public int getTodoProcessParticipantCount(Integer prid, String status) {
		return ig337BL.getTodoIG337InfoCount(prid, status);
	}

	/**
	 * <p>
	 * ��־����,roleidΪnull�򲻼�¼������ɫ����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param type ��־���� 0ϵͳ��־��1��׼��2���أ�3�ύ��4��ֹ��5����
	 * @param pbdid ������ťID
	 * @return ��������Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 *
	 */
	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment,
			String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus) throws BLException {
		//��ѯ����
		IG500Info processRecord = ig500BL.searchIG500InfoByKey(prid);
		IG036TB recordLog = this.getRecordLogTBInstance();
		recordLog.setPrid(prid);
		recordLog.setRluserid(user.getUserid());
		recordLog.setRlusername(user.getUsername());
		recordLog.setRldesc(desc);
		recordLog.setRlcomment(comment);
		recordLog.setRltime(IGStringUtils.getCurrentDateTime());
		recordLog.setPbdid(pbdid);
		//��ťIDΪ��Ϊϵͳ��
		if(StringUtils.isEmpty(pbdid) && !IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(type)) {
			recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		} else if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(pbdid) || IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)) {
			//����/ִ���˱���ʱ�����ݴ����������ޱ��棬���������ύ���¼��û�а�ϵͳ���¼��
			if(StringUtils.isNotEmpty(comment) || (filemap != null && filemap.size() > 0)) {
					recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
			} else {
				recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			}
		} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(pbdid)) {
			//ȷ����������¼�ɴ����࣬���洦����ʱ����***����ȷ�ϣ�������
			recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
			//ȷ�϶���ȥ����ȷ������ 20130708 wangtingzhi
//			recordLog.setRlusername(user.getUsername() + "��" + "��ȷ��" +  "��");
		} else {
			recordLog.setRltype(type);
		}
		if(roleid != null && roleid > 0) {
			recordLog.setRoleid(roleid);
			Role role = roleBL.searchRoleByKey(roleid);
			recordLog.setRlrolename(role.getRolename());
		} else {
			recordLog.setRlrolename(WorkFlowConstDefine.UnspecifiedRoleName);
		}
		recordLog.setRlorgid(user.getOrgid());
		recordLog.setRlorgname(user.getOrgname());
		String attkey = fileUploadBL.uploadFile(filemap);
		recordLog.setRlattkey(attkey);
		recordLog.setPsdcode(processRecord.getPrstatus());
		
		//��״̬Ϊ�գ���ȡ����״̬
		if (StringUtils.isEmpty(prstatus)) {
			prstatus = processRecord.getPrstatus();
		}
		IG333Info psd = null;	
		if (prstatus.length() > 2) {
			if (prstatus.indexOf("_") > -1) {
				psd = workFlowDefinitionBL.searchProcessStatusDefByKey(prstatus.split("_")[0]);
				recordLog.setPsdnum(new Integer(prstatus.split("_")[1]));
				prstatus = prstatus.split("_")[0];
			} else {
				psd = workFlowDefinitionBL.searchProcessStatusDefByKey(prstatus);
			}
			recordLog.setPsdid(prstatus);
		} else {
			//��������״̬
			IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
			psdcond.setPdid(processRecord.getPrpdid());
			psdcond.setPsdcode(processRecord.getPrstatus());
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
			if(!psdList.isEmpty()){
				psd = psdList.get(0);
				recordLog.setPsdid(psd.getPsdid());
			}
		}
		
		//�Զ��幤��
		//zyl 2015��5��21��09:11:06 �����˳������������ж�
		if(processRecord.getPrtype().startsWith("WD") || processRecord.getPrtype().endsWith("D")|| processRecord.getPrtype().startsWith("DRM")|| processRecord.getPrtype().startsWith("PRJ")|| processRecord.getPrtype().startsWith("RIS")|| processRecord.getPrtype().startsWith("FX")|| processRecord.getPrtype().startsWith("AMG")|| processRecord.getPrtype().startsWith("SJ")) {
			//����״̬����
			if(psd != null){
				recordLog.setPsname(psd.getPsdname());
				if(pbdid != null) {
					if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)){
						recordLog.setRldesc("����");
					}else {
						//��ѯ����İ�ť����
						List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
							workFlowDefinitionBL.searchVisibleButton(psd.getPsdid(), roleid);
						for(IG309Info ig309 : lst_ParticipantVisibleButtonVWInfo) {
							if(pbdid.equals(ig309.getVbid())) {
								recordLog.setRldesc(ig309.getVbname());
								break;
							}
						}
					}

				}
			} else if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)) {
				recordLog.setRldesc("������Ϣ");
			}
		}
		
		//�ж��Ƿ��ɫ������
		if(userRoleBL.checkRoleManagerByID(user.getUserid(),roleid)){
			//�ǽ�ɫ������
			recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
		}else{
			recordLog.setRolemanger(IGPRDCONSTANTS.NOT_ROLEMANAGER);
		}
		
		//�Ǿ���ɫ������ʱ�����ж��Ƿ��Ǳ������ύȨ�޵�ֵ����
		if(IGPRDCONSTANTS.NOT_ROLEMANAGER.equals(recordLog.getRolemanger())) {
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(prid);
			cond.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);//��Ȩ��ʶ
			cond.setPproleid(roleid);
			cond.setPpuserid(user.getUserid());
			List<IG337Info> ppList = this.searchProcessParticipants(cond);
			for(IG337Info pp : ppList){
				//�Ƿ�ֵ����
				if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					//�ٶ�Ϊ��ɫ�����˱�ʶ
					recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
				}
			}
		}
		
		return ig036BL.registIG036Info(recordLog);
	}
	
	/**
	 * ������־��Ϣ����
	 * @param info �޸�������־��Ϣ
	 * @throws BLException 
	 */
	public void updateRecordLog(IG036Info info) throws BLException {
		this.ig036BL.updateG036Info(info);
	}
	
	/**
	 * �������̱���ID��ȡ���̱�������ֵ��Ϣ����
	 * @param piid ���̱���ID
	 * @throws BLException 
	 */
	public IG599Info searchProcessInfoByPiid(Integer piid) throws BLException {
		
		return ig599BL.searchIG599InfoByPiid(piid);
		
	}
	
	/**
	 * <p>
	 * ��������ID��ѯ�����˸����̵����̼�¼
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ���̼�¼
	 *
	 */

	public List<IG500Info> searchProcessRecordsByPrid(Integer prid) throws BLException {
		
		//��ѯ��������йص�����ID
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivartype("5");//��������Ϊ���̶���
		List<IG599Info> prInfos = ig599BL.searchIG599InfosByCond(cond);

		List<IG500Info> prds = new ArrayList<IG500Info>();
		
		//��������IDȡ�����̼���
		for(IG599Info prInfo:prInfos){
			
			String pivarvalue = prInfo.getPivarvalue();
			
			if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.indexOf("_")!=-1){
				String pridstr = pivarvalue.split("_")[0];
				if(StringUtils.isNotEmpty(pridstr) && (Integer.valueOf(pridstr)).equals(prid)){
					Integer temp_prid = prInfo.getPrid();
					if(temp_prid!=null && temp_prid>0){
						IG500Info pr = ig500BL.searchIG500InfoByKey(temp_prid);
						if(!prds.contains(pr)){
							prds.add(pr);
						}

					}
					
				}
				
			}

		}

		if(prds.size()==0){
			return null;
		}
		
		return prds;
	}
	

	/**
	 * <p>
	 * ָ��������ʷ��¼��ѯ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ָ��������ʷ��¼
	 *
	 */

	public Map<IG036Info, List<Attachment>> searchRecordLog(Integer prid) {
		List<IG036Info> recordLogList = ig036BL.searchIG036InfoByPrid(prid);
		Map<IG036Info, List<Attachment>> map = new LinkedHashMap<IG036Info, List<Attachment>>();
		for (int i = 0; i < recordLogList.size(); i++) {
			String rlattkey = recordLogList.get(i).getRlattkey();
			List<Attachment> attachmentList = null;
			if (!StringUtils.isEmpty(rlattkey)) {
				attachmentList = attachmentBL.searchAttachmentsByAttkey(rlattkey);
			}
			if (attachmentList == null) {
				attachmentList = new ArrayList<Attachment>();
			}
			map.put(recordLogList.get(i), attachmentList);
		}
		return map;
	}
	
	/**
	 * <p>
	 * ָ��������ʷ��¼��ѯ(�Զ�������ʹ��)
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ָ��������ʷ��¼
	 *
	 */

	public List<IG036Info> searchRecordLogForProcessDef(Integer prid)throws BLException {
		List<IG036Info> recordLogList = ig036BL.searchIG036InfoByPrid(prid);
		
		return recordLogList;
	}
	

	/**
	 * <p>
	 * ��ϵͳ����Ա�⣬�����п����ӵĲ����߽�ɫȡ��
	 * </p>
	 * 
	 * @param processParticipantList ������List
	 * @return �����п����ӵĲ����߽�ɫ
	 *
	 */
	
	public List<Role> getRoleNotInProcessParticipants(
			List<IG337Info> processParticipantList) {
		List<Role> roleList = roleBL.getRolesNotInProcess();
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())&&StringUtils.isEmpty(processParticipantList.get(j).getPpuserid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}
	
	/**
	 * ���ܣ����������������ȡ��(�ɸ��ݱ�����ѯ)
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(IG500SearchCond cond){
		System.out.println(cond.getPrpdid());
		System.out.println(cond.getPrtype());
		
		return ig500BL.queryIG500EntityCount(cond);
	}
	
	
	/**
	 * ��������ʱ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForPRR(List<IG337Info> processParticipantList,RoleSearchCond cond, int start, int count) {
		List<Role> roleList = roleBL.searchRoleForSelfDef(cond,start,count);
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}
	
	/**
	 * ���̶���ʱ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForSelfPRD(RoleSearchCond cond, int start, int count) {
		List<Role> roleList = roleBL.searchRoleForSelfDef(cond,start,count);
		return roleList;
	}
	
	
	
	/**
	 * <p>
	 * ��ȡ�����п����ӵ�������ɫ
	 * </p>
	 * 
	 * @param  processParticipantList �����ӵ�������ɫ
	 * @return �����п����ӵ�������ɫ����
	 *
	 */
	
	public List<Role> getApproveRolesNotAdd(List<IG337Info> processParticipantList){
		List<Role> roleList = roleBL.getApproveRoles();
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}

	/**
	 * <p>
	 * ����ָ��״̬�£��û��ɴ�����ɫȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * 
	 * @return �û��ɴ�����ɫ����
	 *
	 */

	public List<UserRoleInfo> getUserRolesInProcessParticipants(
			Integer prid, String userId, String status) {
		List<UserRoleInfo> roleList = userRoleBL.getUserRolesNotInProcess(userId);
		List<IG337Info> ppList = ig337BL.getIG337InfoTodoRoles(
				prid, status);
		List<UserRoleInfo> userPrRoleList = new ArrayList<UserRoleInfo>();
		for (IG337Info pp : ppList) {
			for (UserRoleInfo ur : roleList) {
				if (pp.getPproleid().equals(ur.getRoleid())) {
					userPrRoleList.add(ur);
					break;
				}
			}
		}
		return userPrRoleList;
	}
	/**
	 * <p>
	 * ����ָ��״̬�£��û��ɴ�����ɫȡ��
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param userId �û�ID
	 * @param status ����״̬
	 * 
	 * @return �û��ɴ�����ɫ����
	 *
	 */

	public List<IG337Info> getUserRolesInProcessParticipants(
			Integer prid, String userId, String status, String na) {
		List<IG337Info> ppList = ig337BL.getIG337InfoTodoRoles(
				prid, status);
		List<IG337Info> userPrRoleList = new ArrayList<IG337Info>();
		for (IG337Info pp : ppList) {
			userPrRoleList.add(pp);
		}
		return userPrRoleList;
	}

	/**
	 * <p>
	 * ��ȡָ�����̶����е����̱���List
	 * </p>
	 * 
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���List
	 */
	
	public List<IG007Info> getProcessInfoDefs(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);
		cond.setTableColumn("N");
		return workFlowDefinitionBL.searchProcessInfoDef(cond);
	}
	
	/**
	 * <p>
	 * ��ȡָ�����̶����е����̱���List,������ȱʡ����
	 * </p>
	 * 
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���List
	 */
	
	public List<IG007Info> getProcessInfoDefsNoDefault(String processDefinitionId){
		return workFlowDefinitionBL.searchProcessInfoDefsNoDefault(processDefinitionId);
	}
	
	/**
	 * <p>
	 * ��ȡ���̷���ʱ����������̱�����Ϣ��List
	 * </p>
	 * 
	 * @param prid 
	 * @return ���̱�����ϢList
	 *
	 */
	
	public List<IG599Info> getProcessInfo(Integer prid){
		return ig599BL.searchIG599InfosByKey(prid);
	}
	
	/**
	 * <p>
	 * ��ȡ���̱�����Ϣ
	 * </p>
	 * 
	 * @param piid 
	 * @return ���̱�����Ϣ
	 * @throws BLException 
	 *
	 */
	
	public IG599Info getProcessInfoByID(Integer piid) throws BLException{
		return ig599BL.searchIG599InfoByPiid(piid);
	}
	
	/**
	 * <p>
	 * ���̱�����Ϣ�趨
	 * </p>
	 * 
	 * @param processInfoList ���̱�����Ϣ����
	 *
	 */
	
	public List<IG599Info> saveOrUpdProcessInfos(List<IG599Info> processInfoList) throws BLException{
		List<IG599Info> newList = ig599BL.saveOrUpdIG599Infos(processInfoList);
		return newList;
	}
	
	/**
	 * <p>
	 * ���̱�����Ϣ�趨
	 * </p>
	 * 
	 * @param processInfo ���̱�����Ϣ����
	 *
	 */
	
	public IG599Info saveProcessInfo(IG599Info processInfo) throws BLException{
		return ig599BL.saveIG599Info(processInfo);
	}
	
	/**
	 * <p>
	 * ��ȡָ����ѯ�����µ�����ģ��
	 * </p>
	 * 
	 * @param ProcessTemplateSearchCond ����ģ���ѯ�ӿ�
	 * @return ָ����ѯ�����µ�����ģ��List
	 *
	 */
	
	public List<IG259Info> getActiveProcessTemplates() throws BLException{
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPtstatus("a");//δͣ��
		return workFlowDefinitionBL.searchProcessTemplate(cond);
	}
	
//	/**
//	 * <p>
//	 * ��ȡ��������ģ��
//	 * </p>
//	 * 
//	 * @param ProcessTemplateSearchCond ����ģ���ѯ�ӿ�
//	 * @return ��������ģ��List
//	 *
//	 */
//	
//	public List<ProcessTemplate> getAllProcessTemplates() throws BLException{
//		ProcessTemplateSearchCondImpl cond = new ProcessTemplateSearchCondImpl();
//		return processTemplateBL.searchProcessTemplates(cond);
//	}
	
	/**
	 * ��ȡָ������ģ��
	 * @param ptid Integer
	 * @return ProcessTemplate
	 * @throws BLException 
	 * @throws BLException
	 */
	
	public IG259Info getProcessTemplateByKey(Integer ptid) throws BLException{
		return workFlowDefinitionBL.searchProcessTemplateByKey(ptid);
	}
	/**
	 * ��ȡָ����������
	 * @param pdid Integer
	 * @return ProcessDefinition
	 * @throws BLException
	 */
	
	public IG380Info getProcessDefinitionByKey(String pdid) throws BLException {
		return workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
	}
	
	/**
	 * <p>
	 * ָ���û������δ�رյ�������Ϣȡ��
	 * </p>
	 * 
	 * @param userId �û�id
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	
	public List<IG500Info> getActiveProcessRecordsInitByUser(
			String userId, String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		cond.setPruserid(userId);
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * ָ����ɫ�����δ�رյ�������Ϣȡ��
	 * </p>
	 * 
	 * @param roleId ��ɫid
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	
	public List<IG500Info> getActiveProcessRecordsInitByRole(
			Integer roleId, String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		cond.setPrroleid(roleId);
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * ָ����ɫ��δ�رյ�������Ϣȡ��
	 * </p>
	 * 
	 * @param roleId ��ɫid
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	
	public List<IG677Info> getWorkAssignedToMyManyRole(
			Integer roleId, String prtype){
		return ig500BL.getTodoProcessRecordsByRole(roleId, prtype);
	}
	
	/**
	 * <p>
	 * ָ���û���δ�رյ�������Ϣȡ��
	 * </p>
	 * 
	 * @param userId �û�id
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	
	public List<IG677Info> getWorkAssignedToMe(String userId, String prtype,String pdid,String prstatus){
		return ig500BL.getTodoProcessRecordsByUser(userId, prtype,pdid,prstatus);
	}
	
	/**
	 * ָ������δ�ر�����ȡ��
	 * 
	 * @param prtype ��������
	 * @return ָ������δ�ر�����
	 */
	
	public List<IG500Info> getAllActiveProcessRecords(String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	
	/**
	 * ȱʡ������ȡ��
	 * @param pdid ��������ID
	 * @return  ȱʡ�������б�
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid) {
		return workFlowDefinitionBL.getDefaultApprovors(pdid);
	}
	
	/**
	 * ȱʡ����������ȡ��
	 * @param pdid ��������ID
	 * @return  ȱʡ�����������б�
	 */
	
	public List<IG337Info> getDefaultApprovorDispatcher(String pdid){
		return workFlowDefinitionBL.searchDefaultApprovorDispatcherByPdid(pdid);
	}
	
	/**
	 * ָ���û���������̴�����ɫ����
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG337Info> queryRolemanager(String userid , Integer prid) {
		return ig337BL.queryRolemanager(userid, prid);
	}
	
	/**
	 * ��������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryServiceRequestList(IG500SearchCond cond, int start, int count) {
		return this.ig500BL.queryServiceRequestList(cond, start, count);
	}
	
	/**
	 * ������������������¼��
	 * @param cond ���������������
	 * @return ����������¼��
	 */
	public int queryServiceRequestListCount(IG500SearchCond cond) {
		return this.ig500BL.queryServiceRequestListCount(cond);
	}

	/**
	 * ָ���û�δ��������������������
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid){
		return this.ig500BL.queryActiveProcessByUserid(userid);
	}
	
	/**
	 * <p>
	 * ���̷����߽�ɫ��δ�رյ�������Ϣȡ��
	 * </p>
	 * 
	 * @param roleId ���̷����߽�ɫid
	 * @param prtype ��������
	 * @return ������Ϣ
	 */
	
	public List<IG677Info> getWorkAssignedToFPRole(
			Integer roleId, String prtype){
		return ig500BL.getTodoProcessRecordsByFPRole(roleId, prtype);
	}
	
	/**
	 * ���ָ���û��Ƿ����ָ�����̲鿴Ȩ�ޣ�Ŀǰֻ֧�ֱ����������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return Ȩ�ޱ�ʶ
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid){
		return this.ig500BL.checkLookDetailPermission(userid, prid);
	}
	
	/**
	 * ������ָ������ɫʱ,�ڽ�ɫ�����˵��ҵĹ�������ʾ����������Ϣ
	 * @param userid �û�ID
	 * @return
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid){
		return this.ig500BL.queryActiveProcessByFPRoleid(userid);
	}

	/**
	 * <p>
	 * �������ʲ���ϵ�趨
	 * </p>
	 * @param IG731 ���̱�����Ϣ����
	 */
	public IG731Info saveProcessInfoEntity(IG731Info processInfoEntity) throws BLException{
		return ig731BL.registIG731Info(processInfoEntity);
	}

	/**
	 * <p>
	 * �������ʲ���ϵ��ѯ
	 * </p>
	 * @param prid ����ID
	 * @return �������ʲ���ϵ��Ϣ����
	 */
	public List<IG731Info> searchProcessInfoEntityByPrid(Integer prid) {
		return ig731BL.searchIG731InfoByPrid(prid);
	}
	
	/**
	 * ��������ʲ�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG731Info> searchProcessInfoEntityByCond(IG731SearchCond cond){
		return ig731BL.searchIG731Info(cond);
	}

	/**
	 * <p>
	 * �������ʲ���ϵɾ��
	 * </p>
	 * @param pieid �����ʲ���ϵID
	 */
	public void deleteProcessInfoEntityById(Integer pieid) throws BLException{
		 ig731BL.deleteIG731Info(pieid);
	}

	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ�����1��δ����������������
	 * @param dealFlag  ��ѯ������־��0���ѹرգ�1��δ�رգ�����������
	 * @return ��������б�
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return this.ig500BL.queryCorrelationProcessByUserid(cond, start, count, closeFlag, dealFlag);
	}
	
	/**
	 * ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ�����1��δ����������������
	 * @param dealFlag  ��ѯ������־��0���ѹرգ�1��δ�رգ�����������
	 * @return �����������
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return this.ig500BL.queryCorrelationProcessByUseridCount(cond, start, count, closeFlag, dealFlag);
	}
	/**
	 * ָ����ɫδ��������������������
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid){
		return this.ig500BL.queryActiveProcessByRoleid(roleid);
	}
	
	/**
	 * <p>
	 * ���̹�ϵ����
	 * </p>
	 * 
	 * @param processRecordRelation ���̹�ϵ��Ϣ
	 * @return ���̹�ϵ��Ϣ
	 * @throws BLException
	 *
	 */
	
	public IG512Info createProcessRecordRelation(IG512Info processRecordRelation)
			throws BLException {
		return this.ig512BL.registIG512Info(processRecordRelation);
	}
	
	/**
	 * <p>
	 * ���ݼ�������ȡ�����̹�ϵ
	 * </p>
	 * 
	 * @param cond ���̹�ϵ��Ϣ��������
	 * @return ���̹�ϵ��Ϣ��������б�
	 *
	 */

	public List<IG512Info> searchProcessRecordRelation(IG512SearchCond cond){
		return this.ig512BL.searchIG512Info(cond, 0, 0);
	}
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param processRecordRelationList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> processRecordRelationList) {
		this.ig512BL.orderByTimeAsc(processRecordRelationList);
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, String psdid, Integer pgrid) throws BLException {
		//��ȡʱ��
		Date dateTime = new Date();
		//�Ƿ���ڵ�
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype) {
			insertBeginRecordStatusLog(prid, prpdid, prtype, fromstatus, statustype, dateTime,psdid);
		} else {
			//����״̬��־����
			updateRecordStatusLog(prid, null, dateTime);
		}
		//����״̬��־����
		insertRecordStatusLog(prid, prpdid, prtype, fromstatus, tostatus, statustype, dateTime, psdid, pgrid);
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @param pgrid ������ID
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	public void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Integer pgrid) throws BLException {
		//��ȡʱ��
		Date dateTime = new Date();
		//�Ƿ���ڵ�
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype) {
			insertBeginRecordStatusLog(prid, prpdid, prtype, fromstatus, statustype, dateTime,null);
		} else {
			//����״̬��־����
			updateRecordStatusLog(prid, fromstatus, dateTime);
		}
		//����״̬��־����
		insertRecordStatusLog(prid, prpdid, prtype, fromstatus, tostatus, statustype, dateTime, null, pgrid);
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param fromstatus ����ԭ״̬
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void updateRecordStatusLog(Integer prid, String fromstatus, Date dateTime) throws BLException {
		//���µ�ǰ����״̬��־��Ϣ
		IG224Info currentRecordStatusLog = this.ig224BL.searchCurrentIG224Info(prid, fromstatus).get(0);
		IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
		currentRecordStatusLogTB.setRslCloseTime(dateTime);//����ʱ��
		this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param fromstatus ����ԭ״̬
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void updateRecordStatusLogByPsdid(Integer prid, Integer pgrid, String pgdid, String frompsdid, Date dateTime) throws BLException {
		//���µ�ǰ����״̬��־��Ϣ
		IG224Info currentRecordStatusLog = this.ig224BL.searchCurrentIG224InfoByPsdid(prid, frompsdid).get(0);
		IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
		currentRecordStatusLogTB.setRslCloseTime(dateTime);//����ʱ��
		this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
		//checkTrigger(prid, pgrid, pgdid, frompsdid);//У���Ƿ񴥷�Ӱ������ԾǨ�߼�
	}
	
	/**
	 * �ο�����ԾǨʱУ���Ƿ񴥷�Ӱ������ԾǨ�߼�
	 * @param prid �ο�����ID
	 * @param pgrid ������ID
	 * @param pgdid �����鶨��ID
	 * @param rpsdid �ο�����״̬
	 * @param dateTime ����ʱ��
	 * @param rtpsdid �ο�����Ŀ��״̬����
	 * @throws BLException
	 */
	private void checkTrigger(Integer prid, Integer pgrid, String pgdid,
			String rpsdid, Date dateTime, List<String> rtpsdids) throws BLException {
		//��ѯδ������ϵʵ����¼
		List<IG485VW> lst_IG485 = this.ig485BL.searchNotDone(prid, rpsdid);
		//��ѯ�������Աʵ��
		IG484SearchCondImpl cond = new IG484SearchCondImpl();
		cond.setPgrid(pgrid);
		List<IG484Info> lst_IG484 = this.ig484BL.searchIG484(cond);
		//��ȡ��������Ϣ
		IG483Info ig483 = this.ig483BL.searchIG483ByPK(pgrid);
		Integer ocount = ig483.getOcount();//�ѷ���������
		Integer ocount_new = ig483.getOcount();//�ѷ���������
		//���¹�ϵʵ����¼Ϊ�Ѵ���
		for(IG485VW info : lst_IG485) {
			//���������ϵû�ж��崥����������Ϊ�κι����ܴ����������̣�����ƥ��Ŀ��״̬
			if(StringUtils.isEmpty(info.getRtpsdid()) || rtpsdids.contains(info.getRtpsdid())){
				IG485TB ig485 = this.ig485BL.getIG485TBInstance();
				copyProperties(ig485, info);
				ig485.setPgrrstatus("1");//�Ѵ���
				this.ig485BL.updateIG485(ig485);
				WorkFlowGroupEventBL groupEventBL = null;
				WorkFlowGroupProcessLaunchBL launchProcessBL = null;
				//�ж��Ƿ����ڷ���
				if(StringUtils.isEmpty(info.getTransferhandler())) {
					//״̬IDΪ001�ı�ʶ����״̬
					if(info.getIpsdid().endsWith("001")) {
						try {
							launchProcessBL = (WorkFlowGroupProcessLaunchBL)
									WebApplicationSupport.getBean("workFlowGroupProcessLaunchBL");
						} catch (Exception e) {
							throw new BLException("IGCO10000.E004", "���ڷ����¼�����");
						}
					}
				} else {//ִ��Լ���¼�BL
					Object obj = WebApplicationSupport.getBean(info.getTransferhandler());
					try {
						groupEventBL = (WorkFlowGroupEventBL)obj;
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "Լ���¼�����");
					}
					try {
						//���ڷ���,״̬IDΪ001�ı�ʶ����״̬
						if(info.getIpsdid().endsWith("001")) {
							if(obj instanceof WorkFlowGroupProcessLaunchBL) {
								launchProcessBL = (WorkFlowGroupProcessLaunchBL)obj;
							} else {
								launchProcessBL = (WorkFlowGroupProcessLaunchBL)
										WebApplicationSupport.getBean("workFlowGroupProcessLaunchBL");
							}
						}
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "���ڷ����¼�����");
					}
					
				}
				//���ڷ���
				if(launchProcessBL != null) {
					//������������û���������з��������̵�Ȩ�ޣ��������쳣��Ĭ��ȡ���ⷢ���ɫ����������
					List<LabelValueBean> lst_Role = this.workFlowDefinitionBL.searchInitProcessParticipantRole(
							ig483.getPgruserid(), info.getIpdid());
					if(lst_Role.isEmpty()) {
						throw new BLException("IGFLOW0000.E000", "���������̶���ID��" + info.getIpdid() + "���ķ����ɫ");
					} else {
				        Integer newPrid = launchProcessBL.launchProcess(pgrid, pgdid, info.getIpdid(), ig483.getPgrtitle() + "_"
								+ this.workFlowDefinitionBL.searchProcessDefinitionByKey(info.getIpdid()).getPdname(),
								ig483.getPgruserid(), new Integer(lst_Role.get(0).getValue()));
				        ocount_new++;
				      //��ѯ���вο�״̬�����̶��壬��Щ���̶���Ӧ���ȷ����ݲ����Ǽ���Լ�����ǲο������
						IG482SearchCondImpl cond_IG482 = new IG482SearchCondImpl();
						//��ȡ�������ϵ����
						cond_IG482.setPgdid(pgdid);//�����鶨��ID
						cond_IG482.setRpdid(info.getIpdid());//�ο����̶���ID
						List<IG482Info> lst_IG482 = this.ig482BL.searchIG482(cond_IG482);
						//���ݷ��������ʵ��ID�����������ϵʵ����Ϣ
						for(IG482Info ig482 : lst_IG482) {
							IG485TB ig485TB = this.ig485BL.getIG485TBInstance();
							ig485TB.setPgreid(ig482.getPgreid());//�������ϵ����ID
							ig485TB.setPgrid(pgrid);//������ʵ��ID
							ig485TB.setPrid(newPrid);//�ο�����ʵ��ID
							ig485TB.setPgrrstatus("0");//״̬��δ���
							this.ig485BL.registIG485(ig485TB);
						}
					}
				}
				//Ӱ���¼�����
				if(groupEventBL != null) {
					//�������̷���������²�ѯ���Աʵ����Ϣ
					if(launchProcessBL != null) {
						lst_IG484 = this.ig484BL.searchIG484(cond);
					}
					//��������Ӱ��״̬��Ӧ������ID,��ִ��Լ���¼�
					for(IG484Info ig484 : lst_IG484) {
						if(StringUtils.startsWith(info.getIpsdid(), ig484.getPdid())) {
							groupEventBL.execute(prid, ig484.getPrid());
							break;
						}
					}
				}
			}
		}
		//�����ѷ���������
		if(ocount.intValue() != ocount_new.intValue()) {
	        IG483TB ig483TB = (IG483TB)SerializationUtils.clone(ig483);
	        ig483TB.setOcount(ocount_new);
	        this.ig483BL.updateIG483(ig483TB);
		}
		//��ȡ��ҪԾǨ��Ӱ������ID
		if(!lst_IG485.isEmpty()) {
			List<IG224VW> lst_IG224 = this.ig485BL.searchTriggerPrid(prid, pgrid, pgdid, rpsdid, rtpsdids);
			IG500Info ig500 = null;
			IG337Info ig337 = null;
			User commitUser = null;
			User authorizeUser = null;
			IG333Info fpsd = null;
			IG333Info tpsd = null;
			List<IG337Info> lst_IG337 = null;
			for(IG224VW obj : lst_IG224) {
				ig500 = this.searchProcessRecordByKey(obj.getPrid());
				if(obj.getPendpsdnum() == null) {
					lst_IG337 = searchProcessParticipantDoneRole(ig500.getPrid(), obj.getPendpsdid());
				} else {
					lst_IG337 = searchProcessParticipantDoneRole(ig500.getPrid(), obj.getPsdid() + "_" + obj.getPendpsdnum());
				}
				if(lst_IG337.isEmpty()) {
					throw new BLException("IGCO10000.E141", ig500.getPrtitle() + "��"+ obj.getPendpsdid() +"��״̬�Ѵ����û�������");
				}
				ig337 = lst_IG337.get(lst_IG337.size()-1);//ȡ������˼�¼
				commitUser = this.userBL.searchUserByKey(ig337.getPpuserid());
				if(StringUtils.isNotEmpty(ig337.getPpproxyuserid())) {
					authorizeUser = this.userBL.searchUserByKey(ig337.getPpproxyuserid());
				}
				fpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(obj.getPendpsdid());
				tpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(obj.getPsdid());
				IG224Info info = ig224BL.searchIG224InfoByKey(obj.getRslid());
				IG224TB ig224 = (IG224TB)SerializationUtils.clone(info);
				ig224.setPend("1");//�������
				ig224.setPendCloseTime(dateTime);
				ig224.setRslOpenTime(dateTime);
				this.ig224BL.updateIG224Info(ig224);
				//���Ӳ�����
				this.addParticipants(obj.getPsdnum() == null ? obj.getPsdid() : obj.getPsdid() + "_" + obj.getPsdnum() , commitUser, 
						ig500.getPrid(), ig337.getPproleid(), "", null,
						null, null, authorizeUser, ig337.getPbdid(), 
						obj.getPsdnum() == null ? obj.getPendpsdid() : obj.getPendpsdid() + "_" + obj.getPsdnum());
				//��������ǰ�����¼�
				this.processPreTreatmentExecute(ig500, fpsd, tpsd, commitUser, ig337.getPproleid(),
						authorizeUser, ig337.getPbdid(), ig337.getPsdnum());
				//�������̶��߳�����
				this.processThreadTreatmentExecute(ig500, fpsd, tpsd, commitUser, ig337.getPproleid());
				
				addRecordLog(ig500.getPrid(), commitUser, ig337.getPproleid(), "�������", null,
						null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null,
						obj.getPsdnum() == null ? obj.getPsdid() : obj.getPsdid() + "_" + obj.getPsdnum());
				
				//��ȡ��һ״̬������
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(ig500.getPrid());
				ppCond.setPsdid(obj.getPsdid());
				ppCond.setPsdnum(ig337.getPsdnum());
				List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
//				List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//						tpsd.getPsdcode());
				List<String> lst_Userid = new ArrayList<String>();
				List<Integer> lst_Roleid = new ArrayList<Integer>();
				if(!ppList.isEmpty()) {
					for(IG337Info pp:ppList){
						if(StringUtils.isEmpty(pp.getPpuserid())) {
							lst_Roleid.add(pp.getPproleid());
						} else {
							lst_Userid.add(pp.getPpuserid());
						}
					}
					sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, ig500);
				}
			}
		}
		
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void insertBeginRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			int statustype, Date dateTime,String psdid) throws BLException {
		//��ѯ��ǰ״̬
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(fromstatus);
		//������һ����״̬��־��Ϣ
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(prid);//����ID
		currentRecordStatusLogTB.setPrtype(prtype);//��������
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//��ʼʱ��
		currentRecordStatusLogTB.setRslCloseTime(dateTime);
		currentRecordStatusLogTB.setPrstatus(psd.getPsdcode());//��ǰ����״̬
		currentRecordStatusLogTB.setPrpdid(prpdid);//�Զ�����������ID
		currentRecordStatusLogTB.setVirtualstatus("0");//������״̬
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
	}

	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void insertBeginRecordStatusLogByPsdid(Integer prid, String prpdid, String prtype, String frompsdid,
			int statustype, Date dateTime, boolean flag) throws BLException {
		//��flagΪtrueʱ����ʾ����ԾǨʱ���ӷ���״̬��־����ʱ��Ҫ�ж��Ƿ��Ѿ������˲ݸ�״̬
		if(flag) {
			
			List<IG224Info> lst_IG224Info = this.searchRecordStatusLog(prid);
			if(lst_IG224Info.size() == 1 && lst_IG224Info.get(0).getRslCloseTime() == null) {
				IG224TB tb = (IG224TB)SerializationUtils.clone(lst_IG224Info.get(0));
				tb.setRslCloseTime(new Date());
				this.ig224BL.updateIG224Info(tb);
				return;
			} 
		}
		
		String psdid = "";
		Integer psdnum = 0;
		if (frompsdid.indexOf("_") > -1) {
			psdid = frompsdid.split("_")[0];
			psdnum = Integer.parseInt(frompsdid.split("_")[1]);
		} else {
			psdid = frompsdid;
		}
		
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//������һ����״̬��־��Ϣ
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(prid);//����ID
		currentRecordStatusLogTB.setPrtype(prtype);//��������
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//��ʼʱ��
		if(flag) {
			currentRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);//��ǰ����״̬
		currentRecordStatusLogTB.setPsdid(psdid);
		if (psdnum > 0) {
			currentRecordStatusLogTB.setPsdnum(psdnum);
		}
		currentRecordStatusLogTB.setPpsdid(psd.getPpsdid());
		currentRecordStatusLogTB.setPrpdid(prpdid);//�Զ�����������ID
		currentRecordStatusLogTB.setVirtualstatus("0");
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private void insertRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Date dateTime,String psdid, Integer pgrid) throws BLException {
		//������һ����״̬��־��Ϣ
		IG224TB nextRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		nextRecordStatusLogTB.setPrid(prid);//����ID
		nextRecordStatusLogTB.setPrpdid(prpdid);//�Զ�����������ID
		nextRecordStatusLogTB.setPrtype(prtype);//��������
		nextRecordStatusLogTB.setRslOpenTime(dateTime);//��ʼʱ��
		//����״̬��Ҫ�趨����ʱ��=��ʼʱ��
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		} else if(WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		//�������Ա�ر�ʱ��������������ѹر�������
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype || WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			if(pgrid != null) {
				IG483Info ig483Info = this.ig483BL.searchIG483ByPK(pgrid);
				IG483TB ig483 = (IG483TB)SerializationUtils.clone(ig483Info);
				ig483.setCcount(ig483.getCcount() + 1);
				//�ѹر���=����������������ر�
				if(ig483.getCcount().intValue() == ig483.getOcount().intValue()) {
					ig483.setPgrclosetime(CommonDefineUtils.DATETIME_FORMAT.format(dateTime));
				}
				this.ig483BL.updateIG483(ig483);
			}
		}
		nextRecordStatusLogTB.setPrstatus(tostatus);//��һ����״̬
		nextRecordStatusLogTB.setVirtualstatus("0");//������״̬
		nextRecordStatusLogTB.setPsdid(psdid);
		this.ig224BL.registIG224Info(nextRecordStatusLogTB);
	}

	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @param dateTime ��¼ʱ��
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	private boolean insertRecordStatusLogByPsdid(Integer prid, String prpdid, Integer pgrid, String pgdid, String prtype, String frompsdid,
			String topsdid, int statustype, Date dateTime) throws BLException {
		//�Ƿ���Ҫ����
		boolean notPend = true;
		String psdid = "";
		Integer psdnum = null;
		if (topsdid.indexOf("_") > -1) {
			psdid = topsdid.split("_")[0];
			psdnum = Integer.parseInt(topsdid.split("_")[1]);
		} else {
			psdid = topsdid;
		}
		
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//������һ����״̬��־��Ϣ
		IG224TB nextRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		nextRecordStatusLogTB.setPrid(prid);//����ID
		nextRecordStatusLogTB.setPrpdid(prpdid);//�Զ�����������ID
		nextRecordStatusLogTB.setPrtype(prtype);//��������
		//�ж���������������Ƿ���Ҫ��topsdid״̬����
		nextRecordStatusLogTB.setRslOpenTime(dateTime);//��ʼʱ��
		if(pgrid != null && pgrid > 0 && this.ig485BL.checkPend(pgrid, pgdid, topsdid)) {
			nextRecordStatusLogTB.setPendOpenTime(dateTime);//����ʼʱ��
			nextRecordStatusLogTB.setPend("0");//����
			nextRecordStatusLogTB.setPendpsdid(frompsdid);//���������״̬ID
			nextRecordStatusLogTB.setPendpsdnum(psdnum);//���������״̬ID��Ӧ��psdnum
			notPend = false;
		}
		//����״̬��Ҫ�趨����ʱ��=��ʼʱ��
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		} else if(WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}else if(4 == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		//�������Ա�ر�ʱ��������������ѹر�������
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype || WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			if(pgrid != null) {
				IG483Info ig483Info = this.ig483BL.searchIG483ByPK(pgrid);
				IG483TB ig483 = (IG483TB)SerializationUtils.clone(ig483Info);
				ig483.setCcount(ig483.getCcount() + 1);
				//�ѹر���=����������������ر�
				if(ig483.getCcount().intValue() == ig483.getOcount().intValue()) {
					ig483.setPgrclosetime(CommonDefineUtils.DATETIME_FORMAT.format(dateTime));
				}
				this.ig483BL.updateIG483(ig483);
			}
		}
		nextRecordStatusLogTB.setPsdid(psdid);//��һ����״̬
		nextRecordStatusLogTB.setPsdnum(psdnum);
		nextRecordStatusLogTB.setPpsdid(psd.getPpsdid());
		//����������ڵ�
		if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(psd.getPsdtype()) || IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(psd.getPsdtype())) {
			nextRecordStatusLogTB.setVirtualstatus("1");
		} else {
			nextRecordStatusLogTB.setVirtualstatus("0");
		}
		this.ig224BL.registIG224Info(nextRecordStatusLogTB);
		return notPend;
	}
	
	/**
	 * ����״̬��־����
	 * 
	 * @param prid ����ID
	 * @param prpdid �Զ�����������ID�����Զ������̴���null��
	 * @param prtype ��������
	 * @param fromstatus ����ԭ״̬
	 * @param tostatus ����ԾǨ״̬
	 * @param statustype ����״̬���ͣ�0��ʼ��1��ͨ��2����
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	public void addRecordStatusLog(IG500Info processRecord, IG333Info fpsd, Integer psdnum,
			String[] tostatus, int statustype, User user, Integer roleid, User authorizeuser, String pbdid) throws BLException {
		
		//��ȡʱ��
		Date dateTime = new Date();
		//�Ƿ���ڵ�
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype || (IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(processRecord.getPrtype()) && IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && IGPRDCONSTANTS.PROCESS_TERMINATE.equals(tostatus))) {
			insertBeginRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(), processRecord.getPrtype(), fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), statustype, dateTime,true);
		} else {
			//����״̬��־����
//			updateRecordStatusLogByPsdid(processRecord.getPrid(), fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime);
			updateRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPid(), processRecord.getPname(),
					fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime);//Ӧ���ϰ�
		}
		//��ҪԾǨ��״̬�Ƿ񱻹���
				Map<String, Boolean> map_NotPend = new HashMap<String, Boolean>();
		//����״̬��־����
		for(String psdid : tostatus) {
			if (checkTranslate(processRecord.getPrid(), processRecord.getPrpdid(), psdid)) {
				//��¼����״̬��־
//				insertRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(), processRecord.getPrtype(), fpsd.getPsdid(), psdid + (psdnum == null ? "" : "_" + psdnum), statustype, dateTime);
				map_NotPend.put(psdid, insertRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(),
						processRecord.getPid(), processRecord.getPname(),
						processRecord.getPrtype(), fpsd.getPsdid(), psdid + (psdnum == null ? "" : "_" + psdnum), 
						statustype, dateTime));
			}
		}

		boolean flag = true;
		
		//����״̬��־����
		for(String psdid : tostatus) {

			IG333Info tpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);

			if (flag) {

				//�������̺����¼�
				this.processAfterTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid,psdnum);
				
				flag = false;
			}
			
			if (checkTranslate(processRecord.getPrid(), processRecord.getPrpdid(), psdid)) {
				//��������ǰ�����¼�
				this.processPreTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid,psdnum);
				//�������̶��߳�����
				this.processThreadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
				
				//��ȡ��һ״̬������
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(processRecord.getPrid());
				ppCond.setPsdid(psdid);
				ppCond.setPsdnum(psdnum);
				List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
//				List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//						tpsd.getPsdcode());
				List<String> lst_Userid = new ArrayList<String>();
				List<Integer> lst_Roleid = new ArrayList<Integer>();
				if(!ppList.isEmpty()) {
					for(IG337Info pp:ppList){
						if(StringUtils.isEmpty(pp.getPpuserid())) {
							lst_Roleid.add(pp.getPproleid());
						} else {
							lst_Userid.add(pp.getPpuserid());
						}
					}
					sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, processRecord);
				}
				
				
				// ��Ŀ��ڵ��������̽ڵ㣬�Զ�����������
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(tpsd.getPsdtype())) {
					
					// ��ѯ�����̿�ʼ�ڵ�
					IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
					psdCond.setPdid(processRecord.getPrpdid());
					psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
					psdCond.setPpsdid(tpsd.getPsdid());
					List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
					
					if (czList != null && czList.size() > 0) {
						
						IG333Info czpsd = czList.get(0);

						this.checkAndTransitionForHandel(user, czpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), roleid, "10", processRecord.getPrid(), 
								czpsd.getPsdtype(), null, null, authorizeuser);
					} else {
						throw new BLException("IGCO10000.E004","�����̿�ʼ״̬");
					}
				}

				// ��Ŀ��ڵ��Ƕ�̬��֧�ڵ㣬�Զ����������̣�������̬��֧�ڵ���������ö�̬��֧
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(tpsd.getPsdtype())) {
					
					// ��ȡ��̬��֧�ڵ������
					IG337SearchCondImpl cppCond = new IG337SearchCondImpl();
					cppCond.setPrid(processRecord.getPrid());
					cppCond.setPsdid(tpsd.getPsdid());
					List<IG337Info> cppList = this.searchProcessParticipants(cppCond);
					
					List<Integer> roleidList = new ArrayList<Integer>();
					Map<Integer, Integer> roleidMap = new HashMap<Integer, Integer>();
					if (IGPRDCONSTANTS.PROCESS_BRANCHCOND_ROLE.equals(tpsd.getBranchcond())) {
						for (IG337Info ppInfo : cppList) {
							if (roleidMap.get(ppInfo.getPproleid()) == null) {
								roleidList.add(ppInfo.getPproleid());
								roleidMap.put(ppInfo.getPproleid(), ppInfo.getPproleid());
							}
						}
					}
					
					// ��ѯ�����̿�ʼ�ڵ�
					IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
					psdCond.setPdid(processRecord.getPrpdid());
					psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
					psdCond.setPpsdid(tpsd.getPsdid());
					List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
					
					if (czList != null && czList.size() > 0) {
						
						IG333Info czpsd = czList.get(0);
						
						// ������ɫ���򰴽�ɫ�������������̣������ý�ɫ������������Ϊ������
						if (IGPRDCONSTANTS.PROCESS_BRANCHCOND_ROLE.equals(tpsd.getBranchcond())) {
							
							if (roleidList != null && roleidList.size() > 0) {
								
								for (int i = 1; i <= roleidList.size(); i++) {
									
									Integer croleid = roleidList.get(i - 1);
									
									// ��ѯ�ý�ɫ�������û�
									UserRoleSearchCondImpl urCond = new UserRoleSearchCondImpl();
									urCond.setRoleid(croleid);
									List<UserRole> urList = userRoleBL.searchUserRole(urCond);
									
									// ԾǨ������״̬
									this.checkAndTransitionForHandel(user, czpsd.getPsdid() + "_" + i, roleid, "10", processRecord.getPrid(), 
											czpsd.getPsdtype(), null, null, authorizeuser);

									// ��ѯ�����̿�ʼ�����״̬
									IG273SearchCondImpl ptCond = new IG273SearchCondImpl();
									ptCond.setFpsdid(czpsd.getPsdid());
									List<IG273Info> ptList = this.workFlowDefinitionBL.searchProcessTransitionDef(ptCond);
									
									if (ptList != null && ptList.size() > 0) {
										
										// ���Ӹý�ɫ�µ���������Ϊ������
										for (UserRole urInfo : urList) {
											
											this.addParticipant(user, processRecord.getPrid(), processRecord.getPrpdid(), ptList.get(0).getTpsdid() + "_" + i, 
													String.valueOf(urInfo.getRoleid()), urInfo.getUserid(), null, authorizeuser, pbdid, czpsd.getPsdid());
										}
									}
									
								}
								
								// ɾ�������̸��ڵ�Ĳ�����
								for (int i = 1; i <= cppList.size(); i++) {
									this.removeProcessParticipant(cppList.get(i-1));
								}
							} else {
								throw new BLException("IGCO10000.E004","��̬��֧������");
							}
						} 
						// ������Ա������Ա���������� ����������Ա����Ϊ������
						else {
							
							if (cppList != null && cppList.size() > 0) {
								
								for (int i = 1; i <= cppList.size(); i++) {
									
									this.checkAndTransitionForHandel(user, czpsd.getPsdid() + "_" + i, roleid, "10", processRecord.getPrid(), 
											czpsd.getPsdtype(), null, null, authorizeuser);
									
									IG273SearchCondImpl ptCond = new IG273SearchCondImpl();
									ptCond.setFpsdid(czpsd.getPsdid());
									List<IG273Info> ptList = this.workFlowDefinitionBL.searchProcessTransitionDef(ptCond);
									
									if (ptList != null && ptList.size() > 0) {
										this.addParticipant(user, processRecord.getPrid(), processRecord.getPrpdid(), ptList.get(0).getTpsdid() + "_" + i, 
												String.valueOf(cppList.get(i-1).getPproleid()), cppList.get(i-1).getPpuserid(), null, authorizeuser, pbdid, czpsd.getPsdid());
									}
									
									this.removeProcessParticipant(cppList.get(i-1));
								}
							} else {
								throw new BLException("IGCO10000.E004","��̬��֧������");
							}
						}
					} else {
						throw new BLException("IGCO10000.E004","��̬��֧���̿�ʼ״̬");
					}
				}
				
				// ��Ŀ��ڵ��������̵Ľ����ڵ㣬�Զ�ԾǨ������
				if (StringUtils.isNotEmpty(tpsd.getPpsdid()) && IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode())) {
					
					// ��ѯ�����̽ڵ�
					IG333Info ppsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(tpsd.getPpsdid());
					
					if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(ppsd.getPsdtype())) {
						this.checkAndTransitionForHandel(user, ppsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), roleid, "10", processRecord.getPrid(), 
								ppsd.getPsdtype(), null, null, authorizeuser);
					} else if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(ppsd.getPsdtype())) {

						// ԾǨ��ʶ
						boolean transflag = true;
						
						// ��ѯ�����̿�ʼ�ڵ�
						IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
						psdCond.setPdid(processRecord.getPrpdid());
						psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
						psdCond.setPpsdid(tpsd.getPpsdid());
						List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
						
						if (czList != null && czList.size() > 0) {
							// ��ѯ��̬�����̸���
							IG224SearchCondImpl rslCond = new IG224SearchCondImpl();
							rslCond.setPrid(processRecord.getPrid());
							rslCond.setPpsdid(ppsd.getPsdid());
							rslCond.setPsdid(czList.get(0).getPsdid());
							List<IG224Info> rslList = this.ig224BL.searchIG224Info(rslCond, 0, 0);
							
							IG224SearchCondImpl drslCond = new IG224SearchCondImpl();
							drslCond.setPrid(processRecord.getPrid());
							drslCond.setPpsdid(ppsd.getPsdid());
							drslCond.setPsdid(tpsd.getPsdid());
							List<IG224Info> drslList = this.ig224BL.searchIG224Info(drslCond, 0, 0);
							
							if (rslList.size() != drslList.size()) {
								transflag = false;
							}
							
							if (transflag) {
								for (IG224Info drslInfo : drslList) {
									if (drslInfo.getRslCloseTime() == null) {
										transflag = false;
									}
								}
							}
						} else {
							throw new BLException("IGCO10000.E004","��̬��֧���̿�ʼ״̬");
						}
						
						if (transflag) {
							this.checkAndTransitionForHandel(user, ppsd.getPsdid(), roleid, "10", processRecord.getPrid(), 
									ppsd.getPsdtype(), null, null, authorizeuser);
						}
					}
				}
			}
			
		}
		//У���Ƿ񴥷�Ӱ������ԾǨ�߼�
		//�Ƿ�������
		if(StringUtils.isNotEmpty(processRecord.getPname())) {
			checkTrigger(processRecord.getPrid(), processRecord.getPid(), processRecord.getPname(),
					fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime, Arrays.asList(tostatus));
			
		}
	}

	/**
	 * �ж��Ƿ��¼״̬��־
	 * 
	 * @param prid
	 * @param prpdid
	 * @param status
	 * @return
	 * @throws BLException
	 */
	private boolean checkTranslate(Integer prid, String prpdid, String psdid)
			throws BLException {
		
		// ��ȡĿ��ڵ���Ϣ
		IG333Info psdInfo = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		boolean doneflag = true;

		// ��Ϊ�ϲ��ڵ㣬�ж����е��ýڵ��Ƿ��Ѿ������
		if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_MERGE.equals(psdInfo.getPsdtype())) {
			
			// ��ȡ���е��úϲ��ڵ�Ľڵ���Ϣ
			IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
			ptdCond.setTpsdid(psdInfo.getPsdid());
			List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			
			// �ж����нڵ��Ƿ��Ѿ����
			for (IG273Info ptdInfo : ptdList) {
				String fpsdid = ptdInfo.getFromPSDTB().getPsdid();
				IG224SearchCondImpl rslCond = new IG224SearchCondImpl();
				rslCond.setPrid(prid);
				rslCond.setPrstatus(fpsdid);
				List<IG224Info> rslList = this.ig224BL.searchIG224Info(rslCond, 0, 0);
				
				// ������δ��ɵĽڵ㣬�򲻼�¼��һ���ڵ��״̬��־
				if (rslList != null && rslList.size() > 0) {
					for (IG224Info rslInfo : rslList) {
						if (rslInfo.getRslCloseTime() == null) {
							doneflag = false;
							break;
						}
					}
					if (!doneflag) {
						break;
					}
				} else {
					doneflag = false;
					break;
				}
			}
		}
		
		return doneflag;
	}
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentRecordStatusLog(Integer prid, String status) throws BLException{
		return this.ig224BL.searchCurrentIG224Info(prid, status);
	}
	
	/**
	 * ��ǰ����״̬��ʶ����ȡ��
	 * 
	 * @param prid ����ID
	 * @return ��ǰ����״̬��ʶ����
	 * @throws BLException 
	 */
	public List<String> searchCurrentRecordStatus(Integer prid) throws BLException {
		List<IG224Info> lst_IG224Info= this.ig224BL.searchCurrentIG224Info(prid, null);
		List<String> lst_status = new ArrayList<String>();
		for(IG224Info bean : lst_IG224Info) {
			lst_status.add(bean.getPsdid() + (bean.getPsdnum() == null ? "" : "_" + bean.getPsdnum()));
		}
		return lst_status;
	}
	
	/**
	 * <p>
	 * ָ������״̬��־��ѯ
	 * </p>
	 * 
	 * @param prid ����ID
	 * @return ָ������״̬��־
	 *
	 */
	public List<IG224Info> searchRecordStatusLog(Integer prid) {
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		return this.ig224BL.searchIG224Info(cond, 0, 0);
	}

	
	/**
	 * <p>
	 * ���ݲ�ѯ������ѯ���̱�����Ϣ
	 * </p>
	 * @param IG599SearchCond ���̱�����ѯ����
	 * @return ���̱�����Ϣ 
	 */
	public List<IG599Info> searchProcessInfoByCond(IG599SearchCond cond) {
		
		List<IG599Info> list = this.ig599BL.searchIG599InfosByCond(cond);
		
		return list;
	}
	
	/**
	 * <p>
	 * ���ݲ�ѯ������ѯ���̱���������Ϣ
	 * </p>
	 * @param IG007SearchCond ���̱��������ѯ����
	 * @return ���̱���������Ϣ 
	 */
	public List<IG007Info> searchProcessInfoDefByCond(IG007SearchCond cond) {
		
		List<IG007Info> list = workFlowDefinitionBL.searchProcessInfoDef(cond);
		
		return list;
	}
	
	///////////////////////////////////////////////////songhy  start//////////////////////////////////////
	
	/**
	 * ��������
	 * 
	 * @param processRecord ���̼�¼����
	 * @param user	        �û�
	 * @param roleid		��ɫID
	 * @param filemap		����map
	 * @param pts           ��������
	 * @param prInfoList	���̱�����Ϣ
	 * @param rlcomment	    ��־��Ϣ
	 * @param psdid	        ����״̬ID
	 * @param action	    ������ʶ
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 */
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,
			String pts,List<IG599Info> prInfoList, String rlcomment,
			String psdid, String action, User authorizeuser)
			throws BLException {
		
		// ��ȡ��ǰ����״̬
		IG333Info psdInfo = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		/**   ����һ�����̵ļ�¼  start**/
		// ���̼�¼
		IG500TB processRecordTB = this.getProcessRecordTBInstance();
		this.copyProperties(processRecordTB, processRecord);
		String datetime = IGStringUtils.getCurrentDateTime();
		processRecordTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		processRecordTB.setPropentime(datetime);
		
		processRecordTB.setPruserid(user.getUserid());
		processRecordTB.setPrusername(user.getUsername());
		processRecordTB.setProrgid(user.getOrgid());
		processRecordTB.setProrgname(user.getOrgname());
		
		//�жϷ�����������
		if(StringUtils.isNotEmpty(pts)){
			processRecordTB.setPrtype(pts);
		}else{
			processRecordTB.setPrtype(IGPRDCONSTANTS.SELF_DEFINING_WORK_PRTYPE);
		}
		
		
		IG500Info newProcessRecord = ig500BL.registIG500Info(processRecordTB);
		Integer prid = newProcessRecord.getPrid();// ������̼�¼ID
		
		//������־
		addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
				filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, action, psdid);
		/**    ����һ�����̵ļ�¼  end**/
		
		/**   ������̷�����  start**/
		// ������̷����߼�¼
		IG337TB opener = this.getProcessParticipantTBInstance();
		opener.setPrid(prid);
		opener.setPpuserid(processRecordTB.getPruserid());
		opener.setPpusername(processRecordTB.getPrusername());
		opener.setPproleid(processRecordTB.getPrroleid());
		opener.setPprolename(processRecordTB.getPrrolename());
		opener.setPporgid(processRecordTB.getProrgid());
		opener.setPporgname(processRecordTB.getProrgname());
		opener.setPpstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		opener.setPpinittime(datetime);
		opener.setPpproctime(datetime);
		opener.setPbdid(action);
		opener.setPpuserinfo(processRecordTB.getPrinfo());
		opener.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		addProcessParticipant(opener,user,roleid,
				"���ӣ�" + opener.getPprolename()
				+ (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
				IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
				IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, psdInfo.getPsdid());
		
		//��дϵͳ��־
		//addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);

		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null) {
			// ���������־����, ����
			rlcomment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), rlcomment);
		}
		
		//��д�ύ��־
		IG036Info rl = this.addRecordLog(prid, user, roleid, rlcomment, IGPRDCONSTANTS.RLDESC_DATA,
				null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, action, psdInfo.getPsdid());
		
		if(prInfoList != null && !prInfoList.isEmpty()){
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(prid);
			}
			//���±�����Ϣ
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			//���ӱ�����־
			addRecordLogVarInfo(prInfoList,rl);
		}
		/**   ������̷�����  end**/
		
		/**   ƥ��ԾǨ  start**/
		this.checkAndTransitionForCreate(user,psdid,roleid,action,prid,prInfoList,authorizeuser);

		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
		newProcessRecord = ig500BL.searchIG500InfoByKey(prid);
		// <<<<<<<<<<<<<<<<< update by yangyining 20131028
		//���ɹ�����
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(newProcessRecord);
		IG380Info ig380Info = this.workFlowDefinitionBL.searchProcessDefinitionByKey(newProcessRecord.getPrpdid());
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			WorkFlowSerialnumGeneratorBL bl = null;
			try {
				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004", "����������������");
			}
			igflowlog.debug("========================�����������¼���ʼ========================");
			igflowlog.debug("������������:" + newProcessRecord.getPrpdname());
			igflowlog.debug("��������ID:" + newProcessRecord.getPrpdid());
			igflowlog.debug("���̱���:" + newProcessRecord.getPrtitle());
			igflowlog.debug("����BL:" + ig380Info.getSerialgenerator());
			ig500TB.setPrserialnum(bl.serialnumGenerator(prid));
			igflowlog.debug("���ɹ�����:" + ig500TB.getPrserialnum());
			igflowlog.debug("========================�����������¼�����========================");
			this.ig500BL.updateIG500Info(ig500TB);
		}
		
		/**   ƥ��ԾǨ  start**/
		return ig500TB;
	}
	
	/**
	 * ���̹���Ա�޸ı�����Ϣ
	 * 
	 */
	public void editVarInfo(IG500Info processRecord,User user, Integer roleid, Map<Integer, FormFile> filemap,
			List<IG599Info> prInfoList,String rlcomment, String prstatus) throws BLException{
		//��д�ύ��־
		IG036Info rl = this.addRecordLog(processRecord.getPrid(), user, roleid, rlcomment, IGPRDCONSTANTS.RLADMIN_DATA,
				null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, prstatus);
		
		if(prInfoList != null && !prInfoList.isEmpty()){
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(processRecord.getPrid());
			}
			//���±�����Ϣ
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			//���ӱ�����־
			addRecordLogVarInfo(prInfoList,rl);
		}

	}
	
	/**
	 * ɾ������
	 * @param prid
	 * @throws BLException
	 */
	public void delProcessRecord(Integer prid) throws BLException {
		ig500BL.deleteProcessRecordByKey(prid);
	}
	
	/**
	 * ����������־��ѯ��������־��Ӧ�ı�����־��Ϣ
	 * 
	 * @param IG036Info ������־
	 * @return ������־��Ϣ
	 */
	public List<IG113Info> searchRecordLogVarInfo(IG036Info recordLog) throws BLException{
		
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(recordLog.getRlid());
		List<IG113Info> list = this.ig113BL.searchIG113InfoByCond(cond);
		
		return list;
	}
	
	/**
	 * ����������־ID��ѯ��������־��Ӧ�ı�����־��Ϣ
	 * 
	 * @param rlid ������־ID
	 * @return ������־��Ϣ
	 */
	public List<IG113Info> searchRecordLogVarInfoByRecordId(Integer rlid) throws BLException{
		
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(rlid);
		return this.ig113BL.searchIG113InfoByCond(cond);
	}
	
	/**
	 * ��ѯ������־
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG113Info> searchRecordLogVarInfoByCond(IG113SearchCond cond) throws BLException {
		return this.ig113BL.searchIG113InfoByCond(cond);
	}
	
	public String searchPtdcond(Integer prid, String status) {
		List<IG337Info> lst_IG337Info = this.searchProcessParticipantDoneRole(prid, status);
		StringBuffer sbf = new StringBuffer("");
		for(IG337Info bean : lst_IG337Info) {
			sbf.append(bean.getPproleid() + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + bean.getPbdid() + IGPRDCONSTANTS.COND_COND_SPLIT);
		}
		return sbf.toString();
	}
	
	/**
	 * ���ӱ�����־��Ϣ
	 * 
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param IG036Info	   ������־
	 * @return ������־�Ƿ񱣴�ɹ�
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl) throws BLException{
		
		boolean flag = true;//���������Ƿ����
		//�жϱ��������Ƿ����
		if(prInfoList != null && !prInfoList.isEmpty()){
			Integer prid = rl.getPrid();
			for(IG599Info pi : prInfoList){
				//����ʽ��������¼��־
				if("8".equals(pi.getPivartype())
						|| "F".equals(pi.getPivartype())){
					continue;
				}
				String varvalue = pi.getPivarvalue();//�������������
				
				if(pi.getPivartype().equals("4")){  //�ʲ�
					if(StringUtils.isNotEmpty(varvalue)){
						//��ѯ��ǰ���̵��ʲ���Ϣ
						List<IG731Info> asmList = searchProcessInfoEntityByPrid(pi.getPrid());
						StringBuffer asmNames = new StringBuffer();
						int index = 0;
						for(IG731Info info:asmList){
							for(String key:pi.getPivarvalue().split(",")){
								if(info.getPieid().toString().equals(key)){
									if(index > 0){
										asmNames.append(",");
									}
									asmNames.append(info.getEntityItemVWTB().getEiname());
									index ++;
								}
							}
						}
						varvalue = asmNames.toString();
					}
				} else if(pi.getPivartype().equals("5")){  //����
					continue;
				} else if(pi.getPivartype().equals("6")){  //��Ŀ
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_prj_")){
						varvalue = varvalue.split("_prj_")[1];
					}
				} else if(pi.getPivartype().equals("R")){  //��ɫ
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_role_")){
						varvalue = varvalue.split("_role_")[1];
					}
				} else if(pi.getPivartype().equals("T")){
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_tree_")){
						varvalue = varvalue.split("_tree_")[1];
					}
				} else if(pi.getPivartype().equals("P")){
					if(StringUtils.isNotEmpty(varvalue)){
						//��ѯ��ǰ���̵���Ա������Ϣ
						List<IG506Info> ppList = searchIG506InfoByprid(pi.getPrid());
						StringBuffer ppNames = new StringBuffer();
						int index = 0;
						for(IG506Info info:ppList){
							for(String key:pi.getPivarvalue().split(",")){
								if(info.getPiuid().toString().equals(key)){
									if(index > 0){
										ppNames.append(",");
									}
									ppNames.append(info.getPiusername());
									index ++;
								}
							}
						}
						varvalue = ppNames.toString();
					}
				} else {
					varvalue = "";
				}
				
				IG113TB rlvtb = this.ig113BL.getIG113TBInstance();
				rlvtb.setPiattkey(pi.getPiattkey());
				rlvtb.setPidid(pi.getPidid());
				rlvtb.setPiid(pi.getPiid());
				rlvtb.setPivarlabel(pi.getPivarlabel());
				rlvtb.setPivarname(pi.getPivarname());
				rlvtb.setPivartype(pi.getPivartype());
				rlvtb.setPivarvalue(pi.getPivarvalue());
				rlvtb.setPrid(prid);
				rlvtb.setRlid(rl.getRlid());
				rlvtb.setFingerPrint(rl.getRltime());
				//���Ϊ�������ͱ�������ֵʱ�򱣴���ʾ����
				if(StringUtils.isNotEmpty(varvalue) && StringUtils.isNotEmpty(pi.getPivarvalue())){
					rlvtb.setPishowvarname(varvalue.replace("cv_cev_", ""));
				}
				
				this.ig113BL.registIG113Info(rlvtb);

			}
			
			
		}else{
			flag = false;
		}

		return flag;
	}
	
	
	
	
	//======================================================================================================================================
	
	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null(�����Զ�������ʱʹ��)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransitionForCreate(User user,String fpsdid,Integer roleid,String action,
			Integer prid,List<IG599Info> piList, User authorizeuser) throws BLException {
		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","��������");
		}
		
		IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);
		
		//Ŀ�꼯��
		List<String> toStatusList = new ArrayList<String>();
		
		//ƥ�����������ptdcondֻ��һ����ɫ�Ķ���
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//����ԾǨ����
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		//ptdCond.setPtdcond(ptdcond);
		ptdCond.setPtdcond_like(ptdcond);
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//���ƥ����ԾǨ���ѵ�һ��ƥ������Ϊ׼��ͬʱ���pr��prptdcond��ֵ�����ڴ���´�ԾǨ����
		boolean flag = true;//trueƥ��,false��ƥ��
		//�޸�prptdcond����¼ֵ��bug��ʼ
		if(ptdList.isEmpty()) {
			flag = false;
		}
		//�޸�prptdcond����¼ֵ��bug����
		for(IG273Info ptd:ptdList){
			//prTB.setPrptdcond(null);
			if(ptd.getPtdcond().indexOf('|')!=-1){
				if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
					//�жϱ�������
					//�Ѷ���ı�������
					String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
					String[] vid=new String[vCond.length];//����id
					String[] vsign=new String[vCond.length];//�����߼�����
					String[] vvalue=new String[vCond.length];//����ֵ
					
					for(int i=0; i<vCond.length;i++){
						//һ������Ĳ����ʱ����
						String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
						vid[i] = temp[0];
						vsign[i] = temp[1];
						vvalue[i] = temp[2];
					}
					//��������ƥ��
					
					for(int i=0,m=piList.size();i<m;i++){
						flag=true;
						IG599Info pi = piList.get(i);
						String pidid = pi.getPidid();//ҳ���ϵı���ID
						String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
						String pitype = pi.getPivartype();//ҳ���ϵı�����������
						for(int j=0,n=vid.length;j<n;j++){
							if(pidid.toString().equals(vid[j])){
								//����ֵ�붨��Ĺ���Ƚ�
								if(StringUtils.isNotEmpty(pivarvalue)){
									if("3".equals(pitype)){//��������
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("A".equals(pitype)){//ʱ������
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("R".equals(pitype)){//��ɫ����
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
											else{
												if(StringUtils.isEmpty(pivarvalue)){
													flag=false;
												}
											}
											break;
										case 2:
											if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										}
									}else if("7".equals(pitype)){//���ֿؼ�
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 2:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 3:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 4:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 5:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 6:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										}
										
									}else if("2".equals(pitype)){//������
										if(!vvalue[j].equals(pivarvalue)){
											flag=false;
										}
									}
								}else{
									flag=false;
								}
							}
							if(!flag){
								break;
							}
						}
						if(!flag){
							break;
						}
					}
					if(flag){
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						
						//����״̬ԾǨ
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
								null,null,authorizeuser, action);
						toStatusList.add(statuscode);
//						return ptd.getTpsdid();
					}
				}
			}else{
				//û�б���������ƥ����ԾǨ����.
				if(ptdcond.equals(ptd.getPtdcond())){
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
					
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
						prTB.setPrstatus(psd.getPsdcode());
						prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
					}
					//����״̬ԾǨ
					String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
							null,null,authorizeuser, action);
					toStatusList.add(statuscode);
//					return ptd.getTpsdid();
				}
			}
			
		}
		//��ȡԾǨ������ʱ����
		String prptdcond = pr.getPrptdcond();
		
		//ȥ����ͬ�Ĵ���
		{	
			if(StringUtils.isNotEmpty(prptdcond)){
				if(StringUtils.isNotEmpty(prptdcond)){
					String[] check = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
					List<String> air = new ArrayList<String>();
					StringBuffer sf = new StringBuffer();
					for(String find:check){
						if(!air.contains(find)){
							sf.append(find).append(IGPRDCONSTANTS.COND_COND_SPLIT);
							air.add(find);
						}
					}
					prptdcond = sf.toString();
				}
			}
			
		}
		
		//ȡ�õ�ǰ����״̬�Ķ���
		IG333Info processStatusDef = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);

		//�����̵�һ�������߲���
		if(StringUtils.isEmpty(prptdcond) && (ptdList==null || ptdList.size()==0)) {
			
			/**ƥ��ȱʡ����ʼ*/
			ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
			ptdCond.setPtdcond_like(ptdcond);
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			flag = true;//trueƥ��,false��ƥ��
			//�޸�prptdcond����¼ֵ��bug��ʼ
			if(ptdList.isEmpty()) {
				flag = false;
			}
			//�޸�prptdcond����¼ֵ��bug����
			for(IG273Info ptd:ptdList){
				//prTB.setPrptdcond(null);
				if(ptd.getPtdcond().indexOf('|')!=-1){
					if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
						//�жϱ�������
						//�Ѷ���ı�������
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//����id
						String[] vsign=new String[vCond.length];//�����߼�����
						String[] vvalue=new String[vCond.length];//����ֵ
						
						for(int i=0; i<vCond.length;i++){
							//һ������Ĳ����ʱ����
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//��������ƥ��
						
						for(int i=0,m=piList.size();i<m;i++){
							flag=true;
							IG599Info pi = piList.get(i);
							String pidid = pi.getPidid();//ҳ���ϵı���ID
							String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
							String pitype = pi.getPivartype();//ҳ���ϵı�����������
							for(int j=0,n=vid.length;j<n;j++){
								if(pidid.toString().equals(vid[j])){
									//����ֵ�붨��Ĺ���Ƚ�
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//��������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//ʱ������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//��ɫ����
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//���ֿؼ�
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//������
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						if(flag){
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							
							//����״̬ԾǨ
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
									null,null,authorizeuser, action);
							toStatusList.add(statuscode);
//							return ptd.getTpsdid();
						}
					}
				}else{
					//û�б���������ƥ����ԾǨ����.
					if(ptdcond.equals(ptd.getPtdcond())){
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						//����״̬ԾǨ
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
								null,null,authorizeuser, action);
						toStatusList.add(statuscode);
//						return ptd.getTpsdid();
					}else{
						flag = false;
					}
				}
			}
			/**ƥ��ȱʡ�������*/
			if(!flag){
				prTB.setPrptdcond(roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
				//workFlowOperationBL.updateProcessRecord(prTB);
				this.updateProcessRecord(prTB);
//				return null;
			}
		} else {//ƥ��������
			if(StringUtils.isEmpty(prptdcond)){
//				return null;
			} else {
			String[] prptdondArray = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_AND);
			
			ptdCond.setPtdcond(null);
			
			ptdCond.setPtdcond_like(ptdcond);
			
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			//true��ƥ��,falseƥ��
			flag = false;//�ж��ԾǨ����ʱ��ÿ�β�ƥ��ʱҪ������һ��ƥ��
			//�޸�prptdcond����¼ֵ��bug��ʼ
			if(ptdList.isEmpty()) {
				flag = true;
			}
			//�޸�prptdcond����¼ֵ��bug����
			for(IG273Info ptd : ptdList) {
				if(ptd.getPtdcond().indexOf('|')!=-1){//�б�������
					String cond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];//��ɫ��������
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//�������������
						List<String> prcondList =new ArrayList<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//ԾǨ��������
						List<String> condList =new ArrayList<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//ƥ��ʱ����������ӦΪ��
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//�����������ƥ�������ɾ��
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//��ȫƥ����ԾǨ
							if(0 == prcondList.size() && 0 == condList.size()) {
								//�����ж�
								boolean vflag = false;//trueƥ��,false��ƥ��
								//�Ѷ���ı�������
								String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//����id
								String[] vsign=new String[vCond.length];//�����߼�����
								String[] vvalue=new String[vCond.length];//����ֵ
								
								for(int i=0; i<vCond.length;i++){
									//һ������Ĳ����ʱ����
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//��������ƥ��
								
								for(int i=0,m=piList.size();i<m;i++){
									vflag=true;
									IG599Info pi = piList.get(i);
									String pidid = pi.getPidid();//ҳ���ϵı���ID
									String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
									String pitype = pi.getPivartype();//ҳ���ϵı�����������
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//ȡ����ֵ
											if("3".equals(pitype)){//��������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("A".equals(pitype)){//ʱ������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("R".equals(pitype)){//��ɫ����
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//���ֿؼ�
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 2:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 3:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 4:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 5:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 6:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//������
												if(!vvalue[j].equals(pivarvalue)){
													vflag=false;
												}
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								
								if(vflag){
									prTB.setPrptdcond(null);
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}

									//����״̬ԾǨ
									String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
											null,null,authorizeuser, action);
									toStatusList.add(statuscode);
//									return ptd.getTpsdid();
								}else{
									flag = true;
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","���������");
						return null;
					}
				}else{//�ޱ�������,��ԭ�߼���ͬ
					String cond = ptd.getPtdcond();
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//�������������
						List<String> prcondList =new ArrayList<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//ԾǨ��������
						List<String> condList =new ArrayList<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//ƥ��ʱ����������ӦΪ��
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//�����������ƥ�������ɾ��
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//��ȫƥ����ԾǨ
							if(0 == prcondList.size() && 0 == condList.size()) {
								prTB.setPrptdcond(null);
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								
								//����״̬ԾǨ
								String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
										null,null,authorizeuser, action);
								toStatusList.add(statuscode);
//								return ptd.getTpsdid();
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","���������");
						return null;
					}
				}
				if(flag && (ptdList==null || ptdList.size()==0)) {
					
					/**ƥ��ȱʡ����ʼ*/
					ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
					ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
					ptdCond.setPtdcond_like(ptdcond);
					ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
					flag = true;//trueƥ��,false��ƥ��
					//�޸�prptdcond����¼ֵ��bug��ʼ
					if(ptdList.isEmpty()) {
						flag = false;
					}
					//�޸�prptdcond����¼ֵ��bug����
					for(IG273Info pt:ptdList){
						//prTB.setPrptdcond(null);
						if(pt.getPtdcond().indexOf('|')!=-1){
							if(ptdcond.equals(pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
								//�жϱ�������
								//�Ѷ���ı�������
								String[] vCond = pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//����id
								String[] vsign=new String[vCond.length];//�����߼�����
								String[] vvalue=new String[vCond.length];//����ֵ
								
								for(int i=0; i<vCond.length;i++){
									//һ������Ĳ����ʱ����
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//��������ƥ��
								
								for(int i=0,m=piList.size();i<m;i++){
									flag=true;
									IG599Info pi = piList.get(i);
									String pidid = pi.getPidid();//ҳ���ϵı���ID
									String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
									String pitype = pi.getPivartype();//ҳ���ϵı�����������
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//����ֵ�붨��Ĺ���Ƚ�
											if(StringUtils.isNotEmpty(pivarvalue)){
												if("3".equals(pitype)){//��������
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(!vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 2:
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 3:
														if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
														break;
													case 4:
														if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
														break;
													case 5:
														if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
														break;
													case 6:
														if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
														break;
													}
												}if("A".equals(pitype)){//ʱ������
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(!vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 2:
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 3:
														if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
														break;
													case 4:
														if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
														break;
													case 5:
														if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
														break;
													case 6:
														if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
														break;
													}
												}if("R".equals(pitype)){//��ɫ����
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
														else{
															if(StringUtils.isEmpty(pivarvalue)){
																flag=false;
															}
														}
														break;
													case 2:
														if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													}
												}else if("7".equals(pitype)){//���ֿؼ�
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 2:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 3:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 4:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 5:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 6:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													}
													
												}else if("2".equals(pitype)){//������
													if(!vvalue[j].equals(pivarvalue)){
														flag=false;
													}
												}
											}else{
												flag=false;
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								if(flag){
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									
									//����״̬ԾǨ
									String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid(),prTB,user,roleid,null,
											null,null,authorizeuser, action);
									toStatusList.add(statuscode);
//									return pt.getTpsdid();
								}
							}
						}else{
							//û�б���������ƥ����ԾǨ����.
							if(ptdcond.equals(pt.getPtdcond())){
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//����״̬ԾǨ
								String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid(),prTB,user,roleid,null,
										null,null,authorizeuser, action);
								toStatusList.add(statuscode);
//								return pt.getTpsdid();
							}else{
								flag = false;
							}
						}
					}
					/**ƥ��ȱʡ�������*/
					if(!flag){
						prTB.setPrptdcond(prTB.getPrptdcond() + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT
								+ action + IGPRDCONSTANTS.COND_COND_SPLIT);
						this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
//						return null;
					}
				}
				if(flag){
					prTB.setPrptdcond(prTB.getPrptdcond()+ptdcond);
					this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),
							null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
//					return null;
				}
			}
			}
		}

		// ��¼����״̬��־
		if (toStatusList != null && toStatusList.size() > 0) {
			
			boolean endflag = false;
			
			String[] toStatus = new String[toStatusList.size()];
			String endStatus = "";
			for (int i = 0; i < toStatusList.size(); i++) {
				toStatus[i] = toStatusList.get(i);

				//Ŀ��״̬
				IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(toStatus[i]);
				endStatus = tpsd.getPsdcode();
				
				if ((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()) && StringUtils.isEmpty(tpsd.getPpsdid())) 
						|| (IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode()) && StringUtils.isNotEmpty(tpsd.getPpsdid()))) {
					endflag = true;
				}
			}
			
			//Դ״̬
			IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
			
			//����״̬�����жϣ�0��ʼ��1��ͨ��2����
			int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
			
			//process0001_begin
			//������·�������̣�����״̬��־ӦΪ�գ�����Ϊ���������
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid()))) {
				//process0001_end
				statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
			} else if(endflag) {
				statustype = WorkFlowConstDefine.STATUSTYPE_END;
			}

			// >>>>>>>>>>>>>>>>> update by yangyining 20131028
			IG500Info prinfo = ig500BL.searchIG500InfoByKey(prTB.getPrid());
			IG500TB prtb = (IG500TB)SerializationUtils.clone(prTB);
			prtb.setPrserialnum(prinfo.getPrserialnum());
			prtb.setPrstatus(endStatus);
			prinfo = null;
			// <<<<<<<<<<<<<<<<< update by yangyining 20131028
			
			List<IG224Info> list = ig224BL.searchCurrentIG224InfoByPsdid(prid, fpsd.getPsdid());
			if(list.size() != 1 && !(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid())))){
				throw new BLException("IGSVC0000.E001");
			}
			ig500BL.updateIG500Info(prtb);
			
			//��������״̬��־
			this.addRecordStatusLog(prTB, fpsd, null, toStatus, statustype, user, roleid, authorizeuser, action);
		}
		
		return null;
		
	}
	
	
	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null(�����Զ�������ʱʹ��)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,Integer prid,
			String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {

		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		Integer psdnum = null;
		if (fpsdid.indexOf("_") > -1) {
			psdnum = Integer.parseInt(fpsdid.split("_")[1]);
			fpsdid = fpsdid.split("_")[0];
		}
		
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);

		//ȡ�õ�ǰ����״̬�Ķ���
		IG333Info processStatusDef = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);

		//Ŀ�꼯��
		List<String> toStatusList = new ArrayList<String>();
		
		//ƥ�����������ptdcondֻ��һ����ɫ�Ķ���
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//����ԾǨ����
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		//ptdCond.setPtdcond(ptdcond);
		ptdCond.setPtdcond_like(ptdcond);
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//���ƥ����ԾǨ���ѵ�һ��ƥ������Ϊ׼��ͬʱ���pr��prptdcond��ֵ�����ڴ���´�ԾǨ����
		boolean flag = true;//trueƥ��,false��ƥ��
		List<IG599Info> pilist = this.getProcessInfo(prid);
		String[] pidids = new String[pilist.size()];
		String[] pivarvalues = new String[pilist.size()];
		String[] pitypes = new String[pilist.size()];
		int num=0;
		for(IG599Info pi:pilist){
			pidids[num] = pi.getPidid();
			pivarvalues[num] = pi.getPivarvalue();
			pitypes[num] = pi.getPivartype();
			num++;
		}
		//�޸�prptdcond����¼ֵ��bug��ʼ
		if(ptdList.isEmpty()) {
			flag = false;
		}
		
		//�����Ƿ񷵻ر�������ֹ�����߼��ظ�ִ��
		boolean returnflag = true;
		
		//�޸�prptdcond����¼ֵ��bug����
		for(IG273Info ptd:ptdList){
			//prTB.setPrptdcond(null);
			if(ptd.getPtdcond().indexOf('|')!=-1){
				if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
					//�жϱ�������
					//�Ѷ���ı�������
					String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
					String[] vid=new String[vCond.length];//����id
					String[] vsign=new String[vCond.length];//�����߼�����
					String[] vvalue=new String[vCond.length];//����ֵ
					
					//String[] pidid = igprr0102Form.getPidid();//ҳ���ϵı���ID
					//String[] pivarvalue = igprr0102Form.getPivarvalue();//ҳ���ϵı���ֵ
					//String[] pitype = igprr0102Form.getPivartype();//ҳ���ϵı�����������
					for(int i=0; i<vCond.length;i++){
						//һ������Ĳ����ʱ����
						String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
						vid[i] = temp[0];
						vsign[i] = temp[1];
						vvalue[i] = temp[2];
					}
					//��������ƥ��
					
					for(int i=0,m=pidids.length;i<m;i++){
						flag=true;
						//ProcessInfo pi = piList.get(i);
						String pidid = pidids[i];//ҳ���ϵı���ID
						String pivarvalue = pivarvalues[i];//ҳ���ϵı���ֵ
						String pitype = pitypes[i];//ҳ���ϵı�����������
						for(int j=0,n=vid.length;j<n;j++){
							if(pidid!=null && pidid.toString().equals(vid[j])){
								//����ֵ�붨��Ĺ���Ƚ�
								if(StringUtils.isNotEmpty(pivarvalue)){
									if("3".equals(pitype)){//��������
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("A".equals(pitype)){//ʱ������
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("R".equals(pitype)){//��ɫ����
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
											else{
												if(StringUtils.isEmpty(pivarvalue)){
													flag=false;
												}
											}
											break;
										case 2:
											if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										}
									}else if("7".equals(pitype)){//���ֿؼ�
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 2:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 3:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 4:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 5:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 6:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										}
										
									}else if("2".equals(pitype)){//������
										if(!vvalue[j].equals(pivarvalue)){
											flag=false;
										}
									}
								}else{
									flag=false;
								}
							}
							if(!flag){
								break;
							}
						}
						if(!flag){
							break;
						}
					}
					if(flag){
						//�жϽ�ɫ�ύȨ��
						if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond()) 
									+ psd.getPsdid() + "_" + ptdcond);
							this.updateProcessRecord(prTB);
							returnflag = false;
//							return null;
						} else {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							//����״̬ԾǨ
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
									participants, ppsuper, authorizeuser, action);
							toStatusList.add(statuscode);
							returnflag = false;
//							return ptd.getTpsdid();
						}
					}
				}
			}else{
				//û�б���������ƥ����ԾǨ����.
				if(ptdcond.equals(ptd.getPtdcond())){
					//�жϽ�ɫ�ύȨ��
					if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
								+ psd.getPsdid() + "_" + ptdcond);
						this.updateProcessRecord(prTB);
						returnflag = false;
//						return null;
					} else {
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						//����״̬ԾǨ
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
								participants, ppsuper, authorizeuser, action);
						toStatusList.add(statuscode);
						returnflag = false;
//						return ptd.getTpsdid();
					}
				}
			}
			
		}
		
		if (returnflag) {
		//��ȡԾǨ������ʱ����
		String prptdcond = searchPtdcond(prid, fpsdid);
		
		//ȥ����ͬ�Ĵ���
		{	
			if(StringUtils.isNotEmpty(prptdcond)){
				String[] check = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
				List<String> air = new ArrayList<String>();
				StringBuffer sf = new StringBuffer();
				for(String find:check){
					if(!air.contains(find)){
						sf.append(find).append(IGPRDCONSTANTS.COND_COND_SPLIT);
						air.add(find);
					}
				}
				prptdcond = sf.toString();
			}
			
		}
		
		//�����̵�һ�������߲���
		if(StringUtils.isEmpty(prptdcond)  && (ptdList==null || ptdList.size()==0)) {
			
			/**ƥ��ȱʡ����ʼ*/
			ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
			ptdCond.setPtdcond_like(ptdcond);
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			flag = true;//trueƥ��,false��ƥ��
			//�޸�prptdcond����¼ֵ��bug��ʼ
			if(ptdList.isEmpty()) {
				flag = false;
			}
			//�޸�prptdcond����¼ֵ��bug����
			for(IG273Info ptd:ptdList){
				//prTB.setPrptdcond(null);
				if(ptd.getPtdcond().indexOf('|')!=-1){
					if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
						//�жϱ�������
						//�Ѷ���ı�������
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//����id
						String[] vsign=new String[vCond.length];//�����߼�����
						String[] vvalue=new String[vCond.length];//����ֵ
						
						for(int i=0; i<vCond.length;i++){
							//һ������Ĳ����ʱ����
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//��������ƥ��
						
						for(int i=0,m=pidids.length;i<m;i++){
							flag=true;
							//ProcessInfo pi = piList.get(i);
							String pidid = pidids[i];//ҳ���ϵı���ID
							String pivarvalue = pivarvalues[i];//ҳ���ϵı���ֵ
							String pitype = pitypes[i];//ҳ���ϵı�����������
							for(int j=0,n=vid.length;j<n;j++){
								if(pidid.toString().equals(vid[j])){
									//����ֵ�붨��Ĺ���Ƚ�
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//��������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//ʱ������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//��ɫ����
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//���ֿؼ�
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//������
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						if(flag){
							//�жϽ�ɫ�ύȨ��
							if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
										+ psd.getPsdid() + "_" + ptdcond);
								this.updateProcessRecord(prTB);
								returnflag = false;
//								return null;
							} else {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//����״̬ԾǨ
								String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
										participants, ppsuper, authorizeuser, action);
								toStatusList.add(statuscode);
								returnflag = false;
//								return ptd.getTpsdid();
							}
						}
					}
				}else{
					//û�б���������ƥ����ԾǨ����.
					if(ptdcond.equals(ptd.getPtdcond())){
						//�жϽ�ɫ�ύȨ��
						if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond()) + 
									psd.getPsdid() + "_" + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
							this.updateProcessRecord(prTB);
							returnflag = false;
//							return null;
						} else {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							//����״̬ԾǨ
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
									participants, ppsuper, authorizeuser, action);
							toStatusList.add(statuscode);
							returnflag = false;
//							return ptd.getTpsdid();
						}
					}else{
						flag = false;
					}
				}
			}
			/**ƥ��ȱʡ�������*/
			if(!flag && returnflag){
				prTB.setPrptdcond(roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
				this.updateProcessRecord(prTB);
//				return null;
			}
		} else {//ƥ��������
			if(StringUtils.isEmpty(prptdcond)){
//				return null;
			} else {
			String[] prptdondArray = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_AND);
			
			ptdCond.setPtdcond(null);
			
			ptdCond.setPtdcond_like(ptdcond);
			
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			//true��ƥ��,falseƥ��
			flag = false;//�ж��ԾǨ����ʱ��ÿ�β�ƥ��ʱҪ������һ��ƥ��
			//�޸�prptdcond����¼ֵ��bug��ʼ
			if(ptdList.isEmpty()) {
				flag = true;
			}
			//�޸�prptdcond����¼ֵ��bug����
			for(IG273Info ptd : ptdList) {
				if(ptd.getPtdcond().indexOf('|')!=-1){//�б�������
					String cond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];//��ɫ��������
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//�������������
						Set<String> prcondList = new HashSet<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//ԾǨ��������
						Set<String> condList = new HashSet<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//ƥ��ʱ����������ӦΪ��
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//�����������ƥ�������ɾ��
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//��ȫƥ����ԾǨ
							if(0 == prcondList.size() && 0 == condList.size()) {
								//�����ж�
								boolean vflag = false;//trueƥ��,false��ƥ��
								//�Ѷ���ı�������
								String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//����id
								String[] vsign=new String[vCond.length];//�����߼�����
								String[] vvalue=new String[vCond.length];//����ֵ
								
								//String[] pidid = igprr0102Form.getPidid();//ҳ���ϵı���ID
								//String[] pivarvalue = igprr0102Form.getPivarvalue();//ҳ���ϵı���ֵ
								//String[] pitype = igprr0102Form.getPivartype();//ҳ���ϵı�����������
								for(int i=0; i<vCond.length;i++){
									//һ������Ĳ����ʱ����
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//��������ƥ��
								
								for(int i=0; i<pilist.size();i++){
									vflag=true;
									//ProcessInfo pi = piList.get(i);
									String pidid = pidids[i];//ҳ���ϵı���ID
									String pivarvalue = pivarvalues[i];//ҳ���ϵı���ֵ
									String pitype = pitypes[i];//ҳ���ϵı�����������
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//ȡ����ֵ
											if("3".equals(pitype)){//��������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("R".equals(pitype)){//��ɫ����
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//ʱ������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}else if("7".equals(pitype)){//���ֿؼ�
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 2:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 3:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 4:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 5:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 6:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//������
												if(!vvalue[j].equals(pivarvalue)){
													vflag=false;
												}
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								
								if(vflag){
									//�жϽ�ɫ�ύȨ��
									if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
										IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
										prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
												+ psd.getPsdid() + "_" + ptdcond);
										this.updateProcessRecord(prTB);
										returnflag = false;
//										return null;
									} else {
										prTB.setPrptdcond(null);
										IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
										if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
											prTB.setPrstatus(psd.getPsdcode());
											prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
										}
										//����״̬ԾǨ
										String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
												participants, ppsuper, authorizeuser, action);
										toStatusList.add(statuscode);
										returnflag = false;
//										return ptd.getTpsdid();
									}
								}else{
									flag = true;
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","���������");
						return null;
					}
				}else{//�ޱ�������,��ԭ�߼���ͬ
					String cond = ptd.getPtdcond();
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//�������������
						Set<String> prcondList = new HashSet<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//ԾǨ��������
						Set<String> condList = new HashSet<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//ƥ��ʱ����������ӦΪ��
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//�����������ƥ�������ɾ��
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//��ȫƥ����ԾǨ
							if(0 == prcondList.size() && 0 == condList.size()) {
								//�жϽ�ɫ�ύȨ��
								if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
											+ psd.getPsdid() + "_" + ptdcond);
									this.updateProcessRecord(prTB);
									returnflag = false;
//									return null;
								} else {
									prTB.setPrptdcond(null);
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									//����״̬ԾǨ
									String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
											participants, ppsuper, authorizeuser, action);
									toStatusList.add(statuscode);
									returnflag = false;
//									return ptd.getTpsdid();
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","���������");
						return null;
					}
				}
			}
			if(flag && (ptdList==null || ptdList.size()==0)) {
				
				/**ƥ��ȱʡ����ʼ*/
				ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
				ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
				ptdCond.setPtdcond_like(ptdcond);
				ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
				flag = true;//trueƥ��,false��ƥ��
				//�޸�prptdcond����¼ֵ��bug��ʼ
				if(ptdList.isEmpty()) {
					flag = false;
				}
				//�޸�prptdcond����¼ֵ��bug����
				for(IG273Info pt:ptdList){
					//prTB.setPrptdcond(null);
					if(pt.getPtdcond().indexOf('|')!=-1){
						if(ptdcond.equals(pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
							//�жϱ�������
							//�Ѷ���ı�������
							String[] vCond = pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
							String[] vid=new String[vCond.length];//����id
							String[] vsign=new String[vCond.length];//�����߼�����
							String[] vvalue=new String[vCond.length];//����ֵ
							
							for(int i=0; i<vCond.length;i++){
								//һ������Ĳ����ʱ����
								String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
								vid[i] = temp[0];
								vsign[i] = temp[1];
								vvalue[i] = temp[2];
							}
							//��������ƥ��
							
							for(int i=0,m=pidids.length;i<m;i++){
								flag=true;
								//ProcessInfo pi = piList.get(i);
								String pidid = pidids[i];//ҳ���ϵı���ID
								String pivarvalue = pivarvalues[i];//ҳ���ϵı���ֵ
								String pitype = pitypes[i];//ҳ���ϵı�����������
								for(int j=0,n=vid.length;j<n;j++){
									if(pidid.toString().equals(vid[j])){
										//����ֵ�붨��Ĺ���Ƚ�
										if(StringUtils.isNotEmpty(pivarvalue)){
											if("3".equals(pitype)){//��������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//ʱ������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("R".equals(pitype)){//��ɫ����
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//���ֿؼ�
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 2:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 3:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 4:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 5:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 6:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//������
												if(!vvalue[j].equals(pivarvalue)){
													flag=false;
												}
											}
										}else{
											flag=false;
										}
									}
									if(!flag){
										break;
									}
								}
								if(!flag){
									break;
								}
							}
							if(flag){
								//�жϽ�ɫ�ύȨ��
								if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), pt)) {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
											+ psd.getPsdid() + "_" + ptdcond);
									this.updateProcessRecord(prTB);
									returnflag = false;
//									return null;
								} else {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									//����״̬ԾǨ
									String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
											participants, ppsuper, authorizeuser, action);
									toStatusList.add(statuscode);
									returnflag = false;
//									return pt.getTpsdid();
								}
							}
						}
					}else{
						//û�б���������ƥ����ԾǨ����.
						if(ptdcond.equals(pt.getPtdcond())){
							//�жϽ�ɫ�ύȨ��
							if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), pt)) {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
										+ psd.getPsdid() + "_" + ptdcond);
								this.updateProcessRecord(prTB);
								returnflag = false;
//								return null;
							} else {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//����״̬ԾǨ
								String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
										participants, ppsuper, authorizeuser, action);
								toStatusList.add(statuscode);
								returnflag = false;
//								return pt.getTpsdid();
							}
						}else{
							flag = false;
						}
					}
				}
				/**ƥ��ȱʡ�������*/
				if(!flag && returnflag){
					prTB.setPrptdcond(prTB.getPrptdcond() + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT 
							+ action + IGPRDCONSTANTS.COND_COND_SPLIT);

					this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
					
//					return null;
				}
			}
			if(flag && returnflag){
				prTB.setPrptdcond(prTB.getPrptdcond()+ptdcond);

				this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
						IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
				
//				return null;
			}
			}
		}
		}
	
		// ��¼����״̬��־
		if (toStatusList != null && toStatusList.size() > 0) {
			
			boolean endflag = false;
			
			String[] toStatus = new String[toStatusList.size()];
			String endStatus = "";
			for (int i = 0; i < toStatusList.size(); i++) {
				toStatus[i] = toStatusList.get(i);

				//Ŀ��״̬
				IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(toStatus[i]);
				endStatus = tpsd.getPsdcode();
				
				if ((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()) && StringUtils.isEmpty(tpsd.getPpsdid())) 
						|| (IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode()) && StringUtils.isNotEmpty(tpsd.getPpsdid()))) {
					endflag = true;
				}
			}
			
			//Դ״̬
			IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
			
			//����״̬�����жϣ�0��ʼ��1��ͨ��2����
			int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
			
			//process0001_begin
			//������·�������̣�����״̬��־ӦΪ�գ�����Ϊ���������
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid()))) {
				//process0001_end
				statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
			} else if(endflag) {
				statustype = WorkFlowConstDefine.STATUSTYPE_END;
			}
			
			// >>>>>>>>>>>>>>>>> update by yangyining 20131028
			IG500Info prinfo = ig500BL.searchIG500InfoByKey(prTB.getPrid());
			IG500TB prtb = (IG500TB)SerializationUtils.clone(prTB);
			prtb.setPrserialnum(prinfo.getPrserialnum());
			prtb.setPrstatus(endStatus);
			prinfo = null;
			// <<<<<<<<<<<<<<<<< update by yangyining 20131028
			
			List<IG224Info> list = ig224BL.searchCurrentIG224InfoByPsdid(prid, fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum));
			if(list.size() != 1 && !(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid())))){
				throw new BLException("IGSVC0000.E001");
			}
			ig500BL.updateIG500Info(prtb);
			
			//��������״̬��־
			this.addRecordStatusLog(prTB, fpsd, psdnum, toStatus, statustype, user, roleid, authorizeuser, action);
		}
		
		return null;
	}
	
	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null(�����Զ�������ʱʹ��)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return Integer ԾǨ�������״̬ID
	 */
	public IG333Info checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,Integer prid, User authorizeuser) throws BLException {
		
		//������Ϣ
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
		
		//ԾǨ��ʶ
		boolean flag = true;
		
		//���нڵ�ԾǨ����ΪANY����Ψһ�������в����ɫ�ĸ����˻�ֵ���˵�����һ���Ѿ��ύ��ԾǨ
		//��ȡδ�ύ������
		List<IG337Info> ppTodoList = this.searchProcessParticipantTodoRole(prid, pr.getPrstatus());
		
		//OAģʽ����ɫ�����˻���Ȩֵ�����ύ�����ύ
		if(IGPRDCONSTANTS.MODE_OA.equals(fpsd.getPsdmode())) {
			Set<Integer> ppDoneSet = new HashSet<Integer>();
			Set<String> ppDoneOrgSet = new HashSet<String>();
			//��ȡ���ύ������
			List<IG337Info> ppDoneList = this.searchProcessParticipantDoneRole(prid, pr.getPrstatus());
			//��ȡ���ύ��ɫID����ɫ�����˻�ֵ�����ύ�����ύ
			//�жϲ����������Ƿ�Ϊ����
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(fpsd.getPsdassign())){
				for(IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						ppDoneOrgSet.add(pp.getPporgid());
					}
				}
			}else{
				for(IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						ppDoneSet.add(pp.getPproleid());
					}
				}
			}
			//��δ������ɫ�����Ѵ�����ɫ����ʱ����ԾǨ
			for(IG337Info pp : ppTodoList) {
				if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
						IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
						(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
					//�жϲ����������Ƿ�Ϊ����
					if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(fpsd.getPsdassign())){
						if(!ppDoneOrgSet.contains(pp.getPporgid())) {
							flag = false;
							break;
						}
					}else{
						if(!ppDoneSet.contains(pp.getPproleid())) {
							flag = false;
							break;
						}
					}
				}
			}
		} else {
			//��ͨģʽ����δ�ύ��������ԾǨ
			if(ppTodoList.size() > 0) {
				flag = false;
			}
		}
		
		if(flag) {
			//���нڵ�ԾǨ����ΪANY����Ψһ�������в����߶��Ѿ��ύ��ԾǨ
			IG273SearchCondImpl cond = new IG273SearchCondImpl();
			
			cond.setFpsdid(fpsdid);
			
			cond.setPtdcond(IGPRDCONSTANTS.TRANSITION_RULE_ANY);
			
			List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(cond);
			
			if(ptdList.size() != 1) {
				throw new BLException("IGCO10000.E004","���нڵ�ԾǨ�������");
			}
			//��ȡԾǨ״̬��Ϣ
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptdList.get(0).getTpsdid());
			
			//��������״̬��Ϣ
			IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);
			
			prTB.setPrstatus(ptdList.get(0).getToPSDTB().getPsdcode());//����״̬
			
			prTB.setPrptdcond(null);//ԾǨ����
			
			if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(prTB.getPrstatus())) {
				prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());//�ر�ʱ��
			}
			//����״̬ԾǨ
			this.processStatusTransition(fpsdid,ptdList.get(0).getTpsdid(),prTB,user,roleid,IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY,
					null, null, authorizeuser, action);
			
			this.processAfterTreatmentExecute(prTB, fpsd, psd, user, roleid, authorizeuser, action, null); 
			
			//��������ǰ�����¼�
			this.processPreTreatmentExecute(prTB, fpsd, psd, user, roleid, authorizeuser, action, null);
			
			this.addRecordStatusLog(pr.getPrid(), pr.getPrpdid(), pr.getPrtype(), fpsd.getPsdcode(),
					psd.getPsdcode(), WorkFlowConstDefine.STATUSTYPE_NORMAL, psd.getPsdid(), pr.getPid());
			
			return psd;
		}
		return null;
	}
		
		
		
		
		
		
		
		
	/**
	 * ��ȡ��һ����״̬��ID
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return ProcessStatusDef ԾǨ�������״̬
	 * @throws BLException
	 */
	public IG333Info checkTransition(String fpsdid,Integer roleid,String action,List<IG599Info> piList) throws BLException {
		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		//����
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		//ƥ�����������ptdcondֻ��һ����ɫ�Ķ���
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//����ԾǨ����
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		ptdCond.setPtdcond_like(ptdcond);
		
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//���ƥ����ԾǨ���򷵻�״̬ID��-1��ʾ����
		if(ptdList.size() > 0) {//�Ƿ�����Ծ�����
			boolean flag = true;//trueƥ��,false��ƥ��
			for(IG273Info ptd:ptdList){
				if(ptd.getPtdcond().indexOf('|')!=-1){//�б���ԾǨ����
						//�жϱ�������
						//�Ѷ���ı�������
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//����id
						String[] vsign=new String[vCond.length];//�����߼�����
						String[] vvalue=new String[vCond.length];//����ֵ
						
						//String[] pidid = igprr0102Form.getPidid();//ҳ���ϵı���ID
						//String[] pivarvalue = igprr0102Form.getPivarvalue();//ҳ���ϵı���ֵ
						//String[] pitype = igprr0102Form.getPivartype();//ҳ���ϵı�����������
						for(int i=0; i<vCond.length;i++){
							//һ������Ĳ����ʱ����
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//��������ƥ��
						
						for(int i=0,m=piList.size();i<m;i++){
							flag=true;
							IG599Info pi = piList.get(i);
							String pidid = pi.getPidid();//ҳ���ϵı���ID
							String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
							String pitype = pi.getPivartype();//ҳ���ϵı�����������
							for(int j=0;j<vid.length;j++){
								if(pidid.toString().equals(vid[j])){
									//����ֵ�붨��Ĺ���Ƚ�
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//��������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//ʱ������
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//��ɫ����
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//���ֿؼ�
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//������
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						
						if(flag){//����붨��Ĺ���ƥ��ԾǨ
							return ptd.getToPSDTB();
						}else{//ûƥ�����ȱʡ�����ƥ��
							
						}
				}else{//û�б���ԾǨ����
					
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(ptdList.get(0).getToPSDTB().getPsdcode())) {
						return null;
					}
					return ptdList.get(0).getToPSDTB();
					
				}
			}
			//���û���κι�����ʾ
			//throw new BLException("IGCO10000.E004","�����壨" + ptdcond + "������");
			return null;
		} else {//û����Ծ�������ȱ�ٹ���
				boolean flag = true;//trueƥ��,false��ƥ��
				/**ȱʡ����*/
				ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
				ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
				ptdCond.setPtdcond_like(ptdcond);
				ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
				//�޸�prptdcond����¼ֵ��bug��ʼ
				if(ptdList.isEmpty()) {
					flag = false;
				}
				//�޸�prptdcond����¼ֵ��bug����
				for(IG273Info ptd:ptdList){
					if(ptd.getPtdcond().indexOf('|')!=-1){
						if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
							//�жϱ�������
							//�Ѷ���ı�������
							String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
							String[] vid=new String[vCond.length];//����id
							String[] vsign=new String[vCond.length];//�����߼�����
							String[] vvalue=new String[vCond.length];//����ֵ
							
							//String[] pidid = igprr0102Form.getPidid();//ҳ���ϵı���ID
							//String[] pivarvalue = igprr0102Form.getPivarvalue();//ҳ���ϵı���ֵ
							//String[] pitype = igprr0102Form.getPivartype();//ҳ���ϵı�����������
							for(int i=0; i<vCond.length;i++){
								//һ������Ĳ����ʱ����
								String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
								vid[i] = temp[0];
								vsign[i] = temp[1];
								vvalue[i] = temp[2];
							}
							//��������ƥ��
							
							for(int i=0,m=piList.size();i<m;i++){
								flag=true;
								IG599Info pi = piList.get(i);
								String pidid = pi.getPidid();//ҳ���ϵı���ID
								String pivarvalue = pi.getPivarvalue();//ҳ���ϵı���ֵ
								String pitype = pi.getPivartype();//ҳ���ϵı�����������
								for(int j=0;j<vid.length;j++){
									if(pidid.toString().equals(vid[j])){
										//����ֵ�붨��Ĺ���Ƚ�
										if(StringUtils.isNotEmpty(pivarvalue)){
											if("3".equals(pitype)){//��������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//ʱ������
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("R".equals(pitype)){//��ɫ����
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//���ֿؼ�
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 2:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 3:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 4:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 5:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 6:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//������
												if(!vvalue[j].equals(pivarvalue)){
													flag=false;
												}
											}
										}else{
											flag=false;
										}
									}
									if(!flag){
										break;
									}
								}
								if(!flag){
									break;
								}
							}
							
							if(flag){
								return ptd.getToPSDTB();
							}
						}
					}else{//û�б���������ƥ����ԾǨ����.
						if(ptdcond.equals(ptd.getPtdcond())){
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(ptdList.get(0).getToPSDTB().getPsdcode())) {
								return null;
							}
							return ptdList.get(0).getToPSDTB();
						}else{
							flag = false;
						}
					}
				}
				if(!flag){
					return null;
				}
				/**ȱʡ����*/
				//���û���κι�����ʾ
				//throw new BLException("IGCO10000.E004","�����壨" + ptdcond + "������");
				return null;
		}
	}
	
	/**
	 * <p>
	 * Description: ����ԾǨ 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	
	public synchronized void doFlow(Integer prid, User user,Integer roleid, String datetime, String rolename,
			String psdid,String action,String desc,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {
		//ԾǨ��ť�¼�����
		if(action.compareTo(IGPRDCONSTANTS.BUTTON_SUBMIT) >= 0) {
			WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			bean.setPbdid(action);//��ťID
			if (psdid.indexOf("_") > -1) {
				bean.setBfstatus(psdid.split("_")[0]);//״̬ID
				bean.setBfstatus(psdid.split("_")[1]);//״̬ID���
			} else {
				bean.setBfstatus(psdid);//״̬ID
			}
			//��־������Ϣ
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setPrid(prid);
			logInfo.setExecutorid(user.getUserid());
			logInfo.setExecutorRoleid(roleid);
			if(authorizeuser != null) {
				logInfo.setAuthuserid(authorizeuser.getUserid());
			}
			bean.setLogInfo(logInfo);
			processStatusButtonTreatmentExecute(bean);
		}
		//���нڵ�ԾǨ�����ж�
		if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(nodeType)){
			this.checkAndTransitionForHandel(user,psdid,roleid,action,prid,authorizeuser);
		} else {//��ͨ�ڵ�ԾǨ�����ж�
			this.checkAndTransitionForHandel(user,psdid,roleid,action,prid,nodeType,
					participants, ppsuper, authorizeuser);
		}
		
	}
	
	/**
	 * <p>
	 * Description: ���Ӳ�����
	 * </p>
	 * 
	 * @param tpsdid tpsdid
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public List<IG337Info> addParticipants(String tpsdid,User user,Integer prid,Integer roleid,String desc,String nodetype,
			Map<Integer, List<String>> participants, String ppsuper,User authorizeuser, String pbdid, String prstatus) throws BLException {
		String psdid = "";
		Integer psdnum = null;
		if (tpsdid.indexOf("_") > -1) {
			psdid = tpsdid.split("_")[0];
			psdnum = Integer.parseInt(tpsdid.split("_")[1]);
		} else {
			psdid = tpsdid;
		}
		
		//��ȡָ��״̬�µĲ�����
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(psdid);
		List<IG222Info> ppdList = workFlowDefinitionBL.searchParticipantDef(ppdCond);
		//ԾǨ״̬
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//ԾǨ��ԭ״̬ʱҪ����ղ����ߵĴ������ʱ��
//		List<IG337Info> ppList = this.searchProcessParticipant(prid, 
//				psd.getPsdcode());
		IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
		ppCond.setPrid(prid);
		ppCond.setPsdid(psdid);
		ppCond.setPsdnum(psdnum);
		List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
		//��¼���ɵĲ�������Ϣ
		Set<String> idSet = new HashSet<String>();
		//����ʱ����մ����˵��ύʱ����ύ��ť
		for(IG337Info pp:ppList){
			if(StringUtils.isNotEmpty(pp.getPpuserid())) {
				idSet.add(pp.getPproleid() + "_" + pp.getPpuserid());
			}
			idSet.add(pp.getPproleid() + "_");
			IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
			processParticipant.setPpinittime(IGStringUtils.getCurrentDateTime());
			processParticipant.setPpproctime(null);
			processParticipant.setPbdid(null);
			this.updateProcessParticipant(processParticipant);
		}
		
		//������̻��˵�����ڵ�,ֻ����ԭ����������Ϣ����������Ĭ�ϲ�����  wangtingzhi 20130124
		if("Z".equals(psd.getPsdcode())){
			return null;
		}
		
		//ģ��
		IG337TB participant_temp = this.getProcessParticipantTBInstance();
		participant_temp.setPrid(prid);
		participant_temp.setPpinittime(IGStringUtils.getCurrentDateTime());
		participant_temp.setPpstatus(workFlowDefinitionBL.searchProcessStatusDefByKey(psdid).getPsdcode());
		participant_temp.setPsdid(psdid);
		participant_temp.setPsdnum(psdnum);
		participant_temp.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
		
		//����������
		List<IG337Info> participantList= new ArrayList<IG337Info>();
		//���Ӳ��нڵ������,roleids���в�Ϊ��id��Ϊ��̬���ɵ�
		if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())) {
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
				if(IGPRDCONSTANTS.ASSIGN_NO.equals(psd.getPsdflag())){
					if(ppdList!=null){
						//��ѯ���������ý�ɫ
						List<Integer> roles_a = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
						if(roles_a==null||roles_a.isEmpty()){
							throw new BLException("IGCO10000.E004","�����˻���");
						}
						//��ѯֵ�������ý�ɫ
						List<Integer> roles_b = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
						//��ѯ��Ӧ�����ĸ�������Ϣ
						UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
						List<UserRoleInfo> urList = null;
						for(IG222Info ppd:ppdList){
							if(StringUtils.isNotEmpty(ppd.getOrgid())){
								urcond.setOrgid_like(ppd.getOrgid());
								urcond.setRoleid_in(roles_a);
								urList = userRoleBL.searchUserRoleVW(urcond);
								if(urList == null||urList.isEmpty()){
									throw new BLException("IGCO10000.E004","��"+ ppd.getOrg().getOrgname() + "�������˻���");
								}else{
									for(UserRoleInfo ur:urList){
										IG337TB ppTB = getProcessParticipantTBInstance();
										ppTB.setPrid(prid);
										ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
										ppTB.setPpstatus(psd.getPsdcode());
										ppTB.setPsdid(psdid);
										ppTB.setPsdnum(psdnum);
										ppTB.setPproleid(ur.getRoleid());
										ppTB.setPprolename(ur.getRolename());
										ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
										ppTB.setPpuserid(ur.getUserid());
										ppTB.setPpusername(ur.getUsername());
										ppTB.setPporgid(ppd.getOrgid());
										ppTB.setPporgname(ppd.getOrg().getOrgname());
										ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
										if(StringUtils.isNotEmpty(ppd.getPpdsuper())) {
											ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
										}
										participantList.add(ppTB);
									}
								}
								if(roles_b != null&&!roles_b.isEmpty()){
									urcond.setRoleid_in(roles_b);
									urList = userRoleBL.searchUserRoleVW(urcond);
									if(urList!=null){
										for(UserRoleInfo ur:urList){
											IG337TB ppTB = getProcessParticipantTBInstance();
											ppTB.setPrid(prid);
											ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
											ppTB.setPpstatus(psd.getPsdcode());
											ppTB.setPsdid(psdid);
											ppTB.setPsdnum(psdnum);
											ppTB.setPproleid(ur.getRoleid());
											ppTB.setPprolename(ur.getRolename());
											ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
											ppTB.setPpuserid(ur.getUserid());
											ppTB.setPpusername(ur.getUsername());
											ppTB.setPporgid(ppd.getOrgid());
											ppTB.setPporgname(ppd.getOrg().getOrgname());
											ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
											if(StringUtils.isNotEmpty(ppd.getPpdsuper())) {
												ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
											}
											participantList.add(ppTB);
										}
									}
								}
							}
						}
					}
				}
			}else{
				if(!ppdList.isEmpty() && (participants == null || participants.size() == 0)){//��ǰ̨ҳ����ɵ�
					//�趨Ĭ�ϲ�����
					for(IG222Info ppd : ppdList) {
						if(idSet.contains(ppd.getRoleid() + "_")) {
							continue;
						}
						idSet.add(ppd.getRoleid() + "_");
						if(participants == null) {
							participants = new LinkedHashMap<Integer, List<String>>();
						}
						participants.put(ppd.getRoleid(), null);//OAģʽֻ��Ҫ��ɫ
					}
				}
				
				UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
				List<UserInfo> uilist = null;
				if(participants != null) {
					Set<Map.Entry<Integer, List<String>>> set = participants.entrySet();
					if(set.size() > 0) {
						Map.Entry<Integer, List<String>> entry = null;
						Role role = null;
						for(Iterator<Map.Entry<Integer, List<String>>> iter = set.iterator();iter.hasNext();){
							entry = iter.next();
							role = this.roleBL.searchRoleByKey(entry.getKey());
							cond.setRoleida(role.getRoleid());
							//�����OAģʽ����ֵ���˺ͽ�ɫ��������Ϊ������
							uilist = this.userBL.searchUserInfo(cond);
							//��ɫ�����˴��ڱ�ʶ
							boolean flag = true;
							for(UserInfo info : uilist) {
								//�Ƿ��ɫ������
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
									flag = false;
									IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
									newParticipantTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
									newParticipantTB.setPpuserid(info.getUserida());
									newParticipantTB.setPpusername(info.getUsername());
									newParticipantTB.setPporgid(info.getOrgida());
									newParticipantTB.setPporgname(info.getOrgname());
									if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
											&& role.getRoleid().toString().equals(ppsuper)) {
										newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
									}
									newParticipantTB.setPproleid(role.getRoleid());
									newParticipantTB.setPprolename(role.getRolename());
									newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
									participantList.add(newParticipantTB);
								}
								//�Ƿ�ֵ����
								if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
									IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
									newParticipantTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
									newParticipantTB.setPpuserid(info.getUserida());
									newParticipantTB.setPpusername(info.getUsername());
									newParticipantTB.setPporgid(info.getOrgida());
									newParticipantTB.setPporgname(info.getOrgname());
									if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
											&& role.getRoleid().toString().equals(ppsuper)) {
										newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
									}
									newParticipantTB.setPproleid(role.getRoleid());
									newParticipantTB.setPprolename(role.getRolename());
									newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
									participantList.add(newParticipantTB);
								}
							}
							
							if(flag) {
								throw new BLException("IGCO10000.E004","��ɫ��"+ role.getRolename() + "�������˻���");
							}
						}
					}
				}
			}
		} else {
			if(participants != null){
				//������ʱûѡ���ˣ��ڶ���ʱָ�����ˣ��򽫸��˱���
				for(IG222Info ppd : ppdList) {
					if(StringUtils.isNotEmpty(ppd.getUserid())) {
						if(participants.containsKey(ppd.getRoleid())) {
							 if(participants.get(ppd.getRoleid()) == null) {
								 participants.put(ppd.getRoleid(), new ArrayList<String>());
								 participants.get(ppd.getRoleid()).add(ppd.getUserid());
							 } else if(participants.get(ppd.getRoleid()).isEmpty()) {
								 participants.get(ppd.getRoleid()).add(ppd.getUserid());
							 }
						}
					}
				}
				Set<Map.Entry<Integer, List<String>>> set = participants.entrySet();
				if(set.size() > 0) {
					Map.Entry<Integer, List<String>> entry = null;
					User participant = null;
					Role role = null;
					for(Iterator<Map.Entry<Integer, List<String>>> iter = set.iterator();iter.hasNext();){
						entry = iter.next();
						role = this.roleBL.searchRoleByKey(entry.getKey());
						if(entry.getValue() == null || entry.getValue().isEmpty()) {
							if(idSet.contains(role.getRoleid() + "_")) {
								continue;
							}
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
							if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
									&& role.getRoleid().toString().equals(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							newParticipantTB.setPproleid(role.getRoleid());
							newParticipantTB.setPprolename(role.getRolename());
							idSet.add(newParticipantTB.getPproleid() + "_");
							participantList.add(newParticipantTB);
						} else {
							for(String userid : entry.getValue()) {
								if(idSet.contains(role.getRoleid() + "_" + userid)) {
									continue;
								}
								participant = this.userBL.searchUserByKey(userid);
								IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
								if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
										&& role.getRoleid().toString().equals(ppsuper)) {
									newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
								}
								newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
								newParticipantTB.setPproleid(role.getRoleid());
								newParticipantTB.setPprolename(role.getRolename());
								newParticipantTB.setPpuserid(userid);
								newParticipantTB.setPpusername(participant.getUsername());
								newParticipantTB.setPporgid(participant.getOrgid());
								newParticipantTB.setPporgname(participant.getOrgname());
								idSet.add(newParticipantTB.getPproleid() + "_" + userid);
								idSet.add(newParticipantTB.getPproleid() + "_");
								participantList.add(newParticipantTB);
							}
						}
					}
				}
			}
			if(!ppdList.isEmpty() && (participants == null || participants.size() == 0)){//��ǰ̨ҳ����ɵ�
				//�趨Ĭ�ϲ�����
				for(IG222Info ppd : ppdList) {
					if(idSet.contains(ppd.getRoleid() + "_" + (ppd.getUserid() == null ? "" : ppd.getUserid()))) {
						continue;
					}
					IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
					newParticipantTB.setPproleid(ppd.getRoleid());
					newParticipantTB.setPprolename(ppd.getRole().getRolename());
					if(StringUtils.isNotEmpty(ppd.getUserid())){
						newParticipantTB.setPpuserid(ppd.getUserid());
						newParticipantTB.setPpusername(ppd.getUser().getUsername());
						newParticipantTB.setPporgid(ppd.getUser().getOrgid());
						newParticipantTB.setPporgname(ppd.getUser().getOrgname());
						newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					}
					if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
								&& ppd.getRoleid().toString().equals(ppsuper)) {	
						newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
					}
					idSet.add(newParticipantTB.getPproleid() + "_" + (ppd.getUserid() == null ? "" : ppd.getUserid()));
					participantList.add(newParticipantTB);
				}
			}
		}
		//���Ӳ�����
		for(IG337Info pp : participantList) {
			this.addProcessParticipant(pp,user,roleid,
					"���ӣ�" + pp.getPprolename()
					+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
					IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,
					null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, pbdid, prstatus);
		}
		

		return participantList;
	}
	
	/**
	 * <p>
	 * Description: ���Ӳ�����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	public void addParticipant(User user,Integer prid, String pdid, String psdid,
			String executorRoleid, String executorUserid, String ppsuper,User authorizeuser, String pbdid, String prstatus
			) throws BLException {
		Integer psdnum = null;
		String npsdid = "";
		if (psdid.indexOf("_") > -1) {
			npsdid = psdid.split("_")[0];
			psdnum = Integer.parseInt(psdid.split("_")[1]);
		} else {
			npsdid = psdid;
		}
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(pdid);
//		psdCond.setPsdcode(psdcode);
		psdCond.setPsdid(npsdid);
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
		if(lst_ProcessStatusDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "״̬��" + psdid + "��");
		} else if(lst_ProcessStatusDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "״̬��" + psdid + "��");
		}
		String log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
		if((pbdid != null &&
				!IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(lst_ProcessStatusDef.get(0).getPsdtype())
						&&!IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(lst_ProcessStatusDef.get(0).getPsdtype())
				&& pbdid.compareTo("10") >= 0)) {
			log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_CL;
		}
		
			//�жϲ���������Ϊ�������ǽ�ɫ
			//������Ϊ������ֻ����oaģʽ�����Ժ��Ի���ģʽ�ж�
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(lst_ProcessStatusDef.get(0).getPsdassign())){
				//��ѯ������Ϣ
				OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
				orgcond.setOrgsyscoding(executorRoleid);
				List<Organization> orgList = organizationBL.searchOrganization(orgcond);
				if(orgList == null || orgList.size() != 1){
					throw new BLException();
				}
				//��ѯ���������ý�ɫ
				List<Integer> roles = null; 
				roles = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
				List<IG337Info> ppList = new ArrayList<IG337Info>();
				//��ѯ��Ӧ�����ĸ�������Ϣ
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setRoleid_in(roles);
				urcond.setOrgid_like(executorRoleid);
				List<UserRoleInfo> urList = null;
				if(roles == null){
					throw new BLException("IGCO10000.E004","��"+ orgList.get(0).getOrgname() + "�������˻���");
				}else{
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList!=null){
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = getProcessParticipantTBInstance();
							ppTB.setPrid(prid);
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(executorRoleid);
							ppTB.setPporgname(orgList.get(0).getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							ppTB.setPsdid(npsdid);
							ppTB.setPsdnum(psdnum);
							ppList.add(ppTB);
						}
					}
					if(ppList.size()==0){
						throw new BLException("IGCO10000.E004","��"+ orgList.get(0).getOrgname() + "�������˻���");
					}
				}
				roles = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
				urcond.setRoleid_in(roles);
				if(roles!=null){
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList!=null){
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = getProcessParticipantTBInstance();
							ppTB.setPrid(prid);
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(executorRoleid);
							ppTB.setPporgname(orgList.get(0).getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							ppTB.setPsdid(npsdid);
							ppTB.setPsdnum(psdnum);
							ppList.add(ppTB);
						}
					}
				}
				for(IG337Info pp:ppList){
					addProcessParticipant(pp, user, pp.getPproleid(),
							"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")���ӣ�" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
							null, log_type, authorizeuser, pbdid, prstatus);
				}
			}else{
				//�����߽�ɫ
				Role role = roleBL.searchRoleByKey(Integer.valueOf(executorRoleid));
				IG337TB instance = getProcessParticipantTBInstance();
				instance.setPrid(prid);
				instance.setPpinittime(IGStringUtils.getCurrentDateTime());
				instance.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
				instance.setPproleid(role.getRoleid());
				instance.setPprolename(role.getRolename());
				instance.setPsdid(npsdid);
				instance.setPsdnum(psdnum);
				if(IGPRDCONSTANTS.MODE_OA.equals(lst_ProcessStatusDef.get(0).getPsdmode())) {
					//��ɫ�����˴��ڱ�ʶ
					boolean flag = true;
					UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
					cond.setRoleida(role.getRoleid());
					List<UserInfo> uilist = this.userBL.searchUserInfo(cond);
					//�����OAģʽ����ֵ���˺ͽ�ɫ��������Ϊ������
					for(UserInfo info : uilist) {
						//�Ƿ��ɫ������
						if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
							flag = false;
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(instance);
							newParticipantTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							newParticipantTB.setPpuserid(info.getUserida());
							newParticipantTB.setPpusername(info.getUsername());
							newParticipantTB.setPporgid(info.getOrgida());
							newParticipantTB.setPporgname(info.getOrgname());
							newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							addProcessParticipant(newParticipantTB, user, Integer.valueOf(executorRoleid),
									"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")���ӣ�" + newParticipantTB.getPprolename()
									+ (StringUtils.isEmpty(newParticipantTB.getPpusername()) ? "" : "(" + newParticipantTB.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
									null, log_type, authorizeuser, pbdid, prstatus);
						}
						//�Ƿ�ֵ����
						if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(instance);
							newParticipantTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
							newParticipantTB.setPpuserid(info.getUserida());
							newParticipantTB.setPpusername(info.getUsername());
							newParticipantTB.setPporgid(info.getOrgida());
							newParticipantTB.setPporgname(info.getOrgname());
							newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							addProcessParticipant(newParticipantTB, user, Integer.valueOf(executorRoleid),
									"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")���ӣ�" + newParticipantTB.getPprolename()
									+ (StringUtils.isEmpty(newParticipantTB.getPpusername()) ? "" : "(" + newParticipantTB.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
									null, log_type, authorizeuser, pbdid, npsdid);
						}
					}
					
					if(flag) {
						throw new BLException("IGCO10000.E004","��ɫ��"+ role.getRolename() + "�������˻���");
					}
				} else {
					if(StringUtils.isEmpty(executorUserid)) {
						instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
					} else {
						//�����û�
						User executor = userBL.searchUserByKey(executorUserid);
						instance.setPpuserid(executor.getUserid());
						instance.setPpusername(executor.getUsername());
						instance.setPporgid(executor.getOrgid());
						instance.setPporgname(executor.getOrgname());
						instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					}
					addProcessParticipant(instance, user, Integer.valueOf(executorRoleid),
							"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")���ӣ�" + instance.getPprolename()
							+ (StringUtils.isEmpty(instance.getPpusername()) ? "" : "(" + instance.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
							null, log_type, authorizeuser, pbdid, prstatus);
				}
			
			}
		
	}
	
	/**
	 * ��������״̬�����������¼�����
	 * 
	 * @param srcStatus ����ԾǨʱ״̬����Դ״̬
	 * @param processRecord ������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid ������ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 * @param pbdid ������ťID
	 * @return ������Ϣ
	 * @throws BLException
	 */
	private String processStatusTransition(String fpsdid, String tpsdid, IG500Info processRecord, 
			User user, Integer roleid,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser, String pbdid) throws BLException {
		
		//Դ״̬
		IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
		
		//ԾǨ״̬
		IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(tpsdid.indexOf("_") > -1 ? tpsdid.split("_")[0] : tpsdid);
		
		//�ǽ���״̬
		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode())) {
			//���Ӳ�����
			this.addParticipants(tpsdid , user, processRecord.getPrid(), roleid, "",nodeType,
					participants, ppsuper, authorizeuser, pbdid, fpsd.getPsdid());
			
		}
		
//		//�������̺����¼�
//		this.processAfterTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid);
		
//		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
//		IG500Info prinfo = ig500BL.searchIG500InfoByKey(processRecord.getPrid());
//		IG500TB prtb = (IG500TB)SerializationUtils.clone(processRecord);
//		prtb.setPrserialnum(prinfo.getPrserialnum());
//		processRecord = prtb;
//		prinfo = null;
//		// <<<<<<<<<<<<<<<<< update by yangyining 20131028
		
		// ��¼��־
		addRecordLog(processRecord.getPrid(), user, roleid, "", 
				IGPRDCONSTANTS.COMMENT_TRANSITION_MESSAGE + tpsd.getPsdname(), null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, pbdid, fpsd.getPsdid());
		
//		//��������״̬
//		this.updateProcessRecord(fpsd.getPsdcode(), processRecord,
//				user,roleid, "", IGPRDCONSTANTS.COMMENT_TRANSITION_MESSAGE + tpsd.getPsdname(),
//				null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, pbdid);

//		//����״̬�����жϣ�0��ʼ��1��ͨ��2����
//		int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
//		
//		//process0001_begin
//		//������·�������̣�����״̬��־ӦΪ�գ�����Ϊ���������
//		if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && searchRecordStatusLog(processRecord.getPrid()).isEmpty()) {
//		//process0001_end
//			statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
//		} else if((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()))) {
//			statustype = WorkFlowConstDefine.STATUSTYPE_END;
//		}
//		
//		//��������״̬��־
//		this.addRecordStatusLog(processRecord.getPrid(), fpsd.getPdid(), processRecord.getPrtype(), 
//				fpsd.getPsdcode(), tpsd.getPsdcode(), statustype);
		//�ǽ���״̬
//		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode())) {
//			
//			//ǰ����
//			this.prInfoPretreatment(tpsdid, processRecord.getPrid(), processRecord.getPrrolename(),user,roleid, pbdid);
//			
//		}
//		//��������ǰ�����¼�
//		this.processPreTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid);
//		//�������̶��߳�����
//		this.processThreadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
//		
//		//��ȡ��һ״̬������
//		List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//				tpsd.getPsdcode());
//		List<String> lst_Userid = new ArrayList<String>();
//		List<Integer> lst_Roleid = new ArrayList<Integer>();
//		if(!ppList.isEmpty()) {
//			for(IG337Info pp:ppList){
//				if(StringUtils.isEmpty(pp.getPpuserid())) {
//					lst_Roleid.add(pp.getPproleid());
//				} else {
//					lst_Userid.add(pp.getPpuserid());
//				}
//			}
//			sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, processRecord);
//		}
		
		return tpsd.getPsdid();
	}
	
	/**
	 * ����֪ͨ
	 * @param status ״̬��ʶ
	 * @param lst_Userid �û�ID�б�
	 * @param sms ��������
	 * @param lst_Roleid ��ɫID�б�
	 * @param title ����
	 * @param content �ʼ�����
	 * @param ig500 ������Ϣ
	 * @throws BLException
	 */
	public void sendMessage(String status, List<String> lst_Userid, String sms,
			List<Integer> lst_Roleid, String title, String content, IG500Info ig500) throws BLException {
		//��ѯ����
		IG212Info instance = this.ig212BL.searchIG212InfoByPK(
				new IG212PK(status, IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO));
		if(instance != null) {
			//ȡ��֪ͨ�Ķ���ģ������
			List<String> lstMessage = getSendMessage();
			//������Ҫ�滻�Ĳ���
			List<String> argStr = null;
			//ȡ���滻ģ��Ĳ���
			argStr = new ArrayList<String>();
			//��ѯ״̬����
			
			List<String> list = searchCurrentRecordStatus(ig500.getPrid());
			
			StringBuffer currentStatusNames = new StringBuffer();
			for(int i=0;i<list.size();i++){
				if(i > 0){
					currentStatusNames.append(",");
				}
				IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(list.get(i));
				currentStatusNames.append(psd.getPsdname());
			}
			//ָ���滻��״̬����
			argStr.add(currentStatusNames.toString());
			//ָ���滻�Ĺ�����
			argStr.add(ig500.getPrserialnum());
			//ָ���滻�Ĺ�������
			argStr.add(ig500.getPrtitle());
			//�ʼ�������ƽ̨URL
//			argStr.add(ResourceUtility.getString("HOME_URL"));
			
			//ȡ���滻�������֪ͨ����
			if(StringUtils.isEmpty(sms)) {
				sms = replaceMessage(lstMessage.get(0),argStr);
			}
			//ȡ���滻�������֪ͨ����
			if(StringUtils.isEmpty(title)) {
				title = replaceMessage(lstMessage.get(1),argStr);
			}
			if(StringUtils.isEmpty(content)) {
				content = replaceMessage(lstMessage.get(2),argStr);
			}
			
			//֪ͨ�����¼�ȡ��
			//ȡ�����̶���
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(ig500.getPrpdid());
			if(StringUtils.isNotEmpty(pd.getMessagegenerator())){
				 igflowlog.debug("========================"
		                    + ig500.getPrserialnum()
		                    + "ǰ�����¼���ʼ========================");
				    igflowlog.debug("�����������ƣ�" + ig500.getPrpdname());
				    igflowlog.debug("��������ID��" + ig500.getPrpdid());
				    igflowlog.debug("����ID��" + ig500.getPrid());
				    WorkFlowMessageGeneratorBL bl = (WorkFlowMessageGeneratorBL)WebApplicationSupport.getBean(pd.getMessagegenerator());
				    //ִ�г�ʼ������
				    bl.init(ig500.getPrid(),currentStatusNames.toString());
				    //ȡ�ñ�����Ϣ
				    String ctitle = bl.titleGenerator();
				    if(StringUtils.isNotEmpty(ctitle)){
				    	title = ctitle;
				    }
				    //�ʼ�����ȡ��
				    String ccontent = bl.contentGenerator();
				    if(StringUtils.isNotEmpty(ccontent)){
				    	content = ccontent;
				    }
				    //��������ȡ��
				    String csms = bl.smsGenerator();
				    if(StringUtils.isNotEmpty(csms)){
				    	sms = csms;
				    }
				    igflowlog.debug("========================"
		                    + ig500.getPrserialnum()
		                    + "ǰ�����¼�����========================");
			}
			//���Ͷ���
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(instance.getSms())) {
				//�û�
				if(lst_Userid != null) {
					for(String userid : lst_Userid) {
						this.sendMessageBL.sendSmsToUser(userid, sms);
					}
				}
				//��ɫ
				if(lst_Roleid != null) {
					for(Integer roleid : lst_Roleid) {
						this.sendMessageBL.sendSmsToRole(roleid, sms);
					}
				}
			}
			//�����ʼ�
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(instance.getEmail())) {
				//�û�
				if(lst_Userid != null) {
					//�û�
					for(String userid : lst_Userid) {
						//ȡ�÷����˵��ʼ���ַ
						User sendUser = userBL.searchUserByKey(userid);
						if(sendUser.getUseremail() != null && sendUser.getUseremail().length() > 0){
							//�����ʼ�
							String[] address = new String[1];
							address[0] = sendUser.getUseremail();
							this.sendMailBL.sendMail(title, content, address);
						}else{
							log.debug("�û���"+sendUser.getUsername()+"��������û������,�޷������ʼ�֪ͨ��");
						}
					}
				}
				//��ɫ
				if(lst_Roleid != null) {
					//ȡ�÷��ͽ�ɫ�ĸ�����
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRolemanager(true);
					for(Integer roleid : lst_Roleid) {
						cond.setRoleid(roleid);
						List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
						for(UserRoleInfo info: userRole){
							User sendUser = userBL.searchUserByKey(info.getUserid());
							if(sendUser.getUseremail() != null && sendUser.getUseremail().length() > 0){
								String[] address = new String[1];
								address[0] = sendUser.getUseremail();
								this.sendMailBL.sendMail(title, content, address);
							}else{
								log.debug("�û���"+sendUser.getUsername()+"��������û������,�޷������ʼ�֪ͨ��");
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * ���̴��������¼�
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @param pbdid ������ťID
	 */
	public void processAfterTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) throws BLException {
		//�Զ����¼�����BL
		WorkFlowEventHandlerBL bl = null;
		//��ȡԴ״̬�����¼��б�
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPdid(processRecord.getPrpdid());//���̶���ID
		cond.setPsdid(fpsd.getPsdid());//Դ״̬ID
		cond.setPedtype(IGPRDCONSTANTS.AFTERTREATMENT);//��������
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if (pedList.size() > 0 ) {
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "�����¼���ʼ========================");
		    igflowlog.debug("�����������ƣ�" + processRecord.getPrpdname());
		    igflowlog.debug("��������ID��" + processRecord.getPrpdid());
            igflowlog.debug("����ID��" + processRecord.getPrid());
            igflowlog.debug("����Դ״̬��" + fpsd.getPsdname()+ "("+fpsd.getPsdid()+")");
            igflowlog.debug("����ԾǨ״̬��" + tpsd.getPsdname()+ "("+tpsd.getPsdid()+")");
            igflowlog.debug("�����û�ID��" + user.getUserid());
            igflowlog.debug("������ɫID��" + roleid);
            igflowlog.debug("��Ȩ��ID��" + (authorizeuser == null ? "" : authorizeuser.getUserid()));
            igflowlog.debug("������ťID��" + pbdid);
		    for(IG413Info ped : pedList) {
	            try {
	                bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
	            } catch (Exception e) {
	                throw new BLException("IGCO10000.E004", "�����¼�����");
	            }
	            igflowlog.debug("����BL" + ped.getPedorder()+":"+ ped.getPedblid());
	            bl.afterTreatmentExecute(initWorkFlowStatusEventBean(processRecord, fpsd, tpsd, user, roleid,
	                    authorizeuser, pbdid,psdnum));
	        }
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "�����¼�����========================");
		}
		
	}
	
	/**
	 * ���̴���ǰ�����¼�
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 * @param authorizeuser��Ȩ���û���Ϣ
	 * @param pbdid ������ťID
	 */
	public void processPreTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) throws BLException {
		//�Զ����¼�����BL
		WorkFlowEventHandlerBL bl = null;
		//��ȡԾǨ״̬ǰ�����¼��б�
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPsdid(tpsd.getPsdid());//ԾǨ״̬ID
		cond.setPedtype(IGPRDCONSTANTS.PRETREATMENT);//ǰ��������
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if (pedList.size() > 0 ) {
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "ǰ�����¼���ʼ========================");
		    igflowlog.debug("�����������ƣ�" + processRecord.getPrpdname());
		    igflowlog.debug("��������ID��" + processRecord.getPrpdid());
		    igflowlog.debug("����ID��" + processRecord.getPrid());
            igflowlog.debug("����Դ״̬��" + fpsd.getPsdname() + "("+fpsd.getPsdid()+")");
            igflowlog.debug("����ԾǨ״̬��" + tpsd.getPsdname()+ "("+tpsd.getPsdid()+")");
            igflowlog.debug("�����û�ID��" + user.getUserid());
            igflowlog.debug("������ɫID��" + roleid);
            igflowlog.debug("��Ȩ��ID��" + (authorizeuser == null ? "" : authorizeuser.getUserid()));
            igflowlog.debug("������ťID��" + pbdid);
    		for(IG413Info ped : pedList) {
    			try {
    				bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
    			} catch (Exception e) {
    				throw new BLException("IGCO10000.E004", "ǰ�����¼�����");
    			}
    			igflowlog.debug("����BL"+ ped.getPedorder()+":" + ped.getPedblid());
    			bl.preTreatmentExecute(initWorkFlowStatusEventBean(processRecord, fpsd, tpsd, user, roleid,
    					authorizeuser, pbdid,psdnum));
    		}
    		igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "ǰ�����¼�����========================");
		}
	}
	
	/**
	 * ��ʼ��ǰ������������
	 * 
	 * @param processRecord ������Ϣ
	 * @param fpsd ����Դ״̬��Ϣ
	 * @param tpsd ����ԾǨ״̬��Ϣ
	 * @param user ��¼�û���Ϣ
	 * @param roleid ������ɫID
	 * @param authorizeuser ��Ȩ���û���Ϣ
	 * @param pbdid ������ťID
	 * @return ǰ������������
	 */
	private WorkFlowStatusEventBeanInfo initWorkFlowStatusEventBean(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) {
		///�Զ������̸��죬״̬code�뽫������ʵ�����壬����״̬��ѯ�����˽���״̬����ID����
		///status ԭΪ״̬code������Ϊ״̬����ID
		///wangtingzhi 20140513
		//ǰ����������Ϣ
		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPdid(processRecord.getPrpdid());
		bean.setPbdid(pbdid);
//		bean.setBfstatus(fpsd.getPsdcode());
//		bean.setAfstatus(tpsd.getPsdcode());
		bean.setBfstatus(fpsd.getPsdid());
		bean.setAfstatus(tpsd.getPsdid());
		bean.setCrtroleid(processRecord.getPrroleid());
		bean.setCrtuserid(processRecord.getPruserid());
		bean.setPsdnum(psdnum);
		//��־������Ϣ
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(processRecord.getPrid());
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(roleid);
		if(authorizeuser != null) {
			logInfo.setAuthuserid(authorizeuser.getUserid());
		}
		bean.setLogInfo(logInfo);
		return bean;
	}
	
	/**
	 * ���̴���ǰ�����¼�
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 * @param authorizeuser��Ȩ���û���Ϣ
	 */
	public void processStatusButtonTreatmentExecute(WorkFlowStatusEventBean bean) throws BLException {
		//�Զ����¼�����BL
		WorkFlowStatusButtonHandlerBL bl = null;
		
		//��ȡԾǨ״̬ǰ�����¼��б�
		IG156SearchCondImpl cond = new IG156SearchCondImpl();
		cond.setPsdid(bean.getBfstatus());
		cond.setPsebuttonid(bean.getPbdid());
		List<IG156Info> psbList = workFlowDefinitionBL.searchProcessStatusButtonDef(cond);
		for(IG156Info info : psbList) {
			try {
				bl = (WorkFlowStatusButtonHandlerBL)WebApplicationSupport.getBean(info.getPseactionid());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004","��ť�¼�����");
			}
			igflowlog.debug("========================���ð�ť�¼���ʼ========================");
            igflowlog.debug("����ID��" + bean.getLogInfo().getPrid());
            igflowlog.debug("����״̬��ʶ��" + bean.getBfstatus());
            igflowlog.debug("������ťID��" + bean.getPbdid());
            igflowlog.debug("�����û�ID��" + bean.getLogInfo().getExecutorid());
            igflowlog.debug("������ɫID��" + bean.getLogInfo().getExecutorRoleid());
            igflowlog.debug("����BL��" + info.getPseactionid());
			bl.statusButtonTreatmentExecute(bean);
			igflowlog.debug("========================���ð�ť�¼�����========================");
		}
	}
	
	/**
	 * ���̶��߳�������
	 * 
	 * @param processRecord������Ϣ
	 * @param fpsd����Դ״̬��Ϣ
	 * @param tpsd����ԾǨ״̬��Ϣ
	 * @param user��¼�û���Ϣ
	 * @param roleid������ɫID
	 */
	public void processThreadTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid) throws BLException {
		//�Զ����¼�����BL
		WorkFlowThreadEventHandlerBLImpl bl = null;
		
		//��ȡԾǨ״̬ǰ�����¼��б�
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPsdid(tpsd.getPsdid());//ԾǨ״̬ID
		cond.setPedtype(IGPRDCONSTANTS.THREADTREATMENT);//���߳�����
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		for(IG413Info ped : pedList) {
			try {
				bl = (WorkFlowThreadEventHandlerBLImpl)WebApplicationSupport.getBean(ped.getPedblid());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004","���߳�������");
			}
			bl.init(processRecord, fpsd, tpsd, user, roleid);
			//�������߳�����
			Thread thread = new Thread(bl);
			thread.start();
		}
	}
	
	/**
	 * ������תJSPȡ��
	 * 
	 * @param pdid���̶���ID
	 * @param prid����ID
	 * @param pjdtypeҳ������
	 * @param user��¼�û���Ϣ
	 */
	public String searchForwardJsp(String pdid, Integer prid, String pjdtype, User user) throws BLException {
		String forward = null;
		//��ȡָ������JSP������Ϣ
		IG126SearchCondImpl cond = new IG126SearchCondImpl();
		cond.setPdid(pdid);
		cond.setPjdtype(pjdtype);
		List<IG126Info> pjdList = workFlowDefinitionBL.searchProcessJspDef(cond);
		if(pjdList.size() > 0) {
			//�Զ�����תBL���岻���ڣ���ת��PJDURL����ҳ�棬����ͨ��BL��ȡJSP·��
			if(StringUtils.isEmpty(pjdList.get(0).getPjdblid())) {
				forward = pjdList.get(0).getPjdurl();
			} else {
				WorkFlowJspHandlerBL bl = null;
				try {
					bl = (WorkFlowJspHandlerBL)WebApplicationSupport.getBean(
							pjdList.get(0).getPjdblid());
				} catch (Exception e) {
					throw new BLException("IGCO10000.E004","����ҳ�涨��");
				}
				igflowlog.debug("========================ȡ��������תJSP�¼���ʼ========================");
	            igflowlog.debug("��������ID:" + pdid);
	            igflowlog.debug("����ID:" + prid);
	            igflowlog.debug("ҳ������:" + pjdtype);
	            igflowlog.debug("�û�ID:" + user.getUserid());
	            igflowlog.debug("����BL:" + pjdList.get(0).getPjdblid());
				forward = bl.forwardExecute(pdid, prid, pjdtype, user);
				igflowlog.debug("������תJSP:" + forward);
				igflowlog.debug("========================ȡ��������תJSP�¼�����========================");
			}
		} else {
			//����������Ϊ��ܱ���ʱ����ת����ر�������ҳ
			String first = pdid.substring(0, 1);
			if("1".equals(first) || "2".equals(first) || "3".equals(first)) {
				forward = "/smr/IGSMR0401.jsp";
			}
		}
		return forward;
	}
	
	/**
	 * �����û���ɫ���ҽ�ɫ��־
	 * 
	 * @param RecordLogSearchCond���̶���ID
	 */
	public List<IG036Info> searchUserRoleRecondLog(IG036SearchCond cond){
		return ig036BL.searchIG036InfoByCond(cond);
	}
	
	/**
	 * ��ȡ���̲����߱���Ȩ��
	 * @param psdid����״̬ID
	 * @param roleid���̲����߽�ɫID
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchParticipantVariableVW(String psdid , Integer roleid) {
		IG893SearchCondImpl cond = new IG893SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setRoleid(roleid);
		return ig893BL.searchIG893Info(cond);
	}
	
	private Map<String, IG893Info> getParticipantVariabelMap(List<IG893Info> participantVariabelList){
		Map<String, IG893Info> participantVariabelMap = null;
		participantVariabelMap = new HashMap<String, IG893Info>();
		if(participantVariabelList != null && participantVariabelList.size() > 0){
			for(IG893Info pi:participantVariabelList){
				participantVariabelMap.put(pi.getPidid(), pi);
			}
		}
		return participantVariabelMap;
	}
	
	/**
	 * ��ȡ���̲��������Ȩ��
	 * @param psdid����״̬ID
	 * @param roleid���̲����߽�ɫID
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchParticipantMaxVariableVW(String psdid , Integer roleid,Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap) {
		Map<String, IG893Info> participantVariabelMap = null;
		if(roleid!=null&&roleid>0){
			List<IG893Info> temp = searchParticipantVariableVW(psdid,roleid);
			participantVariabelMap = getParticipantVariabelMap(temp);
		}
		if(ls_proStatusParticipantMap != null){
			Set<Entry<IG333Info,List<IG337Info>>> set = ls_proStatusParticipantMap.entrySet();
			for(Iterator<Entry<IG333Info, List<IG337Info>>> iter = set.iterator();iter.hasNext();){
				Entry<IG333Info, List<IG337Info>> entry = iter.next();
				IG333Info psd = entry.getKey();
				List<IG337Info> list = entry.getValue();
				if(list != null){
					for(IG337Info pp:list){
						List<IG893Info> temp = searchParticipantVariableVW(psd.getPsdid(),pp.getPproleid());
						if(participantVariabelMap == null){
							participantVariabelMap = getParticipantVariabelMap(temp);
						}else{
							Map<String, IG893Info> variabelMap = getParticipantVariabelMap(temp);
							Set<Entry<String, IG893Info>> varSet = variabelMap.entrySet();
							for(Iterator<Entry<String, IG893Info>> varIter = varSet.iterator();varIter.hasNext();){
								Entry<String, IG893Info> varEntry = varIter.next();
								IG893Info cinfo = varEntry.getValue();
								IG893Info rinfo = participantVariabelMap.get(cinfo.getPidid());
								if(rinfo == null){
									participantVariabelMap.put(cinfo.getPidid(), cinfo);
								}else{
									if(Integer.valueOf(cinfo.getPidaccess())>Integer.valueOf(rinfo.getPidaccess())){
										participantVariabelMap.put(cinfo.getPidid(), cinfo);
									}
								}
							}
						}
					}
				}
			}
		}
		List<IG893Info> participantVariableVWList = new ArrayList<IG893Info>();
		if(participantVariabelMap != null){
			Set<Entry<String,IG893Info>> set = participantVariabelMap.entrySet();
			for(Iterator<Entry<String, IG893Info>> iter = set.iterator();iter.hasNext();){
				Entry<String, IG893Info> entry = iter.next();
				IG893Info value = entry.getValue();
				participantVariableVWList.add(value);
			}
		}
		return participantVariableVWList;
	}
	
	/**
	 * ����ָ����ɫֵ�����ύȨ��
	 * @param prid����ID
	 * @param roleid���̲����߽�ɫID
	 * @throws BLException 
	 */
	public void grantDutyPerson(Integer prid , Integer roleid) throws BLException {
		//��ȡδ����������
		List<IG337Info> ppList = this.searchProcessParticipantTodoRole(prid, 
				this.ig500BL.searchIG500InfoByKey(prid).getPrstatus());
		//��Ȩ
		for(IG337Info pp : ppList) {
			//δ����ָ����ɫֵ����
			if(pp.getPproleid().equals(roleid) &&
					IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) 
					&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus())) {
				IG337TB ppTB = (IG337TB)SerializationUtils.clone(pp);
				ppTB.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);
				this.ig337BL.updateIG337Info(ppTB);
			}
		}
	}
	//�ı���󶨸����ϴ������ظ���ID
	public IG599Info addProcessInfo(Map<Integer, FormFile> filemap) throws BLException {
		IG599TB processInfo = this.getProcessInfoTBInstance();
		String attkey = fileUploadBL.uploadFile(filemap);
		processInfo.setPiattkey(attkey);
		
		return processInfo;
	}
	public void addProcessInfoAtt(Map<Integer, FormFile> filemap,String attkey) throws BLException {
//		ProcessInfoTB processInfo = this.getProcessInfoTBInstance();
//		String attkey = 
			fileUploadBL.uploadFile(filemap,attkey);
//		processInfo.setPiattkey(attkey);
		
//		return processInfo;
	}
	public IG599Info updateProcessInfo(Map<Integer, FormFile> filemap,IG599Info pi) throws BLException {
		IG599TB processInfo = this.getProcessInfoTBInstance();
		String attkey = fileUploadBL.uploadFile(filemap);
		processInfo.setPiattkey(attkey);
		processInfo.setFingerPrint(pi.getFingerPrint());
		processInfo.setPidid(pi.getPidid());
		processInfo.setPiid(pi.getPiid());
		processInfo.setPivarlabel(pi.getPivarlabel());
		processInfo.setPivarname(pi.getPivarname());
		processInfo.setPivartype(pi.getPivartype());
		processInfo.setPivarvalue(pi.getPivarvalue());
		processInfo.setPrid(pi.getPrid());
		
		return processInfo;
	}
	
	
	/**
	 * ��������,���������ı���󶨵ĸ����ϴ�����,���ڸ÷���������
	 * 
	 * @param processRecord ���̼�¼����
	 * @param user	        �û�
	 * @param roleid		��ɫID
	 * @param filemap		����map
	 * @param pts           ��������
	 * @param prInfoList	���̱�����Ϣ
	 * @param rlcomment	    ��־��Ϣ
	 * @param psdid	        ����״̬ID
	 * @param action	    ������ʶ
	 * @param authorizeuser	��Ȩ���û���Ϣ
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,Map<String, FormFile> filemapMuti,
			String pts,List<IG599Info> prInfoList, String rlcomment,String psdid,
			String action,Map<String,List<Attachment>> copyMap, User authorizeuser,
			Map<Integer, String> processInfoEntityMap,Map<String, Object> tableFormValueMap,
			Map<String, List<IG506TB>> participantFormValueMap,String isServiceStart,Integer parprid)
			throws BLException {

		// ��ȡ��ǰ����״̬
		IG333Info psdInfo = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		IG380Info pd = this.workFlowDefinitionBL.searchProcessDefinitionByKey(processRecord.getPrpdid());
		IG259Info pt = this.workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
		
		/**   ����һ�����̵ļ�¼  start**/
		// ���̼�¼
		IG500TB processRecordTB = this.getProcessRecordTBInstance();
		this.copyProperties(processRecordTB, processRecord);
		String datetime = IGStringUtils.getCurrentDateTime();
		processRecordTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		processRecordTB.setPropentime(datetime);
		
		processRecordTB.setPruserid(user.getUserid());
		processRecordTB.setPrusername(user.getUsername());
		processRecordTB.setProrgid(user.getOrgid());
		processRecordTB.setProrgname(user.getOrgname());
		processRecordTB.setPrtype(pt.getPttype());
		
		//�жϷ�����������
		if(StringUtils.isNotEmpty(pts)){
			processRecordTB.setPrtype(pts);
		}else{
			processRecordTB.setPrtype(IGPRDCONSTANTS.SELF_DEFINING_WORK_PRTYPE);
		}
		
		
		IG500Info newProcessRecord = ig500BL.registIG500Info(processRecordTB);
		Integer prid = newProcessRecord.getPrid();// ������̼�¼ID
		

        if(action != null && action.compareTo("10") >= 0){
			//������־
			addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, action, psdInfo.getPsdid());
        } else {//����
        	//������־
        	addRecordLog(prid, user, roleid, null, IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
        			null, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, IGPRDCONSTANTS.BUTTON_SUBMIT, psdInfo.getPsdid());
        }
		//addProcessInfo(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE, filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);

		/**    ����һ�����̵ļ�¼  end**/
		
		//��дϵͳ��־
		//addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		
		// ���������Ȩ,��־������ʾ��˭����˭����
		if (authorizeuser != null) {

			// ���������־����, ����
			if (StringUtils.isNotEmpty(rlcomment)) {
				rlcomment = rlcomment + "<br>" + "��" + user.getUsername()
						+ "�����桾" + authorizeuser.getUsername() + "��������";
			} else {
				rlcomment = "��" + user.getUsername() + "�����桾"
						+ authorizeuser.getUsername() + "��������";
			}

		}
		
		//��д�ύ��־
		IG036Info rl = this.addRecordLog(prid, user, roleid, rlcomment, IGPRDCONSTANTS.RLDESC_DATA,filemap,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, action, psdInfo.getPsdid());
		List<IG599Info> processInfoValueList = null;
		if(prInfoList != null && !prInfoList.isEmpty()){
			//��¼������־
			
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(prid);
				
				//������󶨵ĸ�������processinfo����.=================================================
				if(filemapMuti != null && !filemapMuti.isEmpty()){
					Map<Integer, FormFile> fileMM=new HashMap<Integer, FormFile>();
					for(Map.Entry entry:filemapMuti.entrySet()){
						if(piTB.getPivarname().equals(entry.getKey().toString().split("_")[0])){
							fileMM.put(Integer.parseInt(entry.getKey().toString().split("_")[1]),
									(FormFile) entry.getValue());
						}
						
					}
					if(StringUtils.isNotEmpty(piTB.getPiattkey())){
						addProcessInfoAtt(fileMM, piTB.getPiattkey());
					}else{
						piTB.setPiattkey(this.addProcessInfo(fileMM).getPiattkey());
					}
				}
				//===============================================================================================
				//�������������   20130828 wangtingzhi start
				if("5".equals(pi.getPivartype())){
					String value = pi.getPivarvalue();
					piTB.setPivarvalue(getProcessFormValue(prid, value));
				}
				//�������������   20130828 wangtingzhi end
				if("P".equals(pi.getPivartype())){
					String value = pi.getPivarvalue();
					List<IG506TB> pvList = participantFormValueMap.get(pi.getPidid());
					piTB.setPivarvalue(getParticipantFormValue(prid,pvList,value));
				}
			}
			//���±�����Ϣ
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			List<IG599Info> prInfoListU=new ArrayList<IG599Info>();
			if(prInfoList.size()>0&&copyMap!=null){
				for(int i=0;i<prInfoList.size();i++){
					List<Attachment> list = copyMap.get(prInfoList.get(i).getPivarname());
					if(list != null){
//						prInfoListU.add(prInfoList.get(i));
						if(prInfoList.get(i).getPiattkey() != null){
//							for(int j=0;j<list.size();j++){
//							ProcessInfoTB psitb = (ProcessInfoTB)prInfoList.get(i);
							fileUploadBL.copyFile(list, prInfoList.get(i).getPiattkey());
//							prInfoListU.add(psitb);
//							}
						}else{
							IG599TB psitb = (IG599TB)prInfoList.get(i);
							String attkey = fileUploadBL.copyFile(list, prInfoList.get(i).getPiattkey());
							psitb.setPiattkey(attkey);
							prInfoListU.add(psitb);
						}
					}
				}
				processInfoValueList = this.saveOrUpdProcessInfos(prInfoListU);
			}
			
			//���ӱ�����־
			addRecordLogVarInfo(prInfoList,rl);
			
		}
		
		//���̷������������������ʲ����������ʽ����ֵ��������Ա����ֵ���������˴�  20130905 wangtingzhi start
		//��������ʲ�
		//��������״̬��˽�б��� ig561��¼���������ֲ������ʲ����ڲ�ͬ��״̬ 2015��2��13��15:38:44
        Map<String,String> entitySaveMap=null;
		if(processInfoValueList != null && processInfoValueList.size() > 0){
		    entitySaveMap=saveProcessInfoEntity(processInfoValueList,processInfoEntityMap);
		}else{
		    entitySaveMap=saveProcessInfoEntity(prInfoList,processInfoEntityMap);
		}
		//�ʲ�Ĭ��ֵ����
		//��������ʽ����ֵ
		if(tableFormValueMap != null && tableFormValueMap.size() > 0){
			String[] column_value = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_VALUE);
			String[] column_pidid = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_PIDID);
			String[] column_rownum = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_ROWNUMBER);
			Map<Integer, FormFile> tableFormFileMap = (Map<Integer, FormFile>) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE);
			String fileStr = (String) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_ADD_FLAG);
			String fileDelStr = (String) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG);
			saveTableFormValue(newProcessRecord, column_value, column_pidid, column_rownum, tableFormFileMap, fileStr, fileDelStr);
		}
		//������Ա����ֵ
		//���̷������������������ʲ����������ʽ����ֵ��������Ա����ֵ���������˴�  20130905 wangtingzhi end
		
		
		// ������̷����߼�¼
		IG337TB opener = this.getProcessParticipantTBInstance();
		opener.setPrid(prid);
		opener.setPpuserid(processRecordTB.getPruserid());
		opener.setPpusername(processRecordTB.getPrusername());
		opener.setPproleid(processRecordTB.getPrroleid());
		opener.setPprolename(processRecordTB.getPrrolename());
		opener.setPporgid(processRecordTB.getProrgid());
		opener.setPporgname(processRecordTB.getProrgname());
		opener.setPpstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		opener.setPpinittime(datetime);
		opener.setPpproctime(datetime);
		opener.setPbdid(action);
		opener.setPpuserinfo(processRecordTB.getPrinfo());
		opener.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		
		// ��ѯ����ڵ�����״̬����ID
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(processRecordTB.getPrpdid());
		psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
		psdCond.setFatherflag("Y");
		IG333Info zpsd = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond).get(0);
		
		opener.setPsdid(zpsd.getPsdid());
		
		
		if(parprid != null && parprid > 0){
			//�������̹�ϵ
			//�ӷ��񹤵���ݷ���
			if("S".equals(isServiceStart)){
				//������ϵ
				IG715TB sprrTB = ig715BL.getIG715TBInstance();
				sprrTB.setSprrsfid(parprid);//��������ID
				sprrTB.setSprrprid(prid);//��������ID
				sprrTB.setSprrinstime(datetime);//����ʱ��
				ig715BL.registIG715Info(sprrTB);
			} else if("C".equals(isServiceStart)){ //�����̿�ݷ���
				//������ϵ
				IG512TB prrTB = getProcessRecordRelationTBInstance();
				prrTB.setParprid(parprid);//��������ID
				prrTB.setCldprid(prid);//��������ID
				prrTB.setPrrinstime(datetime);//����ʱ��
				createProcessRecordRelation(prrTB);
			}
			addRecordLog(parprid, user, roleid, "����" + newProcessRecord.getPrpdname(), "��ط���", filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, IGPRDCONSTANTS.BUTTON_PROCESS, null);
		}

        if(action != null && action.compareTo("10") >= 0){
		opener = (IG337TB) addProcessParticipant(opener,user,roleid,
				                "���ӣ�" + opener.getPprolename()
				                + (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
				                IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
				                IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, action, psdid);
        } else {//����
        	opener = (IG337TB) addProcessParticipant(opener,user,roleid,
        			"���ӣ�" + opener.getPprolename()
        			+ (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
        			IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
        			IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, IGPRDCONSTANTS.BUTTON_SUBMIT, psdid);
        }
        
     	// ��ť�¼�-Ӧ��Ǩ����-
    	WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPbdid(action);//��ťID
		if (psdid.indexOf("_") > -1) {
			bean.setBfstatus(psdid.split("_")[0]);//״̬ID
			bean.setBfstatusnum(psdid.split("_")[1]);//״̬ID���
		} else {
			bean.setBfstatus(psdid);//״̬ID
		}
		//��־������Ϣ
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(prid);
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(roleid);
		if(authorizeuser != null) {
			logInfo.setAuthuserid(authorizeuser.getUserid());
		}
		bean.setLogInfo(logInfo);
		this.processStatusButtonTreatmentExecute(bean);
        
		//����˽�б���
		this.registProcessPrivateInfo(prInfoList, roleid, user.getUserid(),opener.getPporgid());

		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
		newProcessRecord = ig500BL.searchIG500InfoByKey(prid);
        // <<<<<<<<<<<<<<<<< update by yangyining 20131028
		//���ɹ�����
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(newProcessRecord);
		IG380Info ig380Info = this.workFlowDefinitionBL.searchProcessDefinitionByKey(newProcessRecord.getPrpdid());
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			WorkFlowSerialnumGeneratorBL bl = null;
			try {
				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004", "����������������");
			}
			igflowlog.debug("========================�����������¼���ʼ========================");
			igflowlog.debug("������������:" + newProcessRecord.getPrpdname());
			igflowlog.debug("��������ID:" + newProcessRecord.getPrpdid());
			igflowlog.debug("���̱���:" + newProcessRecord.getPrtitle());
			igflowlog.debug("����BL:" + ig380Info.getSerialgenerator());
			ig500TB.setPrserialnum(bl.serialnumGenerator(prid));
			igflowlog.debug("���ɹ�����:" + ig500TB.getPrserialnum());
			igflowlog.debug("========================�����������¼�����========================");
			this.ig500BL.updateIG500Info(ig500TB);
		}
		
		
		/**   ������̷�����  end**/
        if(action != null && action.compareTo("10") >= 0){
        	//��ѯ��״̬�ɽ��з��ɵĽڵ��б�
        	List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(psdid, action);
        	if(lst_ProcessStatusDef.isEmpty()) {
        		/**   ƥ��ԾǨ  start**/
        		this.checkAndTransitionForCreate(user,psdid,roleid,action,prid,prInfoList,authorizeuser);
        	} else {
        		opener.setPpproctime(null);//��մ����˵ķ���ʱ��
        		this.updateProcessParticipant(opener);
        		this.insertBeginRecordStatusLogByPsdid(prid, processRecord.getPrpdid(), processRecordTB.getPrtype(), psdid, WorkFlowConstDefine.STATUSTYPE_BEGIN, new Date(datetime),false);
        	}
        }else{
        	opener.setPpproctime(null);//��մ����˵ķ���ʱ��
        	this.updateProcessParticipant(opener);
        	IG224SearchCondImpl cond = new IG224SearchCondImpl();
        	cond.setPrid(prid);
        	if(this.ig224BL.searchIG224Info(cond,0,0).size() == 0) {
        		this.insertBeginRecordStatusLogByPsdid(prid, processRecord.getPrpdid(), processRecordTB.getPrtype(), psdid, WorkFlowConstDefine.STATUSTYPE_BEGIN, new Date(datetime),false);
        	}
        }
		
		//����˽�б���
		this.registProcessPrivateInfo(prInfoList, roleid, user.getUserid(),opener.getPporgid());
		//����״̬���� wyw
        this.registIG561Info(prInfoList,psdid, user.getUserid(),entitySaveMap);
        
		/**   ƥ��ԾǨ  start**/
		return ig500TB;
	}
	
	//ȡprocessinfo����
	public  List<Attachment> searchProcessInofAtt(String piattkey) {
		List<Attachment> ProcessInofAttList = new ArrayList<Attachment>();
		//û�и���ʱ������
		if(piattkey != null && piattkey.length()>0){
		ProcessInofAttList = attachmentBL.searchAttachmentsByAttkey(piattkey);
		}
		return ProcessInofAttList;
	}
	
	//�ı���󶨸���ɾ������
	public  Attachment delAttachment(String attkey) throws BLException {
//		List<Attachment> list = new ArrayList<Attachment>();
//		ProcessInofAttList = attachmentBL.searchAttachmentsByAttkey(piattkey);
		Attachment att = attachmentBL.searchAttachmentByKey(Integer.parseInt(attkey));
		//����ɾ������
		if(att!=null){
			attachmentBL.deleteAttachment(att);
		}
//		attachmentBL.
		return att;
	}
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchProcessInfoForClose(Integer prid, String pdid, String userid){
		return this.ig599BL.searchIG599InfoForClose(prid, pdid, userid);
	}

	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchProcessInfoForSee(Integer prid, String pdid, String userid){
		return this.ig599BL.searchIG599InfoForSee(prid, pdid, userid);
	}
	
	/**
	 * �ж�����״̬��־�Ƿ�ʱ
	 * 
	 * @param ����ID
	 * @param ��ʼʱ��
	 * @param ����ʱ��
	 * @param ����״̬
	 * @return �Ƿ�ʱ
	 * @throws BLException 
	 */
	public String checkTimeOut(Integer prid, Date starttime, Date endtime, String prstatus) throws BLException {
		//��ȡ���̼�¼
		IG500Info process = this.searchProcessRecordByKey(prid);
		
		//����״̬��¼�������������Ƿ�ʱ
		if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(process.getPrstatus())) {
			SimpleDateFormat df = new SimpleDateFormat(CommonDefineUtils.DATETIME_FORMAT.getPattern());
			try {
				starttime = df.parse(process.getPropentime());
			} catch (ParseException e) {
				throw new BLException("IGCO10000.E004","���ڸ�ʽ������");
			}
		}
		
		//�Ƿ�ʱ��ʶ
		String isAlive = WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_NO;
		//��ȡ���̲���
		IG105PK pk = new IG105PK();
		pk.setPdid(process.getPrpdid());// ���̶���ID
		pk.setPsdversion(process.getPrStrategyVersion());// ���԰汾��
		pk.setPrurgency(process.getPrurgency());// ���̽�����
		pk.setPrstatus(prstatus);// ����״̬
		IG105Info psd = ig105BL.searchIG105InfoByKey(pk);
		if (psd != null && psd.getExpecttime() != null && psd.getExpecttime() > 0) {
			Double excepttime = psd.getExpecttime() * 60;
			if ((endtime.getTime() - starttime.getTime()) > excepttime.intValue() * 60000) {
				isAlive = WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_YES;
			}
		}
		return isAlive;
	}

	/**
	 * ƥ��ԾǨ������ƥ�䷵����һ״̬id����ƥ�䷵��Null(��ά�ƻ������Զ�������ʱʹ��)
	 *
	 * @param user �û�
	 * @param fpsdid ��ǰ����״̬ID
	 * @param roleid ��ɫID
	 * @param action ������ť����
	 * @param prid ����ID
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @return Integer ԾǨ�������״̬ID
	 */
	public String checkAndTransition(User user,String fpsdid,Integer roleid,String action,Integer prid,List<IG599Info> piList) throws BLException {
		return checkAndTransitionForCreate(user, fpsdid, roleid, action, prid, piList, null);
	}
	
	/**
	 * <p>
	 * ���̱������´���
	 * </p>
	 * 
	 * @param pi ���̱�����Ϣ
	 * @throws BLException
	 *
	 */

	public void updateProcessInfo(IG599Info pi) throws BLException {
		ig599BL.updateIG599Info(pi);
	}
	
	/**
	 * ���������Ȩ,��־����ʾ˭��˭����
	 * @param username ��ǰ�û�����
	 * @param authorizeusername ��Ȩ���û�����
	 * @param rlcomment ��־����
	 * @return
	 */
	public String getRlcomment(String username, String authorizeusername, String rlcomment){

		// ���������־����, ����
		if (StringUtils.isNotEmpty(rlcomment)) {
			rlcomment = rlcomment + "<br>" + "��" + username
					+ "�����桾" + authorizeusername + "��������";
		} else {
			rlcomment = "��" + username + "�����桾"
					+ authorizeusername + "��������";
		}
		return rlcomment;
	}
	
	
	/**
	 * ����˽�б�������
	 * 
	 * @param lst_ProcessInfo ������������
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException 
	 */
	public void registProcessPrivateInfo(List<IG599Info> lst_ProcessInfo, Integer roleid, String userid,String orgid) throws BLException {
		this.ig899BL.registIG899Info(lst_ProcessInfo, roleid, userid,orgid);
	}
	
	public List<IG899Info> searchProcessPrivateInfo(IG899SearchCond cond) throws BLException{
		return this.ig899BL.searchIG899Info(cond);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG899Info updateProcessPrivateInfo(IG899Info instance) throws BLException{
		return this.ig899BL.updateIG899Info(instance);
	}
	
	/**
	 * ����ִ���˼�������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchProcessExecutors(String userid, Integer prid) {
		return this.ig337BL.searchIG602Info(userid, prid);
	}
	
	/**
	 * ���̿ɷ����˼�������
	 * @param roleid ��ɫID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid) {
		return this.ig337BL.searchSuperAssignExecutors(roleid, prid);
	}
	
	/**
	 * �жϵ�ǰ�ڵ���ύȨ��
	 * 
	 * ���趨Ϊ��ɫ���û�ȫ���ύʱԾǨ��
	 * ����ý�ɫ�Ĳ�����ȫ������������ύ��ťID��ͬ������true�����򷵻�false
	 * ���趨Ϊ��ɫ���û���һ���ύʱԾǨ������true
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ptd ԾǨ����
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRole(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//ֻ����ͨ�ڵ�/��ͨģʽ�ҷǷ���ڵ��ͨ��
		if(!IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL.equals(ptd.getFromPSDTB().getPsdtype())
				|| !IGPRDCONSTANTS.MODE_NORMAL.equals(ptd.getFromPSDTB().getPsdmode())
				|| IGPRDCONSTANTS.PROCESS_START_STATUS.equals(ptd.getFromPSDTB().getPsdcode())) {
			return true;
		}
		if(IGPRDCONSTANTS.COND_TYPE_DEFAULT.equals(ptd.getPtdtype())) {
			return checkUserCommitInRoleDefault(prid, psdid, ptd);//ȱʡ����
		} else {
			return checkUserCommitInRoleNormal(prid, psdid, ptd);//��ͨ����
		}
	}
	
	/**
	 * �жϵ�ǰ�ڵ���ύȨ��
	 * 
	 * ���趨Ϊ��ɫ���û�ȫ���ύʱԾǨ��
	 * ����ý�ɫ�Ĳ�����ȫ������������ύ��ťID��ͬ������true�����򷵻�false
	 * ���趨Ϊ��ɫ���û���һ���ύʱԾǨ������true
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ptd ԾǨ����
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRoleNormal(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//����ύȨ��Ϊ0�ļ��ϣ���ɫID-��ťID��
		Map<String, String> auth = workFlowDefinitionBL.searchRoleCommitNormalAuth(ptd.getFpsdid());
		if(auth == null || auth.size() == 0) {
			return true;
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(prid);
			if (psdid.indexOf("_") > -1) {
				ppCond.setPsdid(psdid.split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
			} else {
				ppCond.setPsdid(psdid);
			}
			List<IG337Info> lst_ProcessParticipant = this.searchProcessParticipants(ppCond);
			//���ԾǨ���򼯺ϣ���ɫID-��ťID��
			Set<String> set_ptd = new HashSet<String>();
			//��ȡԾǨ����
			String ptdCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];
			String[] condArray = ptdCond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			//�����򼯺�
			for(String str : condArray) {
				set_ptd.add(str);
			}
			//���ύȨ�޼����й��˵�����ԾǨ����ļ�¼
			Set<Map.Entry<String, String>> set = auth.entrySet();
			if(set.size() > 0) {
				Map.Entry<String, String> entry = null;
				for(Iterator<Map.Entry<String, String>> iter = set.iterator(); iter.hasNext();){
					entry = iter.next();
					if(set_ptd.contains(entry.getKey() + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + entry.getValue())) {
						for(IG337Info pp : lst_ProcessParticipant) {
							//��ɫ��ͬ
							if(entry.getKey().equals(pp.getPproleid().toString())) {
								if(StringUtils.isEmpty(pp.getPpproctime())) {
									return false;//��δ������
								} else if(!entry.getValue().equals(pp.getPbdid())) {
									return false;//�ύ��ťID��һ��
								} 
							}
						}
					}
				}
			}
			return true;
		}
	}
	/**
	 * �жϵ�ǰ�ڵ���ύȨ��
	 * 
	 * ���趨Ϊ��ɫ���û�ȫ���ύʱԾǨ��
	 * ����ý�ɫ�Ĳ�����ȫ������������ύ��ťID��ͬ������true�����򷵻�false
	 * ���趨Ϊ��ɫ���û���һ���ύʱԾǨ������true
	 * 
	 * @param prid ����ID
	 * @param status ����״̬
	 * @param ptd ԾǨ����
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRoleDefault(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//����ύȨ��Ϊ0�ļ��ϣ���ťID��
		List<String> auth = workFlowDefinitionBL.searchRoleCommitDefaultAuth(ptd.getFpsdid());
		if(auth == null || auth.size() == 0) {
			return true;
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(prid);
			if (psdid.indexOf("_") > -1) {
				ppCond.setPsdid(psdid.split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
			} else {
				ppCond.setPsdid(psdid);
			}
			List<IG337Info> lst_ProcessParticipant = this.searchProcessParticipants(ppCond);
			//���ԾǨ���򼯺ϣ���ɫID-��ťID��
			Set<String> set_ptd = new HashSet<String>();
			//��ȡԾǨ����
			String ptdCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];
			String[] condArray = ptdCond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			//�����򼯺�
			for(String str : condArray) {
				set_ptd.add(str);
			}
			//���ύȨ�޼����й��˵�����ԾǨ����ļ�¼
			String buttonid = null;
			for(Iterator<String> iter = auth.iterator(); iter.hasNext();){
				buttonid = iter.next();
				if(set_ptd.contains(IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + buttonid)) {
					for(IG337Info pp : lst_ProcessParticipant) {
						if(StringUtils.isEmpty(pp.getPpproctime())) {
							return false;//��δ������
						} else if(!buttonid.equals(pp.getPbdid())) {
							return false;//�ύ��ťID��һ��
						} 
					}
				}
			}
			return true;
		}
	}
	private List<String> getSendMessage(){
		//����֪ͨ��������
		//�����ϱ���������
		String smsMessage = codeListUtils.getCodeValue("157", "", "", "9");
		//�ʼ�֪ͨ���ѱ���
		String mailTitleMessage = codeListUtils.getCodeValue("157", "", "", "10");
		//�ʼ�֪ͨ��������
		String mailContentMessage = codeListUtils.getCodeValue("157", "", "", "11");
//		smsMessage = StringUtils.isEmpty(smsMessage)?"�������ѣ�������Ϊ��{0}���� ��{1}��������Ҫ��������":smsMessage;
//		mailTitleMessage = StringUtils.isEmpty(mailTitleMessage)?"�������ѣ�������Ϊ��{0}���� ��{1}��������Ҫ��������":mailTitleMessage;
//		mailContentMessage = StringUtils.isEmpty(mailContentMessage)?"�������ѣ�������Ϊ��{0}���� ��{1}��������Ҫ��������":mailContentMessage;
		smsMessage = StringUtils.isEmpty(smsMessage)?"�������ѣ���ǰ״̬Ϊ��{0}���Ĺ����š�{1}���ġ�{2}��������Ҫ��������":smsMessage;
		mailTitleMessage = StringUtils.isEmpty(mailTitleMessage)?"�������ѣ���ǰ״̬Ϊ��{0}���Ĺ����š�{1}���ġ�{2}��������Ҫ��������":mailTitleMessage;
		mailContentMessage = StringUtils.isEmpty(mailContentMessage)?"�������ѣ���ǰ״̬Ϊ��{0}���Ĺ����š�{1}���ġ�{2}��������Ҫ��������{3}":mailContentMessage;
		List<String> lstMessage = new ArrayList<String>();
		lstMessage.add(smsMessage);
		lstMessage.add(mailTitleMessage);
		lstMessage.add(mailContentMessage);
		return lstMessage;
	}
	
	private String replaceMessage(String message,List<String> args){
		if(args != null && args.size() > 0){
			for(int i = 0; i< args.size(); i++){
				message = StringUtils.replace(message, "{"+i+"}", args.get(i));
			}
		}
		return message;
	}

	public List<CurrentMonthWorkVWInfo> SearchCurrentWorkWithManage(
			CurrentMonthWorkVWSearchCond cond, int start, int count) {
		
		return this.currentMonthWorkVWBL.findCurrentMonthWorkByCond(cond, start, count);
	}

	public int SearchCurrentWorkWithManageCount(
			CurrentMonthWorkVWSearchCond cond) {
		
		return this.currentMonthWorkVWBL.getSearchCurrentMonthWorkCount(cond);
	}
	
	/**
	 * ȡ�����������ֵ
	 * @param prid
	 * @param value
	 * @return
	 * @throws BLException
	 */
	public String getProcessFormValue(Integer prid,String value) throws BLException{
		StringBuffer pivarvalue = new StringBuffer();
		if(StringUtils.isNotEmpty(value)){
			String processinfo = "";
			String delinfo = "";
			String[] infos = value.split("_processValue_");
			String valueinfo = infos[0];
			List<String> valueArray = new ArrayList<String>();
			if(StringUtils.isNotEmpty(valueinfo)){
				String[] values = valueinfo.split(",");
				for(String s:values){
					valueArray.add(s);
				}
			}
			if(infos.length > 2){
				delinfo = infos[2];
				if(StringUtils.isNotEmpty(delinfo)){
					String[] dels = delinfo.split("#");
					if(dels != null && dels.length > 0){
						for(String s:dels){
							valueArray.remove(s);
							IG505TB entity = new IG505TB();
							entity.setPiprrid(Integer.valueOf(s));
							ig505BL.deleteIG505(entity);
						}
					}
				}
			}
			if(!valueArray.isEmpty()){
				for(String s:valueArray){
					pivarvalue.append(",").append(s);
				}
			}
			if(infos.length > 1){
				processinfo = infos[1];
				if(StringUtils.isNotEmpty(processinfo)){
					String[] adds = processinfo.split("#");
					if(adds != null && adds.length > 0){
						for(String s:adds){
							String info = s.split("_id_")[1];
							String piprid = info.split("_svc_")[0];
							String piprtype = info.split("_svc_")[1].split("_name=")[0];
							String piprtitle = info.split("_svc_")[1].split("_name=")[1];
							IG505TB entity = new IG505TB();
							entity.setPrid(prid);
							entity.setPiprid(Integer.valueOf(piprid));
							entity.setPiprtype(piprtype);
							entity.setPiprtitle(piprtitle);
							IG505Info entry = ig505BL.registIG505(entity);
							pivarvalue.append(",").append(entry.getPiprrid());
						}
					}
				}
			}
		}
		String returnValue = pivarvalue.toString();
		if(StringUtils.isNotEmpty(returnValue)){
			return returnValue.substring(1);
		}else{
			return null;
		}
	}
	
	/**
	 * ȡ����Ա�����ֵ
	 * @param prid ��������
	 * @param pvList ��Ա�����ֵʵ�弯��
	 * @param value ����ֵ
	 * @return
	 */
	public String getParticipantFormValue(Integer prid,List<IG506TB> pvList,String value) throws BLException{
		StringBuffer pivarvalue = new StringBuffer();
		if(StringUtils.isNotEmpty(value) && !"N/A".equals(value)){
			String[] infos = value.split("_participantValue_");
			String valueinfo = infos[0];
			String delinfo = "";
			List<String> valueArray = new ArrayList<String>();
			if(StringUtils.isNotEmpty(valueinfo)){
				String[] values = valueinfo.split(",");
				for(String s:values){
					valueArray.add(s);
				}
			}
			if(infos.length == 2){
				delinfo = infos[1];
				if(StringUtils.isNotEmpty(delinfo)){
					String[] dels = delinfo.split("#");
					if(dels != null && dels.length > 0){
						for(String s:dels){
							valueArray.remove(s);
							IG506TB entity = new IG506TB();
							entity.setPiuid(Integer.valueOf(s));
							ig506BL.deleteIG506(entity);
						}
					}
				}
			}
			if(!valueArray.isEmpty()){
				for(String s:valueArray){
					pivarvalue.append(",").append(s);
				}
			}
		}
		if(pvList != null){
			for(IG506TB entity:pvList){
				entity.setPrid(prid);
				IG506Info entry = ig506BL.registIG506(entity);
				pivarvalue.append(",").append(entry.getPiuid());
			}
		}
		String returnValue = pivarvalue.toString();
		if(StringUtils.isNotEmpty(returnValue)){
			return returnValue.substring(1);
		}else{
			return null;
		}
	}	
	
	/**
	 * ����������в�ѯ
	 * @param pdid ���̶�������
	 * @return 
	 * @throws BLException
	 */
	public Map<String, List<IG007Info>> initTableFormAction(String pdid) throws BLException {
		log.debug("=================��ʼ�����������������ʼ===================");
		Map<String, List<IG007Info>> columnInfoMap = null;
		//��ѯ�����������������Ϣ
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(pdid);
		List<IG007Info> columnList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(columnList != null){
			columnInfoMap = new HashMap<String, List<IG007Info>>();
			for(IG007Info column:columnList){
				String key = column.getPpidid();
				if(StringUtils.isEmpty(key)){
					key = "rawdef";
				}
				if(columnInfoMap.get(key) == null){
					List<IG007Info> temp = new ArrayList<IG007Info>();
					temp.add(column);
					columnInfoMap.put(key, temp);
				}else{
					columnInfoMap.get(key).add(column);
				}
			}
		}
		log.debug("=================��ʼ�������������������===================");
		return columnInfoMap;
	}
	
	/**
	 * �����������ֵ���洦��
	 * @param process ������Ϣ
	 * @param column_value ֵ����
	 * @param column_pidid �ж�����������
	 * @param column_rownum ���кż���
	 * @throws BLException
	 */
	public void saveTableFormValue(IG500Info process,String[] column_value,String[] column_pidid,String[] column_rownum,Map<Integer, FormFile> fileMap,String fileStr,String fileDelStr) throws BLException{
		log.debug("================���������ֵ���������ʼ==================");
		if(process == null || column_value == null || column_value.length == 0){
			return;
		}
		//��ѯԭ�б����������ֵ
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(process.getPrid());
		List<IG898Info> tableColumnValueList = ig898BL.searchIG898(cond);
		Set<String> pididset = new HashSet<String>();
		for(String pidid:column_pidid){
			pididset.add(pidid);
		}
		//ɾ����ǰ���������б��������ֵ
		if(tableColumnValueList != null){
			for(IG898Info entry:tableColumnValueList){
				if(pididset.contains(entry.getPvcolpidid())){
					ig898BL.deleteIG898(entry);
				}
			}
		}
		//ȡ���ж�����Ϣ
		Map<String, List<IG007Info>> columnInfoMap = initTableFormAction(process.getPrpdid());
		Map<String, IG007Info> columnInfo = new HashMap<String, IG007Info>();
		Map<String, IG007Info> tableInfoMap = new HashMap<String, IG007Info>();
		Set<Map.Entry<String, List<IG007Info>>> set = columnInfoMap.entrySet();
		Map<String, List<Attachment>> attMap = new HashMap<String, List<Attachment>>();
		for(Iterator<Entry<String, List<IG007Info>>> iter = set.iterator();iter.hasNext();){
			Entry<String, List<IG007Info>> entry = iter.next();
			String pidid = entry.getKey();
			if("rawdef".equals(pidid)){
				continue;
			}
			IG007Info table_def = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
			tableInfoMap.put(pidid, table_def);
			List<IG007Info> columnList = entry.getValue();
			if(columnList != null){
				for(IG007Info column:columnList){
					columnInfo.put(column.getPidid(), column);
					if("F".equals(column.getPidtype())){
						if(StringUtils.isNotEmpty(column.getPiddefault())){
							List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(column.getPiddefault());
							attMap.put(column.getPidid(), list);
						}
					}
				}
			}
		}
		//ɾ�������и���
		if(StringUtils.isNotEmpty(fileDelStr)){
			String[] split = fileDelStr.split("#");
			if(split != null && split.length > 0){
				for(int i=0;i<split.length;i++){
					boolean flag = true;
					if(!attMap.isEmpty()){
						for(Iterator<Entry<String, List<Attachment>>> iter = attMap.entrySet().iterator();iter.hasNext();){
							Entry<String, List<Attachment>> next = iter.next();
							List<Attachment> list = next.getValue();
							boolean iscon = false;
							for(Attachment att : list){
								if(split[i].equals(att.getAttid() + "")){
									flag = false;
									iscon = true;
									list.remove(att);
									break;
								}
							}
							if(iscon){
								break;
							}
						}
					}
					if(flag){
						delAttachment(split[i]);
					}
				}
			}
		}
		if(column_value != null && column_value.length > 0){
			for(int i=0;i<column_value.length;i++){
				//ȡ���ж�����Ϣ
				String pidid = column_pidid[i];
				String rownumber = column_rownum[i];
				//���Ը���ģ���е�ֵ
				if("0".equals(rownumber)||"_#_".equals(rownumber)){
					continue;
				}
				IG007Info column_def = columnInfo.get(pidid);
				IG007Info table_def = tableInfoMap.get(column_def.getPpidid());
				String value = null;
				if("F".equals(column_def.getPidtype()) && StringUtils.isNotBlank(column_value[i]) && column_value[i].equals(column_def.getPiddefault())){
					value = getTableColumnValue(process.getPrid(),pidid,rownumber,column_def.getPidtype(),"N/A",fileMap,fileStr);
				}else{
					value = getTableColumnValue(process.getPrid(),pidid,rownumber,column_def.getPidtype(),column_value[i],fileMap,fileStr);
				}
				IG898TB entity = ig898BL.getIG898TBInstance();
				entity.setPrid(process.getPrid());
				entity.setPidid(column_def.getPpidid());
				entity.setPidname(table_def.getPidname());
				entity.setPvcolname(column_def.getPidname());
				entity.setPvcolpidid(pidid);
				entity.setPvalue(value);
				if("F".equals(column_def.getPidtype())){
					String key = IGStringUtils.getAttKey();
					if(StringUtils.isNotEmpty(value)){
						entity.setAttkey(value);
					}
					List<Attachment> list = attMap.get(pidid);
					if(list != null && list.size() > 0 && StringUtils.isNotBlank(column_value[i]) && column_value[i].equals(column_def.getPiddefault())){
						for(Attachment att:list){
							StringBuffer rfilename = new StringBuffer();
							rfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
							rfilename.append(File.separator);
							rfilename.append(att.getAtturl());
							rfilename.append(File.separator);
							rfilename.append(att.getAttname());
							StringBuffer cfilename = new StringBuffer();
							cfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
							cfilename.append(File.separator);
							cfilename.append(att.getAtturl());
							cfilename.append(File.separator);
							cfilename.append(key);
							cfilename.append("_");
							cfilename.append(att.getAttname().substring(att.getAttname().indexOf("_") + 1));
							try{
								FileUtils.copyFile(new File(rfilename.toString()), new File(cfilename.toString()));
							}catch (Exception e) {
								log.error("",e);
							}
							AttachmentTB attTB = new AttachmentTB();
							attTB.setAttkey(key);
							attTB.setAttname(key + "_" + att.getAttname().substring(att.getAttname().indexOf("_") + 1));
							attTB.setAtturl(att.getAtturl());
							attachmentBL.registAttachment(attTB);
						}
						entity.setAttkey(key);
						entity.setPvalue(key);
					}
				}
				entity.setPvrownumber(rownumber);
				ig898BL.registIG898(entity);
			}
		}
		log.debug("================���������ֵ�����������==================");
	}
	
	/**
	 * �����������ֵ
	 * @param prid ��������
	 * @param pidtype ��������
	 * @param value ����ֵ
	 * @return
	 * @throws BLException
	 */
	private String getTableColumnValue(Integer prid,String pidid,String rownum,String pidtype,String value,Map<Integer, FormFile> fileMap,String fileStr) throws BLException{
		if("4".equals(pidtype)){
			if(StringUtils.isNotEmpty(value)){
				String[] split = value.split("_entityValue_");
				StringBuffer defautl = new StringBuffer();
				if(value.contains("DEFAULT")){
					IG007Info def = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
					String defaultValue = def.getPiddefault();
					if(StringUtils.isNotEmpty(defaultValue)){
						String[] defaults = defaultValue.split("#");
						Set<String> set = new HashSet<String>();
						if(split.length > 2 && StringUtils.isNotEmpty(split[2])){
							String[] dels = split[2].split("_sp_");
							for(String s:dels){
								set.add(s.replace("EIID", ""));
							}
						}
						for(String s:defaults){
							if(!set.contains(s)){
								IG731TB pieTB = new IG731TB();
								pieTB.setPrid(prid);
								pieTB.setEiid(Integer.valueOf(s));
								pieTB.setEiversion(Integer.valueOf(1));
								IG731Info pieInfo = ig731BL.registIG731Info(pieTB);
								defautl.append(pieInfo.getPieid()).append(",");
							}
						}
					}
				}
				if(split != null && split.length > 1){
					String str0 = split[0];
					String str1 = split[1];
					String delStr = "";
					Set<String> delSet = new HashSet<String>();
					if(split.length == 3){
						delStr = split[2];
						String[] dels = delStr.split("_sp_");
						if(dels != null && dels.length > 0){
							for(String pieid:dels){
								if(pieid.indexOf("EIID") < 0){
									delSet.add(pieid);
								}
//								workFlowOperationBL.deleteProcessInfoEntityById(Integer.parseInt(pieid));
							}
						}
					}
					if(StringUtils.isNotEmpty(str1)){
						String[] str2 = str1.split("#");
						StringBuffer pieids = new StringBuffer();
						if(StringUtils.isNotEmpty(str0)){
							String[] cpieids = str0.split(",");
							if(cpieids != null && cpieids.length > 0){
								for(String pieid:cpieids){
									if(!delSet.contains(pieid)){
										pieids.append(pieid).append(",");
									}
								}
							}
						}
						if(str2 != null && str2.length > 0){
							for(int i=0;i<str2.length;i++){
								if(StringUtils.isNotEmpty(str2[i])){
									String str3 = str2[i].split("_rowIndex_")[1];
									String[] info = str3.split("_sp_");
									IG731TB pieTB = new IG731TB();
									pieTB.setPrid(prid);
									pieTB.setEiid(Integer.valueOf(info[0]));
									pieTB.setEiversion(Integer.valueOf(info[1]));
									IG731Info pieInfo = ig731BL.registIG731Info(pieTB);
									pieids.append(pieInfo.getPieid()).append(",");
								}
							}
						}
						if(StringUtils.isNotEmpty(pieids.toString())){
							value = pieids.toString() + "_entityValue_";
						}
					}
				}
				if(StringUtils.isNotEmpty(value)){
					value = defautl.toString() + value;
				}else{
					value = defautl.toString() + "_entityValue_";
				}
			}
		}else if("F".equals(pidtype)){
			Map<Integer, FormFile> columnFileMap = new HashMap<Integer, FormFile>();
			int index = 0;
			if(StringUtils.isNotEmpty(fileStr)){
				String[] split = fileStr.split("#");
				if(split != null && split.length > 0){
					for(String s:split){
						if(StringUtils.isNotEmpty(s)){
							String[] info = s.split("_sp_");
							if(info[0].equals(pidid) && info[1].equals(rownum)){
								FormFile file = fileMap.get(Integer.valueOf(info[2]));
								if(file != null){
									columnFileMap.put(new Integer(index), file);
									index ++;
								}
							}
						}
					}
				}
			}
			if(columnFileMap.size() > 0){
				if(StringUtils.isEmpty(value) || "N/A".equals(value)){
					String attkey = fileUploadBL.uploadFile(columnFileMap);
					value = attkey;
				}else{
					fileUploadBL.uploadFile(columnFileMap,value);
				}
			}
		}else if("5".equals(pidtype)){
			value = getProcessFormValue(prid, value);
		}
		return value;
	}
	
	
	/**
	 * �����ʲ������е��ʲ���Ϣ
	 * �ʲ���Ӧ�ı�����Ϣ������ʱ���쳣
	 * @param processInfoList ����ֵ����
	 * @param processInfoEntityMap �ʲ���Ϣmap
	 * @throws BLException
	 */
	public Map<String,String> saveProcessInfoEntity(List<IG599Info> processInfoList,Map<Integer, String> processInfoEntityMap) throws BLException {
		Map<String,String> returnmap= new HashMap<String, String>();
	    if(processInfoEntityMap != null && processInfoList != null){
			if(processInfoEntityMap.size() > 0){
				//��װ����ֵmap
				Map<String, IG599Info> prInfoMap = new HashMap<String, IG599Info>();
				for(IG599Info prInfo:processInfoList){
					prInfoMap.put(prInfo.getPidid(), prInfo);
				}
				//��װ����ʲ���Ϣ
				Set<Entry<Integer, String>> set = processInfoEntityMap.entrySet();
				for(Iterator<Entry<Integer, String>> iter = set.iterator();iter.hasNext();){
					Map.Entry<Integer,String> entry = iter.next();
					if(StringUtils.isNotEmpty(entry.getValue())){
						String infos = entry.getValue();
						String[] ids = infos.split("#");
						String pidid = ids[0];//��������ID
						String eiid = ids[1];//�ʲ�ID
						String eiversion = ids[2]; //�ʲ��汾��
						//������ʲ�����ʲ���̬����
						if(!"A".equals(pidid)){
							//ȷ���ʲ������ĸ���̬����, ��pidid����
							IG599Info processInfo = prInfoMap.get(pidid);
							if(processInfo == null){
								throw new BLException("IGFLOW0000.E001","����������Ϣ");
							}
							IG731TB pieTB = new IG731TB();
							pieTB.setEiversion(Integer.parseInt(eiversion));
							//update 2016��7��22��09:04:19 jinna ѡ���ʲ�����ʱ��������Զ�̿⣬ԭeiid ��λ�õ�ֵ��ʽ Ϊ ����ʶ_eiid 
							Integer eiidint = null;
							if(StringUtils.isNotBlank(eiid) && eiid.split("_").length > 1){
								String[] eds = eiid.split("_");
								eiidint = Integer.parseInt(eds[1]);
								pieTB.setFingerPrint(eds[0]);
							}else{
								eiidint = Integer.parseInt(eiid);
							}
							pieTB.setEiid(eiidint);
							pieTB.setPiid(processInfo.getPiid());
							pieTB.setPrid(processInfo.getPrid());
							IG731Info info=saveProcessInfoEntity(pieTB);
							returnmap.put(info.getPiid().toString(),info.getPieid().toString());
						}
					}
				}
			}
		}
	    return returnmap;
	}

	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException {
		if(StringUtils.isNotEmpty(type)){
			return ig500BL.searchProcessByTypeCount(cond, type);
		}else{
			return queryIG500EntityCount(cond);
		}
	}

	public List<IG500Info> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException {
		if(StringUtils.isNotEmpty(type)){
			return ig500BL.searchProcessByType(cond, start, count, type);
		}else{
			return queryIG500EntityListByProcessInfo(cond,start,count);
		}
	}
	
	/**
	 * <p>
	 * Description: ���ݲ�ѯ������ȡָ��������Ա
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 * @author liupeng@deliverik.com
	 */
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond){
		return ig337BL.searchIG337InfoRun(cond);
	}
	
	/**
	 * ��������������ѯ���������
	 * @param prid ��������
	 * @return �������������
	 * @throws BLException
	 */
	public List<IG505Info> searchIG505InfoByprid(Integer prid) throws BLException{
		return ig505BL.findByPrid(prid);
	}
	
	/**
	 * ��������������ѯ��Ա�����
	 * @param prid ��������
	 * @return ��Ա���������
	 * @throws BLException
	 */
	public List<IG506Info> searchIG506InfoByprid(Integer prid) throws BLException{
		return ig506BL.findByPrid(prid);
	}
	
	/**
	 * ��������������ѯ��������񹤵���ϵ
	 * @param prid ��������
	 * @return ��������񹤵���ϵʵ�弯��
	 * @throws BLException
	 */
	public List<IG715Info> searchServiceProcessRecordRelationByPrid(Integer prid) throws BLException{
		IG715SearchCondImpl cond = new IG715SearchCondImpl();
		cond.setSprrprid(prid);
		return ig715BL.searchIG715Info(cond, 0, 0);
	}
	 
	/**
	 * ע�����ʽ����ֵ
	 * @param entity ����ʽ����ֵʵ��
	 * @return ����ʽ����ֵʵ��
	 * @throws BLException
	 */
	public IG898Info registTableFormValue(IG898Info entity) throws BLException {
		return ig898BL.registIG898(entity);
	}
	
	/**
	 * ����ʽ����ֵ��ѯ
	 * @param cond ��ѯ����ʵ��
	 * @return ����ʽ����ֵ����
	 * @throws BLException
	 */
	public List<IG898Info> searchTableFormValue(IG898SearchCond cond) throws BLException {
		return ig898BL.searchIG898(cond);
	}
	
	/**
	 * ������������ʽ����
	 * @param pk ����
	 * @return ����ʽ����ʵ��
	 * @throws BLException
	 */
	public IG898Info searchTableFormValueByKey(IG898PK pk) throws BLException {
		return ig898BL.searchIG898ByPK(pk);
	}
	
	/**
	 * ɾ������ʽ����ֵ
	 * @param entitys ����ʽ����ʵ�弯��
	 * @throws BLException
	 */
	public void deleteTableFormValue(List<IG898Info> entitys) throws BLException {
		ig898BL.deleteIG898(entitys);
	}
	
	/**
	 * �����������񹤵�
	 * @param sfid ���񹤵�����
	 * @return ���񹤵���Ϣ
	 * @throws BLException
	 */
	public IG933Info searchServiceFormByKey(Integer sfid) throws BLException{
		return ig933BL.searchIG933InfoByKey(sfid);
	}
	
	/**
	 * ��Ȩ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG463Info> searchProcessProxyWork(IG463SearchCond cond) throws BLException{
		return ig463BL.searchIG463Info(cond, 0, 0);
	}
	
	/**
	 * ������Ȩ����
	 * @param entity ��Ȩ����ʵ��
	 * @throws BLException
	 */
	public void updateProcessProxyWork(IG463Info entity) throws BLException{
		ig463BL.updateIG463Info(entity);
	}
	
	/**
	 * �û���Ȩ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG711Info> searchProcessAccredit(IG711SearchCond cond) throws BLException{
		return ig711BL.searchIG711Info(cond, 0, 0);
	}
	
	/**
	 * ��ѯָ����ܱ���key����������
	 * @param type ��������
	 * @param pdid ��������ID
	 * @param key ����ʵ��key
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��������
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(String type, String pdid, String key, Boolean isClose) throws BLException{
		return ig500BL.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	}
	
	/**
	 * ���ܣ����ݹ�����ʶ��ѯ��ǰ�����ˮ��
	 * @param prserialnum ������ʶ
	 * @return �����ˮ��
	 */
	public String searchMaxPrserialnum(String prserialnum) {
		return ig500BL.searchMaxPrserialnum(prserialnum);
	}
	
	/**
	 * ���鵱ǰ״̬���в������Ƿ�����ɣ�
	 * ���ȫ����������򰴴���ʱ�����һ�������ߵĴ�����¼����״̬ԾǨ��
	 * ����в�����δ���������κβ���.
	 * 
	 * @param prid ����ID
	 * @throws BLException 
	 */
	public void checkAllUserWorkDone(Integer prid) throws BLException {
		//��ȡ���̵�ǰ��Ϣ
		IG500Info process = this.searchProcessRecordByKey(prid);
		//��ȡ��ǰ״̬��������Ϣ�б�
		List<IG337Info> lst_IG337Info = this.searchProcessParticipant(prid, process.getPrstatus());
		//����в�����δ����(ppproctime is null)�����κβ���
		for(IG337Info info : lst_IG337Info) {
			if(StringUtils.isEmpty(info.getPpproctime())) {
				return;
			}
		}
		//���ȫ����������򰴴���ʱ�����һ�������ߵĴ�����¼����״̬ԾǨ
		if(!lst_IG337Info.isEmpty()) {
			//��ȡ���һ������������
			IG337Info ig337Info = lst_IG337Info.get(lst_IG337Info.size() - 1);
			//��ȡ���̵�ǰ״̬��Ϣ
			IG333Info ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(
					this.workFlowDefinitionBL.searchProcessStatusKey(process.getPrpdid(), process.getPrstatus()));
			this.doFlow(prid, this.userBL.searchUserByKey(ig337Info.getPpuserid()), ig337Info.getPproleid(),
					IGStringUtils.getCurrentDateTime(), ig337Info.getPprolename(),
					ig333Info.getPsdid(), ig337Info.getPbdid(), "���̵�ǰ״̬��" + ig333Info.getPsdname() + "����δ���������ߣ�ԾǨ����һ״̬",
					ig333Info.getPsdtype(), null, ig337Info.getPpuserid(), 
					StringUtils.isEmpty(ig337Info.getPpproxyuserid())?
							null : this.userBL.searchUserByKey(ig337Info.getPpproxyuserid()));
		}
	}
	
	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬��ʾ����
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException {
		return this.ig500BL.searchCurrentStatusName(prid);
	}
	
	/**
	 * ��ȡ���̵�ǰ״̬
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬
	 */
	public List<String> searchCurrentStatus(Integer prid) throws BLException {
		return this.ig500BL.searchCurrentStatus(prid);
	}
	
	/**
	 * ״̬��־����
	 * @param cond �������� 
	 * @return
	 */
	public List<IG224Info> searchProcessStatusLog(IG224SearchCond cond){
		return this.ig224BL.searchIG224Info(cond, 0, 0);
	}

	/**
	 * ��������
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException {
		return ig500BL.searchIG677InfoByCond(cond);
	}
	
	/**
	 * У���Ƿ��ǹ���״̬
	 * @param prid ����ID
	 * @param psdid ״̬ID
	 * @return �Ƿ��ǹ���״̬
	 */
	public boolean checkPendStatus(Integer prid, String psdid){
		boolean pend = true;
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		cond.setPend(true);
		cond.setPsdid(psdid);
		if(ig224BL.searchIG224Info(cond,0,0).size() == 0) {
			pend = false;
		}
		return pend;
	}
	
    /**
     * ״̬��˽�б���ֵ��ѯ
     * @Title: searchStatusValue
     * @Description: ״̬��˽�б���ֵ��ѯ
     * @param pdid ����id ���汾��
     * @param psdid �ڵ�id
     * @param prid ����Ϊ�գ�����ʱ��
     * @return Map</key pidid,valueΪĬ��ֵ/ʵ�ʴ洢ֵ> 
     * @throws BLException
     */
	public Map<String,IG561Info> searchStatusValue(String pdid,String psdid,String prid) throws BLException{
	    //״̬��˽�б���ֵ��ʼ��
	    //key pidid,valueΪĬ��ֵ/ʵ�ʴ洢ֵ
	    Map<String,IG561Info> returnmap= new HashMap<String, IG561Info>();
	    IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pdid);
        cond.setPsdid_l(psdid);
		// cond.setUsedToAll("T");
        List<IG560VWInfo> lst= ig560BL.searchIG560VW(cond);
        //Ĭ��ֵȫ�ִ���
        for(IG560VWInfo info:lst ){
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                IG561TB tb= new IG561TB();
                tb.setPivarvalue(info.getDfvalue());
                returnmap.put(info.getPidid(), tb);
            }
        }
        //Ĭ��ֵ�ڵ㴦��
        for(IG560VWInfo info:lst ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                IG561TB tb= new IG561TB();
                if(returnmap.get(info.getPidid()) != null){
                	tb.setPivarvalue(returnmap.get(info.getPidid()).getPivarvalue() + "#" + info.getDfvalue());
                }else{
                	tb.setPivarvalue(info.getDfvalue());
                }
                returnmap.put(info.getPidid(), tb);
            }
        }
        //ʵ��ֵ����
        if(StringUtils.isNotEmpty(prid)){
            IG561SearchCondImpl cond561= new IG561SearchCondImpl();
            cond561.setPidid_l(pdid);
			if (!psdid.endsWith("002"))
            cond561.setPsdid_l(psdid);
            cond561.setPrid_q(prid);
            List<IG561Info> lst_561 = ig561BL.searchIG561(cond561);
            for(IG561Info info:lst_561){
                returnmap.put(info.getPidid(), info);
            }
        }
	    return returnmap;
	}

    /**
     * ״̬��˽�б�����������
     * @Title: registIG561Info
     * @Description: ״̬��������������
     * @param list599 �����б�
     * @param psdid �ڵ�id
     * @param userid �û�id
     * @param entitySaveMap �ʲ�������map
     * @throws BLException
     * wyw
     */
    public void registIG561Info(List<IG599Info> list599, String psdid,String userid,Map<String,String> entitySaveMap) throws BLException {
            IG561SearchCondImpl cond = new IG561SearchCondImpl();
            if(list599==null||list599.size()==0){
                return;
            }
            
            for(IG599Info pi : list599) {
                //�ж��Ƿ�״̬������
                //2015��2��13��13:39:29 ����ֻ��/��д������ֵת�洢
                if((IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pi.getPidaccess())||IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(pi.getPidaccess()))
                        && IGPRDCONSTANTS.PIDMODE_STATUS.equals(pi.getPidmode())) {
                    cond.setPidid_l(pi.getPidid());
                    cond.setPsdid_l(psdid);
                    cond.setPrid_q(String.valueOf(pi.getPrid()));
                    List<IG561Info> list561 = ig561BL.searchIG561(cond);
                    //û����
                    if(list561!=null&&list561.isEmpty()) {
                        IG561TB ig561TB= new IG561TB();
                        this.copyProperties(ig561TB, pi);
                        ig561TB.setPsdid(psdid);
                        ig561TB.setPiuserid(userid);
//                        if(pi.getPiid()==null){
//                            ig561TB.setPiid(map.get(pi.getPidid()));
//                        }
                        //�ʲ������߼�
                        if("4".equals(ig561TB.getPivartype())&&entitySaveMap!=null&&entitySaveMap.get(ig561TB.getPiid().toString())!=null){
                            //��¼ig731������������ͬ��״̬�в�ͬ���ʲ���
                            ig561TB.setPivarvalue(entitySaveMap.get(ig561TB.getPiid().toString()));
                        }
                        //����
                        this.ig561BL.registIG561(ig561TB);
                    } else if(list561.size() == 1) {
                        IG561TB ppTB = (IG561TB) SerializationUtils.clone(list561.get(0));
                        ppTB.setPivarvalue(pi.getPivarvalue());
                        if (StringUtils.isEmpty(ppTB.getPiattkey())) {
                            ppTB.setPiattkey(pi.getPiattkey());
                        }
                        //�ʲ������߼�
                        if("4".equals(ppTB.getPivartype())&&entitySaveMap!=null&&entitySaveMap.get(ppTB.getPiid().toString())!=null){
                            //��¼ig731������������ͬ��״̬�в�ͬ���ʲ���
                            ppTB.setPivarvalue(entitySaveMap.get(ppTB.getPiid().toString()));
                        }
                        ig561BL.updateIG561(ppTB);
                    } else {
                        throw new BLException("IGCO10000.E004", pi.getPivarname() + "״̬����ֵ");
                    }
                    if(pi.getPiid()!=null){
                        //���ProcessInfo�е�ֵ
                        IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
                        piTB.setPivarvalue(null);
                        piTB.setPiattkey(null);
                        piTB.setPidcomment(null);
                        this.ig599BL.updateIG599Info(piTB);
                    }
                }
            }
    }
    
    /** 
    * @Title: searchIG561VW 
    * @Description: TODO ״̬��˽�б����رսڵ��ѯ
    * @param prid
    * @param userid
    * @return    
    * List<IG561VWInfo>    
    * @throws 
    */
    public List<IG561VWInfo> searchIG561VW(String prid, String userid, boolean isAdmin)throws BLException{
        return this.ig561BL.searchIG561VW(prid, userid, isAdmin);
    }
    /**
     * ״̬��˽�б���ֵ����
     */
    public List<IG561Info> searchIG561Info(IG561SearchCondImpl cond)throws BLException{
        return this.ig561BL.searchIG561(cond);
    }
    /** 
     * @Title: searchProcessByTypeStatusAndParticanpant 
     * @Description:  �ɵ�wkm���̲�ѯ ���ӵ��������·�װ��ѯ�� 
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> searchProcessByTypeStatusAndParticanpant(IG500SearchCond prSearchCond, int i, int j, String type) throws BLException {
            return ig500BL.queryIG500WithStatusAndPart(prSearchCond, i, j);
    }
    
    
    
    /**
     * @param prid ���𳡾����������id
     * @param emcproeiname ר��Ԥ���ʲ�����
     * @param sceneeiname �����ʲ�����
     * @param scenepdid �����������̵����̶���id
     * @param propentime �����������̵����̷���ʱ��
     * @throws BLException 
     */
    public void send(Integer prid,String emcproeiname,String sceneeiname,String scenepdid,String propentime) throws BLException{
    	IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
        ig898Cond.setPrid(prid);
        List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
        Map<String,List<Map<String,String>>> resultMap = new LinkedHashMap<String,List<Map<String,String>>>();
        
        Map<String,Map<String,String>> sourceMap = null;
        //ÿ�е��������� ��װ�� ��������ݸ�ʽ
        if(participantList != null && participantList.size() >0){
        	sourceMap = new LinkedHashMap<String,Map<String,String>>();
        	for(IG898Info info : participantList){
        		String pbrownumber = info.getPvrownumber();
        		Map<String,String> restMap = sourceMap.get(pbrownumber);
        		if(restMap == null){
        			restMap = new HashMap<String,String>();
        			sourceMap.put(pbrownumber, restMap);
        		}
        		if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDNAME.equals(info.getPvcolname())){
        			restMap.put("psdname", info.getPvalue());
        		}
        		if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDID.equals(info.getPvcolname())){
        			restMap.put("psdid", info.getPvalue());
        		}
        		if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
        			restMap.put("userids", info.getPvalue());
        		}
        	}
        }
        //��װ����  ��ʽ   Map<userid,List<Map<String,String>>>  List Map<String,String> �� key: psdid,psdname
        if(sourceMap != null){
        	for(Entry<String, Map<String, String>> entry : sourceMap.entrySet()){
        		Map<String,String> valMap = entry.getValue();
        		String psdname = valMap.get("psdname");
        		String psdid = valMap.get("psdid");
        		String userids = valMap.get("userids");
        		//ֵ�ø�ʽΪ  roleid#rolename_role_userid#username_user_userid#username_roleuser_roleid#rolename........
        		if(StringUtils.isNotBlank(userids)){
        			
        			//��ȡ�ýڵ����е�useid ��ȥ��
        			HashSet<String> useridSet = new HashSet<String>(); 
        			
        			//��ɫ_role_�û�
        			String[] roleusers = userids.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]��ɫid#��ɫname , [1]�û�id#�û�name_user_�û�id#�û�name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null){
        						//ֻ�н�ɫ����ѯ��ɫ��������
        						if(roleAnduser.length == 1){
        							//��ɫid#��ɫname
        							String[] role = roleAnduser[0].split("#");
        							if(role != null && role.length > 0){
        								String roleid = role[0];
        								UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
        								cond.setRoleid(Integer.parseInt(roleid));
        								List<UserRole> userRoleList = userRoleBL.searchUserRole(cond);
        								if(userRoleList != null && userRoleList.size() > 0){
        									for(UserRole userRole : userRoleList){
        										useridSet.add(userRole.getUserid());
        									}
        								}
        							}
        						}else if(roleAnduser.length == 2){
        							//�û�id#�û�name
        							String[] users = roleAnduser[1].split("_user_");
        							for(String user : users){
        								if(StringUtils.isNotBlank(user)){
        									String userid = user.split("#")[0];
        									useridSet.add(userid);
        								}
        							}
        						}
        					}
        				}
        			}
        			
        			//ȥ�غ���װ���ݣ� <userid,List<Map<String,String>>>   Map<String,String> �� key: psdid,psdname
        			Iterator<String> iterator = useridSet.iterator(); 
        			while(iterator.hasNext()){ 
        				String userid = iterator.next();
        				if(StringUtils.isNotBlank(userid)){
			    			List<Map<String,String>> pidnames = resultMap.get(userid);
			    			if(pidnames == null || pidnames.size() <= 0){
			    				pidnames = new ArrayList<Map<String,String>>();
			    				resultMap.put(userid, pidnames);
			    			}
			    			//���жϸýڵ��Ƿ�������
			    			Map<String,String> map = new LinkedHashMap<String,String>();
		    				map.put("psdname", psdname);
		    				map.put("psdid", psdid);
		    				pidnames.add(map);
			    		}
        			}
        		}
        	}
        }
        
        if(resultMap != null && !resultMap.isEmpty()){
        	//��ȡԤ�ƿ�ʼʱ��
        	ComputingTime computingTime = new ComputingTime();
        	Map<String,String> parentStepMap = computingTime.getOrderStepEstimateTime(scenepdid,"null",propentime);
        	//����Ϊ��XXXX����Ӧ����������������������Ԥ��Ϊ��Ԥ�����ơ�����Ҫ�������Ļ�����Ԥ�ƿ�ʼʱ��Ϊ��XXXX���ġ��ڵ�1����Ԥ�ƿ�ʼʱ��Ϊ��XXXX���ġ��ڵ�2��������
        	String prTypeName = (StringUtils.isNotEmpty(emcproeiname)?"Ӧ��":"����");
        	String title = "��" + sceneeiname + "��"+prTypeName+"��������������";
        	for(Entry<String,List<Map<String,String>>> entry : resultMap.entrySet()){
        		String desc = "";
        		if(StringUtils.isNotEmpty(emcproeiname)){
	            	 desc = "����Ϊ" + title + "������Ԥ��Ϊ��" + emcproeiname + "������Ҫ�������Ļ�����";
        			
        		}else{
        			
        			 desc = "����Ϊ" + title + "����Ҫ�������Ļ�����";
        		}
        		
        		String key = entry.getKey();
        		List<Map<String,String>> value = entry.getValue();
        		User user = userBL.searchUserByKey(key);
        		String email = user.getUseremail();
        		for(int i = 0 ;i<value.size(); i++){
        			Map<String,String> map =  value.get(i);
        			String psdname = map.get("psdname");
        			String psdid = map.get("psdid");
        			
        			String estimateTime = parentStepMap.get(psdid);
        			if(i!=0){
        				desc += "��";
        			}
        			desc += "Ԥ�ƿ�ʼʱ��Ϊ��" +estimateTime+ "���ġ�" +psdname+ "��";
        			
        			if(i==value.size()-1){
        				desc += "��";
        			}
        		}
        		//�����ʼ�
//        		sendMailBL.sendMail(title, desc, new String[]{email}, new String[]{});
        		sendMessageBL.sendSmsToUser(user.getUserid(), desc);
        		
        	}
        }
    }
   
    /**
     * ��ȡ������������Ϣ
     * @param prid ���𳡾��������̵�����id
     * @return
     * @throws BLException
     */
    public List<UserRoleInfo> getSceneParticipant(Integer prid) throws BLException{
    	IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
        ig898Cond.setPrid(prid);
        List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
        
        List<UserRoleInfo> resultList = new ArrayList<UserRoleInfo>();
        
        Map<String,UserRoleInfo> resultMap = new HashMap<String,UserRoleInfo>();
        
        
        List<String> userlist = new ArrayList<String>();
        
        //��ȡ���еĲ�����
        if(participantList != null && participantList.size() >0){
        	for(IG898Info info : participantList){
        		if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
        			userlist.add(info.getPvalue());
        		}
        	}
        }
        //��װ���� Map<userid,UserRoleInfo>
        if(userlist != null && userlist.size() > 0){
        	for(String  userids : userlist){
        		//ֵ�ø�ʽΪ  roleid#rolename_role_userid#username_user_userid#username_roleuser_roleid#rolename........
        		if(StringUtils.isNotBlank(userids)){
        			//��ɫ_role_�û�
        			String[] roleusers = userids.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]��ɫid#��ɫname , [1]�û�id#�û�name_user_�û�id#�û�name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null){
        						//ֻ�н�ɫ����ѯ��ɫ��������
        						if(roleAnduser.length == 1){
        							//��ɫid#��ɫname
        							String[] role = roleAnduser[0].split("#");
        							if(role != null && role.length > 0){
        								String roleid = role[0];
        								UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        								cond.setRoleid(Integer.parseInt(roleid));
        								List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond);
        								if(userRoleList != null && userRoleList.size() > 0){
        									for(UserRoleInfo userRole : userRoleList){
        										resultMap.put(userRole.getUserid(), userRole);
        									}
        								}
        							}
        						}else if(roleAnduser.length == 2){
        							//�û�id#�û�name
        							String[] users = roleAnduser[1].split("_user_");
        							for(String user : users){
        								if(StringUtils.isNotBlank(user)){
        									//ֻ��ҪUSERID,USERNAME,����Ҫ���²�ѯ
        									UserRoleVW urvw = new UserRoleVW();
        									urvw.setUserid(user.split("#")[0]);
        									urvw.setUsername(user.split("#")[1]);
        									//��ɫid
        									urvw.setRoleid(Integer.parseInt(roleAnduser[0].split("#")[0]));
            								resultMap.put(user.split("#")[0], urvw);
        								}
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        	
        	//��ȡ�û�����
        	if(resultMap != null && !resultMap.isEmpty()){
        		for(Entry<String,UserRoleInfo> entry : resultMap.entrySet()){
        			resultList.add(entry.getValue());
        		}
        	}
        }
        
        return resultList;
    }
}