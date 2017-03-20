$(document).ready( function() {
    //Solicitudes
    var t1 = $('#tabla1').DataTable( {
        "columnDefs": [ {
            "targets": 3,
            "data": null,
            "defaultContent": "<button class='btn btn-success' type='button' id='boton' onclick='aceptar(this);'>Aceptar</button> <button class='btn btn-danger' type='button' onclick='rechazar(this);'>Rechazar</button>"
        },{
            "targets": 4,
            "data": null,
            "defaultContent": "<button class='btn btn-info' type='button' id='boton' onclick='desc(this);'>Descripción</button>"
        } ]
    } );
    //Reembolsos
    var t2 = $('#tabla2').DataTable( {
        "columnDefs": [ {
            "targets": 4,
            "data": null,
            "defaultContent": "<button class='btn btn-success' type='button' id='boton' onclick='aceptar2(this);'>Aceptar</button> <button class='btn btn-danger' type='button' onclick='rechazar2(this);'>Rechazar</button>"
        } ]
    } );


    var nm = localStorage.length;
    var x;
          
    for(x = 0; x < nm; x++){
      var key = localStorage.key(x);

      if (key.indexOf("Destino") !== -1) {
          /*var table = document.getElementById("tabla");
          var row = table.insertRow(table.rows.length);
          var cell1 = row.insertCell(0);
          var cell2 = row.insertCell(1);
          var cell3 = row.insertCell(2);
          var cell4 = row.insertCell(3);
          var cell5 = row.insertCell(4);

          cell1.innerHTML = localStorage.getItem(key);*/
          var ch = key.charAt(7);
          /*cell2.innerHTML = localStorage.getItem("Estado" + ch) ;
          cell3.innerHTML = localStorage.getItem("Solicitante" + ch) ;
          cell4.innerHTML = "<button type='button' id='boton' onclick='aceptar(this);'>Aceptar</button> <button type='button' onclick='rechazar(this);'>Rechazar</button>";
          cell5.innerHTML = "<button type='button' id='boton' onclick='desc(this);'>Descripción</button>";*/
    
        t1.row.add([localStorage.getItem(key),
                    localStorage.getItem("Estado" + ch),
                    localStorage.getItem("Solicitante" + ch)]).draw();
      }

      else if (key.indexOf("Reembolso") !== -1 && key.length === 10) {
        /*var table = document.getElementById("tabla2");
        var row = table.insertRow(table.rows.length);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);*/

        var ch = key.charAt(9);

        /*cell1.innerHTML = localStorage.getItem(key);
        cell2.innerHTML = localStorage.getItem("ReembolsoEstado" + ch);
        cell3.innerHTML = localStorage.getItem("ReembolsoCantidad" + ch);
        cell4.innerHTML = localStorage.getItem("ReembolsoIdentificador" + ch);
        cell5.innerHTML = "<button type='button' id='boton' onclick='aceptar2(this);'>Aceptar</button> <button type='button' onclick='rechazar2(this);'>Rechazar</button>"*/
           
        t2.row.add([localStorage.getItem(key),localStorage.getItem("ReembolsoEstado" + ch),
                    localStorage.getItem("ReembolsoCantidad" + ch),
                    localStorage.getItem("ReembolsoIdentificador" + ch)]).draw();
      }
    }
   
       
  
});


function aceptar(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  localStorage.setItem("Estado" + x, "Aceptado");
  window.location="home-superior.html";
}

function rechazar(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  localStorage.setItem("Estado" + x, "Rechazado");
  window.location="home-superior.html";
}

function aceptar2(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  if(localStorage.getItem("ReembolsoEstado" + x) !== "Aceptado" && localStorage.getItem("ReembolsoEstado" + x) !== "Rechazado"){
    localStorage.setItem("ReembolsoEstado" + x, "Aceptado(Superior)");
  }
  window.location="home-superior.html";
}

function rechazar2(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  if(localStorage.getItem("ReembolsoEstado" + x) !== "Aceptado" && localStorage.getItem("ReembolsoEstado" + x) !== "Rechazado"){
    localStorage.setItem("ReembolsoEstado" + x, "Rechazado(Superior)");
  }
  
  window.location="home-superior.html";
}



function desc(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  var d = localStorage.getItem("Descripcion" + x);
  var t1 = localStorage.getItem("Destino" + x);
  var t2 = localStorage.getItem("Solicitante" + x);
  var d2 = localStorage.getItem("Duracion" + x);
  var p = localStorage.getItem("Proyecto" + x);
  localStorage.setItem("desc", d);
  localStorage.setItem("title1", t1);
  localStorage.setItem("title2", t2);
  localStorage.setItem("duration", d2);
  localStorage.setItem("project", p);

  window.location="descripcion-superior.html";
}
