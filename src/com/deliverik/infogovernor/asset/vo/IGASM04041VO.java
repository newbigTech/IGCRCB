package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * 合同详细信息VO
 * 
 * @author
 * 修改时间 2012/11/26 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM04041VO extends BaseVO implements Serializable{
	
	/** 合同信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 合同所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 图像扫描XML */
	protected String picuXml;
	
	/** 图像查看XML */
	protected String picsXml;

	/** 初始化合同相关显示列表 */
	protected Map<String,String> dismap;
	
	/** 图像显示标识 */
	protected Boolean image_flag;

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM04041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 合同信息取得
	 * @return 合同信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public Map<String, String> getDismap() {
		return dismap;
	}

	public void setDismap(Map<String, String> dismap) {
		this.dismap = dismap;
	}

	/**
	 * 图像显示标识取得
	 *
	 * @return image_flag 图像显示标识
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * 图像显示标识设定
	 *
	 * @param image_flag 图像显示标识
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}