package tests.Ej13;

import Ej13.implementacion.MetodosEj13;
import imple.ABB;
import tda.ABBTDA;

public class TestEj13 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static ABBTDA arbolVacio() {
        ABBTDA a = new ABB();
        a.inicializarArbol();
        return a;
    }

    public static void main(String[] args) {
        System.out.println("=== contarHojasPares ===\n");

        ABBTDA arbol;

        // árbol vacío
        arbol = arbolVacio();
        check("árbol vacío: 0 hojas pares", MetodosEj13.contarHojasPares(arbol) == 0);

        // un solo nodo par (es hoja)
        arbol = arbolVacio();
        arbol.agregarElem(4);
        check("un nodo par y hoja (4): 1 hoja par", MetodosEj13.contarHojasPares(arbol) == 1);

        // un solo nodo impar (es hoja)
        arbol = arbolVacio();
        arbol.agregarElem(3);
        check("un nodo impar y hoja (3): 0 hojas pares", MetodosEj13.contarHojasPares(arbol) == 0);

        // árbol con hojas pares e impares
        // árbol [4,2,6,1,3,5,7]: hojas son 1,3,5,7 (todos impares) → 0
        arbol = arbolVacio();
        arbol.agregarElem(4); arbol.agregarElem(2); arbol.agregarElem(6);
        arbol.agregarElem(1); arbol.agregarElem(3); arbol.agregarElem(5); arbol.agregarElem(7);
        check("hojas [1,3,5,7] todas impares: 0 hojas pares", MetodosEj13.contarHojasPares(arbol) == 0);

        // árbol [5,2,8]: hojas son 2 (par) y 8 (par) → 2
        arbol = arbolVacio();
        arbol.agregarElem(5); arbol.agregarElem(2); arbol.agregarElem(8);
        check("hojas [2,8] ambas pares: 2 hojas pares", MetodosEj13.contarHojasPares(arbol) == 2);

        // árbol [5,3,8]: hojas son 3 (impar) y 8 (par) → 1
        arbol = arbolVacio();
        arbol.agregarElem(5); arbol.agregarElem(3); arbol.agregarElem(8);
        check("hojas [3,8] una par: 1 hoja par", MetodosEj13.contarHojasPares(arbol) == 1);

        // nodo raíz par pero no es hoja: no se cuenta
        arbol = arbolVacio();
        arbol.agregarElem(4); arbol.agregarElem(3); arbol.agregarElem(5);
        check("raíz par (4) pero no es hoja: 0 hojas pares", MetodosEj13.contarHojasPares(arbol) == 0);

        System.out.println("\n=== Fin de tests ===");
    }
}
