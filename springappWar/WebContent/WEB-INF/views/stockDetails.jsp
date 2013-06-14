<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<thead>
		<tr>
			<th>Stock Field Name</th>
			<th>Value</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${symbolDetail}" var="entry">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>