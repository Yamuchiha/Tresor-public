<%-- 
    Document   : Requete_Detail
    Created on : 26 mai 2023, 09:08:52
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Tete.jsp" %>
<div class="row my-5" id="remplacer">
    <div class="col-md-12">
        <h1 class="text-center">Detail de ma requête</h1>
        
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <b>Ma requête</b>
    </div>
    <div class="col-md-6">
        ${demande.permission}
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <b>Date de la demande</b>
    </div>
    <div class="col-md-6">
        ${demande.date}
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <b>Motif de ma requête</b>
    </div>
    <div class="col-md-6">
        ${demande.dem_motif}
    </div>
</div>
    
<div class="row">
    <div class="col-md-6">
        <b>Status de la requête</b>
    </div>
    <div class="col-md-6">
        
              <c:choose>
                <c:when test="${demande.dem_status.equals('En cour')}">
                        <div class="badge bg-secondary text-end">${demande.dem_status}</div> <!--i class="fas fa-spinner fa-pulse"></i-->
                       
                   
                
                    </c:when>
                </c:choose>
                        
               <c:choose>
                <c:when test="${demande.dem_status.equals('Acceptee')}">
                        <div class="badge bg-success text-end">${demande.dem_status}</div> <!--i class="fas fa-spinner fa-pulse"></i-->
                       
                   
                
                    </c:when>
                </c:choose>
                        
                  <c:choose>
                <c:when test="${demande.dem_status.equals('Refuse')}">
                        <div class="badge bg-danger text-end">${demande.dem_status}</div> <!--i class="fas fa-spinner fa-pulse"></i-->
                       
                   
                
                    </c:when>
                </c:choose>
                        
                
    </div>
</div>
    
<div class="row">
    <div class="col-md-6">
        <b>Raison de validation de la requête</b>
    </div>
    <div class="col-md-6">
        
              <c:choose>
                <c:when test="${demande.raison==null}">
                        Requête pas encore traiter
                       
                   
                
                    </c:when>
                </c:choose>
                        
                <c:choose>
                <c:when test="${demande.raison !=null}">
                        ${demande.raison}
                       
                   
                
                    </c:when>
                </c:choose>
    </div>
</div>



<%@include file="Pied.jsp" %>
