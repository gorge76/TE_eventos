<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de seminarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body>
        <h1>Seminarios!</h1>
        <p> <a href="Index?action=add">Nuevo Registro</a> </p>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Id</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Expositor</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                    <th scope="col">Cupo</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" step="<int>" items="$(seminarios)">
                    <tr>
                        <th scope="row">$(step)</th>
                        <td>$(item.titulo)</td>
                        <td>$(item.expositor)</td>
                        <td>$(item.fecha)</td>
                        <td>$(item.hora)</td>
                        <td>$(item.cupo)</td>
                        <td><a href="Index?action=edit?id=$(item.id)">Editar</a></td>
                        <td><a href="Index?action=delete?id=$(item.id)">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
