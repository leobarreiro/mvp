var keycloak = new Keycloak({
    realm: 'mvp',
    clientId: 'mvp.spa'
});

keycloak.init({
    onLoad: 'login-required'
}).then(function (authenticated) {
    localStorage.setItem("auth.clientId", keycloak.clientId);
    localStorage.setItem("auth.token", keycloak.token);
    localStorage.setItem("auth.refreshToken", keycloak.refreshToken);
    localStorage.setItem("auth.subject", keycloak.subject);
    //alert(authenticated ? 'authenticated' : 'not authenticated');
}).catch(function (err) {
    localStorage.setItem("auth.clientId", "");
    localStorage.setItem("auth.token", "");
    localStorage.setItem("auth.refreshToken", "");
    localStorage.setItem("auth.subject", "");
    //alert('failed to initialize' + err);
});