package tests.Ej10;

import Ej10.implementacion.MetodosEj10;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

public class TestEj10 {

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
        System.out.println("=== frecuenciasPila ===\n");

        MetodosEj10 m = new MetodosEj10();
        PilaTDA pila;
        DiccionarioSimpleTDA freq;

        // frecuencia de un elemento que aparece tres veces
        pila = pilaDe(5, 2, 5, 8, 2, 5);
        freq = m.frecuenciasPila(pila);
        check("5 aparece 3 veces", freq.recuperar(5) == 3);
        check("2 aparece 2 veces", freq.recuperar(2) == 2);
        check("8 aparece 1 vez", freq.recuperar(8) == 1);

        // todos los elementos sin repetir: frecuencia 1
        pila = pilaDe(1, 2, 3);
        freq = m.frecuenciasPila(pila);
        check("sin repetidos: freq(1)=1", freq.recuperar(1) == 1);
        check("sin repetidos: freq(2)=1", freq.recuperar(2) == 1);
        check("sin repetidos: freq(3)=1", freq.recuperar(3) == 1);

        // todas las claves presentes
        pila = pilaDe(10, 20, 10);
        freq = m.frecuenciasPila(pila);
        ConjuntoTDA claves = freq.claves();
        check("claves contiene 10", claves.pertenece(10));
        check("claves contiene 20", claves.pertenece(20));

        // pila original no se destruye
        pila = pilaDe(1, 2, 3, 1);
        m.frecuenciasPila(pila);
        int count = 0;
        while (!pila.pilaVacia()) { count++; pila.desapilar(); }
        check("pila original intacta (4 elementos)", count == 4);

        System.out.println("\n=== Fin de tests ===");
    }
}
