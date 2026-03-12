function accesoSistema(){

const USER = "admin";
const PASS = "1234";

let intentos = 0;

while(intentos < 3){

let u = prompt("Ingrese usuario");
let p = prompt("Ingrese contraseña");

if(u === USER && p === PASS){
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