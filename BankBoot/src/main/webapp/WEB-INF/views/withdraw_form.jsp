<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="./withdraw" method="post" id="withdraw">
	<h3>[ 출금 ]</h3>
	<table border="1">
		<tr>
			<td>계좌번호</td>
			<td><input type="text" name="id" id="withdraw_id" /></td>
		</tr>
		<tr>
			<td>출금액</td>
			<td><input type="text" name="money" id="withdraw_money" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="출금" /></td>
		</tr>
	</table>
</form>