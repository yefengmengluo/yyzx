	/*在页面添加css、js*/
	function loadjscssfile(filename,filetype){
		if(filetype == "js"){
			var fileref = document.createElement('script');
			fileref.setAttribute("type","text/javascript");
			fileref.setAttribute("src",filename);
		}else if(filetype == "css"){
			var fileref = document.createElement('link');
			fileref.setAttribute("rel","stylesheet");
			fileref.setAttribute("type","text/css");
			fileref.setAttribute("href",filename);
		}
	   if(typeof fileref != "undefined"){
			document.getElementsByTagName("head")[0].appendChild(fileref);
		}
	}

	/*获取script后的多个参数*/
	var old_src="";
	var getScriptArgs=function(){
		var scripts=document.getElementsByTagName("script"),
		script=scripts[scripts.length-1],//因为当前dom加载时后面的script标签还未加载，所以最后一个就是当前的script
		src=script.src+"&cur_src=" + "http://"+script.src.split("/")[2]+"/",
		reg=/(?:\?|&)(.*?)=(.*?)(?=&|$)/g,
		temp,res={};
		while((temp=reg.exec(src))!=null) res[temp[1]]=decodeURIComponent(temp[2]);
		return res;
	};
	
	var args=getScriptArgs();
	/*当第一次加载广告时，加载广告css，之后不再加载*/
	if ($('link[href$="'+args.cur_src+'backstage/css/league/ad_league.css"]').length == 0) {
		loadjscssfile(args.cur_src+"backstage/css/league/ad_league.css","css");
	}
	
	var ad_class=args.advCode.split("_")[2];
	var scripts=document.getElementsByTagName("script");
	var scriptParentDiv=$(scripts[scripts.length-1]).parent();
		scriptParentDiv.addClass(args.advCode);

	jQuery.support.cors = true;//解决ie7，8，9，10 跨越问题 jquery.support.cors只是对CORS协议的一种实现，具体可以看jQuery的源代码
	$.ajax({
		
		type : "get",
		async: false,
		url : args.cur_src+"queryLeagueAdvList?time="+new Date().getTime(),
		dataType : "jsonp",
		crossDomain: true, 
		data:"jsonCallback=?", 
		jsonCallback:"callback",
		data :{
			"pageWidth": args.pageWidth,
			"advType": args.advType,
			"advCode": args.advCode,
			"dataNum": args.dataNum,
			"industryId":args.advCode.split("_")[0],
			"scriptParentDiv":args.advCode,//script所在div class名称
			"adClass":ad_class, //将对应的尺寸作为类名称，创建到对应的ul上
			"advType":args.advType
		},
		success : function(data) {
	
			var ad_html,ad_text;
				if(data.dataList!=null && data.advType == 0){
						ad_html = "<ul class='ad_"+data.adClass+"'>";
						var listLen = data.dataList.length > args.dataNum ? args.dataNum :  data.dataList.length;
						
						for(var i=0;i<listLen;i++){
							ad_html += '<li><a target="_blank" onclick="doTrafficRecord('+data.dataList[i].adID+',0)" href="'+data.dataList[i].targetUrl+'"><img src="'+data.dataList[i].picUrl+'" /></a></li>';
						}

										
				}else if(data.wordList!=null && data.advType == 1){
					ad_html = '<ul class="ad_ind_text">';
					var wordListLen = data.wordList.length > args.dataNum ? args.dataNum :  data.wordList.length;
					for(var i=0;i<wordListLen;i++){
						if(data.wordList[i].redFlag == 1){
							ad_html += '<li class="red"><a target="_blank" onclick="doTrafficRecord('+data.wordList[i].id+',1)"  href="'+data.wordList[i].targetUrl+'" title="'+data.wordList[i].title+'">'+data.wordList[i].title+'</a></li>';
							alert(ad_html);
						}else{
							ad_html += '<li><a target="_blank" onclick="doTrafficRecord('+data.wordList[i].id+',1)"  href="'+data.wordList[i].targetUrl+'" title="'+data.wordList[i].title+'">'+data.wordList[i].title+'</a></li>';
						}
						
					}

				}

				ad_html += '</ul>';
				
				var ad_len=data.adClass.length;
				if( data.adClass.substring(ad_len-2,ad_len)== "40"){
					$("."+data.scriptParentDiv).prepend(ad_html);
				}else{
					$("."+data.scriptParentDiv).append(ad_html);
				}
			
		}
	});
	
//
	function doTrafficRecord(adID,adType){
		
		var site_id=$("#siteID").val();
		var memberTag=$.cookie('MEMBERTGC');
		var plw_member='';
		if(memberTag!=null&&memberTag!=''){
			plw_member=$.cookie(memberTag);
		}   

		var url=args.cur_src+"doTrafficRecord?siteId="+site_id+"&adId="+adID+"&plwMember="+plw_member+"&adType="+adType;	
		$.ajax({
			 url:url,
			 dataType:'jsonp',
			 processData: false, 
			 type:'get',
			 jsonpCallback:"result",
			 success:function(data){
			 },
			 error:function(XMLHttpRequest, textStatus, errorThrown) {
			}});
	}
	
$(function () {

	/**************************************************** 前台 ***************************************************/

	/*判断标签内容是否为空*/
	function IsEmpty(obj){
		$(obj).each(function(){
			var ad_con=$.trim($(this).html());
			var ad_con_in=$.trim($(this).children().first().html());
			if(  ad_con == "" || ad_con_in == "" ){
				$(this).parent().hide();
			}else{
				$(this).parent().show();
			}
		
		})
		
	}
		IsEmpty(".ad_flex_con");
		IsEmpty(".fullAd-1000X90-con");
		IsEmpty(".artListAd-300X80-con");
		IsEmpty(".artDetailAd-300X250-con");
		IsEmpty(".listComAd-188X218-con");
		
					
		/*顶部通栏广告*/
		var tt;
		function enlargeAd(obj){
			$(obj).each(function(){
				var _this=$(this);
				_this.css("height","180px");
				_this.find(".ad_1000x180").animate({"height":"180px"},1000);
			});
			
		}
		function narrowAd(obj){
			$(obj).each(function(){
				var _this=$(obj);
				$(".ad_flex_close").hide(1000);
				_this.animate({"height":"40px"},1000);
				_this.find(".ad_1000x40").animate({"height":"40px"},1000);
			});
		}
		
		$(".ad_flex_close").click(function(){
			clearTimeout(tt);
			narrowAd(".ad_flex_con");
		
		});
		
		function closeTopAd(){
			narrowAd(".ad_flex_con");
		}
		
		 enlargeAd(".ad_flex_con");
		 tt = setTimeout(closeTopAd,5000);

	});