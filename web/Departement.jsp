<%-- 
    Document   : Departement
    Created on : 15 mars 2023, 15:51:43
    Author     : Yami Sukehiro
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="entite.Departement"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Tete.jsp" %>
<div class="row my-5">
    <div class="col-md-12 text-center my-3">
        <h3>Departements</h3>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Nouveau. Dep
        </button>

        <!-- Modal -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nouveau Departement</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form>
                            <label for="nom" class="form-label">Nom du Departement</label>
                            <input type="text" name="nom" id="nom" class="form-control" required>
                            <label for="abr" class="form-label">Abréviation</label>
                            <input type="text" name="abr" id="abr" class="form-control" required>
                            <label for="date_cre" class="form-label">Date de création</label>
                            <input type="date" name="date_cre" id="date_cre" class="form-control" required>
                            
                            <% Connection con = Connexion.seConnecter();
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery("Select * from departement");
                            %>

                            <label class="form-label" for="parent">Departement Parent</label>
                            <select id="parent" name="parent" class="form-select">
                                <option value="0"></option>
                                <option value="0">Pas d'entité parent</option>
                                <% while (rs.next()) {%>
                                <option value="<%=rs.getInt("Dep_Id")%>"><%=rs.getString("Dep_Nom")%></option>
                                <%
                                    }
                                    rs.close();
                                    con.close();

                                %>
                            </select>

                            <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from type");
                            %>

                            <label class="form-label" for="type">Type</label>
                            <select id="type" name="type" class="form-select">
                                <option value=""></option>
                                <% while (rs1.next()) {%>
                                <option value="<%=rs1.getInt("Type_Id")%>"><%=rs1.getString("Type_Nom")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con.close();

                                %>
                            </select>



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
            Nouveau. mod
        </button-->

        <!-- Modal -->

        <div class="modal fade" id="updateMod" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modifier Departement</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form method="post" action="depDetail">
                            <input type="hidden" name="id1" id="id1" value="${dep.dep_id}">
                            <label for="nom" class="form-label">Nom du Departement</label>
                            <input type="text" name="nom" id="nom" class="form-control" required value="${dep.dep_nom}">
                            <label for="abr" class="form-label">Abréviation</label>
                            <input type="text" name="abr" id="abr" class="form-control" required value="${dep.dep_abr}">
                            <label for="date_cre" class="form-label">Date de création</label>
                            <input type="date" name="date_cre" id="date_cre" class="form-control" required value="${dep.dep_date}">

                            <% Connection con4 = Connexion.seConnecter();
                                Statement st4 = con4.createStatement();
                                ResultSet rs4 = st4.executeQuery("Select * from departement");
                            %>

                            <label class="form-label" for="parent">Departement Parent</label>
                            <select id="parent" name="parent" class="form-select" selected="${dep.dep_id_par}">
                                
                                <option value="0">Pas d'entité parent</option>
                                <%
                                 if(session.getAttribute("dep")!=null){
                                 while (rs4.next()) {
                                Departement dep = (Departement) session.getAttribute("dep");
                                    if(rs4.getInt("Dep_Id")== dep.getDep_id_par()){%>
                                    <option value="<%=rs4.getInt("Dep_Id")%>" selected><%=rs4.getString("Dep_Nom")%></option>
                                    <%
                                        }else{
                                %>
                                <option value="<%=rs4.getInt("Dep_Id")%>"><%=rs4.getString("Dep_Nom")%></option>
                                <%
                                    }
                                    }
                                    rs.close();
                                    con.close();
                                    }
                                %>
                            </select>

                            <% Connection con5 = Connexion.seConnecter();
                                Statement st5 = con5.createStatement();
                                ResultSet rs5 = st5.executeQuery("Select * from type");
                            %>

                            <label class="form-label" for="type">Type</label>
                            <select id="type" name="type" class="form-select" selected="${dep.type_id}">
                                
                                <% if(session.getAttribute("dep")!=null){
                                    while (rs5.next()) {
                                    Departement dep1 = (Departement)session.getAttribute("dep");
                                   if (rs5.getInt("Type_ID") == dep1.getType_id()) {%>
                                   <option value="<%=rs5.getInt("Type_Id")%>" selected><%=rs5.getString("Type_Nom")%></option>
                                <%
                                    }else{

                                %>
                                <option value="<%=rs5.getInt("Type_Id")%>"><%=rs5.getString("Type_Nom")%></option>
                                <%
                                    }
                                    }
                                    rs5.close();
                                    con5.close();
                                    }
                                %>
                            </select>



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
        <table class="table table-striped data-table">
            <thead>
                <tr>
                    <th scope="col">Departement</th>
                    <th scope="col">Abréviation</th>
                    <th scope="col">Date de Création</th>
                    <th scope="col">Parent</th>
                    <th scope="col">Type</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>

                <% Connection con2 = Connexion.seConnecter();
                    Statement st2 = con2.createStatement();
                    ResultSet rs2 = st2.executeQuery("select * from departement inner join type on departement.Type_Id=type.Type_Id");
                    
                    while(rs2.next()) {%>
                <tr>

                    <td><%=rs2.getString("departement.Dep_Nom")%></td>
                    <td><%=rs2.getString("departement.Dep_Abr")%></td>
                    <td><%=rs2.getString("departement.Dep_date")%></td>
                    <% PreparedStatement pst2 = con2.prepareStatement("select * from departement where Dep_Id=?");
                        int id = rs2.getInt("departement.Dep_Id_Par");
                        pst2.setInt(1, id);
                        ResultSet rs3 = pst2.executeQuery();
                        if (rs3.next()) {%>
                            <td><%=rs3.getString("Dep_Nom")%></td> 
                    <%
                    } else {
                    %>
                            <td>Pas de parent</td>
                    <%
                        }
                    %>
                    <td><%=rs2.getString("type.Type_Nom")%></td>
                    <td>
                        <span>
                            <a href="depSupp?id=<%=rs2.getInt("departement.Dep_Id")%>" id="supprimer"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                        </span>
                        <span>
                            <a href="depDetail?id=<%=rs2.getInt("departement.Dep_Id")%>"><i class="fa fa-edit" style="color: blue;"></i></a>
                        </span>

                    </td> 
                </tr>

                <% 
                    
                    }
                    con2.close();
                %>






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
        $("#abr").val("");
        $("#date_cre").val("");
        $("#parent").val("");
        $("#type").val("");
        
       


    }
    function ajout() {
      

        $.ajax({
            url: 'depInsert',
            type: 'post',
       
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
    
   

</script>

                                
<%@include file="Pied.jsp" %>