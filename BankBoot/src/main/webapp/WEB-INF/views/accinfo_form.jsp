<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="./accinfo" method="post" id="acc_info">
	<h3>[ 계좌조회 ]</h3>
	<table border="1">
		<tr>
			<td>계좌번호</td>
			<td><input type="text" name="id" id="acc_info_id" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="조회" /></td>
		</tr>
	</table>
</form>