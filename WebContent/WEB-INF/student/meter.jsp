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
 <link rel="stylesheet" type="text/css" href="../static/css/meter.css">   
 <script src="../static/js/jquery-1.11.2.min.js"></script>
 <script src="../static/js/global.js"></script>
 <script src="../static/js/meter.js"></script>
</head>
<body>
  <header>
    <img src="../static/img/logo.png8" title="logo" class="url-img" />
	<div>
		<s:if test="#session.student!=null">
			<s:property value="#session.student.name"/>&nbsp;&nbsp;
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
  <!-- 电费查询 -->
  <main class="eleQuary">
    <form>
      <table>
        <tr>
          <td class="left">校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</td>
          <td class="right">
            <select id="fSelectCampus">

            </select>
          </td>
        </tr>
        <tr>
          <td class="left">楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
          <td class="right">
            <select id="fSelectBuild">
				
            </select>
          </td>
        </tr>
        <tr>
          <td class="left">寝&nbsp;室&nbsp;号</td>
          <td class="right">
            <select id="fSelectRoom">

            </select>
          </td>
        </tr>
        <tr>
          <td class="left">电表状态</td>
          <td class="right" id="meterStatus">在线</td>
        </tr>
        <tr>
          <td class="left">当月用电</td>
          <td class="right" id="meterMonth">420°</td>
        </tr>
        <tr>
          <td class="left">历史用电</td>
          <td class="right" id="meterSum">2300°</td>
        </tr>
      </table>
    </form>
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
