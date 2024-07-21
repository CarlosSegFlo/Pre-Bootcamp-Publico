<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Products</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}">
                    <tr>
                        <td>${producto.name}</td>
                        <td>${producto.price}</td>
                        <td>
                            <form action="/productos/add-categoria" method="post">
                                <input type="hidden" name="productoId" value="${producto.id}"/>
                                <select name="categoriaId" class="form-control">
                                    <c:forEach var="categoria" items="${categorias}">
                                        <option value="${categoria.id}">${categoria.name}</option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn btn-primary mt-2">Add Category</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
