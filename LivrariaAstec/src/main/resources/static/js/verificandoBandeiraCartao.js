console.log("ok");
function calcular() {
            var digitoVerificado = document.querySelector('#qtdCodigoCartao').value;
            var tratandoDigitoVerificado = digitoVerificado.substring(0,1);
            var passandoValor = document.getElementById('valorBandeira');


            var parametros = [
                                '<img src="/imagens/1.png"/>',
                                '<img src="/imagens/2.png"/>',
                                '<img src="/imagens/3.png"/>',
                                'VISA',
                                'MASTERCARD',
                                'ELO'
                            ];

            if(tratandoDigitoVerificado == 4){
                document.getElementById('resultado').innerHTML = parametros[1];
                passandoValor.value = parametros[3];
            }   
            else if(tratandoDigitoVerificado == 5){
                document.getElementById('resultado').innerHTML = parametros[0];
                passandoValor.value = parametros[4];
            }   
            else if(tratandoDigitoVerificado == 6){
                document.getElementById('resultado').innerHTML = parametros[2];
                passandoValor.value = parametros[5];
            }
            else{
                alert("Cartão invalido!, verifique o numero digitado");
                
            }
}