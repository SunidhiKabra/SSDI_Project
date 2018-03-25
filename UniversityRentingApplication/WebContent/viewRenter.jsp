<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />
<jsp:include page="errorList.jsp" />

<hr />
<br />
<p>
<table border="1">


	<tr>
		<td valign="top">Name</td>
		<td valign="top">${renter.getFirstName()} ${renter.getLastName()} </td>
	</tr>
	<tr>
		<td valign="top">Email ID</td>
		<td valign="top">${renter.getEmail()}</td>
	</tr>

	<tr>
		<td valign="top">Phone Number</td>
		<td valign="top">${renter.getPhoneNumber()}</td>
	</tr>
</table>
</p>



<jsp:include page="footer.jsp" />