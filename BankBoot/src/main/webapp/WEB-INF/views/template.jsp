<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multicampus Bank</title>
<style>
	#header {
		margin: 20px auto 0 auto;
		width:958px; height:60px;		
		text-align: center;
		line-height : 60px;
		background-color: #b5818f;
	}
	#table {
		margin:0 auto;
		width:960px; height:500px;
		color:gray;
		/* border:1px solid gray; */
	}
	#table #top {
		background-color: #b5818f;
		height:43px;
		text-align : right;
		padding-right: 10px;
	}
	#table #left {
		background-color: silver;
		width : 15%;
		align : center;
		valign : top;
	}
	#table #right {
		background-color: #bcab8f;
		margin: 0 auto;
		padding-top:20px;
	}
	#table #bottom {
		background-color: #8ea201;
		width : 100%;
		height : 43px; 
	}		
	
	
</style>

</head>
<body>
<h2 id="header">멀티캠퍼스 은행</h2>
<table id="table">
	<tr><td id="top" colspan="3" ><jsp:include page="top.jsp"/></td></tr>
	<tr>
		<td id="left"><br>
			<jsp:include page="left.jsp"/></td>
		<td id="right" colspan="2" align="center" valign="top">
			<jsp:include page='${page }.jsp'/></td>
	</tr>
	<tr>
		<td id="bottom" colspan="3">
			<jsp:include page="bottom.jsp"/></td>
	</tr>
</table>
</body>
</html>