var modulo = angular.module('veiculo', ['ngRoute','auth', 'toastr', 'ui.bootstrap']);

modulo.constant('authConfig', {
    urlUsuario: 'http://localhost:50992/api/funcionario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/telaMenu',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});