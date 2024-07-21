<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categories</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Categories</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="categoria" items="${categorias}">
                    <tr>
                        <td>${categoria.name}</td>
                        <td>
                            <form action="/categorias/add-producto" method="post">
                                <input type="hidden" name="categoriaId" value="${categoria.id}"/>
                                <select name="productoId" class="form-control">
                                    <c:forEach var="producto" items="${productos}">
                                        <option value="${producto.id}">${producto.name}</option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn btn-primary mt-2">Add Product</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
