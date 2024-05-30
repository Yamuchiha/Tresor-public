<%-- 
    Document   : Prendre_Affiche
    Created on : 24 mars 2023, 21:38:12
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
                    <th scope="col">Type de congé</th>
                    <th scope="col">Date de départ</th>
                    <th scope="col">Date de retour</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                     <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pres}" var="prend">
                    <tr>
                        <input type="hidden" name="em_id" value="${prend.em_id}">
                        <td><a href="Em_Detail?id=${prend.em_id}">${prend.nom}</a></td>
                        <td>${prend.prenom}</td>
                        <td>${prend.conge}</td>
                        <td>${prend.date_depart}</td>
                        <td>${prend.date_retour}</td>
                         <c:choose>
                            <c:when test="${prend.statu.equals('En service')}">
                                <td>${prend.statu}</td>
                                <td><i class="fa fa-toggle-on" style="color: #31b131"></i></td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${prend.statu.equals('Suspendue')}">
                                <td>${prend.statu}</td>
                                <td><i class="fa fa-toggle-off" style="color: #565e64"></i></td>
                                </c:when>
                            </c:choose>
                  
                        <td><a href="prendre_Supp?id=${prend.pre_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                        <a href="prendreDetail?id=${prend.pre_id}"><i class="fa fa-edit" style="color: blue;"></i></a>
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
