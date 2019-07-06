$(function() {
	$('#logins').click(function() {
		var uname =  $('#uname').val().trim().length;
		var pas = $('#pas').val().trim().length;
		if(uname==0||pas==0){
			layer.msg('请填写密码或账号!', {icon: 5,time: 1500});
		}else{
		$.ajax({
			 url : "/SSH_CMS/login_AdminUserAction",
	         type : "post",
	         data:{
	        	 "users" : $('#uname').val().trim(),
	             "password" :  $('#pas').val().trim()
	         },
	         success : function (m) {
	        	 var arry = JSON.parse(m);
	        	 console.log(arry);
	        	 if(arry.state==1){
	        		 location.href="index.html?user_names="+arry.user_name;
	        	 }else{
	        		 $('#uname').val(""); $('#pas').val("");
	        		 layer.msg('登陆失败...', {icon: 5,time: 800});
	        	 }
	            
	         }
		});
		}
		
	});
});