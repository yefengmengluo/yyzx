var liuyanMap=new Array();
liuyanMap[0]="{key:'0', value:'未审核'}";
liuyanMap[1]="{key:'1',value:'已审核'}";
liuyanMap[2]="{key:'2',value:'已禁用'}";



function revertLiuyanStatus(status){
	if(status!=null&&status!=''){
			for(var i in liuyanMap){
				var liuyanstatus=strToJson(liuyanMap[i]);
				if(status==liuyanstatus.key.trim()){
					return liuyanstatus.value;
				}
			}	
	}else{
		return "未审核";
		
	}

	}	  
	
	function strToJson(str){
		var json = eval('(' + str + ')');
		return json;
	} 