<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="./deposit" method="post" id="deposit">
	<h3>[ 입금 ]</h3>
	<table border="1">
		<tr>
			<td>계좌번호</td>
			<td><input type="text" name="id" id="deposit_id" /></td>
		</tr>
		<tr>
			<td>입금액</td>
			<td><input type="text" name="money" id="deposit_money" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="입금" /></td>
		</tr>
	</table>
</form>