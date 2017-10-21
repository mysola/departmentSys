$(document).ready(function(){
	$.ajax({
		type:"POST",
		url:"../common/getCampus",
		success:function(data){
			var campus=data.campus;
			for(var i=0;i<campus.length;i++){
				var $new_option=$("<option></option>");
				$new_option.val(campus[i].campusId);
				$new_option.text(campus[i].campusName);
				$("#fSelectCampus").append($new_option);
			}
			$("#fSelectCampus").change();
		}
	});


	$("#fSelectCampus").change(function(){
		$.ajax({
			type:"POST",
			url:"../common/getBuildings",
			data:{
				campusId:$("#fSelectCampus option:selected").val()
			},
			success:function(data){				
				var building=data.buildings;
				$("#fSelectBuild").empty();
				for(var i=0;i<building.length;i++){
					var $new_option=$("<option></option>");
					$new_option.val(building[i].buildingId);
					$new_option.text(building[i].buildingName);					
					$("#fSelectBuild").append($new_option);
				}
				$("#fSelectBuild").change();
			}
		});
	});
	var bedroom;
	$("#fSelectBuild").change(function(){
		$.ajax({
			type:"POST",
			url:"../common/getBedrooms",
			data:{
				buildingId:$("#fSelectBuild option:selected").val()
			},
			success:function(data){
				bedroom=data.bedrooms;
				$("#fSelectRoom").empty();
				for(var i=0;i<bedroom.length;i++){
					var $new_option=$("<option></option>");
					$new_option.val(bedroom[i].bedroomId);
					$new_option.text(bedroom[i].num);					
					$("#fSelectRoom").append($new_option);
				}
				$("#fSelectRoom").change();
			}
		});
	});
	
	$("#fSelectRoom").change(function(){
		var roomId=$("#fSelectRoom option:selected").val();
		var room;
		for(var i=0;i<bedroom.length;i++){
			if(bedroom[i].bedroomId==roomId){
				$("#meterStatus").text(bedroom[i].meter.status);
				$("#meterMonth").text(bedroom[i].meter.costMonth);
				$("#meterSum").text(bedroom[i].meter.coastAll);
			}
		}
	});
});