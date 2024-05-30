<%-- 
    Document   : Dep_Affiche
    Created on : 15 mars 2023, 16:41:38
    Author     : Yami Sukehiro
--%>

<%@page import="entite.Departement"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="dao.Connexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row" id="remplacer">
    <div class="card">
        
        <div class="card-body">
    <div class="table-responsive col-12">
        <table class="table table-striped data-table">
            <thead>
                <tr>
                    <th scope="col">Departement</th>
                    <th scope="col">Abréviation</th>
                    <th scope="col">Date de Création</th>
                    <th scope="col">Parent</th>
                    <th scope="col">Type</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                
                        <% 
                            Connection con1 = Connexion.seConnecter();
                            List<Departement> deps= (List<Departement>) request.getAttribute("deps");
                            for(Departement dep : deps)
                            
                            {%>
                            <tr>

                                   <td><%=dep.getDep_nom() %></td>
                                   <td><%=dep.getDep_abr() %></td>
                                   <td><%=dep.getDep_date() %></td>
                            <% PreparedStatement pst = con1.prepareStatement("select * from departement where Dep_Id=?");
                                int id = dep.getDep_id_par();
                                pst.setInt(1, id);
                                ResultSet rs = pst.executeQuery();
                                if(rs.next())
                                {%>
                                 <td><%=rs.getString("Dep_Nom") %></td> 
                                <%
                                    }else{
                                %>
                                <td>Pas de parent</td>
                                <% 
                                    }
                                %>
                                <td><%=dep.getType_nom() %></td>
                                <td>
                                    <span>
                                        <a href="depSupp?id=<%=dep.getDep_id() %>" id="supprimer"><i class="fa fa-trash-alt" style="color: red;"></i></a>
                                    </span>
                                    <span>
                                        <a href="depDetail?id=<%=dep.getDep_id() %>"><i class="fa fa-edit" style="color: blue;"></i></a>
                                    </span>
                                    
                                </td> 
                                </tr>
                                
                            <%
                                }
                                con1.close();
                            %>
                   
                           
                    
                


            </tbody>
        </table>
    </div>
</div>
</div>
</div>
 
  <script src="js/table.js"></script>

