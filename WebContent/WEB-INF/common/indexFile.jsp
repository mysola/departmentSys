<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <ul>
        <a href="javascript:void(0);" class="title url-download">相关下载</a>
        <s:iterator value="#request.files">
			<li>
				<a href="../common/getNoticeText?noticeId=<s:property value="noticeId"/>"><s:property value="title"/> </a>
			</li>
		</s:iterator>
<!--         <li><a>下载1</a></li>
        <li><a>下载2</a></li>
        <li><a>下载3</a></li>
        <li><a>下载4</a></li>
        <li><a>下载5</a></li>      -->
      </ul>
</body>
</html>