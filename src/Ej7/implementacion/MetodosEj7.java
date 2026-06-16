package Ej7.implementacion;

import imple.Conjunto;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;

public class MetodosEj7 {

    public ConjuntoTDA elementosRepetidos(PilaTDA pila) {

        // Guarda los elementos que ya aparecieron
        ConjuntoTDA conjuntoVistos = new Conjunto();
        conjuntoVistos.inicializarConjunto();

        // Guarda los elementos repetidos
        ConjuntoTDA conjuntoResultado = new Conjunto();
        conjuntoResultado.inicializarConjunto();

        // Permite restaurar la pila original
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        // Recorro la pila
        while(!pila.pilaVacia()) {
            int elemento = pila.tope();

            // Guardo el elemento para reconstruir la pila luego
            aux.apilar(elemento);
            pila.desapilar();

            // Si ya aparecio, lo agrego al resultado
            if(conjuntoVistos.pertenece(elemento)) {
                conjuntoResultado.agregar(elemento);
            } else {
                conjuntoVistos.agregar(elemento);
            }
        }

        // Restauro la pila original
        while(!aux.pilaVacia()) {
            int elemento = aux.tope();
            pila.apilar(elemento);
            aux.desapilar();
        }

        return conjuntoResultado;
    }
}