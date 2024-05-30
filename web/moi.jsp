<%-- 
    Document   : moi
    Created on : 8 mars 2023, 19:09:05
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/datatables.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <!-- bar de navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
            <div class="container-fluid">
                <!-- offcanvas triggered -->
                <button class="navbar-toggler me-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                    <span class="navbar-toggler-icon" data-bs-target="#offcanvasExample"></span>
                </button>
                <!-- offcanvas triggered -->
                <a class="navbar-brand me-auto" href="#"><img src="téléchargement (1).png" alt="" style="width: 9%; ">    Tresor Public</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
           
                <form class="d-flex ms-auto">
                    <div class="input-group my-3 my-md-0">
                        <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
                        <button class="btn btn-dark" type="button" id="button-addon2">Button</button>
                    </div>
                </form>
                <ul class="navbar-nav mb-2 mb-lg-0">
                   
                   
                    <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-user"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                    </li>
                   
                </ul>
                
                </div>
            </div>
        </nav>

    <!-- bar de navigation -->

    <!-- offcane -->
       
       
        
        <div class="offcanvas offcanvas-start bg-primary text-white sidebar-nav" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
            
            <div class="offcanvas-body p-0">
                <nav class="navbar-dark">
                    <ul class="navbar-nav">
                        <li>
                            <div class="px-3 small">
                                Core
                            </div>
                        </li>
                        <li>
                            <a href="" class="nav-link px-3 active">
                                <span class="me-2">
                                    <i class="fas fa-home fa-fw"></i>
                                </span>
                                <span>Acceuil</span>
                            </a>
                        </li>
                        <li class="my-4">
                            <hr class="dropdown-divider">
                        </li>
                        <li>
                            <div class="px-3 small">
                                Core
                            </div>
                        </li>
                        <li>
                            <a class="nav-link px-3 sidebar-link active" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                <span class="me-2">
                                    <i class="fa fa-stroopwafel"></i>
                                </span>
                                <span>Affichage</span>
                                <span class="right-icon ms-auto">
                                    <i class="fa fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="collapse" id="collapseExample">
                                <div>
                                  <ul class="navbar-nav ps-3">
                                    <li>
                                        <a href="" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Affichage</span>
                                        </a>
                                    </li>

                                  </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </nav>
         
            </div>
        </div>

    <!-- offcane -->
    <main class="mt-5 pt-3">
        <div class="container-fluid">
            
        </div>
    </main>
        



    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/chart.min.js"></script>
    <script src="js/datatables.min.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>
