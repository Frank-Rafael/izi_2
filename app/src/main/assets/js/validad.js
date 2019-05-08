function valida(v,t)
{
var patt1 = /^([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])\s([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9])$/;
var patt2 = /^([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/;
var patt3 = /^(?:(?:([01]?\d|2[0-3]):)?([0-5]?\d):)?([0-5]?\d)$/;   
var patt4 = /(^\\s|[,.\\"\\'\\*\\!#~!¿¡\\'])/;
var patt5 = /^\s*[\w\-\+_]+(\.[\w\-\+_]+)*\@[\w\-\+_]+\.[\w\-\+_]+(\.[\w\-\+_]+)*\s*$/;
var patt6 = new RegExp("(\\D|\\s)");
var patt7 = new RegExp("(\\s|\\d)");
var patt8 = /^(((\d{1,3})(,\d{3})*)|(\d+))(.\d+)?$/;
var patt9 = /^[0-9]*[.][0-9]+$/;
var patt10 = /^[a-zA-ZñÑ\s]*$/;
var patt11 = /^[a-zA-ZñÑ0-9]*$/;
var patt12 = /^[a-zA-ZñÑ0-9\s]*$/;
if(v==null || v.trim()=="")
{return false;}
else
{
	
if(t=="HF") /*fecha-hora*/
{if(v.match(patt1)){return true;}else{return false;}}
else if(t=="FE") /*fecha*/
{if(v.match(patt2)){return true;}else{return false;}}
else if(t=="HO") /*hora*/
{if(v.match(patt3)){return true;}else{return false;}}
else if(t=="TC") /*??*/
{if(v.match(patt4)){return true;}else{return false;}}
else if(t=="EM") /*email*/
{if(v.match(patt5)){return true;}else{return false;}}
else if(t=="NU")  /*entero*/
{if(!patt6.test(v)){return true;}else{return false;}}
else if(t=="NE") /*TEXTO SIN ESPACIOS (SOLO LETRAS)*/
{if(!patt7.test(v)){return true;}else{return false;}}
else if(t=="NG") /*Entero o Flotante*/
{if(v.match(patt8)){return true;}else{return false;}}
else if(t=="FL") /*Flotante*/
{if(v.match(patt9)){return true;}else{return false;}}
else if(t=="TX") /*Solo letras y espacios*/
{if(v.match(patt10)){return true;}else{return false;}}
else if(t=="AN") /*Solo alfanumerico*/
{if(v.match(patt11)){return true;}else{return false;}}
else if(t=="AA") /*Solo alfanumerico + espacios*/
{if(v.match(patt12)){return true;}else{return false;}}
else{return false;}

}
}