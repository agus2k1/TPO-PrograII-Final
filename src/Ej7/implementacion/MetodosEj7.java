package Ej7.implementacion;

import imple.Conjunto;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class MetodosEj7 {

    public ConjuntoTDA elementosRepetidos(PilaTDA pila) { // P

        ConjuntoTDA conjuntoVistos = new Conjunto(); // C
        conjuntoVistos.inicializarConjunto(); // C

        ConjuntoTDA conjuntoResultado = new Conjunto(); // C
        conjuntoResultado.inicializarConjunto(); // C

        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        while(!pila.pilaVacia()) { // P (pertenece adentro es L)
            int elemento = pila.tope(); // C

            aux.apilar(elemento); // C
            pila.desapilar(); // C

            if(conjuntoVistos.pertenece(elemento)) { // L
                conjuntoResultado.agregar(elemento); // C
            } else {
                conjuntoVistos.agregar(elemento); // C
            }
        }

        while(!aux.pilaVacia()) { // L
            int elemento = aux.tope(); // C
            pila.apilar(elemento); // C
            aux.desapilar(); // C
        }

        return conjuntoResultado; // C
    }
}