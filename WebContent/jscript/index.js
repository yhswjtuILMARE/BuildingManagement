window.setInterval(function ShowTime(){
				var date = new Date();
				var div = document.getElementById("div2");
				div.innerHTML = date.toLocaleDateString() + date.toLocaleTimeString();
				},500);
			function borderShow(button){
				var name = "/BuildingManagement/buyUI/?building_id=" + button.value;
				alert(name);
			}
			function ToTop(){
				scroll(0,0);
			}
			function change(button){
				button.value=button.value==""?"顶部":"";
			}
			