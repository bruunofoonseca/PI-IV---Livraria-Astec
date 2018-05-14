
$(document).ready(function() { 
    ajustar();
});

function ajustar(){
    var altura = $("#navFixed").css("height");
    $(".ajustar").css("margin-top",altura);
}   

$(":input").inputmask();

$("#inputCustom6").inputmask({"mask": "999.999.999-99"});