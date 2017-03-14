/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.plugin.change.socket;
  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;

/***
 * ���ͱ���߳�
 * @time 2015/08/20
 * @author zhangq
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IgChangeThread implements Runnable {
	
	static Log log = LogFactory.getLog(IgChangeThread.class);

	
	protected static ActionServlet servlet;
	
	/**����ID*/
	protected Integer prid;
	
	public IgChangeThread(Integer prid){
		this.prid = prid;
	}
	
	
	/**
	 * ���ͱ���߳� ִ�в���
	 */
	public void run(){  
		log.info("=========================�����Ϣ���Ϳ�ʼ========================");
		IGCHANGE01BLImpl ctrBL = (IGCHANGE01BLImpl) WebApplicationSupport.getBean("iGCHANGE01BLImpl");
    	try {
    	    //ʵ����DTO
    	    IGCHANGE01DTO dto = new IGCHANGE01DTO();
    	    dto.setPrid(prid);
    		
    		//���ñ����־����BL��ѯ����Ӧ��prid��ص�������־����
    	    IGCHANGE01DTO initDto = ctrBL.searchInitiacteChangeAction(dto);
    	    
			//ʵ�������ͱ��������
			IGPMSSERVICE01Utils utils = new IGPMSSERVICE01Utils();
			/**��ʼ���ͱ����Ϣ*/ 
			utils.ChangeTicketPhase(initDto.getTicketId(),"true");
			
		} catch (BLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	log.info("=========================�����Ϣ���ͽ���========================");
	}  
   
	

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	
	public Integer getPrid() {
		return prid;
	}



	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}



	/**
	 * servlet��ȡ
	 * @return the servlet
	 */
	public static ActionServlet getServlet() {
		return servlet;
	}

	/**
	 * servlet�趨
	 * @param servlet servlet 
	 */
	public static void setServlet(ActionServlet servlet) {
		IgChangeThread.servlet = servlet;
	}  
} 