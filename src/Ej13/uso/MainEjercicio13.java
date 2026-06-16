package Ej13.uso;

import imple.ABB;
import tda.ABBTDA;
import Ej13.implementacion.MetodosEj13;

public class MainEjercicio13 {

    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.inicializarArbol();

        arbol.agregarElem(4);
        arbol.agregarElem(2);
        arbol.agregarElem(6);
        arbol.agregarElem(1);
        arbol.agregarElem(3);
        arbol.agregarElem(5);
        arbol.agregarElem(7);

        int cantidad = MetodosEj13.contarHojasPares(arbol);
        System.out.println("Hojas con valor par: " + cantidad);
    }
}