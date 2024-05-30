<%-- 
    Document   : Tableau_User
    Created on : 29 mars 2023, 16:59:19
    Author     : Yami Sukehiro
--%>



<%@page import="entite.Demander"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Tete.jsp" %>



<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Ma liste de requêtes</h3>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Nouveau. Req
        </button>

        <!-- Modal -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nouveau Requête</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form>
                            
                            <input type="hidden" name="em_id" id="em_id" class="form-control" required value="${name.us_id}">
                             <% Connection con = Connexion.seConnecter();
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery("Select * from permission");
                            %>

                            <label class="form-label" for="per_id">Type de requête</label>
                            <select id="per_id" name="per_id" class="form-select">
                                <option value=""></option>
                                <% while (rs.next()) {%>
                                <option value="<%=rs.getInt("Per_id")%>"><%=rs.getString("Permission")%></option>
                                <%
                                    }
                                    rs.close();
                                    con.close();

                                %>
                            </select>
      
                            <label for="motif" class="form-label">Motif de la demande</label>
                            <textarea id="motif" name="motif" class="form-control"></textarea>
 
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onclick="ajout()">Enregistrer</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>
                            
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
                        <h5 class="modal-title" id="exampleModalLabel">Modifier ma requête</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form method="post" action="demDetail">
                            <input type="hidden" name="dem_id" id="dem_id" class="form-control" required value="${detailDem.dem_id}">
                            <input type="hidden" name="em_id" id="em_id" class="form-control" required value="${detailDem.em_id}">
                             <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from permission");
                            %>

                            <label class="form-label" for="per_id">Type de requête</label>
                            <select id="per_id" name="per_id" class="form-select">
                                <option value=""></option>
                                <% 
                                    if(session.getAttribute("detailDem")!=null){
                                    while (rs1.next()) {
                                    Demander dems = (Demander) session.getAttribute("detailDem");
                                        if(rs1.getInt("Per_id")==dems.getPer_id())
                                        {%>
                                        <option value="<%=rs1.getInt("Per_id")%>" selected><%=rs1.getString("Permission")%></option>
                                        <%
                                            }else{
                                        %>
                                <option value="<%=rs1.getInt("Per_id")%>"><%=rs1.getString("Permission")%></option>
                                <%
                                    }
                                    }
                                    rs.close();
                                    con.close();
                                    }
                                %>
                            </select>
      
                            <label for="motif" class="form-label">Motif de la demande</label>
                            <textarea id="motif" name="motif" class="form-control">${detailDem.dem_motif}</textarea>
 
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
<div id="afficher"></div>

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
                            
                            
<script>
    function vider() {
        
        $("#per_id").val("");
        $("#motif").val("");
      


    }
    function ajout() {
       

        $.ajax({
            url: 'demander',
            type: 'post',
       
            data: $("form").serialize(),
            success: function (result) {
                console.log("success");
                vider();
                $("#remplacer").remove();
                $("#afficher").after(result);
                swal.fire("Succès !", " ", "success");

            }
        });
    }

    /*function delete(deletid){
     $.ajax({
     url:'emSupp',
     type:'post',
     data:deletid,
     success: function(result){
     $("#remplacer").remove();
     $("#afficher").after(result);
     }
     });
     }*/









</script>                            

<%@include file="Pied.jsp" %>
