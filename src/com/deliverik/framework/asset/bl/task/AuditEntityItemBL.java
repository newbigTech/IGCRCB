/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.asset.model.entity.AuditEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: 审计资产表业务逻辑接口
  * 功能描述: 审计资产表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditEntityItemBL extends BaseBL {

	/**
	 * 审计资产表实例取得
	 *
	 * @return 审计资产表实例
	 */
	public AuditEntityItemTB getAuditEntityItemTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditEntityItemInfo searchAuditEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditEntityItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditEntityItemInfo registAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditEntityItemInfo updateAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAuditEntityItem();

}