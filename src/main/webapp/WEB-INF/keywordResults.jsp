<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>FilmsByKeyword</title>
</head>
<body>
<c:choose>
    <c:when test="${! empty films}">
	<c:forEach var="film" items="${films}">
		<ul>
			<li><a href= "findByFilmId.do?id=${film.id}">${film.title}</a></li>
			
			
		</ul>


	</c:forEach>
	</c:when>
    <c:otherwise>
      <p> Ruh roh no film found</p>
    </c:otherwise>
  </c:choose>


</body>
</html>