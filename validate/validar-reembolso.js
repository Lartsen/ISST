$(function(){

	$("#reembolso").validate({
		rules: {
				"firstname": {
					"required": true
				},
				"lastname": {
					"required": true
				},
				"identificador": {
					"required": true
				},
				"destination": {
					"required": true
				},
				"cantidad": {
					"required": true
				}
		},
		messages: {
				"firstname": {
					"required": "Escriba su nombre"
				},
				"lastname": {
					"required": "Escriba su apellido"
				},
				"identificador": {
					"required": "Escriba su identificador"
				},
				"destination": {
					"required": "Escriba el destino"
				},
				"cantidad": {
					"required": "Escriba ela cantidad"
				}
			},
		submitHandler: function(form){
			
		    var s1 = "Reembolso" + localStorage.getItem("filas2");
		    var s2 = $("#destination").val();
		    localStorage.setItem(s1, s2);

		    var s3 = "Pendiente";
		    var s4 = "ReembolsoEstado" +  localStorage.getItem("filas2");
		    localStorage.setItem(s4, s3);

		    var s5 = $("#cantidad").val();
		    var s6 = "ReembolsoCantidad" +  localStorage.getItem("filas2");
		    localStorage.setItem(s6, s5);

		    var s7 = $("#identificador").val();
		    var s8 = "ReembolsoIdentificador" +  localStorage.getItem("filas2");
		    localStorage.setItem(s8, s7);

		    localStorage.setItem("filas2",parseInt(localStorage.getItem("filas2")) + 1);
		    window.location.href="home-empleado.html"; 
					
		}

	})
})