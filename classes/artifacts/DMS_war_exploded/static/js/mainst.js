$(document).ready(function(){
	var Time=(function () {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    });
	$(".repairtime").val(Time);
	$("#mainst-myInfo").click(function(){
		location.href="../mainst/myInfo";
	});	
	$("#mainst-unRecevied").click(function(){
		location.href="../mainst/getMainstRepair?pageNum=1&sumPerPage=10&flag=unReceived";
	});
	$("#mainst-recevied").click(function(){
		location.href="../mainst/getMainstRepair?pageNum=1&sumPerPage=10&flag=received";
	});
	$("#mainst-history").click(function(){
		location.href="../mainst/getMainstRepair?pageNum=1&sumPerPage=10&flag=history";
	});
	/*确认维修（多项）*/
	$("#SRepaired").click(function(){
		if(confirm("确认已维修？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='repairId' style='display:none;'/>");					
					$tmpInput.val($(this).val());					
					$("#mainstSubmitAll").append($tmpInput);
				}
			});			
			var $tmpInput=$("<input type='text' name='finishTime' style='display:none'/>");
			$tmpInput.val(Time);			
			$("#mainstSubmitAll").append($tmpInput);			
			$("#form-mainstAll").submit();
		}		
	});
	/*确认接收（多项）*/
	$("#SReceive").click(function(){
		if(confirm("确认已维修？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='repairId' style='display:none;'/>");					
					$tmpInput.val($(this).val());					
					$("#mainstReceiveAll").append($tmpInput);
				}
			});			
			var $tmpInput=$("<input type='text' name='finishTime' style='display:none'/>");
			$tmpInput.val(Time);			
			$("#mainstReceiveAll").append($tmpInput);			
			$("#form-receiveAll").submit();
		}
	});
	
	$("#mainst-cgPassword").click(function(){
		$.ajax({
			type:"POST",
			url:"../mainst/updateMainst",
			data:{
				flag:1,
				oldPass:$("#mainst-oldPass").val(),
				newPass:$("#mainst-newPass").val()
			},
			success:function(data){
				if(data.msg=="false"){
					alert("原始密码输入错误！");
				}else{
					alert("修改密码成功！");
				}
				$("#down_content").css("display","none");
			}
		});
	});
	$("#mainst-rpNewPass").blur(function(){
		var newPass=$("#mainst-newPass").val();
		var rpNewPass=$("#mainst-rpNewPass").val();
		
		if(newPass!=rpNewPass){
			alert("两次输入密码不一致！");
			$("#mainst-newPass").css("background","#ff4d4d");
			$("#mainst-rpNewPass").css("background","#ff4d4d");
		}else{
			$("#mainst-newPass").css("background","white");
			$("#mainst-rpNewPass").css("background","white");
		}
	});
	$("#mainst-infoSave").click(function(){
		$.ajax({
			type:"post",
			url:"../mainst/updateMainst",
			data:{
				flag:0,
				tel:$("#mainst-tel").val()
			},
			success:function(data){
				alert("修改成功！");
			}
		});
	});
	
});