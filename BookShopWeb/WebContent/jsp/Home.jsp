<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" 
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Book> books = (List<Book>) request.getAttribute("books");
%>

<t:genericpage>
	<h1>Index Page Here</h1>
	<table>
		<tbody>
			<c:forEach var="book" items="${ books }">
				<tr>
					<td>${ book.title }</td>
					
					<td><input type="button" value="Add to Cart"/></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
