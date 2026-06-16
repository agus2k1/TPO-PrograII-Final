package Ej9.implementacion;

import imple.Cola;
import imple.Conjunto;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class ConjuntoImpl {
    public ConjuntoTDA devolverConjuntoResultante(PilaTDA pila, ColaTDA cola) {
        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        ConjuntoTDA conjuntoCola = new Conjunto();
        conjuntoCola.inicializarConjunto();
        ConjuntoTDA conjuntoResultado = new Conjunto();
        conjuntoResultado.inicializarConjunto();

        while (!cola.colaVacia()) {
            int primero = cola.primero();

            conjuntoCola.agregar(primero);
            colaAux.acolar(primero);
            cola.desacolar();
        }

        while (!pila.pilaVacia()) {
            int tope = pila.tope();

            if (conjuntoCola.pertenece(tope)) {
                conjuntoResultado.agregar(tope);
            }
            pilaAux.apilar(tope);
            pila.desapilar();
        }

        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjuntoResultado;
    }
}
