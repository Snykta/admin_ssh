//注意进度条依赖 element 模块，否则无法进行正常渲染和功能性操作
layui.use(['element','form','laypage','laydate','layedit','upload','laytpl'], function(){
    var element = layui.element;
    var laytpl = layui.laytpl;
    var upload = layui.upload;
    var form = layui.form;
    var laydate = layui.laydate;
    var laypage = layui.laypage;
    var data = {
        "list":[
                {"name":"系统主页","icon":"layui-icon-home","url":"./index.html"},
                {"name":"文章管理","icon":"layui-icon-list","url":"./news.html"},
                {"name":"添加文章","icon":"layui-icon-template-1","url":"./news_add.html"},
                {"name":"友情链接","icon":"layui-icon-link","url":"./link.html"},
                {"name":"添加链接","icon":"layui-icon-component","url":"./link_add.html"},
                {"name":"资源下载","icon":"layui-icon-chart","url":"./data_backout.html"},
                {"name":"人员管理","icon":"layui-icon-friends","url":"./users.html"},
                {"name":"添加人员","icon":"layui-icon-add-1","url":"./users_add.html"},
                {"name":"添加分组","icon":"layui-icon-user","url":"./dept_add.html"},
                {"name":"分组管理","icon":"layui-icon-user","url":"./dept.html"},
                {"name":"后台管理员","icon":"layui-icon-username","url":"./AdminUserListt.html"},
            ]
    };
    
    var getTpl = side.innerHTML
        ,view = document.getElementById('leftside');
        laytpl(getTpl).render(data, function(html){
            view.innerHTML = html;
        });
    //执行实例
    var uploadadd = upload.render({
        elem: '#newadd' //绑定元素
        ,url: '/SSH_CMS/uploadImg_news' //上传接口
        ,done: function(res){
        	if(res["state"]==1){
        		layer.msg('上传成功');
        		$('#ds').children().remove();
        		var imgs = res['names'];
        		var str = "<img name='myfileFileName' src='http://localhost:8080/test/"+imgs+"' class='layui-nav-img '/>"
        		$('#ds').append(str)
        	}else{
        		layer.msg('上传失败', {icon: 5,time: 800});
        	}
        }
    	,field: "myfile"
    	,size :1024
        ,error: function(){
        }
    });
    $('#user_name').html(eval("(" + $.cookie('admin_user') + ")")['names']);
    
/*
    function del_new() {
        $(".new_dels").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"确认删除 ID 为："+$(this).attr("rel")+" 的信息吗？",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/SSH_CMS/del_news",
           	         type : "post",
           	         data:{
           	        	 "result" : ids,
           	         },
           	         success : function (m) {
           	        	 var arry = JSON.parse(m);
           	        	 console.log(arry);
           	        	 if(arry.state==1){
           	        		layer.msg("删除成功",{
           	                    icon:1,time:2000
           	                });
           	        		 setTimeout("location.href='news.html'",1000);
           	        	 }else{
           	        		 layer.msg('删除失败', {icon: 5,time: 800});
           	        	 }
           	         }
           		});
                    
                }
                ,btn2: function(index, layero){
                    layer.msg("已取消",{
                        icon:2,time:1000
                    });
                }
            });
            return false;
        });
	}*/
    
    
    //添加分类
    $("#addclass").click(function () {
        layer.open({
            title: '添加分类'
            ,type: 1
            ,content:$('#addclassform')
        });
        return false;
    });
    
    
    
    $(".userhead").click(function () {
        var imgpath = $(this).attr('src');
        layer.open({
            type: 1,
            shade:false,
            title: false, //不显示标题
            content: "<img src='"+ imgpath +"' width='100%'>"
        });
    });
});