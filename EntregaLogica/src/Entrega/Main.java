package Entrega;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[10];
        String[] correos = new String[10];
        String[] claves = new String[10];
        String[] cursosUsuario = new String[10];

        String[] cursos = new String[10];
        double[] precios = new double[10];

        int totalUsuarios = 0;
        int totalCursos = 3;
        int usuarioActual = -1;
        int opcion = -1;

        boolean sesion = false;
        boolean admin = false;

        String correo;
        String clave;
        String r;

        String correoAdmin = "admin@cursos.com";
        String claveAdmin = "admin123";

        cursos[0] = "Desarrollo Web";
        cursos[1] = "JavaScript Moderno";
        cursos[2] = "CSS Avanzado";

        precios[0] = 159990;
        precios[1] = 179990;
        precios[2] = 149990;

        do {
            System.out.println("\n==============================");
            System.out.println("     PLATAFORMA DE CURSOS     ");
            System.out.println("==============================");

            if (!sesion) {
                System.out.println(" 1) Registrarse");
                System.out.println(" 2) Iniciar sesión");
                System.out.println(" 0) Salir");
            } else if (admin) {
                System.out.println(" 1) Ver usuarios");
                System.out.println(" 2) Cambiar precios");
                System.out.println(" 3) Eliminar usuario");
                System.out.println(" 4) Agregar curso");
                System.out.println(" 5) Eliminar curso");
                System.out.println(" 6) Cerrar sesión");
                System.out.println(" 0) Salir");
            } else {
                System.out.println(" 1) Ver cursos");
                System.out.println(" 2) Comprar curso");
                System.out.println(" 3) Ver perfil");
                System.out.println(" 4) Cerrar sesión");
                System.out.println(" 0) Salir");
            }

            System.out.println("------------------------------");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese una opción válida: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    if (!sesion) {
                        System.out.print("Nombre: ");
                        nombres[totalUsuarios] = sc.nextLine();
                        System.out.print("Correo: ");
                        correos[totalUsuarios] = sc.nextLine();
                        System.out.print("Contraseña: ");
                        claves[totalUsuarios] = sc.nextLine();
                        cursosUsuario[totalUsuarios] = "Ninguno";
                        totalUsuarios++;
                        System.out.println("Registro exitoso.");
                    } else if (admin) {
                        System.out.println("\n--- USUARIOS REGISTRADOS ---");
                        for (int i = 0; i < totalUsuarios; i++) {
                            System.out.println(" " + (i + 1) + ") " + nombres[i] +
                                    " | " + correos[i] +
                                    " | " + cursosUsuario[i]);
                        }
                    } else {
                        System.out.println("\n--- CURSOS DISPONIBLES ---");
                        for (int i = 0; i < totalCursos; i++) {
                            System.out.println(" " + (i + 1) + ") " + cursos[i] + " - $" + precios[i]);
                        }
                        System.out.print("Seleccione un curso: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        if (c > 0 && c <= totalCursos) {
                            cursosUsuario[usuarioActual] = cursos[c - 1];
                            System.out.println("Curso seleccionado.");
                        }
                    }
                    break;

                case 2:
                    if (!sesion) {
                        System.out.print("Correo: ");
                        correo = sc.nextLine();
                        System.out.print("Contraseña: ");
                        clave = sc.nextLine();

                        if (correo.equals(correoAdmin) && clave.equals(claveAdmin)) {
                            sesion = true;
                            admin = true;
                            System.out.println("Bienvenido ADMIN.");
                        } else {
                            boolean encontrado = false;
                            for (int i = 0; i < totalUsuarios; i++) {
                                if (correo.equals(correos[i]) && clave.equals(claves[i])) {
                                    sesion = true;
                                    usuarioActual = i;
                                    encontrado = true;
                                    System.out.println("Bienvenido " + nombres[i]);
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Datos incorrectos.");
                            }
                        }
                    } else if (admin) {
                        System.out.println("\n--- MODIFICAR PRECIOS ---");
                        for (int i = 0; i < totalCursos; i++) {
                            System.out.println(" " + (i + 1) + ") " + cursos[i] + " - $" + precios[i]);
                        }
                        System.out.print("Curso a modificar: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        if (c > 0 && c <= totalCursos) {
                            System.out.print("Nuevo precio: ");
                            precios[c - 1] = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Precio actualizado.");
                        }
                    } else {
                        if (!cursosUsuario[usuarioActual].equals("Ninguno")) {
                            System.out.print("¿Desea comprar el curso? (s/n): ");
                            r = sc.nextLine();
                            if (r.equalsIgnoreCase("s")) {
                                System.out.println("Compra realizada con éxito.");
                            }
                        } else {
                            System.out.println("Debe seleccionar un curso.");
                        }
                    }
                    break;

                case 3:
                    if (admin) {
                        System.out.println("\n--- ELIMINAR USUARIO ---");
                        for (int i = 0; i < totalUsuarios; i++) {
                            System.out.println(" " + (i + 1) + ") " + nombres[i]);
                        }
                        System.out.print("Usuario a eliminar: ");
                        int u = sc.nextInt();
                        sc.nextLine();

                        if (u > 0 && u <= totalUsuarios) {
                            for (int i = u - 1; i < totalUsuarios - 1; i++) {
                                nombres[i] = nombres[i + 1];
                                correos[i] = correos[i + 1];
                                claves[i] = claves[i + 1];
                                cursosUsuario[i] = cursosUsuario[i + 1];
                            }
                            totalUsuarios--;
                            System.out.println("Usuario eliminado.");
                        }
                    } else {
                        System.out.println("\n--- PERFIL ---");
                        System.out.println("Nombre: " + nombres[usuarioActual]);
                        System.out.println("Correo: " + correos[usuarioActual]);
                        System.out.println("Curso: " + cursosUsuario[usuarioActual]);
                    }
                    break;

                case 4:
                    if (admin) {
                        System.out.print("Nombre del curso: ");
                        cursos[totalCursos] = sc.nextLine();
                        System.out.print("Precio: ");
                        precios[totalCursos] = sc.nextDouble();
                        sc.nextLine();
                        totalCursos++;
                        System.out.println("Curso agregado.");
                    } else {
                        sesion = false;
                        usuarioActual = -1;
                        System.out.println("Sesión cerrada.");
                    }
                    break;

                case 5:
                    if (admin) {
                        System.out.println("\n--- ELIMINAR CURSO ---");
                        for (int i = 0; i < totalCursos; i++) {
                            System.out.println(" " + (i + 1) + ") " + cursos[i]);
                        }
                        System.out.print("Curso a eliminar: ");
                        int c = sc.nextInt();
                        sc.nextLine();

                        if (c > 0 && c <= totalCursos) {
                            for (int i = c - 1; i < totalCursos - 1; i++) {
                                cursos[i] = cursos[i + 1];
                                precios[i] = precios[i + 1];
                            }
                            totalCursos--;
                            System.out.println("Curso eliminado.");
                        }
                    }
                    break;

                case 6:
                    if (admin) {
                        sesion = false;
                        admin = false;
                        System.out.println("Sesión cerrada.");
                    }
                    break;

                case 0:
                    System.out.print("¿Desea salir? (s/n): ");
                    r = sc.nextLine();
                    if (!r.equalsIgnoreCase("s")) opcion = -1;
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}



