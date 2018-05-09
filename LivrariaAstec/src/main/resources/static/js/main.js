
$(document).ready(function() { 
    ajustar();
});

function ajustar(){
    var altura = $("#navFixed").css("height");
    $(".ajustar").css("margin-top",altura);
}   

