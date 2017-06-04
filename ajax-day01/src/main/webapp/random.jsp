<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript"src="js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function showNumber(){
		var xhr = getXhr();
		alert(xhr);
		//step2:发送请求
		xhr.open('get','random.do',true);
		xhr.onreadystatechange=function(){
			//step4:处理服务器返回的数据
			if(xhr.readyState==4&&xhr.status==200){
				var txt = xhr.responseText;
				$('msg').innerHTML = txt;
				
				
			}
		};
		xhr.send(null);
		
	}
	
	
</script>
</head>
<body style="font-size:30px">
<!--
	<a href="random.jsp" onclick="f1();">随机数</a><br>
	如果这样写，则，会返回数据，但是数据一闪就没了 
要想稳定的显示，就得将链接改为脚本语言代码
	<a href="javascript:showNumber();">随机数</a><br> -->
<a href="javascript:showNumber();">随机数</a> 
<div id="msg"></div>
	
</body>
</html>