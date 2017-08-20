<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>test</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#add").click(function(){
					$.post(
						"${pageContext.request.contextPath}/add",
						$("#addForm").serialize(),
						function(data){
							$("#result").val(data);
						}
					);
				});
				
				$("#select").click(function(){
					$.post(
						"${pageContext.request.contextPath}/select",
						function(data){
							$("#selectDiv").empty();
							data=eval('(' + data + ')');
							var result = "<table border='1' cellspacing='3' cellpadding='1'><tr><td>id</td><td>name</td><td>age</td><td>修改</td><td>删除</td></tr>";
							var result_suffix = "</table>";
							$.each(data, function(i, n){
								var temp = "<tr><td>"+n.id+"</td>"
									+"<td><input type='text' value='"+n.name+"' /></td>"
									+"<td><input type='text' value='"+n.age+"' /></td>"
									+"<td><input type='button' onclick='updateBtn("+n.id+", this);' value='修改'/></td>"
									+"<td><input type='button' onclick='deleteBtn("+n.id+");' value='删除'/></td></tr>";
								result = result + temp;
							});
							result = result + result_suffix;
							$("#selectDiv").html(result);
						}
					);
				});
			});
			
			function updateBtn(id, obj){
				var tr = $(obj).parents("tr");
				var tds = tr.children("td");
				var id = tds.eq(0).html();
				var name = tds.eq(1).children().val();
				var age = tds.eq(2).children().val();
				
				$.post(
					"${pageContext.request.contextPath}/update",
					{id:id, name:name, age:age},
					function(data){
						if(data==1){
							alert("修改成功");
							$("#select").trigger("click");
						}
					}
				);
			}
			
			function deleteBtn(id){
				$.post(
					"${pageContext.request.contextPath}/delete",
					{id:id},
					function(data){
						if(data==1){
							alert("删除成功");
							$("#select").trigger("click");
						}
					}
				);
			}
		</script>
	
	</head>
	<body>
		<form id="addForm">
			<input name="name" type="text" placeholder="name"/>
			<input name="age" type="number" placeholder="age"/>
		</form>
		<button id="add">add</button> <button id="select">select</button><br/>
		<input id="result" disabled="disabled" readonly="readonly" /><br/>
		<div id="selectDiv">
		</div>
	</body>
</html>