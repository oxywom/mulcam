<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(function() {
	$('input[type=radio]').change(function() {
		if($(this).val()=='normal') {
			$('select').attr('disabled','disabled');
		} else {
			$('select').removeAttr('disabled');
		}
	});
});
</script>

<form action="./makeaccount" method="post" id="make_acc">
	<h3>[ 계좌개설 ]</h3>
	<table border="1">
		<tr>
			<td>계좌번호</td>
			<td><input type="text" name="id" id="make_id" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="make_name" /></td>
		</tr>
		<tr>
			<td>입금액</td>
			<td><input type="text" name="balance" id="make_money" /></td>
		</tr>
		<tr>
			<td>계좌구분</td>
			<td><input type="radio" value="normal" name="sect"
				checked="checked" /> 일반&nbsp;<input type="radio"
				value="special" name="sect" /> 특수</td>
		</tr>
		<tr>
			<td>등급</td>
			<td><select name="grade" class="in" disabled="disabled" >
					<option value="VIP">VIP</option>
					<option value="Gold">Gold</option>
					<option value="Silver">Silver</option>
					<option value="Normal">Normal</option>
			</select></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2"><input type="submit" value="개설" /></td>
		</tr>
	</table>
</form>