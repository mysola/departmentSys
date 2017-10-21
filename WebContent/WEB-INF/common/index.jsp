<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>武汉理工大学学生寝室管理系统</title>
  <link rel="stylesheet" type="text/css" href="../static/css/normalize.css">
  <link rel="stylesheet" type="text/css" href="../static/css/global.css">
  <link rel="stylesheet" type="text/css" href="../static/css/index.css">   
  <script src="../static/js/jquery-1.11.2.min.js"></script>
  <script src="../static/js/global.js"></script>
  <script src="../static/js/index.js"></script>  
</head>
<body>
  <header>
    <img src="../static/img/logo.png8" title="logo" class="url-img" />
    <div>
    	<s:if test="#session.student!=null">
    		<s:property value="#session.student.name"/>&nbsp;&nbsp;
    		<s:property value="#session.student.college+#session.student.major+#session.student._class"/>
    		<form action="../common/logoff" id="form-loginOut" style="display:inline-block">
    			<a href="javascript:void(0);"  id="login-out">退出登录</a>
    		</form>
    	</s:if>
    	<s:else>
    		<a href="javascript:void(0);"  id="login">用户登录</a>
    	</s:else>
    </div>
  <!--  <div id="login"><a href="javascript:void(0);">用户登录</a></div>  --> 
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
  <!-- 主页 -->
  <main class="index">
    <div id="message">
    	<s:action name="getNoticeIndex" namespace="/common" executeResult="true"></s:action>
    </div>
    <div id="download">
		<s:action name="getFileIndex" namespace="/common" executeResult="true"></s:action>
    </div>
    <div id="contactInfo">
      <ul>
        <a class="title">联系我们</a>
        <li>学生工作部宿舍管理科</li>
        <li>地点：<br>学生工作部宿舍管理科</li>
        <li>电话：<br>021-12345678</li>
        <li>邮箱：<br>12345678@whut.edu.com</li>
      </ul>
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
  <div class="login">
  	<form >
    <div class="login-title">登&nbsp;&nbsp;录<span><a href="javascript:void(0);" class="close-login">关闭</a></span></div>
    <div class="login-input-content">
        <div class="login-input">
            <label>用&nbsp;户&nbsp;&nbsp;名：</label>
            <input type="text" placeholder="请输入用户名"   id="username" class="list-input"/>
        </div>
        <div class="login-input">
            <label>登录密码：</label>
            <input type="password" placeholder="请输入登录密码"  id="password" class="list-input"/>
        </div>
        <div class="login-input-radio">
            <input type="radio" name="usertype" class="input-radio" value="student"/>学生
            <input type="radio" name="usertype" class="input-radio" value="master"/>宿管
            <input type="radio" name="usertype" class="input-radio" value="mainst"/>维修人员
            <input type="radio" name="usertype" class="input-radio" value="manager"/>系统管理员
        </div>
    </div>
    <input id="submit" type="button" name="" class="button button-rounded button-tiny" value="登录">
    </form>
  </div>
  
  <div class="login-bg"></div>
  <div class="tip-box">
  	<!-- <div class="tb-close">×</div> -->
  	<div class="tb-content tb-success">登录成功！</div>
  	<div class="tb-content tb-fail">登录失败！</div>
  	<div class="tb-content tb-out">退出登录成功！</div>
  </div>
</body>
</html>
