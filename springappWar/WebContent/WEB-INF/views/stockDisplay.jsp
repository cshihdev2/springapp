<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body#stock_page_body {
	font-family: arial,helvetica,sans-serif;
}
body#stock_page_body table, th, td
{
border: 1px solid black;
}
.error{
	color:red;
}
</style>

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<title>StockDisplay</title>
</head>

<body id="stock_page_body">
	<h1>Welcome Stock Report Powered by Yahoo! Finance</h1>

	<fieldset>
	
		<legend>Look Up Your Stock Here</legend>
		<span>Stock Symbol</span><br/>
		<input type="text" value=""	name="symbol">
		<div class="error" id="error_for_symbol"></div>
		<br/>
		<span>Select interested fields</span><br/>
		<select name="fields" multiple="multiple" size="10" }>
			<c:forEach items="${fieldSelection}" var="entry">
				<option value="${entry.key}">${entry.value}</option>
			</c:forEach>
		</select>
		<div class="error" id="error_for_fields"></div>
	</fieldset>
	
	<input type="submit" value="Look Up" />

	<div id="s_detail"></div>
</body>

<script>
	$(document).ready(function(){
		$('input[type="submit"]').click(function(){
			
			// validate that a symbol is entered
			if(!$('input[name="symbol"]').val() || 0===$('input[name="symbol"]').val().length){
				$('#error_for_symbol').html("Please enter a symbol");	
				return false; 
			} else {
				$('#error_for_symbol').html("");
			}
			
			// validate that at least one field is selected
			var options = $('select[name="fields"]').val();
			if (options == null) {
				$('#error_for_fields').html("Please select at least one field");
				return false;
			} else {
				$('#error_for_fields').html("");
			}

			$.ajax({                                       
				  url : '${contextPath}/stock/getSymbol/' + $('input[name="symbol"]').val(),
				  type : 'GET',
				  async: true,
				  data : {'fields':options.join()},
				  success : function(data) {  
						$('#s_detail').html(data);				    
				  }
				});
		});
		
	});
</script>

</html>