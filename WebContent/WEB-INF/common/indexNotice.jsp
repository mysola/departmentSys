<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<ul>
		<a href="javascript:void(0);" class="title url-notice">通知公告</a>
		<s:iterator value="#request.notices">
			<li>
				<a href="../common/getNoticeText?noticeId=<s:property value="noticeId"/>"><s:property value="title"/> </a>
			</li>
		</s:iterator>
		
	</ul>
</body>
</html>