<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
String message = (String) request.getAttribute("message");
%>


<t:genericpage>
	<h3>${ message  }</h3>
	<div class="btn-group">
		<a href="shop" class="btn btn-primary">Continue browsing</a>
	</div>
</t:genericpage>