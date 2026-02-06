package Entrega;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Usuario
        String nombreGuardado = "";
        String correoGuardado = "";
        String passGuardado = "";

        boolean sesionIniciada = false;
        boolean esAdmin = false;

        // Admin
        String correoAdmin = "admin@cursos.com";
        String passAdmin = "admin123";

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

            if (!sesionIniciada) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("0. Salir");
            }
            else if (esAdmin) {
                System.out.println("7. Ver datos del usuario");
                System.out.println("8. Modificar precios de cursos");
                System.out.println("9. Cerrar sesión");
                System.out.println("0. Salir");
            }
            else {
                System.out.println("3. Ver cursos y elegir");
                System.out.println("4. Ver características y comprar");
                System.out.println("5. Actualizar datos del usuario");
                System.out.println("6. Ver perfil");
                System.out.println("9. Cerrar sesión");
                System.out.println("0. Salir");
            }

            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            // REGISTRO USUARIO
            if (opcion == 1 && !sesionIniciada) {
                System.out.print("Nombre: ");
                nombreGuardado = sc.nextLine();

                System.out.print("Correo: ");
                correoGuardado = sc.nextLine();

                System.out.print("Contraseña: ");
                passGuardado = sc.nextLine();

                System.out.println("Registro exitoso.");
            }

            // LOGIN
            else if (opcion == 2 && !sesionIniciada) {
                System.out.print("Correo: ");
                String correo = sc.nextLine();

                System.out.print("Contraseña: ");
                String pass = sc.nextLine();

                if (correo.equals(correoAdmin) && pass.equals(passAdmin)) {
                    sesionIniciada = true;
                    esAdmin = true;
                    System.out.println("Bienvenido ADMINISTRADOR");
                }
                else if (correo.equals(correoGuardado) && pass.equals(passGuardado)) {
                    sesionIniciada = true;
                    esAdmin = false;
                    System.out.println("Bienvenido " + nombreGuardado);
                }
                else {
                    System.out.println("Datos incorrectos.");
                }
            }

            // VER CURSOS (USUARIO)
            else if (opcion == 3 && sesionIniciada && !esAdmin) {
                System.out.println("1. " + titulo1 + " - $" + precio1);
                System.out.println("2. " + titulo2 + " - $" + precio2);
                System.out.println("3. " + titulo3 + " - $" + precio3);

                System.out.print("Seleccione un curso: ");
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
                }

                System.out.println("Curso seleccionado: " + cursoSeleccionado);
            }

            // COMPRAR
            else if (opcion == 4 && sesionIniciada && !esAdmin) {
                if (!cursoSeleccionado.equals("")) {
                    System.out.print("¿Desea comprar el curso? (s/n): ");
                    String r = sc.nextLine();

                    if (r.equals("s")) {
                        System.out.println("Compra realizada con éxito.");
                    }
                } else {
                    System.out.println("Debe seleccionar un curso.");
                }
            }

            // ACTUALIZAR DATOS
            else if (opcion == 5 && sesionIniciada && !esAdmin) {
                System.out.print("Nuevo nombre: ");
                nombreGuardado = sc.nextLine();

                System.out.print("Nuevo correo: ");
                correoGuardado = sc.nextLine();

                System.out.print("Nueva contraseña: ");
                passGuardado = sc.nextLine();

                System.out.println("Datos actualizados.");
            }

            // VER PERFIL
            else if (opcion == 6 && sesionIniciada && !esAdmin) {
                System.out.println("Nombre: " + nombreGuardado);
                System.out.println("Correo: " + correoGuardado);
                System.out.println("Curso: " + cursoSeleccionado);
            }

            // ADMIN: VER USUARIO
            else if (opcion == 7 && esAdmin) {
                System.out.println("Usuario registrado:");
                System.out.println("Nombre: " + nombreGuardado);
                System.out.println("Correo: " + correoGuardado);
                System.out.println("Curso: " + cursoSeleccionado);
            }

            // ADMIN: MODIFICAR PRECIOS
            else if (opcion == 8 && esAdmin) {
                System.out.print("Nuevo precio Desarrollo Web: ");
                precio1 = sc.nextDouble();
                System.out.print("Nuevo precio JavaScript: ");
                precio2 = sc.nextDouble();
                System.out.print("Nuevo precio CSS: ");
                precio3 = sc.nextDouble();
                sc.nextLine();

                System.out.println("Precios actualizados.");
            }

            // CERRAR SESIÓN
            else if (opcion == 9 && sesionIniciada) {
                sesionIniciada = false;
                esAdmin = false;
                System.out.println("Sesión cerrada.");
            }

            // SALIR
            else if (opcion == 0) {
                System.out.print("¿Desea salir? (s/n): ");
                String salir = sc.nextLine();
                if (!salir.equals("s")) opcion = -1;
                else System.out.println("Gracias por usar la plataforma.");
            }

        } while (opcion != 0);
    }
}
