$(document).ready(function(){
//	if($(".login-out")){
//		$(".tip-box").css("display","block");
//	}
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    //方法二：
    var login = $.getUrlParam('login');
//打开登录框
	$("#login").click(function(){
		$(".list-input").val("");
		$(".input-radio").prop("checked",false);
		switch(login){
			case "1":{
				$(".input-radio[value='student']").prop("checked",true);
			}		
			break;
			case "2":{
				$(".input-radio[value='master']").prop("checked",true);
			}		
			break;
			case "3":{
				$(".input-radio[value='mainst']").prop("checked",true);
			}		
			break;
			case "4":{
				$(".input-radio[value='manager']").prop("checked",true);
			}		
			break;	
			default:{
				$(".input-radio[value='student']").prop("checked",true);
			}
		}	
		$(".login").css("display","block");
		$(".login-bg").css("display","block");
		
	});

    if(login!=null){
    	alert("请先登录！");
    	$("#login").click();
    }
//关闭登录框
	$(".close-login").click(function(){
		$(".login").css("display","none");
		$(".login-bg").css("display","none");
	});
//		退出登录
	$("#login-out").click(function(){
		var result=confirm("确认退出登录？");
		if(result){
			  $(".tip-box").css("display","block");
			  $(".tb-out").css("display","block");
			  setTimeout(function(){
				  $("#form-loginOut").submit();
			  },1000);

		}
		
	});
//		登录操作ajax
	$("#submit").click(function(){
		var userType=$("input[name='usertype']:checked").val();
		$.post("../common/proLogin",//请求页面URL
			  {//表单数据
				username : $("#username").val(),
				password : $("#password").val(),
				userType: userType
			  },
			  function(data,textStatus){//回调函数
				  if(data.msg){
					  $(".tip-box").css("display","block");
					  $(".tb-success").css("display","block");					  
					  setTimeout(function(){
						  if(userType=="student"){
							  location.href="../common/index";
						  }else if(userType=="manager"){
							  location.href="../manager/sysManagerIndex";
						  }else if(userType=="master"){
							  location.href="../master/masterIndex";
						  }else if(userType=="mainst"){
							  location.href="../mainst/mainstIndex";
						  }else{//跳转error
							  
						  }
					  },1000);
					  
					  
				  }else{
					  $(".tip-box").css("display","block");
					  $(".tb-fail").css("display","block");
					  setTimeout(function(){
						  $(".tip-box").css("display","none");
						  $(".tb-fail").css("display","none");
					  },1000);
				  }
				  
			  });
	});	
	$(".tb-close").click(function(){
		$(".tip-box").css("display","none");
	});
//	监听回车键
	$("#password").keydown(function(event){
		 if (event.keyCode == 13) {      
			 $("#submit").click();
         }  
	});
	$("#username").keydown(function(event){
		 if (event.keyCode == 13) {       
			 $("#submit").click();
        }  
	});
	
//	操作多项
  $(".opMul").click(function(){
    if ($(".hide").css("display")=="none") {
      $(".hide").css("display","table-cell");
    }
    else{
      $(".hide").css("display","none");
    }
  });
//  修改密码
  $(".cgPword").click(function(){
    $("#down_content").css("display","block");
  });
//  全选
  $(".all").click(function(){
    if (this.checked) {
      $(".hide input[type=checkbox]").prop("checked",true);
    }
    else{
      $(".hide input[type=checkbox]").prop("checked",false);
    }
  });
//  跳转至首页
  	$(".url-index").click(function(){
  		location.href="../common/index";
  	});  	
//	跳转至通知公告
	$(".url-notice").click(function(){
		location.href="../common/getNoticeList?pageNum=1&sumPerPage=10";
	});
//	跳转至相关下载
	$(".url-download").click(function(){
		location.href="../common/getFileList?pageNum=1&sumPerPage=10";
	});
//	跳转至维修记录
	$(".url-rpHistory").click(function(){
		location.href="../student/getStuRepairList?pageNum=1&sumPerPage=10";
	});
//	跳转至我要报修
	$(".url-addRepair").click(function(){
		location.href="../student/addRepairPage";//action未添加
	});
//	跳转至电费查询
	$(".url-meter").click(function(){
		location.href="../student/meter";//action未添加
	});	
//	跳转至卫生情况查询
	$(".url-roomHyg").click(function(){
		location.href="../student/roomHyp";//action未添加
	});	
//	页脚链接
	$("#whut-index").click(function(){
		 window.open("http://www.whut.edu.cn/2015web/index.htm");
	});
	$("#whut-jwc").click(function(){
		window.open("http://jwc.whut.edu.cn/");
	});
	$("#whut-yjsInfo").click(function(){
		window.open("http://gd.whut.edu.cn/");
	});
  
});
