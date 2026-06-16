package Ej9.uso;

import Ej9.implementacion.ConjuntoImpl;
import imple.Cola;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class Main {
    static void check(String descripcion, boolean condicion) {
        System.out.println((condicion ? "[PASS]" : "[FAIL]") + " " + descripcion);
    }

    static PilaTDA pilaConElementos(int... elementos) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        for (int e : elementos) pila.apilar(e);
        return pila;
    }

    static ColaTDA colaConElementos(int... elementos) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        for (int e : elementos) cola.acolar(e);
        return cola;
    }

    public static void main(String[] args) {
        System.out.println("=== devolverConjuntoResultante ===\n");

        ConjuntoImpl impl = new ConjuntoImpl();
        PilaTDA pila;
        ColaTDA cola;
        ConjuntoTDA resultado;

        // sin elementos en común → resultado vacío
        pila = pilaConElementos(1, 2, 3);
        cola = colaConElementos(4, 5, 6);
        resultado = (ConjuntoTDA) impl.devolverConjuntoResultante(pila, cola);
        check("sin intersección → resultado vacío", resultado.conjuntoVacio());

        // un elemento en común → pertenece al resultado
        pila = pilaConElementos(1, 2, 3);
        cola = colaConElementos(3, 7, 8);
        resultado = (ConjuntoTDA) impl.devolverConjuntoResultante(pila, cola);
        check("un elemento en común → pertenece(3)", resultado.pertenece(3));
        check("un elemento en común → no pertenece(1)", !resultado.pertenece(1));
        check("un elemento en común → no pertenece(7)", !resultado.pertenece(7));

        // todos en común → todos pertenecen al resultado
        pila = pilaConElementos(1, 2, 3);
        cola = colaConElementos(1, 2, 3);
        resultado = (ConjuntoTDA) impl.devolverConjuntoResultante(pila, cola);
        check("todos en común → pertenece(1)", resultado.pertenece(1));
        check("todos en común → pertenece(2)", resultado.pertenece(2));
        check("todos en común → pertenece(3)", resultado.pertenece(3));

        // duplicados en pila → el elemento aparece una sola vez en el resultado (es conjunto)
        pila = pilaConElementos(2, 2, 2);
        cola = colaConElementos(2, 5);
        resultado = (ConjuntoTDA) impl.devolverConjuntoResultante(pila, cola);
        check("duplicados en pila → pertenece(2)", resultado.pertenece(2));
        resultado.sacar(2);
        check("duplicados en pila → no hay segundo 2 (es conjunto)", resultado.conjuntoVacio());

        // pila intacta post-llamada
        pila = pilaConElementos(1, 2, 3);
        cola = colaConElementos(2, 3);
        int topeAntes = pila.tope();
        impl.devolverConjuntoResultante(pila, cola);
        check("pila intacta post-llamada: tope sigue siendo " + topeAntes, pila.tope() == topeAntes);

        // cola intacta post-llamada
        pila = pilaConElementos(1, 2, 3);
        cola = colaConElementos(2, 3);
        int primeroAntes = cola.primero();
        impl.devolverConjuntoResultante(pila, cola);
        check("cola intacta post-llamada: primero sigue siendo " + primeroAntes, cola.primero() == primeroAntes);

        System.out.println("\n=== Fin de tests ===");
    }
}