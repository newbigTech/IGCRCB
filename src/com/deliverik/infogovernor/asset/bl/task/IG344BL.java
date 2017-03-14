/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;

/**
  * 概述: 业务逻辑接口
  * 功能描述: 业务逻辑接口
  * 创建记录: 2012/07/13
  * 修改记录: 
  */
public interface IG344BL extends BaseBL {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG344Info> searchIG344(
			IG344SearchCond cond, int start, int count);
}