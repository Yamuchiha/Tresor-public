<%-- 
    Document   : Dem_Aff
    Created on : 30 mars 2023, 10:22:33
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- tableau -->
<div class="row" id="remplacer">
    <div class="table-responsive col-12">
       
                <c:forEach items="${userRequets}" var="useRequete">
                 
                        <c:choose>
                            <c:when test="${useRequete.status.equals('En cour')}">
                            <div class="col-md-12">
                                
                                <div class="alert alert-primary"><strong><a href="detailDemande?id=${useRequete.dem_id}">${useRequete.permission}</a></strong> ${useRequete.date}
                                    <span class="badge bg-secondary text-end">${useRequete.status}</span> <i class="fas fa-spinner fa-pulse"></i>
                                    <span>
                                        <a href="demSupp?id=${useRequete.dem_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                        <a href="demDetail?id=${useRequete.dem_id}"><i class="fa fa-edit" style="color: blue;"></i></a>
                                    </span>
                                </div>
                            </div>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${useRequete.status.equals('Acceptee')}">
                                    <div class="alert alert-primary"><strong><a href="detailDemande?id=${useRequete.dem_id}">${useRequete.permission}</a></strong> ${useRequete.date}
                                    <span class="badge bg-success text-end">${useRequete.status}</span> <i class="fas fa-check-square" style="color: springgreen;"></i>
                                    <a href="demSupp?id=${useRequete.dem_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                </div>
                                </c:when>
                            </c:choose>
                            
                             <c:choose>
                                <c:when test="${useRequete.status.equals('Refuse')}">
                                    <div class="alert alert-primary"><strong><a href="detailDemande?id=${useRequete.dem_id}">${useRequete.permission}</a></strong> ${useRequete.date}
                                    <span class="badge bg-danger text-end">${useRequete.status}</span> <i class="fas fa-times-circle " style="color: red;"></i>
                                    <a href="demSupp?id=${useRequete.dem_id}"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                </div>
                                </c:when>
                            </c:choose>
                    

                    
                </c:forEach>


            </tbody>
        </table>
    </div>
</div>



