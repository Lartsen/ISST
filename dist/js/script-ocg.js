$(document).ready( function() {
    //Reembolsos
    var t1 = $('#tabla1').DataTable( {
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

      if (key.indexOf("Reembolso") !== -1 && key.length === 10 ) {

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
      
        t1.row.add([localStorage.getItem(key),
                    localStorage.getItem("ReembolsoEstado" + ch),
                    localStorage.getItem("ReembolsoCantidad" + ch),
                    localStorage.getItem("ReembolsoIdentificador" + ch)]).draw();
      }
    }
});


function aceptar2(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  var st = localStorage.getItem("ReembolsoEstado" + x);
  if(st.indexOf("Superior") !== -1 || st === "Aceptado" || st === "Rechazado"){
     localStorage.setItem("ReembolsoEstado" + x, "Aceptado");
  }
  window.location="home-ocg.html";
}

function rechazar2(elm){ 
  var x = elm.parentNode.parentNode.rowIndex;
  var st = localStorage.getItem("ReembolsoEstado" + x);
  if(st.indexOf("Superior") !== -1 || st === "Aceptado" || st === "Rechazado"){
     localStorage.setItem("ReembolsoEstado" + x, "Rechazado");
  }
  window.location="home-ocg.html";
}
