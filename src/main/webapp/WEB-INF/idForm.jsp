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
	<form action="findByFilmId.do" method="GET">
		ID: <input type="number" name="id" /> <input type="submit"
			value="Get film" />
	</form>

</body>
</html>