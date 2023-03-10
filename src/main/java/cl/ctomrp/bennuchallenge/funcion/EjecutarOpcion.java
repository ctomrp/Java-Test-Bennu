package cl.ctomrp.bennuchallenge.funcion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class EjecutarOpcion {
    
    public static void crearArchivo(String nombreArchivo) throws IOException{
        File archivo = new File(nombreArchivo);
        archivo.createNewFile();
    }
    
    public static List<Integer> generadorNumeros(int cantidadNumeros){
        Random numeroAleatorio = new Random();
        List<Integer> listaNumeros = new ArrayList<>();  
        
        for(int i = 0; i < cantidadNumeros; i++){
            int aleatorio = numeroAleatorio.nextInt(10);
            listaNumeros.add(aleatorio);
        }
        return listaNumeros;
    }
    
    public static void escribirNumerosEnArchivo(String nombreArchivo, List<Integer> listaNumeros) throws IOException{
        FileWriter escritor = new FileWriter(nombreArchivo);
        
        for(int numero : listaNumeros){
            escritor.write(numero + "\n");
        }        
        escritor.close();
    }
    
    public static void leerNumerosEnArchivo(String nombreArchivo)throws IOException{
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        List<String> lista = new ArrayList<>();        
        String linea = lector.readLine();  
        
        while(linea != null){
            lista.add(linea);
            linea = lector.readLine();
        }
        System.out.println(lista);
    }
    
    public static List<Integer> ordenarConSort(String nombreArchivo) throws IOException{
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        List<Integer> listaNumeros = new ArrayList<>();        
        String linea = lector.readLine();
        
        while(linea != null){
            int numero = Integer.parseInt(linea);
            listaNumeros.add(numero);
            linea = lector.readLine();
        }        
        lector.close();        
        Collections.sort(listaNumeros);
        return listaNumeros;
    }
    
    public static List<Integer> ordenarConBubbleSort(String nombreArchivo) throws IOException{
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        List<Integer> listaNumeros = new ArrayList<>();        
        String linea = lector.readLine();
        
        while(linea != null){
            int numero = Integer.parseInt(linea);
            listaNumeros.add(numero);
            linea = lector.readLine();
        }        
        lector.close();
        
        int aux;
        boolean flag = false;
        
        while(!flag){
            flag = true;
            for(int i = 0; i < listaNumeros.size() - 1; i++){
                if(listaNumeros.get(i + 1) < listaNumeros.get(i)){
                    aux = listaNumeros.get(i + 1);
                    listaNumeros.set(i + 1, listaNumeros.get(i));
                    listaNumeros.set(i, aux);
                    flag = false;                
                }
            }
        }
        return listaNumeros;
    }

    public static boolean buscarNumero(int numero, String nombreArchivo) throws IOException {
        List<Integer> numbers = ordenarConSort(nombreArchivo);
        
        return numbers.contains(numero);
    }
    
}
