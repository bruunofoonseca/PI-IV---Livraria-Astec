    $('#validationCPF').formatter({
      'pattern': '{{999}}.{{999}}.{{999}}-{{99}}'
    });

    $('#validationCustom03').formatter({
      'pattern': '({{99}}){{9999}}-{{9999}}',
      'persistent': true // always displays the formatted character.
    });

    $('#validationCustom04').formatter({
      'pattern': '({{99}}){{99999}}-{{9999}}',
      'persistent': true // always displays the formatted character.
    });
    $('#cep').formatter({
      'pattern': '{{99999}}-{{999}}',
      'persistent': true // always displays the formatted character.
    });
    $('#valCartao').formatter({
      'pattern': '{{99}}/{{99}}',
      'persistent': true // always displays the formatted character.
    });
    $('#codSeg').formatter({
      'pattern': '{{999}}',
      'persistent': true // always displays the formatted character.
    });
    $('#qtdCodigoCartao').formatter({
      'pattern': '{{9999}}.{{9999}}.{{9999}}.{{9999}}',
      'persistent': true // always displays the formatted character.
    });