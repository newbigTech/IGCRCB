<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGRIS0207" toScope="request" />
<bean:define id="title" value="风险检查详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
var gid='IGGIS0207';


</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back"><a href="IGRIS0203_sel.do" target="_self">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<bean:define id="bean" name="IGRIS02011VO" property="riskCheck" ></bean:define>
	<table cellspacing="2" class="table_style1">
	<table cellspacing="2" class="table_style1">
		<tr>
		<%-- 
			<th width="15%" align="right">
			检查项类别：
			</th>
			<td width="35%">${bean.rccategoryname}</td>--%>
			<th align="right">
			检查项名称：
			</th>
			<td colspan="3">${bean.rcname}</td>
		</tr>
		<tr>			
			<th width="15%" align="right">
			策略开始时间：
			</th>
			<td width="35%">${bean.rcstartdate}</td>
			<th align="right">
			策略结束时间：
			</th>
			<td>${bean.rcenddate}</td>
		</tr>
		<tr>
			<th width="15%" align="right">
			登记时间：
			</th>
			<td width="35%">${bean.rccreatetime}</td>
			<th align="right">
			频率：
			</th>
			<td>${IGRIS02011VO.cronInfo}</td>
			
		</tr>
		<tr>
			<th align="right">
			责任组：
			</th>
			<td>${bean.rcrolename}</td>
			<th align="right">
			责任人：
			</th>
			<td>${bean.rcusername}</td>
		</tr>
		
		<tr>
			<%-- <th align="right">
			相关资产：
			</th>
			<td>
				<a href="javascript:void(0)" onclick="openSubIGCOM0303('${bean.rcasset}','')">
					${bean.rcassetname}
				</a>
			</td>--%>
			<th align="right">
			重要程度：
			</th>
			<td colspan="3"><ig:codeValue ccid="RISKCHECK_TYPE_CODE" cid="${bean.rctype}" /></td>
		</tr>
		<tr>
			<th align="right">检查类型：</th>
			<td><ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${bean.rcclass}" /></td>
			<th align="right">
			工作执行期限(小时)：
			</th>
			<td>
				${bean.wtip}
			</td>
		</tr>
		<tr>
			<th align="right">检查方法：</th>
			<td colspan="3"><pre>${bean.rccommon}</pre></td>
		</tr>
		<tr>
			<th align="right">
			检查方法说明：
			</th>
			<td colspan="3">${bean.rcdesc}</td>
		</tr>
		<tr>
		  <th align="right">
			附件：
			</th>
		  <td colspan="3">
				<logic:present name="IGRIS02011VO" property="attachmentDataList">
				<logic:iterate id="bean" name="IGRIS02011VO"
					property="attachmentDataList" indexId="index">
					<!-- 附件 -->
					<logic:empty name="bean"
					property="attname">&nbsp;</logic:empty>
					<a href="<%=contextPath %>/downloadFinFile.do?attId=${bean.attid}&type=risk">
					<bean:define id="attname" name="bean" property="attname" />
					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					</a>
				</logic:iterate>
				
				</logic:present>
		  </td>
		  </tr>
		  
	</table>
	</div>

	
	
   </div>
   </div>  
  </div>


</div>
</body>
</html:html>