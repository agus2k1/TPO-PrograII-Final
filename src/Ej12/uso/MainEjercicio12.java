package Ej12.uso;

import imple.ABB;
import tda.ABBTDA;
import Ej12.implementacion.MetodosEj12;

public class MainEjercicio12 {

    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.inicializarArbol();

        arbol.agregarElem(5);
        arbol.agregarElem(3);
        arbol.agregarElem(7);
        arbol.agregarElem(2);
        arbol.agregarElem(4);

        MetodosEj12 metodos = new MetodosEj12();
        int suma = metodos.sumaImpar(arbol);

        System.out.println("Suma de nodos impares: " + suma);
    }
}