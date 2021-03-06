package com.deliverik.framework.soc.asset.model;

/**
 * 设备资产信息
 * 
 */
public interface SOC0602Info {

	/**
	 * 设备资产ID取得
	 * @return 设备资产ID
	 */
	public Integer getEiid();

	/**
	 * 设备资产模型ID取得
	 * @return 设备资产模型ID
	 */
	public String getEid();

	/**
	 * 设备资产名称取得
	 * @return 设备资产名称
	 */
	public String getEiname();
	
	/**
	 * 设备资产编号取得
	 * @return 设备资产编号
	 */
	public String getEilabel();

	/**
	 * 设备资产说明取得
	 * @return 设备资产说明
	 */
	public String getEidesc();

	/**
	 * 设备资产版本号取得
	 * @return 设备资产版本号
	 */
	public Integer getEiversion();

	/**
	 * 登记日取得
	 * @return 登记日
	 */
	public String getEiinsdate();

	/**
	 * 设备资产位置（U）取得
	 * @return 设备资产位置（U）
	 */
	public String getU_value();

	/**
	 * 设备资产高度（U）取得
	 * @return 设备资产高度（U）
	 */
	public String getU_width();

	/**
	 * 所属机柜ID取得
	 * @return 所属机柜ID
	 */
	public Integer getContainer_eiid();

	/**
	 * 所属机柜编号取得
	 * @return 所属机柜编号
	 */
	public String getContainer_eilabel();

	/**
	 * 所属机柜名取得
	 * @return 所属机柜名
	 */
	public String getContainer_einame();
	
	/**
	 * 设备资产模型名称取得
	 * @return 设备资产模型名称
	 */
	public String getEname();
	
	/**
	 * 设备资产型号取得
	 * @return 设备资产型号
	 */
	public String getModel();

	/**
	 * 设备层次码取得
	 * @return 设备层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 设备层次码取得
	 * @return 设备层次码
	 */
	public String getInroomFlg();
	
	
	/**
	 * 设备状态取得
	 * @return 设备状态
	 */
	public String getEistatus();
	
	 /**
     * 功率取得
     *
     * @return power 功率
     */
    public String getPower();

    /**
     * 重量取得
     *
     * @return load 重量
     */
    public String getLoad();

    /**
	 * 所属机柜取得
	 * @return cabinet  所属机柜
	 */
	public String getCabinet();
}