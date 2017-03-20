$(function(){
	var timeSlide = 1000;

	$("#accesoadmin").validate({
		rules: {
				"email": {
					"required": true,
					"email": true
				},
				"password": {
					"required": true,
					"minlength": "6"
				}
		},
		messages: {
				"email": {
					"required": "Escriba su email",
					"email": "Email no válido"
				},
				"password": {
					"required": "Escriba su contraseña",
					"minlength": "Mínimo 6 caracteres"
				}
			},
		submitHandler: function(form){
			if($('#alertBoxes>.alert-success, #alertBoxes>.alert-danger, #alertBoxes>.alert-info, #alertBoxes>.alert-warning')){
				$('#alertBoxes>.alert-success, #alertBoxes>.alert-danger, #alertBoxes>.alert-info, #alertBoxes>.alert-warning').slideUp(timeSlide);
			}
			
			var location="null";
				if($("#email").val()==="empleado@empleado.com"){
					location = "home-empleado.html";
					$(form).find("#btn-ingresar").attr("disabled", "disabled").attr("value","Entrando...");
					$('#alertBoxes').html('<div class="alert alert-success"></div>');
					$('#alertBoxes>.alert-success').hide(0).html('Bienvenido empleado');
					$('#alertBoxes>.alert-success').slideDown(timeSlide);
					setTimeout(function(){
						window.location.href = location;	
					},(timeSlide + 1000));
				}

				if($("#email").val()==="superior@superior.com"){
					location = "home-superior.html";
					$(form).find("#btn-ingresar").attr("disabled", "disabled").attr("value","Entrando...");
					$('#alertBoxes').html('<div class="alert alert-success"></div>');
					$('#alertBoxes>.alert-success').hide(0).html('Bienvenido superior');
					$('#alertBoxes>.alert-success').slideDown(timeSlide);
					setTimeout(function(){
						window.location.href = location;	
					},(timeSlide + 1000));
				}
				
				if($("#email").val()==="ocg@ocg.com"){
					location = "home-ocg.html";
					$(form).find("#btn-ingresar").attr("disabled", "disabled").attr("value","Entrando...");
					$('#alertBoxes').html('<div class="alert alert-success"></div>');
					$('#alertBoxes>.alert-success').hide(0).html('Bienvenido OCG');
					$('#alertBoxes>.alert-success').slideDown(timeSlide);
					setTimeout(function(){
						window.location.href = location;	
					},(timeSlide + 1000));
				}

			if(location==="null"){
				$('#alertBoxes').html('<div class="alert alert-danger"></div>');
				$('#alertBoxes>.alert-danger').hide(0).html('Error al intentar acceder');
				$('#alertBoxes>.alert-danger').slideDown(timeSlide);
			}
		}

	})
})