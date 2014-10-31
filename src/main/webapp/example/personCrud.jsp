<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Input</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script language="JavaScript">
	
	function modify(id) {
		$("#firstRow").hide();
		//取name=id的input
		var idInput = $("input[name=id]");
		var v = idInput.attr("value");
		//若取到v代码input存在，则把input还原为原来的td
		if(undefined!=v){
	
			idInput.parent().html(v);
			var whichId = v-1;
			//取ID="Name_"+whichId的TD下面的input的值
			var val =$("#Name_"+whichId).find("input").val();
			$("#Name_"+whichId).html(val);
			var val =$("#Telp_"+whichId).find("input").val();
			$("#Telp_"+whichId).html(val);
			var val =$("#Addr_"+whichId).find("input").val();
			$("#Addr_"+whichId).html(val);

			
		}
	
		//把当前行的td内容转成带input
		var whichTr = $("#modify_" + id).parent().parent();//TR
		var idTd = whichTr.children("#ID_" + id);//TD
		var nameTd = whichTr.children("#Name_" + id);//TD
		var addrTd = whichTr.children("#Addr_" + id);//TD
		var telpTd = whichTr.children("#Telp_" + id);//TD

		idTd.html("<input type='input' name='id' value='"
					+ idTd.html() + "' readonly=readonly size=6>");
		nameTd.html("<input type='input' name='name' value='"
					+ nameTd.html() + "' size=12>");
		telpTd.html("<input type='input' name='telphone' value='" + telpTd.html() + "' size=12>");
		addrTd.html("<input type='input' name='address' value='" + addrTd.html() + "' size=24>");
	
	}
	
	$(document).ready(function() {
		$("#btnAdd").click(function() {
			var whichEl = $("#firstRow");
			if (whichEl.css("display") == "none") {
				whichEl.show();
				$(this).val("取消新增");
			} else {
				whichEl.hide();
				$(this).val("新增");
			}
		});

		$("#submitCng").click(function() {
			if (window.confirm('确定要提交吗？')) {
				var whichEl = $("#firstRow");
				//#firstRow的display为none则是修改提交，否则为新增
				if (whichEl.css("display") == "none") {
					var idInput = $("input[name=id]");
					var v = idInput.attr("value");
					//修改提交的时候把当前行的input值给#firstRow的input
					if(undefined!=v){
						var whichId = v-1;
						$("#firstRow").find("input[name='i']").val(whichId);
						var val =$("#Name_"+whichId).find("input").val();
						$("#firstRow").find("input[name$='name']").val(val);
						var val =$("#Telp_"+whichId).find("input").val();
						$("#firstRow").find("input[name$='telphone']").val(val);
						var val =$("#Addr_"+whichId).find("input").val();
						$("#firstRow").find("input[name$='address']").val(val);
					}
					
					//提交代码
					$("#frmAdd").attr("action", "${path }/example/personCrud_update");
					$("#frmAdd").submit();
				}else{
					//提交代码
					$("#frmAdd").submit();
				}
			}
		});
	});
</script>
</head>

<body>

	<table id="main" class="table table-hover">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Telphone</th>
			<th>Address</th>
			<th><input type="button" id="btnAdd" value="新增" />&nbsp;<input
				type="button" id="submitCng" value="提交" /></th>
		</thead>
		<tbody>
			<form id="frmAdd" action="${path }/example/personCrud_add" method="post">
				<tr id="firstRow" style="display: none">
					<td><input type="hidden" name="i" />&nbsp;</td>
					<td><input type="text" name="person.name" /></td>
					<td><input type="text" name="person.telphone" /></td>
					<td><input type="text" name="person.address" /></td>
					<td>&nbsp;</td>
				</tr>
			</form>
			<c:forEach items="${result}" var="person" varStatus="status">
				<tr>
					<td id="ID_${status.index}"><c:out value="${status.index+1}" />&nbsp;</td>
					<td id="Name_${status.index}"><c:out value="${person.name}" />&nbsp;</td>
					<td id="Telp_${status.index}"><c:out
							value="${person.telphone}" />&nbsp;</td>
					<td id="Addr_${status.index}"><c:out value="${person.address}" />&nbsp;</td>
					<td id="Func"><a href="#" id="modify_${status.index}"
						onclick="modify(${status.index})">修改</a>&nbsp;<a
						href="${path }/example/personCrud_remove?i=${status.index}">删除</a>&nbsp;</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
