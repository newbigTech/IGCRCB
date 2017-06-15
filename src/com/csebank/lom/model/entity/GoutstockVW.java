/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csebank.lom.model.GoutstockVWInfo;

/**
 * 
 * ��Ʒ������Ϣ��ͼʵ��
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "GoutstockVW")
@SuppressWarnings("serial")
public class GoutstockVW implements Serializable,GoutstockVWInfo {
	
	/** ��Ʒ������ϢID */
	@Id
	protected Integer goid;
	
	/** ��������(0:��� 1:���� 2:���� 3:����) */
	protected String gotype;
	
	/** ������������� */
	protected String goorg;
	
	/** ��Ʒ���� */
	protected String gocategory;
	
	/** ��Ʒ���� */
	protected String goname;
	
	/** ��Ʒ��� */
	protected String gocode;
	
	/** ����ʱ�� */
	protected String gotime;

	/** �ɹ����뵥���� */
	protected String goreqnum;

	/** ���ⵥ�� */
	protected BigDecimal gooutprice;
	
	/** �������� */
	protected Integer goinnum;
	
	/** ������λ */
	protected String gounit;
	
	/** ��Ӧ��*/
	protected String goprovider;
	
	/** ������*/
	protected String gopurchaser;

	/** �����۸�*/
	protected BigDecimal goreliefprice;
	
	/** ��������*/
	protected Integer goreliefnum;
	
	/** ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)*/
	protected String gostatus;
	
	/** ���û���/�������������*/
	protected String goreqorg;
	
	/** ������/������ID*/
	protected String gorequser;
	
	/** ������/����������*/
	protected String gorequsername;
	
	/** �Ǽ���*/
	protected String gouser;
	
	/** �Ǽ�������*/
	protected String gousername;
	
	/** ��������*/
	protected Integer gochknum;
	
	/** ������ID*/
	protected String gochkid;
	
	/** ����������*/
	protected String gochkkname;
	
	/** ˵��*/
	protected String goreason;
	
	/** GStock���� */
	protected Integer gsid;
	
	/** ������ */
	protected Integer gsnum;
	
	/** ������������� */
	protected String gsorg;
	
	/** �ɹ�ƽ���� */
	protected BigDecimal gsavgprice;
	
	/** �������� */
	protected Integer gsfreezenum;
	
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return goid;
	}

	/**
	 * ˵��ȡ��
	 * @return ˵��
	 */
	public String getGoreason() {
		return goreason;
	}


	/**
	 * ˵���趨
	 * @param goreason ˵��
	 */
	public void setGoreason(String goreason) {
		this.goreason = goreason;
	}


	/**
	 *��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid() {
		return goid;
	}




	/**
	 *��Ʒ������ϢID�趨
	 * @param godid��Ʒ������ϢID
	 */
	public void setGoid(Integer goid) {
		this.goid = goid;
	}




	/**
	 * ��������(0:��� 1:���� 2:���� 3:����)ȡ��
	 * @return ��������(0:��� 1:���� 2:���� 3:����)
	 */
	public String getGotype() {
		return gotype;
	}




	/**
	 * ��������(0:��� 1:���� 2:���� 3:����)�趨
	 * @param godtype ��������(0:��� 1:���� 2:���� 3:����)
	 */
	public void setGotype(String gotype) {
		this.gotype = gotype;
	}




	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGoorg() {
		return goorg;
	}




	/**
	 * ��������������趨
	 * @param goorg �������������
	 */
	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGocategory() {
		return gocategory;
	}




	/**
	 * ��Ʒ�����趨
	 * @param gocategory ��Ʒ����
	 */
	public void setGocategory(String gocategory) {
		this.gocategory = gocategory;
	}




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGoname() {
		return goname;
	}




	/**
	 * ��Ʒ�����趨
	 * @param goname ��Ʒ����
	 */
	public void setGoname(String goname) {
		this.goname = goname;
	}




	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGocode() {
		return gocode;
	}




	/**
	 * ��Ʒ����趨
	 * @param godcode ��Ʒ���
	 */
	public void setGocode(String gocode) {
		this.gocode = gocode;
	}




	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getGotime() {
		return gotime;
	}




	/**
	 * ����ʱ���趨
	 * @param godtime ����ʱ��
	 */
	public void setGotime(String gotime) {
		this.gotime = gotime;
	}




	/**
	 * �ɹ����뵥����ȡ��
	 * @return �ɹ����뵥����
	 */
	public String getGoreqnum() {
		return goreqnum;
	}




	/**
	 * �ɹ����뵥�����趨
	 * @param goreqnum �ɹ����뵥����
	 */
	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}




	/**
	 * ���ⵥ��ȡ��
	 * @return ���ⵥ��
	 */
	public BigDecimal getGooutprice() {
		return gooutprice;
	}




	/**
	 * ���ⵥ���趨
	 * @param gooutprice ���ⵥ��
	 */
	public void setGooutprice(BigDecimal gooutprice) {
		this.gooutprice = gooutprice;
	}




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGoinnum() {
		return goinnum;
	}




	/**
	 * ���������趨
	 * @param goinnum ��������
	 */
	public void setGoinnum(Integer goinnum) {
		this.goinnum = goinnum;
	}



	/**
	 * ������λȡ��
	 * @return ������λ
	 */
	public String getGounit() {
		return gounit;
	}




	/**
	 * ������λ�趨
	 * @param gounit ������λ
	 */
	public void setGounit(String gounit) {
		this.gounit = gounit;
	}




	/**
	 * ��Ӧ��ȡ��
	 * @return ��Ӧ��
	 */
	public String getGoprovider() {
		return goprovider;
	}




	/**
	 * ��Ӧ���趨
	 * @param goprovider ��Ӧ��
	 */
	public void setGoprovider(String goprovider) {
		this.goprovider = goprovider;
	}




	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getGopurchaser() {
		return gopurchaser;
	}




	/**
	 * �������趨
	 * @param gopurchaser ������
	 */
	public void setGopurchaser(String gopurchaser) {
		this.gopurchaser = gopurchaser;
	}




	/**
	 * �����۸�ȡ��
	 * @return �����۸�
	 */
	public BigDecimal getGoreliefprice() {
		return goreliefprice;
	}




	/**
	 * �����۸��趨
	 * @param goreliefprice �����۸�
	 */
	public void setGoreliefprice(BigDecimal goreliefprice) {
		this.goreliefprice = goreliefprice;
	}




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGoreliefnum() {
		return goreliefnum;
	}




	/**
	 * ���������趨
	 * @param goreliefnum ��������
	 */
	public void setGoreliefnum(Integer goreliefnum) {
		this.goreliefnum = goreliefnum;
	}




	/**
	 * ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)ȡ��
	 * @return ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public String getGostatus() {
		return gostatus;
	}




	/**
	 * ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)�趨
	 * @param gostatus ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public void setGostatus(String gostatus) {
		this.gostatus = gostatus;
	}




	/**
	 * ���û���/�������������ȡ��
	 * @return ���û���/�������������
	 */
	public String getGoreqorg() {
		return goreqorg;
	}




	/**
	 * ���û���/��������������趨
	 * @param goreqorg ���û���/�������������
	 */
	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}




	/**
	 * ������/������IDȡ��
	 * @return ������/������ID
	 */
	public String getGorequser() {
		return gorequser;
	}




	/**
	 * ������/������ID�趨
	 * @param gorequser ������/������ID
	 */
	public void setGorequser(String gorequser) {
		this.gorequser = gorequser;
	}




	/**
	 * ������/����������ȡ��
	 * @return ������/����������
	 */
	public String getGorequsername() {
		return gorequsername;
	}




	/**
	 * ������/�����������趨
	 * @param gorequsername ������/����������
	 */
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}




	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getGouser() {
		return gouser;
	}




	/**
	 * �Ǽ����趨
	 * @param gouser �Ǽ���
	 */
	public void setGouser(String gouser) {
		this.gouser = gouser;
	}




	/**
	 * �Ǽ�������ȡ��
	 * @return �Ǽ�������
	 */
	public String getGousername() {
		return gousername;
	}




	/**
	 * �Ǽ��������趨
	 * @param gousername �Ǽ�������
	 */
	public void setGousername(String gousername) {
		this.gousername = gousername;
	}




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGochknum() {
		return gochknum;
	}




	/**
	 * ���������趨
	 * @param gochknum ��������
	 */
	public void setGochknum(Integer gochknum) {
		this.gochknum = gochknum;
	}




	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getGochkid() {
		return gochkid;
	}




	/**
	 * ������ID�趨
	 * @param gochkid ������ID
	 */
	public void setGochkid(String gochkid) {
		this.gochkid = gochkid;
	}




	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getGochkkname() {
		return gochkkname;
	}




	/**
	 * �����������趨
	 * @param gochkkname ����������
	 */
	public void setGochkkname(String gochkkname) {
		this.gochkkname = gochkkname;
	}
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * ����ID
	 * @param gsid ����ID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * ������
	 * @param ������
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * �������������
	 * @param �������������
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * �ɹ�ƽ����
	 * @param ���ɹ�ƽ����
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * ��������
	 * @param ��������
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

}