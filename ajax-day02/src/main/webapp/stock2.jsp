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
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript" >
			$(function(){
				//页面加载完成
				setInterval(quoto,5000);
			});
			function quoto(){
				$.ajax({
					"url":"quoto.do",
					"type":"post",
					"dataType":"json",
					"success":function(data){
						//服务器处理正确
						/*
						如果服务器返回的是json字符串，$.ajax函数会自动将这个json字符串转换为javascript对象
						*/
						$('#tb1').empty();
						for(i=0;i<data.length;i++){
							var s = data[i];
							$('#tb1').append(
									'<tr><td>'+s.code
									+'</td><td>'+s.name
									+'+</td><td>'+s.price
									+'</td></tr>');
						}
					},
					"error":function(){
						//服务器处理发生异常
						alert("error");
						
					}
				});
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