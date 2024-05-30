const charts = document.querySelectorAll(".chart");

var nomb = document.getElementById("nombre");
var requete = document.getElementById("requete");
console.log(nomb.value);
var text = "amateratus";
var service = document.getElementById("service");
var suspendu = document.getElementById("suspendu");
var acceptee = document.getElementById("acceptee");
var refuse = document.getElementById("refuse");
var en_cour = document.getElementById("en_cour");
charts.forEach(function (chart) {
  var ctx = chart.getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: ["Total_Employer", "En service", "Suspendu" , "Total_Requête", "Req_Validée", "Req_Refusée", "Req_encour"],
      datasets: [
        {
          label: "nombre",
          data: [nomb.value, service.value, suspendu.value, requete.value, acceptee.value, refuse.value, en_cour.value],
          backgroundColor: [
            "rgba(255, 206, 86, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(255, 99, 132, 0.2)",
            "rgba(153, 102, 255, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(255, 99, 132, 0.2)",
            "rgba(255, 159, 64, 0.2)",
          ],
          borderColor: [
            "rgba(255, 206, 86, 1)",
            "rgba(54, 162, 235, 1)",
            "rgba(255, 99, 132, 1)",
            "rgba(153, 102, 255, 1)",
            "rgba(54, 162, 235, 1)",
            "rgba(255, 99, 132, 1)",
            "rgba(255, 159, 64, 1)",
          ],
          borderWidth: 1,
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  });
});

$(document).ready(function () {
  $(".data-table").each(function (_, table) {
    $(table).DataTable();
  });
});
