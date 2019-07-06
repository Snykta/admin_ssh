$(function() {
	$('#updateUser').click(function() {
		var names =  $('#names').val().trim().length;
		var email = $('#email').val().trim().length;
		if(names==0||email==0){
			layer.msg('请输入内容!', {icon: 5,time: 1500});
		}else{
		$.ajax({
			 url : "/SSH_CMS/update_AdminUserAction",
	         type : "post",
	         data:{
	        	 "result" : eval("(" + $.cookie('admin_user') + ")")['id'],
	        	 "names"  : $('#names').val(),
	        	 "email"  : $('#email').val()
	         },
	         success : function (m) {
	        	 var arry = JSON.parse(m);
	        	 console.log(arry);
	        	 if(arry.state==1){
	        		 layer.msg('修改成功');
	        		 setTimeout("location.href='updateAdmin.html'",1000);
	        	 }else{
	        		 layer.msg('修改失败', {icon: 5,time: 800});
	        	 }
	            
	         }
		});
		}
		
	});
	
	
	
	
	$('#updatepass').click(function() {
		var pass3 =  $('#repassword').val().trim().length;
		var pass2 = $('#password').val().trim().length;
		var pass = $('#pass').val().trim().length;
		if(pass3==0||pass2==0||pass==0){
			layer.msg('请输入密码!', {icon: 5,time: 1500});
		}else if(($('#repassword').val().trim())!=($('#password').val().trim())){
			layer.msg('两次密码不一致', {icon: 5,time: 1500});
		}else{
		$.ajax({
			 url : "/SSH_CMS/updatepass_AdminUserAction",
	         type : "post",
	         data:{
	        	 "result" : eval("(" + $.cookie('admin_user') + ")")['id'],
	        	 "password"  : $('#password').val().trim(),
	        	 "pass" : $('#pass').val().trim()
	         },
	         success : function (m) {
	        	 var arry = JSON.parse(m);
	        	 console.log(arry);
	        	 if(arry.state==1){
	        		 layer.msg('密码修改成功');
	        		 setTimeout("location.href='updateAdmin.html'",1000);
	        	 }else if(arry.state==(-2)){
	        		 layer.msg('原密码输入错误', {icon: 5,time: 800});
	        	 }else{
	        		 layer.msg('修改失败', {icon: 5,time: 800});
	        	 }
	            
	         }
		});
		}
		
	});
	
	
});