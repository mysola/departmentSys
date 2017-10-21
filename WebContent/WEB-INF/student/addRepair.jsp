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
 <script src="../static/js/addRepair.js"></script>
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
   <main class="addRepairInfo">
<%--     <s:form cssClass="repairForm" action="../student/stuAddRepair">
      <table>
        <tr>
          <td class="left">报修人:</td>
          <td class="right">
            <input type="text" disabled="true" id="form-Name" value="<s:property value="#session.student.name"/>">
          </td>
        </tr>
        <tr>
          <td class="left">报修寝室:</td>
          <td class="right">
            <input type="text" disabled="true"  id="form-Room" value="<s:property value="#session.student.bedroom.building.buildingName"/>-<s:property value="#session.student.bedroom.num"/>">
          </td>
        </tr>
       	<s:select id="form-Type" name="repair.type.typeId" label="报修类别" list="#{'1':'管道类','2':'家具类','3':'电器类' }" listKey="key" listValue="value"/>
       	<s:textarea name="repair.note" label="备注" rows="3" cols="30" id="form-Note"/>
       	<s:textfield name="Repair.repairTime" label="报修时间" disabled="true"  id="form-Time"/>
       	<s:token/>
       	<s:submit value="提交" class="button button-rounded button-tiny" id="form-submit"/>
      </table>
    </s:form> --%>
    <form class="repairForm">
    	<s:token/>
    	<table>
    		<tr>
    			<td class="left">报修人:</td>
          		<td class="right">
            		<input type="text" disabled="true" id="form-Name" value="<s:property value="#session.student.name"/>">
          		</td>
    		</tr>
    		<tr>
    		    <td class="left">报修寝室:</td>
          		<td class="right">
            		<input type="text" disabled="true"  id="form-Room" value="<s:property value="#session.student.bedroom.building.buildingName"/>-<s:property value="#session.student.bedroom.num"/>">
          		</td>
    		</tr>
    		<tr>
    			<td class="left">报修类别:</td>
    			<td class="right">
	    			<select id="form-Type">
						<option value="1">管道类</option>
						<option value="2">家具类</option>
						<option value="3">电器类</option>
					</select>
				</td>
    		</tr>
    		<tr>
    			<td class="left">备注:</td>
    			<td class="right">
    				<textarea  rows="3" cols="30" id="form-Note"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td class="left">报修时间:</td>
    			<td class="right">
    				<input type="text" disabled="true"  id="form-Time"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="button" value="提交" class="button button-rounded button-tiny" id="form-submit"/></td>
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