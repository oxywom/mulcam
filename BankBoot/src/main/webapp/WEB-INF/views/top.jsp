<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:choose>
	<c:when test="${sessionScope.id == null }">
		<a href="./login">Login</a>
	</c:when>
	<c:otherwise>
		<a href="./logout">Logout</a>
	</c:otherwise>
</c:choose>

<a href="./join">Join</a>
