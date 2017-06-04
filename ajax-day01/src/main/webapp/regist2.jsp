<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript"src="js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function check_uname(){
		//step1.获得ajax对象
		var xhr = getXhr();
		alert(xhr);
		//step2:发送请求
		xhr.open('post','check_uname.do',true);
		xhr.setRequestHeader(
			'content-type','application/x-www-form-urlencoded');
		xhr.onreadystatechange=function(){
			//step4:处理服务器返回的数据
			if(xhr.readyState==4&&xhr.status ==200){
				var txt = xhr.responseText;
				$('username_msg').innerHTML = txt;
			}
		}
		xhr.send('username='+$F('username'));
	}
	
	
</script>
</head>
<body style="font-size:30px">
	<form action="register.do" method="post" type="text">
		用户名:<input name="username" id="username" onblur="check_uname();"/>
		<span id="username_msg"></span>
		<br>
		密码:<input name="pwd" type="password"/><br>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>