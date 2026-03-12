function accesoSistema(){

const usuario = "admin";
const contraseña = "1234";

let intentos = 0;

while(intentos < 3){

let u = prompt("Ingrese usuario");
let p = prompt("Ingrese contraseña");

if(u === usuario && p === contraseña){
console.log("Acceso permitido. Bienvenido.");
return;
}

intentos++;

if(intentos < 3){
console.log("Credenciales incorrectas. Intento " + intentos + " de 3");
}else{
console.log("Usuario bloqueado por demasiados intentos.");
}

}

}

accesoSistema();
