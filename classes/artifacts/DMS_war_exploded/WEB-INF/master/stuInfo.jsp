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
			<input type="text" style="display:none;" id="masterBuilding" value="<s:property value="#session.master.building.buildingId"/>">
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
  <main class="stu">
    <aside>
      <ul>
        <li><a href="javascript:void(0);" id="master-myInfo">个人中心</a></li>
        <li><a href="javascript:void(0);" id="master-stuInfo">学生管理</a></li>
        <li><a href="javascript:void(0);" id="master-roomInfo">寝室状态</a></li>
      </ul>
    </aside>
    <div class="main stuInfo">
      <table>
        <tr>
          <th width="10px" class="hide"><input type="checkbox" class="all">全选</th>
          <th width="30px">姓名</th>
          <th width="15px">性别</th>
          <th width="65px">所在学院</th>
          <th width="65px">所在专业</th>
          <th width="20px">寝室号</th>
          <th width="40px">联系方式</th>
          <th width="15px">保存</th>
        </tr>
<!--         <tr>
          <td class="hide"><input type="checkbox" name=""></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td><input type="button" name="" value="保存"></td>
        </tr> -->
        <s:iterator value="#request.students">        
			<tr>				
	          	<td class="hide"><input type="checkbox" name="<s:property value="studentId"/>" value="<s:property value="bedroom.bedroomId"/>"></td>	          	
				<td><s:property value="name"/></td>
				<td><s:property value="sex"/></td>
				<td><s:property value="college"/></td>
				<td><s:property value="major"/></td>
				<td>
					<select id="<s:property value="studentId"/>" class="roomNum">
						
					</select>
				</td>
				<td><s:property value="tel"/></td>
	          	<td>
	          		<form action="../master/updateStudent" style="width:50px;">    <!-- action尚未添加 -->
			          	<input type="text" name="studentId" style="display:none" value="<s:property value="studentId"/>">
			          	<input type="text" name="bedroomId" style="display:none" studentId="<s:property value="studentId"/>" value="">
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
          <td></td>
          <td></td>
          <td class="hide">
          	<form action="../master/updateStudent" id="form-stuAll">   <!-- action尚未添加 -->
          		<div style="display:none" id="stuAll">
          			
          		</div>
          		<input type="button"  value="保存" class="Ssave" id="stuSubmit">
          	</form>
          </td>
        </tr>
      </table>
      <a href="javascript:void(0);" class="opMul">操作多项</a>
	<s:include value="../common/page.jsp">
		<s:param name="url" value="'../master/'"/>      <!-- value尚未添加 -->
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