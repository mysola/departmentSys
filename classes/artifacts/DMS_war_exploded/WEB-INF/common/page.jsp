<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<s:bean name="util.Page" var="p">
		<s:param name="pageNum1" value="pageNum" />
		<s:param name="pageSum1" value="pageSum" />
	</s:bean>

	<div class="tab_footer">
		<div class="message">
			第
			<s:if test="pageSum!=0">
				<s:property value="pageNum" />
			</s:if>
			<s:else>
				0
			</s:else>
			页,共
			<s:property value="pageSum" />
			页,共
			<s:property value="resultSum" />
			条
		</div>
		<s:if test="pageSum!=0">
			<div class="btn">
				<span><a
					href="<s:property value="url" />?pageNum=1&sumPerPage=<s:property value="sumPerPage"/>">首页</a>
				</span>
				<s:if test="pageNum>1">
					<span><a
						href="<s:property value="url" />?pageNum=<s:property value="pageNum-1"/>&sumPerPage=<s:property value="sumPerPage"/>">上一页</a>
					</span>
				</s:if>
				<!-- 页码限制为10页算法 -->
				<s:iterator begin="#p.begin" end="#p.end" var="i">
					<s:if test="pageNum==#i">
						<span><a><s:property value="#i" /></a> </span>
					</s:if>
					<s:else>
						<span><a
							href="<s:property value="url" />?pageNum=<s:property value="#i"/>&sumPerPage=<s:property value="sumPerPage"/>"><s:property
									value="#i" /></a> </span>
					</s:else>
				</s:iterator>
				<s:if test="pageNum<pageSum">
					<span><a
						href="<s:property value="url" />?pageNum=<s:property value="pageNum+1"/>&sumPerPage=<s:property value="sumPerPage"/>">下一页</a>
					</span>
				</s:if>
				<span><a
					href="<s:property value="url" />?pageNum=<s:property value="pageSum"/>&sumPerPage=<s:property value="sumPerPage"/>">尾页</a>
				</span>
			</div>
		</s:if>
	</div>
</body>
</html>