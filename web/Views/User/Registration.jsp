<%-- 
    Document   : Registration
    Created on : 21 févr. 2023, 14:59:15
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="./Images/téléchargement (1).png"/>
        <link rel="stylesheet" href="../../Assets/css/bootstrap.min.css"/>
        <script src="../../Assets/js/bootstrap.bundle.min.js"></script>
        <script src="./Assets/js/sweetalert.min.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
      <input type="hidden" id="status" name="status" value="<%= request.getAttribute("status") %>">
        <form action="user" method="post" class="row g-3">
           
            <div class="col-md-4">
               
                <label for="nom" class="form-label">Nom</label>
                <input type="text" name="nom" id="nom" class="form-control" maxlength="15" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            
            <label for="prenom" class="form-label">Prenom</label>
            <input type="prenom" name="prenom" id="prenom" class="form-control" required>
            <label for="email" class="form-label">Email</label>
            <input type="email" name="email" id="email" class="form-control">
            <label for="password" class="form-label">Mot de passe</label>
            <input type="password" name="password" id="password" class="form-control" maxlength="8" value="fhjdfhjdf">
           
            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
     
            <%@include file="/Views/footer.jsp" %>
            <script>
                var status = document.getElementById("status").value;
                console.log(status);
                if(status == "success"){
                    swal("Félicitation !", "L'inscription a été un succès", "success");
                }else if(status == "email"){
                    swal("Désolé !", "Cette email est déjà utilisée.", "error");
                }
            </script>
    </body>
</html>
