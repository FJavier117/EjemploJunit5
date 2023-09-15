package org.example;

import java.util.HashSet;
import java.util.Set;

public class EjemploTest {

    public Set<Integer> interseccion(int [] arr1, int [] arr2){
        Set<Integer> interseccion = new HashSet<>();
        for (int i = 0; i < arr1.length ; i++) {
            for (int j = 0; j < arr2.length ; j++) {
                if (arr1[i] == arr2[j]){
                    interseccion.add(arr1[i]);
                    break;
                }
            }
        }
        return interseccion;
    }

    public Integer sumaCadena(Integer [] elementos){
        int resultado=0;
        for (int i = 0; i < elementos.length ; i++) {
            resultado+=elementos[i];
        }
        return resultado;
    }


    public int suma(int a, int b){
        return  a + b;
    }


    public int tamCadena(String cadena){
        return cadena.length();
    }

    public int compararCadena(String cadena1, String cadena2){
        if(cadena1.length() == cadena2.length()){
            return 0;
        } else if (cadena1.length() > cadena2.length()) {
            return  cadena1.length();
        }else {
            return cadena2.length();
        }
    }

    public String procesarCadena(String cadena){
        String cad;
        if (cadena.equals(cadena.toUpperCase())){
            cad = cadena.trim();
        }else {
            cad = cadena.trim().toUpperCase();
        }
        return cad;
    }

    public boolean validarCadena(String cadena){
        return cadena.equals(cadena.toUpperCase());
    }


    public boolean cadenaVacia(String cadena){
        return cadena.trim().isEmpty();
    }

    public boolean evaluarPrimo(int n){
        boolean valor = true;
        int c = 2;
        while(valor && c!= n){
            if (n % c == 0){valor = false;}
            c++;
        }
        return valor;
    }


}
