<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seminario</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    </head>
    <body>
        <h1>
            <c:if test="$(seminario.id)==0">Nuevo</c:if>
            <c:if test="$(seminario.id)!=0">Editar</c:if>
            Seminario
        </h1>
        <form class="needs-validation" novalidate action="Index" method="POST">
            <input type="hidden" class="hidden" id="id" name="id" value="$(seminario.id)" hidden>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Título</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" value="$(seminario.titulo)" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Expositor</label>
                    <input type="text" class="form-control" id="expositor" name="expositor" value="$(seminario.expositor)" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Fecha</label>
                    {{-- <input type="date" class="form-control" id="date" name="date" value="$(seminario.date)" required> --}}
                    <input type="text" class="form-control" id="date" name="date" value="$(seminario.date)" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Hora</label>
                    <input type="text" class="form-control" id="hora" name="hora" value="$(seminario.hora)" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Cupo</label>
                    <input type="text" class="form-control" id="cupo" name="cupo" value="$(seminario.cupo)" required>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Guardar</button>
        </form>
    </body>
</html>
