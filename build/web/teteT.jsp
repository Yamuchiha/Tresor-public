<%-- 
    Document   : teteT
    Created on : 25 mars 2023, 06:41:43
    Author     : Yami Sukehiro
--%>

<% 
	if(session.getAttribute("name") == null){
		response.sendRedirect("Login");
	}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/select2.min.css"/>
    <title>Trésor public</title>
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
                        <!--input type="text" class="form-control" placeholder="recherche" aria-label="Recipient's username" aria-describedby="button-addon2" id="myInput" onkeyup="myFunction()">
                        <button class="btn btn-dark" type="button" id="button-addon2"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div-->
                </form>
                <ul class="navbar-nav mb-2 mb-lg-0">
                   
                   
                    <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-user"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">${name.us_prenom}</a></li>
                        <!--li><a class="dropdown-item" href="#">Mon compte</a></li-->
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="Logout">Deconnexion</a></li>
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
                        <c:if test="${name.us_role.equals('Admin')}">
                        <li>
                            <div class="px-3 small">
                                Table
                            </div>
                        </li>
                        <li>
                            <a class="nav-link px-3 sidebar-link active" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                <span class="me-2">
                                    <i class="fa fa-eye"></i>
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
                                        <a href="emAcceuil" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Employer</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="depAffAcceuil" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Departement</span>
                                        </a>
                                    </li>

                                  </ul>
                                </div>
                            </div>
                        </li>
                        <li class="my-4">
                            <hr class="dropdown-divider">
                        </li>
                         <li>
                            <div class="px-3 small">
                                Action
                            </div>
                        </li>
                        <li>
                            <a class="nav-link px-3 sidebar-link active" data-bs-toggle="collapse" href="#collapseEx" role="button" aria-expanded="false" aria-controls="collapseExample">
                                <span class="me-2">
                                     <i class="fas fa-spinner fa-pulse"></i>
                                </span>
                                <span>Traitement</span>
                                <span class="right-icon ms-auto">
                                    <i class="fa fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="collapse" id="collapseEx">
                                <div>
                                  <ul class="navbar-nav ps-3">
                                    <li>
                                        <a href="formAffect" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Nouvelle affectation</span>
                                        </a>
                                    </li>
                                     <li>
                                        <a href="affAffiche" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Liste des affectations</span>
                                        </a>
                                    </li>
                                      <!--li>
                                        <a href="formAffPrendre" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <!--span class="px-3">Attribution de congé</span>
                                        </a>
                                    </li-->
                                    
                                    <!--li>
                                        <a href="prendreAffiche" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <!--span class="px-3">Liste des congés attribués</span>
                                        </a>
                                    </li-->
                                     <li>
                                        <a href="FormUtilisateur" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Nouveau utilisateur</span>
                                        </a>
                                    </li>
                                       <li>
                                        <a href="utiAffiche" class="nav-link px-3">
                                            <!-- <span class="me-2">
                                                <i class="fa fa-stroopwafel"></i>
                                            </span> -->
                                            <span class="px-3">Liste des utilisateurs</span>
                                        </a>
                                    </li>

                                  </ul>
                                </div>
                            </div>
                        </li>
                        <li class="my-4">
                            <hr class="dropdown-divider">
                        </li>
                        <li>
                            <div class="px-3 small">
                                Requête
                            </div>
                        </li>
                          <li>
                            <a class="nav-link px-3 sidebar-link active" data-bs-toggle="collapse" href="#colla" role="button" aria-expanded="false" aria-controls="collapseExample">
                                <span class="me-2">
                                    <i class="fas fa-check-square"></i>
                                </span>
                                <span>Validation</span>
                                <span class="right-icon ms-auto">
                                    <i class="fa fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="collapse" id="colla">
                                <div>
                                  <ul class="navbar-nav ps-3">
                                    <li>
                                        <a href="valAffEn" class="nav-link px-3">
                                          
                                            <span class="px-3">Requêtes en cour</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="valAffVal" class="nav-link px-3">
                                            
                                            <span class="px-3">Requêtes validées</span>
                                        </a>
                                    </li>
                                    
                                    <li>
                                        <a href="valAffRef" class="nav-link px-3">

                                            <span class="px-3">Requêtes refusées</span>
                                        </a>
                                    </li>
                                  </ul>
                                </div>
                            </div>
                        </li>
                        </c:if>
                        <c:if test="${name.us_role.equals('User')}">
                        <li>
                            <div class="px-3 small">
                                Moi
                            </div>
                        </li>
                        <li>
                            <a href="demAff" class="nav-link px-3 active">
                                <span class="me-2">
                                    <i class="fas fa-home fa-fw"></i>
                                </span>
                                <span>Utilisateur</span>
                            </a>
                        </li>
                        </c:if>
                    </ul>
                </nav>
         
            </div>
        </div>

    <!-- offcane -->
    <main class="mt-5 pt-3">
        <div class="container-fluid">
