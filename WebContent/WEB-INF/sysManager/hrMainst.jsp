<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武汉理工大学学生寝室管理系统</title>
<link rel="stylesheet" type="text/css"
	href="../static/css/normalize.css">
<link rel="stylesheet" type="text/css" href="../static/css/global.css">
<link rel="stylesheet" type="text/css"
	href="../static/css/sysManagerIndex.css">
<script src="../static/js/jquery-1.11.2.min.js"></script>
<script src="../static/js/global.js"></script>
<script src="../static/js/sysManager.js"></script>
</head>
<body>
	<header> <img src="../static/img/logo.png8" title="logo" />
	<div>
		<s:if test="#session.sysManager!=null">
			系统管理员：<s:property value="#session.sysManager.name" />&nbsp;&nbsp;
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
	<main> 
		<aside>
			<ul>
				<li><a href="javascript:void(0);" id="sys-hrMaster">宿管管理</a></li>
				<li><a href="javascript:void(0);" id="sys-hrMainst">维修员管理</a></li>
				<li><a href="javascript:void(0);" id="sys-building">宿舍楼管理</a></li>
				<li><a href="javascript:void(0);" id="sys-upload">上传文件</a></li>
				<li><a href="javascript:void(0);" id="sys-notice">发布通知</a></li>
			</ul>
		</aside>
		<div class="main">
	      <table>
	        <tr>
	          <th width="10px" class="hide"><input type="checkbox" class="all">全选</th>
	          <th width="30px">姓名</th>
	          <th width="15px">性别</th>
	          <th width="40px">出生年月</th>
	          <th width="40px">工号</th>
	          <th width="25px">密码</th>
	          <th width="20px">负责楼号</th>
	          <th width="20px">身份证号</th>
	          <th width="40px">联系方式</th>
	          <th width="15px">保存</th>
	          <th width="15px">删除</th>
	        </tr>
<!-- 	        <tr>
	          <td class="hide"><input type="checkbox" name=""></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td><input type="button" name="" value="保存"></td>
	          <td><input type="button" name="" value="删除"></td>
	        </tr> -->
	        <s:iterator value="#request.mainsts">
	        	<tr>
	        		<td class="hide"><input type="checkbox"></td>
	        		<td><input type="text" class="name" value="<s:property value="name"/>" masterId="name<s:property value="MasterId"/>"></td>
	        		<td>
	        			<select class="sex" masterId="sex<s:property value="MasterId"/>">
		        			<s:if test="sex=='男'">
		        				<option value="man" selected="true">男</option>
		        				<option value="woman">女</option>
		        			</s:if>
		        			<s:else>
		        				<option value="man">男</option>
		        				<option value="woman" selected="true">女</option>
		        			</s:else>
	        			</select>
	        		<%-- <s:property value="sex"/> --%>
	        		</td>
	        		<td><input type="text" class="birth" value="<s:property value="birth"/>" masterId="birth<s:property value="MasterId"/>"></td>
	        		<td><input type="text" class="username" value="<s:property value="username"/>" masterId="username<s:property value="MasterId"/>"></td>
	        		<td><input type="text" class="password" value="<s:property value="password"/>" masterId="password<s:property value="MasterId"/>"></td>
	        		<td>
	        			<s:iterator value="buildings">
	        				<select class="buildingNum" id="<s:property value="buildingId"/>" campus="<s:property value="campus"/>" masterId="building<s:property value="MasterId"/>">
		        				
		        			</select>
	        			</s:iterator>
	        		<%-- <s:property value="building.num"/> --%>
	        		</td>
	        		<td><input type="text" class="idCard" value="<s:property value="idCard"/>" masterId="idcard<s:property value="MasterId"/>"></td>
	        		<td><input type="text" class="tel" value="<s:property value="tel"/>"></td>
	        		<td>
	        			<form action="">
	        				<input>
	        				<input>
	        				<input>
	        				<input>
	        				<input>
	        				<input>
	        				<input>	        				
	        				<input type="submit" value="保存">
	        			</form>	        			
	        		</td>
	          		<td>
	          			<form action="">
	          				<input type="text" name="MasterId" style="display:none;" value="<s:property value="MasterId"/>">
	          				<input type="submit" value="删除">
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
	          <td></td>
	          <td></td>
	          <td></td>
	          <td></td>
	          <td class="hide"><input type="button" value="保存" class="Ssave"></td>
	          <td class="hide"><input type="button" value="删除" class="Ssave"></td>
	        </tr>
	      </table>
	      <a href="javascript:void(0);" class="opMul">操作多项</a>
		<s:include value="../common/page.jsp">
			<s:param name="url" value="'../sysManager/'"/>      <!-- value尚未添加 -->
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