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
	href="../static/css/mainstIndex.css">
<script src="../static/js/jquery-1.11.2.min.js"></script>
<script src="../static/js/global.js"></script>
<script src="../static/js/mainst.js"></script>
</head>
<body>
	<header> <img src="../static/img/logo.png8" title="logo"
		class="url-img" />
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
	<main> 
		<aside>
		<ul>
			<li><a href="javascript:void(0);" id="mainst-myInfo">个人中心</a></li>
			<li><a href="javascript:void(0);" id="mainst-unRecevied">未接维修</a></li>
			<li><a href="javascript:void(0);" id="mainst-recevied">已接维修</a></li>
			<li><a href="javascript:void(0);" id="mainst-history">维修历史</a></li>
		</ul>
		</aside>
    <div class="main">
      <table class="myInfo">
        <tr>
          <th width="40px">工号</th>
          <th width="40px">姓名</th>
          <th width="30px">性别</th>
          <th width="40px">生日</th>
          <th width="60px">电话</th>
          <th width="70px">负责区域</th>
          <th width="40px"></th>
        </tr>
        <tr>
          <td><s:property value="#session.mainst.idCard"/></td>
          <td><s:property value="#session.mainst.name"/></td>
          <td><s:property value="#session.mainst.sex"/></td>
          <td><s:date name="#session.mainst.birth" format="yyyy-MM-dd" var="date"/><s:property value="date"/></td>
          <td>
          	<input type="text" id="mainst-tel" value="<s:property value='#session.mainst.tel'/>" style="text-align:center;margin:0;float:none;width:100px;"/>
          </td>
   		  <td>
	          <s:iterator value="#session.mainst.buildings" >
	          	<s:property value="buildingName"/>
	          </s:iterator>
          </td> 
          <td>
          <input type="text" style="display:none;" id="mainstId" value="<s:property value="#session.mainst.mainstenanceId"/>">
          <input type="button" value="保存" id="mainst-infoSave" class="button button-rounded button-tiny" style="margin:0;top:0;">
          </td>
        </tr>
      </table>
      <div class="down">
        <a href="javascript:void(0);" class="cgPword">修改密码?</a>
        <div id="down_content">
          <form class="resetPword">
            <table>
              <tr>
                <td>旧&nbsp;密&nbsp;码&nbsp;:</td>
                <td><input type="password" id="mainst-oldPass"></td>
              </tr>
              <tr>
                <td>新&nbsp;密&nbsp;码&nbsp;:</td>
                <td><input type="password" id="mainst-newPass"></td>
              </tr>
              <tr>
                <td>确认密码:</td>
                <td><input type="password" id="mainst-rpNewPass"></td>
              </tr>
              <tr>
                <td colspan="2"><input type="button" id="mainst-cgPassword" value="提交"></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
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