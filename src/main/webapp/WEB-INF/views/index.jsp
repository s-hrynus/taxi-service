<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Service Console: Cars</title>
</head>
<body>
    <%@include file="components/header.jsp"%>
    <div class="content">
        <h3 style="display: flex;">
            <span>Cars</span>
            <a href="${pageContext.request.contextPath}/drivers" style="margin-left: auto;">Drivers</a>
        </h3>
        <div class="topContainer">
            <c:if test="${manufacturers.size() == 0}">
                <div>Add at least one manufacture to add car</div>
            </c:if>
            <c:if test="${manufacturers.size() != 0}">
                <form style="display: flex; gap: 20px" method="post" action="${pageContext.request.contextPath}/cars/add">
                    <input type="text" placeholder="model" name="model" required />
                    <select name="manufacturer_id">
                        <c:forEach items="${manufacturers}" var="manufacturer">
                            <option value="${manufacturer.id}">
                                <c:out value="${manufacturer.name}" />
                                -
                                <c:out value="${manufacturer.country}" />
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit">add car</button>
                </form>
            </c:if>
            <form style="display: flex; gap: 20px" method="post" action="${pageContext.request.contextPath}/manufacturers/add">
                <input type="text" placeholder="manufacturer name" name="name" required/>
                <input type="text" placeholder="manufacturer country" name="country" required/>
                <button type="submit">add manufacturer</button>
            </form>
            <c:if test="${manufacturers.size() == 0}">
                <div>Add at least one manufacture to remove</div>
            </c:if>
            <c:if test="${manufacturers.size() != 0}">
                <form style="display: flex; gap: 20px" method="post" action="${pageContext.request.contextPath}/manufacturers/delete">
                    <select name="manufacturer_id">
                        <c:forEach items="${manufacturers}" var="manufacturer">
                            <option value="${manufacturer.id}">
                                <c:out value="${manufacturer.name}" />
                                -
                                <c:out value="${manufacturer.country}" />
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit">delete manufacturer</button>
                </form>
            </c:if>
        </div>
        <p><a href="${pageContext.request.contextPath}/manufacturers">See all manufacturers</a></p>
        <ul class="carsList">
            <c:if test="${cars.size() == 0}">
                <div>No available cars</div>
            </c:if>
            <c:if test="${cars.size() != 0}">
                <c:forEach items="${cars}" var="car">
                    <li class="carsList__item" style="display: flex; gap: 5px;">
                        <span>
                            <c:out value="${car.id}" />.
                            <c:out value="${car.model}" />
                        </span>
                        <span><i><c:out value="${car.manufacturer.name}" /></i></span>
                        <span><a href="${pageContext.request.contextPath}/cars/drivers?carId=${car.id}">See drivers</a></span>
                        <a href="${pageContext.request.contextPath}/cars/delete?id=${car.id}" style="margin-left:auto;">delete</a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </div>
</body>
</html>
