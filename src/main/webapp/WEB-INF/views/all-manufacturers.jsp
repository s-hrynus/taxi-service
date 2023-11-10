<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Service Console: All Manufacturers</title>
</head>
<body>
<%@include file="components/header.jsp"%>
<div class="content">
    <h3><a href="${pageContext.request.contextPath}/cars"><- Cars</a> All Manufacturers</h3>
    <ul class="manufacturersList">
        <c:if test="${manufacturers.size() == 0}">
            <div>There are no manufacturers</div>
        </c:if>
        <c:if test="${manufacturers.size() != 0}">
            <c:forEach items="${manufacturers}" var="manufacturer">
                <li class="manufacturersList__item" style="display: flex; gap: 5px;">
                    <span>
                        <c:out value="${manufacturer.name}" />
                        -
                        <c:out value="${manufacturer.country}" />
                    </span>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</div>
</body>
</html>

