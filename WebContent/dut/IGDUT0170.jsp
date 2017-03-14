<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0170" toScope="request" />
<bean:define id="title" value="信息提示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div class="msg">
<div class="taps">信息提示</div>
</div>
<div class="msg_box"><html:form styleId="form" action="/IGDUT0101_Disp"
	onsubmit="return checkSubmit(this);">
	<div class="msg_img"><img src="images/Round_Icon_09.gif"
		border="0" /></div>
	<div class="msgcontent"><ig:message /></div>
	<div class="msgbtn">
	<input type="button" class="button" value="继续新增"  onclick="window.location='IGDUT0101_Disp.do';" />
	<input type="button" class="button" value="值班检查管理"  onclick="window.location='IGDUT0102_Disp.do?dadcategory=${IGDUT0101Form.dadcategory}';" />
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>