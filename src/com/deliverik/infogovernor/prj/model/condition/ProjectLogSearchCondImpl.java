package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����: projectlog����������ʵ��
 * ��������: projectlog����������ʵ��
 * ������¼: 2012/04/19
 * �޸ļ�¼: 
 */
public class ProjectLogSearchCondImpl implements ProjectLogSearchCond {

	protected Integer pid;
	/**��־����ʱ��*/
	protected String pltime_to;
	/**��־��ʼʱ��*/
	protected String pltime_from;
	/**��־����*/
	protected String plinfo;
	/**��־����*/
	protected String pltype;
	/**��־���Ͳ�Ϊ��*/
	protected String pltype_ne;
	
	
	/**
	 * pidȡ��
	 * @return pid
	 *
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * pid�趨
	 * @param pid
	 *
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * ��־��ʼʱ��ȡ��
	 * @return pltime_from
	 */
	public String getPltime_from() {
		return pltime_from;
	}
	/**
	 * ��־��ʼʱ���趨
	 * @param pltime_from
	 */
	public void setPltime_from(String pltime_from) {
		this.pltime_from = pltime_from;
	}
	/**
	 * ��־����ʱ��ȡ��
	 * @return pltime_to
	 */
	public String getPltime_to() {
		return pltime_to;
	}
	/**
	 * ��־����ʱ���趨
	 * @param pltime_to
	 */
	public void setPltime_to(String pltime_to) {
		this.pltime_to = pltime_to;
	}
	/**
	 * ��־����ȡ��
	 * @return plinfo
	 */
	public String getPlinfo() {
		return plinfo;
	}
	/**
	 * ��־�����趨
	 * @param plinfo
	 */
	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}
	/**
	 * ��־����ȡ��
	 * @return pltype
	 */
	public String getPltype() {
		return pltype;
	}
	/**
	 * ��־�����趨
	 * @param pltype
	 */
	public void setPltype(String pltype) {
		this.pltype = pltype;
	}
	/**
	 * ��־���Ͳ�Ϊ��ȡ��
	 * @return pltype_ne
	 */
	public String getPltype_ne() {
		return pltype_ne;
	}
	/**
	 * ��־���Ͳ�Ϊ���趨
	 * @param pltype_ne
	 */
	public void setPltype_ne(String pltype_ne) {
		this.pltype_ne = pltype_ne;
	}
	
	
}