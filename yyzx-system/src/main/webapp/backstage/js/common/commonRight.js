$(function(){
	/* 全选 */
	$("#checkedAll").click(function() {
		$("input[name='companyList[]']").prop("checked", this.checked);
	});
});