package tests.Ej3;

import Ej3.implementacion.Multipila;
import Ej3.interfaz.MultipilaTDA;
import imple.Pila;
import tda.PilaTDA;

public class TestEj3 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static Multipila nuevaMultipila() {
        Multipila m = new Multipila();
        m.inicializarPila();
        return m;
    }

    static PilaTDA pilaDe(int... valores) {
        PilaTDA p = new Pila();
        p.inicializarPila();
        for (int i = valores.length - 1; i >= 0; i--) p.apilar(valores[i]);
        return p;
    }

    public static void main(String[] args) {
        System.out.println("=== Multipila ===\n");

        Multipila m;
        PilaTDA resultado;

        // pilaVacia
        m = nuevaMultipila();
        check("multipila recién inicializada está vacía", m.pilaVacia());

        // apilar y tope
        m = nuevaMultipila();
        m.apilar(pilaDe(7, 2, 8, 9));
        check("después de apilar, no está vacía", !m.pilaVacia());
        resultado = m.tope(2);
        check("tope(2): primer elemento es 7", resultado.tope() == 7);
        resultado.desapilar();
        check("tope(2): segundo elemento es 2", resultado.tope() == 2);

        // tope con cantidad mayor al tamaño devuelve todos
        m = nuevaMultipila();
        m.apilar(pilaDe(1, 2, 3));
        resultado = m.tope(100);
        int count = 0;
        while (!resultado.pilaVacia()) { count++; resultado.desapilar(); }
        check("tope(100) con 3 elementos devuelve 3", count == 3);

        // apilar dos pilas: orden correcto (segunda pila queda encima)
        m = nuevaMultipila();
        m.apilar(pilaDe(9, 8));
        m.apilar(pilaDe(7, 2));
        resultado = m.tope(1);
        check("apilar segunda pila: tope es el primer elemento de la segunda pila (7)", resultado.tope() == 7);

        // desapilar coincidente
        m = nuevaMultipila();
        m.apilar(pilaDe(7, 2, 8, 9));
        m.desapilar(pilaDe(7, 2));
        resultado = m.tope(1);
        check("desapilar coincidente: nuevo tope es 8", resultado.tope() == 8);

        // desapilar no coincidente no modifica la multipila
        m = nuevaMultipila();
        m.apilar(pilaDe(7, 2, 8, 9));
        m.desapilar(pilaDe(7, 99));
        resultado = m.tope(1);
        check("desapilar no coincidente: tope sigue siendo 7", resultado.tope() == 7);

        // desapilar más elementos de los que hay no modifica
        m = nuevaMultipila();
        m.apilar(pilaDe(7, 2));
        m.desapilar(pilaDe(7, 2, 3));
        resultado = m.tope(1);
        check("desapilar pila más grande: no coincide, tope sigue en 7", resultado.tope() == 7);

        System.out.println("\n=== Fin de tests ===");
    }
}
