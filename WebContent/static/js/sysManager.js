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
	$("#form-time").val(Time);
	$("#file-time").val(Time);

	
	
	
	
/*	var building;
	$.ajax({
		type:"POST",
		url:"../common/getBuildings",
		data:{
			campusId:$(this).attr('campus')
		},
		success:function(data){		
			building=data.building;
			for(var i=0;i<building.length;i++){
				var $new_option=$("<option></option>");
				$new_option.val(building[i].buildingId);
				$new_option.text(building[i].buildingName);					
				$(".buildingNum").append($new_option);
			}
			$(".buildingNum").each(function(){
				var selectId=$(this).attr('id');
				selectId="[name='"+selectId+"']";
				$(this).children().each(function(){
					if($(selectId).val()==$(this).val()){
						$(this).attr("selected",true);
					}
				});
			});
		}
	});*/
	
	
	
	$("#sys-hrMaster").click(function(){
		location.href="../manager/hrMaster";
	});
	$("#sys-hrMainst").click(function(){
		location.href="../manager/hrMainst";
	});
	$("#sys-building").click(function(){
		location.href="../manager/building";
	});
	$("#sys-upload").click(function(){
		location.href="../manager/upload?pageNum=1&sumPerPage=10";
	});
	$("#sys-notice").click(function(){
		location.href="../manager/notice?pageNum=1&sumPerPage=10";
	});
	
	
	
	$("#delSubmit").click(function(){
		if(confirm("确认删除？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='noticeId' style='display:none;'/>");					
					$tmpInput.val($(this).val());					
					$("#del").append($tmpInput);
				}
			});			
			$("#form-del").submit();
		}
	});
	$("#upNotice").click(function(){
		$("#submitNotice").css("display","block");
		$("#delList").css("display","none");
		$(".notice-height").css("height","700px");
	});

	
		
	$("#fileSubmit").click(function(){
		if(confirm("确认删除？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='noticeId' style='display:none;'/>");					
					$tmpInput.val($(this).val());					
					$("#file").append($tmpInput);
				}
			});			
			$("#form-file").submit();
		}
	});
	$("#upFile").click(function(){
		$("#submitFile").css("display","block");
		$("#del-file").css("display","none");
		
	});
	
	
	

	$("#form-notice").click(function(){
		$.ajax({
			type:"POST",
			url:"../manager/addNotice",
			data:{
				title:$("#form-title").val(),
				time:$("#form-time").val(),
				text:$("#noticeContent").val()			
			},
			success:function(data){
				if(data.msg){
					alert("上传成功！");
					$("#sys-notice").click();
				}else{
					alert("上传失败！");
				}
			}
		});
	});
/*	$("#file-button").click(function(){
		$.ajaxFileUpload({
			type:"POST",
			url:"../manager/addFile",
			data:{
				title:$("#file-name").val(),
				time:$("#file-time").val(),
				
			},
			secureuri: false,
            fileElementId: 'file-uri',
            dataType: 'JSON',
            success:function(data){
				if(data.msg=="true"){
					alert("上传成功！");
					$("#sys-notice").click();
				}else{
					alert("上传失败！");
				}
            }
		});
	});*/
	
	
});