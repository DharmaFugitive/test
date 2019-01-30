// 初始用户页面加载
$(function(){
	var currentPage =$("#currentPage").text(); 
	//ajax提交请求给服务器
	$.get(
			"/news/GetUser",
			{"currentPage":currentPage},
			function(page){
				$(".pageData").remove();
				$("#totalPage").text(page.totalPage); 
				$.each(page.data, function(index,User){
					var auth = this.auth;
					if(auth==0){
						auth="管理员";
					}else if(auth==1){
						auth="娱乐";
					}else if(auth==2){
						auth="体育";
					}else if(auth==3){
						auth="国际";
					}else if(auth==4){
						auth="民生";
					}else{
						auth="未知";
					}
					$(".public-cont-table").append('<tr class="pageData">'
							+'<td><a id="userId">'+this.id+'</a></td>'
							+'<td>'+this.account+'</td>'
							+'<td>'+this.password+'</td>'
							+'<td>'+this.username+'</td>'
							+'<td>'+auth+'</td>'
							+'<td><div class="table-fun"><a onclick="updataUser(this)">修改</a><a class="delUser" >删除</a></div></td>'
							+'</tr>');
					
				});
			},
			"json"
			);
})

// 跳转页面加载用户信息
function Page(obj){
	var currentPage =parseInt($("#currentPage").text()); 
	var totalPage =parseInt($("#totalPage").text()); 
	var name = $(obj).attr("name");
	if(name=="homePage"){
		currentPage = 1;
	}else if(name=="upPage"){
		if(currentPage<=1){
			currentPage=1;
		}else{
			currentPage=currentPage-1 ;
		}
	}else if(name=="nextPage"){
		if(currentPage>=totalPage){
			currentPage=totalPage;
		}else{
			currentPage=parseInt(currentPage)+1 ;
		}
	}else if(name=="jumpPage"){
		var jumpPage =$(".page-input").val();
		if(jumpPage >= 1 && jumpPage <=totalPage ){
			currentPage=jumpPage;
		}else{
			alert("你输入的页码有误,请重新输入")
			return flase;
		}	
	}
	
	
	$.get(
			"/news/GetUser",
			{"currentPage":currentPage},
			function(page){
				$(".pageData").remove();
				$.each(page.data, function(index,User){
					var auth = this.auth;
					if(auth==0){
						auth="管理员";
					}else if(auth==1){
						auth="娱乐";
					}else if(auth==2){
						auth="体育";
					}else if(auth==3){
						auth="国际";
					}else if(auth==4){
						auth="民生";
					}else{
						auth="未知";
					}
					$(".public-cont-table").append('<tr class="pageData">'
							+'<td><a id="userId">'+this.id+'</a></td>'
							+'<td>'+this.account+'</td>'
							+'<td>'+this.password+'</td>'
							+'<td>'+this.username+'</td>'
							+'<td>'+auth+'</td>'
							+'<td><div class="table-fun"><a onclick="updataUser(this)">修改</a><a class="delUser" >删除</a></div></td>'
							+'</tr>');
				});
				$("#currentPage").text(currentPage);
			},
			"json"
			);
}



// 删除用户信息
$(".delUser").live("click",function(){
	var id = $(this).parents("tr").find("#userId").text();
	$.get(
			"/news/DeleteUserServlet",
			{"id":id},
			function(flag){
				alert(flag)
				if(flag){
					alert("删除成功");
					location.href="usermanager.html";
				}else{
					alert("删除失败");
				}
			}
	);
	
});



