<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- loads JSTL -->
<table>
		<tr>
			<th>Film Title: </th>
			<th>Year: </th>
			<th>Director: </th>
			<th>Stars: </th>
			<th>Review: </th>
		</tr>
			<c:forEach items="${films}" var="f" >
		<tr>
			<td><c:out value="${f.getTitle()}"/></td>
			<td><c:out value="${f.getYear()}"/></td>
			<td><c:out value="${f.getDirector()}"/></td>
			<td><c:out value="${f.getStars()}"/></td>
			<td><c:out value="${f.getReview()}"/></td>
			<td><button class='edit-btn' onclick='makeRowsEditable(this)' name="<c:out value='${f.getId()}'/>">Edit</button><button onclick='deleteRow(this)' class='delete-btn' name="<c:out value='${f.getId()}'/>">Delete</button></td>
		</tr>
			</c:forEach>
	</table>