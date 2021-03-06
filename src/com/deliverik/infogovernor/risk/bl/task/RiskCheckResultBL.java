/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;

/**
 * 
 * 风险检查结果信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskCheckResultBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskCheckResultSearchCond cond);
	
	/**
	 * 条件检索结果(百分比)件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCountForRate(RiskCheckResultSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rcrid 风险检查结果信息ID
	 * @return 风险检查结果信息
	 */
	public RiskCheckResult searchRiskCheckResultByKey(Integer rcrid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部风险检查结果信息信息
	 */
	public List<RiskCheckResult> searchRiskCheckResultAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> searchRiskCheckResult(RiskCheckResultSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskCheckResult 登录数据
	 * @return 风险检查结果信息
	 */
	public RiskCheckResult registRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rcrid 风险检查结果信息ID
	 * @return
	 */
	public void deleteRiskCheckResult(Integer rcrid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskCheckResult 变更数据
	 * @return 风险检查结果信息
	 */
	public RiskCheckResult updateRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> findResultByCond(RiskCheckResultSearchCond cond, int start, int count);

	/**
	 * 首页检查工作查询
	 * @param userid 查询用户ID
	 * @param desc 是否按时间倒序排列
	 * @param group 是否查询相关检查工作信息(true:是;flase:否) 
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> riskCheckResultGoup(String userid, boolean desc, boolean group);
	
	public List<RiskCheckResult> sel(RiskCheckResultSearchCondImpl cond, int i,int j);
	public List<RiskCheckResult> dbmrcrsel(String year);
	public List<RiskCheckResult> getRiskCheckResult(RiskCheckResultSearchCond cond);

}
