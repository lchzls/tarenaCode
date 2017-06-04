<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<style type="text/css">
		#d1{
		width:480px;
		height:350px;
		margin-left:400px;
		margin-top:80px;
		background-color:black;
		}
		#d2{
		color:red;
		background-color:yellow;
		height:32px;
		}
		table{
		color:white;
		font-style:italic;
		font-size:14px;
		}
		</style>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" >
			function showStocks(){
				setInterval(quoto,5000);
			}
			function quoto(){
				var xhr = getXhr();
				xhr.open('get','quoto.do',true);//true代表异步
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4&&xhr.status==200){
						//txt是一个json字符串 
						var txt = xhr.responseText;
						alert(txt);
						
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size:30px;" onload="showStocks()">
		<div id="d1">
			<div id="d2">股票实时行情</div>
			<div id="d3">
				<table width="100%">
					<thead>
						<tr>
							<td>代码</td>
							<td>名称</td>
							<td>价格</td>
						</tr>
					</thead>
					<tbody id="tb1">
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>