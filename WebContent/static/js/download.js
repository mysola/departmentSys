$(document).ready(function(){
	var itemNum=10;
	function getFileList(pageNum,itemNum){
		$.post("",
				{
					page:pageNum,
					sumPerPage:itemNum
				},
				function(data,textStatus){				
				});
	}
	getFileList(1,itemNum);
	
	

});