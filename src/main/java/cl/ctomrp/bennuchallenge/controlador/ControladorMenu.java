package cl.ctomrp.bennuchallenge.controlador;

import cl.ctomrp.bennuchallenge.funcion.EjecutarOpcion;
import cl.ctomrp.bennuchallenge.funcion.VerMenu;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class ControladorMenu {
    
    public static void ejecutarMenu() throws IOException {
        
        int op = 0;
        String fichero = "archivoNumerosAleatorios.txt";
        File archivo = new File(fichero);
        Scanner input = new Scanner(System.in);
        Scanner inputNumero = new Scanner(System.in);
        VerMenu menu = new VerMenu();
        
        do{
            menu.verMenu();
            System.out.print("Ingrese una opción: ");
            
            if (input.hasNextInt()) {
                op = input.nextInt();                
            } else {
                System.out.println("Debe ingresar una opción válida.");
                input.nextLine();
            }

            switch (op) {
                case 1:
                    EjecutarOpcion.crearArchivo("archivoNumerosAleatorios.txt");
                    ArrayList<Integer> listaNumeros = EjecutarOpcion.generadorNumeros(10);
                    EjecutarOpcion.escribirNumerosEnArchivo("archivoNumerosAleatorios.txt", listaNumeros);
                    System.out.println("Se creó un archivo en la carpeta del proyecto.\n");
                    break;
                case 2:
                    try{
                        System.out.print("Los números almacenados en el archivo son: ");
                        EjecutarOpcion.leerNumerosEnArchivo("archivoNumerosAleatorios.txt");
                        System.out.println("");
                    }catch(Exception e){
                        System.out.println("\nEl archivo que intenta leer no existe. Seleccione la opción 1 para crear un archivo.\n");
                    }
                    break;
                case 3:
                    try{
                        long tInicial = System.currentTimeMillis();
                        EjecutarOpcion.escribirNumerosEnArchivo("archivoOrdenadoSort.txt", EjecutarOpcion.ordenarConSort("archivoNumerosAleatorios.txt"));
                        long tFinal = System.currentTimeMillis();
                        System.out.println("Sort ordenó en " + (tFinal - tInicial) + " milisegundos.");
                        tInicial = System.currentTimeMillis();
                        EjecutarOpcion.escribirNumerosEnArchivo("archivoOrdenadoBubbleSort.txt", EjecutarOpcion.ordenarConBubbleSort("archivoNumerosAleatorios.txt"));
                        tFinal = System.currentTimeMillis();
                        System.out.println("BubbleSort ordenó en " + (tFinal - tInicial) + " milisegundos.");
                        System.out.println("Se ordenaron los números y se almacenaron en los archivos 'archivoOrdenadoSort.txt' y 'archivoOrdenadoBubbleSort.txt'.\n");
                    }catch(Exception e){
                        System.out.println("El archivo que intenta ordenar no existe. Seleccione la opción 1 para crear un archivo.\n");
                    }
                    break;
                case 4:
                    try{
                        System.out.println("Ordenamiento con método sort de Collections:");
                        EjecutarOpcion.leerNumerosEnArchivo("archivoOrdenadoSort.txt");
                        System.out.println("Ordenamiento con método burbuja:");
                        EjecutarOpcion.leerNumerosEnArchivo("archivoOrdenadoBubbleSort.txt");
                        System.out.println("");
                    }catch(Exception e) {
                        System.out.println("El archivo que intenta leer no existe. Seleccione la opción 1 para generar un archivo y luego seleccione la opción 3 para ordenar los números en otro archivo.\n");
                    }
                    break;
                case 5:
                    if(archivo.exists()){
                        try{
                            System.out.print("Ingrese el número que desea buscar: ");
                            int numero = inputNumero.nextInt();

                            if (EjecutarOpcion.buscarNumero(numero, fichero)) {
                                System.out.println("El número se encuentra dentro del archivo.\n");
                            } else {
                                System.out.println("El número no se encuentra dentro del archivo.\n");
                            }
                        }catch(Exception e){
                            System.out.println("Ingrese un número entero.\n");
                            inputNumero.nextLine();
                        }
                    }else{
                        System.out.println("No existe un archivo. Para crear un archivo con números seleccione la opción 1.\n");
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opción incorrecta, seleccione entre 1 y 6.\n");
            }
        }while(op != 6);
    }
    
}
