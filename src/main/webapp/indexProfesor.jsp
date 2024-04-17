<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
    <!doctype html>
    <html lang="es">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Crud profesores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      </head>
      <body>
       
        <div class="container">
            <div class="row">
                <div class="col">
                    <a href="CreateProfesores">Crear</a>
                </div>
            </div>
            <div class="row">
                <div class="col">
					<!-- ${tareas} -->                    
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">id</th>
                            <th scope="col">dni</th>
                            <th scope="col">nombre</th>
                            <th scope="col">apellido</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${profesores}" var="profesor">
                          <tr>
                            <td>${profesor.id}</td>
                            <td>${profesor.dni}</td>
                            <td>${profesor.nombre}</td>
                            <td>${profesor.apellido}</td>
                            <td>
                            	<a href="ShowProfesores?id=${profesor.id}">Ver</a>
                            	<a href="EditProfesores?id=${profesor.id}">Modificar</a>
                            	<a href="DestroyProfesores?id=${profesor.id}">Eliminar</a>                            	
                            </td>
                          </tr>
                          </c:forEach>
                          
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
      </body>
    </html>