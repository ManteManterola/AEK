<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!doctype html>
        <html class="bg-dark" lang="es">

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Matriculacion</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="stylesheet" href="style1.css">
        </head>

        <body class="bg-dark">
            <div>

                <div class="row">
                    <nav class="navbar bg-dark navbar-expand-lg ">
                        <div class="container-fluid">
                            <a href="landingPage.jsp"><img class="ms-3" src="imgs/logo-aek.png" width="30%" height="60%"
                                    alt="logo-aek"></a>
                        </div>
                    </nav>
                </div>

                <div class="row">


                    <c:if test="${msg=='insertOk'}">
                        <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
                            <strong>Ok!</strong> Alumno/s matriculados correctamente.
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>

                    <c:if test="${msg=='insertError'}">
                        <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
                            <strong>Error:</strong> Elige un curso para asignar a los alumnos y como minimo un alumno.
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>

                    <!-- Barra lateral -->

                    <aside class="col-2 text-center bg-dark">


                        <!-- Lista del resto de campos -->
                        <ul class="list-group">
                            <a href="IndexProfesores">
                                <li class="list-group-item hoverable"><span class="desaparece">Profesores</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                                        class="bi bi-mortarboard-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917z" />
                                        <path
                                            d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466z" />
                                    </svg></li>
                            </a>

                            <a href="IndexAlumnos">
                                <li class="list-group-item hoverable"><span class="desaparece">Alumnos</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                                        class="bi bi-person-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                                    </svg></li>
                            </a>
                            <a href="IndexSeguimientos">
                                <li class="list-group-item hoverable"><span class="desaparece">Seguimiento</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                                        class="bi bi-journal-bookmark-fill" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                            d="M6 1h6v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z" />
                                        <path
                                            d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2" />
                                        <path
                                            d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z" />
                                    </svg></li>
                            </a>

                            <a href="IndexProgramas">
                                <li class="list-group-item hoverable"><span class="desaparece">Programas</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                                        class="bi bi-book-half" viewBox="0 0 16 16">
                                        <path
                                            d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
                                    </svg></li>
                            </a>

                            <a href="IndexCursos">
                                <li class="list-group-item hoverable"><span class="desaparece">Cursos</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                                        class="bi bi-folder-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M9.828 3h3.982a2 2 0 0 1 1.992 2.181l-.637 7A2 2 0 0 1 13.174 14H2.825a2 2 0 0 1-1.991-1.819l-.637-7a2 2 0 0 1 .342-1.31L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3m-8.322.12q.322-.119.684-.12h5.396l-.707-.707A1 1 0 0 0 6.172 2H2.5a1 1 0 0 0-1 .981z" />
                                    </svg></li>
                            </a>

                            <a href="IndexHistoricos">
                                <li class="list-group-item hoverable"><span class="desaparece">Historico</span> <svg
                                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-award-fill" viewBox="0 0 16 16">
                                        <path
                                            d="m8 0 1.669.864 1.858.282.842 1.68 1.337 1.32L13.4 6l.306 1.854-1.337 1.32-.842 1.68-1.858.282L8 12l-1.669-.864-1.858-.282-.842-1.68-1.337-1.32L2.6 6l-.306-1.854 1.337-1.32.842-1.68L6.331.864z" />
                                        <path d="M4 11.794V16l4-1 4 1v-4.206l-2.018.306L8 13.126 6.018 12.1z" />
                                    </svg></li>
                            </a>

                        </ul>
                    </aside>


                    <div class="col-10 mt-2">
                        <form action="AsignarCurso" method=POST>
                            <!-- Atributos -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Inscribir</th>
                                        <th scope="col">Dni</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <!-- Datos -->


                                    <div>
                                        <p style="color: white">
                                            Curso al que se inscribiran los alumnos seleccionados <select
                                                name="idCurso">
                                                <option value=0></option>
                                                <c:forEach items="${cursos}" var="cursos">
                                                    <option ${cursos.id==alumno.curso.id ? 'selected' : '' }
                                                        value="${cursos.id}">${cursos.nivel}${cursos.turno}</option>
                                                </c:forEach>
                                            </select>
                                        </p>
                                    </div>
                                    <div>
                                        <c:forEach items="${alumnosNuevos}" var="alumnoNuevo">

                                            <tr>
                                                <td>
                                                    <div class="form-check">
                                                        <input class="form-check-input naranja" type="checkbox"
                                                            value="${alumnoNuevo.id}" id="flexCheckDefault"
                                                            name="alumnosSeleccionados[]"> <label
                                                            class="form-check-label" for="flexCheckDefault"> </label>
                                                    </div>
                                                </td>
                                                <td>${alumnoNuevo.dni}</td>
                                                <td>${alumnoNuevo.nombre}</td>
                                                <td>${alumnoNuevo.apellido}</td>

                                                <td></td>

                                            </tr>
                                        </c:forEach>
                                    </div>
                                    <div></div>


                        </form>
                        </tbody>

                        </table>

                        <button type="submit" class="btn naranja btn-warning ">
                            <strong>GUARDAR</strong>
                        </button>
                    </div>
                </div>

            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous">

                </script>
        </body>

        </html>