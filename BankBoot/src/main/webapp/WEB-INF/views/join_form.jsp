<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>[ 회원정보 입력 ]</h3>
<form action="./join" method="post">
<table border="1">
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"></td>
	</tr>
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="password" id = "password"></td>
	</tr>
	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" id = "name"></td>
	</tr>
	<tr>
		<td><label for = "sex">성별 : </label></td>
		<td>
			<input type="radio" name="sex" value="male" id = "sex" checked>남
			<input type="radio" name="sex" value="female">여
		</td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" id = "age"></td>
	</tr>
	<tr>
		<td><label for = "email">이메일주소 : </label></td>
		<td><input type="text" name="email" id = "email"></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="가입">
			<input type="reset" value="다시 작성">
		</td>
	</tr>
</table>
</form>