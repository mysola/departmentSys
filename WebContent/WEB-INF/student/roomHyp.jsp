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
<link rel="stylesheet" type="text/css" href="../static/css/meter.css">
<script src="../static/js/jquery-1.11.2.min.js"></script>
<script src="../static/js/global.js"></script>
<script src="../static/js/meter.js"></script>
</head>
<body>
	<header> <img src="../static/img/logo.png8" title="logo"
		class="url-img" />
	<div>
		<s:if test="#session.student!=null">
			<s:property value="#session.student.name" />&nbsp;&nbsp;
	  		<s:property
				value="#session.student.college+#session.student.major+#session.student._class" />
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
	<nav>
	<ul>
		<li><a href="javascript:void(0);" class="url-index">首页</a></li>
		<li><a href="javascript:void(0);" class="url-notice">通知公告</a></li>
		<li><a href="javascript:void(0);" class="url-download">相关下载</a></li>
		<li class="down1"><a href="javascript:void(0);"
			class="url-rpHistory">网上报修</a>
			<div class="down_content1">
				<a href="javascript:void(0);" class="url-rpHistory">报修记录</a> <a
					href="javascript:void(0);" class="url-addRepair">我要报修</a>
			</div></li>
		<li><a href="javascript:void(0);" class="url-meter">电费查询</a></li>
		<li><a href="javascript:void(0);" class="url-roomHyg">卫生状况查询</a></li>
	</ul>
	</nav>
	<main class="eleQuary">
	<div class="hygInfo">
		<table>
			<tr>
				<td class="left">校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</td>
				<td class="right">
					<s:property value="#session.student.bedroom.building.campus.campusName"/>
				</td>
			</tr>
			<tr>
				<td class="left">楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
				<td class="right">
					<s:property value="#session.student.bedroom.building.buildingName"/>
				</td>
			</tr>
			<tr>
				<td class="left">寝&nbsp;室&nbsp;号</td>
				<td class="right">
					<s:property value="#session.student.bedroom.num"/>
				</td>
			</tr>
			<tr>
				<td class="left">寝室卫生评分</td>
				<td class="right">
					<s:property value="#session.student.bedroom.score"/>
				</td>
			</tr>
			<tr>
				<td class="left">寝室星级</td>
				<td class="right">
					<s:property value="#session.student.bedroom.star"/>
				</td>
			</tr>
			<tr class="link">
				<td colspan="2" class="down"><a href="javascript:void(0);">点此查看学院寝室卫生条例和规范</a>
					<div class="tips">
						<p>
							1 . 床铺要求: 床上用品保持干净整齐，被子折叠整齐,床单无褶皱，被子摆放方式及位置要求全寝室统一，床上不摆放其他衣物等。<br>2
							. 书桌要求：桌面干净无污渍，书籍摆放整齐划一，其他用品布局合理，不摆放其他杂物。<br>3 .
							地面要求：保持地面清洁，无果皮纸屑等垃圾，地板干净明亮，无水迹痰迹等。<br>4 .
							鞋物要求：摆放位置恰当，摆放统一、整洁。<br>5 .
							空气要求：保持室内空气流通，防止异味的产生，杜绝蝇、蚊等虫子，注意个人卫生。<br>6 .
							墙壁要求：墙壁无乱贴乱画，保持墙壁洁白，墙壁装饰物要有整体美感，提倡个人或寝室特色。<br>7 .
							电器要求：严禁昼夜灯长明，学校熄灯后开关必须自行关闭。电路，电器出现异常或损坏应及时采取措施，并说明责任。做到人离电灭，不乱来乱扯电线。<br>8
							. 玻璃要求：玻璃洁净明亮，粘贴的装饰物具有美感且不影响室内光线，窗弦上无灰尘，窗帘整洁。<br>9 .
							窗台要求：不摆放鞋类、饮料瓶等杂物，保持窗台清洁无泥土，花草、花盆摆放位置合适，具有美感，无水迹、痰迹等。<br>10
							. 内务要求：毛巾、口杯、水桶等生活用品摆放整齐合理。<br>11 .
							整体效果要求：不使用蜡烛等明火，保证寝室安全，垃圾箱摆放位置恰当，保持垃圾箱的清洁，寝室有自己的特色布置，美观大方。<br>12
							.
							寝室氛围要求：寝室成员团结友好，寝室间和睦相处，寝室成员共同营造出一个温馨、和谐的休息学习环境，有本寝室独特的寝室文化，对待来客大方有礼，热情接待。<br>
						</p>
					</div></td>
			</tr>
		</table>
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