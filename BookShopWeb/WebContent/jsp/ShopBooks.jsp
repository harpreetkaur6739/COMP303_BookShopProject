<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Book> books = (List<Book>)request.getAttribute("books");
%>

<t:genericpage>
<h1>Books available for purchase</h1>
<table class="table table-hover">
<tbody>
		<c:forEach var="b" items="${ books }">
			<tr>
				<td>
					<ul style="list-style-type: none">
						<li><h3>${ b.getTitle() }</h3></li>
						<li>${ b.getDetail().getSummary() }</li>
						<li>Status: Available</li>
						<li>Price: ${b.getInventory().getPrice()} </li>
						<li><div class="btn-group">							
							<a href="shop?id=${ b.getBookId() }" class="btn btn-danger">Buy</a>
						</div></li>
					</ul>
				</td>
			</tr>				
		</c:forEach>
		</tbody>
</table>
</t:genericpage>