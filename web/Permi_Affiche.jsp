<%-- 
    Document   : Permi_Affiche
    Created on : 25 mai 2023, 11:18:34
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

  <script src="js/table.js"></script>