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
<%-- 	<script src="ajaxfileupload.js"></script> --%>
	<script src="../static/js/global.js"></script>
	<script src="../static/js/sysManager.js"></script>
</head>
<body>
	<header> <img src="../static/img/logo.png8" title="logo" />
	<div>
		<s:if test="#session.manager!=null">
			系统管理员：<s:property value="#session.manager.name" />&nbsp;&nbsp;
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
	<div class="main" id="del-file">
      <table width="100%">
        <tr>
          <th width="110px">文件名</th>
          <th width="100px">上传时间</th>
          <th width="60px">上传者</th>
          <th width="15px"></th>
        </tr>
		<s:iterator value="#request.files">
		<tr>
			<td><s:property value="title"/></td>
            <td><s:date name="time" format="yyyy-MM-dd" var="date"/><s:property value="date"/></td>
            <td><s:property value="publisher.name"/></td>
            <td>
            	<form action="../manager/deleteFile">
            		<input type="text" name="fileId" style="display:none;" value="<s:property value="fileId"/>">
             		<input type="submit" value="删除" class="button button-rounded button-tiny" style="margin:0;top:0;width:100px;">
            	</form>
            </td>
        </tr>
		</s:iterator>

      </table>
	<s:include value="../common/page.jsp">
		<s:param name="url" value="'../manager/deleteFile'"/>      <!-- value尚未添加 -->
	</s:include>
	<a href="javascript:void(0);" id="upFile">上传新文件</a>
    </div>
    
    
    <div class="main" id="submitFile">
      <s:form action="addFile" enctype="multipart/form-data">
        <table class="upload">
          <tr>
            <td class="left">文件名:</td>
            <td class="right"><input name="title" type="text" id="file-name"></td>
          </tr>
<!--           <tr>
            <td class="left">文件路径:</td>
            <td class="right"><input type="file" id="file-uri"></td>
          </tr> -->
          <s:file name="file" />
          <tr>
            <td class="left">上传时间:</td>
            <td class="right"><input type="text" name="time" id="file-time" disabled="true"></td>
          </tr>
          <tr>
            <td colspan="2">
            	<input type="submit" id="file-button" value="上传">
            </td>
          </tr>
        </table>
      </s:form>
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