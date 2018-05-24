console.log("ok");
function calcular() {
            var n1 = parseInt(document.querySelector('#inputCustom2').value);
            console.log(n1);
            var img = ['<img src="/imagens/1.png"/>','<img src="/imagens/2.png"/>','<img src="/imagens/3.png"/>'];

            if(n1 >= 1 && n1 <= 4){
                document.getElementById('resultado').innerHTML = img[0];
            }   
            else if(n1 > 4 && n1 <= 8){
                document.getElementById('resultado').innerHTML = img[1];
            }   
            else if(n1 > 8){
                document.getElementById('resultado').innerHTML = img[2];
            }    
}