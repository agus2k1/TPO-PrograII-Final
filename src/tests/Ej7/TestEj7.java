package tests.Ej7;

import Ej7.implementacion.MetodosEj7;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class TestEj7 {

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
        System.out.println("=== elementosRepetidos ===\n");

        MetodosEj7 m = new MetodosEj7();
        PilaTDA pila;
        ConjuntoTDA resultado;

        // pila con un elemento repetido
        pila = pilaDe(1, 2, 1, 3);
        resultado = m.elementosRepetidos(pila);
        check("un repetido: resultado contiene 1", resultado.pertenece(1));
        check("un repetido: resultado no contiene 2 (no se repite)", !resultado.pertenece(2));
        check("un repetido: resultado no contiene 3 (no se repite)", !resultado.pertenece(3));

        // pila con múltiples repetidos
        pila = pilaDe(1, 2, 1, 3, 2, 4);
        resultado = m.elementosRepetidos(pila);
        check("múltiples repetidos: contiene 1", resultado.pertenece(1));
        check("múltiples repetidos: contiene 2", resultado.pertenece(2));
        check("múltiples repetidos: no contiene 3", !resultado.pertenece(3));
        check("múltiples repetidos: no contiene 4", !resultado.pertenece(4));

        // pila sin repetidos
        pila = pilaDe(1, 2, 3, 4);
        resultado = m.elementosRepetidos(pila);
        check("sin repetidos: resultado vacío", resultado.conjuntoVacio());

        // pila vacía
        pila = pilaDe();
        resultado = m.elementosRepetidos(pila);
        check("pila vacía: resultado vacío", resultado.conjuntoVacio());

        // pila original no se destruye
        pila = pilaDe(1, 2, 1);
        m.elementosRepetidos(pila);
        int count = 0;
        while (!pila.pilaVacia()) { count++; pila.desapilar(); }
        check("pila original intacta (3 elementos)", count == 3);

        System.out.println("\n=== Fin de tests ===");
    }
}
