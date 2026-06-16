package Ej12.implementacion;

import tda.ABBTDA;

public class MetodosEj12 {

    public int sumaImpar(ABBTDA a) {

        //En caso de que arbol este vacio
        if(a.arbolVacio()) {
            return 0;
        }

        int suma = 0;

        // Si la raíz es impar la sumo
        if (a.raiz() % 2 != 0) {
            suma = a.raiz();
        }

        // Sumo los impares de ambos subárboles
        suma += sumaImpar(a.hijoIzq());
        suma += sumaImpar(a.hijoDer());

        return suma;
    }
}