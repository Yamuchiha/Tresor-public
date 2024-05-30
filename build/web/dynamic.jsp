<%-- 
    Document   : dynamic
    Created on : 9 mars 2023, 06:57:53
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Tete.jsp" %>
<input type="hidden" name="nombre" value="${nombre}" id="nombre">
<input type="hidden" name="suspendu" value="${suspendu}" id="suspendu">
<input type="hidden" name="service" value="${service}" id="service">
<input type="hidden" name="requete" value="${requete}" id="requete">
<input type="hidden" name="acceptee" value="${acceptee}" id="acceptee">
<input type="hidden" name="refuse" value="${refuse}" id="refuse">
<input type="hidden" name="en_cour" value="${en_cour}" id="en_cour">

<div class="row my-3">
    <h1 class="text-center">Tableau de bord</h1>
</div>
<div class="row my-3">
   <div class="col-md-6 mb-3">
            <div class="card h-100">
              <div class="card-header text-center">
                <span class="me-2"><i class="bi bi-bar-chart-fill"></i></span>
                Graphe de représentation
              </div>
              <div class="card-body">
                <canvas class="chart" width="400" height="200"></canvas>
              </div>
            </div>
          </div>
</div>
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
                            <!--th></th-->
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
                                <!--td><a href="emSupp?id=${empl.id}" id="supprimer"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                    <a href="Em_Detail?id=${empl.id}"><i class="fa fa-edit" style="color: blue;"></i></a>
                                </td-->

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="Pied.jsp" %>


