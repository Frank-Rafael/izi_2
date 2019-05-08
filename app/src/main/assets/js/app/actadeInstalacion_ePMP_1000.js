"use strict";

function cargarFotoCapturada(itemID, path){
        $('#foto-'+itemID).attr('src',path);
}

function loadPhotosFromDB(rutaFotos){
    console.log("rutaFotos:",rutaFotos);
}

$(document).ready(function(){

    console.log("Loading...");

    var photosFromDB = JSON.parse(Android.loadPhotosFromDB());
        console.log("fotosCargadas:"+photosFromDB.length);

    //variable global que almacena los tipos

        var tipos = [
              {id:1,descripcion:"1. Número de serie del GPS"},
              {id:2,descripcion:"2. Número de serie de Antena"},
              {id:3,descripcion:"3. Número de serie de AP"},
              {id:4,descripcion:"4. Número de serie POE"},
              {id:5,descripcion:"5. Número de serie S. SUPPRESSOR INF. (S. Suppressor indoor)"},
              {id:6,descripcion:"6. Vista Frontal GPS"},
              {id:7,descripcion:"7. Vista Posterior GPS"},
              {id:8,descripcion:"8. Conexión GPS - ePMP 1000"},
              {id:9,descripcion:"9. Foto frontal de antena"},
              {id:10,descripcion:"10. Estruct. donde se vea antena instalada (CON BRUJULA)"},
              {id:11,descripcion:"11. Sellado"},
              {id:12,descripcion:"12. Polarización"},
              {id:13,descripcion:"13. Foto frontal de AP"},
              {id:14,descripcion:"14. Estructura donde se vea AP instalado"},
              {id:15,descripcion:"15. Sellado"},
              {id:16,descripcion:"16. Cableado de Jumper"},
              {id:17,descripcion:"17. Aterramiento AP"},
              {id:18,descripcion:"18. Aterramiento AP lado BDT"},
              {id:19,descripcion:"19. Sellado KIT de tierra alto (si aplica)"},
              {id:20,descripcion:"20. Sellado KIT de tierra medio"},
              {id:21,descripcion:"21. Sellado KIT de tierra bajo"},
              {id:22,descripcion:"22. Sellado KIT de tierra Pasamuro"},
              {id:23,descripcion:"23. Ruteo SF/UTP vertical superior"},
              {id:24,descripcion:"24. Ruteo SF/UTP vertical abajo"},
              {id:25,descripcion:"25. Ruteo SF/UTP horizontal hacia subida"},
              {id:26,descripcion:"26. Ruteo SF/UTP exterior hacia pasamuros"},
              {id:27,descripcion:"27. Ruteo SF/UTP en pasamuros"},
              {id:28,descripcion:"28. BDT Pasamuro (conexiones en barra)"},
              {id:29,descripcion:"29. BDT Pasamuro (recorrido vertical)"},
              {id:30,descripcion:"30. Sellado de ductos en pasamuro."},
              {id:31,descripcion:"31. Vista de Rack completo"},
              {id:32,descripcion:"32. Vista interconexión AP en supresor"},
              {id:33,descripcion:"33. Vista de conexiones del supresor"},
              {id:34,descripcion:"34. Vista interconexion supresor y POE"},
              {id:35,descripcion:"35. Aterramiento supresor"},
              {id:36,descripcion:"36. Vista de equipos POE y S.Suppresor"},
              {id:37,descripcion:"37. Etiquetados SF/UTP ODU - Supresor"},
              {id:38,descripcion:"38. Etiquetados tierra Supresor - Barra"},
              {id:39,descripcion:"39. Uso de terminales tipo manguito"},
              {id:40,descripcion:"40. Vista de intercon. POE en router o Sw"},
              {id:41,descripcion:"41. Vista de conexiones del POE"},
              {id:42,descripcion:"42. Frontal rectificador y  barra de 0v"},
              {id:43,descripcion:"43. Breakers Utilzados (Foto Zoom)"},
              {id:44,descripcion:"44. Etiquetados energía (Rect)"},
              {id:45,descripcion:"45. Etiquetados energía (POE)"},
              {id:46,descripcion:"46. Etiquetados SF/UTP POE – Supresor"},
              {id:47,descripcion:"47. Etiquetados tierra POE - Barra"},
              {id:48,descripcion:"48. Panoramica Estacion / Torre"}
          ];

        //variable global que almacena la ruta del icono de la camara
    var rutaIconoCamara = '../../img/icons/camara.png';

    //iniciarInsertarCodigo();
    iniciarListaDeFotos(); //cargar la lista con los elementos que hay en la variable tipos


    function iniciarListaDeFotos(){

        let list = "", widthParent = $("#listaContainer").width();

        tipos.forEach(function(tipo){
            let itemID = tipo.id, itemDescripcion = tipo.descripcion;// itemimgPreview = tipo.imgprevia;
            let dataFoto = photosFromDB.find(x=>parseInt(x.id_dato)===parseInt(itemID));

            let cont1 = `<td rowspan="3" style="width:${widthParent/2}px;">
                             <figure class="figure">
                                 <img src="${(dataFoto?dataFoto.ruta_foto:rutaIconoCamara)}" class="figure-img img-fluid rounded" id="foto-${itemID}">
                             </figure>
                         </td>

                         <td>${itemDescripcion}</td>`;

            let cont2 = `<td>
                            <div class="row">
                                <div class="col-6">Ejemplo</div>
                                    <div class="col-6">
                                        <figure class="figure" style="width:20px!important;height:15px!important;">
                                            <img class="img-pre" id="${itemID}" src="../../img/preview/imgp_${itemID}.jpg" class="figure-img img-fluid rounded">
                                        </figure>
                                    </div>
                                </div>
                        </td>`;
            let cont3 = `<td><button type="button" class="btn btn-primary capturarFoto" itemID="${itemID}" id="">Capturar</button></td>`;
            //let item = `<div class="col-12 subtitle text-center mark" id="${rackEquipoLabel}" style="border-top-style: solid!important;"><b>${equipoSel}</b></div>`;
            list = list + '<tr>'+cont1+'</tr>' + '<tr>'+cont2+'</tr>' + '<tr>'+cont3+'</tr>';
        });

        $("#listaContainer").html(list);
    }



    //Evento al dar click en el boton Capturar Foto
    $(".capturarFoto").on("click",function(){
            let codigo = $("#codigo").val();
            if(codigo===""){
                alert("Ingrese Codigo");
                $("#codigo").focus();
                return false;
            }
            let itemID = $(this).attr("itemID"); //ID del item
            Android.capturarFoto(itemID,codigo); // Invoca al metodo capturarFoto(itemID) que esta en la clase MainActivity
        });



    $(".img-pre").on("click",function(){
            let itemID = $(this).attr("id"); //ID del item
            Android.cargarImgPrevia(itemID); // Invoca al metodo mostrarImgPreviaFoto(itemID) que esta en la clase MainActivity
        });




});