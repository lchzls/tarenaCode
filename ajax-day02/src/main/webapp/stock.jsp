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
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
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
						//alert(txt);
						//将json字符串转换为js对象
						var arr = txt.evalJSON();
						//更新表格
						var trs = ' ';
						for(i=0;i<arr.length;i++){
							var s = arr[i];
							
							trs += '<tr><td>'+s.code+'</td><td>'+s.name+'+</td><td>'+s.price+'</td></tr>';
						}
						//ie浏览器，table,thead，tbody，tr都不能使用 
						$('tb1').innerHTML = trs;
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