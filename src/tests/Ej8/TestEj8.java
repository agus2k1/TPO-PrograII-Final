package tests.Ej8;

import Ej8.implementacion.MetodosEj8;
import imple.Cola;
import tda.ColaTDA;

public class TestEj8 {

    static void check(String desc, boolean cond) {
        System.out.println((cond ? "[PASS]" : "[FAIL]") + " " + desc);
    }

    static ColaTDA colaDe(int... valores) {
        ColaTDA c = new Cola();
        c.inicializarCola();
        for (int v : valores) c.acolar(v);
        return c;
    }

    static int tamanio(ColaTDA c) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        int count = 0;
        while (!c.colaVacia()) {
            int v = c.primero();
            c.desacolar();
            aux.acolar(v);
            count++;
        }
        while (!aux.colaVacia()) { c.acolar(aux.primero()); aux.desacolar(); }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== sinRepetidos ===\n");

        MetodosEj8 m = new MetodosEj8();
        ColaTDA cola, resultado;

        // cola con un repetido
        cola = colaDe(1, 2, 1, 3);
        resultado = m.sinRepetidos(cola);
        check("un repetido: tamaño resultado=3", tamanio(resultado) == 3);
        check("un repetido: primer elemento es 1", resultado.primero() == 1);

        // cola sin repetidos: devuelve todos los elementos
        cola = colaDe(1, 2, 3);
        resultado = m.sinRepetidos(cola);
        check("sin repetidos: tamaño resultado=3", tamanio(resultado) == 3);

        // cola con todos iguales: resultado con un solo elemento
        cola = colaDe(5, 5, 5);
        resultado = m.sinRepetidos(cola);
        check("todos iguales: tamaño resultado=1", tamanio(resultado) == 1);
        check("todos iguales: el elemento es 5", resultado.primero() == 5);

        // cola vacía
        cola = colaDe();
        resultado = m.sinRepetidos(cola);
        check("cola vacía: resultado vacío", resultado.colaVacia());

        // cola original no se destruye
        cola = colaDe(1, 2, 1);
        m.sinRepetidos(cola);
        check("cola original intacta (3 elementos)", tamanio(cola) == 3);

        System.out.println("\n=== Fin de tests ===");
    }
}
