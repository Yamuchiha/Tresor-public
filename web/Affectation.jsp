<%-- 
    Document   : Affectation
    Created on : 24 mars 2023, 09:39:29
    Author     : Yami Sukehiro
--%>

<%@page import="dao.Connexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Affectations</h3>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
       
        <form method="post" action="affInsert">
                            <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from employer");
                            %>

                            <label class="form-label" for="per">Personnel</label>
                            <select id="per" name="per" class="form-control moi">
                                <option value=""></option>
                                <% while (rs1.next()) {%>
                                <option value="<%=rs1.getInt("Em_Id")%>"><%=rs1.getString("Em_Nom")%> || <%=rs1.getString("Em_Prenom")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                             <% Connection con2 = Connexion.seConnecter();
                                Statement st2 = con2.createStatement();
                                ResultSet rs2 = st2.executeQuery("Select * from departement");
                            %>

                            <label class="form-label" for="dep">Departement</label>
                            <select id="dep" name="dep" class="form-control moi">
                                <option value=""></option>
                                <% while (rs2.next()) {%>
                                <option value="<%=rs2.getInt("Dep_Id")%>"><%=rs2.getString("Dep_Nom")%> || <%=rs2.getString("Dep_Abr")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                               
                             <label for="date" class="form-label">Date d'Affectation</label>
                             <input type="date" class="form-control" id="date" name="date">
                         
                            <button type="submit" class="btn btn-primary my-3">Enregistrer</button>
                        </form>

</div>
</div>




<%@include file="Pied.jsp" %>  

