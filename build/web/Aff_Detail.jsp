<%-- 
    Document   : Aff_Detail
    Created on : 24 mars 2023, 14:40:17
    Author     : Yami Sukehiro
--%>

<%@page import="entite.Affectation"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.Connexion"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Tete.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Modification Affectation</h3>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
       
        <form method="post" action="affecDetail">
                            <input type="hidden" name="id1" value="${affy.conc_id}">
                            <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from employer");
                            %>

                            <label class="form-label" for="per">Personnel</label>
                            <select id="per" name="per" class="form-control moi">
                                <option value=""></option>
                                <%  
                                    Affectation aff = (Affectation) session.getAttribute("affy");
                                    while (rs1.next()) {
                                   if(rs1.getInt("Em_Id") == aff.getEm_id())
                                   {%>
                                   <option value="<%=rs1.getInt("Em_Id")%>" selected><%=rs1.getString("Em_Nom")%> || <%=rs1.getString("Em_Prenom")%></option>
                                   <%
                                       }else{
                                   %>
                                <option value="<%=rs1.getInt("Em_Id")%>"><%=rs1.getString("Em_Nom")%> || <%=rs1.getString("Em_Prenom")%></option>
                                <%
                                    }
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
                                <% 
                                    Affectation aff1 = (Affectation) session.getAttribute("affy");
                                    while (rs2.next()) {
                                    if(rs2.getInt("Dep_Id")== aff1.getEm_dep())
                                    {
                                %>
                                <option value="<%=rs2.getInt("Dep_Id")%>" selected><%=rs2.getString("Dep_Nom")%> || <%=rs2.getString("Dep_Abr")%></option>
                                <%
                                    }else{
                                %>
                                <option value="<%=rs2.getInt("Dep_Id")%>"><%=rs2.getString("Dep_Nom")%> || <%=rs2.getString("Dep_Abr")%></option>
                                <%
                                    }
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                               
                             <label for="date" class="form-label">Date d'Affectation</label>
                             <input type="date" class="form-control" id="date" name="date" value="${affy.annee_Aff}">
                         
                            <button type="submit" class="btn btn-primary my-3">Enregistrer</button>
                        </form>

</div>
</div>




<%@include file="Pied.jsp" %>  

