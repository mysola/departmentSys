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
	$(".updateTime").val(Time);
	$("#master-myInfo").click(function(){
		location.href="../master/myInfo";
	});	
	$("#master-stuInfo").click(function(){
		location.href="../master/stuInfoPage?pageNum=1&sumPerPage=10";
	});	
	$("#master-roomInfo").click(function(){
		location.href="../master/bedroomInfoPage?pageNum=1&sumPerPage=10";
	});	
	var bedroom;
	$.ajax({
		type:"POST",
		url:"../common/getBedrooms",
		data:{
			buildingId:$("#masterBuilding").val()
		},
		success:function(data){
			bedroom=data.bedrooms;
			for(var i=0;i<bedroom.length;i++){
				var $new_option=$("<option></option>");
				$new_option.val(bedroom[i].bedroomId);
				$new_option.text(bedroom[i].num);					
				$(".roomNum").append($new_option);
			}
			$(".roomNum").each(function(){
				var selectId=$(this).attr('id');
				selectId="[name='"+selectId+"']";
				$(this).children().each(function(){
					if($(selectId).val()==$(this).val()){
						$(this).attr("selected",true);
					}
				});
			});
		}
	});

	$(".roomNum").change(function(){
		var roomId= $(this).children("option:selected").val();
		var thisId=$(this).attr('id');
		var temp="[name='"+thisId+"']";
		$(temp).val(roomId);
		var temp2="[studentId='"+thisId+"']";
		$(temp2).val(roomId);		
	});
	$(".used").change(function(){
		var roomStatus=$(this).children("option:selected").val();
		var thisId=$(this).attr('id');
		var temp="[bedroomId='"+thisId+"']";
		$(temp).val(roomStatus);
		var temp2="[name='"+thisId+"']";
		$(temp2).val(roomStatus);	
	});
	$(".score").change(function(){
		var score=$(this).val();
		if(number(score)<0){
			alert(分数不可为负数);
		}else{
			var thisId=$(this).attr('id');
			var temp="[bId='"+thisId+"']";
			$(temp).val(score);
			var temp2="[name='"+thisId+"']";
			$(temp2).val(score);
		}
	});
	$(".score").blur(function(){
		/*this.value=this.value.replace(/[^0-9-]+/,'');*/
		if(!(/^(\d{1,2}(\.\d+)?|100|NA)$/.test(this.value))){
			this.value='';
			alert("不可输入0-100之外的字符或数字！");
			
		}
	})
	/*提交寝室分数（多项）*/
	$("#roomSubmit").click(function(){
		if(confirm("确认提交分数？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='bedroomId' style='display:none;'/>");					
					$tmpInput.val($(this).attr('name'));					
					$("#roomAll").append($tmpInput);
					$tmpInput=$("<input type='text' name='score' style='display:none;'/>");
					$tmpInput.val($(this).val());
					$("#roomAll").append($tmpInput);
					$tmpInput=$("<input type='text' name='used' style='display:none;'/>");
					$tmpInput.val($(this).attr('used'));
					$("#roomAll").append($tmpInput);
				}
			});			
			$tmpInput=$("<input type='text' name='updateTime' style='display:none;'/>");
			$tmpInput.val(Time);
			$("#roomAll").append($tmpInput);
			$("#form-roomAll").submit();
		}
	});
	
	$("#stuSubmit").click(function(){
		if(confirm("确认修改寝室？")){
			$("input[type='checkbox']:checked").each(function(){
				if($(this).attr('class')!='all'){
					var $tmpInput=$("<input type='text' name='studentId' style='display:none;'/>");					
					$tmpInput.val($(this).attr('name'));					
					$("#stuAll").append($tmpInput);
					$tmpInput=$("<input type='text' name='bedroomId' style='display:none;'/>");
					$tmpInput.val($(this).val());
					$("#stuAll").append($tmpInput);
				}
			});					
			$("#form-stuAll").submit();
		}
	});
	
	$("#master-cgPassword").click(function(){
		$.ajax({
			type:"POST",
			url:"../master/updateMaster",
			data:{
				flag:1,
				oldPass:$("#master-oldPass").val(),
				newPass:$("#master-newPass").val()
			},
			success:function(data){
				if(data.msg=="false"){
					alert("原始密码输入错误！");
				}else{
					alert("修改密码成功！");
				}
			}
		});
	});
	$("#master-rpNewPass").blur(function(){
		var newPass=$("#master-newPass").val();
		var rpNewPass=$("#master-rpNewPass").val();
		
		if(newPass!=rpNewPass){
			alert("两次输入密码不一致！");
			$("#master-newPass").css("background","#ff4d4d");
			$("#master-rpNewPass").css("background","#ff4d4d");
		}else{
			$("#master-newPass").css("background","white");
			$("#master-rpNewPass").css("background","white");
		}
	});
	$("#master-infoSave").click(function(){
		$.ajax({
			type:"post",
			url:"../master/updateMaster",
			data:{
				flag:0,
				tel:$("#master-tel").val()
			},
			success:function(data){
				alert("修改成功！");
			}
		});
	});
	$(".used").blur(function(){

		var bedroomId=$(this).attr("id");
		bedroomId="[bedroomId="+bedroomId+"]";

		$(bedroomId).val($(this).val());
        // alert($(bedroomId).val());
	});
    $(".score").blur(function(){

        var bedroomId=$(this).attr("id");
        bedroomId="[bId="+bedroomId+"]";

        $(bedroomId).val($(this).val());
        // alert($(bedroomId).val());
    });
});