<%-- 
    Document   : Employer
    Created on : 13 mars 2023, 09:00:01
    Author     : Yami Sukehiro
--%>

<%@page import="entite.Employer"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Employers</h3>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Nouveau. Emp
        </button>

        <!-- Modal -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nouveau Employer</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form>
                            <label for="nom" class="form-label">Nom</label>
                            <input type="text" name="nom" id="nom" class="form-control" required>
                            <label for="prenom" class="form-label">Prenom</label>
                            <input type="text" name="prenom" id="prenom" class="form-control" required>
                            <label for="date_naiss" class="form-label">Date de naissance</label>
                            <input type="date" name="date_naiss" id="date_naiss" class="form-control" required>
                            <label for="situation" class="form-label">Situation matrimonialle</label>
                            <select id="situation" name="situation" class="form-select">
                                <option value=""></option>
                                <option value="Marié(e)">Marié(e)</option>
                                <option value="Cébibataire">Célibataire</option>
                            </select>


                            <label for="adresse" class="form-label">Adresse</label>
                            <input type="text" name="adresse" id="adresse" class="form-control" required>
                            <label for="num" class="form-label">Numéro de téléphone</label>
                            <input type="number" name="num" id="num" class="form-control" required>
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" id="email" class="form-control" required max="30">
                            <% Connection con = Connexion.seConnecter();
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery("Select * from statu");
                            %>

                            <label class="form-label" for="sta">Statu</label>
                            <select id="sta" name="sta" class="form-select">
                                <option value=""></option>
                                <% while (rs.next()) {%>
                                <option value="<%=rs.getInt("Sat_Id")%>"><%=rs.getString("Status")%></option>
                                <%
                                    }
                                    rs.close();
                                    con.close();

                                %>
                            </select>
                            <label for="motif" class="form-label">Motif</label>
                            <textarea id="motif" name="motif" class="form-control"></textarea>
                            <label for="genre" class="form-label">Genre</label>
                            <% Connection con2 = Connexion.seConnecter();
                                Statement st2 = con2.createStatement();
                                ResultSet rs2 = st2.executeQuery("Select * from sexe");
                            %>
                            <select id="genre" class="form-select" name="genre">
                                <option value=""></option>
                                <% while (rs2.next()) {%>
                                <option value="<%=rs2.getString("Sexe")%>"><%=rs2.getString("Sexe")%></option>
                                <%
                                    }
                                    rs2.close();
                                    con2.close();

                                %>
                                <!--option value="Masculin">Masculin</option>
                                <option value="Féminin">Féminin</option-->
                            </select>
                            <label for="date_eng" class="form-label">Date d'engagement</label>
                            <input type="date" name="date_eng" id="date_eng" class="form-control" required>
                            <label for="fonction" class="form-label">Fonction</label>
                            <input type="text" name="fonction" id="fonction" class="form-control" required maxlength="20">


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
                            <label for="prenom" class="form-label">Prenom</label>
                            <input type="text" name="prenom" id="prenom" class="form-control" required value="${detailEm.prenom}">
                            <label for="date_naiss" class="form-label">Date de naissance</label>
                            <input type="date" name="date_naiss" id="date_naiss" class="form-control" required value="${detailEm.date_naiss}">
                            <label for="situation" class="form-label">Situation matrimonialle</label>
                            <select id="situation" name="situation" class="form-select" spellcheck="${detailEm.etat_civil}">
                                <option value=""></option>
                                <option value="Marié(e)">Marié(e)</option>
                                <option value="Cébibataire" selected>Célibataire</option>
                            </select>


                            <label for="adresse" class="form-label">Adresse</label>
                            <input type="text" name="adresse" id="adresse" class="form-control" required value="${detailEm.adresse}">
                            <label for="num" class="form-label">Numéro de téléphone</label>
                            <input type="tel" name="num" id="num" class="form-control" required value="${detailEm.contact}">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" id="email" class="form-control" required max="30" value="${detailEm.email}">
                            <% 
                                Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from statu");
                            %>

                            <label class="form-label" for="sta">Statu</label>
                            <select id="sta" name="sta" class="form-select">
                                <option value=""></option>
                                <% 
                                    if(session.getAttribute("detailEm")!=null){
                                    while (rs1.next()) {
                                    Employer em = (Employer) session.getAttribute("detailEm");
                                    if(rs1.getInt("Sat_Id")==em.getStatu_id()){%>
                                    <option value="<%=rs1.getInt("Sat_Id")%>" selected><%=rs1.getString("Status")%></option>
                                    <%
                                        }else{
                                %>
                                    
                                <option value="<%=rs1.getInt("Sat_Id")%>"><%=rs1.getString("Status")%></option>
                                <%
                                    }
                                    }
                                    rs1.close();
                                    con1.close();
                                    }
                                %>
                            </select>
                            <label for="motif" class="form-label">Motif</label>
                            <textarea id="motif" name="motif" class="form-control">${detailEm.motif}</textarea>
                            <input type="hidden" name="genred" id="genred" value="${detailEm.sexe}">
                            
                            <%
                                Connection con3 = Connexion.seConnecter();
                                Statement st3 = con3.createStatement();
                                ResultSet rs3 = st3.executeQuery("Select * from sexe");
                            %>
                            <label for="genres" class="form-label">Genre</label>
                            <select id="genres" class="form-select" name="genre">
                                
                                <option value=""></option>
                                 <% 
                                    if(session.getAttribute("detailEm")!=null){
                                    while (rs3.next()) {
                                    Employer em = (Employer) session.getAttribute("detailEm");
                                    if(rs3.getString("Sexe").equals(em.getSexe())){%>
                                    <option value="<%=rs3.getString("Sexe")%>" selected><%=rs3.getString("Sexe")%></option>
                                    <%
                                        }else{
                                %>
                                    
                                <option value="<%=rs3.getString("Sexe")%>"><%=rs3.getString("Sexe")%></option>
                                <%
                                    }
                                    }
                                    rs3.close();
                                    con3.close();
                                    }
                                %>
                                <!--option value="Masculin" selected>Masculin</option>
                                <option value="Féminin">Féminin</option-->
                            </select>
                            <label for="date_eng" class="form-label">Date d'engagement</label>
                            <input type="date" name="date_eng" id="date_eng" class="form-control" required value="${detailEm.date_eng}">
                            <label for="fonction" class="form-label">Fonction</label>
                            <input type="text" name="fonction" id="fonction" class="form-control" required maxlength="20" value="${detailEm.fonction}">


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
                            <th scope="col">Nom</th>
                            <th scope="col">Prénom</th>
                            <th scope="col">Fonction</th>
                            <th scope="col">Date d'entrée</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                            <!--th scope="col">Status</th-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employers}" var="empl">
                            <tr>

                                <td>${empl.nom}</td>
                                <td>${empl.prenom}</td>
                                <td>${empl.fonction}</td>
                                <td>${empl.date_eng}</td>
                                <!--td><img src="Deux-geishas-vêtus-de-kimono-japonais-traditionnel-au-milieu-du-temple-Sensoji-à-Asakusa-Tokyo-au-Japon.-755x504.jpg" alt="" style="width: 9%; "></td-->
                                <c:choose>
                                    <c:when test="${empl.statu.equals('En service')}">
                                        <td>${empl.statu}</td>
                                        <td><i class="fa fa-toggle-on" style="color: #31b131"></i></td>
                                        </c:when>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${empl.statu.equals('Suspendue')}">
                                        <td>${empl.statu}</td>
                                        <td><i class="fa fa-toggle-off" style="color: #565e64"></i></td>
                                        </c:when>
                                    </c:choose>
                                <td><a href="emSupp?id=${empl.id}" id="supprimer"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                    <a href="Em_Detail?id=${empl.id}"><i class="fa fa-edit" style="color: blue;"></i></a>
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
        $("#nom").val("");
        $("#prenom").val("");
        $("#date_naiss").val("");
        $("#situation").val("");
        $("#adresse").val("");
        $("#num").val("");
        $("#email").val("");
        $("#sta").val("");
        $("#motif").val("");
        $("#genre").val("");
        $("#date_eng").val("");
        $("#fonction").val("");


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
            url: 'employer',
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
