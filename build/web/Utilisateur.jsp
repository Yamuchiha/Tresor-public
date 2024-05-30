<%-- 
    Document   : Utilisateur
    Created on : 25 mars 2023, 04:43:42
    Author     : Yami Sukehiro
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="teteT.jsp" %>

<div class="row my-5">
    <div class="col-md-12 text-center">
        <h3>Création d'un nouveau utilisateur</h3>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
       
        <form method="post" action="UtiliInsert">
                            <% Connection con1 = Connexion.seConnecter();
                                Statement st1 = con1.createStatement();
                                ResultSet rs1 = st1.executeQuery("Select * from employer");
                            %>

                            <label class="nom" for="per">Nom d'utilisateur du Personnel</label>
                            <select id="nom" name="nom" class="form-control moi">
                                <option value=""></option>
                                <% while (rs1.next()) {%>
                                <option value="<%=rs1.getInt("Em_Id")%>"><%=rs1.getString("Email")%> || <%=rs1.getString("Em_Nom")%> || <%=rs1.getString("Em_Prenom")%></option>
                                <%
                                    }
                                    rs1.close();
                                    con1.close();

                                %>
                            </select>
                              
                              <input type="hidden" class="form-control" id="role" name="role" value="User">                        
                             <label for="pass" class="form-label">Mot de passe du personnel</label>
                             <input type="password" class="form-control" id="pass" name="pass" maxlength="8">
                             <button type="submit" class="btn btn-primary my-3">Enregistrer</button>
                        </form>

</div>
</div>




<%@include file="Pied.jsp" %>  

