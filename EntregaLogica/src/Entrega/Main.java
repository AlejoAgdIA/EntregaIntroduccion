package Entrega;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombreGuardado = "";
        String correoGuardado = "";
        String passGuardado = "";

        String correoAdmin = "admin@cursos.com";
        String passAdmin = "admin123";

        boolean sesionIniciada = false;
        boolean esAdmin = false;

        String titulo1 = "Desarrollo Web";
        String titulo2 = "JavaScript Moderno";
        String titulo3 = "CSS Avanzado";

        double precio1 = 159990;
        double precio2 = 179990;
        double precio3 = 149990;

        String cursoSeleccionado = "";
        double precioSeleccionado = 0;

        int opcion = -1;
        int elegir;
        String correo;
        String pass;
        String r;
        String salir;

        do {
            System.out.println("\n===== PLATAFORMA DE CURSOS =====");

            if (!sesionIniciada) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("0. Salir");
            } else if (esAdmin) {
                System.out.println("7. Ver datos del usuario");
                System.out.println("8. Modificar precios de cursos");
                System.out.println("9. Cerrar sesión");
                System.out.println("0. Salir");
            } else {
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

            if (opcion == 1 && !sesionIniciada) {
                System.out.print("Nombre: ");
                nombreGuardado = sc.nextLine();
                System.out.print("Correo: ");
                correoGuardado = sc.nextLine();
                System.out.print("Contraseña: ");
                passGuardado = sc.nextLine();
                System.out.println("Registro exitoso.");
            }
            else if (opcion == 2 && !sesionIniciada) {
                System.out.print("Correo: ");
                correo = sc.nextLine();
                System.out.print("Contraseña: ");
                pass = sc.nextLine();

                if (correo.equals(correoAdmin) && pass.equals(passAdmin)) {
                    sesionIniciada = true;
                    esAdmin = true;
                    System.out.println("Bienvenido ADMINISTRADOR");
                } else if (correo.equals(correoGuardado) && pass.equals(passGuardado)) {
                    sesionIniciada = true;
                    esAdmin = false;
                    System.out.println("Bienvenido " + nombreGuardado);
                } else {
                    System.out.println("Datos incorrectos.");
                }
            }
            else if (opcion == 3 && sesionIniciada && !esAdmin) {
                System.out.println("1. " + titulo1 + " - $" + precio1);
                System.out.println("2. " + titulo2 + " - $" + precio2);
                System.out.println("3. " + titulo3 + " - $" + precio3);

                System.out.print("Seleccione un curso: ");
                elegir = sc.nextInt();
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
            else if (opcion == 4 && sesionIniciada && !esAdmin) {
                if (!cursoSeleccionado.equals("")) {
                    System.out.print("¿Desea comprar el curso? (s/n): ");
                    r = sc.nextLine();
                    if (r.equalsIgnoreCase("s")) {
                        System.out.println("Compra realizada con éxito.");
                    }
                } else {
                    System.out.println("Debe seleccionar un curso.");
                }
            }
            else if (opcion == 5 && sesionIniciada && !esAdmin) {
                System.out.print("Nuevo nombre: ");
                nombreGuardado = sc.nextLine();
                System.out.print("Nuevo correo: ");
                correoGuardado = sc.nextLine();
                System.out.print("Nueva contraseña: ");
                passGuardado = sc.nextLine();
                System.out.println("Datos actualizados.");
            }
            else if (opcion == 6 && sesionIniciada && !esAdmin) {
                System.out.println("Nombre: " + nombreGuardado);
                System.out.println("Correo: " + correoGuardado);
                System.out.println("Curso: " + cursoSeleccionado);
            }
            else if (opcion == 7 && esAdmin) {
                System.out.println("Nombre: " + nombreGuardado);
                System.out.println("Correo: " + correoGuardado);
                System.out.println("Curso: " + cursoSeleccionado);
            }
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
            else if (opcion == 9 && sesionIniciada) {
                sesionIniciada = false;
                esAdmin = false;
                System.out.println("Sesión cerrada.");
            }
            else if (opcion == 0) {
                System.out.print("¿Desea salir? (s/n): ");
                salir = sc.nextLine();
                if (!salir.equalsIgnoreCase("s")) {
                    opcion = -1;
                } else {
                    System.out.println("Gracias por usar la plataforma.");
                }
            }

        } while (opcion != 0);
    }
}
