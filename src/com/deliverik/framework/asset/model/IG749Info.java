/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;


/**
  * 概述: 资产模型视图接口
  * 功能描述: 资产模型视图接口
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public interface IG749Info {

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 资产编号取得
	 *
	 * @return 资产编号
	 */
	public String getEilabel();

	/**
	 * 资产说明取得
	 *
	 * @return 资产说明
	 */
	public String getEidesc();

	/**
	 * 资产更新时间取得
	 *
	 * @return 资产更新时间
	 */
	public String getEiupdtime();

	/**
	 * 资产状态取得
	 *
	 * @return 资产状态
	 */
	public String getEistatus();

	/**
	 * 资产版本取得
	 *
	 * @return 资产版本
	 */
	public Integer getEiversion();

	/**
	 * 资产登记时间取得
	 *
	 * @return 资产登记时间
	 */
	public String getEiinsdate();

	/**
	 * 资产所属机构层次码取得
	 *
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();

	/**
	 * 资产所属模型层次码取得
	 *
	 * @return 资产所属模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产管理人ID取得
	 *
	 * @return 资产管理人ID
	 */
	public String getEiuserid();

	/**
	 * 资产管理人姓名取得
	 *
	 * @return 资产管理人姓名
	 */
	public String getEiusername();

	/**
	 * 资产模型名称取得
	 *
	 * @return 资产模型名称
	 */
	public String getEname();

	/**
	 * 模型标识取得
	 *
	 * @return 模型标识
	 */
	public String getElabel();

	/**
	 * 模型分类取得
	 *
	 * @return 模型分类
	 */
	public String getEcategory();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion();

}