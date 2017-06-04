$(function(){
	
	$('#login').click(loginAction); 
	$('#count').focus().blur(checkName);
	$('#password').blur(checkPassword);
	$('#regist_button').click(registAction);
	$('#regist_username').blur(checkRegistUsername);
	$('#regist_password').blur(checkRegistPassword);
	$('#final_password').blur(checkFinalPassword);
	
});


function registAction(){
	//console.log('registAction');
	var pass = checkRegistUsername()+checkRegistPassword()+checkFinalPassword();
	if(pass!=3){
		return;
	}
	var url = "user/regist.do";
	var name = $('#regist_username').val();
	var nick = $('#nickname').val();
	var pwd = $('#regist_password').val();
	var confirm = $('#final_password').val();
	var data = {name:name,nick:nick,password:pwd,confirm:confirm};
	$.post(url,data,function(result){
		if(result.state==0){
			var user = result.data;
			$('#back').click();
			$('#count').val(user.name);
			$('#password').focus();
		}else if(result.state==2){
			$('#warning_1 span').html(result.message).parent().show();
		}else if(result.state==3){
			$('#warning_2 span').html(result.message).parent().show();
		}else {
			alert(result.message);
		}
	},"json");
}

function checkRegistUsername(){
	console.log('checkRegistUsername');
	var name = $('#regist_username').val();
	var reg = /^\w{3,10}$/;
	if(!reg.test(name)){
		$('#warning_1 span').html('不合规则').parent().show();
		return false;
	}
	$('#warning_1').hide();
	return true;
}

function checkRegistPassword(){
	console.log('checkRegistPassword');
	var password = $('#regist_password').val();
	var reg = /^\w{3,10}$/;
	if(!reg.test(password)){
		$('#warning_2 span').html('不合规则').parent().show();
		return false;
	}
	$('#warning_2').hide();
	return true;
}

function checkFinalPassword(){
	console.log('checkFinalPassword');
	var confirm = $('#final_password').val();
	var pwd = $('#regist_password').val();
	if(confirm!=pwd){
		$('#warning_3 span').html('不一致').parent().show();
		return false;
	}
	$('#warning_3').hide();
	return true;
}


function loginAction(){
	var name = $('#count').val();
	var password = $('#password').val();
	var pass = checkName() + checkPassword();
	if(pass!=2){
		return ;
	}
	
	var parameter = {'name':name,'password':password};
	//发送ajax请求
	$.ajax({
		url:'user/login.do',
		data:parameter,
		dataType:'json',
		type:'post',
		success:function(result){
			if(result.state==0){
				//console.log("success");
				//console.log(result.data);
				var user = result.data;
				setCookie('userId',user.id);
				location.href='edit.html';
				return;
			}else if(result.state==2){
				$('#count-msg').html(result.message);
				return;
			}else if(result.state==3){
				$('#password-msg').html(result.message);
				return;
			}
			alert(result.message);
		},
		error:function(){
			alert('ajax请求失败');
		}
	});
}

function checkName(){
	//alert('checkName--------------');
	var name = $('#count').val();
	//如果是输入空或者长度不对，则提示
	if(name==null||name==""){
		$('#count-msg').html('not null');
		return false;
	}
    var reg = /^\w{3,10}$/;
    if(!reg.test(name)){
    	$('#count-msg').html('length is error');
    	return false;
    }
    //然后再次输入，若输入正确，在切换光标时，则应该将以上提示信息清空
    $('#count-msg').empty();
    return true;
}

function checkPassword(){
	var password = $('#password').val();
	if(password==null||password==""){
		$('#password-msg').html('not null');
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(password)){
		$('#password-msg').html('length is error');
		return false;
	}
	$('#password-msg').empty();
	return true;
}
