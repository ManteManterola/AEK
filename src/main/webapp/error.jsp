<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>error</title>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> -->
    <!--  <link rel="stylesheet" id="picostrap-styles-css" href="https://cdn.livecanvas.com/media/css/library/bundle.css" media="all"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/livecanvas-team/ninjabootstrap/dist/css/bootstrap.min.css" media="all">
    <link rel="stylesheet" href="style.css">

</head>

<body>

    <section class="py-6">
        <div class="container bg-light min-vh-50 py-6 d-flex justify-content-center align-items-center"
            style="max-width:1920px">
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="lc-block mb-4">
                        <div editable="rich">
                            <h1 class="fw-bold display-1">ERROR</h1>
                        </div>
                    </div>
                    <div class="lc-block">
                        <div editable="rich">
                            <p class="h2">Accion no permitida. </p>
                            <p class="lead">No puedes eliminar a un profesor que este impartiendo un curso.</p>
                        </div>
                    </div>
                    <div class="lc-block">
                        <a class="btn naranja btn-warning" href="IndexProfesores" role="button">Volver</a>
                    </div><!-- /lc-block -->
                </div><!-- /col -->
            </div>
        </div>
    </section>

    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>

</html>