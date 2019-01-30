function init(){
	var vu = new Vue({
		el:"#loginUser",
		data:{
			username:"请登录",
			auth:"",
			userId:""	
		}
	});
	
	var userjson = sessionStorage.getItem("user");
	var user = JSON.parse(userjson);
	if(user != null){
		sessionStorage.setItem("username",user.username);
		sessionStorage.setItem("author",user.auth);
		sessionStorage.setItem("userId",user.id);
		vu.$data.username="hello,"+user.username;
		vu.$data.auth=user.auth;
		vu.$data.userId=user.id;
	}

}

function userPower(obj){
	var auth = $("#auth").text();
	if(auth != "0"){
		alert("你的权限不够");
		$(obj).attr("href","");
		return false;
	}

}