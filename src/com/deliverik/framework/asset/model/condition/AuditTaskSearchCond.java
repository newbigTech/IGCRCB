/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �����������������ӿ�
  * ��������: �����������������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditTaskSearchCond {
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getAutstatus_eq();
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getAutdesc_like() ;
	
	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getAuttime_from() ;
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getAuttime_to() ;

}