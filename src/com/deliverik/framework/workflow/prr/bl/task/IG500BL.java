/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;

/**
 * <p>
 * 流程记录记录信息业务逻辑
 * </p>
 */

public interface IG500BL extends BaseBL {
	
	/**
	 * <p>
	 * 创建流程记录实例
	 * </p>
	 * 
	 * @param ig500Info 流程记录
	 * @return 流程记录
	 * @throws BLException
	 */

	public IG500Info registIG500Info(IG500Info ig500Info)
			throws BLException;
	
	/**
	 * <p>
	 * 更新流程记录信息
	 * </p>
	 * 
	 * @param ig500Info 流程记录
	 * @return 流程记录
	 * @throws BLException
	 */

	public IG500Info updateIG500Info(IG500Info ig500Info)
			throws BLException;

	
	/**
	 * <p>
	 * 检索流程记录信息
	 * </p>
	 * 
	 * @param cond 流程记录信息检索条件
	 * @return 流程记录信息列表
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(IG500SearchCond cond);
			
	/**
	 * <p>
	 * 检索流程记录信息
	 * </p>
	 * 
	 * @param cond 流程记录信息检索条件
	 * @param start 检索起始条数
	 * @param count 检索条数
	 * @return 流程记录信息列表
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(
			IG500SearchCond cond, int start, int count);
	
	

	/**
	 * <p>
	 * 根据流程记录ID获取流程记录信息
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @return 流程记录
	 * @throws BLException 
	 */
	
	public IG500Info searchIG500InfoByKey(Integer processId) throws BLException;
	
	/**
	 * 获取流程记录实例
	 * 
	 * @return ProcessRecordTB
	 * @throws BLException
	 */
	
	public IG500TB getIG500TBInstance();
	
	/**
	 * <p>
	 * 检索流程记录总数
	 * </p>
	 * 
	 * @param cond 流程记录检索条件
	 * @return 流程记录总数
	 */
	
	public int getIG500InfoSearchCount(IG500SearchCond cond);
	
	/**
	 * 服务请求条件检索处理（平台保留）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 服务请求条件检索记录数（平台保留）
	 * @return 条件检索记录数
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond);
	
	/**
	 * 流程(包含事件处理子状态）条件检索处理（平台保留）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * 流程(包含事件处理子状态）条件检索处理（平台保留）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count);
	
	
	/**
	 * 流程(包含事件处理子状态）条件检索记录数（平台保留）
	 * @return 条件检索记录数
	 */
	public int queryIG500InfoSubStatusListCount(final IG500SearchCond cond);
	
	/**
	 * 流程(包含事件处理子状态）条件检索记录数（平台保留）
	 * @return 条件检索记录数
	 */
	public int queryIG500ONLYInfoSubStatusListCount(final IG500SearchCond cond);
	
	
	/**
	 * <p>
	 * 获取指定角色所有的待办流程记录
	 * </p>
	 * 
	 * @param roleId 角色ID
	 * @param prType 流程记录类型
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByRole(Integer roleId,String prType);

	/**
	 * <p>
	 * 获取指定用户所有的待办流程记录
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param prType 流程记录类型
	 * @param pdid 流程定义ID
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByUser(String userId,String prType,String pdid,String prstatus);

	
	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息结果条数
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @return 流程记录与参与用户信息结果集合
	 */
	public int getProcessRecordVWSearchCount(IG677SearchCond cond);

	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @return 流程记录与参与用户信息结果集合
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond);
	
	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @param start 检索起始条数
	 * @param count 检索总条数
	 * @return 流程记录与参与用户信息结果集合
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond, int start, int count);
	
	/**
	 * 根据流程记录信息主键删除流程记录信息处理
	 * 
	 * @param prid 删除流程记录信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecordByKey(Integer prid) throws BLException;
	
	/**
	 * 删除流程记录信息处理
	 * 
	 * @param processRecord 删除的流程记录信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecord(IG500Info processRecord) throws BLException;
	
	/**
	 * 指定用户未处理流程条件检索处理
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid);

	/**
	 * 指定角色未处理流程条件检索处理
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid);
	
	/**
	 * 获取流程分派者角色所有的待办流程记录
	 * @param roleid 流程分派者角色ID
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByFPRole(Integer roleid, String prtype);
	
	/**
	 * 检测指定用户是否具有指定流程查看权限（目前只支持变更，发布）
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 权限标识
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid);
	
	/**
	 * 当流程指定到角色时,在角色负责人的我的工作中显示此条流程信息
	 * @param userid 用户ID
	 * @return
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid);
	
	/**
	 * 流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryProcessRecordEntityList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond);
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count);
	
	/**
	 * 自定义流程相关工作条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchProcessRecordCountForRelatedWork(final IG500SearchCond cond);
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * <p>
	 * 查询流程相关的共通变量信息
	 * </p>
	 * 
	 */
	public List<String> getProcessInfoDefGeneral(List<IG677Info> list, Integer pidGeneralId);

	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果数量
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 首页上按部门统计工作数量查询处理
	 * @return 检索结果列表
	 */
	public List<IG808Info> getOrganizationProcessCount();
	
	/**
	 * 功能：根据工单标识查询当前最大流水号
	 * @param prserialnum 工单标识
	 * @return 最大流水号
	 */
	public String searchMaxPrserialnum(String prserialnum);
	
	/**
	 * 功能：根据用处理人id取得发文流程列表
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchDispatchStatistics(IG677SearchCond cond, int start, int count);
	
	/**
	 * 功能：根据用处理人id取得发文流程列表数量
	 * @return 记录总数
	 */
	public int findDispatchStatisticsSearchCount(IG677SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count);

	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(IG500SearchCond cond);
	
	/**
	 * 查询指定监管报表key关联的流程
	 * @param type 报表类型
	 * @param pdid 报表定义ID
	 * @param key 报表实例key
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 关联流程
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException;
	
	/**
	 * 根据指定的流程类型查询流程
	 * @param type 流程查询类型
	 * @return 流程信息
	 */
	public List<IG500Info> searchProcessByType(IG500SearchCond cond,int start,int count,String type) throws BLException;
	
	/**
	 * 根据指定的流程类型查询流程数量
	 * @param type 流程查询类型
	 * @return 流程信息
	 */
	public Integer searchProcessByTypeCount(IG500SearchCond cond,String type) throws BLException;
	
	/**
	 * 获取流程当前状态显示名称
	 * @param prid 流程ID
	 * @return 流程当前状态显示名称
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException;
	
	/**
	 * 获取流程当前状态
	 * @param prid 流程ID
	 * @return 流程当前状态
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException;
	
	
	/**
	 * 条件检索
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException;
	
	/**
	 * dashboard
	 *	风险评估工作总体情况 问题数量
	 * @param months
	 * @return List<Map>
	 * <p>
	 * 	map 结构   key :(DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT)
	 * </p>
	 */
	public List<Map> getRiskAssess (String months,String prpdid)throws BLException;
	
	/**
	 * 问题整改
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(RehearseSearchCond cond, int start, int count) throws BLException;
	/**
	 * 问题整改 根据领域钻取
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(RehearseSearchCond cond, int start, int count) throws BLException;
/** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO 查询ig500 和流程状态，当前流程状态的参与者
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> queryIG500WithStatusAndPart(IG500SearchCond prSearchCond, int i, int j)throws BLException;
    
    /**
     * 查询应急处置流程
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count);
    
    /**
     * 查询应急处置流程数量
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public Integer countDrmFlow(final IG500SearchCond cond);
}
