<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.History" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<History> history = (List<History>)request.getAttribute("history");
%>

<t:genericpage>
	<h1>History</h1>
	<hr />
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Book</th>
				<th>Date</th>
				<th>IP Address</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="h" items="${ history }">
				<tr>
					<td><a href="books/detail?id=${ h.getBook().getBookId()}">${ h.getBook().getTitle() }</a></td>
					<td>
						<fmt:formatDate value="${h.getDate()}" pattern="dd/MM/yyyy hh:mm:ss a" />
					</td>
					<td>${ h.getIp() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
