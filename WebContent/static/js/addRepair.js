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
	$("#form-Time").val(Time);
	
	$("#form-submit").click(function(){
		var result=confirm("确认提交报修？");
		if(result){
//			$.ajax({
//				type:"PSOT",
//				url:"../student/stuAddRepair",
//				data:{
//					typeId:$("#form-Type option:selected").val(),
//					note:$("#form-Note").val(),
//					repairTime:$("#form-Time").val()
//				},
//				success:function(){
//					location.href="../common/getFileList?pageNum=1&sumPerPage=10";
//				}
//			});
			$.post("../student/stuAddRepair",
					{
						typeId:$("#form-Type option:selected").val(),
						note:$("#form-Note").val(),
						repairTime:$("#form-Time").val()
					},
					function(data,textStatus){
						location.href="../student/getStuRepairList?pageNum=1&sumPerPage=10";
				});
		}
	});

});