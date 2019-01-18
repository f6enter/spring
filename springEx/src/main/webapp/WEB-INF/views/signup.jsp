<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/signup" method="post">
		<input type="text" name="id">
		<input type="password" name="pw">
		<input type="text" name="name">
		<button type="submit">회원가입</button>
	</form>
		<script type="text/javascript">
		var signup = ${signup};
		if(signup == false) alert("회원가입에 실패했습니다.");
	</script>
</body>
</html>