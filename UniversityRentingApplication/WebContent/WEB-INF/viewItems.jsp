<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />



<jsp:include page="errorList.jsp" />

<hr />
<br />
<p>
<table border="1">
	<c:forEach var="item" items="${items}">

		<tr>
			<td valign="top">${item.getName()}</td>
		<tr>
			<td valign="top">${item.getDescription()}</td>
		<tr>
			<td valign="top">${item.getRent()}</td>
		</tr>

	</c:forEach>
</table>
</p>

<jsp:include page="footer.jsp" />
