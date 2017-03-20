$(document).ready( function() {
    var t1 = $('#tabla1').DataTable( {
        "columnDefs": [ {
            "targets": -1,
            "data": null,
            "defaultContent": "<button class='btn btn-danger' type='button' onclick='delete1(this);'>Eliminar</button>"
        } ]
    } );

    var t2 = $('#tabla2').DataTable( {
        "columnDefs": [ {
            "targets": -1,
            "data": null,
            "defaultContent": "<button class='btn btn-danger' type='button' onclick='delete2(this);'>Eliminar</button>"
        } ]
    } );


    var nm = localStorage.length;
    var x;
          
    for(x = 0; x < nm; x++){
      var key = localStorage.key(x);

      if (key.indexOf("Destino") !== -1) {
        /*var table = document.getElementById("tabla1");
        var row = table.insertRow(table.rows.length);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = localStorage.getItem(key);*/
        var ch = key.charAt(7);
        /*cell2.innerHTML = localStorage.getItem("Estado" + ch);
        cell3.innerHTML = "<button type='button' onclick='delete1(this);'>Eliminar</button>";*/

        t1.row.add([localStorage.getItem(key),localStorage.getItem("Estado" + ch)]).draw();
      }

      else if (key.indexOf("Reembolso") !== -1 && key.length === 10 ) {
        /*var table = document.getElementById("tabla2");
        var row = table.insertRow(table.rows.length);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);*/
                
        var ch = key.charAt(9);
        /*cell1.innerHTML = localStorage.getItem(key);
        cell2.innerHTML = localStorage.getItem("ReembolsoCantidad" + ch);
        cell3.innerHTML = localStorage.getItem("ReembolsoEstado" + ch);
        cell4.innerHTML = "<button type='button' onclick='delete2(this);'>Eliminar</button>";*/
                
        t2.row.add([localStorage.getItem(key),localStorage.getItem("ReembolsoCantidad" + ch),
                    localStorage.getItem("ReembolsoEstado" + ch)]).draw();
      }
    }
   
       
  
});

function delete1(elm){
    var x = elm.parentNode.parentNode.rowIndex;
    console.log(x);
    var s1 = "Destino" + x;
    localStorage.removeItem(s1);

    var s3 = "Estado" + x;
    localStorage.removeItem(s3);

    var s5 = "Solicitante" + x;
    localStorage.removeItem(s5);

    var s7 = "Descripcion" + x;
    localStorage.removeItem(s7);

    var s9 = "Duracion" + x;
    localStorage.removeItem(s9);

    var s10 = "Proyecto" + x;
    localStorage.removeItem(s10);

    var num1 = localStorage.getItem("filas1");
    localStorage.setItem("filas1",num1-1);

    window.location="home-empleado.html";    
    
  }
        
  function delete2(elm){
    var x = elm.parentNode.parentNode.rowIndex;

    var s1 = "Reembolso" + x;
    localStorage.removeItem(s1);

    var s3 = "ReembolsoEstado" + x;
    localStorage.removeItem(s3);

    var s5 = "ReembolsoCantidad" + x;
    localStorage.removeItem(s5);

    var s7 = "ReembolsoIdentificador" + x;
    localStorage.removeItem(s7);

    var num2 = localStorage.getItem("filas2");
    localStorage.setItem("filas2",num2-1);
          
    window.location="home-empleado.html";
  }