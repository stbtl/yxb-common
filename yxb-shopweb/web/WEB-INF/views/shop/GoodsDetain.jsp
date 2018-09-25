<script type="text/javascript">
	$(function(){
		$("#edit").click(function(){
			alert(1);
		});
	})
</script>
<div>
	<form:form id="form" modelAttribute="goodsDTO" action="${pageContext.request.contextPath}/Goods/detainInit" method="post">
		<div>
			<form:input path="id" /><br/>
			<form:input path="name" /><br/>
			<form:input path="price" /><br/>
			<input id="edit" type="button" value="EDIT" />
			<input id="update" type="button" value="UPDATE" />
			<input id="cancel" type="button" value="CANCEL" />
			<input id="delete" type="button" value="DELETE" />
		</div>
	</form:form>
</div>