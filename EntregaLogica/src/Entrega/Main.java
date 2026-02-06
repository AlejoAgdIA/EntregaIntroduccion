package Entrega;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Datos del usuario
        String nombreGuardado = "";
        String correoGuardado = "";
        String passGuardado = "";

        boolean sesionIniciada = false;

        // Cursos
        String titulo1 = "Desarrollo Web";
        double precio1 = 159990;

        String titulo2 = "JavaScript Moderno";
        double precio2 = 179990;

        String titulo3 = "CSS Avanzado";
        double precio3 = 149990;

        String cursoSeleccionado = "";
        double precioSeleccionado = 0;

        int opcion;

        do {
            System.out.println("\n===== PLATAFORMA DE CURSOS =====");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Ver cursos y elegir");
            System.out.println("4. Ver características y comprar");
            System.out.println("5. Actualizar datos del usuario");
            System.out.println("6. Buscar usuario");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            // REGISTRO
            if (opcion == 1) {
                System.out.print("Nombre: ");
                nombreGuardado = sc.nextLine();

                System.out.print("Correo: ");
                correoGuardado = sc.nextLine();

                System.out.print("Contraseña: ");
                passGuardado = sc.nextLine();

                System.out.println("Registro exitoso.");
            }

            // LOGIN
            else if (opcion == 2) {
                System.out.print("Correo: ");
                String correo = sc.nextLine();

                System.out.print("Contraseña: ");
                String pass = sc.nextLine();

                if (correo.equals(correoGuardado) && pass.equals(passGuardado)) {
                    System.out.println("Bienvenido " + nombreGuardado);
                    sesionIniciada = true;
                } else {
                    System.out.println("Datos incorrectos.");
                }
            }

            // VER CURSOS
            else if (opcion == 3) {
                System.out.println("\nCursos disponibles:");
                System.out.println("1. " + titulo1 + " - $" + precio1);
                System.out.println("2. " + titulo2 + " - $" + precio2);
                System.out.println("3. " + titulo3 + " - $" + precio3);

                System.out.print("Seleccione un curso (1-3): ");
                int elegir = sc.nextInt();
                sc.nextLine();

                if (elegir == 1) {
                    cursoSeleccionado = titulo1;
                    precioSeleccionado = precio1;
                } else if (elegir == 2) {
                    cursoSeleccionado = titulo2;
                    precioSeleccionado = precio2;
                } else if (elegir == 3) {
                    cursoSeleccionado = titulo3;
                    precioSeleccionado = precio3;
                } else {
                    System.out.println("Selección inválida.");
                }

                if (!cursoSeleccionado.equals("")) {
                    System.out.println("Curso seleccionado: " + cursoSeleccionado);
                }
            }

            // COMPRAR
            else if (opcion == 4) {
                System.out.println("\nCaracterísticas del curso:");
                System.out.println("- Clases 100% online");
                System.out.println("- Certificado al finalizar");
                System.out.println("- Acceso ilimitado");
                System.out.println("- Soporte académico");

                if (!sesionIniciada) {
                    System.out.println("Debe iniciar sesión para comprar.");
                }
                else if (!cursoSeleccionado.equals("")) {
                    System.out.println("Curso elegido: " + cursoSeleccionado);
                    System.out.println("Precio: $" + precioSeleccionado);

                    System.out.print("¿Desea comprar el curso? (s/n): ");
                    String respuesta = sc.nextLine();

                    if (respuesta.equals("s")) {
                        System.out.println("Compra realizada con éxito.");
                    } else {
                        System.out.println("Compra cancelada.");
                    }
                } else {
                    System.out.println("Primero debe elegir un curso.");
                }
            }

            // ACTUALIZAR DATOS
            else if (opcion == 5) {
                if (!sesionIniciada) {
                    System.out.println("Debe iniciar sesión para actualizar datos.");
                } else {
                    System.out.print("Nuevo nombre: ");
                    nombreGuardado = sc.nextLine();

                    System.out.print("Nuevo correo: ");
                    correoGuardado = sc.nextLine();

                    System.out.print("Nueva contraseña: ");
                    passGuardado = sc.nextLine();

                    System.out.println("Datos actualizados correctamente.");
                }
            }

            // BUSCAR USUARIO
            else if (opcion == 6) {
                System.out.print("Ingrese el correo a buscar: ");
                String correoBuscar = sc.nextLine();

                if (correoBuscar.equals(correoGuardado)) {
                    System.out.println("Usuario encontrado:");
                    System.out.println("Nombre: " + nombreGuardado);
                    System.out.println("Correo: " + correoGuardado);
                } else {
                    System.out.println("Usuario no encontrado.");
                }
            }

            // VER PERFIL
            else if (opcion == 7) {
                if (!sesionIniciada) {
                    System.out.println("Debe iniciar sesión para ver el perfil.");
                } else {
                    System.out.println("\n--- PERFIL DEL USUARIO ---");
                    System.out.println("Nombre: " + nombreGuardado);
                    System.out.println("Correo: " + correoGuardado);
                    if (!cursoSeleccionado.equals("")) {
                        System.out.println("Curso seleccionado: " + cursoSeleccionado);
                    } else {
                        System.out.println("Curso seleccionado: Ninguno");
                    }
                }
            }

            // CERRAR SESIÓN
            else if (opcion == 8) {
                if (sesionIniciada) {
                    sesionIniciada = false;
                    System.out.println("Sesión cerrada correctamente.");
                } else {
                    System.out.println("No hay ninguna sesión iniciada.");
                }
            }

            // SALIR CON CONFIRMACIÓN
            else if (opcion == 0) {
                System.out.println("Gracias por usar la plataforma.");
            }

            else {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
