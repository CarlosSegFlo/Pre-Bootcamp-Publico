<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Product</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Create New Product</h1>
        <form:form action="/productos" method="post" modelAttribute="producto">
            <div class="form-group">
                <form:label path="name">Name:</form:label>
                <form:input path="name" class="form-control"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <form:label path="price">Price:</form:label>
                <form:input path="price" class="form-control"/>
                <form:errors path="price" cssClass="text-danger"/>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form:form>
    </div>
</body>
</html>
