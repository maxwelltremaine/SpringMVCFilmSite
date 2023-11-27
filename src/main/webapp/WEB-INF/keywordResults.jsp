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
			<li>film id: ${film.id}</li>
			<li>film title: ${film.title}</li>
			<li>film description: ${film.description}</li>
			<li>film release year: ${film.releaseYear}</li>
			<li>film language id: ${film.languageId}</li>
			<li>film rental duration: ${film.rentalDuration}</li>
			<li>film rental rate: ${film.rentalRate}</li>
			<li>film length: ${film.length}</li>
			<li>film replacement cost: ${film.replacementCost}</li>
			<li>film rating: ${film.rating}</li>
			<li>film special features: ${film.specialFeatures}</li>
			<li>film rating: ${film.rating}</li>
			<li>film language: ${film.language}</li>
			<li>film category: ${film.category}</li>
			<li>film actors: ${film.actors}</li>
		</ul>


	</c:forEach>
	</c:when>
    <c:otherwise>
      <p> Ruh roh no film found</p>
    </c:otherwise>
  </c:choose>


</body>
</html>