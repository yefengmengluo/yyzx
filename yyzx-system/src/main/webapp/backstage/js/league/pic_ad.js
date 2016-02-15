/*图片广告*/
var str = "";
var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
$(function(){
	var pic_ad=$(".advertising-picture-con-bottom").prop("outerHTML");
	var i=0;
	$('.advertising-none .advertising-picture-con-bottom').remove();	
	$('.advertising-picture-con-top ul li.categ').click(function(){
		//alert(1);
		var industryId=$(this).attr("value");
		var thisCon =$(this).html();
		if($(this).hasClass('blue')){
						
			$(this).removeClass('blue');
			if($(".categ").length != $(".advertising-picture-con-top ul li.blue").length){
				$(".all").removeClass("blue1");
			}else{
				$(".all").addClass("blue1");
			}
			var s=$(this).html();
			str=str.replace(s,'');
			ids=ids.replace(industryId+",",'');
			thisCon="";
		}else{
						
			$(this).addClass('blue');
			
			if($(".categ").length != $(".advertising-picture-con-top ul li.blue").length){
				$(".all").removeClass("blue1");
			}else{
				$(".all").addClass("blue1");
			}
			ids+=industryId+',';
			str+=thisCon+' ';
			//$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').find('th label').html(str);
			
		}
		
		selectionIndustry(ajaxCallUrl,ids);
		
			
		
	})
	
	
		$('.advertising-picture-con-top ul li.all').click(function(){
			if($(this).hasClass('blue1')){
				$(this).removeClass('blue1');
				$('.advertising-picture-con-top ul li.categ').removeClass('blue');
				//$('.content').html('');
				str='';
				ids='';
				$('.advertising-picture-con-center dd a').removeClass('blue gray orange');
			}else{
				$(this).addClass('blue1');
				str= '';ids='';
				$('.advertising-picture-con-top ul li.categ').addClass('blue');
				for( var num=0;num<$('.categ').length;num++){
					str+=$('.blue').eq(num).html()+' ';
					ids+=$('.blue').eq(num).attr("value")+',';
				}
				//$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('th label').html(str);	
			}
			//alert(ids);
			selectionIndustry(ajaxCallUrl,ids);
		})
	
	$('.advertising-picture-con-center').on("click","dd a",function(){
		if($(this).hasClass('gray')){
			$(this).unbind(); 
		}else{
			if($('.advertising-picture-con-top ul li.categ').hasClass('blue')){
				var Aid=$(this).attr('id');
				var dtHtml=$(this).parent().parent().children('dt').html();
					
				if($(this).hasClass('blue')){
					$(this).removeClass('blue');
				}else{
					$(this).addClass('blue').closest('.advertising-picture-con-center').find('dl').siblings().find('a').removeClass('blue');
					$(this).addClass('blue').siblings().removeClass('blue');
					$(this).closest('.advertising-picture-con').find(".content").prepend(pic_ad);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('.file').attr("id","fileToUpload"+i);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find("input[name='startTime']").attr("id","st"+i);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find("input[name='endTime']").attr("id","st"+i);
					
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('th span').html(dtHtml);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('th label').html(str);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('i').html($(this).html());
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).attr('id','adv-'+Aid);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find("input[name='industryIds']").val(ids);
					var code=$(this).attr("id");
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find("input[name='sizeCode']").val(code);
					/*$('.fabu1').click(function(){
						$(this).closest('.advertising-picture-con-bottom').find('.focus_on').attr('disabled','disabled');
					})*/
					$('.close').click(function(){
						$(this).closest('.advertising-picture-con-bottom').remove();
					})
					

					/*$(".content").find("input[name='targetUrl']").each(function(){
					
						$(this).blur(function(){
							var thisVal=$(this).val();
							if(thisVal==""||!Expression.test(thisVal)){
								$(this).next("font").text("请输入正确的Url地址，格式如：http://...");
						   }else{
							   $(this).next("font").text("");
						   }
						
						})
						
					});*/
				}
	i++;
			}else{
				alert('请选择行业');	
			}
		}
	})
	
	   
})
/*添加id名*/
$(function(){
	var num=1;
	var aLength= $('.advertising-picture-con-center a').length;
	for(num; num<=aLength;num++){
		$('.advertising-picture-con-center a').eq(num-1).attr('id','size-'+num);
	}	
})
/*上传图片*/
	function previewImage(file)  
	{  
	  var MAXWIDTH  = 124;  
	  var MAXHEIGHT = 124; 
	 /* var div = document.getElementById('preview');*/  
	  var div=$(file).closest(".advertising-pic-modify").find(".preview")[0];
	  var hidSrc=$(file).closest(".advertising-pic-modify").find(".preview").find(".imghead");
	 // var hidSrc= document.getElementById('imghead');
	  if (file.value.length < 5) { alert('请选择文件！'); return; }
      var agent = window.navigator.userAgent;
		if (!file.value.match(/.jpg|.gif|.png|.bmp/i)) {
			alert('您上传的图片格式不正确，请重新选择！');
			if (file.outerHTML) {
				file.outerHTML = file.outerHTML;
			 } else { // FF(包括3.5)
			 $(file).val("");
			}
			$(hidSrc).attr("src","/backstage/fodder/league/add_bg.jpg");
			return false;
		}
	  if (file.files && file.files[0])  
	  {  
		 /* div.innerHTML = '<img class=imghead id=imghead>';  
		  var img=$(div).find(".imghead");  */
		  if (file.files[0].size / 1024 > 350) {  
				alert("您上传的文件大小超出了300KB！"); 
				$(file).val("");
				//$(img).attr("src","/backstage/fodder/league/add_bg.jpg");
				$(hidSrc).attr("src","/backstage/fodder/league/add_bg.jpg");
				return false;  
			} 
		  div.innerHTML = '<img class=imghead id=imghead>';  
		  var img=$(div).find(".imghead");
		  img.onload = function(){  
		  var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);  
		  img.width = MAXWIDTH;  
		  img.height = MAXHEIGHT;  
		  img.style.marginLeft = 0+'px';  
		  img.style.marginTop = 0+'px';  
		}  
		var reader = new FileReader();  

		reader.onload = function(evt){img.attr({src:evt.target.result})}
		reader.readAsDataURL(file.files[0]);  
	  }  
	  else  
	  {  	    
		var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
		file.select();
		window.top.document.body.focus();
		var src = document.selection.createRange().text;  
		div.innerHTML = '<img class=imghead id=imghead>';  
		var img = document.getElementById('imghead'); 
		
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);  
		status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);  
		div.innerHTML = "<div id=divhead style='width:"+MAXWIDTH+"px;height:"+MAXHEIGHT+"px;margin-top:"+0+"px;margin-left:"+0+"px;"+sFilter+src+"\"'></div>";
		var img = document.getElementById('divhead'); 
/*		Imgttmt = new Image();
		//Img.src = isrc;
		Imgttmt.onload = function ()
		{
		alert("complete : "+Imgttmt.complete +"\nreadyState : "+Imgttmt.readyState)
		document.body.appendChild(Imgttmt);
		}
		Imgttmt.src = src; 
		var falg=false;
		var check=function(){
			if(Imgttmt.readyState!="complete") //如果图像是未加载完成进行循环检测
			  {
			    setTimeout(check(),3000);
			    return false;
			  }
		}
		check();
		alert("hout:"+Imgttmt.readyState);*/
		
		
		/*alert("complete2 : "+Imgttmt.complete +"\nreadyState : "+Imgttmt.readyState)
		
		if(img.readyState=="complete"){//已经load完毕，直接打印文件大小
			alert("1~~~"+Imgttmt.fileSize);
			if(img.document.fileSize/1024>150){//ie获取文件大小
				alert("您上传的文件大小超出了150KB！");
				alert(11);
				file.outerHTML = file.outerHTML;
				img.src="/backstage/fodder/league/add_bg.jpg";
				return false;
			}
		}else{
			alert("2~~~");
			img.onreadystatechange=function(){
				if(img.readyState=='complete'){//当图片load完毕  complete
					alert("3~~~");
					if(img.document.fileSize/1024>150){//ie获取文件大小
						alert("您上传的文件大小超出了150KB！");
						alert(22);
						file.outerHTML = file.outerHTML;	
						img.src="/backstage/fodder/league/add_bg.jpg";
						return false;
					}							
				}
			}			
		}*/
	  }  

	  
	}  
	function clacImgZoomParam( maxWidth, maxHeight, width, height ){  
		var param = {top:0, left:0, width:width, height:height};  
		if( width>maxWidth || height>maxHeight )  
		{  
			rateWidth = width / maxWidth;  
			rateHeight = height / maxHeight;  
			  
			if( rateWidth > rateHeight )  
			{  
				param.width =  maxWidth;  
				param.height = Math.round(height / rateWidth);  
			}else  
			{  
				param.width = Math.round(width / rateHeight);  
				param.height = maxHeight;  
			}  
		}  
		  
		param.left = Math.round((maxWidth - param.width) / 2);  
		param.top = Math.round((maxHeight - param.height) / 2);  
		return param;  
	}  
	function selectionIndustry(ajaxCallUrl,ids){
		$.post(
		        ajaxCallUrl,
		        {"ids":ids},// 你的formid
		       // "jsonp",
		       function(data) {
		        	//console.log(data);
		            //$("#commonLayout_appcreshi").parent().html(data);
		        	if(!(data==null)){
		        		$(".hangye").html("");
		        		 var jsonobj = eval(data);
		        		 $(jsonobj).each(
		        				 function(){
		        	        	// console.log(this);
									//console.log(this.advType);
				        			var html0=" <dl class=''><dt>"+this.advType +"</dt><dd>";
				        			var html1="";
				        			$(this.leagueSizeList).each( function(){
					        				if(this.linkStatus==1&this.onFlag==0){
					        					html1+=" <a href='javascript:void(0);' title='' id="+this.sizeCode+" >"+this.advSize +"</a>";
					        				}else if(this.linkStatus==1&this.onFlag==2){
					        					html1+=" <a href='javascript:void(0);' title='' class='orange'  id="+this.sizeCode+">"+this.advSize +"</a>";
					        				}else if(this.linkStatus==0){
					        					html1+=" <a href='javascript:void(0);' title='' class='gray' id="+this.sizeCode+">"+this.advSize +"</a>";
					        				}
					        		});
				        			var html00="</dd></dl>";
				        			var html=html0+html1+html00;
				        			//alert(html);
				        			$(".hangye").append(html);
		        				});
		        		//alert("success");
		        	}else{
		        		alert("Connection error");
		        	}
		        }
		    );
		
		
	}
	$(function(){
		var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;

		$(".content").on("blur","input[name='targetUrl']",function(){
			
			//$(this).blur(function(){
				var thisVal=$(this).val();
				if(thisVal==""||!Expression.test(thisVal)&&!(thisVal=="#")){
					$(this).next("font").text("格式如：http://99114.com 或  # ").show();
			   }else{
				   $(this).next("font").text("").hide();
			   }
			
			//})
			
		});
		
	})

	
	function addAdvPic(obj){
		var $form = $(obj).closest("form");
		var $file = $(obj).closest("form").find(".file");
		var $advName = $(obj).closest("form").find("input[name='advName']");
		var $targetUrl = $(obj).closest("form").find("input[name='targetUrl']");
		var $startTime = $(obj).closest("form").find(".Wdate").eq(0);
		var $endTime = $(obj).closest("form").find(".Wdate").eq(1);
		var $webUrl=$(obj).closest("form").find("input[name='targetUrl']");
		
		//alert($form.formSerialize());
			            var options = {
			                //target:'#Tip', //后台将把传递过来的值赋给该元素
			            	//async: false,
			                url: ajaxUrl, //提交给哪个执行
			                type:'POST',
			                // dataType:'xml',
			                beforeSubmit:function(){//如：验证表单数据是否为空
			  			      //alert("表单提交前执行的操作！");
			                	 $(obj).attr("disabled","true");
				                 $(obj).attr("value","发布中");
			  			      if($startTime.val()==""||$endTime.val()==""||$advName.val()==""||$file.val()==""||$targetUrl.val()==""){
			  			    	  alert("请先完善广告信息！");
			  			    	 $(obj).removeAttr("disabled");
				                 $(obj).attr("value","发布");
			  			    	  return false;
			  			    	}
			  			   
			  					if($webUrl.val()==""||!Expression.test($webUrl.val())&&!($webUrl.val()=="#")){
			  						$webUrl.next("font").text("格式如：http://99114.com 或  # ").show();
			  						 $(obj).removeAttr("disabled");
					                 $(obj).attr("value","发布");
			  						  return false;
			  				   }else{
			  					  $webUrl.next("font").text("").hide();
			  					  
			  				   }
			  			
			  			      if($startTime.val()>$endTime.val()){
			  			    	  alert("结束时间不能大于开始时间！");
			  			    	 $(obj).removeAttr("disabled");
				                 $(obj).attr("value","发布");
			  			    	 return false;
			  			      }
			  			     },
			                success: function(msg){
			                	if(msg=="ok"){
			                	selectionIndustry(ajaxCallUrl,'');
			                    //alert(msg);
			                    $(obj).attr("disabled","true");
			                    $(obj).attr("value","已发布");
									$(obj).closest('.advertising-picture-con-bottom').find('.focus_on').attr('disabled','disabled');
									$(obj).closest('.advertising-picture-con-bottom').find('.file').attr('disabled','disabled');
									$(obj).css("color","#999");
									
									$(".advertising-picture-con-top ul li").each(function(){
										$(this).removeClass("blue");
									});
									ids='';
									str ='';
			                	}else{
			                		 alert("发布失败，请稍后再试！");
			                		 $(obj).removeAttr("disabled");
					                 $(obj).attr("value","发布");
			                	}
			                }, //显示操作提示
					        error:function(err){
								      alert("发布失败！");
								      $(obj).removeAttr("disabled");
						              $(obj).attr("value","发布");
							}
			                //complete: function(jqXHR, textStatus){
			                	//console.log(jqXHR);
			                	//alert(jqXHR.responseText+"textStatus:"+textStatus);
			                	/*if(jqXHR.responseText=="ok"){
				                	selectionIndustry(ajaxCallUrl,'');
				                    alert(msg);
				                    $(obj).attr("disabled","true");
										$(this).closest('.advertising-picture-con-bottom').find('.focus_on').attr('disabled','disabled');
										$(obj).css("color","#999");
										
										$(".advertising-picture-con-top ul li").each(function(){
											$(this).removeClass("blue");
											
										});
				                	}else{
				                		 alert(textStatus+":"+表单提交异常，请稍后再试！");
				                	}*/
			             //   }
			            };
			            $form.ajaxSubmit(options);
			           return false; //为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	}
	function unifyOs(){
		$("input[name='fa']").each(function(){
			alert($(this).attr("id"));
			alert($(this).attr("disabled"));
			if(!($(this).attr("disabled")=="disabled")){
				$(this).click();
				 $(this).attr("disabled","disabled");
	             $('.fabu1').click(function(){
						$(this).closest('.advertising-picture-con-bottom').find('.focus_on').attr('disabled','disabled');
					})
			}else{
				alert("已提交！");
			}
		})
}
