<%-- 
    Document   : Permission
    Created on : 25 mai 2023, 10:09:06
    Author     : Yami Sukehiro
--%>

<%@page import="entite.Employer"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Permission</h3>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Nouveau. Permi
        </button>

        <!-- Modal -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nouveau Permission</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form>
                            <label for="permission" class="form-label">Permission</label>
                            <input type="text" name="permission" id="permission" class="form-control" required>
                            


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onclick="ajout()">Enregistrer</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>



<!-- update modal -->
<div class="row my-5">
    <div class="col-md-12">
        <!-- Button trigger modal -->
        <!--button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateMod">
            Nouveau. u
        </button-->

        <!-- Modal -->

        <div class="modal fade" id="updateMod" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modifier Employer</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form method="post" action="Em_Detail">
                            <input type="hidden" name="id" id="id1" value="${detailEm.id}">
                            <label for="nom" class="form-label">Nom</label>
                            <input type="text" name="nom" id="nom" class="form-control" required value="${detailEm.nom}">
                  
                        


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Enregistrer</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>

<!-- update modal -->


<input type="hidden" name="name" id="Emstat" value="${Emstat}">
<input type="hidden" name="status" value="${status}" id="status">
<div id="afficher"></div>

<!-- tableau -->
<div class="row" id="remplacer">
    <div class="card">
        
        <div class="card-body">
            
    
            <div class="table-responsive col-12">
                <table class="table table-striped data-table" id="myTable">
                    <thead>
                        <tr>
                            <th scope="col">Permission</th>
                           
                            <th></th>
                            
                            <!--th scope="col">Status</th-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${permi}" var="perm">
                            <tr>

                                <td>${perm.permission}</td>
                              
                                <!--td><img src="Deux-geishas-vêtus-de-kimono-japonais-traditionnel-au-milieu-du-temple-Sensoji-à-Asakusa-Tokyo-au-Japon.-755x504.jpg" alt="" style="width: 9%; "></td-->
                         
                                <td><a href="emSupp?id=${perm.id}" id="supprimer"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                    <a href="Em_Detail?id=${perm.id}"><i class="fa fa-edit" style="color: blue;"></i></a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

 
    

<!-- tableau -->


<script>
    function vider() {
        $("#permission").val("");
        $("#prenom").val("");
     


    }
    function ajout() {
        /*var nom = $("#nom").val();
         var prenom = $("#prenom").val();
         var date_naiss = $("#date_naiss").val();
         var situation = $("#situation").val();
         var adresse = $("#adresse").val();
         var num = $("#num").val();
         var email = $("#email").val();
         var sta = $("#sta").val();
         var motif = $("#motif").text();
         var genre = $("#genre").val();
         var date_eng= $("#date_eng").val();
         var foncion = $("#fonction").val();
         
         console.log(date_naiss);*/

        $.ajax({
            url: 'permInsert',
            type: 'post',
            /*data: {
             nom:nom,
             prenom:prenom,
             dateNaiss:date_naiss,
             situation:situation,
             adresse:adresse,
             num:num,
             email:email,
             sta:sta,
             motif:motif,
             genre:genre,
             dateEng:date_eng,
             fonction:fonction
             },*/
            data: $("form").serialize(),
            success: function (result) {
                console.log("success");
                vider();
                $("#remplacer").remove();
                $("#afficher").after(result);
                swal.fire("Succès !", " ", "success");

            }
        });
    }

    /*function delete(deletid){
     $.ajax({
     url:'emSupp',
     type:'post',
     data:deletid,
     success: function(result){
     $("#remplacer").remove();
     $("#afficher").after(result);
     }
     });
     }*/









</script>


<%@include file="Pied.jsp" %>                 

