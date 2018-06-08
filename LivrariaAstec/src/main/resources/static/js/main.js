$(document).ready(function() { 
    ajustar();
//    $('#validationDate').mask('00/00/0000');
//    $('#validationCustom03').mask('(00) 0000-0000');
//    $('#validationCustom04').mask('(00) 00000-0000');
//    $('#validationCPF').mask('000.000.000-00', {reverse: true});
//    $('#validationCep').mask('00000-000');
});

//$('#validationCPF').formatter({
//  'pattern': '{{9999}}-{{9999}}-{{9999}}-{{9999}}'
//});

function ajustar(){
   var altura = $("#navFixed").css("height");
    $(".ajustar").css("margin-top",altura);
}