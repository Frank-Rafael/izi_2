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
              {id:1,descripcion:"1. Número de serie Router"},
              {id:2,descripcion:"2. Número de serie de FORCE 180/190"},
              {id:3,descripcion:"3. Número de serie de POE"},
              {id:4,descripcion:"4. Numero de serie arrestor"},
              {id:5,descripcion:"5. Número de serie de Switch"},
              {id:6,descripcion:"6. Número de serie Access Point"},
              {id:7,descripcion:"7. Numero de serie UPS"},
              {id:8,descripcion:"8. Numero de serie Impresosa"},
              {id:9,descripcion:"9. Número de serie PC01"},
              {id:10,descripcion:"10. Número de serie PC02"},
              {id:11,descripcion:"11. Número de serie PC03"},
              {id:12,descripcion:"12. Número de serie PC04"},
              {id:13,descripcion:"13. Número de serie PC05"},
              {id:14,descripcion:"14. Foto frontal del FORCE 180/190"},
              {id:15,descripcion:"15. Foto posterior del FORCE 180/190"},
              {id:16,descripcion:"16. Sellado FORCE 180/190"},
              {id:17,descripcion:"17. Estructura donde se vea FORCE 180/190"},
              {id:18,descripcion:"18. Foto frontal del arrestor"},
              {id:19,descripcion:"19. Foto posterior del arrestor"},
              {id:20,descripcion:"20. Sellado arrestor"},
              {id:21,descripcion:"21. Estructura donde se vea arrestor"},
              {id:22,descripcion:"22. Aterramiento arrestor"},
              {id:23,descripcion:"23. Anclaje de mástil Frontal o piso"},
              {id:24,descripcion:"24. Anclaje de mástil posterior o piso"},
              {id:25,descripcion:"25. Ruteo SF/UTP vertical abajo"},
              {id:26,descripcion:"26. Ruteo SF/UTP exterior hacia sala de computo"},
              {id:27,descripcion:"27. Cable de pararrayo en torre"},
              {id:28,descripcion:"28. Cable de pararrayo en pozo"},
              {id:29,descripcion:"29. Ruteo cable de tierra vertical abajo"},
              {id:30,descripcion:"30. Ruteo cable de tierra horizontal"},
              {id:31,descripcion:"31. Panoramica Cableado datos 1 (canaleta abierta)"},
              {id:32,descripcion:"32. Panoramica Cableado datos 1 (canaleta cerrada)"},
              {id:33,descripcion:"33. Panoramica Cableado eléctrico 1 (canaleta abierta)"},
              {id:34,descripcion:"34. Panoramica Cableado eléctrico 1 (canaleta cerrada)"},
              {id:35,descripcion:"35. Tomas de energía (Abierto)"},
              {id:36,descripcion:"36. Tomas de energía (Cerrado)"},
              {id:37,descripcion:"37. Tablero General / Tablero Secundario"},
              {id:38,descripcion:"38. Breaker"},
              {id:39,descripcion:"39. Aterramiento en breaker"},
              {id:40,descripcion:"40. Impresora, UPS y computadora (s)"},
              {id:41,descripcion:"41. Foto Router, Switch"},
              {id:42,descripcion:"42. Foto AP"},
              {id:43,descripcion:"43. PC 01"},
              {id:44,descripcion:"44. PC 02"},
              {id:45,descripcion:"45. PC 03"},
              {id:46,descripcion:"46. PC 04"},
              {id:47,descripcion:"47. PC 05"},
              {id:48,descripcion:"48. UPS"},
              {id:49,descripcion:"49. Supresor de picos"},
              {id:50,descripcion:"50. Equipos en bandeja"},
              {id:51,descripcion:"51. Ubicación de equipos en bandeja"},
              {id:52,descripcion:"52. Acces Point"},
              {id:53,descripcion:"53. Etiquetado de equipos"},
              {id:54,descripcion:"54. Mastil y CPE"},
              {id:55,descripcion:"55. Vista interconexion y etiquetado supresor"},
              {id:56,descripcion:"56. Vista de conexiones y etiquetado POE"},
              {id:57,descripcion:"57. Conexión en Suppresor 220 VAC para PoE"},
              {id:58,descripcion:"58. Aterramiento arrestor lado BDT"},
              {id:59,descripcion:"59. Vista cable de tierra y BDT mástil"},
              {id:60,descripcion:"60. Vista cable de tierra y BDT pozo"},
              {id:61,descripcion:"61. Caja de registro SPAT - Pararrayos"},
              {id:62,descripcion:"62. Conexiones SPAT - Pararrayos"},
              {id:63,descripcion:"63. Caja de registro SPAT - Equipos"},
              {id:64,descripcion:"64. Conexiones SPAT - Equipos"},
              {id:65,descripcion:"65. Medición 1 SPAT Pararrayos"},
              {id:66,descripcion:"66. Medición 2 SPAT Pararrayos"},
              {id:67,descripcion:"67. Medición 3 SPAT Pararrayos"},
              {id:68,descripcion:"68. Certificado calibración Telurometro"},
              {id:69,descripcion:"69. Medición 1 SPAT Equipos"},
              {id:70,descripcion:"70. Medición 2 SPAT Equipos"},
              {id:71,descripcion:"71. Medición 3 SPAT Equipos"},
              {id:72,descripcion:"72. Foto DNI primera cara"},
              {id:73,descripcion:"73. Foto posterior DNI"},
              {id:74,descripcion:"74. Foto Computadoras"},
              {id:75,descripcion:"75. Foto panoramica de equipos"},
              {id:76,descripcion:"76. Foto panoramica con los equipos"},
              {id:77,descripcion:"77. Foto de la fachada de la IIBB"},
              {id:78,descripcion:"78. Foto de la fachada de lugar donde se realizó los modulos"},
              {id:79,descripcion:"79. Panoramica de la localidad"},
              {id:80,descripcion:"80. Panoramica de la plaza"}

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
                                        <figure class="figure" style="width:25px!important;height:20px!important;">
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