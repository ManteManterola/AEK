<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alumnos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style1.css">
</head>

<body class="bg-light-subtle">
    <div class="container-fluid">

        <div class="row">
            <nav class="navbar bg-dark navbar-expand-lg ">
                <div class="container-fluid">
                    <a href="landingPage.jsp"><img src="imgs/logo-aek.png" width="30%" height="60%" alt="logo-aek"></a>


                    <!-- Boton de matriculacion -->

                  <a class="btn btn-outline-warning" href="IndexMatriculas"> MATRICULAR</a>

                    <div class="modal fade" id="modalAlumnos" aria-hidden="true"
                        aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="modalAlumnos">Alumnos sin
                                        matricular</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <table class="table">

                                        <tr>

                                            <th scope="col">Dni</th>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Apellido</th>
                                            <th scope="col">Matricular</th>
                                            <th></th>
                                        </tr>

                                        <!-- Datos -->
                                        <c:forEach items="${alumnosNuevos}" var="alumnoNuevo">
                                            <tr>

                                                <td>${alumnoNuevo.dni}</td>
                                                <td>${alumnoNuevo.nombre}</td>
                                                <td>${alumnoNuevo.apellido}</td>

                                                <td>
                                                
                                                <form action="AsignCurso" method=post>
                                                    <p>
                                                        <select name="idCurso">
                                                            <option value=0></option>
                                                            <c:forEach items="${cursos}" var="cursos">
                                                                <option ${cursos.id==alumno.curso.id ? 'selected' : '' }
                                                                    value="${cursos.id}">${cursos.nivel}
                                                                    ${cursos.turno}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </p>

												</form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="modal-footer">

                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn naranja btn-warning ">Guardar</button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
    <!-- fin modalCursos -->


    <div class="row">

        <!-- Barra lateral -->
        <aside class="col-2 bg-dark text-center">


            <!-- Lista del resto de campos -->
            <ul class="list-group">
                <a href="IndexProfesores">
                    <li class="list-group-item hoverable"><span class="desaparece">Profesores</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                            class="bi bi-mortarboard-fill" viewBox="0 0 16 16">
                            <path
                                d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917z" />
                            <path
                                d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466z" />
                        </svg>
                    </li>
                </a>



                <a href="IndexAlumnos">
                    <li class="list-group-item activo"><span class="desaparece">Alumnos</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                            class="bi bi-person-fill" viewBox="0 0 16 16">
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                        </svg>
                    </li>
                </a>
                <a href="IndexSeguimientos">
                    <li class="list-group-item hoverable"><span class="desaparece">Seguimiento</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                            class="bi bi-journal-bookmark-fill" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                d="M6 1h6v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z" />
                            <path
                                d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2" />
                            <path
                                d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z" />
                        </svg>
                    </li>
                </a>

                <a href="IndexProgramas">
                    <li class="list-group-item hoverable"><span class="desaparece">Programas</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                            class="bi bi-book-half" viewBox="0 0 16 16">
                            <path
                                d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
                        </svg>
                    </li>
                </a>

                <a href="IndexCursos">
                    <li class="list-group-item hoverable"><span class="desaparece">Cursos</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor"
                            class="bi bi-folder-fill" viewBox="0 0 16 16">
                            <path
                                d="M9.828 3h3.982a2 2 0 0 1 1.992 2.181l-.637 7A2 2 0 0 1 13.174 14H2.825a2 2 0 0 1-1.991-1.819l-.637-7a2 2 0 0 1 .342-1.31L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3m-8.322.12q.322-.119.684-.12h5.396l-.707-.707A1 1 0 0 0 6.172 2H2.5a1 1 0 0 0-1 .981z" />
                        </svg>
                    </li>
                </a>

                <a href="IndexHistoricos">
                    <li class="list-group-item hoverable"><span class="desaparece">Historico</span>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-award-fill" viewBox="0 0 16 16">
                            <path
                                d="m8 0 1.669.864 1.858.282.842 1.68 1.337 1.32L13.4 6l.306 1.854-1.337 1.32-.842 1.68-1.858.282L8 12l-1.669-.864-1.858-.282-.842-1.68-1.337-1.32L2.6 6l-.306-1.854 1.337-1.32.842-1.68L6.331.864z" />
                            <path d="M4 11.794V16l4-1 4 1v-4.206l-2.018.306L8 13.126 6.018 12.1z" />
                        </svg>
                    </li>
                </a>

            </ul>
        </aside>

        <div class="col-10 mt-2">

            <!-- boton crear Alumno -->
            <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#crearAlumno">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                    class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                    <path
                        d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0" />
                </svg>
            </button>

            <div class="modal fade" id="crearAlumno" tabindex="-1" aria-labelledby="createModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Creacion</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="StoreAlumnos" method="post">
                                <p>
                                    DNI: <input type="text" name="dni" />
                                </p>
                                <p>
                                    Nombre: <input type="text" name="nombre" />
                                </p>
                                <p>
                                    Apellido: <input type="text" name="apellido" />
                                </p>
                                <p>
                                    Edad: <input type="number" name="edad" />
                                </p>


                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn naranja btn-warning">Guardar</button>
                                </div>

                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <!-- Atributos -->
            <table class="table">
                <thead>
                    <tr>
                        <th scope="">Id</th>
                        <th scope="col">Dni</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Curso</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <!-- Datos -->
                    <c:forEach items="${alumnos}" var="alumno">
                        <tr>
                            <td>${alumno.id}</td>
                            <td>${alumno.dni}</td>
                            <td>${alumno.nombre}</td>
                            <td>${alumno.apellido}</td>
                            <td>${alumno.edad}</td>
                            <td>${alumno.curso.nivel}</td>
                            <td>
                                <!-- boton ver -->
                                <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                    data-bs-target="#verAlumno${alumno.id}">

                                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                        class="bi bi-eye-fill" viewBox="0 0 16 16">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
                                        <path
                                            d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
                                    </svg>

                                </button>

                                <div class="modal fade" id="verAlumno${alumno.id}" tabindex="-1"
                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Visualizacion</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">

                                                <ul class="list-group list-group-flush">

                                                    <li class="list-group-item"><strong>DNI:</strong>
                                                        ${alumno.dni}</li>
                                                    <li class="list-group-item"><strong>Nombre:</strong>
                                                        ${alumno.nombre}</li>
                                                    <li class="list-group-item"><strong>Apellido:</strong>
                                                        ${alumno.apellido}</li>
                                                    <li class="list-group-item"><strong>Edad:</strong>
                                                        ${alumno.edad}</li>
                                                    <li class="list-group-item"><strong>Curso:</strong>
                                                        ${alumno.curso.nivel} | ${alumno.curso.turno}</li>

                                                </ul>
                                            </div>

                                        </div>
                                    </div>
                                </div> 
                                
                                <!-- boton editar -->

                                <button type="button" class="btn btn-light" data-bs-toggle="modal"
                                    data-bs-target="#editarAlumno${alumno.id}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                        class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path
                                            d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                                        <path fill-rule="evenodd"
                                            d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z" />
                                    </svg>
                                </button>

                                <div class="modal fade" id="editarAlumno${alumno.id}" tabindex="-1"
                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="editarModal">Modificar</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="UpdateAlumnos" method="POST">
                                                    <input type="hidden" name="id" value="${alumno.id}" />
                                                    <p class="mb-0">DNI:</p>
                                                    <input type="text" name="dni" value="${alumno.dni}" />

                                                    <p class="mb-0">Nombre:</p>
                                                    <input type="text" name="nombre" value="${alumno.nombre}" />

                                                    <p class="mb-0">Apellido :</p>
                                                    <input type="text" name="apellido" value="${alumno.apellido}" />

                                                    <p class="mb-0">Edad :</p>
                                                    <input type="number" name="edad" value="${alumno.edad}" />

                                                    <p>
                                                        Curso: 
                                                        <select name="idCurso">
                                                            <option value=0></option>
                                                            <c:forEach items="${cursos}" var="cursos">
                                                                <option ${cursos.id==alumno.curso.id ? 'selected' : '' }
                                                                    value="${cursos.id}">${cursos.nivel}
                                                                    ${cursos.turno}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </p>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Cerrar</button>
                                                        <button type="submit"
                                                            class="btn naranja btn-warning ">Guardar</button>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div> 
                                
                                <!-- boton eliminar --> 
                                
                                <a class="btn btn-light"
                                    href="DestroyAlumnos?id=${alumno.id}"><svg xmlns="http://www.w3.org/2000/svg"
                                        width="25" height="25" fill="currentColor" class="bi bi-backspace-reverse"
                                        viewBox="0 0 16 16">
                                        <path
                                            d="M9.854 5.146a.5.5 0 0 1 0 .708L7.707 8l2.147 2.146a.5.5 0 0 1-.708.708L7 8.707l-2.146 2.147a.5.5 0 0 1-.708-.708L6.293 8 4.146 5.854a.5.5 0 1 1 .708-.708L7 7.293l2.146-2.147a.5.5 0 0 1 .708 0" />
                                        <path
                                            d="M2 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h7.08a2 2 0 0 0 1.519-.698l4.843-5.651a1 1 0 0 0 0-1.302L10.6 1.7A2 2 0 0 0 9.08 1zm7.08 1a1 1 0 0 1 .76.35L14.682 8l-4.844 5.65a1 1 0 0 1-.759.35H2a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1z" />
                                    </svg> </a>
                            </td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">

        </script>
    <script src="javaScript.js"></script>
</body>

</html>