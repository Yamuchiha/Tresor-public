<%-- 
    Document   : table
    Created on : 8 mars 2023, 19:16:04
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Tete.jsp" %>
<div class="row">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header">
                Graphe
            </div>
            <div class="card-body">
                <canvas class="chart" width="400" height="200"></canvas>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <table class="table">
            <thead>
                <tr>
                    <th>fd</th>
                    <th>Requete</th>
                    <th>fdf</th>
                    <th>Requete</th>
                    <th>Requete</th>
                    <th>Requete</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>
                        En cour
                    </td>
                    <td>
                        <i class="fas fa-spinner fa-spin" style="color: blue;"></i>
                    </td>
                </tr>
                <tr>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td class="table-danger">
                        Refusé
                    </td>
                    <td class="table-danger">
                        <i class="fas fa-times-circle " style="color: red;"></i>
                    </td>
                </tr>
                <tr>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td>fdf</td>
                    <td class="table-info">Acceptée</td>
                    <td class="table-info"><i class="fas fa-check-square" style="color: springgreen;"></i></td>
                </tr>
            </tbody>
        </table>
        
    </div>
   
</div>


<%@include file="Pied.jsp" %>

