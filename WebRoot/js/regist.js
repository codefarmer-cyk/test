var xmlHttp;
var flag1 = false;
var flag2 = false;
var flag3 = false;
function createXMLHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function checkUserid(userid) {
	createXMLHttp();
	if (userid == null || userid == "") {
		document.getElementById("msg1").innerHTML = "用户id不能为空！";
		document.getElementById("msg1").style.color = 'red';
	} else {
		xmlHttp.open("POST", "CheckUseridServlet?userid=" + userid);
		xmlHttp.onreadystatechange = checkUseridCallback;
		xmlHttp.send(null);
		document.getElementById("msg1").innerHTML = "正在验证·····";
		document.getElementById("msg1").style.color = 'yellow';
	}
}

function checkPassword(password) {
	if (password == null || password == "") {
		document.getElementById("msg2").innerHTML = "密码不能为空！";
		document.getElementById("msg2").style.color = 'red';
		flag2 = false;
	} else {
		document.getElementById("msg2").innerHTML = "密码可以使用";
		document.getElementById("msg2").style.color = 'green';
		flag2 = true;
	}
}

function checkReppassword(password, reppassword) {
	if (password != reppassword) {
		flag3 = false;
		document.getElementById("msg3").innerHTML = "两次输入密码不一致!";
		document.getElementById("msg3").style.color = 'red';
	} else {
		flag3 = true;
		document.getElementById("msg3").innerHTML = "输入正确";
		document.getElementById("msg3").style.color = 'green';
	}
}

function checkUseridCallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var text = xmlHttp.responseText;
			if (text == "true") {
				document.getElementById("msg1").innerHTML = "用户id已存在！";
				document.getElementById("msg1").style.color = 'red';
				flag1 = false;
			} else {
				flag1 = true;
				document.getElementById("msg1").innerHTML = "此用户id可以注册！";
				document.getElementById("msg1").style.color = 'green';
			}
		}
	}

	function checkForm() {
		document.write("<h1>"+flag1 && flag2 && flag3+"</h1>");
		//return flag1 && flag2 && flag3;
		return false;
	}
}
