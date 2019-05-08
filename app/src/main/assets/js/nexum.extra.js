$(document).ready(function(){


    $("#send").on("click",function(){

        var email = $("#email").val();
        var pwd = $("#pwd").val();

        if(email == ""){
            alert("Complete el campo Email");
            return false;
        }

        if(pwd == ""){
            alert("Complete el campo Contraseña");
            return false;
        }

        var data = "email:"+email+","+"pwd:"+pwd+",action:send";

        if (confirm("Desea enviar el registro?")) {
            alert(data);
            Android.sendData(data);
        } else {

        }


    });


    $("#map-bandeja-flujo-pasos").on("click",function(){

            var idp = $(this).attr("idp");
            Android.openMapCustomers(idp);

    });


    $("#list-listas").on("change",function(){

        var idLista = $(this).val();
        Android.getCamposFromLista(idLista);

    });

    $(document).on("click","#search-on-list",function(){

        var idLista = $('#list-listas option:selected').val()
        var dataCampos = "";
        var ii = 0;

        $( ".input-campos" ).each(function() {

            if($(this).val() != ""){

                if(ii>0){
                dataCampos = dataCampos + ",";
                }

                dataCampos = dataCampos + $(this).attr("id")+"="+$(this).val();
                ii++;
            }

        });

        if(dataCampos != ""){
            Android.searchOnList(idLista,dataCampos);
            //alert(dataCampos);
        }else{
            alert("Ingrese un campo de busqueda");
        }

    });

    $(document).on("click",".get-info-data",function(){

        var idData = $(this).attr("id");
        Android.getInfoData(idData);
    });



});