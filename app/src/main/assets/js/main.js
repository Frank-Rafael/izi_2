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


    $("#take-pic").on("click",function(){

            Android.takePicture();

    });


});