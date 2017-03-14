package com.deliverik.framework.asset.model;

/**
 * �豸�ʲ���Ϣ
 * 
 */
public interface IG912Info {

	/**
	 * �豸�ʲ�IDȡ��
	 * @return �豸�ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �豸�ʲ�ģ��IDȡ��
	 * @return �豸�ʲ�ģ��ID
	 */
	public Integer getEid();

	/**
	 * �豸�ʲ�����ȡ��
	 * @return �豸�ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �豸�ʲ����ȡ��
	 * @return �豸�ʲ����
	 */
	public String getEilabel();

	/**
	 * �豸�ʲ�˵��ȡ��
	 * @return �豸�ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �豸�ʲ��汾��ȡ��
	 * @return �豸�ʲ��汾��
	 */
	public int getEiversion();

	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getEiinsdate();

	/**
	 * �豸�ʲ�λ�ã�U��ȡ��
	 * @return �豸�ʲ�λ�ã�U��
	 */
	public String getU_value();

	/**
	 * �豸�ʲ��߶ȣ�U��ȡ��
	 * @return �豸�ʲ��߶ȣ�U��
	 */
	public String getU_width();

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public int getContainer_eiid();

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getContainer_eilabel();

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getContainer_einame();
	
	/**
	 * �豸�ʲ�ģ������ȡ��
	 * @return �豸�ʲ�ģ������
	 */
	public String getEname();
	
	/**
	 * �豸�ʲ��ͺ�ȡ��
	 * @return �豸�ʲ��ͺ�
	 */
	public String getModel();

	/**
	 * �豸�����ȡ��
	 * @return �豸�����
	 */
	public String getEsyscoding();
	
	/**
	 * �豸�����ȡ��
	 * @return �豸�����
	 */
	public String getInroomFlg();
	
	
	/**
	 * �豸״̬ȡ��
	 * @return �豸״̬
	 */
	public String getEistatus();
	
}