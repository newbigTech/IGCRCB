﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0107" toScope="request" />
<bean:define id="title" value="参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//角色下的人员选择标识 1 为已选参与者标识   2 为可选参与者标识
	var selectRoleUserFlag = 1;
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="参与者" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择要添加的参与者。';
			confirmMsg = '请确认是否要进行参与者添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			IGPRD0107Form.action = getAppRootUrl() + "/IGPRD0107.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("roleid_add");
			var ppuserids=document.getElementsByName("ppuserid");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("roleids",check[i].value,IGPRD0107Form);
					createHiddenInputForm("ppuserids",ppuserids[i].value,IGPRD0107Form);
				}
			}
		}else{
			var check=document.getElementsByName("roleid_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("ppdids",check[i].value,IGPRD0107Form);
				}
			}
		}
		return count;
	}	

	function selectRoleUser(roleid,flag){
		selectRoleUserFlag = flag;
		openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		if(selectRoleUserFlag == 1){
			var check = document.getElementsByName("roleid");
			for(var i=0;i<check.length;i++){
				if(check[i].value == roleid){
					document.getElementsByName("userid")[i].value = userid;
					document.getElementsByName("username")[i].value = username;
					break;
				}
			}
		}else{
			var check=document.getElementsByName("roleid_add");
			for(var i=0;i<check.length;i++){
				if(check[i].value==roleid){
					document.getElementsByName("ppuserid")[i].value = userid;
					document.getElementsByName("ppusername")[i].value = username;
					break;
				}
			}
		}
	}

	function ope(temp,psdid,ppdid,pdid){
		if(temp=="domain"){
			IGPRD0107Form.action=getAppRootUrl() + "/IGPRD0108_Disp.do?psdid="+psdid+"&ppdid="+ppdid+"&pdid="+pdid;
			IGPRD0107Form.submit();
		}
	}
	function changeParticipants(){
		if(window.confirm("是否确认更改参与者？")){
			form.action = getAppRootUrl() + "/IGPRD0107_Change.do";
			form.submit();
		}
	}
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0107" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation /> &gt;&gt; 状态列表 &gt;&gt; 参与者</p>
<div class="back">
	<a href="IGPRD0104_Back.do?pdid=${IGPRD0107Form.pdid}&ppsdid=${IGPRD0107Form.ppsdid}" target="_self">返回</a>
</div> 
</div>
<div class="role_title">当前状态：${IGPRD01071VO.processStatusDef.psdname}</div>
<br/>
	<div class="role_title">现有参与者</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<c:if test="${IGPRD01071VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','roleid_del')"/> 
						</c:if>
					</label>
				</th>
				<th width="40%">角色名称</th>
				<th width="20%">参与人</th>
				<th width="20%">权限</th>
			</tr>
			<logic:present name="IGPRD01071VO" property="processParticipantDefMap">
				<logic:iterate id="map" name="IGPRD01071VO" property="processParticipantDefMap" indexId="index">
				<bean:size id="ppdsize" name="map" property="value"/>
				<logic:iterate id="bean" name="map" property="value" indexId="idx">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
							<c:if test="${IGPRD01071VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="roleid_del" value="${bean.ppdid}">
							</c:if>
							<c:if test="${IGPRD01071VO.processStatusDef.psdtype == '1'}">
							<input type="radio" name="roleid_del" value="${bean.ppdid}">
							</c:if>
						 	</label>
						 	<input type="hidden" name="change_ppdid" value="${bean.ppdid }"/>
							<input type="hidden" name="roleid" value="${bean.roleid }"> 
						</td>
						<c:if test="${idx == 0 }">
						<td rowspan="${ppdsize }">
							${bean.role.rolename}
						</td>
						</c:if>
						<td>
							<input type="text" size="10" style="text-align: center;" name="username" value="${bean.user.username}">
							<input type="hidden" name="userid" value="${bean.userid }">
							<a href="javascript:void(0)" onclick="selectRoleUser('${bean.roleid}',1);"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
						</td>
						<c:if test="${idx == 0 }">
						<td rowspan="${ppdsize }">
							<a href="javascript:ope('domain','${bean.psdid}','${bean.ppdid}','${pdid}');">
							<img src="images/sqcd.gif" width="16" height="16" border="0" alt="权限" />
							</a>
						</td>
						</c:if>
					</tr>
					</logic:iterate>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01071VO" property="processParticipantDefList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('0');" />
		<html:button property="btn_changeParticipant"  value="保存更改" styleClass="button"  onclick="changeParticipants();"/>
		<%} %>	
		</span>
	</logic:present>
	</div>
	<div class="role_title">可选参与者</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
						<c:if test="${IGPRD01071VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','roleid_add')"/> 
						</c:if>
					</label>
				</th>
				<th width="40%">角色名称</th>
				<th width="40%">参与人</th>
			</tr>
			<logic:present name="IGPRD01071VO" property="roleList">
				<logic:iterate id="bean" name="IGPRD01071VO" property="roleList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
						<label>
							<c:if test="${IGPRD01071VO.processStatusDef.psdtype != '1'}">
								<input type="checkbox" name="roleid_add" value="${bean.roleid}">
							</c:if>
							<c:if test="${IGPRD01071VO.processStatusDef.psdtype == '1'}">
							<input type="radio" name="roleid_add" value="${bean.roleid}">
							</c:if>
						</label>
						</td>
						<td>${bean.rolename}
						</td>
						<td><input type="text" name="ppusername" size="10" style="text-align: center" readonly="readonly"/><input type="hidden" name="ppuserid"/>
						<a href="javascript:void(0)" onclick="selectRoleUser('${bean.roleid}',2);"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01071VO" property="roleList">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<c:choose>
			<c:when test="${IGPRD01071VO.processStatusDef.psdtype != '1'}">
					<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
			</c:when>
			<c:when test="${IGPRD01071VO.processStatusDef.psdtype == '1' && IGPRD01071VO.processParticipantDefListSize == 0}">
				<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
			</c:when>
		</c:choose>
		<%} %>	
	</logic:present>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0107Form"/>
	<html:hidden property="psdid" styleId="psdid" name="IGPRD0107Form"/>
	<html:hidden property="ppsdid" styleId="ppsdid" name="IGPRD0107Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>