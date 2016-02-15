// JavaScript Document
$(function(){
	/*vote hover css*/
	$(".t1000-voteList-li").hover(function(){
		$(this).addClass("on").siblings().removeClass("on");
	},function(){
		$(this).removeClass("on");
	})
	$(".t1000-voteList-li").click(function(){
		$(this).addClass("on").siblings().removeClass("on");
	})
	
})

/*滑动门*/
function comTab1(tabTit,tabName){
	$(tabTit).hover(function(){
		$(this).addClass(tabName).siblings().removeClass(tabName);
		var index=$(this).index();
		$(this).parent().parent().siblings().children().eq(index).show().siblings().hide();
	})		
}
function comTab2(tabTit,tabName){
	$(tabTit).hover(function(){
		$(this).addClass(tabName).siblings().removeClass(tabName);
		var index=$(this).index();
		$(this).parent().siblings().children().eq(index).show().siblings().hide();
	})		
}
/**/
$(function(){
	comTab1(".advertising-common-tab-2-tit ul li","on");//公告切换

})