<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>films</h3>
	<form action="findByKeyword.do" method="GET">
		Keyword: <input type="text" name="keyword" /> <input type="submit"
			value="Get films" />
	</form>
</body>
</html>