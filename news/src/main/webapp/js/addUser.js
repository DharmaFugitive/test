var flag1 = false;
var flag2 = false;
var flag3 = false;
function addUser(obj){
	var value = $(obj).val();
	var name =$(obj).attr("name");
	
	if(name=="user_Account"){
		var patt1 = /^[a-zA-Z0-9]{4,20}$/;
		flag1 = patt1.test(value);
		if(patt1.test(value)){
			
			$.get("/news/addUserAccount",{"account":value},function(data){
				if(data){
					$(obj).next().css("color","red");
					$(obj).next().text("编号已存在,请重新输入");
				}else{
					$(obj).next().css("color","green");
					$(obj).next().text("√ ");

				}
			})
		}else{
			$(obj).next().css("color","red");
			$(obj).next().text("X 格式:不为空, 4~20字符，字母和数字");
			return false;
		}
	}else if(name=="user_Password"){
		var patt2 = /^[a-zA-Z0-9]{4,20}$/;
		flag2 = patt2.test(value);
		if(patt2.test(value)){
			$(obj).next().css("color","green");
			$(obj).next().text("√ ");
		}else{
			$(obj).next().css("color","red");
			$(obj).next().text("X 格式:不为空, 4~20字符，字母和数字");
			return false;
		}

	}else if(name=="user_Name"){
		var patt3 = /^[a-zA-Z0-9_\u4e00-\u9fa5]{1,100}$/;
		flag3 = patt3.test(value);
		if(patt3.test(value)){
			$(obj).next().css("color","green");
			$(obj).next().text("√ ");
		}else{
			$(obj).next().css("color","red");
			$(obj).next().text("X 格式:不为空，不超过100字符");
			return false;
		}
	}
	
}

function sumbmitAddUser(obj){
	var account = $("input[name='user_Account']").val();
	var password=$("input[name='user_Password']").val();
	var name=$("input[name='user_Name']").val();
	var auth=$("select[name='user_Auth']").val();
	if(!(flag1 && flag2 &&flag3)){
		alert("请填写完整正确注册信息");
		return false;s
	}
	if(name=="" || password=="" || account==""){
		alert("请填写完整正确注册信息");
		return false;
	}else{
		var param={"account":account,"password":password,"name":name,"auth":auth}
		$.post("/news/addUser",param,
				function(data){
			alert(data)
			if(data==1){
				alert("增加成功");
			}else if(data==0){
				alert("增加失败");
			}
		})
	}
	
}