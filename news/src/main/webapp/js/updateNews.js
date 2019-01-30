function init(){
	alert("init")
	var updnews = new Vue({
		el:"updateNewsContent",
		data:{
			title:"",
			description:"",
			content:"",
			createtime:"",
			author:""
		},
		methods:{
			jump:function(){
				alert(this.title);
			}
		}
	});
	

}
/*function jump(){
	alert("1");
	alert(updnews.$data.title);
}*/