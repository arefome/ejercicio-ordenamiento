/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burbuja;
import java.util.Scanner;

/**
 *
 * @author forer
 */
public class Ordenamiento{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            int tam = s.nextInt();
            if (tam == 0) break;
            int[] numeros = new int[tam];
            for (int i=0;i<tam;i++)
                    numeros[i] = s.nextInt();
            int intercambios = quickSort(numeros, 0, tam - 1);
            //int intercambios = ordenarBurbuja(numeros);
            if (intercambios % 2 != 0)
                System.out.println("Marcelo");
            else
                System.out.println("Carlos");
        }
    }
    
  
    static int ordenarBurbuja(int arr[]){
        int n=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1; j++){
                if(arr[j]>arr[j+1]){
                    int aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                    n++;
                }
            }
        }
        imprimir(arr);
        return n;
    }
    
  
    static void imprimir(int arr[]){
        System.out.print("[");
        for(int i=0; i < arr.length-1; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]+"]");
    }
    
    static int quickSort(int arr[],int inicio, int tam){
        int intercambios = 0;  
        int mid = (inicio + tam) / 2;
        int pivote = arr[mid];
        int i = inicio;
        int j = tam;
        do{
            while(arr[i] < pivote) i++;
            while(arr[j] > pivote) j--;
            if(i <= j){
                if (i < j) intercambios++;
                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux; 
                i++;
                j--;
            }
        }while(i<=j);
        if(inicio<j){
            intercambios += quickSort(arr, inicio, j);
        }
        if(i<tam){
            intercambios += quickSort(arr, i, tam);
        }
        return intercambios;
    }
}
