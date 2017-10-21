<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武汉理工大学学生寝室管理系统</title>
<link rel="stylesheet" type="text/css"
	href="../static/css/normalize.css">
<link rel="stylesheet" type="text/css" href="../static/css/global.css">
<link rel="stylesheet" type="text/css"
	href="../static/css/masterIndex.css">
<script src="../static/js/jquery-1.11.2.min.js"></script>
<script src="../static/js/global.js"></script>
<script src="../static/js/master.js"></script>
</head>
<body>
	<header> <img src="../static/img/logo.png8" title="logo"/>
	<div>
		<s:if test="#session.master!=null">
			宿管：<s:property value="#session.master.name" />&nbsp;&nbsp;
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
        <li><a href="javascript:void(0);" id="master-myInfo">个人中心</a></li>
        <li><a href="javascript:void(0);" id="master-stuInfo">学生管理</a></li>
        <li><a href="javascript:void(0);" id="master-roomInfo">寝室状态</a></li>
      </ul>
    </aside>
    <div class="main">
		<table>
        <tr>
          <th width="30px" class="hide"><input type="checkbox" class="all">全选</th>
          <th width="40px">寝室号</th>
          <th width="40px">寝室状态</th>
          <th width="50px">上阶段卫生得分</th>
          <th width="50px">分数上传时间</th>
          <th width="60px">寝室星级</th>
          <th width="40px"></th>
        </tr>
<!--         <tr>
          <td class="hide"><input type="checkbox" name=""></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td><input type="button" name="" value="保存"></td>
        </tr> -->
        <s:iterator value="#request.bedrooms">        
			<tr>
	          	<td class="hide"><input type="checkbox" name="<s:property value="bedroomId"/>" value="<s:property value="score"/>" used="<s:property value="used"/>"></td>
				<td><s:property value="num"/></td>
				<td>
					<select id="<s:property value="bedroomId"/>" class="used">
						<s:if test="used==1">
							<option value="1" selected="true">可用</option>
							<option value="2">占用</option>
						</s:if>
						<s:else>
							<option value="1">可用</option>
							<option value="2" selected="true">占用</option>
						</s:else>
					</select>
					<%-- <s:property value="used"/> --%>
				</td>
				<td><input type="text" style="width:50px;" value="<s:property value="score"/>" class="score" id="<s:property value="bedroomId"/>"></td>
				<td><s:date name="updateTime" format="yyyy-MM-dd" var="date"/><s:property value="date"/></td>
				<td><s:property value="star"/></td>
	          	<td>
	          		<form action="../master/updateBedroom" style="width:50px;">    <!-- action尚未添加 -->
			          	<input type="text" name="bedroomId" style="display:none" value="<s:property value="bedroomId"/>">
			          	<input type="text" name="score" style="display:none" value="<s:property value="score"/>" bId="<s:property value="bedroomId"/>">
			          	<input type="text" name="used" style="display:none" value="<s:property value="used"/>" bedroomId="<s:property value="bedroomId"/>">
			          	<input type="text" name="updateTime" style="display:none" value="" class="updateTime">
			          	<input type="submit" value="保存" class="button button-rounded button-tiny" style="margin:0;top:0;width:100px;">
		          	</form>
	          	</td>
			</tr>
		</s:iterator>
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td class="hide">
          	<form action="../master/updateBedroom" id="form-roomAll">   <!-- action尚未添加 -->
          		<div style="display:none" id="roomAll">
          			
          		</div>
          		<input type="button"  value="保存" class="Ssave" id="roomSubmit">
          	</form>
          </td>
        </tr>
      </table>
      <a href="javascript:void(0);" class="opMul">操作多项</a>
	<s:include value="../common/page.jsp">
		<s:param name="url" value="'../master/updateBedroom'"/>      <!-- value尚未添加 -->
	</s:include>
    </div>
  </main>
	<footer>
	<div id="link">
		友情链接： <a href="javascript:void(0);" id="whut-index">武汉理工大学</a> <a
			href="javascript:void(0);" id="whut-jwc">武汉理工大学教务处</a> <a
			href="javascript:void(0);" id="whut-yjsInfo">武汉理工大学研究生教育信息网</a>
	</div>
	<div id="copyright">Copyright © 2017 武汉理工大学.版权所有 Powered By
		不随便的咸鱼.</div>
	</footer>
</body>
</html>