<%@ page import="com.example.demo4.models.Results" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ServletContext servletContext = request.getServletContext();
  Results results = ((Results) servletContext.getAttribute("Collection"));
%>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Лабораторная работа №2 по веб-программированию</title>
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/style_error.css"/>
</head>
<body>

</body>
</html>