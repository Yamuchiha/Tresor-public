<%-- 
    Document   : Utilisateur_Affiche
    Created on : 25 mars 2023, 08:40:04
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Liste des Utilisateurs</h3>
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
                    <th scope="col">Role</th>
                    <th scope="col">Email</th>
                    <th scope="col">Departement</th>
                    <th scope="col">Fonction</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${utis}" var="utili">
                    <tr>
                        <td>${utili.nom}</td>
                        <td>${utili.prenom}</td>
                        <td>${utili.role}</td>
                        <td>${utili.email}</td>
                        <td>${utili.departement}</td>
                        <td>${utili.fonction}</td>
                         <c:choose>
                            <c:when test="${utili.status.equals('En service')}">
                                <td>${utili.status}</td>
                                <td><i class="fa fa-toggle-on" style="color: #31b131"></i></td>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${utili.status.equals('Suspendue')}">
                                <td>${utili.status}</td>
                                <td><i class="fa fa-toggle-off" style="color: #565e64"></i></td>
                                </c:when>
                            </c:choose>
                            <td><a href="utiliSup?id=${utili.user_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                            <a href="affecDetail?id=${utili.user_id}"><i class="fa fa-user-shield" style="color: blue;"></i></a>
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

