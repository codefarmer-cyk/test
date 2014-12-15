		var xmlHttp;
		var flag1;
		var flag2;
		function createXMLHttp() {
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}

		function checkUserid(userid) {
			createXMLHttp();
			if (userid == "" || userid == null) {
				document.getElementById("msg1").innerHTML = "用户名不能为空！";
				document.getElementById("msg1").style.color='red';
			} else {
				xmlHttp.open("POST", "CheckUseridServlet?userid=" + userid);
				xmlHttp.onreadystatechange = checkUseridCallback;
				xmlHttp.send(null);
				document.getElementById("msg1").innerHTML = "正在验证····";
			}
		}
		
		function checkPassword(password) {
			if (password == "" || password == null) {				
				document.getElementById("msg2").innerHTML = "密码不能为空！";
				document.getElementById("msg2").style.color='red';
				flag2=false;
			} 
		}	

		function checkUseridCallback() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					if (text == "false") {
						flag1 = false;
						document.getElementById("msg1").innerHTML = "用户id不存在！";
						document.getElementById("msg1").style.color='red';
					} else {
						flag1 = true;
						document.getElementById("msg1").innerHTML = "可以登录";
					}
				}
			}
		}

		function checkForm() {
			return flag1&&flag2;
		}