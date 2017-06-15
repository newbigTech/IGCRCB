/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;

/**
  * 概述: 审计任务表业务逻辑接口
  * 功能描述: 审计任务表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditTaskBL extends BaseBL {

	/**
	 * 审计任务表实例取得
	 *
	 * @return 审计任务表实例
	 */
	public AuditTaskTB getAuditTaskTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditTaskInfo> searchAuditTask();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditTaskInfo searchAuditTaskByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditTaskInfo registAuditTask(AuditTaskInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditTaskInfo updateAuditTask(AuditTaskInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditTaskByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditTask(AuditTaskInfo instance)
		throws BLException;

}