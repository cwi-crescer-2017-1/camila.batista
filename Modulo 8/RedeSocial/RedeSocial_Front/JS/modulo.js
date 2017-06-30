var rede = angular.module('rede', ['ngRoute', 'auth', 'toastr']);

rede.constant('authConfig',{
    urlUsuario: 'http://localhost:9090/api/usuario',

    urlLogin: '/login',

    urlPrivada: '/dashboard',

    urlLogout: '/login'
});