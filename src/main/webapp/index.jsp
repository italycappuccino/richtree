<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Home</title>
</head>
<body>
<h2>Hello World!</h2>
<div>
country:<input type="text" id="country" name="country"/>
<input type="button" id="calc" value="统计" onclick="calc()"/><span id="Msg" style="color: red;"></span>
<select name="cityId" id="S_City" >
	<option value="">请选择</option>
</select>
</div>
<script src="/static/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
var url = '/demo/country';
function calc(){
	$.ajax({url:url, dataType:'json', data:{"country": $("#country").val()}, success:function(data){
		if(data.success==false){
			$('#Msg').html(data.Msg);
			return;
		}
		$('#Msg').html(data.count);
		var html = '';
		html += '<option value="">请选择</option>';
		for(var i = 0; i < data.city.length; i++){
			if(!data.city[i]){
				continue;
			}
			html += '<option value="' + data.city[i].id + '">' + data.city[i].name + '</option>';
		}
		$('#S_City').html(html);
		}
	});	
}
</script>
</body>
</html>