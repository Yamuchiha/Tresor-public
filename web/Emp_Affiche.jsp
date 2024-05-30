<%-- 
    Document   : Emp_Affiche
    Created on : 14 mars 2023, 14:16:59
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row" id="remplacer">
    <div class="card">
        
        <div class="card-body">
        <div class="table-responsive col-12">
            <table class="table table-striped data-table">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Prénom</th>
                        <th scope="col">Fonction</th>
                        <th scope="col">Date d'entrée</th>
                        <th scope="col">Status</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${employers}" var="empl">
                        <tr>
                            
                            <td>${empl.nom}</td>
                            <td>${empl.prenom}</td>
                            <td>${empl.fonction}</td>
                            <td>${empl.date_eng}</td>
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

  <script src="js/table.js"></script>
