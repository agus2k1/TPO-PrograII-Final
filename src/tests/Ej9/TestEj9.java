package tests.Ej9;

import Ej9.implementacion.ConjuntoImpl;
import imple.Cola;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class TestEj9 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static PilaTDA pilaDe(int... valores) {
        PilaTDA p = new Pila();
        p.inicializarPila();
        for (int i = valores.length - 1; i >= 0; i--) p.apilar(valores[i]);
        return p;
    }

    static ColaTDA colaDe(int... valores) {
        ColaTDA c = new Cola();
        c.inicializarCola();
        for (int v : valores) c.acolar(v);
        return c;
    }

    public static void main(String[] args) {
        System.out.println("=== devolverConjuntoResultante ===\n");

        ConjuntoImpl impl = new ConjuntoImpl();
        PilaTDA pila;
        ColaTDA cola;
        ConjuntoTDA resultado;

        // intersección básica
        pila = pilaDe(1, 2, 3, 4);
        cola = colaDe(2, 4, 6);
        resultado = impl.devolverConjuntoResultante(pila, cola);
        check("intersección: contiene 2 (en ambas)", resultado.pertenece(2));
        check("intersección: contiene 4 (en ambas)", resultado.pertenece(4));
        check("intersección: no contiene 1 (solo en pila)", !resultado.pertenece(1));
        check("intersección: no contiene 3 (solo en pila)", !resultado.pertenece(3));
        check("intersección: no contiene 6 (solo en cola)", !resultado.pertenece(6));

        // sin elementos en común
        pila = pilaDe(1, 3, 5);
        cola = colaDe(2, 4, 6);
        resultado = impl.devolverConjuntoResultante(pila, cola);
        check("sin intersección: resultado vacío", resultado.conjuntoVacio());

        // pila vacía
        pila = pilaDe();
        cola = colaDe(1, 2, 3);
        resultado = impl.devolverConjuntoResultante(pila, cola);
        check("pila vacía: resultado vacío", resultado.conjuntoVacio());

        // cola vacía
        pila = pilaDe(1, 2, 3);
        cola = colaDe();
        resultado = impl.devolverConjuntoResultante(pila, cola);
        check("cola vacía: resultado vacío", resultado.conjuntoVacio());

        // pila y cola originales no se destruyen
        pila = pilaDe(1, 2, 3);
        cola = colaDe(2, 3, 4);
        impl.devolverConjuntoResultante(pila, cola);
        int countPila = 0, countCola = 0;
        while (!pila.pilaVacia()) { countPila++; pila.desapilar(); }
        while (!cola.colaVacia()) { countCola++; cola.desacolar(); }
        check("pila original intacta (3 elementos)", countPila == 3);
        check("cola original intacta (3 elementos)", countCola == 3);

        System.out.println("\n=== Fin de tests ===");
    }
}
