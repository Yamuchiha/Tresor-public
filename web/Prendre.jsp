<%-- 
    Document   : Prendre
    Created on : 24 mars 2023, 20:46:09
    Author     : Yami Sukehiro
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Attribution congés</h3>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
       
        <form method="post" action="prendreInsert">
                            <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from employer inner join statu on employer.Statu_Id=statu.Sat_Id where statu.Status='En service'");
                            %>

                            <label class="form-label" for="per">Personnel</label>
                            <select id="per" name="per" class="form-control moi">
                                <option value=""></option>
                                <% while (rs1.next()) {%>
                                <option value="<%=rs1.getInt("employer.Em_Id")%>"><%=rs1.getString("employer.Em_Nom")%> || <%=rs1.getString("employer.Em_Prenom")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                             <% Connection con2 = Connexion.seConnecter();
                                Statement st2 = con2.createStatement();
                                ResultSet rs2 = st2.executeQuery("Select * from conge");
                            %>

                            <label class="form-label" for="conge">Type de congé</label>
                            <select id="conge" name="conge" class="form-control moi">
                                <option value=""></option>
                                <% while (rs2.next()) {%>
                                <option value="<%=rs2.getInt("Conge_Id")%>"><%=rs2.getString("Group_cong")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                               
                             <label for="date_dep" class="form-label">Date de départ</label>
                             <input type="date" class="form-control" id="date_dep" name="date_dep">
                             <label for="date_fin" class="form-label">Date de retour</label>
                             <input type="date" class="form-control" id="date_fin" name="date_fin">
                             <label for="date_dep" class="form-label">Motif</label>
                             <textarea class="form-control" name="motif"></textarea>
                         
                            <button type="submit" class="btn btn-primary my-3">Enregistrer</button>
                        </form>

</div>
</div>




<%@include file="Pied.jsp" %>  
