/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ʲ�������Ϣ���ɶ�Ӧ��ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 * (1)������Ӧ��ȡʵ���ж��Է�ֹNullPointerException
 */
@SuppressWarnings("serial")
public class Select2AssetFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		//��ر�����Ϣȡ�� 
		List<IG599Info> processInfoList = (List<IG599Info>) params.get(PARAMS_PROCESSINFO_LIST);
		//����ʲ���Ϣȡ��
		List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
		//������������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//��������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//��������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//�Ƿ����
		String pidrequired = (String) params.get(PARAMS_PIDREQUIRED);
		//ģ�Ͷ���ȡ��
		String ccid = (String) params.get(PARAMS_CCID);
		String syscoding = "";
		if(StringUtils.isNotEmpty(ccid)){
			syscoding = ccid.split("_entity_")[0];
		}
		String value = "";
		Integer eiid = null;
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		boolean flag = true;
		if(processInfoList!=null){
			for(IG599Info pi:processInfoList){
				if(pidlabel.equals(pi.getPivarlabel())&& WorkFlowConstDefine.PROCESS_ASSET_PIVRTYPE.equals(pi.getPivartype())){
					if(processInfoEntityList!=null){
						//�����ж��Ƿ����
						if(processInfoEntityList.size() > 0) {
							value = "N/A";
						}
						for(IG731Info entity:processInfoEntityList){
							if(pi.getPiid().equals(entity.getPiid())){
								//�ж�EntityItemTB��EntityItemVWTB�Ƿ�Ϊ��//����ԭ������ΪIG731���������IG013��IG688
								flag = false;
								String einame = "";
								if(entity.getEntityItemTB() != null){
									einame = entity.getEntityItemTB().getEiname();
									eiid = entity.getEntityItemTB().getEiid();
								}else if(entity.getEntityItemVWTB() != null){
									einame = entity.getEntityItemVWTB().getEiname();
									eiid = entity.getEntityItemVWTB().getEiid();
								}
								
								tagString.append("<a href=\"javascript:void(0)\" asm=\"")
										 .append(pidid)
										 .append("\" onclick=\"openSubIGCOM0303('")
										 .append(entity.getEiid())
										 .append("','")
										 .append(entity.getEiversion())
										 .append("');\" id=\"")
										 .append(entity.getPieid())
										 .append("\">")
										 .append(einame)
//										 .append("(")
//										 .append(entity.getEiversion())
//										 .append(")")
										 .append("</a><img id=\"")
										 .append(entity.getPieid())
										 .append("ENT\" src=\"images/delate.gif\" align=\"middle\" ");
								 tagString.append(" onClick=\"delSelect2SingleEntity('")
								 		  .append(entity.getPieid())
								 		  .append("','").append(pidid)
								 		  .append("','").append(property)
								 		  .append("','")
								 		  .append(pidid)
								 		  .append("','")
								 		  .append(syscoding)
								 		  .append("',")
								 		  .append(index)
								 		  .append(",");
								 if("1".equals(pidrequired)){
									 tagString.append("'1'");
								 }else{
									 tagString.append("'0'");
								 }
								 tagString.append(");\"");
								tagString.append(" border=\"0\" style=\"cursor: hand\" alt='ɾ��'/>&nbsp;");
								tagString.append("<input type=\"hidden\" id=\"ENT"+pidid+"\" value=\""+entity.getPieid()+"\">");
							}
						}
					}
				}
			}
		}
		String displayflag= "";
		if(!flag){
			displayflag = "none";
		}
		//��ǩ��������Ϣ
		tagString.append(" <select class=\"js-example-basic-single js-states form-control\" style=\"width:180px;display:"+displayflag+";\" ")
		.append(index)
		.append("  id=\"assetSelector"+pidid+"\"  >");
		tagString.append("</select>");
		tagString.append("<script>asmNum=").append(index+1).append(";</script>");
		tagString.append("<input type=\"hidden\" name=\"entityId["+index+"]\" id=\"entity").append(pidid).append("\" eiid=\"").append(pidid + "#"+eiid).append("\" >");
		tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"").append(value).append("\"/>");
		return tagString.toString();
	}
	
	/**
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTag(Map<String, Object> params){
		
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		//��ر�����Ϣȡ�� 
		List<IG599Info> processInfoList = (List<IG599Info>) params.get(PARAMS_PROCESSINFO_LIST);
		//����ʲ���Ϣȡ��
		List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
		//��������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		if(processInfoList!=null){
			for(IG599Info pi:processInfoList){
				if(pidlabel.equals(pi.getPivarlabel())&& WorkFlowConstDefine.PROCESS_ASSET_PIVRTYPE.equals(pi.getPivartype())){
					if(processInfoEntityList!=null){
						for(IG731Info entity:processInfoEntityList){
							if(pi.getPiid().equals(entity.getPiid())){
								tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303('")
										 .append(entity.getEiid())
										 .append("','")
										 .append(entity.getEiversion())
										 .append("');\" id=\"")
										 .append(entity.getPieid())
										 .append("\">")
										 .append(entity.getEntityItemVWTB().getEiname())
//										 .append("(")
//										 .append(entity.getEiversion())
//										 .append(")")
										 .append("</a>")
										 .append("<br />");
							}
						}
					}
				}
			}
		}
		String value = (String) params.get(PARAMS_VALUE);
		if(StringUtils.isNotEmpty(value) && !"N/A".equals(value)){

			IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
			IG688SearchCondImpl cond = new IG688SearchCondImpl();
			List<String> eiids = new ArrayList<String>();
			for(String s:value.split("#")){
				eiids.add(s);
			}
			if(eiids.size() > 0){
				cond.setEiidList(eiids);
				if(eiids.get(0).indexOf("_")>0){
					SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
					for(String eiid : eiids){
						try {
							SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(eiid.split("_")[0]),Integer.parseInt(eiid.split("_")[1])));
							tagString.append("<a href=\"javascript:void(0)\" asm=\"")
							.append("\" onclick=\"openSubIGCOM0303ForER('")
							.append(eiid)
							.append("','")
							.append(info.getEiversion())
							.append("")
							.append("');\" id=\"")
							.append(eiid)
							.append("EIID\">")
							.append(info.getEiname())
//							.append("(")
//							.append(info.getEiversion())
//							.append(")")
							.append("</a>")
							.append("<br />");
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (BLException e) {
							e.printStackTrace();
						}
					}
				}else{
					List<IG688Info> list = ig013BL.searchIG688Info(cond);
					for(IG688Info info:list){
						tagString.append("<a href=\"javascript:void(0)\" asm=\"")
						.append("\" onclick=\"openSubIGCOM0303('")
						.append(info.getEiid())
						.append("','")
						.append(info.getEiversion())
						.append("")
						.append("');\" id=\"")
						.append(info.getEiid())
						.append("EIID\">")
						.append(info.getEiname())
//						.append("(")
//						.append(info.getEiversion())
//						.append(")")
						.append("</a>")
						.append("<br />");
					}
				}
			}
		}
		return tagString.toString();
	}
	
   /**
    *���̹ر�״̬״̬��������ʾ
    * @param params ����
    * @return ���̹ر�״̬״̬��������ʾ
    */
   @Override
   public String generatedStatusCloseTag(Map<String, Object> params){
       //ȡ��piid
       String pidid = (String) params.get(PARAMS_PIDID);
       //��������ȡ��
       String property = (String) params.get(PARAMS_PROPERTY);
       //����ֵȡ��
//       String value = (String) params.get(PARAMS_VALUE);
       
       //�ر�֮���״̬��˽�б����б�
       @SuppressWarnings("unchecked")
       Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) params.get(FormGeneratedTag.PARAMS_STATUS_CLOSE);
       //����ʲ���Ϣȡ��
       @SuppressWarnings("unchecked")
       List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
       
       StringBuffer tagString = new StringBuffer();
       if(statusclosedetails!=null){
           tagString.append("<table class=\"table_form\" style=\"width:100%;\"> " );
           List<IG561VWInfo> list= statusclosedetails.get(pidid);
           for(IG561VWInfo info:list){
               tagString.append("<tr>")
                   .append("<td style=\"width:30%;\">").append(info.getPsdname())
                   .append("</td>")
               
                   .append("<td style=\"width:70%;\">");
               //�ڴ��������⴦���߼� start
               boolean flag=false;
               for(IG731Info entity:processInfoEntityList){
                   if(StringUtils.isNotEmpty(info.getPivarvalue())&&info.getPivarvalue().equals(entity.getPieid().toString())){
                       tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303('")
                                .append(entity.getEiid())
                                .append("','")
                                .append(entity.getEiversion())
                                .append("');\" id=\"")
                                .append(entity.getPieid())
                                .append("\">")
                                .append(entity.getEntityItemTB().getEiname())
                                .append("</a>")
                                .append("<br />");
                                ;
                       flag=true;
                   }
               }
               //���û�ж�����Ĭ��ֵ������ʾĬ��ֵ
               if(!flag&&StringUtils.isNotEmpty(info.getPivarvalue())&&info.getPivarvalue().contains("def_")){
                   IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
                   IG688SearchCondImpl cond = new IG688SearchCondImpl();
                   List<String> eiids = new ArrayList<String>();
                   String value=info.getPivarvalue().substring(4);
                   for(String s:value.split("#")){
                       eiids.add(s);
                   }
                   if(eiids.size() > 0){
                       cond.setEiidList(eiids);
                       List<IG688Info> list_688 = ig013BL.searchIG688Info(cond);
                       for(IG688Info ig688Info:list_688){
                           tagString.append("<a href=\"javascript:void(0)\" asm=\"")
                            .append("\" onclick=\"openSubIGCOM0303('")
                            .append(ig688Info.getEiid())
                            .append("','")
                            .append(ig688Info.getEiversion())
                            .append("")
                            .append("');\" id=\"")
                            .append(ig688Info.getEiid())
                            .append("EIID\">")
                            .append(ig688Info.getEiname())
                            .append("(")
							.append(ig688Info.getEiversion())
							.append(")")
                            .append("</a>")
                            .append("<br />");
                       }
                   }
               }
               //�ڴ��������⴦���߼� end
               tagString.append("</td>");
               tagString.append("</tr>");
           }
           tagString.append("</table>");
       }
       tagString.append("<input type=\"hidden\" id=\"pidid")
                .append(pidid)
                .append("\" name=\"")
                .append(property)
                .append("\" value=\"")
                .append("")
                .append("\"/>");
       return tagString.toString();
   }
	
}