"use strict";

$(document).ready(function(){

    console.log("Loading...");

    //Evento al dar click en el boton Firmar
    $(".firma").on("click",function(){
            let itemID = $(this).attr("id"); //ID del item
            Android.capturarFirma(); // Invoca al metodo capturarFoto(itemID) que esta en la clase MainActivity
        });

});