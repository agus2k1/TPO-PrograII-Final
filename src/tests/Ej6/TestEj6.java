package tests.Ej6;

import Ej6.implementacion.MetodosEj6;
import imple.Pila;
import tda.PilaTDA;

public class TestEj6 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static PilaTDA pilaDe(int... valores) {
        PilaTDA p = new Pila();
        p.inicializarPila();
        for (int i = valores.length - 1; i >= 0; i--) p.apilar(valores[i]);
        return p;
    }

    public static void main(String[] args) {
        System.out.println("=== pares ===\n");

        MetodosEj6 m = new MetodosEj6();
        PilaTDA pila;

        // todos pares → 100%
        pila = pilaDe(2, 4, 6);
        check("todos pares [2,4,6]: 100%", m.pares(pila) == 100.0f);

        // mitad pares → 50%
        pila = pilaDe(1, 2, 3, 4);
        check("mitad pares [1,2,3,4]: 50%", m.pares(pila) == 50.0f);

        // ningún par → 0%
        pila = pilaDe(1, 3, 5);
        check("ningún par [1,3,5]: 0%", m.pares(pila) == 0.0f);

        // un solo par de tres → 33.33%
        pila = pilaDe(1, 2, 3);
        check("un par de tres [1,2,3]: 33.33%", m.pares(pila) == (1.0f / 3) * 100);

        // pila no se destruye
        pila = pilaDe(1, 2, 3, 4);
        m.pares(pila);
        int count = 0;
        while (!pila.pilaVacia()) { count++; pila.desapilar(); }
        check("pila original intacta (4 elementos)", count == 4);

        System.out.println("\n=== Fin de tests ===");
    }
}
