<%--
  Created by IntelliJ IDEA.
  Date: 2017/3/14
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="jumbotron">
        <c:if test="${not empty resultMsg}">
            <h1>${resultMsg}！</h1>
        </c:if>

    </div>
</div>
</body>
</html>
