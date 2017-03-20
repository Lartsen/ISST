$(document).ready(function() {
  $("#titulo").html("Solicitud de viaje a " + 
                    localStorage.getItem("title1") + 
                    " por parte del empleado " + 
                    localStorage.getItem("title2"));

  $("#desc").html(localStorage.getItem("desc"));
  $("#dur").html("Duración del viaje: " + localStorage.getItem("duration"));
  $("#pro").html("Proyecto del viaje: " + localStorage.getItem("project"));
});
  
    
$(".volver-descripcion").click(function() {
  localStorage.removeItem("desc");
  localStorage.removeItem("title1");
  localStorage.removeItem("title2");
  localStorage.removeItem("duration");
  localStorage.removeItem("project");
  window.location.href="home-superior.html"; 
});

$("#v-desc-out").click(function() {
  localStorage.removeItem("desc");
  localStorage.removeItem("title1");
  localStorage.removeItem("title2");
  localStorage.removeItem("duration");
  localStorage.removeItem("project");
  window.location.href="index.html"; 
});
 