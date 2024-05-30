<%-- 
    Document   : Login
    Created on : 11 mars 2023, 16:59:54
    Author     : Yami Sukehiro
--%>
<% if (session.getAttribute("name") != null){
	response.sendRedirect("affichage");
} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/moi.css">
    <script src="js/bootstrap.bundle.min.js"></script>
    <title>Trésor public</title>

    </style>
</head>
<body>
 <input type="hidden", id="status" value="<%= request.getAttribute("status") %>">
  <div class="wrapper">
    <div class="container main">
        <div class="row">
            <div class="col-md-6 side-image">
                <img src="Logo_tresor_Dame.png" alt="">
            </div>
            <div class="col-md-6 right">
                <div class="input-box">
                    <header>Connexion</header>
                    <form action="Login" method="post">
                    <div class="input-field">
                        <input type="text" class="input" id="email" required autocomplete="off" name="email">
                        <label for="email">Email</label>

                    </div>
                    <div class="input-field">
                        <input type="password" class="input" id="password" required name="password">
                        <label for="password">Mot de passe</label>

                    </div>
                    <div class="input-field">
                        <input type="submit" class="submit" id="password" value="Connexion">
                       
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
  </div>
 
    <script type="text/javascript" src="js/sweetalert2@11.js"></script>
    <script type="text/javascript">
	
            var status = document.getElementById("status").value;
            if(status == "failed"){
                    swal.fire("Désolé !", "Nom d'utilisateur ou mot de passe incorrect", "error");
            }
    </script>
</body>
</html>