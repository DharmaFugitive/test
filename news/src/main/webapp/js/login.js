function init(){
	var vm = new Vue({
		el:"#loginVue",
		data:{
			account:"",
			password:"",
			error:""
		},
		
		methods:{
			login:function(){
				this.$http.post("/news/AccountLogin",
				{account:this.account,password:this.password},
				{emulateJSON:true}
				).then(
						function(resp){
							var data = resp.body;
							if(data == "null"){
								// 登陆失败
								this.error = "账号或密码错误";
							}else{
								var jsonStr = JSON.stringify(data);
								sessionStorage.setItem("user",jsonStr);
								location.href="index.html";
							}
						});
			}
		}
	})	
}


