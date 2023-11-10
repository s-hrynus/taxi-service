<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Service Console: All Drivers</title>
</head>
<body>
    <%@include file="components/header.jsp"%>
    <div class="content">
        <h3><a href="${pageContext.request.contextPath}/cars"><- Cars</a> All Drivers</h3>
        <form style="display: flex; gap: 20px" method="post" action="${pageContext.request.contextPath}/drivers/add">
            <input type="text" placeholder="driver name" name="name" required/>
            <input type="text" placeholder="driver license number" name="license_number" required/>
            <button type="submit">add driver</button>
        </form>
        <ul class="driversList">
            <c:if test="${drivers.size() == 0}">
                <div>There are no drivers</div>
            </c:if>
            <c:if test="${drivers.size() != 0}">
                <c:forEach items="${drivers}" var="driver">
                    <li class="driversList__item" style="display: flex; gap: 5px;">
                        <span>
                            <c:out value="${driver.name}" />
                            -
                            <c:out value="${driver.licenseNumber}" />
                        </span>
                        <a href="${pageContext.request.contextPath}/drivers/delete?id=${driver.id}" style="margin-left:20px;">
                            delete
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</body>
</html>
