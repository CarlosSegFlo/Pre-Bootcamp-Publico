<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Dojo</title>
</head>
<body>
     <h1>New Dojo</h1>
        <form:form action="/agregar/dojo" method="post" modelAttribute="dojo">
            <div class="form-group">
                <form:label path="name" class="detalle">Name:</form:label>
                <form:input path="name" type="text" class="form-control" />
                <form:errors path="name" class="alerta" />
            </div>
            <button type="submit" class="btn btn-success">submit</button>
        </form:form>
</body>
</html>