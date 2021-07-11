<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
a:link {text-align:center}
</style>

</head>
<body style=" background-color:powderblue;">

 

<h1 style="text-align:center; color:blue;"><c:out value ="${heading}"></c:out></h1><br>
<h2 style="text-align:center;"> <a href="cars">Add Car</a><br>
<a href="cars/all">View Car</a><br>
<a href="cars/findAll">View Available Cars</a><br>
<a href="cars/showByBrand"> Show Cars By Brand</a></h2>

 


</body>
</html>