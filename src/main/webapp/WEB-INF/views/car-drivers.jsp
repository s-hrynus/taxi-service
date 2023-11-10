<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Service Console: ${car.model} drivers</title>
</head>
<body>
    <%@include file="components/header.jsp"%>


    <div class="content">
        <h3><a href="${pageContext.request.contextPath}/cars"><- Cars</a> Drivers for ${car.model}</h3>
        <c:if test="${drivers.size() == 0}">
            <div>No drivers available</div>
        </c:if>
        <c:if test="${drivers.size() != 0}">
            <form style="display: flex; gap: 20px" method="post" action="${pageContext.request.contextPath}/cars/drivers/add">
                <select name="driver_id">
                    <c:forEach items="${drivers}" var="driver">
                        <option value="${driver.id}">
                            <c:out value="${driver.name}" />
                            -
                            <c:out value="${driver.licenseNumber}" />
                        </option>
                    </c:forEach>
                </select>
                <input type="hidden" value="${car.id}" name="car_id" />
                <button type="submit">add driver</button>
            </form>
        </c:if>
        <ul class="driversList">
            <c:if test="${car.drivers.size() == 0}">
                <div>The car has no drivers</div>
            </c:if>
            <c:if test="${car.drivers.size() != 0}">
                <c:forEach items="${car.drivers}" var="driver">
                    <li class="driversList__item" style="display: flex; gap: 5px;">
                        <span>
                            <c:out value="${driver.name}" />
                            -
                            <c:out value="${driver.licenseNumber}" />
                        </span>
                        <a href="${pageContext.request.contextPath}/cars/drivers/delete?driverId=${driver.id}&carId=${car.id}"
                            style="margin-left:20px;">delete</a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</body>
</html>
