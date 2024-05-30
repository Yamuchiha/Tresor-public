<%-- 
    Document   : Pied
    Created on : 8 mars 2023, 19:14:58
    Author     : Yami Sukehiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 </div>
    </main>
    <a href="../../../../Downloads/favicon.ico"></a>
        



    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/chart.min.js"></script>
    <script src="js/datatables.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/jquery.dataTables.js"></script>
    <script src="js/dataTables.bootstrap5.min.js"></script>
    <script src="js/sweetalert2@11.js"></script>
    <script src="js/scrip.js"></script>
    <script src="js/EmpModa.js"></script>
    <script src="js/select2.min.js"></script>
    <script src="js/select.js"></script>
    <script src="js/table.js"></script>
    
    <script>
        var statu = document.getElementById("status");
       console.log(statu.value);
       if(statu.value == "success"){
           swal.fire("Succès !", " ", "success");
       }

    </script>
    
        <script>
            function myFunction() {
              var input, filter, table, tr, td, i, txtValue;
              input = document.getElementById("myInput");
              filter = input.value.toUpperCase();
              table = document.getElementById("myTable");
              tr = table.getElementsByTagName("tr");
              for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[1];
                            if (td) {
                                txtValue = td.textContent || td.innerText;
                                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                    tr[i].style.display = "";
                                } else {
                                    tr[i].style.display = "none";
                                }
                            }
                        }
                    }
        </script>
        <script>
            $(document).on("click", "#supprimer", function(e){
            e.preventDefault();
            var link = $(this).attr("href");
            swal.fire({
                title: 'Etes-vous vraiment sûr ?',
                text: "Une fois validé, vous ne pouvez plus revenir en arrière",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                cancelButtonText: 'Annulé',
                confirmButtonText: 'Oui'
              }).then((result) => {
                if (result.isConfirmed) {
                  window.location.href = link;
                }
              })
            
            });
        </script>

</body>
</html>
