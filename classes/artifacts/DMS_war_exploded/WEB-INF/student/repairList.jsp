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
 <link rel="stylesheet" type="text/css" href="../static/css/repair.css">   
 <script src="../static/js/jquery-1.11.2.min.js"></script>
 <script src="../static/js/global.js"></script>
</head>
<body>
  <header>
    <img src="../static/img/logo.png8" title="logo" class="url-img" />
    <div>
		<s:if test="#session.student!=null">
			<s:property value="#session.student.name" />&nbsp;&nbsp;
    		<s:property
				value="#session.student.college+#session.student.major+#session.student._class" />
			<form action="../common/logoff" id="form-loginOut" style="display:inline-block">
    			<a href="javascript:void(0);"  id="login-out">退出登录</a>
    		</form>
		</s:if>
		<s:else>
			<a href="javascript:void(0)" id="login">用户登录</a>
		</s:else>
	</div>
  </header>
  <nav>
    <ul>
      <li><a href="javascript:void(0);" class="url-index">首页</a></li>
      <li><a href="javascript:void(0);" class="url-notice">通知公告</a></li>
      <li><a href="javascript:void(0);" class="url-download">相关下载</a></li>
      <li class="down1">
        <a href="javascript:void(0);" class="url-rpHistory">网上报修</a>
        <div class="down_content1">
          <a href="javascript:void(0);" class="url-rpHistory">报修记录</a>
          <a href="javascript:void(0);" class="url-addRepair">我要报修</a>
        </div>
      </li>
      <li><a href="javascript:void(0);" class="url-meter">电费查询</a></li>
      <li><a href="javascript:void(0);" class="url-roomHyg">卫生状况查询</a></li>
    </ul>
  </nav>
  <!-- 报修记录 -->
  <main class="repair_list">
    <div class="repair_tb">
      <table>
        <tr width="100%">
          <th width="30px">报修类别</th>
          <th width="80px">备注</th>
          <th width="40px">报修时间</th>
          <th width="40px">是否已接受</th>
          <th width="40px">接受时间</th>
          <th width="40px">是否已维修</th>
          <th width="40px">维修时间</th>
          <th width="40px"></th>
        </tr>
      	<s:iterator value="#request.repairs" id="repair">
      	  <tr>
      	  	<td><s:property value="type.type"/></td>
      	  	<td><s:property value="note"/></td>
      	  	<td>
      	  		<s:if test="repairTime!=null">
      	  			<s:date name="repairTime" format="yyyy-MM-dd" var="date1"/><s:property value="date1"/>
      	  		</s:if>      	  	
      	  	</td>
      	  	<td>
      	  	<s:if test="received==true">是</s:if>
      	  	<s:elseif test="received==false">否</s:elseif>
      	  	<%-- <s:property value="received"></s:property> --%>
      	  	</td>
      	  	<td>
      	  		<s:if test="receiveTime!=null">
      	  			<s:date name="receiveTime" format="yyyy-MM-dd" var="date2"/><s:property value="date2"/>
      	  		</s:if>
      	  	</td>
      	  	<td>
      	  	<s:if test="finished==true">是</s:if>
      	  	<s:elseif test="finished==false">否</s:elseif>
      	  	<%-- <s:property value="finished"></s:property> --%>
      	  	</td>
      	  	<td>
      	  		<s:if test="finishTime!=null">
      	  			<s:date name="finishTime" format="yyyy-MM-dd" var="date3"/><s:property value="date3"/>
      	  		</s:if>
      	  	</td>
      	  	<td>
      	  		<form action="../student/deleteRepair" style="width:50px;">  <!-- action尚未添加 -->
      	  			<input type="text" name="repairId" style="display:none;" value="<s:property value="repairId"/>">
      	  			<input type="submit" value="删除" class="button button-rounded button-tiny" style="margin:0;top:0;width:100px;">
      	  		</form>
      	  	</td>
      	  </tr>
		</s:iterator>
      </table>
      <s:include value="../common/page.jsp">
		<s:param name="url" value="'../student/getStuRepairList'"/>
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