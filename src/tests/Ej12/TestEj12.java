package tests.Ej12;

import Ej12.implementacion.MetodosEj12;
import imple.ABB;
import tda.ABBTDA;

public class TestEj12 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static ABBTDA arbolVacio() {
        ABBTDA a = new ABB();
        a.inicializarArbol();
        return a;
    }

    public static void main(String[] args) {
        System.out.println("=== sumaImpar ===\n");

        MetodosEj12 m = new MetodosEj12();
        ABBTDA arbol;

        // árbol vacío
        arbol = arbolVacio();
        check("árbol vacío: suma=0", m.sumaImpar(arbol) == 0);

        // un solo nodo impar
        arbol = arbolVacio();
        arbol.agregar(7);
        check("un nodo impar (7): suma=7", m.sumaImpar(arbol) == 7);

        // un solo nodo par
        arbol = arbolVacio();
        arbol.agregar(4);
        check("un nodo par (4): suma=0", m.sumaImpar(arbol) == 0);

        // múltiples nodos: suma solo los impares
        arbol = arbolVacio();
        arbol.agregar(5); arbol.agregar(3); arbol.agregar(7);
        arbol.agregar(2); arbol.agregar(4);
        // impares: 5, 3, 7 → suma = 15
        check("árbol con [5,3,7,2,4]: suma impares=15", m.sumaImpar(arbol) == 15);

        // todos los nodos pares
        arbol = arbolVacio();
        arbol.agregar(2); arbol.agregar(4); arbol.agregar(6);
        check("todos pares [2,4,6]: suma=0", m.sumaImpar(arbol) == 0);

        // todos los nodos impares
        arbol = arbolVacio();
        arbol.agregar(1); arbol.agregar(3); arbol.agregar(5);
        check("todos impares [1,3,5]: suma=9", m.sumaImpar(arbol) == 9);

        System.out.println("\n=== Fin de tests ===");
    }
}
