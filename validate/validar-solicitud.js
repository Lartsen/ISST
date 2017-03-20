$(function(){

	$("#solicitud").validate({
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
				"proyecto": {
					"required": true
				},
				"comienzo": {
					"required": true
				},
				"final": {
					"required": true
				},
				"descripcion": {
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
				"proyecto": {
					"required": "Escriba el proyecto"
				},
				"comienzo": {
					"required": "Elija fecha de inicio"
				},
				"final": {
					"required": "Elija fecha final"
				},
				"descripcion": {
					"required": "Escriba una descripción"
				}
			},
		submitHandler: function(form){
			
		    var s1 = "Destino" + localStorage.getItem("filas1");
		    var s2 = $("#destination").val();
		    localStorage.setItem(s1, s2);

		    var s3 = "Pendiente";
		    var s4 = "Estado" +  localStorage.getItem("filas1");
		    localStorage.setItem(s4, s3);

		    var s5 = "Solicitante" + localStorage.getItem("filas1");
		    var s6 = $("#identificador").val();
		    localStorage.setItem(s5, s6);

		    var s7 = "Descripcion" + localStorage.getItem("filas1");
		    var s8 = $("#descripcion").val();
		    localStorage.setItem(s7, s8);

		    var inicio = /*Date.parse(*/$("#comienzo").val()/*)*/;
		    var final = /*Date.parse(*/$("#final").val()/*)*/;
		    /*var tiempo = (final-inicio)/1000;
		    var duracion = (tiempo/3600)/24;*/
		    var s9 = "Duracion" + localStorage.getItem("filas1");
		    var s10 = "Fecha de salida: "+inicio+"- Fecha de llegada: "+final;//Math.trunc(duracion);
		    localStorage.setItem(s9, s10);

		    var s10 = "Proyecto" + localStorage.getItem("filas1");
		    var s11 = $("#proyecto").val();
		    localStorage.setItem(s10, s11);

		    localStorage.setItem("filas1",parseInt(localStorage.getItem("filas1")) + 1);
		    window.location.href="home-empleado.html"; 
					
		}

	})
})