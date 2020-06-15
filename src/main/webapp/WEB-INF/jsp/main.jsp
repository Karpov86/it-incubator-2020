<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <title>Main</title>
</head>
<body>
<h1 style="margin-left: 40%; margin-top: 5%">Main page</h1>
<p>Richest user: <c:out value="${requestScope.fullName} "/></p>
<p>Sum of accounts = <c:out value="${requestScope.sum}"/></p>
</body>
</html>
