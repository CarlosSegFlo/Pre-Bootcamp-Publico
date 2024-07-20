<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Dojo</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/agrega/ninja" method="post" modelAttribute="ninja">
        <div>
            <form:label path="dojo" class="detalle">Dojo:</form:label>
            <form:select path="dojo.id" class="detalle">
                <form:option value="" label="Select Dojo" />
                <c:forEach var="dojo" items="${dojos}">
                    <form:option value="${dojo.id}" label="${dojo.name}" />
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="firstName" class="detalle">First Name:</form:label>
            <form:input path="firstName" type="text" class="form-control"/>
            <form:errors path="firstName" class="alerta"/>
        </div>
        <div class="form-group">
            <form:label path="lastName" class="detalle">Last Name:</form:label>
            <form:input path="lastName" type="text" class="form-control"/>
            <form:errors path="lastName" class="alerta"/>
        </div>
        <div class="form-group">
            <form:label path="age" class="detalle">Age:</form:label>
            <form:input path="age" type="text" class="form-control"/>
            <form:errors path="age" class="alerta"/>
        </div>
        <button type="submit" class="btn btn-success">Create</button>
    </form:form>
</body>
</html>
