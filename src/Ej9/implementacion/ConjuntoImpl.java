package Ej9.implementacion;

import imple.Cola;
import imple.Conjunto;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class ConjuntoImpl {
    public ConjuntoTDA devolverConjuntoResultante(PilaTDA pila, ColaTDA cola) { // P
        ColaTDA colaAux = new Cola(); // C
        colaAux.inicializarCola(); // C
        PilaTDA pilaAux = new Pila(); // C
        pilaAux.inicializarPila(); // C
        ConjuntoTDA conjuntoCola = new Conjunto(); // C
        conjuntoCola.inicializarConjunto(); // C
        ConjuntoTDA conjuntoResultado = new Conjunto(); // C
        conjuntoResultado.inicializarConjunto(); // C

        while (!cola.colaVacia()) { // L
            int primero = cola.primero(); // C

            conjuntoCola.agregar(primero); // C
            colaAux.acolar(primero); // C
            cola.desacolar(); // C
        }

        while (!pila.pilaVacia()) { // P (pertenece adentro es L)
            int tope = pila.tope(); // C

            if (conjuntoCola.pertenece(tope)) { // L
                conjuntoResultado.agregar(tope); // C
            }
            pilaAux.apilar(tope); // C
            pila.desapilar(); // C
        }

        while (!colaAux.colaVacia()) { // L
            cola.acolar(colaAux.primero()); // C
            colaAux.desacolar(); // C
        }

        while (!pilaAux.pilaVacia()) { // L
            pila.apilar(pilaAux.tope()); // C
            pilaAux.desapilar(); // C
        }

        return conjuntoResultado; // C
    }
}
