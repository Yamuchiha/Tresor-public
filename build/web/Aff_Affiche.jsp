<%-- 
    Document   : Aff_Affiche
    Created on : 24 mars 2023, 12:20:50
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Liste des Affectations</h3>
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
                    <th scope="col">Fonction</th>
                    <th scope="col">Departement</th>
                    <th scope="col">Annee Affectation</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                  
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${aff}" var="affect">
                    <tr>
                        <td>${affect.nom}</td>
                        <td>${affect.prenom}</td>
                        <td>${affect.fonction}</td>
                        <td>${affect.dep_nom}</td>
                        <td>${affect.annee_aff}</td>
                         <c:choose>
                            <c:when test="${affect.statu.equals('En service')}">
                                <td>${affect.statu}</td>
                                <td><i class="fa fa-toggle-on" style="color: #31b131"></i></td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${affect.statu.equals('Suspendue')}">
                                <td>${affect.statu}</td>
                                <td><i class="fa fa-toggle-off" style="color: #565e64"></i></td>
                                </c:when>
                            </c:choose>
                            <td><a href="affecSupp?id=${affect.conc_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                            <a href="affecDetail?id=${affect.conc_id}"><i class="fa fa-edit" style="color: blue;"></i></a>
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
