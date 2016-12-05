var agentID = '';
var sttime = 0;
var endtime = 0;
var threshold = 10;

// 获取url中参数的值
function getUrlParam(name) {
	var reg = new RegExp("(^|\\?|&)"+ name +"=([^&]*)(\\s|&|$)", "i");
	if (reg.test(location.href)) return unescape(RegExp.$2.replace(/\+/g, " ")); return "";
}
// 初始化赋值
function getParams() {
	agentID = getUrlParam('agentID')?getUrlParam('agentID'):'';
	var d = new Date();
	var now = d.getTime();
	var now_b = now - 30 * 60 * 1000;
	sttime = getUrlParam('sttime')?getUrlParam('sttime'):now_b;
	endtime = getUrlParam('endtime')?getUrlParam('endtime'):now;
}

function initFormPlugin(st, ed){
	var d1 = new Date(parseInt(st));
	$('input[name=from]').val(d1.getFullYear() + '-' + (d1.getMonth()+1) + '-' + d1.getDate() + ' ' + d1.getHours() + ':' + d1.getMinutes());
    $('input[name=from]').appendDtpicker();
    
	var d2 = new Date(parseInt(ed));
	$('input[name=to]').val(d2.getFullYear() + '-' + (d2.getMonth()+1) + '-' + d2.getDate() + ' ' + d2.getHours() + ':' + d2.getMinutes());
    $('input[name=to]').appendDtpicker();
}

$(document).ready(function(){
	getParams();
	initFormPlugin(sttime, endtime);
});

function navjump(ind) {
	var jumpurl = "/stewardweb/";
	switch(ind) {
		case 0:
			jumpurl += 'topo.do';
		break;
		case 1:
			jumpurl += 'performance.do';
		break;
		case 2:
			jumpurl += 'appLoad.do';
		break;
		case 3:
			jumpurl += 'slowCall.do';
		break;
		case 4:
			jumpurl += 'wrongCall.do';
		break;
		default:
			jumpurl += 'topo.do';
		break;
	}
	jumpurl = jumpurl + '?agentID=' + agentID;
	if (sttime != 0) {
		jumpurl = jumpurl + '&sttime=' + sttime;
	}
	if (endtime != 0) {
		jumpurl = jumpurl + '&endtime=' + endtime;
	}
	window.location.href = jumpurl;
//	alert(jumpurl);
}
//$("ul.headermenu>li").click(function(){
//	var ind = $("ul.headermenu>li").index(this);
//	var jumpurl = "/stewardweb/";
//	switch(ind) {
//		case 0:
//			jumpurl += 'topo.do';
//		break;
//		case 1:
//			jumpurl += 'performance.do';
//		break;
//		case 2:
//			jumpurl += 'appLoad.do';
//		break;
//		case 3:
//			jumpurl += 'slowCall.do';
//		break;
//		case 4:
//			jumpurl += 'wrongCall.do';
//		break;
//		default:
//			jumpurl += 'topo.do';
//		break;
//	}
//	jumpurl = jumpurl + '?agentID=' + agentID;
//	if (sttime != 0) {
//		jumpurl = jumpurl + '&sttime=' + sttime;
//	}
//	if (endtime != 0) {
//		jumpurl = jumpurl + '&endtime=' + endtime;
//	}
//	alert(jumpurl);
//});
