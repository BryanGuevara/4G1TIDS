package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int o = 0, s = 0, p = 0;
        Scanner in = new Scanner(System.in);
        Futbolista fut = new Futbolista();
        Entrenador ent = new Entrenador();
        Masajista msj = new Masajista();

        while (o <= 4) {
            o = 0;
            System.out.print("""
                            ============= <[Menu]> =============
                             
                                 Elija una opcion: 
                                 1- Futbolistas 
                                 2- Entrenadores 
                                 3- Mesajistas
                                 4- Personas
                                 5- Finalizar
                             
                             ==================================
                                 """);
            o = in.nextInt();

            if (o == 1) {

                while (s <= 4) {
                    o = 0;
                    System.out.print("""
                                 ========== <[Futbolistas]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Concentrarse 
                                  2- Viajar 
                                  3- Entrenar 
                                  4- Jugar
                                  5- Volver
                                 
                                =================================
                                 """);
                    s = in.nextInt();
                    if (s == 1) {
                        System.out.println("\n=================================\n");
                        fut.Concentrarse();
                        System.out.println("\n=================================\n");

                    } else {
                        if (s == 2) {
                            System.out.println("\n=================================\n");
                            fut.Viajar();
                            System.out.println("\n=================================\n");

                        } else {
                            if (s == 3) {
                                System.out.println("\n=================================\n");
                                fut.Entrenar();
                                System.out.println("\n=================================\n");

                            } else {
                                if (s == 4) {
                                    System.out.println("\n=================================\n");
                                    fut.jugarPartido();
                                    System.out.println("\n=================================\n");

                                } else {
                                }
                            }
                        }
                    }
                }
            } else {
                if (o == 2) {
                    while (s <= 4) {
                        s = 0;
                        System.out.print("""
                                 ========== <[Entrenadores]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Concentrarse 
                                  2- Viajar 
                                  3- Dirigir Partido
                                  4- Dirigir Entrenamiento
                                  5- Volver
                                 
                                =================================
                                 """);
                        s = in.nextInt();
                        if (s == 1) {
                            System.out.println("\n=================================\n");
                            ent.Concentrarse();
                            System.out.println("\n=================================\n");

                        } else {
                            if (s == 2) {
                                System.out.println("\n=================================\n");
                                ent.Viajar();
                                System.out.println("\n=================================\n");

                            } else {
                                if (s == 3) {
                                    System.out.println("\n=================================\n");
                                    ent.DirigirPartido();
                                    System.out.println("\n=================================\n");

                                } else {
                                    if (s == 4) {
                                        System.out.println("\n=================================\n");
                                        ent.DirijgirEntrenamiento();
                                        System.out.println("\n=================================\n");

                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                if (o == 3) {
                    s = 0;
                    while (s <= 3) {
                        System.out.print("""
                                 ========== <[Masajistas]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Concentrarse 
                                  2- Viajar 
                                  3- Dar el Mensaje
                                  4- Volver
                                 
                                =================================
                                 """);
                        s = in.nextInt();
                        if (s == 1) {
                            System.out.println("\n=================================\n");
                            msj.Concentrarse();
                            System.out.println("\n=================================\n");

                        } else {
                            if (s == 2) {
                                System.out.println("\n=================================\n");
                                msj.Viajar();
                                System.out.println("\n=================================\n");

                            } else {
                                if (s == 3) {
                                    System.out.println("\n=================================\n");
                                    msj.DarMensaje();;
                                    System.out.println("\n=================================\n");

                                }
                            }
                        }
                    }
                } else {
                    if (o == 4) {

                        while (s <= 3) {
                            s = 0;
                            System.out.print("""
                                 ========= <[Personas]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Futbolista 
                                  2- Entrenador
                                  3- Masajista
                                  4- Volver
                                 
                                =================================
                                 """);
                            s = in.nextInt();

                            if (s == 1) {
                                while (p <= 2) {
                                    p = 0;
                                    System.out.print("""
                                 ========== <Futbolistas]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Añadir o Reemplazar
                                  2- Mostrar
                                  3- Salir y Eliminar
                                 
                                =================================
                                 """);
                                    p = in.nextInt();
                                    if (p == 1) {
                                        System.out.println("\n======= <[Ingrese los datos]> ========\n");
                                        System.out.print("Ingrese el Id:");
                                        fut.ID = in.nextInt();
                                        System.out.print("Ingrese el Nombre:");
                                        fut.Nombre = in.next();
                                        System.out.print("Ingrese el Apellido:");
                                        fut.Apellidos = in.next();
                                        System.out.print("Ingrese la Edad:");
                                        fut.Edad = in.nextInt();
                                        System.out.print("Ingrese Dorsal:");
                                        fut.dorsal = in.nextInt();
                                        System.out.print("Ingrese Demarcación:");
                                        fut.Demarcacion = in.next();
                                        System.out.println("\n=================================\n");
                                        p = 0;
                                    } else {
                                        if (p == 2) {

                                            System.out.println("\n============ <[datos]> ============\n");
                                            System.out.println("Id: " + fut.ID);
                                            System.out.println("Nombre: " + fut.Nombre);
                                            System.out.println("Apellido: " + fut.Apellidos);
                                            System.out.println("Edad: " + fut.Edad);
                                            System.out.println("Dorsal: " + fut.dorsal);
                                            System.out.println("Demarcación: " + fut.Demarcacion);
                                            System.out.println("\n=================================\n");
                                        }
                                    }
                                }

                            } else {
                                if (s == 2) {
                                    while (p <= 2) {
                                        p = 0;
                                        System.out.print("""
                                 ========== <Entrenadores]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Añadir o Reemplazar
                                  2- Mostrar
                                  3- Salir y Eliminar
                                 
                                =================================
                                 """);
                                        p = in.nextInt();
                                        if (p == 1) {
                                            System.out.println("\n======= <[Ingrese los datos]> ========\n");
                                            System.out.print("Ingrese el Id:");
                                            ent.ID = in.nextInt();
                                            System.out.print("Ingrese el Nombre:");
                                            ent.Nombre = in.next();
                                            System.out.print("Ingrese el Apellido:");
                                            ent.Apellidos = in.next();
                                            System.out.print("Ingrese la Edad:");
                                            ent.Edad = in.nextInt();
                                            System.out.print("Ingrese ID de la Federacion:");
                                            ent.idFederacion = in.nextInt();
                                            System.out.println("\n=================================\n");
                                            p = 0;
                                        } else {
                                            if (p == 2) {

                                                System.out.println("\n============ <[datos]> ============\n");
                                                System.out.println("Id: " + ent.ID);
                                                System.out.println("Nombre: " + ent.Nombre);
                                                System.out.println("Apellido: " + ent.Apellidos);
                                                System.out.println("Edad: " + ent.Edad);
                                                System.out.println("ID de la Federacion: " + ent.idFederacion);
                                                System.out.println("\n=================================\n");
                                            }
                                        }
                                    }
                                } else {
                                    if (s == 3) {
                                        while (p <= 2) {
                                            p = 0;
                                            System.out.print("""
                                ========== <Masajista]> ===========
                                                                  
                                  Elija una opcion: 
                                  1- Añadir o Reemplazar
                                  2- Mostrar
                                  3- Salir y Eliminar
                                 
                                =================================
                                 """);
                                            p = in.nextInt();
                                            if (p == 1) {
                                                System.out.println("\n======= <[Ingrese los datos]> ========\n");
                                                System.out.print("Ingrese el Id:");
                                                msj.ID = in.nextInt();
                                                System.out.print("Ingrese el Nombre:");
                                                msj.Nombre = in.next();
                                                System.out.print("Ingrese el Apellido:");
                                                msj.Apellidos = in.next();
                                                System.out.print("Ingrese la Edad:");
                                                msj.Edad = in.nextInt();
                                                System.out.print("Ingrese Años de Experiencia:");
                                                msj.AniosExperiencia = in.nextInt();
                                                System.out.print("Ingrese Titulacion:");
                                                msj.Titulacion = in.next();
                                                System.out.println("\n=================================\n");
                                                p = 0;
                                            } else {
                                                if (p == 2) {

                                                    System.out.println("\n============ <[datos]> ============\n");
                                                    System.out.println("Id: " + msj.ID);
                                                    System.out.println("Nombre: " + msj.Nombre);
                                                    System.out.println("Apellido: " + msj.Apellidos);
                                                    System.out.println("Edad: " + msj.Edad);
                                                    System.out.println("Años de Experiencia: " + msj.AniosExperiencia);
                                                    System.out.println("Titulacion: " + msj.Titulacion);
                                                    System.out.println("\n=================================\n");
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    } else {
                        if (o == 5) {

                            System.out.print("""
                                 ========== <[Apagando]> ===========
                                                                  
                                    ⚠ Cerrando Programa ⚠
                                 
                                =================================
                                 """);
                        } else {
                            o = 0;
                            System.out.print("""
                                 ============= <[Error]>= ===========
                                                                  
                                    🚫 Opcion no valida 🚫
                                 
                                ===================================
                                 """);
                        }
                    }
                }
            }
        }
    }
}
