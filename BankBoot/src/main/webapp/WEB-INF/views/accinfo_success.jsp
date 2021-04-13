<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.mulcam.bank.vo.Account" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<h3>[ 계좌 조회 ]</h3>
<table border="1">
	<tr>
		<td>계좌번호</td><td>${acc.id }</td>
	</tr>
	<tr>
		<td>이름</td><td>${acc.name }</td>
	</tr>
	<tr>
		<td>잔액</td><td>${acc.balance }</td>
	</tr>
	<tr>
		<td>계좌구분</td><td>${acc.sect }</td>
	</tr>
	<c:if test="{acc.sect=='special'}">
		<tr><td>등급</td><td>${acc.grade}</td></tr>
	</c:if>
</table>		
