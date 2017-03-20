$(document).ready(function() {
	$(".page-wrapper").css("padding-top", $(".navbar").height()+"px");
	
	if(localStorage.getItem("filas1")===null){
		localStorage.setItem("filas1", 1);
	}

	if(localStorage.getItem("filas2")===null){
		localStorage.setItem("filas2", 1);
	}

});

/*$("#form-reembolso").click( function() {
  var entradas = document.getElementById("tabla2").rows.length;
    localStorage.setItem("filas2", entradas);
    window.location.href = "form-reembolso.html";
});

$("#form-viaje").click( function() {
  var entradas = document.getElementById("tabla1").rows.length;
  localStorage.setItem("filas1", entradas);
  window.location.href = "form-viaje.html";
});*/