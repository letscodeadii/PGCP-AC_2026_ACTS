<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int a = 10;
	String name = "Aditya";

	int square() {
		return a * a;
	}%>


	<%
	out.println("a :" + a);
	out.println("Name : " + name);
	out.println(square());

	int b = 20;
	if (b < 100) {
		out.println("b is smaller than 100");
	} else {
		out.println("b is greater than 100");
	}
	for (int i = 1; i <= 5; i++) {
		out.println(i);
	}
	//String name=request.getParameter("");
	%>
	
	<%= a %>
	<%= name %>
	<%= square() %>
	
	<%= Math.random() %>
	
</body>
</html>