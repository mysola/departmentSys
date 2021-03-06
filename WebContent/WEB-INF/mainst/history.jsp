<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>武汉理工大学学生寝室管理系统</title>
 <link rel="stylesheet" type="text/css" href="../static/css/normalize.css">
 <link rel="stylesheet" type="text/css" href="../static/css/global.css">
 <link rel="stylesheet" type="text/css" href="../static/css/mainstIndex.css">   
 <script src="../static/js/jquery-1.11.2.min.js"></script>
 <script src="../static/js/global.js"></script>
 <script src="../static/js/mainst.js"></script>
</head>
<body>
  <header>
    <img src="../static/img/logo.png8" title="logo" class="url-img" />
	<div>
		<s:if test="#session.mainst!=null">
			维修人员：<s:property value="#session.mainst.name" />&nbsp;&nbsp;
			<form action="../common/logoff" id="form-loginOut"
				style="display: inline-block">
				<a href="javascript:void(0);" id="login-out">退出登录</a>
			</form>
		</s:if>
		<s:else>
			<a href="javascript:void(0)" id="login">用户登录</a>
		</s:else>
	</div>
  </header>
  <nav></nav>
  <main class="roomInfo">
    <aside>
      <ul>
			<li><a href="javascript:void(0);" id="mainst-myInfo">个人中心</a></li>
			<li><a href="javascript:void(0);" id="mainst-unRecevied">未接维修</a></li>
			<li><a href="javascript:void(0);" id="mainst-recevied">已接维修</a></li>
			<li><a href="javascript:void(0);" id="mainst-history">维修历史</a></li>
      </ul>
    </aside>
    <div class="main">
      <table>
        <tr>
          <th width="30px">寝室号</th>
          <th width="40px">维修类别</th>
          <th width="90px">备注</th>
          <th width="50px">报修时间</th>
          <th width="50px">接受时间</th>
          <th width="50px">完成时间</th>
        </tr>
		<s:iterator value="#request.repairs">
			<tr>
				<td><s:property value="bedroom.num"/></td>
				<td><s:property value="type.type"/></td>
				<td><s:property value="note"/></td>
				<td><s:date name="repairTime" format="yyyy-MM-dd" var="rpdate"/><s:property value="rpdate"/></td>
				<td><s:date name="receiveTime" format="yyyy-MM-dd" var="rvdate"/><s:property value="rvdate"/></td>
				<td><s:date name="finishTime" format="yyyy-MM-dd" var="fdate"/><s:property value="fdate"/></td>
			</tr>
		</s:iterator>
      </table>
	<s:include value="../common/page.jsp">
		<s:param name="url" value="'../mainst/getMainstRepair'"/>
	</s:include>
    </div>
  </main>
  <footer>
    <div id="link">友情链接：
      <a href="javascript:void(0);" id="whut-index">武汉理工大学</a>
      <a href="javascript:void(0);" id="whut-jwc">武汉理工大学教务处</a>
      <a href="javascript:void(0);" id="whut-yjsInfo">武汉理工大学研究生教育信息网</a>
    </div>
    <div id="copyright">Copyright © 2017 武汉理工大学.版权所有 Powered By 不随便的咸鱼.</div>
  </footer>
</body>
</html>
