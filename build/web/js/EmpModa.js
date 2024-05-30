/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function () {
    var Emstat = document.getElementById("Emstat");
    console.log(Emstat.value);
    if (Emstat.value == "success") {
        $("#updateMod").modal("show");
    }
});