/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 虚拟资源项目信息表检索条件接口
  * 功能描述: 虚拟资源项目信息表检索条件接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface VIM02SearchCond {

    /**
     * 获取部署进度
     * @return 部署进度 
     */
    public String getProgress_eq();
    
}