package Ej13.uso;

import imple.ABB;
import tda.ABBTDA;
import Ej13.implementacion.MetodosEj13;

public class MainEjercicio13 {

    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.inicializarArbol();

        arbol.agregar(4);
        arbol.agregar(2);
        arbol.agregar(6);
        arbol.agregar(1);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(7);

        int cantidad = MetodosEj13.contarHojasPares(arbol);
        System.out.println("Hojas con valor par: " + cantidad);
    }
}