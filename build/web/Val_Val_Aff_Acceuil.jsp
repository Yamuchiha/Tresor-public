<%-- 
    Document   : Val_Val_Aff_Acceuil
    Created on : 26 avr. 2023, 17:56:57
    Author     : Yami Sukehiro
--%>

<%@page import="Selection.Selection_Validation_Update"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Tete.jsp" %>

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
                        <h5 class="modal-title" id="exampleModalLabel">Validation de la requête</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form method="post" action="valDetail">
                            <input type="hidden" name="dem_id" id="dem_id" value="${valdetail.dem_id}">
                          
                            <% 
                                Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from status_req");
                            %>

                            <label class="form-label" for="dem_req_status">Status de la requête</label>
                            <select id="dem_req_status" name="dem_req_status" class="form-select">
                                <option value=""></option>
                                <% 
                                    if(session.getAttribute("valdetail")!=null){
                                    while (rs1.next()) {
                                    Selection_Validation_Update vali = (Selection_Validation_Update) session.getAttribute("valdetail");
                                     if(rs1.getString("Statu_Req").equals(vali.getDem_req_status())){%>
                                    <option value="<%=rs1.getString("Statu_Req")%>" selected><%=rs1.getString("Statu_Req")%></option>
                                    <%
                                        }else{
                                %>
                                    
                                <option value="<%=rs1.getString("Statu_Req")%>"><%=rs1.getString("Statu_Req")%></option>
                                <%
                                    }
                                    }
                                    rs1.close();
                                    con1.close();
                                    }
                                %>
                            </select>
                            <label for="raison" class="form-label">Raison</label>
                            <textarea id="raison" name="raison" class="form-control">${valdetail.raison}</textarea>

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

<div class="row">
    <div class="col-md-12 text-center">
        <h3>Liste des requêtes validées</h3>
    </div>
</div>
<div class="row my-5" id="remplacer">
      <div class="card">
        
        <div class="card-body">
    <input type="hidden" name="status" value="${status}" id="status">
    <div class="table-responsive col-12">
        <table class="table table-striped data-table" id="myTable">
            <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Permission demandé</th>                   
                    <th scope="col">Date de demande</th>
                    <th scope="col">Status permission</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${valsen}" var="vali">
                    <tr>
                        <td>${vali.nom}</td>
                        <td>${vali.prenom}</td>
                        <td>${vali.permission}</td>
                        <td>${vali.date}</td>
                         <c:choose>
                            <c:when test="${vali.statu_per.equals('Acceptee')}">
                                <td><div class="badge bg-success">${vali.statu_per}</div></td>
                                <td><i class="fas fa-check-square" style="color: springgreen;"></td>
                                </c:when>
                            </c:choose>
                            <td><a href="affecSupp?id=${vali.dem_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                            <a href="valDetail?id=${vali.dem_id}"><i class="fa fa-edit" style="color: blue;"></i></a>
                            </td>
                    </tr>
                    
                </c:forEach>
                


            </tbody>
        </table>
    </div>
</div>
    
    </div>
</div>

<%@include file="Pied.jsp" %> 

